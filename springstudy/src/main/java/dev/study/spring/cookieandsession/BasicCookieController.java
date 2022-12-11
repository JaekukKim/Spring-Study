package dev.study.spring.cookieandsession;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicCookieController {
	
	/*
		검색지식
		=> @RequestMapping(method = RequestMethod.GET, ... ) == @GetMapping
	*/
	
	// 아래 두줄 코드의 의미는 같다.
	/* @RequestMapping(value = "/tikitakacookie", method = RequestMethod.GET) */
	@GetMapping("/makingcookie")
	public String makingCookieAndSend(HttpServletRequest req, HttpServletResponse resp,Model model) {
		// 일단 쿠키를 만들어보자.
		// 쿠키는 키와 값을 설정 해 주어야 한다. 키는 firstCookie, 값은 "1번쿠키에용"이다.
		Cookie cookie = new Cookie("firstCookie","1번쿠키에용");
		
		// 쿠키의 유통기한 설정 초단위이지만 초단위를 막 우겨넣어서는 안된다. 누구나 보기좋게!!
		cookie.setMaxAge(60*60); // 60초 x 60 =1시간.
		
		// 혹시 모르니 쿠키의 유통기한 확인
		System.out.println("쿠키의 수명은 몇초임? : " + cookie.getMaxAge() + "sec");
		
		// 쿠키를 만들면 뭐하나 어디에 쓸지 설정해줘야지.
		cookie.setPath("/makingcookie"); // 그냥 / 로 하면 모든 경로에서 써버려가지고 대참사가 나버린다. 꼭 필요한 경로에만!!
		// 콘솔출력 생활화 매우 도움이 된다.
		System.out.println(cookie.getPath());
		
		// 이제 만든 쿠키를 던져줘야한다. 만들기만하고 안주면 뭐함?
		resp.addCookie(cookie);
		
		// 어디서 쓸지 경로도 표시하여 보내버리자.
		return "/cookieandsession/cookieExam";
		
	}
	
	/*
	 * @GetMapping("/receivingcookie") public String
	 */
}
