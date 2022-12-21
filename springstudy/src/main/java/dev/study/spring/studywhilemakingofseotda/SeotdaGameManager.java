package dev.study.spring.studywhilemakingofseotda;


// ----------------------------------------------------------------------------------
// ------------------------------TODO 리팩토링 임시보류------------------------------
//-----------------------------------------------------------------------------------


public class SeotdaGameManager {

	// 매직넘버 방지용 광 변수 생성 (final)
	final int FIRST_LIGHT_NUM = 11;
	final int THIRD_LIGHT_NUM = 13;
	final int EIGHTH_LIGHT_NUM = 18;

	int firstHandedNum;
	int secondHandedNum;

	// 카드 값을 변환해주는 메소드
	public int translateCardValue(String playerFirstCard, String playerSecondCard) {
		
		if (playerFirstCard.equals("1광")) {
			firstHandedNum = FIRST_LIGHT_NUM;
		} else if (playerFirstCard.equals("3광")) {
			firstHandedNum = THIRD_LIGHT_NUM;
		} else if (playerFirstCard.equals("8광")) {
			firstHandedNum = EIGHTH_LIGHT_NUM;
		} else {
			firstHandedNum = Integer.parseInt(playerFirstCard);
		}

		if (playerSecondCard.equals("1광")) {
			secondHandedNum = FIRST_LIGHT_NUM;
		} else if (playerSecondCard.equals("3광")) {
			secondHandedNum = THIRD_LIGHT_NUM;
		} else if (playerSecondCard.equals("8광")) {
			secondHandedNum = EIGHTH_LIGHT_NUM;
		} else {
			secondHandedNum = Integer.parseInt(playerSecondCard);
		}
		// 1번 플레이어 총 합 점수
		int firstPlayerTotalScore = firstHandedNum + secondHandedNum;
		return firstPlayerTotalScore;
	}

	// 승자를 판별해주는 메소드
//	public String matchOutput(String playerFirstCard, String playerSecondCard, String dealerFirstCard,
//			String dealerSecondCard) {
//		int firstPlayerLevel = 0;
//		int secondPlayerLevel = 0;
//
//		// 결과를 저장하고 출력할 문자열 생성
//		String result = "";
//		// 패 등급의 명칭을 담을 변수
//		String firstPlayerDeckLevel = "";
//		String secondPlayerDeckLevel = "";
//
//		if (firstHandedNum == THIRD_LIGHT_NUM && secondHandedNum == EIGHTH_LIGHT_NUM) {
//			firstPlayerDeckLevel = "38광땡";
//			firstPlayerLevel = 100;
//		} else if (firstHandedNum == FIRST_LIGHT_NUM && secondHandedNum == THIRD_LIGHT_NUM) {
//			firstPlayerDeckLevel = "13광땡";
//			firstPlayerLevel = 99;
//		} else if (firstHandedNum == FIRST_LIGHT_NUM && secondHandedNum == EIGHTH_LIGHT_NUM) {
//			firstPlayerDeckLevel = "18광땡";
//			firstPlayerLevel = 99;
//		}
//		// 2번 플레이어 레벨검사
//		if (secFirstHandedNum == THIRD_LIGHT_NUM && secSecondHandedNum == EIGHTH_LIGHT_NUM) {
//			secondPlayerDeckLevel = "38광땡";
//			secondPlayerLevel = 100;
//		} else if (secFirstHandedNum == FIRST_LIGHT_NUM && secSecondHandedNum == THIRD_LIGHT_NUM) {
//			secondPlayerDeckLevel = "13광땡";
//			secondPlayerLevel = 99;
//		} else if (secFirstHandedNum == FIRST_LIGHT_NUM && secSecondHandedNum == EIGHTH_LIGHT_NUM) {
//			secondPlayerDeckLevel = "18광땡";
//			secondPlayerLevel = 99;
//		}
//		// [2] 땡계산
//		// 1번 플레이어 계산
//		if (firstHandedNum == 10 && secondHandedNum == 10) {
//			firstPlayerDeckLevel = "장땡";
//			firstPlayerLevel = 50;
//		} else if (firstHandedNum == 9 && secondHandedNum == 9) {
//			firstPlayerDeckLevel = "구땡";
//			firstPlayerLevel = 49;
//		} else if (firstHandedNum == 8 && secondHandedNum == EIGHTH_LIGHT_NUM) {
//			firstPlayerDeckLevel = "팔땡";
//			firstPlayerLevel = 48;
//		} else if (firstHandedNum == 7 && secondHandedNum == 7) {
//			firstPlayerDeckLevel = "칠땡";
//			firstPlayerLevel = 47;
//		} else if (firstHandedNum == 6 && secondHandedNum == 6) {
//			firstPlayerDeckLevel = "육땡";
//			firstPlayerLevel = 46;
//		} else if (firstHandedNum == 5 && secondHandedNum == 5) {
//			firstPlayerDeckLevel = "오땡";
//			firstPlayerLevel = 45;
//		} else if (firstHandedNum == 4 && secondHandedNum == 4) {
//			firstPlayerDeckLevel = "사땡";
//			firstPlayerLevel = 44;
//		} else if (firstHandedNum == 3 && secondHandedNum == THIRD_LIGHT_NUM) {
//			firstPlayerDeckLevel = "삼땡";
//			firstPlayerLevel = 43;
//		} else if (firstHandedNum == 2 && secondHandedNum == 2) {
//			firstPlayerDeckLevel = "이땡";
//			firstPlayerLevel = 42;
//		} else if (firstHandedNum == 1 && secondHandedNum == FIRST_LIGHT_NUM) {
//			firstPlayerDeckLevel = "일땡";
//			firstPlayerLevel = 41;
//		}
//
//		// 2번 플레이어
//		if (secFirstHandedNum == 10 && secSecondHandedNum == 10) {
//			secondPlayerDeckLevel = "장땡";
//			secondPlayerLevel = 50;
//		} else if (secFirstHandedNum == 9 && secSecondHandedNum == 9) {
//			secondPlayerDeckLevel = "구땡";
//			secondPlayerLevel = 49;
//		} else if (secFirstHandedNum == 8 && secSecondHandedNum == EIGHTH_LIGHT_NUM) {
//			secondPlayerDeckLevel = "팔땡";
//			secondPlayerLevel = 48;
//		} else if (secFirstHandedNum == 7 && secSecondHandedNum == 7) {
//			secondPlayerDeckLevel = "칠땡";
//			secondPlayerLevel = 47;
//		} else if (secFirstHandedNum == 6 && secSecondHandedNum == 6) {
//			secondPlayerDeckLevel = "육땡";
//			secondPlayerLevel = 46;
//		} else if (secFirstHandedNum == 5 && secSecondHandedNum == 5) {
//			secondPlayerDeckLevel = "오땡";
//			secondPlayerLevel = 45;
//		} else if (secFirstHandedNum == 4 && secSecondHandedNum == 4) {
//			secondPlayerDeckLevel = "사땡";
//			secondPlayerLevel = 44;
//		} else if (secFirstHandedNum == 3 && secSecondHandedNum == THIRD_LIGHT_NUM) {
//			secondPlayerDeckLevel = "삼땡";
//			secondPlayerLevel = 43;
//		} else if (secFirstHandedNum == 2 && secSecondHandedNum == 2) {
//			secondPlayerDeckLevel = "이땡";
//			secondPlayerLevel = 42;
//		} else if (secFirstHandedNum == 1 && secSecondHandedNum == FIRST_LIGHT_NUM) {
//			secondPlayerDeckLevel = "일땡";
//			secondPlayerLevel = 41;
//		}
//
//		// 무승부
//		if ((firstPlayerTotalScore % 10) == (secondPlayerTotalScore % 10)) {
//			result = "무승부네요!";
//		}
//
//		// 레벨과 총합계점수로 최종판별 (레벨 : 땡판별 / 합계점수 : 끗판별)
//		// 1번 플레이어
//		if (firstPlayerLevel > secondPlayerLevel) {
//			result = "1번 플레이어가 " + firstPlayerDeckLevel + " 으로 이겼습니다!";
//		} else if (firstPlayerTotalScore % 10 > secondPlayerTotalScore % 10) {
//			result = "1번 플레이어가 " + firstPlayerTotalScore % 10 + " 끗으로 이겼습니다!";
//		}
//		// 2번 플레이어
//		if (firstPlayerLevel < secondPlayerLevel) {
//			result = "2번 플레이어가 " + secondPlayerDeckLevel + " 으로 이겼습니다!";
//		} else if (firstPlayerTotalScore % 10 < secondPlayerTotalScore % 10) {
//			result = "2번 플레이어가 " + secondPlayerTotalScore % 10 + " 끗으로 이겼습니다!";
//		}
//		return result;
//	}
}
