package dev.study.spring.cookieandsession;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicCookieController {

	/*
	 * 검색지식 => @RequestMapping(method = RequestMethod.GET, ... ) == @GetMapping
	 */

	// 아래 두줄 코드의 의미는 같다.
	/* @RequestMapping(value = "/tikitakacookie", method = RequestMethod.GET) */
	@GetMapping("/makingcookie")
	public String makingCookieAndSend(HttpServletResponse resp, HttpServletRequest req, Model model)
			throws UnsupportedEncodingException {
		// 데브툴즈에서 문자열 깨져서나옴..
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		// ...? 위에걸로 해결이 안됨. 일단 쿠키세션하고 따로 찾아보자.

		// 일단 쿠키를 만들어보자.
		// 쿠키는 키와 값을 설정 해 주어야 한다. 키는 firstCookie, 값은 "1번쿠키에용"이다.
		Cookie cookie = new Cookie("firstCookie", "1번쿠키");

		// 쿠키의 유통기한 설정 초단위이지만 초단위를 막 우겨넣어서는 안된다. 누구나 보기좋게!!
		cookie.setMaxAge(60 * 60); // 60초 x 60 =1시간.

		// 혹시 모르니 쿠키의 유통기한 확인
		System.out.println("쿠키의 수명은 몇초임? : " + cookie.getMaxAge() + "sec");

		// 쿠키를 만들면 뭐하나 어디에 쓸지 설정해줘야지.
		cookie.setPath("/makingcookie"); // 그냥 / 로 하면 모든 경로에서 써버려가지고 대참사가 나버린다. 꼭 필요한 경로에만!!
		// 콘솔출력 생활화 매우 도움이 된다.
		System.out.println(cookie.getPath());

		// 이제 만든 쿠키를 던져줘야한다. 만들기만하고 안주면 뭐함?
		// 던져준다? response다. 쿠키생성 부분에선 req가 필요가 없다.
		resp.addCookie(cookie);
		resp.addCookie(new Cookie("secondCookie", "2번쿠키"));

		// 던진 쿠키를 가져와보자.
		Cookie[] cookies = req.getCookies();
		// 쿠키는 request로 가져온다. (쿠키 "요청")

		for (int i = 0; i < cookies.length; i++) {
			// 일단 콘솔에 테스트.
			System.out.println("쿠키의 이름은? " + cookies[i].getName());
			System.out.println("쿠키의 값은? " + cookies[i].getValue());
			
			// 반복문 안에서도 이게 돼나? 갑자기 궁금해짐 ㅎㅎ
			model.addAttribute("cookie"+i , cookies[i]);
			// 어 이게되네
		}
		// 여기서 JSESSIONID가 나온다. 이건 내가 만든 세션이 아니다...! 톰캣에서 세션을 유지하기 위해 발급하는 "키"일 뿐이다!!!
		// 절대 세션이 아니다.

		// 테스트 출력 성공. 이제 웹에서 뽑아보자.
//		model.addAttribute("cookie1", cookies[0]);
//		model.addAttribute("cookie2", cookies[1]);
		// 혹시..?
//		model.addAttribute("allCookie",cookies); <= 역시나 안된당.

		// 어디서 쓸지 경로도 표시하여 보내버리자.
		
		// ******* 쿠키의 값은 조작이 가능하다 !!!!!!!!!
		return "/cookieandsession/cookieExam";

	}

}
