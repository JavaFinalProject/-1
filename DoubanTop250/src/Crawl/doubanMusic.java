package Crawl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class doubanMusic {
	public static ArrayList<String> douban() throws IOException {
        String s1 = "https://music.douban.com/top250?start=";
      String s2 = "&filter=";
        String link = null;   // 电影的链接
        String title = null;  // 电影名称
        String score = null;  // 电影评分
        String num = null ;   // 获取评价人数
        // 存储待爬取的网址url链接
        ArrayList<String> list = new ArrayList<>();
        //String a[]=new String[250];
        ArrayList<String> listSo = new ArrayList<>();
        PrintStream ps = new PrintStream("doubanMusic.txt");//打印流
        for (int i = 0; i <= 225; i += 25) {
            list.add(s1+i+s2);
        } 
        // 遍历url集合 爬取网页数据
        for (String string : list) {
            Document doc = Jsoup.connect(string).userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36").timeout(6000).get();
			
           

            Element content = doc.getElementById("content");
            Elements infos = content.getElementsByClass("item");//获取关于该音乐的详细信息
            
           
            
            for (Element element : infos) {
                Element links = element.getElementsByTag("a").get(0);
                Element star = element.getElementsByClass("star clearfix").get(0);
                Element info = element.getElementsByClass("pl").get(0);
                link = links.attr("href");        // 获取音乐的链接
                title = links.attr("title"); // 获取音乐名称
                
                score = star.child(1).html();     // 获取音乐评分
                num = star.child(2).html(); // 获取音乐人数
               
                ps.println(link +"\t%" + title+"\t详细信息："+info + "\t评分" + score + "\t评价" + num);//输出到文件中，该方法将输出内容自动转成字符串型

              // System.setOut(ps);
              //System.out.println(link + "\t" + title+"\t详细信息："+info + "\t评分" + score + "\t" + num);//在控制台输出
             
              listSo.add(link + "\t%" +"\t" + title+"\t详细信息："+info + "\t评分" + score + "\t" + num+"\n");
                
           
             
            }
            
        }return listSo;
        
       
    }
	
	public static void getdoubanMusic() throws Exception {
			int size=doubanMusic.douban().size();
			//String array[]=new String[250];
			//for(int i=0;i<250;i++) {
			//	array[i]=(String)doubantest.douban().get(i);
			//}
			String[]array=(String[])doubanMusic.douban().toArray(new String[size]);
			for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
				
			
	}
			
			//System.out.println(doubantest.douban());

	

	
	}}


