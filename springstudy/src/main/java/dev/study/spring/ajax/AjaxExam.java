package dev.study.spring.ajax;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxExam {
	
	@ResponseBody
	@RequestMapping(value = "/cardgame", method = RequestMethod.POST)
	public List<CardVO> returnListVO(@RequestParam("name") String name) throws Exception{
		System.out.println(name);
		List<CardVO> list = new ArrayList<>();
		
		list.add(new CardVO(4, "spade"));
		list.add(new CardVO(10, "clover"));
		list.add(new CardVO(2, "diamond"));
		list.add(new CardVO(8, "heart"));
		
		return list;
		// 여기서 카드를 이미 찍은 상태로 list안에 저장되있으니깐 여기서 받아가지고
	}
	// jsp에 최초 진입하는 return에 있는 jsp파일 [1]
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws Exception{
		return "toyprj/ajaxexam";
	} 

}
