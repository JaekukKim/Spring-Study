package dev.study.spring.newlec.entity;

public class ExamA1 implements Exam {
	
	private int korScore;
	private int mathScore;
	private int comScore;
	
	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getComScore() {
		return comScore;
	}

	public void setComScore(int comScore) {
		this.comScore = comScore;
	}

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

	@Override
	public String toString() {
		return "ExamA1 [korScore=" + korScore + ", mathScore=" + mathScore + ", comScore=" + comScore + "]";
	}
	
	
}
