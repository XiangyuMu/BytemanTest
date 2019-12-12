package packTest;

import java.util.ArrayList;
import java.util.List;

public class Element {
	private List<Object> elem = new ArrayList<Object>();

	public List<Object> getElem() {
		return elem;
	}

	public void setElem(List<Object> elem) {
		this.elem = elem;
	}
	
	public String toString() {
		String str = "[";
		for(int i = 0;i<this.elem.size();i++) {
			str = str + this.elem.get(i)+" ";
		}
		str = str + "]";
		return str;
	}

}
