package jlu;

import java.io.File;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class VoidVisitorComplete {
	
	

	private static final String FILE_PATH = "src/main/java/jlu/parsedExamplre.java";
			
			public static void main(String[] args) throws Exception {
			
			CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));
			VoidVisitor<?> methodNameVisitor = new MethodNamePrinter();
			methodNameVisitor.visit(cu, null);
			}
			


	

	private static class MethodNamePrinter extends VoidVisitorAdapter<Void> {
		
		@Override
		 public void visit(MethodDeclaration md, Void arg) {
		 super.visit(md, arg);
		 System.out.println("Method Name Printed: " + md.getName());
		 }
		 }
	
}
