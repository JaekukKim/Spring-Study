package dev.study.spring.cardgame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.study.spring.cardgame.dto.GameResult;
import dev.study.spring.cardgame.service.CardGameService;
import dev.study.spring.studywhilemakingofseotda.CardDeck;

@Controller
public class CardGameController {

	// 섯다 "게임 시스템관리"를 위한 게임 서비스 객체 생성.
	private final CardGameService cardGameService;
	
	//
	public CardGameController(CardGameService cardGameService) {
		this.cardGameService = cardGameService;
	}
	
	// jsp 진입페이지 리펙토링.
	@RequestMapping(value = "/securityajaxmk2", method = RequestMethod.GET)
	public String connectAjax(HttpServletRequest req) {
		return cardGameService.gameInit(req);
	}
	
	@ResponseBody
	@RequestMapping(value = "/securitydobakmk2", method = RequestMethod.POST)
	public GameResult getDeck(
			HttpSession session,
			HttpServletRequest req) {
		
		return cardGameService.getDeck(session, req);
	}
	
}
