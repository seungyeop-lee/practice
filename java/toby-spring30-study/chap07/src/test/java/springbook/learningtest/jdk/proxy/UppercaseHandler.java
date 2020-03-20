package springbook.learningtest.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 다이나믹 프록시에서 사용 할 핸들러(부가 기능)
 *
 */
public class UppercaseHandler implements InvocationHandler {

	Object target;
	
	//생성 시 실제 작업을 수행 할 타겟 객체를 주입받음
	public UppercaseHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(
			Object proxy, 	//이 메소드(invoke)를 부른 다이나믹 프록시 객체
			Method method, 	//다이나믹 프록시를 통해 실행 된 메소드
			Object[] args) throws Throwable {
		
		Object ret = method.invoke(target, args);	//(메소드를 실행 시킬 타켓 객체, 전달 할 인자값)
		
		//메소드의 반환값이 String타입이면서 실행 된 메소드의 이름이 say로 시작하는 경우
		if(ret instanceof String && method.getName().startsWith("say")) {
			//대문자로 변환하여 반환
			return ((String)ret).toUpperCase();
		} else {
			//그 외에 타입일 경우 그대로 반환
			return ret;
		}
	}

}
