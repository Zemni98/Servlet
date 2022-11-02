package post.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import member.vo.Member;

public class postDAO {

	private DataSource ds;
	private Connection con;
	private ResultSet rs;

	public postDAO() throws Exception {

		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");

	}

	public Member select(Member member) throws Exception {
		Connection con = ds.getConnection();
		System.out.println("connection 획득 성공!!");

		String sql = "SELECT * FROM users WHERE id=? AND pw=?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			// Login 성공
			member.setName(rs.getString("name"));
			return member;
		}

		return null;
	}

	/*
	 * public boolean ID_Check(String id) { try { PreparedStatement pstmt =
	 * con.prepareStatement("SELECT * FROM users WHERE id = ?"); pstmt.setString(1,
	 * id); rs = pstmt.executeQuery(); if (rs.next()) { return false; } else {
	 * return true; } } catch (Exception e) { e.printStackTrace(); } return false; }
	 */

	public Member join(Member member) throws Exception {
		Connection con = ds.getConnection();
		System.out.println("connection 획등 성공!!");
		String sql = "INSERT INTO users VALUES (?,?,?)";
		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.executeUpdate();
			return member;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
