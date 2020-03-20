package springbook.learningtest;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * JUnit과 스프링의 테스트 컨텍스트에 대한 학습 테스트
 * 
 * 1. @Test가 붙은 메소드가 실행 될 때마다
 * 새로운 객체가 생성되는지 검증하는 학습 테스트
 * 
 * 2. 테스트 별로 새로운 객체가 생겨도,
 * 같은 객체 어플리케이션 컨텍스트가 주입되는지 검증하는 학습 테스트 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "junit.xml")
public class JUnitTest {
	
	@Autowired
	ApplicationContext context;
	
	static Set<JUnitTest> testObjects = new HashSet<>();
	static ApplicationContext contextObject = null;
	
	@Test
	public void test1() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
		
		//일반적인 assertThat 검증
		assertThat(contextObject == null || contextObject == this.context,
				is(true));
		contextObject = this.context;
	}
	
	@Test
	public void test2() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
		
		//boolean결과에 대해서는 assertTrue로 더 깔끔하게
		assertTrue(contextObject == null || contextObject == this.context);
		contextObject = this.context;
	}
	
	@Test
	public void test3() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
		
		//either(matcher).or(matcher)과 같이, 영어 문장처럼 구성이 가능
		assertThat(contextObject, either(is(nullValue())).or(is(this.context)));
		contextObject = this.context;
	}
	
}
