package lecture0725;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public LoginServlet() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {

		}
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 입력을 받는다.
		// 한가지 주의해야 할 점은... 입력을 받을 때 사용되는 Stream의 encoding이 ISO-8859-1(영문 encoding이라 한글이
		// 깨진다.)
		// 만약 한글 data를 전달받으려면 별도의 처리를 해주어야한다.
		// -> 만약 GET방식인 경우, Tomcat의 입력 Stream의 encoding을 바꾸어주야한다.
		// Servers Folder에 server.xml의 connector 뒤에 URIEncoding="EUC-KR"을 추가해주면 된다.
		// request.setCharacterEncoding("EUC-KR");
		String email = request.getParameter("userEmail"); // Query String으로 넘어가는것은 무조건 문자열이다.
		String pw = request.getParameter("userPassword");

		// 2. LOGIC 처리한다.
		// 입력된 email과 password가 database table에 존재하는지 확인!
		// JDBC code
		String jdbcURL = "jdbc:mysql://localhost:3306/sql5db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean loginStatus = false;
		try {
			con = DriverManager.getConnection(jdbcURL, "root", "jm19980630!");
			String sql = "SELECT * FROM tmpuser WHERE email=? and password=?";
			// 3. Statement 생성
			// stmt = con.createStatement(); // 일반 Statement
			// PreparedStatement 생성
			
			pstmt = con.prepareStatement(sql); // PreparedStatement
			pstmt.setString(1, email);
			pstmt.setString(2, pw);

			// 4. 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				loginStatus = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}finally {
			
				
				try {
					if(rs != null)rs.close();
					if(con != null)con.close();
					if(pstmt != null)pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = new PrintWriter(response.getOutputStream());
		if(loginStatus) {
			out.println("성공");
		} else {
			out.println("실패");
		}
		// 3. 출력을 처리한다.
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// POST 방식에서의 한글입력받기.
		// request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
