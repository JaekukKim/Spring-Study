package dev.study.spring.toy;

public class Card {
	private String deckNum;
	private String cardNum;
	private int num;
	
	
	public Card(String deckNum, String cardNum, int num) {
		this.deckNum=deckNum;
		this.cardNum=cardNum;
		this.num=num;
	}
	public String getDeckNum() {
		return deckNum;
	}
	public void setDeckNum(String deckNum) {
		this.deckNum = deckNum;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "[" + deckNum + ", " + cardNum + "]";
	}
	
}
