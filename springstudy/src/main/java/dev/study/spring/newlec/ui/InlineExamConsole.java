package dev.study.spring.newlec.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import dev.study.spring.newlec.entity.Exam;

@Primary
public class InlineExamConsole implements ExamConsole {
	
	private Exam exam;
	
	public InlineExamConsole() {
		System.out.println("@Autowired : 생성자호출");
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
	@Qualifier("exam2")
	@Override
	public void setExam(Exam exam) {
		System.out.println("@Autowired : setter호출");
		this.exam=exam;
	}

}
