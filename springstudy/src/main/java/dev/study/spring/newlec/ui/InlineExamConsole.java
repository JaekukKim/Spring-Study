package dev.study.spring.newlec.ui;

import dev.study.spring.newlec.entity.Exam;

public class InlineExamConsole implements ExamConsole {
	
	private Exam exam;
	
	// Exam을 받아내는 생성자 만들어야함.
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}
	
	@Override
	public void print() {
		System.out.printf("InlineExamConsole출력\n"
	+ "total : %d, avg : %f\n", exam.total(), exam.avg());

	}

}
