package springbook.learningtest.jdk.proxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
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
	
	@Test
	public void classNamePointcutAdvisor() {
		
		@SuppressWarnings("serial")
		NameMatchMethodPointcut classMethodPointcut = new NameMatchMethodPointcut() {
			//인터페이스의 익명 객체를 생성하듯, 클래스의 메소드를 오버라이드하면서 객체를 생성하는 것이 가능!!
			@Override
			public ClassFilter getClassFilter() {
				return new ClassFilter() {
					@Override
					public boolean matches(Class<?> clazz) {
						return clazz.getSimpleName().startsWith("HelloT");
					}
				};
			}
		};
		classMethodPointcut.setMappedName("sayH*");
		
		checkAdviced(new HelloTarget(), classMethodPointcut, true);
		
		class HelloWorld extends HelloTarget {}
		checkAdviced(new HelloWorld(), classMethodPointcut, false);
		
		class HelloToby extends HelloTarget {}
		checkAdviced(new HelloToby(), classMethodPointcut, true);
		
	}
	
	/**
	 * 파라미터 값을 기반으로 하여  실제 적용 유무를 확인
	 * 
	 * @param target 프록시의 대상 객체
	 * @param pointcut 프록시 적용 대상 정보
	 * @param adviced 프록시 대상 유무
	 * 
	 */
	private void checkAdviced(Object target, Pointcut pointcut, boolean adviced) {
		
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(target);
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
		
		Hello proxiedHello = (Hello) pfBean.getObject();
		
		if(adviced) {
			assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
			assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
			assertThat(proxiedHello.sayThankYou("Toby"), is("Thank You Toby")); 
		} else {
			assertThat(proxiedHello.sayHello("Toby"), is("Hello Toby"));
			assertThat(proxiedHello.sayHi("Toby"), is("Hi Toby"));
			assertThat(proxiedHello.sayThankYou("Toby"), is("Thank You Toby")); 
		}
		
	}
	
}
