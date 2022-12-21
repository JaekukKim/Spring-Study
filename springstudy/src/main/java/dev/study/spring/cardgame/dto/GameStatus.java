package dev.study.spring.cardgame.dto;

import java.util.Stack;

import dev.study.spring.studywhilemakingofseotda.Card;


public class GameStatus {
	private Stack<Card> cards;
	private Card firstCard;
	private Card secondCard;
	
	public GameStatus() {
	}
	
	public GameStatus(Stack<Card> cards, Card firstCard, Card secondCard) {
		this.cards = cards;
		this.firstCard = firstCard;
		this.secondCard = secondCard;
	}

	public Stack<Card> getCards() {
		return cards;
	}

	public Card getFirstCard() {
		return firstCard;
	}

	public Card getSecondCard() {
		return secondCard;
	}


	
	
}
