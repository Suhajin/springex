package cafe.jjdev.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cafe.jjdev.web.service.Member;
import cafe.jjdev.web.service.MemberDao;
import cafe.jjdev.web.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberService memberService;
	//로그아웃처리
	   @RequestMapping(value="/logout")
	   public String logout(HttpSession session) {
	      session.invalidate();
	      return "redirect:/login";
	   }
	   
	   //로그인 폼
	   @RequestMapping(value="/login", method = RequestMethod.GET)
	   public String login(HttpSession session) {
	      if(session.getAttribute("loginMember") == null) {
	         return "login";
	      }
	      return "redirect:/test";
	   }
	   
	   //로그인처리
	   @RequestMapping(value="/login", method = RequestMethod.POST)
	   public String login(Member member, HttpSession session) {
	      Member loginMember = memberDao.login(member);
	      
	      if(loginMember == null) {
	         return "redirect:/login";
	      } else {
	         //session 로그인 정보를 저장
	         session.setAttribute("loginMember", loginMember);
	         return "redirect:/test";
	      }
	      
	   }
	   
	   //회원전용페이지
	   @RequestMapping(value="/test") //로그인이 안되어 있으면 login페이지로 넘긴다.
	   public String test(HttpSession session) {
	      if(session.getAttribute("loginMember") == null) {
	         return "redirect:/login";
	      }
	      return "test";
	   }
	   
	
	
	@RequestMapping(value="/memberList")
	public String memberList(Model model) {
		System.out.println("memberList ��û...");
		List<Member> list = memberDao.selectMemberList();
		model.addAttribute("list", list);
		// DB list get....
		return "memberList"; 	
	}
	
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	// command��ü�̿��ϴ� ���
	public String addMebmer(MemberRequest memberRequest) { // Member member
		System.out.println(memberRequest);
		memberService.addMember(memberRequest);
		return "redirect:/memberList"; // response.sendRedirct("/memberList")
	}
	
	/* @RequestParam ����
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
