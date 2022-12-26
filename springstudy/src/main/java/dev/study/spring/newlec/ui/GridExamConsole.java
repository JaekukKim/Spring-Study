package dev.study.spring.newlec.ui;

import dev.study.spring.newlec.entity.Exam;

public class GridExamConsole implements ExamConsole {
	
	private Exam exam;
	
	public GridExamConsole() {
		// TODO Auto-generated constructor stub
	}
	
	public GridExamConsole(Exam exam) {
		super();
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("GridExamConsole 출력\n"
	+ "total : %d, avg : %f", exam.total(), exam.avg());
	}

	@Override
	public void setExam(Exam exam) {
		// TODO Auto-generated method stub
		this.exam=exam;
	}

}
