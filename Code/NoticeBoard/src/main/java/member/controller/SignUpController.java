package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		// 1. 입력
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userNAME");
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");

		// 2. LOGIC
		// Service객체가 필요하다. Class가 있어야 Service 객체를 생성할 수 있다.
		// 만들러 가야지.. 슈웅~!

		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);

		MemberService service = new MemberService();
		member = service.join(member); // member data를 사용하니까 member data의 VO를 만들어서
		// 인자로 VO를 넘겨준다.
		// 인자로 VO를 넘겨준다.
		// 그럴려면 Class가 있어야지..
		// 그래서??? VO를 만들러 가야지.. 슈웅~!
		// 3.출력
		// Login에 성공하면 VO객체안에 Login한 사람의 name이 들어가있다.
		if (member != null) {

			response.sendRedirect("/NoticeBoard/user/login.html");
		}

	}

}
