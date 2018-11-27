package DouBanMusicGUI;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Landing.LandingMyActionListener;
public class doubanMusic {
	

	private JFrame myFrame;
	private JTable myTable;
	private Panel myPanel;
	private Panel panel1;
	private Panel panel2;
	private TextArea t1;
	private TextArea t2;
	private Label label;
	private Button b;
	private Button myButton;
	private TextField myTextField;
	 Vector v = new Vector(250);
	 Tool tool=new Tool();
	
	DefaultTableModel model = new DefaultTableModel(); // �½�һ��Ĭ������ģ��
	
	
	String[]name= {"����","��վ","�����Լ�ר������","��ϸ��Ϣ","����","��������"};
	public  doubanMusic(){
		myFrame=new JFrame();
		myFrame.setTitle("Douban music Top 250");
		myFrame.setResizable(true);
		myFrame.setSize(500,400);
		
		myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
			
		});
		
		myButton=new Button("����");
		myTextField=new TextField(20);
		//myFrame.setLayout(new GridLayout(4,1));
		myPanel=new Panel();
		myPanel.add(myTextField);
		myFrame.add(myPanel,BorderLayout.NORTH);
		myPanel.add(myButton);
		MyActionListener myActionListener = new MyActionListener(myTextField);
		
		myButton.addActionListener(myActionListener);
		myTable = new JTable(model); // ������ģ�ʹ���JTable
		//������Ԫ����Ⱦ��������¼�������
        LinkCellRenderer renderer = new LinkCellRenderer();
        //ע����Ⱦ��
        myTable.setDefaultRenderer(Object.class, renderer);
        //ע�������
        myTable.addMouseListener(renderer);
        myTable.addMouseMotionListener(renderer);


		myFrame.add(myTable,BorderLayout.CENTER);
		myFrame.add(new JScrollPane(myTable));
		myFrame.setVisible(true);
		panel1=new Panel(new BorderLayout());
		label=new Label("-----------------------------------------------------"
				+ "----------------------- �� �� �� -------------------------------"
				+ "------------------------------------");
		JScrollPane jsp=new JScrollPane(t1);
		panel1.add(jsp);
		t1=new TextArea();
		t2=new TextArea();
		//JScrollPane jsp1=new JScrollPane(t2);
		//myFrame.getContentPane().add(jsp1);

		b=new Button("ȷ������");
		aActionListener actionListener=new aActionListener(t1,t2);
		if(LandingMyActionListener.land==true)
			b.addActionListener(actionListener);
		 
		panel1.add(label,BorderLayout.NORTH);
		panel1.add(t1,BorderLayout.CENTER);
		panel1.add(b,BorderLayout.EAST);
		panel1.add(t2,BorderLayout.SOUTH);
		
		try {File ctoFile = new File("MusicComment.txt");
		  
		InputStreamReader rdCto = new InputStreamReader(new FileInputStream(ctoFile));
		BufferedReader bfReader = new BufferedReader(rdCto);
	
      	String txtline = null;
		
		
			while ((txtline = bfReader.readLine()) != null) {
				
				t2.append(txtline+"\r\n");
			}
			bfReader.close();
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		myFrame.add(panel1,BorderLayout.SOUTH);
		
		model.setColumnIdentifiers(name);
		 myFrame.setLocationRelativeTo(null);     
		try {for(int i=0;i<250;i++)
			model.addRow(tool.toArray(i));
		} catch (IOException e) {
			
			e.printStackTrace();
		}}
	
	
		 
	/*	public static void main(String[] args) throws IOException {
			GUITest frame=new GUITest();
	
	
	}*/
	
	}


	class MyActionListener implements ActionListener{
			Tool tool1=new Tool();
			private TextField textfield;
			public MyActionListener(TextField textfield) {
				this.textfield=textfield;
			}
	public void actionPerformed(ActionEvent e) {
		String strr=new String();
		strr=textfield.getText();
		
		JFrame f=new JFrame();
		f.setLocation(100,50);
	    //�����С
		f.setSize(800,500);
		JLabel jlabel=new JLabel("��Ǹ����Ҫ�ҵĸ��ֻ������ֲ��ڡ���������TOP 250����");
		JLabel label=new JLabel("�������");
		f.add(label,BorderLayout.NORTH);
		JTable table=new JTable();
		String[]name1= {"����","��վ","�����Լ�ר������","��ϸ��Ϣ","����","��������"};
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(name1);
		table = new JTable(model); // ������ģ�ʹ���JTable
		
		f.add(new JScrollPane(table));
		//������Ԫ����Ⱦ��������¼�������
        LinkCellRenderer renderer = new LinkCellRenderer();
        //ע����Ⱦ��
        table.setDefaultRenderer(Object.class, renderer);
        //ע�������
        table.addMouseListener(renderer);
        table.addMouseMotionListener(renderer);


		f.add(table,BorderLayout.CENTER);
		
		for(int i=0;i<250;i++)
		{try {
			if(tool1.infoShow()[i].contains(strr)) {
					model.addRow(tool1.toArray(i));//i++;
			}	
			} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		/*int i=0;
		while(i!=250)
		{try {
			if(tool1.infoShow()[i].contains(strr)==false) {
				i++;
			}
			while(i==250)
			{
				f.add(jlabel);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}*/
		f.setVisible(true);
	}
	}
	
	class aActionListener implements ActionListener{
		private TextArea textarea1;
		private TextArea textarea2;
	
		public aActionListener(TextArea textarea1,TextArea textarea2) {
			this.textarea1=textarea1;
			this.textarea2=textarea2;
			
		}
		public void actionPerformed(ActionEvent a) {
			String str=new String();
			str=textarea1.getText();
			// File file=new File("D:\\mydoc");
			  //if(!file.exists()){
			 //file.mkdir();
			// }
			 File file2 = new File("MusicComment.txt");
			  if(!file2.exists()){
			 try{
				 file2.createNewFile();
				 }catch(IOException e){
			e.printStackTrace();
	}
				}
				 FileWriter fileWriter;
				 try{ /*File ctoFile = new File("D:\\mydoc\\����.txt");
				  
					InputStreamReader rdCto = new InputStreamReader(new FileInputStream(ctoFile));
					BufferedReader bfReader = new BufferedReader(rdCto);
				
                  	String txtline = null;
					
					while ((txtline = bfReader.readLine()) != null) {
						
						textarea2.append(txtline+"\r\n");
					}
					bfReader.close();*/
					
				  fileWriter = new FileWriter(file2,true);
				  
				  BufferedWriter out=null;
				  out=new BufferedWriter(new OutputStreamWriter(new 
						  FileOutputStream(file2,true)));
				  out.write("@"+LandingMyActionListener.userName+":"+str.toString()+"\r\n");
				 out.close();
				  
				 textarea2.append("@"+LandingMyActionListener.userName+":"+str.toString()+"\r\n");
				 
		    
				 }catch(IOException e){
			         e.printStackTrace();
			        }
				 
			 }
			
		}
	


class Tool{
	public String[] infoShow() throws IOException {
		File ctoFile = new File("doubanMusic.txt");
		
		InputStreamReader rdCto = new InputStreamReader(new FileInputStream(ctoFile));

		BufferedReader bfReader = new BufferedReader(rdCto);

		String txtline = null;
		String a[]=new String[250];
		int i=0;int count=0;

		while ((txtline = bfReader.readLine()) != null) {
		a[i]=txtline;
			i++;
			//return txtline;
			count++;
				}
	    bfReader.close();
		return a;
	}
	
	
	public String toStr6(String Str) {
		String str=Str;
		return str.substring(str.indexOf("����(")+3, str.lastIndexOf("��")+1);
	}
	public String toStr1(String Str) {
		String str=Str;
		return str.substring(str.indexOf("h"), str.lastIndexOf("%"));
	}
	public String toStr2(String Str) {
		String str=Str;
		return str.substring(str.indexOf("%")+1, str.lastIndexOf("��ϸ"));
	}
	/*public String toStr3(String Str) {
		String str1=Str;
		return str1.substring(str1.indexOf("-"), str1.lastIndexOf("��"));
	}*/
	
	public String toStr4(String Str) {
		String str=Str;
		return str.substring(str.indexOf(">")+1, str.lastIndexOf("<"));
	}
	public String toStr5(String Str) {
		String str=Str;
		return str.substring(str.indexOf("����")+2, str.lastIndexOf("\t"));
	}
	public Vector toArray(int i) throws IOException {
		Tool tool=new Tool();
		Vector v=new Vector();
		
		v.add("No."+(i+1));
		v.add(tool.toStr1(tool.infoShow()[i]));
		v.add(tool.toStr2(tool.infoShow()[i]));
		v.add(tool.toStr4(tool.infoShow()[i]));
		v.add(tool.toStr5(tool.infoShow()[i]));
	    v.add(tool.toStr6(tool.infoShow()[i]));
	    return v;}
}


class LinkCellRenderer extends DefaultTableCellRenderer implements MouseInputListener {

    //����¼����ڵ���
    private int row = -1;
    //����¼����ڵ���
    private int col = -1;
    //��ǰ������Table
    private JTable table = null;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //�ָ�Ĭ��״̬
        this.table = table;
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        this.setForeground(Color.black);
        table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        this.setText(value.toString());
        //�����ǰ��Ҫ��Ⱦ���ĵ�Ԫ���������¼����ڵĵ�Ԫ��
        if (row == this.row && column == this.col) {
            //����ǵڶ���(�ڶ�������ʾ�����ӵ���)
            if (column == 1) {
                //�ı�ǰ��ɫ(������ɫ)
                this.setForeground(Color.blue);
                //�ı������״
                table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                //��ʾ��������ʽ
                this.setText("<html><u>" + value.toString() + "</u></html>");
            }
            setBackground(table.getSelectionBackground());
        } else if (isSelected) {
            //�����Ԫ��ѡ��,��ı�ǰ��ɫ�ͱ���ɫ
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            //��������»ָ�Ĭ�ϱ���ɫ
            setBackground(Color.white);
        }
        return this;
    }

    /**
     * ����Ƴ��¼�
     * @param e 
     */
    public void mouseExited(MouseEvent e) {
        if (table != null) {
            int oldRow = row;
            int oldCol = col;
            //����Ƴ�Ŀ�����,�ָ��������ݵ�Ĭ��ֵ
            row = -1;
            col = -1;
            //��֮ǰ������������Чʱ�ػ��������
            if (oldRow != -1 && oldCol != -1) {
                Rectangle rect = table.getCellRect(oldRow, oldCol, false);
                table.repaint(rect);
            }
        }
    }

    /**
     * ����϶��¼�
     * @param e 
     */
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    /**
     * ����ƶ��¼�
     * @param e 
     */
    public void mouseMoved(MouseEvent e) {
        if (table != null) {
            Point p = e.getPoint();
            int oldRow = row;
            int oldCol = col;
            row = table.rowAtPoint(p);
            col = table.columnAtPoint(p);
            //�ػ�ԭ��������
            if (oldRow != -1 && oldCol != -1) {
                Rectangle rect = table.getCellRect(oldRow, oldCol, false);
                table.repaint(rect);
            }
            //�ػ��µ�����
            if (row != -1 && col != -1) {
                Rectangle rect = table.getCellRect(row, col, false);
                table.repaint(rect);
            }
        }
    }

    /**
     * ��굥���¼�
     * @param e 
     */
    public void mouseClicked(MouseEvent e) {
        //��ȡ�¼����ڵ�����������Ϣ
        Point p = e.getPoint();
        int c = table.columnAtPoint(p);
        if(c != 1){
            return;
        }
        int r = table.rowAtPoint(p);
        try {
            //ȡ��Ŀ�굥Ԫ���ֵ,��������Ϣ
            URL url = new URL(table.getValueAt(r, c).toString());
            //��ϵͳĬ��������д�����
            Desktop.getDesktop().browse(url.toURI());
        } catch (Exception ex) {
            Logger.getLogger(LinkCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}}



