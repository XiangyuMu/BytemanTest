package testList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.jlu.redcueExample.Element;
import com.jlu.redcueExample.ElemwntList;
//read the testcase file into the Elemwnlist.
public class TestInput {
	public ElemwntList ellist = new ElemwntList();
	public String path;
	public ElemwntList getEl() {
		return ellist;
	}
	public void setEl(ElemwntList el) {
		this.ellist = el;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public ElemwntList createTestCase(int CaseNum,String type1,String type2) {
		String filepath = path+Integer.toString(CaseNum)+".txt";
		File file = new File(filepath);  
		BufferedReader  reader = null;  
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				String str[] = tempString.split("# ");
				System.out.println("str "+str.length);
				Element el = new Element();
				for(int i = 0;i<str.length;i++) {
					el.getList().add(str[i]);
				}
				ellist.getList().add(el);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ellist;
	}

}
