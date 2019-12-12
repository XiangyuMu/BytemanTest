package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import BackWord.allController;
import BackWord.checkingNode;


public class Frame extends JFrame{
	public JButton jb1 = new JButton("选择");
	public JButton jb2 = new JButton("选择");
	public JButton jb3 = new JButton("开始检测");
	public JButton jb4 = new JButton("输出文件");
	public JTextField jtf1 = new JTextField("请选择字典库。");
	public JTextField jtf2 = new JTextField("请选择检测文件。");
	public String dict_path;
	public String file_path;
	public JPanel mainpanel = new JPanel();
	public JScrollPane scrollPane = new JScrollPane(mainpanel);
	int num = 0;
	public JFileChooser jfc1 = new JFileChooser();
	public JFileChooser jfc2 = new JFileChooser();
	public File checkeFile;
	public File dictFile;
	private List<checkingNode> errorList;
	private allController demo = new allController();
	
	
	public allController getDemo() {
		return demo;
	}
	public void setDemo(allController demo) {
		this.demo = demo;
	}
	public void CreatJFrame(String title) {
		JFrame jf = new JFrame(title);
		jf.setLayout(null);
		Container container=jf.getContentPane();//获取一个容器
        //container.setBackground(Color.blue);//设置容器的背景颜色
        jf.setVisible(true);//使窗体可视
        jf.setBounds(500,100,450,650);;//设置窗体大小
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        jtf1.setBounds(5, 5, 250, 25);
        jb1.setBounds(270, 5, 100, 25);
        jtf2.setBounds(5, 40, 250, 25);
        jb2.setBounds(270, 40, 100, 25);
        
        
        //mainpanel.setBounds(0, 0, waith, high);
       // mainpanel.setLayout(null);
        
//        c
        
        
        scrollPane.setBounds(5, 80, 400, 450);
        jb3.setBounds(100, 550, 100, 25);
        jb4.setBounds(225, 550, 100, 25);
        container.add(jtf1);
        container.add(jb1);
        container.add(jtf2);
        container.add(jb2);
        container.add(scrollPane);
        container.add(jb3);
        container.add(jb4);
        System.out.println(num);
        
        jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfc1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
				jfc1.showDialog(new JLabel(), "选择");
				dictFile = jfc1.getSelectedFile();
				jtf1.setText(dictFile.getAbsolutePath());
				dict_path = dictFile.getAbsolutePath();
				
			}
		});
        
        jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfc2.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
				jfc2.showDialog(new JLabel(), "选择");
				checkeFile = jfc2.getSelectedFile();
				jtf2.setText(checkeFile.getAbsolutePath());
				file_path = checkeFile.getAbsolutePath();
			}
		});
        
        
        jb3.addActionListener(new ActionListener() {     //检测按钮
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//mainpanel.remove(pieces);
				
				demo.setDict_path(dict_path);
				demo.setFile_path(file_path);
				demo.inputDictList();
				demo.inputTextList();
				errorList = demo.getErrorList();
				
				
				num = errorList.size();
				System.out.println("num="+num);
				int waith = 400;
		        int high = num * 255;
				mainpanel.setPreferredSize(new Dimension(waith,high));
				int k1  = 0;
				for(int i=0;i<num;i++) {
		        	specialPanel sp = new specialPanel();
		        	sp.createPanel();
		        	sp.setJL(errorList.get(i).getName());
		        	sp.setAllButton(errorList.get(i).getDictList().get(0).getName(), errorList.get(i).getDictList().get(1).getName(), errorList.get(i).getDictList().get(2).getName(), errorList.get(i).getDictList().get(3).getName(), errorList.get(i).getDictList().get(4).getName(),errorList.get(i).getDictList().get(5).getName());
		        	//sp.setBounds(0, (i-1)*150, 400, 150);
		        	String str1 = errorList.get(i).getDictList().get(0).getName();
		        	String str2 = errorList.get(i).getDictList().get(1).getName();
		        	String str3 = errorList.get(i).getDictList().get(2).getName();
		        	String str4 = errorList.get(i).getDictList().get(3).getName();
		        	String str5 = errorList.get(i).getDictList().get(4).getName();
		        	String str6 = errorList.get(i).getDictList().get(5).getName();
		        	String correctword = errorList.get(i).getName();
		        	mainpanel.add(sp);
		        	sp.getJb1().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
				
							// TODO Auto-generated method stub
							demo.fixWord( str1);
							demo.pluNessaryCount();
						}
					});
		        	sp.getJb2().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							demo.fixWord(str2);
							demo.pluNessaryCount();
						}
					});
		        	sp.getJb3().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							demo.fixWord( str3);
							demo.pluNessaryCount();
						}
					});
		        	sp.getJb4().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							demo.fixWord( str4);
							demo.pluNessaryCount();
						}
					});
		        	sp.getJb5().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							demo.fixWord( str5);
							demo.pluNessaryCount();
						}
					});
		        	sp.getJb6().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							demo.fixWord( str6);
							demo.pluNessaryCount();
						}
					});
		        	sp.getJb7().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
		        	sp.getJb8().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							demo.inDict(correctword);
							demo.pluNessaryCount();
						}
					});
		        }
				mainpanel.revalidate();
				mainpanel.repaint();
				
				
				
			}
		});
        
        
        jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				demo.outputFile();
			}
		});
        
	}
	public static void main(String[] args) {
		new Frame().CreatJFrame("123");
	}
}
