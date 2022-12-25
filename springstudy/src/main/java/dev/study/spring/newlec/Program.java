package dev.study.spring.newlec;

import dev.study.spring.newlec.entity.Exam;
import dev.study.spring.newlec.entity.ExamA1;
import dev.study.spring.newlec.ui.ExamConsole;
import dev.study.spring.newlec.ui.GridExamConsole;
import dev.study.spring.newlec.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		// 데이터가 담겨있는 Exam을 인터페이스로써 등록하면 ExamA1은 데이터 구현객체가 된다.
		Exam exam = new ExamA1();

		// 출력하는 객체도 따로 만든다.
		// 이때 DI주입 방식은 생성자 주입 방식이다. 생성자로 넣어줌.
		
		// 하나 더 다른걸 만들어본다.
//		ExamConsole console = new InlineExamConsole(exam);
		
		ExamConsole console = new GridExamConsole(exam);
		console.print();
		
	}

}
