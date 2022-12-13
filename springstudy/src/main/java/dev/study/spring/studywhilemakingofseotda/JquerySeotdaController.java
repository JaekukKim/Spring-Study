package dev.study.spring.studywhilemakingofseotda;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JquerySeotdaController {

	@RequestMapping(value = "/jquery")
	public String getDeck(HttpServletRequest req, Model model) {
		CardDeck cd = new CardDeck();

		cd.shuffle();
		String first = cd.getCards().get(0).getCardNum();
		String second = cd.getCards().get(2).getCardNum();
		String result = "";
			
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		model.addAttribute("result", result);
		
		return "toyprj/jqueryhouse";
	}
}
