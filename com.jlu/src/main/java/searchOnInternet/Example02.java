package searchOnInternet;

import java.util.ArrayList;
import java.util.List;



import com.jlu.redcueExample.Element;
import com.jlu.redcueExample.ElemwntList;
//输入<String,int>(key,value)
//将value的值进行累加
//可交换
public class Example02 {
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	public void reduce(ElemwntList list) {

		String key = (String)list.getList().get(0).getList().get(0);
        Integer sum = 0;
        for (Element i : list.getList()) {
            sum += (Integer)i.getList().get(1);
        }
        
        output.add(new TwoTuple(key, sum.toString()));
    
	}

}
