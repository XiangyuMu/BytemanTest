package searchOnInternet;


import java.util.ArrayList;
import java.util.List;
import com.jlu.redcueExample.Element;
import com.jlu.redcueExample.ElemwntList;
//输入<String,int>(key,value)     (其中key为名字+“:”+分数)
//计算人物对应的分数和总分数，使用了String的加法
//不可交换

public class Example09 {

	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	String v = "";
	
	String userId = "";
	String itermScore = "";
	public void reduce(ElemwntList list) {
		String key = (String)list.getList().get(0).getList().get(0);


		        Double totalScore = 0.0;
		        for (Element value : list.getList()) {
		            totalScore +=(Integer) value.getList().get(1);
		        }
		        String[] strArr = key.toString().split(":");
		        userId=(strArr[0]);
		        itermScore=(strArr[1] + ":" + totalScore);
		        output.add(new TwoTuple(userId, itermScore));
		    
	}


}
