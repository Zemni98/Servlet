package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import book.vo.Book;

public class BookDAO {

	private DataSource ds;

	public BookDAO() throws Exception {

		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");

	}

	public ArrayList<Book> select(String keyword) throws Exception {
		Connection con = ds.getConnection();
		System.out.println("connection 획등 성공!!");

		String sql = "SELECT btitle,bauthor,bprice,bisbn,bimgurl FROM book WHERE btitle LIKE ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyword + "%");
		ResultSet rs = pstmt.executeQuery();

		ArrayList<Book> list = new ArrayList<Book>();

		while (rs.next()) {
			Book tmp = new Book();

			tmp.setBtitle(rs.getString("btitle"));
			tmp.setBauthor(rs.getString("bauthor"));
			tmp.setBprice(rs.getInt("bprice"));
			tmp.setBisbn(rs.getString("bisbn"));
			tmp.setBimgurl(rs.getString("bimgurl"));

			list.add(tmp);
		}

		return list;
	}
}
