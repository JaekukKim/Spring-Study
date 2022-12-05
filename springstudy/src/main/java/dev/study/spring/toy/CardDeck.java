package dev.study.spring.toy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	private List<Card> cards;
	private static final String[] DECK_NUMBER = {"광덱","일반덱"};
	private static final int CARD_NUM = 10;

	public CardDeck() {
		cards = new ArrayList<>();
		
		for (String deck : DECK_NUMBER) {
			for (int i = 1; i <= CARD_NUM; i++) {
				String light;
				int cardnum = i;
				
				if(deck=="광덱") {
	
					switch(i) {
					case 1:
						light = "1광";
						cardnum = 11;
						break;
					case 3:
						light = "3광";
						cardnum = 13;
						break;
					case 8:
						light = "8광";
						cardnum = 18;
						break;
						default:
							light = Integer.toString(i);
							break;
					}
				} else {
	
					light = Integer.toString(i);
				}
				Card card = new Card(light,deck,cardnum);
				cards.add(card);
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	@Override
	public String toString() {
		for(Card card : cards) {
			System.out.println(card.toString());
		}
		return "";
	}
	public static void main(String[] args) {
		CardDeck carddeck = new CardDeck();
		System.out.println(carddeck.toString());
		System.out.println(carddeck.getCards().get(7).getNum());
	}
}
