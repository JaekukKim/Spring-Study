package dev.study.spring.cardgame.enums;

public enum HandResult {

	THREE_EIGHT_GWANG("38광땡", 100),
	ONE_THREE_GWANG("13광땡", 99),
	ONE_EIGHT_GWANG("18광땡", 99),
	TEN_DOUBLE("장땡", 50),
	NINE_DOUBLE("구땡", 49),
	EIGHT_DOUBLE("팔땡", 48),
	SEVEN_DOUBLE("칠땡", 47),
	SIX_DOUBLE("육땡", 46),
	FIVE_DOUBLE("오땡", 45),
	FOUR_DOUBLE("사땡", 44),
	THREE_DOUBLE("삼땡", 43),
	TWO_DOUBLE("이땡", 42),
	ONE_DOUBLE("일땡", 41),
	NOT_MADE("", 0)
	;

	
	private String deckLevel;
	private int powerLevel;
	
	HandResult(String deckLevel, int powerLevel) {
		this.deckLevel = deckLevel;
		this.powerLevel = powerLevel;
	}

	public String getDeckLevel() {
		return deckLevel;
	}

	public int getPowerLevel() {
		return powerLevel;
	}
	
	
}
