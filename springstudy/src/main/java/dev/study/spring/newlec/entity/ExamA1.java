package dev.study.spring.newlec.entity;

public class ExamA1 implements Exam {
	
	private int korScore;
	private int mathScore;
	private int comScore;
	
	@Override
	public int total() {
		// TODO Auto-generated method stub
		return korScore + mathScore + comScore;
	}

	@Override
	public double avg() {
		// TODO Auto-generated method stub
		return total()/3.0;
	}

}
