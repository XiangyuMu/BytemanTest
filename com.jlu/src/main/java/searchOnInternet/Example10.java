package searchOnInternet;

import java.util.ArrayList;
import java.util.List;
import com.jlu.redcueExample.Element;
import com.jlu.redcueExample.ElemwntList;
//输入<String,String>(key,value)
//将value作为String进行累加
//不可交换
public class Example10 {

	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	String v = "";
	
	String userId = "";
	String itermScore = "";
	public void reduce(ElemwntList list) {
		String key = (String)list.getList().get(0).getList().get(0);

        //map输出的数据key为1,value为101:5.0
        String itermPers = "";
        for (Element value : list.getList()) {
            itermPers += "," + value.getList().get(1).toString();
        }
        v=(itermPers.replaceFirst(",", ""));
        output.add(new TwoTuple(key, v));
    
		    
	}


}
