//package dev.study.spring.cardgame.dto;
//
//import java.util.Arrays;
//import java.util.List;
//
//import dev.study.spring.cardgame.enums.LevelName;
//import dev.study.spring.cardgame.enums.LevelNumber;
//
//public class PairCard {
//
//	private final Card card1;
//	private final Card card2;
//	private static final List<Integer> magicNumbers = Arrays.asList(1, 3, 8);
//	
//	// constructor
//	public PairCard(Card card1, Card card2) {
//		this.card1 = card1;
//		this.card2 = card2;
//	}
//	
//	public newResult getResult() {
//		boolean card1Special = card1.isSpecial();
//		int card1Number = card1.getNumber();
//
//		boolean card2Special = card2.isSpecial();
//		int card2Number = card2.getNumber();
//
//		int totalScore = card1Number + card2Number;
//		
//		if (card1Number == card2Number) {
//			return card1Number + "땡";
//		}
//		
//		boolean bothSpecial = card1Special && card2Special;
//		boolean isCard1MagicNumber = magicNumbers.contains(card1Number);
//		boolean isCard2MagicNumber = magicNumbers.contains(card2Number);
//
//		LevelName levelName;
//		
//		if(bothSpecial && isCard1MagicNumber && isCard2MagicNumber) {
//			// rhkdEod
//			int magicNumberSum = card1Number + card2Number;
//			LevelNumber levelNumber = LevelNumber.parseSum(magicNumberSum);
//			levelName = LevelName.LIGHT_MADE;
//			new Result(levelNumber.getNumber(), levelName);
//			
//			return card1Number + "" + card2Number + "광땡 입니다!";
//		}
//		
//		// Rmt rngkrl
//		return 
//	}
//	
//	// getter
//}
