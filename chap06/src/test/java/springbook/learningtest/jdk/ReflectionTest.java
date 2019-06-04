package springbook.learningtest.jdk;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;


public class ReflectionTest {
	
	@Test
	public void invokeMethod() throws Exception {
		String name = "Spring";
		
		//String.length()
		assertThat(name.length(), is(6));
		
		Method lengthMethod = String.class.getMethod("length");
		assertThat((Integer)lengthMethod.invoke(name), is(6));
		
		//String.charAt()
		assertThat(name.charAt(0), is('S'));
		
		Method charAtMethod = String.class.getMethod("charAt", int.class);	//(메소드 이름, 파라미터 타입)
		assertThat((Character)charAtMethod.invoke(name, 0), is('S'));
	}
	
	@Test
	public void simpleProxy() {
		
		Hello hello = new HelloTarget();
		assertThat(hello.sayHello("Toby"), is("Hello Toby"));
		assertThat(hello.sayHi("Toby"), is("Hi Toby"));
		assertThat(hello.sayThankYou("Toby"), is("Thank You Toby"));
		
		Hello proxiedHello = new HelloUppercase(hello);
		assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
		assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
		assertThat(proxiedHello.sayThankYou("Toby"), is("THANK YOU TOBY"));
		
	}
	
	@Test
	public void dynamicProxy() {
		Hello proxiedHello = (Hello)Proxy.newProxyInstance(
				getClass().getClassLoader(), //다이나믹 프록시 클래스의 로딩에 사용 할 클래스 로더
				new Class[] {Hello.class}, 	//구현 할 인터페이스
				new UppercaseHandler(new HelloTarget()));	//부가기능을 담은 핸들러
		
		assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
		assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
		assertThat(proxiedHello.sayThankYou("Toby"), is("THANK YOU TOBY"));
		
		assertThat(proxiedHello.saidHello("Toby"), is("Hello Toby"));
		assertThat(proxiedHello.sayNumber("3"), is(3));
	}
	
}
