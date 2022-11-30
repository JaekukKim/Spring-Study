package dev.study.spring.toy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxSeotdaController {

	@ResponseBody
	@RequestMapping(value = "/ajaxjspdobak", method = RequestMethod.POST)
	public Map<String, Object> getDeck(@RequestParam Map<String,Object> map) {

		// 1번째 플레이어의 카드를 담을 리스트 생성
		List<Card> playerCardList = new ArrayList<>();
		
		// 카드 객체 생성
		Card card = new Card();
		
		
		// 카드 덱 객체 생성.
		CardDeck cd = new CardDeck();
		// 섞음
		cd.shuffle();

		// 플레이어의 1번째카드, 2번째카드 얻는 변수.
		String firstHanded = cd.getCards().get(0).getCardNum();
		String secondHanded = cd.getCards().get(2).getCardNum();
		/*
		 * int totalHanded = (cd.getCards().get(0).getNum() +
		 * cd.getCards().get(2).getNum()) % 10; String result = "";
		 */

		// 어떤 카드를 받았는지를 넣어주고 카드 리스트에 추가.
		card.setCardNum(firstHanded);
		playerCardList.add(card);

		// 두번째 카드
		card = new Card();
		// 마찬가지
		card.setCardNum(secondHanded);
		playerCardList.add(card);
		
		Map<String, Object> cardList = new HashMap<>();
		cardList.put("cardList", playerCardList);
		cardList.put("connect", "success");

		// 이러면 플레이어 카드 리스트의 총 길이는 2이며 인덱스는 0과 1 존재
		// 0 = firstHanded // 1 = secondHanded
		//int a = 1;
		return cardList;
	}
	
	@RequestMapping(value="/firstajax", method = RequestMethod.GET)
	public String connectAjax() {
		return "toyprj/ajaxjsphouse";
	}
}
