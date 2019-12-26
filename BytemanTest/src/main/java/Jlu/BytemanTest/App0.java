package Jlu.BytemanTest;


import java.util.ArrayList;
import java.util.List;



public class App0 {

	public List<TwoTuple> getOutput() {
		return output;
	}
	public void setOutput(List<TwoTuple> output) {
		this.output = output;
	}
	
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	public void reduce(ElemwntList list) {
		String s1;
		String s2;
		s1 = "s is a String!";
		s2 = s1;
		System.out.println(s1);
		System.out.println("init!");
		String key = (String)list.getList().get(0).getList().get(0);
		System.out.println("second line");
        StringBuilder totalStr = new StringBuilder();
        key = "2";
        for (Element value : list.getList()) {
        	System.out.println("in front of getList()");
            totalStr.append(value.getList().get(1).toString()).append(" ");
        }
        String v =totalStr.toString();
        output.add(new TwoTuple(key, v));
    }



}

