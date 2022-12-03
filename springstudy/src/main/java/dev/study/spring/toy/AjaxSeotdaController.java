package dev.study.spring.toy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxSeotdaController {

	@ResponseBody
	@RequestMapping(value = "/ajaxjspdobak", method = RequestMethod.POST)
	public Map<String, Object> getDeck(@RequestParam Map<String,Object> param) {

		// 1번째 플레이어의 카드를 담을 리스트 생성
		List<Card> firstCardList = new ArrayList<>();
		// 2번째 플레이어의 카드를 담을 리스트 생성
		List<Card> secondCardList = new ArrayList<>();
		
		// 1번 플레이어 카드 객체 생성
		Card card = new Card();
		// 2번 플레이어 카드 객체 생성
		Card card2 = new Card();
		
		
		// 카드 덱 객체 생성.
		CardDeck cd = new CardDeck();
		// 섞음
		cd.shuffle();

		// 1번 플레이어의 1번째카드, 2번째카드 얻는 변수.
		String firstHanded = cd.getCards().get(0).getCardNum();
		String secondHanded = cd.getCards().get(2).getCardNum();
		
		// 2번 플레이어의 1번째 카드, 2번째 카드 얻는 변수.
		String firstHandedSecondPlayer = cd.getCards().get(1).getCardNum();
		String secondHandedSecondPlayer = cd.getCards().get(3).getCardNum();
		/*
		 * int totalHanded = (cd.getCards().get(0).getNum() +
		 * cd.getCards().get(2).getNum()) % 10; String result = "";
		 */

		// 어떤 카드를 받았는지를 넣어주고 카드 리스트에 추가.
		
		// 1번 플레이어의 1번째 카드
		card.setCardNum(firstHanded);
		// 2번 플레이어의 1번째 카드
		card2.setCardNum(firstHandedSecondPlayer);
		// 각각 카드 추가
		firstCardList.add(card);
		secondCardList.add(card2);

		// 두번째 카드
		card = new Card();
		card2 = new Card();
		
		// 마찬가지
		card.setCardNum(secondHanded);
		card2.setCardNum(secondHandedSecondPlayer);
		firstCardList.add(card);
		secondCardList.add(card2);
		
		Map<String, Object> cardList = new HashMap<>();
		cardList.put("cardList", firstCardList);
		cardList.put("cardList2", secondCardList);
		cardList.put("connect", "success");
		cardList.put("connect2", "success2");
		
		return cardList;
	}
	
	@RequestMapping(value="/firstajax", method = RequestMethod.GET)
	public String connectAjax() {
		return "toyprj/ajaxjsphouse";
	}
	
}
