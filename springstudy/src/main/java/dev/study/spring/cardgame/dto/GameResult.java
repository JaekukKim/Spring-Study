package dev.study.spring.cardgame.dto;

import java.io.Serializable;
import java.util.List;

import dev.study.spring.studywhilemakingofseotda.Card;


public class GameResult implements Serializable{

	private List<Card> secondCardList;
	private String result;
	
	public GameResult() {
	}
	
	public GameResult(List<Card> secondCardList, String result) {
		this.secondCardList = secondCardList;
		this.result = result;
	}

	public List<Card> getSecondCardList() {
		return secondCardList;
	}

	public String getResult() {
		return result;
	}
	
}
