package mergeTestExamples;

import java.util.ArrayList;
import java.util.List;

import packTest.Element;
import packTest.TestExample;

public class Demo {
	private List<TestExample> mergedTest = new ArrayList<TestExample>();
	
	public void allSort(TestExample te) {
		List<TestExample> intermid = new ArrayList<TestExample>();
		TestExample te_1 = new TestExample();
		te_1.getTest().add(te.getTest().get(0));
		intermid.add(te_1);
		for(int i = 1;i<te.getTest().size();i++) {
			intermid = diedai(intermid,te.getTest().get(i));
			System.out.println(intermid.size());
		}

//		intermid = diedai(intermid,te.getTest().get(1));
		mergedTest = intermid;
	}
	
	private List<TestExample> diedai(List<TestExample> example ,Element elem){
		List<TestExample> output = new ArrayList<TestExample>();
		TestExample te_1  = new TestExample();
		TestExample te_2  = new TestExample();
		for(int i = 0;i<example.size();i++) {
			te_1.copy(example.get(i));
//			te_1 = example.get(i);
//			System.out.println(te_1.getTest().size());
//			System.out.println("i = "+ i);
			for(int j = 0;j<=te_1.getTest().size();j++) {
				//System.out.println("i = "+i+" j = "+j+" size = "+te_1.getTest().size());
				te_2.copy(te_1);
//				te_2 = te_1;
				te_2.getTest().add(j, elem);
//				for(int k = 0;k<te_2.getTest().size();k++) {
//					System.out.println(te_2.getTest().get(k).toString());
//				}
				TestExample te_3  = new TestExample();
				te_3.copy(te_2);
				output.add(te_3);
				//te_2.getTest().clear();
			}
		}
//		System.out.println("output");
		return output;
	}
	
	public void printDemo() {
		System.out.println("Êä³ö");
		for(int i = 0;i<mergedTest.size();i++) {
			TestExample tel = mergedTest.get(i);
			System.out.println();
			for(int j = 0;j<tel.getTest().size();j++) {
				Element ell = tel.getTest().get(j);
				System.out.println(ell.getElem().toString());
				
			}
		}
	}
	
	public static void main(String[] args) {
		TestExample te = new TestExample();
		Element el;
		for(int i = 0;i<10;i++) {
			el = new Element();
			for(int j = 0;j<5;j++) {
				el.getElem().add(i);
			}
			te.getTest().add(el);
		}
		Demo de = new Demo();
		de.allSort(te);
		de.printDemo();
	}

}
