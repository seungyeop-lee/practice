package springbook.learningtest.spring.pointcut;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

public class PointCutTest {

	@Test
	public void getMethodFullSignature() throws SecurityException, NoSuchMethodException {
		Method minusMethod = Target.class.getMethod("minus", int.class, int.class);
		String minusMethodFullSigniture = minusMethod.toString();
		assertThat(minusMethodFullSigniture, 
				is("public int springbook.learningtest.spring.pointcut.Target.minus(int,int) throws java.lang.RuntimeException"));
	}
	
	@Test
	public void methodSignaturePointcut() throws SecurityException, NoSuchMethodException {
		//AspectJ표현식을 사용가능하게 해주는 객체
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		
		//execution은 실행 할 메소드를 지정하는 접두사
		//메소드의 full signature로 특정 메소드의 지정이 가능하다.
		pointcut.setExpression("execution(public int "
				+ "springbook.learningtest.spring.pointcut.Target.minus(int,int) "
				+ "throws java.lang.RuntimeException)");
		
		//Target.minus() 테스트
		assertThat(
				pointcut.getClassFilter().matches(Target.class) && 
					pointcut.getMethodMatcher().matches(Target.class.getMethod("minus", int.class, int.class), null), 
				is(true));
		
		//Target.plus() 테스트
		assertThat(
				pointcut.getClassFilter().matches(Target.class) && 
					pointcut.getMethodMatcher().matches(Target.class.getMethod("plus", int.class, int.class), null), 
				is(false));
		
		//Bean.method() 테스트
		assertThat(
				pointcut.getClassFilter().matches(Target.class) && 
					pointcut.getMethodMatcher().matches(Bean.class.getMethod("method"), null), 
				is(false));
	}
	
	@Test
	public void pointcut() throws Exception {
		//가장 느슨한 표현식, 모든 타입의 모든 메소드를 지정
		targetClassPointcutMatches("execution(* *(..))",
				true, true, true, true, true, true);
		
		//메소드 이름에 와일드카드(*)를 혼합하여 메소드를 지정
		targetClassPointcutMatches("execution(* hello(..))",
				true, true, false, false, false, false);
		targetClassPointcutMatches("execution(* hello())",
				true, false, false, false, false, false);
		targetClassPointcutMatches("execution(* hello(String))",
				false, true, false, false, false, false);
		targetClassPointcutMatches("execution(* meth*(..))",
				false, false, false, false, true, true);
		
		//파라미터의 타입을 직접 지정
		targetClassPointcutMatches("execution(* *(int,int))",
				false, false, true, true, false, false);
		targetClassPointcutMatches("execution(* *())",
				true, false, false, false, true, true);
		
		//지정 할 메소드가 포함된 클래스를 지정
		targetClassPointcutMatches("execution(* springbook.learningtest.spring.pointcut.Target.*(..))",
				true, true, true, true, true, false);
		targetClassPointcutMatches("execution(* springbook.learningtest.spring.pointcut.*.*(..))",
				true, true, true, true, true, true);
		targetClassPointcutMatches("execution(* springbook.learningtest.spring.pointcut..*.*(..))",
				true, true, true, true, true, true);
		targetClassPointcutMatches("execution(* springbook..*.*(..))",
				true, true, true, true, true, true);
		targetClassPointcutMatches("execution(* com..*.*(..))",
				false, false, false, false, false, false);
		targetClassPointcutMatches("execution(* *..Target.*(..))",
				true, true, true, true, true, false);
		targetClassPointcutMatches("execution(* *..Tar*.*(..))",
				true, true, true, true, true, false);
		targetClassPointcutMatches("execution(* *..*get.*(..))",
				true, true, true, true, true, false);
		targetClassPointcutMatches("execution(* *..B*.*(..))",
				false, false, false, false, false, true);
		
		//인터페이스(타입)으로 지정 가능, 이 경우 인터페이스를 구현하는 모든 클래스가 지정
		targetClassPointcutMatches("execution(* *..TargetInterface.*(..))",
				true, true, true, true, true, false);
		
		//던지는 예외에 따른 메소드 지정도 가능
		targetClassPointcutMatches("execution(* *(..) throws Runtime*)",
				false, false, false, true, false, true);
		
		//메소드의 반환값의 타입으로 지정
		targetClassPointcutMatches("execution(int *(..))",
				false, false, true, true, false, false);
		targetClassPointcutMatches("execution(void *(..))",
				true, true, false, false, true, true);
	}
	
	private void targetClassPointcutMatches(String expression, boolean... expected) throws Exception {
		pointcutMatches(expression, expected[0], Target.class, "hello");
		pointcutMatches(expression, expected[1], Target.class, "hello", String.class);
		pointcutMatches(expression, expected[2], Target.class, "plus", int.class, int.class);
		pointcutMatches(expression, expected[3], Target.class, "minus", int.class, int.class);
		pointcutMatches(expression, expected[4], Target.class, "method");
		pointcutMatches(expression, expected[5], Bean.class, "method");
	}
	
	/**
	 * 포인트컷 표현식과 클래스, 메소드를 비교하여 예상 대상유무와 동일 함을 확인
	 * 
	 * @param expression 포인트컷 표현식
	 * @param expected 예상되는 대상유무
	 * @param clazz 확인 할 타입
	 * @param methodName 확인 할 메소드 이름
	 * @param args 확인 할 메소드의 파라미터 정보
	 * @throws Exception
	 */
	private void pointcutMatches(String expression, Boolean expected, Class<?> clazz, String methodName, Class<?>... args) throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(expression);
		
		assertThat(pointcut.getClassFilter().matches(clazz) &&
					pointcut.getMethodMatcher().matches(clazz.getMethod(methodName, args), null), 
				is(expected));
	}
}
