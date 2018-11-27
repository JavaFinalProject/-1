package Landing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import MainFrameGUI.MainFrame;

public class LandingMyActionListener implements ActionListener{
	public static String userName;
	public static boolean land;
		private JTextField usertxt;
		private JPasswordField pwdtxt;
		MainFrame mf=new MainFrame();
		
		public LandingMyActionListener(JTextField usertxt,JPasswordField pwdtxt) {
			this.usertxt=usertxt;
			this.pwdtxt=pwdtxt;
			
		}
		public void actionPerformed(ActionEvent e)
	    {
			
	        if(!CheckIsNull())
	        {
	        	userName=usertxt.getText().trim();
	            //获取用户所输入的用户名
	            String user = usertxt.getText().trim();
	        	
	            //获取用户所输入的密码
	            String pwd = pwdtxt.getText().trim();
	        	
	            if(checkUserAndPwd(user,pwd)=="true")
	            {

	                //隐藏当前登录窗口
	              
	            	JOptionPane.showMessageDialog(mf,"登录成功！！！");
	            	//mf.setVisible(false);
	            	land=true;
	            }
	            else
	            {   land=false;
	            	if(checkUserAndPwd(user,pwd)=="stay")
	                //如果错误则弹出一个显示框
	                //JOptionPane pane = new JOptionPane("用户或密码错误");
	                //JDialog dialog  = pane.createDialog(GUIt.myFrame,"警告");
	                //dialog.show();
	               {JOptionPane.showMessageDialog(mf,"密码错误，请重新输入");}
	            if(checkUserAndPwd(user,pwd)=="false") {
	            	JOptionPane.showMessageDialog(mf,"您还未注册过，请先注册");
	            }
	            	

	            }
	        }
	    }
	    

		public String result;
		

	private String checkUserAndPwd(String user,String pwd)
	{
	    result = "false";
	    try
	    {
	       
	    	File ctoFile = new File("Register.txt");
			  if (!ctoFile.exists()) {
	    	    ctoFile.createNewFile();
	    	   }
			InputStreamReader rdCto = new InputStreamReader(new FileInputStream(ctoFile));
			BufferedReader bfReader = new BufferedReader(rdCto);
		
	      	String txtline = null;
			
			
				while ((txtline = bfReader.readLine()) != null) 
	    	
	       {
	            String[] strs = txtline.split(" ");
	            if(strs[0].equals(user)&&strs[1].equals(pwd))
	            {
	                //if(strs[1].equals(pwd))
	               result ="true"; 
	            }
	            else { if(strs[0].equals(user)&&!strs[1].equals(pwd))
	            	{result="stay";}
	            
	            }}
	           
	       
	       bfReader.close();
	    }catch(Exception ex)
	    {
	        System.out.print("");
	    }
	    return result;
	}
	@SuppressWarnings("deprecation")
	private boolean CheckIsNull()
	{
	    boolean flag = false;
	    if(usertxt.getText().trim().equals(""))
	    {
	        flag = true;
	    }
	    else
	    {
	        if(pwdtxt.getText().trim().equals(""))
	        {
	            flag = true;
	        }
	    }
	    return flag;
	}
	 
	}
