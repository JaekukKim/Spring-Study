package dev.study.spring.cardgame.dto;

import java.util.Stack;


public class GameStatus {
	private Stack<CardDTO> cards;
	private CardDTO firstCard;
	private CardDTO secondCard;
	
	public GameStatus() {
	}
	
	public GameStatus(Stack<CardDTO> cards, CardDTO firstCard, CardDTO secondCard) {
		this.cards = cards;
		this.firstCard = firstCard;
		this.secondCard = secondCard;
	}

	public Stack<CardDTO> getCards() {
		return cards;
	}

	public CardDTO getFirstCard() {
		return firstCard;
	}

	public CardDTO getSecondCard() {
		return secondCard;
	}


	
	
}
