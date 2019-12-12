package searchOnInternet;

import java.util.ArrayList;
import java.util.List;
import com.jlu.redcueExample.ElemwntList;
//输入<String,String>(key,value)
//输出value为空的键值对
//不可交换
public class Example20 {
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	String v ="";
    public void reduce(ElemwntList list)  {

    	String key = (String)list.getList().get(0).getList().get(0);

    	int i = 0;
    	while (list.getList().get(i)!=null) {
            String inputDoc = (String) list.getList().get(i).getList().get(1);
            boolean keep = inputDoc.isEmpty();
            if (!keep) {
                String incrCounter="BehemothReducer";
                continue;
            }
            output.add(new TwoTuple(key, inputDoc));
    	}
    }
}
