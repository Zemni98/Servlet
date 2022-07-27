package book.service;

import java.util.ArrayList;

import book.dao.BookDAO;
import book.vo.Book;

public class BookService {

	public ArrayList<Book> SearchByKeyword(String keyword) {
		// 키워드를 이용해서 책는 로직을 처리
		// for, if 로직처리가 일반적으로 나오는데
		// Database 처리를 해야 해요!

		ArrayList<Book> list = null;
		try {
			BookDAO dao = new BookDAO();
			list = dao.select(keyword);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		return list;
	}
}
