package dev.study.spring.studywhilemakingofseotda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityAjaxSeotdaController {
	
	@RequestMapping(value = "/securityajax", method = RequestMethod.GET)
	public String connectAjax(CardDeck carddeck, HttpServletRequest req, Model model) {
		// 이제 이 SecurityAjaxSeotdaController 부분에선 웹 브라우저에서 데브툴즈로 값이 조작 가능 한 점을 파악하여 그것을
		// 방지하기 위한
		// 카드에 쿠키 세션 값을 입혀주어 보안? 까지 강화시키는 버전을 만들어 볼려고한다.

		// 먼저 쿠키는 보안성이 세션에 비해 안좋으므로 세션 객체를 생성한다. 세션은 서버에 저장되어 관리되기 때문.
		HttpSession cardSession = req.getSession();

		// 아래 주석 두줄로 "이 컨트롤러(입장컨트롤러)" 에서 ajax와 통신하는 컨트롤러로 session값이 넘어가는 부분은 확인이 완료되었다.
//		String ticket = "입장권";
//		cardSession.setAttribute("player", ticket);

		carddeck.shuffle();

		// 1번 플레이어의 1번째카드, 2번째카드 얻는 변수.
		String firstHanded = carddeck.getCards().get(0).getCardNum();
		String secondHanded = carddeck.getCards().get(2).getCardNum();
		
		// 값을 session에 추가
		cardSession.setAttribute("firstCard", firstHanded);
		cardSession.setAttribute("secondCard", secondHanded);
		
		// ** 페이지 진입부가 정답이였다... 내가 했던 모든 방식들을 조합할 생각을 못했다.
		// 세션값은 map형태로 관리되어 새로운 페이지가 뜨면 카드의 value가 덮어씌워져버린다.
		// 그럼 두번째 페이지를 띄웠을 때 아예 그 전 페이지를 만료시켜버리면 어떨까??
		// 먼저 페이지의 상태를 확인하는 변수 선언, 변수의 특정값을 이용해 페이지를 관리할 예정이다.
		int pageCount = 1;
		
		// 세션에 저장되어있는 pageCount를 불러와 null검사를 실시한다.
		if(cardSession.getAttribute("pageCount") != null) {
			// 초기값 1, null이 아님.
			pageCount = (int)cardSession.getAttribute("pageCount");
			pageCount++;
			System.out.println("jsp 진입부분 pageCount : " + pageCount);
		}
		// model에만 추가하여 jsp에서 관리할 수 있게 한다.
		model.addAttribute("pageCount", pageCount);
		
		cardSession.setAttribute("pageCount", pageCount);

		return "toyprj/securityajaxjsphouse";
	}

	@ResponseBody
	@RequestMapping(value = "/securitydobak", method = RequestMethod.POST)
	public Map<String, Object> getDeck(@RequestParam("pageCount") int pageC, @RequestParam Map<String, Object> param, CardDeck carddeck, HttpSession session,
			HttpServletRequest req) {

		List<Card> secondCardList = new ArrayList<>();
		
		// @RequestParam("pageCount") int pageC jsp에서 넘어온 값을 pageC에 저장한다.
		if((int)session.getAttribute("pageCount") != pageC) {
			System.out.println("에러가 났을시 pageCount(pageC)의 값(jsp진입부분의 값과 동일해야함) : " + pageC);
			throw new IllegalStateException("만료된 게임입니다.");
		}
		System.out.println("세션에 저장된 pageCount값(jsp에서 넘겨준 pageCount값) : " + (int)session.getAttribute("pageCount"));
		System.out.println("ajax에서 넘어온 pageCount(pageC) 값 : " + pageC);
		
		// 1번 플레이어는 진입부분에서 생성함.
		// 2번 플레이어 카드 객체 생성
		Card card2 = new Card();
		// 결과를 저장하고 출력할 문자열 생성
		String result = "";
		// 패 등급의 명칭을 담을 변수
		String firstPlayerDeckLevel = "";
		String secondPlayerDeckLevel = "";
		// 매직넘버 방지용 광패 변수, 광은 하나밖에 없는 패 이므로 final로 설정
		final int FIRST_LIGHT_NUM = 11;
		int THIRD_LIGHT_NUM = 13;
		int EIGHTH_LIGHT_NUM = 18;

		// 작은 패를 첫번째 카드로 바꿔주기 위한 임시변수
		int temp1 = 0; // 1번 플레이어
		int temp2 = 0; // 2번 플레이어.
		// 플레이어의 패 등급을 판별하기 위한 변수
		int firstPlayerLevel = 0;
		int secondPlayerLevel = 0;

		// 카드 덱 객체 생성.
//		CardDeck cd = new CardDeck();

		carddeck.shuffle();

		// -----------------------------------------------------------------------------
		// 1번 플레이어의 1번째카드, 2번째카드 얻는 변수.
		// 문자열로 넘어 간뒤 한번 더 문자열로 받아가지고 더블쿼테이션이 겹친다... ""1"" 이런식으로 나와서
		// numberformatException이 뜬다.
		// 중복문자열 제거로 없애줘야한다.
		// --------- jsp내부에서 JSON 데이터를 stringify로 변형하여 문자열에 문자열이 씌워져 더블 쿼테이션이 나온것이였다.
		// 현재 jsp파일은 알맞게 수정 한 상태이다. 이제 numberformatException이 뜨지 않으므로 처음과 같이 계획한대로 가능하다!

		// 일단 넘어온 값이 맞나 테스트
//		System.out.println("firstCard : " + first);
//		System.out.println("secondCard : " + second);
		// ㅇㅋ 확인

		// 진입 페이지에서 생성된 플레이어의 카드를 받아와 변수에 대입.
		String firstHanded = (String) session.getAttribute("firstCard");
		String secondHanded = (String) session.getAttribute("secondCard");
		
		// 페이지의 카운트 변수를 가져와 확인해봐야한다
		int pageCount = (int) session.getAttribute("pageCount");
//		System.out.println("ajax에서 넘어온 페이지 카운트 변수 : " + pageCount);
//		System.out.println("ajax에서 넘어온 req.getAttr 페이지 카운트 변수 : " + req.getAttribute("pageCount"));
//		System.out.println("ajax에서 넘어온 req.getParam 페이지 카운트 변수 : " + req.getParameter("pageCount"));
		// jsp 테스트 출력은 성공했으나 컨트롤러 안에서 결과가 다르다. 진입부에서 넘겨준 1을 그대로 받아옴;

		// 컨트롤러 부분 세션 아이디 확인
//		System.out.println("컨트롤러 세션 아이디 : " + session.getId());

		// 승부 판별용 점수만 따로 계산
		int firstHandedNum;
		int secondHandedNum;

		// 페이지 진입시에 받은 카드를 이쪽 컨트롤러로 넘겨받았다, 그 값은 문자열이며 광도 섞여있는데 "광"이 섞여있는 경우
		// parseint로 타입변환을 하지 못하여 500에러가 난다. 좀 길지만 if문으로 레벨디자인 했던 숫자로 강제변환 해주어야 한다.
		// 여기서 다시한번 느꼈다. 승부 판정을 레벨디자인 변수를 만들어둔건 진짜 이세돌의 백78수였다.

		if (firstHanded.equals("1광")) {
			firstHandedNum = FIRST_LIGHT_NUM;
		} else if (firstHanded.equals("3광")) {
			firstHandedNum = THIRD_LIGHT_NUM;
		} else if (firstHanded.equals("8광")) {
			firstHandedNum = EIGHTH_LIGHT_NUM;
		} else {
			firstHandedNum = Integer.parseInt(firstHanded);
		}

		if (secondHanded.equals("1광")) {
			secondHandedNum = FIRST_LIGHT_NUM;
		} else if (secondHanded.equals("3광")) {
			secondHandedNum = THIRD_LIGHT_NUM;
		} else if (secondHanded.equals("8광")) {
			secondHandedNum = EIGHTH_LIGHT_NUM;
		} else {
			secondHandedNum = Integer.parseInt(secondHanded);
		}
		// 1번 플레이어 총 합 점수
		int firstPlayerTotalScore = firstHandedNum + secondHandedNum;

		// 2번 플레이어의 1번째 카드, 2번째 카드 얻는 변수.
		String firstHandedSecondPlayer = carddeck.getCards().get(1).getCardNum();
		String secondHandedSecondPlayer = carddeck.getCards().get(3).getCardNum();
		// 2번 플레이어 승부 판별용 점수
		int secFirstHandedNum = carddeck.getCards().get(1).getNum();
		int secSecondHandedNum = carddeck.getCards().get(3).getNum();
		// 2번 플레이어 총 합 점수
		int secondPlayerTotalScore = secFirstHandedNum + secSecondHandedNum;

		// ----------------------------------------------------------

		// 승부 가르기
		// 승부는 까다롭다. 이긴 플레이어에 따라서 점수를 계산해야한다.
		// [1] 광땡을 먼저 계산. 13, 18, 38이 있고 38광땡은 최대 레벨이므로 모든 패를 이긴다. 13광땡과 18광땡은 확률이 동일하므로
		// 동일레벨로본다.
		// [2] 13, 18 광땡은 38광땡만 못이긴다.
		// [3] 땡은 순서대로 10 9 8...1 땡으로 큰 수부터 서열순으로 정렬된다. 모든 땡은 모든 광땡을 이기지 못한다.
		// [4] 모든 끗은 모든 땡 종류를 이기지 못하고 끗 내에서만 정리가된다.
		// [5] 단순 패들의 숫자 합이 더 높다고 이기는게 아니다. 1땡같은 경우는 숫자 총 합이 2이지만 숫자 총합이 9인 9끗을 가볍게이긴다.
		// [6] 점수가 더 높은쪽의 플레이어가 승리한다는 조건을 걸되 반대쪽 플레이어의 패검사도 반드시 이루어져야한다.
		// [7] 무승부여도 4끗과 2땡은 엄연히 다르다. 무승부 마저도 조건검사를 걸어야한다.
		// -- 위의 조건들을 만족하기 위해선 등급을 판별하는 객체를 따로 만들어서 검사를 해 줄 경우 편리해진다. 하나 더 만들자.
		// [8] 1번카드와 2번카드를 각각 개별 객체로 나누면 까다로워진다. 손에 들어온 패는 무조건 순서를 지킬 필요는없다. 만약
		// 작은 패를 앞쪽으로 넣어주면 조건이 매우 편해진다.

		// [8] 작은 패 먼저 앞으로 옮기기.
		// 1번 플레이어
		if (firstHandedNum > secondHandedNum) {
			temp1 = firstHandedNum;
			firstHandedNum = secondHandedNum;
			secondHandedNum = temp1;
		}
		// 2번 플레이어
		if (secFirstHandedNum > secSecondHandedNum) {
			temp2 = secFirstHandedNum;
			secFirstHandedNum = secSecondHandedNum;
			secSecondHandedNum = temp2;
		}

		// [1] 광땡 계산하기
		// 1번 플레이어 레벨검사
		if (firstHandedNum == THIRD_LIGHT_NUM && secondHandedNum == EIGHTH_LIGHT_NUM) {
			firstPlayerDeckLevel = "38광땡";
			firstPlayerLevel = 100;
		} else if (firstHandedNum == FIRST_LIGHT_NUM && secondHandedNum == THIRD_LIGHT_NUM) {
			firstPlayerDeckLevel = "13광땡";
			firstPlayerLevel = 99;
		} else if (firstHandedNum == FIRST_LIGHT_NUM && secondHandedNum == EIGHTH_LIGHT_NUM) {
			firstPlayerDeckLevel = "18광땡";
			firstPlayerLevel = 99;
		}
		// 2번 플레이어 레벨검사
		if (secFirstHandedNum == THIRD_LIGHT_NUM && secSecondHandedNum == EIGHTH_LIGHT_NUM) {
			secondPlayerDeckLevel = "38광땡";
			secondPlayerLevel = 100;
		} else if (secFirstHandedNum == FIRST_LIGHT_NUM && secSecondHandedNum == THIRD_LIGHT_NUM) {
			secondPlayerDeckLevel = "13광땡";
			secondPlayerLevel = 99;
		} else if (secFirstHandedNum == FIRST_LIGHT_NUM && secSecondHandedNum == EIGHTH_LIGHT_NUM) {
			secondPlayerDeckLevel = "18광땡";
			secondPlayerLevel = 99;
		}
		// [2] 땡계산
		// 1번 플레이어 계산
		if (firstHandedNum == 10 && secondHandedNum == 10) {
			firstPlayerDeckLevel = "장땡";
			firstPlayerLevel = 50;
		} else if (firstHandedNum == 9 && secondHandedNum == 9) {
			firstPlayerDeckLevel = "구땡";
			firstPlayerLevel = 49;
		} else if (firstHandedNum == 8 && secondHandedNum == EIGHTH_LIGHT_NUM) {
			firstPlayerDeckLevel = "팔땡";
			firstPlayerLevel = 48;
		} else if (firstHandedNum == 7 && secondHandedNum == 7) {
			firstPlayerDeckLevel = "칠땡";
			firstPlayerLevel = 47;
		} else if (firstHandedNum == 6 && secondHandedNum == 6) {
			firstPlayerDeckLevel = "육땡";
			firstPlayerLevel = 46;
		} else if (firstHandedNum == 5 && secondHandedNum == 5) {
			firstPlayerDeckLevel = "오땡";
			firstPlayerLevel = 45;
		} else if (firstHandedNum == 4 && secondHandedNum == 4) {
			firstPlayerDeckLevel = "사땡";
			firstPlayerLevel = 44;
		} else if (firstHandedNum == 3 && secondHandedNum == THIRD_LIGHT_NUM) {
			firstPlayerDeckLevel = "삼땡";
			firstPlayerLevel = 43;
		} else if (firstHandedNum == 2 && secondHandedNum == 2) {
			firstPlayerDeckLevel = "이땡";
			firstPlayerLevel = 42;
		} else if (firstHandedNum == 1 && secondHandedNum == FIRST_LIGHT_NUM) {
			firstPlayerDeckLevel = "일땡";
			firstPlayerLevel = 41;
		}

		// 2번 플레이어
		if (secFirstHandedNum == 10 && secSecondHandedNum == 10) {
			secondPlayerDeckLevel = "장땡";
			secondPlayerLevel = 50;
		} else if (secFirstHandedNum == 9 && secSecondHandedNum == 9) {
			secondPlayerDeckLevel = "구땡";
			secondPlayerLevel = 49;
		} else if (secFirstHandedNum == 8 && secSecondHandedNum == EIGHTH_LIGHT_NUM) {
			secondPlayerDeckLevel = "팔땡";
			secondPlayerLevel = 48;
		} else if (secFirstHandedNum == 7 && secSecondHandedNum == 7) {
			secondPlayerDeckLevel = "칠땡";
			secondPlayerLevel = 47;
		} else if (secFirstHandedNum == 6 && secSecondHandedNum == 6) {
			secondPlayerDeckLevel = "육땡";
			secondPlayerLevel = 46;
		} else if (secFirstHandedNum == 5 && secSecondHandedNum == 5) {
			secondPlayerDeckLevel = "오땡";
			secondPlayerLevel = 45;
		} else if (secFirstHandedNum == 4 && secSecondHandedNum == 4) {
			secondPlayerDeckLevel = "사땡";
			secondPlayerLevel = 44;
		} else if (secFirstHandedNum == 3 && secSecondHandedNum == THIRD_LIGHT_NUM) {
			secondPlayerDeckLevel = "삼땡";
			secondPlayerLevel = 43;
		} else if (secFirstHandedNum == 2 && secSecondHandedNum == 2) {
			secondPlayerDeckLevel = "이땡";
			secondPlayerLevel = 42;
		} else if (secFirstHandedNum == 1 && secSecondHandedNum == FIRST_LIGHT_NUM) {
			secondPlayerDeckLevel = "일땡";
			secondPlayerLevel = 41;
		}

		// 무승부
		if ((firstPlayerTotalScore % 10) == (secondPlayerTotalScore % 10)) {
			result = "무승부네요!";
		}

		// 레벨과 총합계점수로 최종판별 (레벨 : 땡판별 / 합계점수 : 끗판별)
		// 1번 플레이어
		if (firstPlayerLevel > secondPlayerLevel) {
			result = "플레이어가 " + firstPlayerDeckLevel + " 으로 이겼습니다!";
		} else if (firstPlayerTotalScore % 10 > secondPlayerTotalScore % 10) {
			result = "플레이어가 " + firstPlayerTotalScore % 10 + " 끗으로 이겼습니다!";
		}
		// 2번 플레이어
		if (firstPlayerLevel < secondPlayerLevel) {
			result = "딜러가 " + secondPlayerDeckLevel + " 으로 이겼습니다!";
		} else if (firstPlayerTotalScore % 10 < secondPlayerTotalScore % 10) {
			result = "딜러가 " + secondPlayerTotalScore % 10 + " 끗으로 이겼습니다!";
		}
		
		
		// 승부 판별 종료.
		// [1] 레벨 변수 하나 만들어서 관리하길 너무잘함.
		// 단순 숫자만 놓고 보는 블랙잭과는 달리 섯다는 족보란게 존재하여 단순 숫자가 낮아도 상대방을 이길 수 있는 패가 매우 많음.
		// 이에 착안하여 level을 판별하는 변수를 추가. => 박수짝짝

		// [2] 1번카드 2번카드는 프로그래밍일 뿐 현실에선 순서가 중요하지 않다는 점에 착안하여 생각을 바꿔봄.
		// 바꾼 생각 -> 숫자가 작은걸 앞쪽에 몰아넣자. 어차피 결과점수는 똑같다. => 매우 잘한일, 코드 단축 및 생산성이 극대화됨.

		
		// 어떤 카드를 받았는지를 넣어주고 카드 리스트에 추가.
		// 딜러의 1번째 카드
		card2.setCardNum(firstHandedSecondPlayer);
		// 카드 추가
		secondCardList.add(card2);

		// 두번째 카드
		card2 = new Card();
		card2.setCardNum(secondHandedSecondPlayer);
		secondCardList.add(card2);

		Map<String, Object> cardList = new HashMap<>();
		cardList.put("cardList2", secondCardList);
		cardList.put("result", result);

		return cardList;
	}

}
