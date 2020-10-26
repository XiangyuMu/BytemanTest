package TargetClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example01 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    String k = new String();
    String v = new String();
    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    public void reduce(ElemwntList list) throws IOException, InterruptedException {
        Set<String> friends = new HashSet<String>();
        for (Element value : list.getList()) {
            friends.add(value.getList().get(1).toString());
        }
        System.out.println(friends);
        if (friends.size() > 1) {
            for (String f1 : friends) {
                for (String f2 : friends) {
                    if (!f1.equals(f2)) {
                        k = f1;
                        v = f2;
                        output.add(new TwoTuple(k, v));
                    }
                }
            }
        }
    }

}