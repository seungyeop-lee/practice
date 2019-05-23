package springbook.learningtest.template;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

public class CalcSumTest {
	
	//파일의 숫자 합을 계산하는 테스트 메소드
	@Test
	public void sumOfNumbers() throws IOException {
		
		Calculator calculator = new Calculator();
		int sum = calculator.calcSum(
				getClass()	//현재 클래스의 정보를 가진 객체 획득
				.getResource("numbers.txt")	//클래스의 위치에 numbers.txt 파일의 정보를 가진 객체 획득
				.getPath());	//numbers.txt 파일의 경로 획득
		
		assertThat(sum, is(10));
	}
	
}