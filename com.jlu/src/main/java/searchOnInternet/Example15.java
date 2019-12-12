package searchOnInternet;

import java.util.ArrayList;
import java.util.List;
import com.jlu.redcueExample.Element;
import com.jlu.redcueExample.ElemwntList;
//输入<String,String>(key,value)
//输出输入序列的个数
//可交换
public class Example15 {
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	String v ="";
    public void reduce(ElemwntList list)  {

    	String key = (String)list.getList().get(0).getList().get(0);
    	String recordKey = key.toString();
        String authorId = recordKey.substring(1);

        // we know that the first element will the the user reputation
        // because keys are sorted before arriving to the reducer
        // so we get it
        
        Integer reputation = (Integer) list.getList().iterator().next().getList().get(1);

        int postsNumber = 0;
        for (Element value : list.getList()) {
            postsNumber++;
        }
        v = (reputation + "\t" + postsNumber);
        output.add(new TwoTuple(authorId,v ));
    }
}
