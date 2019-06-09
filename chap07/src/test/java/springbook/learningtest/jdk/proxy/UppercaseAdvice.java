package springbook.learningtest.jdk.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 부가기능을 담은 Advice객체 
 * MethodInterceptor 인터페이스는 Advice를 상속받고있다.
 *
 */
public class UppercaseAdvice implements MethodInterceptor {

	//프록시에서 사용하던 InvocationHandler와 달리 타겟 객체를 Advice에 주입 시킬 필요가 없다.
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//타겟 객체의 실제 수행을 위임하는 것이 가능하다. (MethodInvocation에는 타겟 객체의 정보가 포함되어 있다.)
		String ret = (String)invocation.proceed();
		return ret.toUpperCase();
	}

}
