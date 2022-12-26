package dev.study.spring.newlec;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.study.spring.newlec.entity.Exam;
import dev.study.spring.newlec.ui.ExamConsole;

public class Program {

	public static void main(String[] args) {
		// 스프링에서 DI 또는 지시서를 읽어가지고 생성해주고 조립해주는 스프링의 구체적인 객체 이름은
		// ApplicationContext이다. 정확히는 이건 인터페이스 명이고 이걸 구현하고 있는 클래스는 여러개가 있다.
		// 대표적으로 ClassPathXmlApplicationContext가 있다 여러개의 클래스가 있는데 전부 경로를 나타내는 클래스명이다.
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("dev/study/spring/newlec/setting.xml");
		// ioc컨테이터 객체를 생성하는 과정이다.
		// 세팅을 해준 xml파일 경로를 패키지 단위로 적어주면 그걸 찾아 보따리같이 만든 뒤 변수(위의 context)에 담아 쓸 수 있다.
		// 그리고 bean에 등록된 Exam인터페이스를 구현객체화 시켜주어야 한다.
		
		//Exam exam = context.getBean(Exam.class);
		//System.out.println("exam에 저장되어있는건? : " + exam.toString());
		// 오류로 한참을 해맸다. setting.xml에서 exam이라는 인터페이스 끌어다 쓰는데 이 부분이 있다면 ExamConsole과 겹쳐서 예외가 나버린다.
		// ExamConsole의 매개변수로 exam을 받는데 그 부분이 겹치는거같다.
		
//		ExamConsole console = context.getBean("console");
		// 이름만 가지고 꺼낼수는 있지만 오브젝트 형으로 꺼내지니 강제캐스팅으로 맞춰주야한다. 이 방법타입 검증이 이루어지지 않아 좀 위험하다.
		
		// 이럴때는 자료형 명으로 꺼내는 방식이 안전하다.
		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
	}

}
