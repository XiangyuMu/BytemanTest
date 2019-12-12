package Jlu.BytemanTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
//	public static void main(String[] args) throws IOException {
//		TestInput ti = new TestInput();
//		ti.setPath("case");
//		ElemwntList el = ti.createTestCase_Single(3, "String", "String");
//		//System.out.println(el.toString());
//		createNewCase cnc = new createNewCase();
//		cnc.setElementList(el);
//		cnc.createAllCases();
//		for(int k = 0;k<cnc.getElementListList().size();k++) {
//			System.out.println(cnc.getElementListList().get(k).toString());
//		}
//		System.out.println("个数为："+cnc.getElementListList().size());
//		 createDir cd = new createDir();
//		 cd.createFileDir(new File("case2.txt"));
//		 cd.createRelatedFile(cnc.getElementListList());
//	}
//	
	
//	public static List<ElemwntList> list1= new ArrayList<ElemwntList>();
//	public List<ElemwntList> list2 = new  ArrayList<ElemwntList>();
//	public static List<TwoTuple> tt1 ;
//	public static List<TwoTuple> tt2 ;
//	
//	public boolean isEqual(List<TwoTuple> tt1,List<TwoTuple> tt2) {
//
//		boolean flag = true;
//		if(tt1.size() != tt2.size()) {
//			System.out.println("the number of output is different!");
//			flag = false;
//			return flag;
//		}else {
//			for(int i = 0;i<tt1.size();i++) {
//				if(!tt2.get(i).equal(tt1.get(i))) {
//					flag = false;
//					System.out.println("different result");
//					return flag;
//				}
//			}
//			return flag;
//		}
//	
//	}
//	
//	public static void main(String[] args) throws IOException, InterruptedException {
//		TestInput ti = new TestInput();
//		list1 = ti.createTestCase_multi("case35mix.txt", "String", "String");
//		Example35 e5 ;
//		
//		e5 = new Example35();
//		
//		e5.reduce(list1.get(0));
//		tt1 = e5.getOutput();
//		System.out.println("0th:"+tt1.toString());
//		for(int i = 1;i<list1.size();i++) {
//			Example35 e6 ;
//			e6 = new Example35();
//			e6.reduce(list1.get(i));
//			System.out.println(list1.get(i));
//			tt2 = e6.getOutput();
//			System.out.println(i+"th:"+tt2.toString());
//			if(!new Demo() .isEqual(tt1, tt2)) {
//				System.out.println("uncommutility!");
//				break;
//			}
//		}
//		System.out.println("commutility");
//	}
	public static List<ElemwntList> list1= new ArrayList<ElemwntList>();
	public static List<TwoTuple> tt1 ;
	public static void main(String[] args) {
		TestInput ti = new TestInput();
		ti.setPath("case");
		ElemwntList el = ti.createTestCase_Single(4, "String", "String");
		App0 a = new App0();
		a.reduce(el);
		tt1 = a.getOutput();
		System.out.println(tt1.toString());
	}

}
