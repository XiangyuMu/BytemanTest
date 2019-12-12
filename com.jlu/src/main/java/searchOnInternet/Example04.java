package searchOnInternet;

import java.util.ArrayList;
import java.util.List;


import com.jlu.redcueExample.Element;
import com.jlu.redcueExample.ElemwntList;
//输入<String,String>(key,value)
//将value的值通过“ ”连接
//不可交换
public class Example04 {

	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	public void reduce(ElemwntList list) {
		String key = (String)list.getList().get(0).getList().get(0);
        StringBuilder totalStr = new StringBuilder();
        for (Element value : list.getList()) {
            totalStr.append(value.getList().get(1).toString()).append(" ");
        }
        String v =totalStr.toString();
        output.add(new TwoTuple(key, v));
    }



}
