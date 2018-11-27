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
			}//创建目录
		
		try {
			FileWriter fw = new FileWriter(file,true);//FileWriter写入文件时不能指定编码格式，编码格式是系统默认的编码格式
			
			fw.write(name+" "+password+"\n"); //向文件中写入字符串
			fw.flush(); //刷新
			fw.close(); }//关闭流}
			
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
