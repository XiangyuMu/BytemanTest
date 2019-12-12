package mergeTestExamples;

import java.util.ArrayList;
import java.util.List;

import packTest.Element;
import packTest.TestExample;

public class dataProgress {
	private List<TestExample> mergedTest = new ArrayList<TestExample>();
	
	
	
	public void SingleItem(int row,TestExample test) {
		TestExample test_1 = new TestExample();
		if(row>test.getTest().size()) {
			System.out.println("测试用例行数小于输入，错误！");
		}else {
			TestExample te;
			for(int i = 0;i<test.getTest().size();i++) {
				if(i == row) {
					continue;
				}
				te = new TestExample();
				Element el_1 = test.getTest().get(row);
				Element el_2 = test.getTest().get(i);
				for(int j = 0;j<test.getTest().size();j++) {
					if(j == i) {
						te.getTest().add(el_1);
					}else if(j == row) {
						te.getTest().add(el_2);
					}else {
						te.getTest().add(test.getTest().get(j));
					}
				}
				mergedTest.add(te);
		}
		}
	}
	
	public void IndexValuePair() {
		
	}
	
	public void allSort(int x) {

		List<Integer> numList = new ArrayList<Integer>();
		for(int i = 0;i<x;i++) {
			numList.add(i);
		}
		for(int j = 0;j<numList.size();j++) {
			while(numList.size()!=0) {
				
			}
		}
		while(numList.size()!=0) {
			
		}
	
	}
	
	public void printDemo() {
		for(int i = 0;i<mergedTest.size();i++) {
			TestExample tel = mergedTest.get(i);
			for(int j = 0;j<tel.getTest().size();j++) {
				Element ell = tel.getTest().get(j);
				for(int k = 0;k<ell.getElem().size();k++) {
					System.out.println(ell.getElem().get(k));
				}
				
			}
		}
	}
	
//	public static void main(String[] args) {
//		TestExample te = new TestExample();
//		Element el;
//		for(int i = 0;i<10;i++) {
//			el = new Element();
//			for(int j = 0;j<5;j++) {
//				el.getElem().add(i);
//			}
//			te.getTest().add(el);
//		}
//		Demo de = new Demo();
//		//de.SingleItem(3, te);
//		de.printDemo();
//	}

}
