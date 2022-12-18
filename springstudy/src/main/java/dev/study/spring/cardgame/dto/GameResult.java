package dev.study.spring.cardgame.dto;

import java.io.Serializable;
import java.util.List;


public class GameResult implements Serializable{

	private List<CardDTO> secondCardList;
	private String result;
	
	public GameResult() {
	}
	
	public GameResult(List<CardDTO> secondCardList, String result) {
		this.secondCardList = secondCardList;
		this.result = result;
	}

	public List<CardDTO> getSecondCardList() {
		return secondCardList;
	}

	public String getResult() {
		return result;
	}
	
}
