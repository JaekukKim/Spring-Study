package dev.study.spring.cookieandsession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicSessionController {
	
	@GetMapping("/makingsession")
	public String makingSessionAndConfirm(HttpServletRequest req, HttpServletResponse resp) {
		// 세션 객체는 request를 사용하여 생성한다.
		HttpSession mySession = req.getSession();
		String sessionName = "1번세션";
		
		// 세션 객체에 키와 값을 넣어주자.
		mySession.setAttribute("firstSession", sessionName);
		
		// 세션의 여러가지 메소드를 활용하여 확인해보자.
		// 세션의 value 획득
		System.out.println(mySession.getAttribute("firstSession"));
		
		// 세션에 설정된 아이디 확인
		System.out.println(mySession.getId());
		
		// 세션 제거
//		mySession.invalidate(); <= 지금은 실습을 해봐야하니 당장 제거하진 말자.
		
		mySession.setMaxInactiveInterval(60*60);
		return "/cookieandsession/sessionExam";
	}
}
