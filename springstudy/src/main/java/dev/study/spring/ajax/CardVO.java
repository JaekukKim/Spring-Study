package dev.study.spring.ajax;

public class CardVO {
	private int number;
	private String pattern;
	
	public CardVO() {
		// TODO Auto-generated constructor stub
	}
	
	public CardVO (int number, String pattern) {
		this.number=number;
		this.pattern=pattern;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	
}
