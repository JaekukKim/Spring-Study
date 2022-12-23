package dev.study.spring.studywhilemakingofseotda;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data")
public class DBConnection {
	
	@Inject
	private DataSource dataSource;
	
	@GetMapping(value = "/connectionDB")
	public String testConnection(@RequestParam Test test) {
		try {
			Connection conn = dataSource.getConnection();
			System.out.println("연결성공 : " + conn);
		} catch (Exception e) {
			System.out.println("연결실패");
			e.printStackTrace();
		}
		return "/data/connectionDB";
	}
}
