package dev.study.spring.newlec.ui;

import org.springframework.beans.factory.annotation.Autowired;

import dev.study.spring.newlec.entity.Exam;

public class InlineExamConsole implements ExamConsole {
	
	private Exam exam;
	
	public InlineExamConsole() {
		// TODO Auto-generated constructor stub
	}
	
	// Exam을 받아내는 생성자 만들어야함.
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}
	
	@Override
	public void print() {
		System.out.printf("InlineExamConsole출력\n"
	+ "total : %d, avg : %f\n", exam.total(), exam.avg());

	}
	
	@Autowired
	@Override
	public void setExam(Exam exam) {
		// TODO Auto-generated method stub
		this.exam=exam;
	}

}
