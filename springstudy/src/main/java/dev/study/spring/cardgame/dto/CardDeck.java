package dev.study.spring.cardgame.dto;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {

	private Stack<CardDTO> cards;
	private static final int CARD_NUM = 10;

	public CardDeck() {
		cards = new Stack<>();
		
		for (int number = 1; number <= CARD_NUM; number++) {		
			CardDTO card = new CardDTO(false, number);
			CardDTO specialCard = new CardDTO(true, number);
			cards.push(card);
			cards.push(specialCard);
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Stack<CardDTO> getCards() {
		return cards;
	}

	public void setCards(Stack<CardDTO> cards) {
		this.cards = cards;
	}
	
	@Override
	public String toString() {
		for(CardDTO card : cards) {
			System.out.println(card.toString());
		}
		return "";
	}
}
