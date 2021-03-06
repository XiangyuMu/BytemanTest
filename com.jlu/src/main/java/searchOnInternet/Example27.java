package searchOnInternet;

import java.util.ArrayList;
import java.util.List;
import com.jlu.redcueExample.Element;
import com.jlu.redcueExample.ElemwntList;
//输入<String,int>(key,value)
//输出值为累加
//可交换
public class Example27 {
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	String v ="";
	
    public void reduce(ElemwntList list)  {

    	String key = (String)list.getList().get(0).getList().get(0);

    	int numTotalTweets = 0;
        for (Element value : list.getList()) {
            numTotalTweets += (Integer)value.getList().get(1);
        }
        output.add(new TwoTuple(key,Integer.toString(numTotalTweets)));
    }

}
