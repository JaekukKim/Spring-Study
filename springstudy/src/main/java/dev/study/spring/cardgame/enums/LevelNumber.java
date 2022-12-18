package dev.study.spring.cardgame.enums;

public enum LevelNumber {
	THREE_EIGHT(11, 20, "38", "삼팔"),
	ONE_THREE(4, 15, "13", "일삼"),
	ONE_EIGHT(9, 15, "18", "일팔");

	private int sum;
	private int cardLevelNumber;
	private String number;
	private String koreaDiction;
	
	LevelNumber(int sum, int cardLevelNumber, String number, String koreaDiction) {
		this.sum = sum;
		this.cardLevelNumber = cardLevelNumber;
		this.number = number;
		this.koreaDiction = koreaDiction;
		
	}

	public static LevelNumber parseSum(int sum) {
		LevelNumber[] levelNumbers = LevelNumber.values();
		for (LevelNumber levelNumber : levelNumbers) {
			if(levelNumber.getSum() == sum) {
				return levelNumber;
			}
		}
		throw new RuntimeException("only LIGHT_MADE");
	}

	public int getSum() {
		return sum;
	}

	public int getCardLevelNumber() {
		return cardLevelNumber;
	}

	public String getNumber() {
		return number;
	}

	public String getKoreaDiction() {
		return koreaDiction;
	}
	
	

}
