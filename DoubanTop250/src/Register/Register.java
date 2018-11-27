package Register;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class Register  {
	public static void getRegistered(String name,String password,JTextArea jtA) {
		if(ReadInfo.readFileString(name)==true) {
			WriteInfo.writeFiles(name,password);
			jtA.setText("注册成功");
		}
		else {
			jtA.setText("对不起该用户名以被注册，请重新注册");
		}
		
	}

}
