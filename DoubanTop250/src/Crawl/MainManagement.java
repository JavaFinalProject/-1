package Crawl;

import java.io.IOException;

public class MainManagement {
	public static void main(String[] args) throws Exception {
		//��ȡ����ͼ��
		doubanBooks.getDouBanBooks();
		//��ȡ�����Ӱ
		doubanMovies.getdoubanMovies();
		//��ȡ��������
		doubanMusic.getdoubanMusic();
	}
}
