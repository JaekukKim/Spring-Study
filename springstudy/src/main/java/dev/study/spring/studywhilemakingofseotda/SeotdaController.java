package dev.study.spring.studywhilemakingofseotda;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SeotdaController {

	@RequestMapping(value = "/dobak")
	public String getDeck(HttpServletRequest req, Model model) {
		CardDeck cd = new CardDeck();

		cd.shuffle();
		String first = cd.getCards().get(0).getCardNum();
		String second = cd.getCards().get(2).getCardNum();
		String result = "";
		
		int sum = (cd.getCards().get(0).getNum() + cd.getCards().get(2).getNum()) % 10;
		
		if (first.equals(second)) {
			result = first + "땡 입니다!";
		} else {
			result = sum + "끗 입니다.";
		}
		if (sum==0) {
			result = "망통이네요...";
		}
		
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		model.addAttribute("result", result);
		
		return "toyprj/house";
	}
}
