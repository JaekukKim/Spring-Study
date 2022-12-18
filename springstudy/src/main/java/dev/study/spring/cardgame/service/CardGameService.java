package dev.study.spring.cardgame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import dev.study.spring.cardgame.dto.CardDTO;
import dev.study.spring.cardgame.dto.CardDeck;
import dev.study.spring.cardgame.dto.GameResult;
import dev.study.spring.cardgame.dto.GameStatus;
import dev.study.spring.cardgame.enums.HandResult;
import dev.study.spring.cardgame.util.CalculateScoreUtil;

@Service
public class CardGameService {

	private static final String GAME_STATUS = "gameStatus";
	// 게임 시스템 관리 객체를 만들어주면 혹시나 다른 사람이 접속했을 때를 대비해 게임의 진행 상황을 저장하여야 한다.
	// 저장을 하는 키 값으로 gameStatus를 입력해도 되지만 게임의 진행 상황이라는 "키"는 변하지 않음, 즉 정적이기 때문에 상수로 선언해준다.

	public String gameInit(HttpServletRequest req) {
		// 이제 이 SecurityAjaxSeotdaController 부분에선 웹 브라우저에서 데브툴즈로 값이 조작 가능 한 점을 파악하여 그것을
		// 방지하기 위한
		// 카드에 쿠키 세션 값을 입혀주어 보안? 까지 강화시키는 버전을 만들어 볼려고한다.

		// 먼저 쿠키는 보안성이 세션에 비해 안좋으므로 세션 객체를 생성한다. 세션은 서버에 저장되어 관리되기 때문.
		HttpSession cardSession = req.getSession();

		CardDeck cardDeck = new CardDeck();
		cardDeck.shuffle();

		// 1번 플레이어의 1번째카드, 2번째카드 얻는 변수.
		Stack<CardDTO> cards = cardDeck.getCards();
		CardDTO firstHanded = cards.pop();
		CardDTO secondHanded = cards.pop();
		// 세션 아이디 확인
		System.out.println("jsp입장 세션 아이디 : " + cardSession.getId());

		// 게임 상태를 담는 객체 (전체상태)
		// TODO firstHanded, secondHanded => convert to Card Object 
		// TODO GameStatus field, getDeck method logic 
		GameStatus gameStatus = new GameStatus(cards, firstHanded, secondHanded);

		// 값을 session에 추가
		cardSession.setAttribute(GAME_STATUS, gameStatus);

		return "toyprj/securityajaxjsphouse";
	}

	public GameResult getDeck(HttpSession session, HttpServletRequest req) {

		List<CardDTO> secondCardList = new ArrayList<>();

		// 1번 플레이어는 진입부분에서 생성함.
		// 2번 플레이어 카드 객체 생성
		CardDTO card = new CardDTO();

		// 매직넘버 방지용 광패 변수, 광은 하나밖에 없는 패 이므로 final로 설정
		final int FIRST_LIGHT_NUM = CalculateScoreUtil.FIRST_LIGHT_NUM;
		final int THIRD_LIGHT_NUM = CalculateScoreUtil.THIRD_LIGHT_NUM;
		final int EIGHTH_LIGHT_NUM = CalculateScoreUtil.EIGHTH_LIGHT_NUM;

		// 게임이 시작할때 만들어진 카드덱을 그대로 가져와 이용할수 있게 만듬.
		Object statusObject = session.getAttribute(GAME_STATUS);
		GameStatus gameStatus;
		if (Objects.nonNull(statusObject)) {
			if (statusObject instanceof GameStatus) {
				gameStatus = (GameStatus) statusObject;
			} else {
				// type mismatch
				throw new RuntimeException("statusObject type mismatch!");
			}
		} else {
			// game init
			throw new RuntimeException("new game required!");
		}

		// -----------------------------------------------------------------------------
		// 1번 플레이어의 1번째카드, 2번째카드 얻는 변수.
		// 문자열로 넘어 간뒤 한번 더 문자열로 받아가지고 더블쿼테이션이 겹친다... ""1"" 이런식으로 나와서
		// numberformatException이 뜬다.
		// 중복문자열 제거로 없애줘야한다.
		// --------- jsp내부에서 JSON 데이터를 stringify로 변형하여 문자열에 문자열이 씌워져 더블 쿼테이션이 나온것이였다.
		// 현재 jsp파일은 알맞게 수정 한 상태이다. 이제 numberformatException이 뜨지 않으므로 처음과 같이 계획한대로 가능하다!

		CardDTO firstHanded = gameStatus.getFirstCard();
		CardDTO secondHanded = gameStatus.getSecondCard();

		// 컨트롤러 부분 세션 아이디 확인
		System.out.println("컨트롤러 세션 아이디 : " + session.getId());

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
			firstHandedNum = firstHanded.getNumber();
		}

		if (secondHanded.equals("1광")) {
			secondHandedNum = FIRST_LIGHT_NUM;
		} else if (secondHanded.equals("3광")) {
			secondHandedNum = THIRD_LIGHT_NUM;
		} else if (secondHanded.equals("8광")) {
			secondHandedNum = EIGHTH_LIGHT_NUM;
		} else {
			secondHandedNum = secondHanded.getNumber();
		}
		// 1번 플레이어 총 합 점수
		int firstPlayerTotalScore = firstHandedNum + secondHandedNum;

		// 2번 플레이어의 1번째 카드, 2번째 카드 얻는 변수.
		Stack<CardDTO> cards = gameStatus.getCards();
		CardDTO firstDealerCard = cards.pop();
		CardDTO secondDealerCard = cards.pop();

		int firstHandedSecondPlayer = firstDealerCard.getNumber();
		int secondHandedSecondPlayer = secondDealerCard.getNumber();
		// 이미 플레이어는 패를 2장을 가져간 상태 이 상태에서 pop()를 해주면 가져간 패를 제외
		// 2번 플레이어 총 합 점수
		int secondPlayerTotalScore = firstHandedSecondPlayer + secondHandedSecondPlayer;

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

		// 작은 패 먼저 앞으로 옮기기.
		// 플레이어
		int playerFirstHandNum = Math.min(firstHandedNum, secondHandedNum);
		int playerSecondHandNum = Math.max(firstHandedNum, secondHandedNum);

		// 딜러
		int dealerFirstHandNum = Math.min(firstHandedSecondPlayer, secondHandedSecondPlayer);
		int dealerSecondHandNum = Math.max(firstHandedSecondPlayer, secondHandedSecondPlayer);

		// 플레이어의 광땡과 땡을 검사해주는걸 한줄로 (enum (class명 : CalculateScoreUtil) 사용)
		HandResult playerHandResult = CalculateScoreUtil.getHandResult(playerFirstHandNum, playerSecondHandNum);

		// 딜러의 광땡과 땡을 검사해주는걸 한줄로 (enum (class명 : CalculateScoreUtil) 사용)
		HandResult dealerHandResult = CalculateScoreUtil.getHandResult(dealerFirstHandNum, dealerSecondHandNum);
		// [1] 가져온 데이터를 변수에 담는 습관을 들이자.
		
		String announceResult = CalculateScoreUtil.getAnnounceMessage(firstPlayerTotalScore, secondPlayerTotalScore, playerHandResult, dealerHandResult);
		// 값이 자주 바뀌거나 역동적인 메소드, 변수 등에는 static을 선언해주면 안된다.
		// 단어 뜻 그대로 (static : 정적이다) 역할에 맞게 사용해주어야 한다.

		// 어떤 카드를 받았는지를 넣어주고 카드 리스트에 추가.
		// 딜러의 1번째 카드

		// 카드 추가
		secondCardList.add(firstDealerCard);

		secondCardList.add(secondDealerCard);

		GameResult gameResult = new GameResult(secondCardList, announceResult);

		return gameResult;
	}
}
