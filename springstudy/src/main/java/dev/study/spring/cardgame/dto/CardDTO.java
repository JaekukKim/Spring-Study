package dev.study.spring.cardgame.dto;

public class CardDTO {

	// true : special
	private boolean special;
	private int number;
	
	public CardDTO() {
		
	}
	
	public CardDTO(boolean special, int number) {
		this.special = special;
		this.number = number;
	}

	public boolean isSpecial() {
		return special;
	}

	public int getNumber() {
		return number;
	}
	
	
}
