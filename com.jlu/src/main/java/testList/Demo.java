package testList;

import java.io.File;
import java.io.IOException;

import com.jlu.redcueExample.ElemwntList;

public class Demo {
	public static void main(String[] args) throws IOException {
		TestInput ti = new TestInput();
		ti.setPath("case");
		ElemwntList el = ti.createTestCase(1, "String", "String");
		//System.out.println(el.toString());
		createNewCase cnc = new createNewCase();
		cnc.setElementList(el);
		cnc.createAllCases();
		for(int k = 0;k<cnc.getElementListList().size();k++) {
			System.out.println(cnc.getElementListList().get(k).toString());
		}
		System.out.println("¸öÊýÎª£º"+cnc.getElementListList().size());
		 createDir cd = new createDir();
		 cd.createFileDir(new File("case1.txt"));
		 cd.createRelatedFile(cnc.getElementListList());
	}

}
