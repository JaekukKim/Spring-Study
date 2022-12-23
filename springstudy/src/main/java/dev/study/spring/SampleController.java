package dev.study.spring;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/datasample")
public class SampleController {
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping(value = "/getsample")
	public String getSample(@ModelAttribute Test test){
		try {
			Connection conn = (Connection) dataSource.getConnection();
			System.out.println("성공 : " + conn);
		} catch (Exception e) {
			System.out.println("연결실패함");
			e.printStackTrace();
		}
		return "/datasample/getsample";
	}
}
