import com.ibm.wala.classLoader.IClass;
import com.ibm.wala.classLoader.IMethod;
import com.ibm.wala.ipa.callgraph.AnalysisScope;
import com.ibm.wala.ipa.cha.ClassHierarchyException;
import com.ibm.wala.ipa.cha.ClassHierarchyFactory;
import com.ibm.wala.ipa.cha.IClassHierarchy;
import com.ibm.wala.util.config.AnalysisScopeReader;

import java.io.*;

public class CountParameters {

    private static final ClassLoader MY_CLASSLOADER = CountParameters.class.getClassLoader();

    /** Use the 'CountParameters' launcher to run this program with the appropriate classpath */
    public static void main(String[] args) throws IOException, ClassHierarchyException {


        BufferedReader r = null;
        String line;
        File scopeFile = new File("primordial.txt");
        if (scopeFile.exists()) {
            r = new BufferedReader(new FileReader("E:\\eclipse-workspace\\jlu\\src\\main\\java\\jlu\\example.java"));
            System.out.println("r exit!");
        }else{
            System.out.println("not exit!");
        }
        while ((line = r.readLine()) != null) {
            System.out.println("r = "+line);
        }


        r.close();
        // build an analysis scope representing the standard libraries, excluding no classes
        AnalysisScope scope = AnalysisScopeReader.readJavaScope("primordial.txt", null, MY_CLASSLOADER);

        // build a class hierarchy
        System.err.print("Build class hierarchy...");
        IClassHierarchy cha = ClassHierarchyFactory.make(scope);
        System.err.println("Done");

        int nClasses = 0;
        int nMethods = 0;
        int nParameters = 0;

        for (IClass c : cha) {
            nClasses++;
            for (IMethod m : c.getDeclaredMethods()) {
                nMethods++;
                nParameters += m.getNumberOfParameters();
            }
        }

        System.out.println(nClasses + " classes");
        System.out.println(nMethods + " methods");
        System.out.println((float) nParameters / (float) nMethods + " parameters per method");
    }
}
