package book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.service.BookService;
import book.vo.Book;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/bsearch")
public class BookSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 입력
		String keyword = request.getParameter("keyword");

		// 2. 서비스를 이용한 로직처리
		BookService service = new BookService();
		ArrayList<Book> list = service.SearchByKeyword(keyword);
		// 책에 대한 목록들을 가지고 와야한다(LIST)

		// 3. 결과처리(View 처리)
		if (list != null) {
			// Success
			// list를 jsp에게 전달해서 결과를 Client에게 전송
			RequestDispatcher rd = request.getRequestDispatcher("/book/bookSearchResult.jsp");
			request.setAttribute("result", list);
			rd.forward(request, response);

		} else {
			// Fail
			// Fail.html 만들어서 사용자에게 redirect
			response.sendRedirect("/book/SuccessFail.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * String btitle = request.getParameter("bookName"); String bauthor =
		 * request.getParameter("bookAuthor");
		 * 
		 * Book book = new Book(); book.setBtitle(btitle); book.setBauthor(bauthor);
		 * 
		 * BookService service = new BookService(); // book = service.search(book);
		 * 
		 * if (book != null) { RequestDispatcher rd =
		 * request.getRequestDispatcher("/member/searchSuccess.jsp");
		 * request.setAttribute("book", book); rd.forward(request, response); } else {
		 * response.sendRedirect("/book/SuccessFail.html"); }
		 */

	}

}
