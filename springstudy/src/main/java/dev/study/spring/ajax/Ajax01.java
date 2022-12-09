package dev.study.spring.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ajax01 {
	
	@RequestMapping(value = "/ajaxStudy", method = RequestMethod.GET)
	public String connectExam() {
		return "ajax/ajaxExam01";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxreturn", method = RequestMethod.POST)
	public void testAjax(@RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("location") String location) {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("사는곳 : " + location);
	}
}
