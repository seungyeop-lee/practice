package springbook.learningtest.jdk.proxy;

/**
 * Hello타입의 메소드의 반환값을 대문자로 변환해 주는 프록시 클래스 
 *
 */
public class HelloUppercase implements Hello {
	Hello hello;
	
	//생성 시 실제 작업을 위임 할 타겟 객체를 주입받음
	public HelloUppercase(Hello hello) {
		this.hello = hello;
	}
	
	@Override
	public String sayHello(String name) {
		return hello.sayHello(name).toUpperCase();	//위임 후 반환 값을 대문자로 변환하여 최종 반환
	}
	
	@Override
	public String sayHi(String name) {
		return hello.sayHi(name).toUpperCase();
	}
	
	@Override
	public String sayThankYou(String name) {
		return hello.sayThankYou(name).toUpperCase();
	}

	@Override
	public String saidHello(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Integer sayNumber(String name) {
		throw new UnsupportedOperationException();
	}
}
