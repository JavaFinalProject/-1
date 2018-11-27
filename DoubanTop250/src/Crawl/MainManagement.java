package Crawl;

import java.io.IOException;

public class MainManagement {
	public static void main(String[] args) throws Exception {
		//获取豆瓣图书
		doubanBooks.getDouBanBooks();
		//获取豆瓣电影
		doubanMovies.getdoubanMovies();
		//获取豆瓣音乐
		doubanMusic.getdoubanMusic();
	}
}
