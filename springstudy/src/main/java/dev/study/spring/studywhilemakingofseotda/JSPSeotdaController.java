package dev.study.spring.studywhilemakingofseotda;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPSeotdaController {

	@RequestMapping(value = "/jspdobak")
	public String getDeck(HttpServletRequest req, Model model) {
		CardDeck cd = new CardDeck();

		cd.shuffle();
		String firstHanded = cd.getCards().get(0).getCardNum();
		String secondHanded = cd.getCards().get(2).getCardNum();
//		int totalHanded = cd.getCards().get(0).getNum() + cd.getCards().get(2).getNum();
		String result = "";
		
//		if (firstHanded.equals(secondHanded)) {
//			result = firstHanded + "땡입니다 !";
//		} else if (!firstHanded.equals(secondHanded)) {
//			result = totalHanded + "끗입니다.";
//		} else if (totalHanded==0) {
//			result = "망통이네요..";
//		}
		
		model.addAttribute("first", firstHanded);
		model.addAttribute("second", secondHanded);
		model.addAttribute("result", result);
		
		return "toyprj/jsphouse";
	}
}
