package dev.study.spring.di.mycar;

// 스프링 없이 의존성 주입하는 과정을 해보자.
// 생성자 주입 먼저 해볼거임
public class Car {
	Tire tire;
	
	/*
	 * 매개변수가 있는 생성자만 달랑 놓지말고 웬만해선 기본생성자르 만들어주는 습관을 들이자.
	 * => 매개변수가 있는 생성자만 혼자 두면 기본생성자는 자동으로 생성되지 않는다.
	 * 기본생성자를 만들어둘 시 다른 클래스에서 작업할때 가독성도 높일수 있는 장점이 있다.
	 */
	public Car() {
		// TODO 자동생성이 안돼는 기본생성자를 만들어둠.
	}
	
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public void getBrand() {
		System.out.println(tire.getTireBrand() + " 입니다.");
	}
}
