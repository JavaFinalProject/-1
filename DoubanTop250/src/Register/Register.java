package Register;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class Register  {
	public static void getRegistered(String name,String password,JTextArea jtA) {
		if(ReadInfo.readFileString(name)==true) {
			WriteInfo.writeFiles(name,password);
			jtA.setText("ע��ɹ�");
		}
		else {
			jtA.setText("�Բ�����û����Ա�ע�ᣬ������ע��");
		}
		
	}

}
