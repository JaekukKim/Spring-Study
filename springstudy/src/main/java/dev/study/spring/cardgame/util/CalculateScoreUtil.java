package dev.study.spring.cardgame.util;

import dev.study.spring.cardgame.dto.CardDTO;
import dev.study.spring.cardgame.enums.HandResult;

public class CalculateScoreUtil {

	public static final int FIRST_LIGHT_NUM = 11;
	public static final int THIRD_LIGHT_NUM = 13;
	public static final int EIGHTH_LIGHT_NUM = 18;

//	public static newHandResult getHandResult(Card card1, Card card2 ) {
//		
//	}
	
	public static HandResult getHandResult(int firstHandedNum, int secondHandedNum) {
		HandResult handResult;
		if (firstHandedNum == THIRD_LIGHT_NUM && secondHandedNum == EIGHTH_LIGHT_NUM) {
			handResult = HandResult.THREE_EIGHT_GWANG;
		} else if (firstHandedNum == FIRST_LIGHT_NUM && secondHandedNum == THIRD_LIGHT_NUM) {
			handResult = HandResult.ONE_THREE_GWANG;
		} else if (firstHandedNum == FIRST_LIGHT_NUM && secondHandedNum == EIGHTH_LIGHT_NUM) {
			handResult = HandResult.ONE_EIGHT_GWANG;
		} else if (firstHandedNum == 10 && secondHandedNum == 10) {
			handResult = HandResult.TEN_DOUBLE;
		} else if (firstHandedNum == 9 && secondHandedNum == 9) {
			handResult = HandResult.NINE_DOUBLE;
		} else if (firstHandedNum == 8 && secondHandedNum == EIGHTH_LIGHT_NUM) {
			handResult = HandResult.EIGHT_DOUBLE;
		} else if (firstHandedNum == 7 && secondHandedNum == 7) {
			handResult = HandResult.SEVEN_DOUBLE;
		} else if (firstHandedNum == 6 && secondHandedNum == 6) {
			handResult = HandResult.SIX_DOUBLE;
		} else if (firstHandedNum == 5 && secondHandedNum == 5) {
			handResult = HandResult.FIVE_DOUBLE;
		} else if (firstHandedNum == 4 && secondHandedNum == 4) {
			handResult = HandResult.FOUR_DOUBLE;
		} else if (firstHandedNum == 3 && secondHandedNum == THIRD_LIGHT_NUM) {
			handResult = HandResult.THREE_DOUBLE;
		} else if (firstHandedNum == 2 && secondHandedNum == 2) {
			handResult = HandResult.TWO_DOUBLE;
		} else if (firstHandedNum == 1 && secondHandedNum == FIRST_LIGHT_NUM) {
			handResult = HandResult.ONE_DOUBLE;
		} else {
			handResult = HandResult.NOT_MADE;
		}
		return handResult;
	}

	public static String getAnnounceMessage(int firstPlayerTotalScore, int secondPlayerTotalScore,
			HandResult playerHandResult, HandResult dealerHandResult) {
		// 플레이어의 패 등급을 판별하기 위한 변수
		int firstPlayerLevel = playerHandResult.getPowerLevel();
		int secondPlayerLevel = dealerHandResult.getPowerLevel();
		// 패 등급의 명칭을 담을 변수
		String firstPlayerDeckLevel = playerHandResult.getDeckLevel();
		String secondPlayerDeckLevel = playerHandResult.getDeckLevel();
		
		// 결과 메세지를 담을 변수.
		String result = "";
		
		// 무승부 (점수(int)로만 계산)
		if ((firstPlayerTotalScore % 10) == (secondPlayerTotalScore % 10)) {
			result = "무승부네요!";
		}
		
		// 레벨과 총합계점수로 최종판별 (레벨 : 땡판별 / 합계점수 : 끗판별)
		// 플레이어
		if (firstPlayerLevel > secondPlayerLevel) {
			result = "플레이어가 " + firstPlayerDeckLevel + " 으로 이겼습니다!";
		} else if (firstPlayerTotalScore % 10 > secondPlayerTotalScore % 10) {
			result = "플레이어가 " + firstPlayerTotalScore % 10 + " 끗으로 이겼습니다!";
		}
		// 딜러
		if (firstPlayerLevel < secondPlayerLevel) {
			result = "딜러가 " + secondPlayerDeckLevel + " 으로 이겼습니다!";
		} else if (firstPlayerTotalScore % 10 < secondPlayerTotalScore % 10) {
			result = "딜러가 " + secondPlayerTotalScore % 10 + " 끗으로 이겼습니다!";
		}
		return result;
	}
	
	
//	public static String getAnnounceMessage2(int firstPlayerTotalScore, int secondPlayerTotalScore,
//			HandResult playerHandResult, HandResult dealerHandResult) {
//		// 플레이어의 패 등급을 판별하기 위한 변수
//		int firstPlayerLevel = playerHandResult.getPowerLevel();
//		int secondPlayerLevel = dealerHandResult.getPowerLevel();
//		// 패 등급의 명칭을 담을 변수
//		String firstPlayerDeckLevel = playerHandResult.getDeckLevel();
//		String secondPlayerDeckLevel = playerHandResult.getDeckLevel();
//		
//		// 결과 메세지를 담을 변수.
//		String result = "";
//		
//		// 무승부 (점수(int)로만 계산)
//		if ((firstPlayerTotalScore % 10) == (secondPlayerTotalScore % 10)) {
//			result = "무승부네요!";
//		}
//		
//		// 레벨과 총합계점수로 최종판별 (레벨 : 땡판별 / 합계점수 : 끗판별)
//		// 플레이어
//		if (firstPlayerLevel > secondPlayerLevel) {
//			result = "플레이어가 " + firstPlayerDeckLevel + " 으로 이겼습니다!";
//		} else if (firstPlayerLevel < secondPlayerLevel) {
//			result = "딜러가 " + secondPlayerDeckLevel + " 으로 이겼습니다!";
//			
//		} else if (firstPlayerTotalScore%10 > secondPlayerTotalScore%10){
//			result = "플레이어가 " + firstPlayerTotalScore % 10 + " 끗으로 이겼습니다!";
//		} else {
//			result = "딜러가 " + secondPlayerTotalScore % 10 + " 끗으로 이겼습니다!";
//		}
//		// 딜러
////		if (firstPlayerLevel < secondPlayerLevel) {
////			result = "딜러가 " + secondPlayerDeckLevel + " 으로 이겼습니다!";
////		} else if (firstPlayerTotalScore % 10 < secondPlayerTotalScore % 10) {
////			result = "딜러가 " + secondPlayerTotalScore % 10 + " 끗으로 이겼습니다!";
////		}
//		return result;
//	}
}
