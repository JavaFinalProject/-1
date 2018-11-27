package Crawl;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.ArrayList;
import java.util.List;


	public class doubanBooks {
		private static List<String> stringBuffer=new ArrayList<String>();
		public static void Crawl() throws IOException {
		  
	    	
	    	String s1 = "https://book.douban.com/top250?start=";
	        // �洢����ȡ����ַurl����
	        ArrayList<String> list = new ArrayList<>();
	        for (int i = 0; i <= 225; i += 25) {
	            list.add(s1+i);
	        }
	      
	        // ����url���� ��ȡ��ҳ����
	        int i=0;
	       
	        for (String string : list) {
	        	List<String>content=null;
	            Document doc = Jsoup.connect(string).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36").timeout(6000).get();
	            	Elements elements = doc.select("div[class=indent]").select("table");
	        		for (Element ele : elements){
	        			i=i+1;
	        			String name = ele.select("div[class=pl2]").text();
	        			Element links=ele.getElementsByTag("a").get(0);
	        			String link=links.attr("href");
	        			
	        			String pubinfo = ele.select("p").text();
	        			//pubinfo:[��] ���յ¡������� / ��̺� / �Ϻ���������� / 2006-5 / 29.00Ԫ
	        			//               ����       / ����  /    ������      /����ʱ��/�۸�
	        			// û�з�����Ա�ĸ�ʽ��Ǯ���� / ������ѧ������ / 1991-2 / 19.00
	        			String[] infos = pubinfo.split("/");
	        			content=Arrays.asList(infos);
	        			
	        			String ratingStr = ele.select("div[class=star clearfix]").select("span[class=rating_nums]").text();
	        			Double rating = Double.valueOf(ratingStr);
	        			stringBuffer.add(" <<"+name+">>"+"\n "+content.toString()+"\n "+rating+"\n "+link);
	        			System.out.println();
	        			
	            }
	        		//crawlcontent.setPagecontent(Crawlcontent.toString());
	        		
	    }

	}
		
		public static void getDouBanBooks() throws IOException {
		    Crawl();
			ReadTxt.writeFileString(stringBuffer);
			ReadTxt.readFileString();
			
			
		}
	}
	 class ReadTxt {
		 
		public static void writeFileString(List<String> stringBuffer) {
			File file = new File("doubanBooks.txt");
			//if(!file.isDirectory())
				//file.mkdir();//����Ŀ¼
			File fileDir = new File(file,"");
			if(!fileDir.isFile()){
				try {
					fileDir.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				FileWriter fw = new FileWriter(fileDir);//FileWriterд���ļ�ʱ����ָ�������ʽ�������ʽ��ϵͳĬ�ϵı����ʽ
				for(String a:stringBuffer) {
				fw.write(a+"\n"); //���ļ���д���ַ���
				}
				
				fw.flush(); //ˢ��
				fw.close(); }//�ر���}
				
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void readFileString() {
			try {
				FileReader fr = new FileReader("doubanBooks.txt");//�ַ�������
				BufferedReader br = new BufferedReader(fr);
				while(br.read() > 0){
					System.out.println(br.readLine());
				}
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
