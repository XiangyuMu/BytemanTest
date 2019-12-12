package BackWord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class checkingNode {
	
	private String name;
	private List<dictNode> dictList= new ArrayList<dictNode>();
	private boolean isCorrect = false;
	private List<Integer> squNumber = new ArrayList<Integer>();
	private String correctWord;
	
	
	
	public List<Integer> getSquNumber() {
		return squNumber;
	}
	public void setSquNumber(List<Integer> squNumber) {
		this.squNumber = squNumber;
	}
	public List<dictNode> getDictList() {
		return dictList;
	}
	public void setDictList(List<dictNode> dictList) {
		this.dictList = dictList;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getCorrectWord() {
		return correctWord;
	}
	public void setCorrectWord(String correctWord) {
		this.correctWord = correctWord;
	}
	
	
	private int computeSimilirity(String dictWord) {
		char[] s1=name.toCharArray();	//预置单词
		char[] s2=dictWord.toCharArray();
		int m=s2.length+1,n=s1.length+1;		//矩阵
		int[][] table=new int[m][n];
		// 矩阵的初始化
		for(int i=0;i<n;i++){	
			table[0][i]=i;
			
		}
		for(int i=0;i<m;i++){
			table[i][0]=i;
			
		}
		//算法开始，向矩阵中添加数值
		for(int i=0;i<n-1;i++){
			for(int j=0;j<m-1;j++){
				int temp=0;
				if(s1[i]!= s2[j])
					temp=1;
				else
					temp=0;
			table[j+1][i+1]=Min(table[j][i]+temp,table[j+1][i]+1,table[j][i+1]+1);
			}
			
		}
		//输出矩阵
//		for(int i=0;i<m;i++){
//			for(int j=0;j<n;j++){
//				System.out.print(table[i][j]);
//				System.out.print(",");
//			}
//			System.out.println();
//			
//		}
		if(table[m-1][n-1]==0) {
			isCorrect = true;
		}
		return table[m-1][n-1];
	}
	
	public void sumDictList(List<dictNode> list) {                      //计算一个单词对应dict中每个单词的相似度并排序
		int count;
		count = list.size();
		for (int i = 0;i < count; i++) {
			dictNode node = new dictNode();
			node.setName(list.get(i).getName());
			node.setSimilarity(computeSimilirity(list.get(i).getName()));    //computeSimilirity
			dictList.add(node);
		}
		
		Collections.sort(dictList, new Comparator<dictNode>() {
			public int compare(dictNode node1,dictNode node2) {
				if(node1.getSimilarity()>node2.getSimilarity()) {
					return 1;
				}
				if(node1.getSimilarity()==node2.getSimilarity()) {
					return 0;
				}
				return -1;                           //排序
			}
		});
	}
	private static int Min(int i, int j, int k) {
		// TODO Auto-generated method stub
		int[] tempSequence={i,j,k};
		int min=i;
		for(int n=0;n<3;n++){
			if(tempSequence[n]<min){
				min=tempSequence[n];
			}
		}
		return min;
	}
	
	
	public int test(String word) {
		float a,b,c;
		b=0;
		int wordsize;
		System.out.println(word+"   "+name);
		if(word.length()>name.length()) {
			wordsize = name.length();
			c = word.length() - wordsize;
		}else {
			wordsize = word.length();
			c = name.length() - wordsize;
		}
		char[] s1=name.toCharArray();	
		char[] s2=word.toCharArray();
		
		for(int i = 0;i<s1.length;i++) {
			boolean flag1 = true;
			char c1 = s1[i];
			for(int k = 0;k<s2.length;k++) {
				if(c1 == s2[k]) {
					flag1 = false;
					break;
				}
			}
			if(flag1) {
				b = b + 1;
			}
		}
		int samecount = 0;
		for(int m=0;m<wordsize;m++) {
			if(s1[m]==s2[m]) {
				samecount = samecount + 1;
			}
		}
		a = samecount/wordsize;
		return  (int) ((a-0.5*b-0.1*c)*10);
	}


}
