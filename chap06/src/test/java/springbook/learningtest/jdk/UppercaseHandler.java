package springbook.learningtest.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 다이나믹 프록시에서 사용 할 핸들러(부가 기능)
 *
 */
public class UppercaseHandler implements InvocationHandler {

	Hello target;
	
	//생성 시 실제 작업을 수행 할 타겟 객체를 주입받음
	public UppercaseHandler(Hello target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(
			Object proxy, 	//이 메소드(invoke)를 부른 다이나믹 프록시 객체
			Method method, 	//다이나믹 프록시를 통해 실행 된 메소드
			Object[] args) throws Throwable {
		String ret = (String)method.invoke(target, args);	//(메소드를 실행 시킬 타켓 객체, 전달 할 인자값)
		return ret.toUpperCase();
	}

}
