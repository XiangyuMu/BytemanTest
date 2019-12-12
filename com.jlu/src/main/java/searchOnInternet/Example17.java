package searchOnInternet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import com.jlu.redcueExample.ElemwntList;
//输入<String,String>(key,value)
//输出set（value）的集合
//可交换（set为无顺序）
public class Example17 {
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	String v ="";
    public void reduce(ElemwntList list)  {

    	String key = (String)list.getList().get(0).getList().get(0);
    	Set<String> attackers = new TreeSet<String>();
    	int i = 0;
        while (list.getList().get(i)!=null) {
          String valStr = list.getList().get(i).getList().get(1).toString();
          i = i+1;
          attackers.add(valStr);
        }
        output.add(new TwoTuple(key, attackers.toString()));
    }
}
