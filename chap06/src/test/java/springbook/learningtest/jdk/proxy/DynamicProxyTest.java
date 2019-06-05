package springbook.learningtest.jdk.proxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class DynamicProxyTest {
	
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
	
	@Test
	public void proxyFactoryBean() {
		
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		
		//프록시 객체의 타겟객체 설정
		pfBean.setTarget(new HelloTarget());
		//부가기능을 담은 어드바이스 객체 추가, 2개 이상의 어드바이스 추가가 가능하기 때문에 setter가 아니라 adder이다.
		pfBean.addAdvice(new UppercaseAdvice());
		
		Hello proxiedHello = (Hello) pfBean.getObject();
		
		assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
		assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
		assertThat(proxiedHello.sayThankYou("Toby"), is("THANK YOU TOBY"));
		
	}
	
	@Test
	public void pointcutAdvisor() {
		
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(new HelloTarget());
		
		//실행 메소드 이름으로 프록시 객체 생성유무를 판별 할 Pointcut객체
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.setMappedName("sayH*");	//sayH로 시작하는 메소드만 대상으로 한다.
		
		//Advisor == Pointcut(적용대상) + Advice(부가기능)
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
		
		Hello proxiedHello = (Hello) pfBean.getObject();
		
		assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
		assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
		assertThat(proxiedHello.sayThankYou("Toby"), is("Thank You Toby")); 	//sayH로 시작하지 않으므로 적용 대상에서 제외 됨
		
	}
	
}
