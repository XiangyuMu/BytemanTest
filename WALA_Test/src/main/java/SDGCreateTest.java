import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

import com.ibm.wala.classLoader.JavaLanguage;
import com.ibm.wala.classLoader.Language;
import com.ibm.wala.ipa.callgraph.*;
import com.ibm.wala.ipa.callgraph.AnalysisOptions.ReflectionOptions;
import com.ibm.wala.ipa.callgraph.impl.Util;
import com.ibm.wala.ipa.callgraph.propagation.InstanceKey;
import com.ibm.wala.ipa.callgraph.propagation.PointerAnalysis;
import com.ibm.wala.ipa.cha.ClassHierarchy;
import com.ibm.wala.ipa.cha.ClassHierarchyException;
import com.ibm.wala.ipa.cha.ClassHierarchyFactory;
import com.ibm.wala.ipa.modref.ModRef;
import com.ibm.wala.ipa.slicer.*;
import com.ibm.wala.ipa.slicer.Slicer.ControlDependenceOptions;
import com.ibm.wala.ipa.slicer.Slicer.DataDependenceOptions;
import com.ibm.wala.ipa.slicer.thin.ThinSlicer;
import com.ibm.wala.shrikeCT.InvalidClassFileException;
import com.ibm.wala.ssa.IR;
import com.ibm.wala.ssa.SSAInstruction;
import com.ibm.wala.ssa.SSAInvokeInstruction;
import com.ibm.wala.util.CancelException;
import com.ibm.wala.util.WalaException;
import com.ibm.wala.util.config.AnalysisScopeReader;
import com.ibm.wala.util.debug.Assertions;
import com.ibm.wala.util.graph.Graph;
import com.ibm.wala.util.graph.GraphIntegrity;
import com.ibm.wala.util.graph.GraphSlicer;
import com.ibm.wala.util.intset.IntSet;
import com.ibm.wala.util.io.FileProvider;
import com.ibm.wala.util.strings.Atom;

public class SDGCreateTest {

	private static File exFile;
	private static ModRef<InstanceKey> modRef = ModRef.make();

	public static void doSlicing(String exclusionFile,String classPath,String MethodName,String ClassName) throws WalaException, IOException, CancelException {
		exFile = new FileProvider().getFile(exclusionFile);
		AnalysisScope scope = AnalysisScopeReader.makeJavaBinaryAnalysisScope(classPath, exFile);

		ClassHierarchy cha = ClassHierarchyFactory.make(scope);



		Iterable<Entrypoint> entrypoints =Util.makeMainEntrypoints(scope, cha);
		AnalysisOptions options = new AnalysisOptions(scope, entrypoints);
		options.setReflectionOptions(ReflectionOptions.NONE);

		CallGraphBuilder<InstanceKey> builder = Util.makeVanillaZeroOneCFABuilder(Language.JAVA, options, new AnalysisCacheImpl(), cha, scope);

		CallGraph cg = builder.makeCallGraph(options, null);
		final PointerAnalysis<InstanceKey> pa = builder.getPointerAnalysis();
		SDG<?> sdg = new SDG<>(cg, pa, modRef, DataDependenceOptions.REFLECTION, ControlDependenceOptions.NO_EXCEPTIONAL_EDGES, null);

		System.out.println("SDG:");


		Graph<Statement> g = pruneSDG(sdg);

//		System.err.println(sdg);
		Collection<Statement> collection = null;

		for (Iterator<Statement> it = sdg.iterator(); it.hasNext(); ) {
			Statement s = it.next();
			if(s.getNode().getMethod().getName().toString().equals("main")){
				System.out.println("TRUE!");
				System.out.println(s.getNode().getMethod().getDeclaringClass().getName());
			}

			//System.out.println("s: "+s.getNode().getMethod().getName().toString());

		}
		CGNode n = findMethod(cg, MethodName, ClassName);
		Statement statement = findCallTo(n, "printTest1");
		System.err.println("Statement: " + statement);


		Collection<Statement> slice = null;
		final PointerAnalysis<InstanceKey> pointerAnalysis = builder.getPointerAnalysis();
		slice = Slicer.computeBackwardSlice(statement, cg, pointerAnalysis, DataDependenceOptions.REFLECTION, ControlDependenceOptions.NO_EXCEPTIONAL_EDGES);
//		ThinSlicer ts = new ThinSlicer(cg,pa);
//		collection = ts.computeBackwardThinSlice(statement);
		dumpSlice(slice);
	}








	 public static CGNode findMethod(CallGraph cg1, String Name, String methodCLass) {
    	 if(Name.equals(null) && methodCLass.equals(null))
             return null;
    	 //Atom name = Atom.findOrCreateUnicodeAtom(Name);
    	 for (Iterator<? extends CGNode> it = cg1.iterator(); it.hasNext();) {
             CGNode n = it.next();
//             System.out.println(n.getMethod().toString());
   //           
             if (n.getMethod().getName().toString().equals(Name)&&n.getMethod().getDeclaringClass().getName().toString().equals(methodCLass)) {
            	 return n;
            		  }
             
    	 }
    	 Assertions.UNREACHABLE("Failed to find method " + Name);
         return null;
     }

	private static Graph<Statement> pruneSDG(final SDG<?> sdg) {
		Predicate<Statement> f =
				s -> {
					if (s.getNode().equals(sdg.getCallGraph().getFakeRootNode())) {
						return false;
					} else if (s instanceof MethodExitStatement || s instanceof MethodEntryStatement) {
						return false;
					} else {
						return true;
					}
				};
		return GraphSlicer.prune(sdg, f);
	}

	public static Statement findCallTo(CGNode n, String methodName) {
		 IR ir = n.getIR();
		 for (Iterator<SSAInstruction> it = ir.iterateAllInstructions(); it.hasNext();) {
			 SSAInstruction s = it.next();
			 if (s instanceof SSAInvokeInstruction) {
				 SSAInvokeInstruction call = (SSAInvokeInstruction) s;
				 if (call.getCallSite().getDeclaredTarget().getName().toString().equals(methodName)) {
					IntSet indices = ir.getCallInstructionIndices(call.getCallSite());
					Assertions.productionAssertion(indices.size() == 1, "expected 1 but got " + indices.size());
					return new NormalStatement(n, indices.intIterator().next());
				 }
			 }
		 }
		 Assertions.UNREACHABLE("Failed to find call to " + methodName + " in " + n);
		 return null;
	}

	public static void dumpSlice(Collection<Statement> slice) {
		for (Statement s : slice) {
			System.out.println(s);
		}
	}
	
	public static void main(String args[]) throws IOException, WalaException, IllegalArgumentException, CancelException {

		SDGCreateTest sdgct = new SDGCreateTest();
    sdgct.doSlicing(
        "Java60RegressionExclusions.txt", "E:\\eclipse-workspace\\TestWALA", "main", "Lsource/Demo");
	}
	        
}
