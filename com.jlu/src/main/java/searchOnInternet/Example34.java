package searchOnInternet;

import java.util.ArrayList;
import java.util.List;

import com.jlu.redcueExample.Element;
import com.jlu.redcueExample.ElemwntList;
//https://github.com/josonle/MapReduce-Demo/blob/master/src/main/java/shuffleTest/TempSort.java

//输入<String,int>(key,value)
//输出值为value的累加
//可交换
public class Example34 {
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	String v ="";
	float gradesSum;
    public void reduce(ElemwntList list)  {

    	String key = (String)list.getList().get(0).getList().get(0);

    	int  maxTemp = Integer.MIN_VALUE;
		for(Element value : list.getList()) {
			System.out.println("年："+key+", 气温："+value);
			if ((Integer)value.getList().get(1)>maxTemp) {
				maxTemp = (Integer) value.getList().get(1);
			}
		}
		System.out.println("Date:"+key+", MaxTemp:"+maxTemp);
		output.add(new TwoTuple(key, Integer.toString(maxTemp)));
    }

}
