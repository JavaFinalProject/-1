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
        String link = null;   // ��Ӱ������
        String title = null;  // ��Ӱ����
        String score = null;  // ��Ӱ����
        String num = null ;   // ��ȡ��������
        // �洢����ȡ����ַurl����
        ArrayList<String> list = new ArrayList<>();
        //String a[]=new String[250];
        ArrayList<String> listSo = new ArrayList<>();
        PrintStream ps = new PrintStream("doubanMusic.txt");//��ӡ��
        for (int i = 0; i <= 225; i += 25) {
            list.add(s1+i+s2);
        } 
        // ����url���� ��ȡ��ҳ����
        for (String string : list) {
            Document doc = Jsoup.connect(string).userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36").timeout(6000).get();
			
           

            Element content = doc.getElementById("content");
            Elements infos = content.getElementsByClass("item");//��ȡ���ڸ����ֵ���ϸ��Ϣ
            
           
            
            for (Element element : infos) {
                Element links = element.getElementsByTag("a").get(0);
                Element star = element.getElementsByClass("star clearfix").get(0);
                Element info = element.getElementsByClass("pl").get(0);
                link = links.attr("href");        // ��ȡ���ֵ�����
                title = links.attr("title"); // ��ȡ��������
                
                score = star.child(1).html();     // ��ȡ��������
                num = star.child(2).html(); // ��ȡ��������
               
                ps.println(link +"\t%" + title+"\t��ϸ��Ϣ��"+info + "\t����" + score + "\t����" + num);//������ļ��У��÷�������������Զ�ת���ַ�����

              // System.setOut(ps);
              //System.out.println(link + "\t" + title+"\t��ϸ��Ϣ��"+info + "\t����" + score + "\t" + num);//�ڿ���̨���
             
              listSo.add(link + "\t%" +"\t" + title+"\t��ϸ��Ϣ��"+info + "\t����" + score + "\t" + num+"\n");
                
           
             
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


