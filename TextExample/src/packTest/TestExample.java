package packTest;

import java.util.ArrayList;
import java.util.List;

public class TestExample {
	private List<Element> test = new ArrayList<Element>();

	public List<Element> getTest() {
		return test;
	}

	public void setTest(List<Element> test) {
		this.test = test;
	}
	
	public void copy(TestExample te) {
		test.clear();
		this.test.addAll(te.getTest());
	}

}
