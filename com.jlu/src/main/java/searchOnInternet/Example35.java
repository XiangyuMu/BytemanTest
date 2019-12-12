package searchOnInternet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jlu.redcueExample.Element;
import com.jlu.redcueExample.ElemwntList;
//https://github.com/josonle/MapReduce-Demo/blob/master/src/main/java/ssdut/training/mapreduce/peoplerank/PeopleRank2.java

//输入<String,String>(key,value)
//输出值为复杂计算
//暂不清楚，大概率可交换
public class Example35 {
	public static enum Mycounter {
		my
	}
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	float gradesSum;
    public void reduce(ElemwntList list) throws IOException  {

    	String key = (String)list.getList().get(0).getList().get(0);

    	double sum = 0.0;
		People sourcePeople = null;
		for (Element v : list.getList()) {
			People people = People.fromMR(v.getList().get(1).toString());
			if (people.containsAttentionPeoples()) {		//含有关注人的是源结构
				sourcePeople = people;
			} else {
				sum += people.getPeopleRank();				//将不含临近节点的PR值累加
			}
		}
		double newPR = (1 - 0.85) / 4 + (0.85 * sum);		//计算新的PR值 = (1-d)/N + d* sum（每个被关注者PR值/每个关注人链出数）  (阻尼系数取0.85)
		//double d = newPR - sourcePeople.getPeopleRank();	//计算新旧PR差值
		//int j = Math.abs( (int)(d*100.0) );					//取收敛差值放大100倍后的绝对值
		//context.getCounter(Mycounter.my).increment(j);		//放入计数器
		sourcePeople.setPeopleRank(newPR);					//更新PR值			
		output.add(new TwoTuple(key, sourcePeople.toString()));	//输出格式："userid  新PR值  userlist"
    }
    public static class People {
    	private double peopleRank = 1.0;		//存储 PR值，初值默认1.0
    	private String[] attentionPeoples;		//关注的人
    	public static final char fieldSeparator = '\t';	//多处使用分隔符\t，定义为常量

    	public double getPeopleRank() {
    		return peopleRank;
    	}

    	public People setPeopleRank(double pageRank) {
    		this.peopleRank = pageRank;
    		return this;
    	}

    	public String[] getAttentionPeoples() {
    		return attentionPeoples;
    	}

    	public People setAttentionPeoples(String[] attentionPeoples) {
    		this.attentionPeoples = attentionPeoples;
    		return this;
    	}

    	//判断是否包含关注用户
    	public boolean containsAttentionPeoples() {
    		return attentionPeoples != null && attentionPeoples.length > 0;
    	}

    	@Override
    	//People对象转成字符串
    	public String toString() {
    		StringBuilder sb = new StringBuilder();
    		sb.append(peopleRank);
    		if (attentionPeoples != null) {
    			sb.append(fieldSeparator).append(StringUtils.join(attentionPeoples, fieldSeparator));
    		}
    		return sb.toString();	//返回String格式："PeopleRand值	u1	u2..."
    	}
    	
    	//字符串转成People对象
    	public static People fromMR(String str) throws IOException {	//参数String格式："PeopleRand值	u1	u2..."
    		People people = new People();
    		String[] strs = StringUtils.splitPreserveAllTokens(str, fieldSeparator);	//将字符串按分隔符分割成字符串数组
    		people.setPeopleRank(Double.valueOf(strs[0]));	//处理第一个元素
    		if (strs.length > 1) {// 设置关注的人，从strs下标为1的位置开始（因为传进来类似"1.0 b c d"的字符串）
    			people.setAttentionPeoples(Arrays.copyOfRange(strs, 1, strs.length));	//处理其它元素
    		}
    		return people;	//返回People对象
    	}
    }
}
