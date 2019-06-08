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
}
