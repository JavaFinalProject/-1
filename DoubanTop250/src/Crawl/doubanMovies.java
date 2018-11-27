package Crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class doubanMovies {
	
	private static List<String> StringBuffer = new ArrayList<String>();
	
	private static void Crawl() throws IOException{
		String s1 = "https://movie.douban.com/top250?start=";
		String s2 = "&filter=";
        String link = null;   // ��Ӱ������
        String title = null;  // ��Ӱ����
        String score = null;  // ��Ӱ����
        String num = null ;   // ��ȡ��������
		
		//�洢����ȡ����ַurl����
		ArrayList<String> list = new ArrayList<>();
		
		 for (int i = 0; i <= 225; i += 25) {
	            list.add(s1+i);
	        }
		 
		// ����url���� ��ȡ��ҳ����
		 int i =0;
		 
		 for(String string:list) {
			
			 Document doc = Jsoup.connect(string).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:60.0) Gecko/20100101 Firefox/60.0").timeout(6000).get();
			 Element content = doc.getElementById("content");
	         Elements infos = content.getElementsByClass("info");
	         
	         for (Element element : infos) {
	                Element links = element.getElementsByTag("a").get(0);
	                Element star = element.getElementsByClass("star").get(0);
	                Element bd = element.getElementsByClass("bd").get(0);
	                link = links.attr("href");        // ��ȡ��Ӱ������
	                title = links.child(0).html();    // ��ȡ��Ӱ����
	                score = star.child(1).html();     // ��ȡ��Ӱ����
	                num = star.child(3).html();       // ��ȡ��������
	        
	                //        System.out.println(link + "\t" + title + "\t����" + score + "\t" + num);
	                StringBuffer.add(link + "\t" + title + "\t����" + score + "\t" + num);
	                System.out.println();
	            }
			 
		 }
	}
	
	
	public static void getdoubanMovies() throws IOException{
		Crawl();
		MovieTxt.writeFileString(StringBuffer);
		MovieTxt.readFileString();
	}
}


 class MovieTxt {

	public static void writeFileString(List<String> stringBuffer) {
		
		File file = new File("doubanmovie.txt");
		File fileDir = new File(file,"");
		if(!fileDir.isFile()) {
			try {
				fileDir.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		try {
			FileWriter fw = new FileWriter(fileDir);
			
			for(String a:stringBuffer) {
				fw.write(a+"\n");
			}
				fw.flush();//ˢ��
				
				fw.close();//�ر���
			}catch(IOException e){
				
				e.printStackTrace();
			}
			}
		
	public static void readFileString() {
		
		try {
			
		FileReader fr = new FileReader("doubanmovie.txt");//�ַ�������
		BufferedReader br = new BufferedReader(fr);
		
		try {
			while(br.read()>0) {
				System.out.println(br.readLine());
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		}
		
	}

