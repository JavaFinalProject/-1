package Register;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteInfo {
	public static void writeFiles(String name,String password) {
		File file = new File("Register.txt");
		if(!file.isFile())
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//����Ŀ¼
		
		try {
			FileWriter fw = new FileWriter(file,true);//FileWriterд���ļ�ʱ����ָ�������ʽ�������ʽ��ϵͳĬ�ϵı����ʽ
			
			fw.write(name+" "+password+"\n"); //���ļ���д���ַ���
			fw.flush(); //ˢ��
			fw.close(); }//�ر���}
			
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
