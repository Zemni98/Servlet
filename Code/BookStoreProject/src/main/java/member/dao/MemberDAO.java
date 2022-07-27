package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.vo.Member;

public class MemberDAO {

	private DataSource ds;

	public MemberDAO() {

		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Member select(Member member) throws Exception {

		Connection con = ds.getConnection();
		System.out.println("connection 획등 성공!!");
		String sql = "SELECT * FROM members WHERE id=? AND pw=?";
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
}
