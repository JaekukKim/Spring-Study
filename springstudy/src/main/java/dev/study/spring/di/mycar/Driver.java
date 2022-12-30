package dev.study.spring.di.mycar;

public class Driver {
	public static void main(String[] args) {
		// 인터페이스 구현체를 만듬.
		Tire koreaTire = new KoreaTire();
		Tire chinaTire = new ChinaTire();
		
		// 1번째 의존성 주입 : koreaTire
		Car car = new Car();
		car = new Car(koreaTire);
		car.getBrand();

		// 2번째 의존성 주입 : chinaTire
		car = new Car(chinaTire);
		car.getBrand();
		
		// 인터페이스를 통하여 koreaTire, chinaTire 구현체를 만들고 나니 Car객체에다가 객체만 바꿔넣어주면 되는 간편함이 있다.
		// 스프링의 DI기능 없이 구현해본 DI이며 DI라는 말은 어려우니 "부품교체"의 개념으로 생각해도 좋을거같다.
		// 말그대로 car라는 객체에 koreaTire, chinaTire라는 부품을 갈아끼우니 결과가 다르게 나온거처럼.
	}
}
