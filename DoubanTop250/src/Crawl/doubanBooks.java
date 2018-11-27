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
	        // 存储待爬取的网址url链接
	        ArrayList<String> list = new ArrayList<>();
	        for (int i = 0; i <= 225; i += 25) {
	            list.add(s1+i);
	        }
	      
	        // 遍历url集合 爬取网页数据
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
	        			//pubinfo:[美] 卡勒德·胡赛尼 / 李继宏 / 上海人民出版社 / 2006-5 / 29.00元
	        			//               作者       / 翻译  /    出版社      /出版时间/价格
	        			// 没有翻译人员的格式：钱锺书 / 人民文学出版社 / 1991-2 / 19.00
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
				//file.mkdir();//创建目录
			File fileDir = new File(file,"");
			if(!fileDir.isFile()){
				try {
					fileDir.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				FileWriter fw = new FileWriter(fileDir);//FileWriter写入文件时不能指定编码格式，编码格式是系统默认的编码格式
				for(String a:stringBuffer) {
				fw.write(a+"\n"); //向文件中写入字符串
				}
				
				fw.flush(); //刷新
				fw.close(); }//关闭流}
				
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void readFileString() {
			try {
				FileReader fr = new FileReader("doubanBooks.txt");//字符读入流
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
