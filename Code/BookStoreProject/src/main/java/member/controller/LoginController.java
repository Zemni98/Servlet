package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
			throws ServletException, IOException {
		// 1. 입력
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		// 2. LOGIC
		// Service객체가 필요하다. Class가 있어야 Service 객체를 생성할 수 있다.
		// 만들러 가야지.. 슈웅~!

		Member member = new Member();
		member.setId(id);
		member.setPw(pw);

		MemberService service = new MemberService();
		member = service.login(member); // member data를 사용하니까 member data의 VO를 만들어서 인자로 VO를 넘겨준다.
		// 그럴려면 Class가 있어야지..
		// 그래서??? VO를 만들러 가야지.. 슈웅~!
		// 3.출력
		// Login에 성공하면 VO객체안에 Login한 사람의 name이 들어가있다.
		if (member != null) {
			// Login에 성공하면 JSP를 이용해서 출력해야 한다.
			// 사용자의 이름을 찍어야하는데 이름이 member라는 객체안에있다.
			// member VO 객체를 JSP에게 전달해야한다.
			// 즉, Controller Servlet이 request를 전달해서 다른 Servlet(JSP)을 호출하는 개념
			RequestDispatcher rd = request.getRequestDispatcher("/member/loginSuccess.jsp");
			request.setAttribute("member", member);
			rd.forward(request, response);
			// request.getDispatcherType();
		} else {
			response.sendRedirect("/book/member/loginFail.html"); // 잘못되었을때 클라이언트에게 보내줄 HTML을 여기에다가 적으면된다.
		}

	}

}
