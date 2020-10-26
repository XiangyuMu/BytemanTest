package PaeserPackage;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.DotPrinter;
import com.github.javaparser.printer.PrettyPrinter;
import com.github.javaparser.printer.XmlPrinter;

import java.io.File;
import java.io.FileNotFoundException;

public class ASTforXML {


    public static void main(String[] args) throws FileNotFoundException {
        XmlPrinter xp = new XmlPrinter(true);
        PrettyPrinter pp = new PrettyPrinter();
        DotPrinter dp = new DotPrinter(true);
        CompilationUnit cu = StaticJavaParser.parse(new File("src/main/java/TargetClass/Example01.java"));
        String parentNodeName = "";
        String name = "";
        StringBuilder builder = new StringBuilder();
        String s = xp.output(cu);
        String s1 = pp.print(cu);
        String s2 = dp.output(cu);
        dp.output(cu,parentNodeName,name,builder);
        System.out.println("XmlPrinter: "+s);
        System.out.println("PrettyPrinter: "+s1);
        System.out.println("DotPrinter: "+s2);
        System.out.println("parentNodeName: "+parentNodeName);
        System.out.println("name: "+name);
        System.out.println("builder: "+builder);
    }
}
