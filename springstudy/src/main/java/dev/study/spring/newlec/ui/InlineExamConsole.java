package dev.study.spring.newlec.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import dev.study.spring.newlec.entity.Exam;

public class InlineExamConsole implements ExamConsole {
	
	
	private Exam exam;
	
//	public InlineExamConsole() {
//		System.out.println("@Autowired : 기본생성자호출");
//	}
	
	// Exam을 받아내는 생성자 만들어야함.
	@Autowired
	public InlineExamConsole(@Qualifier("exam1") Exam exam1) {
		System.out.println("@Autowired : 오버로딩 생성자호출");
		this.exam = exam1;
	}
	
	@Override
	public void print() {
		System.out.printf("InlineExamConsole출력\n"
	+ "total : %d, avg : %f\n", exam.total(), exam.avg());

	}

	@Override
	public void setExam(Exam exam) {
		System.out.println("@Autowired : setter호출");
		this.exam=exam;
	}

}
