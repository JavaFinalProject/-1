package Register;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadInfo {
	@SuppressWarnings("unused")
	public static Boolean readFileString(String name) {
		File file=new File("Register.txt");
		if(!file.isFile())
			return true;
		 try {
			FileReader fr = new FileReader("Register.txt");//×Ö·û¶ÁÈëÁ÷
			if(fr==null)
				return true;
			BufferedReader br = new BufferedReader(fr);
			String a;
			while((a=br.readLine())!=null){
				String b[]=new String[2];
				b=a.split(" ");
				if(b[0].equals(name)){
					return false;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
