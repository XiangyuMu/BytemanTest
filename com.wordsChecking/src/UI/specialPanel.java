package UI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class specialPanel extends JPanel{
	public JLabel jl = new JLabel();
	public JButton jb1 = new JButton();
	public JButton jb2 = new JButton();
	public JButton jb3 = new JButton();
	public JButton jb4 = new JButton();
	public JButton jb5 = new JButton();
	public JButton jb6 = new JButton();
	public JButton jb7 = new JButton("没有推荐");
	public JButton jb8 = new JButton("单词正确");
	
	
	
	public JButton getJb1() {
		return jb1;
	}
	public void setJb1(JButton jb1) {
		this.jb1 = jb1;
	}
	public JButton getJb2() {
		return jb2;
	}
	public void setJb2(JButton jb2) {
		this.jb2 = jb2;
	}
	public JButton getJb3() {
		return jb3;
	}
	public void setJb3(JButton jb3) {
		this.jb3 = jb3;
	}
	public JButton getJb4() {
		return jb4;
	}
	public void setJb4(JButton jb4) {
		this.jb4 = jb4;
	}
	public JButton getJb5() {
		return jb5;
	}
	public void setJb5(JButton jb5) {
		this.jb5 = jb5;
	}
	public JButton getJb6() {
		return jb6;
	}
	public void setJb6(JButton jb6) {
		this.jb6 = jb6;
	}
	public JButton getJb7() {
		return jb7;
	}
	public void setJb7(JButton jb7) {
		this.jb7 = jb7;
	}
	public JButton getJb8() {
		return jb8;
	}
	public void setJb8(JButton jb8) {
		this.jb8 = jb8;
	}
	public void setJL(String str) {
		jl.setText(str);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		
	}
	
	
	
	public void setAllButton(String str1,String str2,String str3,String str4,String str5,String str6) {
		jb1.setText(str1);
		jb2.setText(str2);
		jb3.setText(str3);
		jb4.setText(str4);
		jb5.setText(str5);
		jb6.setText(str6);
		
		
	}
	public void createPanel() {
		this.setPreferredSize(new Dimension(400,250));
		//this.setLayout(null); 
		jl.setPreferredSize(new Dimension(400,40));
//		jb1.setBounds(5, 55, 70, 40);
//		jb2.setBounds(85, 55, 70, 40);
//		jb3.setBounds(165, 55, 70, 40);
//		jb4.setBounds(245, 55, 70, 40);
//		jb5.setBounds(325, 55, 70, 40);
//		jb6.setBounds(5, 105, 190, 40);
//		jb7.setBounds(205, 105, 190, 40);
		jb1.setPreferredSize(new Dimension(190,40));
		jb2.setPreferredSize(new Dimension(190,40));
		jb3.setPreferredSize(new Dimension(190,40));
		jb4.setPreferredSize(new Dimension(190,40));
		jb5.setPreferredSize(new Dimension(190,40));
		jb6.setPreferredSize(new Dimension(190,40));
		jb7.setPreferredSize(new Dimension(190,40));
		jb8.setPreferredSize(new Dimension(190,40));
		this.add(jl);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		this.add(jb7);
		this.add(jb8);
		
		
		
	}
	
	

}
