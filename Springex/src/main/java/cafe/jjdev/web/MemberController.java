package cafe.jjdev.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.web.service.Member;
import cafe.jjdev.web.service.MemberDao;
import cafe.jjdev.web.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	} 	
	// 로그인 폼
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(HttpSession session) {
		if(session.getAttribute("logingMember") == null) {
			return "login";
		}
		return "redirect:/test";
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		Member loginMember = memberDao.login(member);
		System.out.println("loginMember"+loginMember);
		if(loginMember == null) {
			return "redirect:/login";
		} else {
			// session 로그인 정보를 저장
			session.setAttribute("logingMember", loginMember);
			return "redirect:/test";
		}
	}
	@RequestMapping(value="/test")
	public String test(HttpSession session) {
		if(session.getAttribute("logingMember") == null) {
			return "redirect:/login";
		}
		return "test";
	}
	
	
	@RequestMapping(value="/memberList")
	public String memberList(Model model) {
		System.out.println("memberList 요청...");
		List<Member> list = memberDao.selectMemberList();
		model.addAttribute("list",list);
		return "memberList"; 
	}
	 
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	// command객체이용하는 방법
	public String addMebmer(MemberRequest memberRequest) { // Member member
		System.out.println(memberRequest);
		memberService.addMember(memberRequest);
		return "redirect:/memberList"; // response.sendRedirct("/memberList")
	}
	
	/* @RequestParam 각각
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	public String addMebmer(@RequestParam(value="memberId") String memberId
							,@RequestParam(value="memberPw") String memberPw
							,@RequestParam(value="memberName") String memberName) {
			System.out.println("memberId:"+memberId);
			System.out.println("memberPw:"+memberPw);
			System.out.println("memberName:"+memberName);
		return "";
	}
	*/
	@RequestMapping(value="/addMember", method = RequestMethod.GET)
	public String addMebmer() {
		return "addMember";
	}
	
	@RequestMapping("/getMember")
	public String getMember(Model model) {
		Member member = memberDao.selectMemberOne(1);
		model.addAttribute("member", member);
		return "getMember";
	}
}
