package member.service;

import member.dao.MemberDAO;
import member.vo.Member;

public class MemberService {

	// login 처리하는 method
	public Member login(Member member) {
		// Login되는지 확인하는 LOGIC처리
		// Database 처리
		// Database 처리를 위해 DAO가 있어야한다.
		// 당연히 Class도 존재해야한다.
		// 그럼 만들러가야지.. 슈웅~!!

		try {
			MemberDAO dao = new MemberDAO();
			member = dao.select(member);
		} catch (Exception e) {
			System.out.println(e);
		}

		return member;
	}

	public Member join(Member member) {
		// Login되는지 확인하는 LOGIC처리
		// Database 처리
		// Database 처리를 위해 DAO가 있어야한다.
		// 당연히 Class도 존재해야한다.
		// 그럼 만들러가야지.. 슈웅~!!

		try {
			MemberDAO dao = new MemberDAO();
			member = dao.join(member);

		} catch (Exception e) {
			System.out.println(e);
		}

		return member;
	}
}
