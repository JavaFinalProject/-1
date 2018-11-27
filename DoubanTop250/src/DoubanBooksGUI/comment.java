package DoubanBooksGUI;
/**
 * author xiajiayu
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.*;
import Landing.LandingMyActionListener;
@SuppressWarnings("serial")
public class comment extends JPanel{
	private JButton button=new JButton("�ύ����");
	private JTextArea JxA=new JTextArea(5,50);
	private JTextArea JxA2=new JTextArea(30,50);
	public comment() {
		button.addActionListener(new setComment());		
		JxA2.setText(readComment());
		this.setLayout(new BorderLayout());
		this.add(button,BorderLayout.EAST);
		this.add(JxA,BorderLayout.WEST);
		this.add(JxA2,BorderLayout.SOUTH);
	}
	private class setComment implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String comment=JxA.getText();
			if(LandingMyActionListener.land==true) {
			writeComment("@"+LandingMyActionListener.userName+": "+comment);
			JxA2.setText(readComment());
		}
			// TODO Auto-generated method stub
			
		}

	public  void writeComment(String comment) {
		File file=new File("BooksComment.txt");
		if(!file.isFile())
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//����Ŀ¼
		try {
			FileWriter fw = new FileWriter(file,true);//FileWriterд���ļ�ʱ����ָ�������ʽ�������ʽ��ϵͳĬ�ϵı����ʽ
			fw.write(" "+comment+"\n"); //���ļ���д���ַ���
			fw.flush(); //ˢ��
			fw.close(); }//�ر���}
			
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
	public  String readComment() {
		StringBuilder comment=new StringBuilder();
		try {
			FileReader fr = new FileReader("BooksComment.txt");//�ַ�������
			BufferedReader br = new BufferedReader(fr);
			while(br.read() > 0){
				comment.append(br.readLine()+"\n");
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return comment.toString();
	}
	
	
}

