package jlu;

import java.io.File;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class VoidVisitorStarter {
	private static final String FILE_PATH = "src/main/java/jlu/parsedExamplre.java";
			
			public static void main(String[] args) throws Exception {
			
			CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));
			
			}
			

}
