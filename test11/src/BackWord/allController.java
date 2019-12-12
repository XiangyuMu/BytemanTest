package BackWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class allController {
	
	private String dict_path;
	private String file_path;
	private List<dictNode> dictList = new ArrayList<dictNode>();
	private List<checkingNode> textList = new ArrayList<checkingNode>();
	private List<checkingNode> errorList = new ArrayList<checkingNode>();
	private int necessarycount = 0;
	
	public void pluNessaryCount() {
		necessarycount = necessarycount+1;
	}
	public int getNecessarycount() {
		return necessarycount;
	}
	public void setNecessarycount(int necessarycount) {
		this.necessarycount = necessarycount;
	}
	public List<checkingNode> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<checkingNode> errorList) {
		this.errorList = errorList;
	}
	public String getDict_path() {
		return dict_path;
	}
	public void setDict_path(String dict_path) {
		this.dict_path = dict_path;
		System.out.println(this.dict_path);
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	
	
	public void inputDictList() {
		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw  
		      
            /* ����TXT�ļ� */  
			System.out.println(dict_path);
            File filename = new File(dict_path); // Ҫ��ȡ����·����input��txt�ļ�  
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); // ����һ������������reader  
            BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
            String line = "";  
            line = br.readLine();  
            while (line != null) {
            	dictNode node = new dictNode();
            	node.setName(line);
            	node.setSimilarity(0);
            	dictList.add(node);
            	System.out.println(node.getName());
                line = br.readLine(); // һ�ζ���һ������  
            }  
            System.out.println("����");
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	public void inputTextList() {                    //������ļ�����List
		int count = 0;

		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw  
		      
            /* ����TXT�ļ� */  
            File filename = new File(file_path); // Ҫ��ȡ����·����input��txt�ļ�  
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); // ����һ������������reader  
            BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
            String line = "";  
            line = br.readLine();
            boolean flag = true;  
            while (line != null) {
            	String[] str1 = line.split(" ");
            	for(int i = 0;i<str1.length;i++) {
//            		String inword = str1[i];
            		String inword = preprocessWords(str1[i]);
            		//System.out.println("���е���");
            		
            		if(flag) {
            			checkingNode textword = new checkingNode();
            			textword.setName(inword);
            			count = count + 1;
            			textword.getSquNumber().add(count);
            			textList.add(textword);
            			flag = false;
            		}
            		int countsize = textList.size();
            		boolean flag1 = false;
            		for(int k = 0;k<countsize;k++) {
            			System.out.println(k);
            			if(inword.equals(textList.get(k).getName())) {
            				count = count +1 ;
            				textList.get(k).getSquNumber().add(count);
            				flag1=true;
            				break;
            			}		
            			
            		}
            		if(!flag1) {
            			checkingNode textword = new checkingNode();
            			textword.setName(inword);
            			count = count + 1;
            			textword.getSquNumber().add(count);
            			textList.add(textword);
            		}
            	}
                line = br.readLine(); // һ�ζ���һ������  
            }
            for(int j = 0;j<textList.size();j++) {
            	System.out.println(textList.get(j).getName());
            	textList.get(j).sumDictList(dictList);
            }
            
            for(int j = 0;j<textList.size();j++) {
//            	System.out.println("����"+textList.size());
            	if(!textList.get(j).isCorrect()) {
            		errorList.add(textList.get(j));
            		System.out.println("���ʣ�"+textList.get(j).getName()+"  "+textList.get(j).isCorrect());
            		for(int k12 = 0;k12<6;k12++) {
            			System.out.println(textList.get(j).getDictList().get(k12).getName()+"   "+textList.get(j).getDictList().get(k12).getSimilarity());
            		}
            	}
            	
            }
//            List<dictNode> node1 = textList.get(3).getDictList();
//            System.out.println(textList.get(3).getName()+"   "+textList.get(3).isCorrect());
//            for(int ki = 0;ki<5;ki++) {
//            	System.out.println(node1.get(ki).getName()+"    "+node1.get(ki).getSimilarity());
//            	
//            }
            System.out.println("jieshu");
		}catch (Exception e) {
			e.printStackTrace();
		}

	

	}
	
		
	
	public String preprocessWords(String src) {         //�Դ�����ļ�����Ԥ����
		char[] cr= src.toCharArray();
		char[] str= new char[cr.length];
		int index = 0;
		for(int i = 0;i < cr.length;i++) {
//			if(cr[i] == '\'') {
//				break;
//			}
			if((cr[i] <= 'Z'&&cr[i]>= 'A') || (cr[i] <= 'z'&&cr[i]>= 'a') || (cr[i] == '\'')|| (cr[i] == '��')) {//�ж��ǲ����ַ�
				if(cr[i] == '��') {
					cr[i] = '\'';
				}
				str[index ++] = cr[i];
			}
		}
		return new String(str, 0, index).toLowerCase();//�����ַ����
		}
	
	
	public void fixWord(String correctWord) {
		errorList.get(necessarycount).setCorrectWord(correctWord);
		
	}
	
	
	public void outputFile() {
		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw  
		      
            /* ����TXT�ļ� */  
			File file=new File("newfile.txt");
			RandomAccessFile raf=new RandomAccessFile(file, "rw");
            File filename = new File(file_path); // Ҫ��ȡ����·����input��txt�ļ�  
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); // ����һ������������reader  
            BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
            String line = "";  
            line = br.readLine();
            boolean flag = true;  
            while (line != null) {
            	String newText = "";
            	String[] str1 = line.split(" ");
            	for(int i = 0;i<str1.length;i++) {
            		String inword = preprocessWords(str1[i]);
            		for(int k = 0;k<errorList.size();k++) {
            			if(errorList.get(k).isCorrect()==false&&inword.equals(errorList.get(k).getName())) {
            				inword = errorList.get(k).getCorrectWord();
            				
            			}
            			
            		}
            		newText = newText + inword + " ";
            		
            		
            		
            	}
            	raf.seek(raf.length());
            	raf.writeBytes(newText + "\r\n");
            	
                line = br.readLine(); // һ�ζ���һ������  
            }
            raf.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void inDict(String word) {
		
		try {
			File file=new File(dict_path);
			RandomAccessFile raf=new RandomAccessFile(file, "rw");
			raf.seek(raf.length());
        	raf.writeBytes("\r\n");
        	raf.writeBytes(word);
        	raf.close();
        	
        	errorList.get(necessarycount).setCorrect(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
