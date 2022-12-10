package dev.study.spring.toy;

public class Card {
	private String deckNum;
	private String cardNum;
	private int num;
	
	
	public Card(String cardNum, String deckNum, int num) {
		this.cardNum=cardNum;
		this.deckNum=deckNum;
		this.num=num;
	}
	public Card() {
		// TODO Auto-generated constructor stub
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
		return "[cardNum=" + cardNum + "]";
	}
	
}
