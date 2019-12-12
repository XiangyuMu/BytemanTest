package jlu;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.BinaryExpr.Operator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class TestChecking {

	private static final String FILE_PATH = "src/main/java/jlu/test.java";
	public static void main(String[] args) throws FileNotFoundException {
		CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));
		VoidVisitor<?> methodNameVisitor = new ForPrinter();
		methodNameVisitor.visit(cu, null);
		FieldAccessExpr fa = new FieldAccessExpr();
		
		BlockStmt bl = cu.getClassByName("test").get().getMethods().get(0).getBody().get();
		Expression es = new FieldAccessExpr(new NameExpr("System"), "out");
		StringLiteralExpr sle = new StringLiteralExpr("the x is ");
		NameExpr ne = new NameExpr("i");
		NameExpr ne1 = new NameExpr("println");
		BinaryExpr be = new BinaryExpr(sle, ne,Operator.PLUS);
		MethodCallExpr mce = new MethodCallExpr(es,"println");
		mce.addArgument(be);
		bl.addStatement(mce);
		System.out.println(bl);
		
	}
	
	private static class ForPrinter extends VoidVisitorAdapter<Void>{
		public void visit(BlockStmt fs,Void arg) {
			super.visit(fs, arg);
			System.out.println(fs.getStatements().get(2).asExpressionStmt().getExpression().asMethodCallExpr().getScope());
		}
		
		public void printstmt(CompilationUnit cu) {
			BlockStmt bl = cu.getClassByName("main").get().getMethods().get(0).getBody().get();
			System.out.println(bl);
		}
	}
	
	
}
