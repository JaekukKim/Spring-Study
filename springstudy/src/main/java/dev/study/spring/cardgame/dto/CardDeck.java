package dev.study.spring.cardgame.dto;

//------------------------------------------------------------------------------------------------------------
//---------------------------------TODO cardgame 패키지 탑다운 반드시할것 ------------------------------------
//------------------------------------------------------------------------------------------------------------

import java.util.Collections;
import java.util.Stack;

import dev.study.spring.studywhilemakingofseotda.Card;

public class CardDeck {
	private Stack<Card> cards;
	private static final String[] DECK_NUMBER = {"광덱","일반덱"};
	private static final int CARD_NUM = 10;

	public CardDeck() {
		cards = new Stack<>();
		
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

	public Stack<Card> getCards() {
		return cards;
	}

	public void setCards(Stack<Card> cards) {
		this.cards = cards;
	}
	
	@Override
	public String toString() {
		for(Card card : cards) {
			System.out.println(card.toString());
		}
		return "";
	}
}
