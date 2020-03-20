package springbook.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

	/**
	 * 파일의 모든 줄에 써있는 숫자를 더함
	 * 
	 * @param filepath 대상 파일의 경로 
	 * @return 모든 줄에 써있는 숫자의 합
	 * @throws IOException
	 */
	public int calcSum(String filepath) throws IOException {
		
		LineCallback<Integer> sumCallback = new LineCallback<Integer>() {
			@Override
			public Integer doSomethingWithLine(String line, Integer value) {
				return value + Integer.valueOf(line);
			}
		};
		
		return fileReadTemplate(filepath, sumCallback, 0);
		
	}
	
	/**
	 * 파일의 모든 줄에 써있는 숫자를 곱함
	 * 
	 * @param filepath 대상 파일의 경로 
	 * @return 모든 줄에 써있는 숫자의 곱
	 * @throws IOException
	 */
	public Integer calcMultiply(String filepath) throws IOException {
		
		LineCallback<Integer> multiplyCallback = new LineCallback<Integer>() {
			@Override
			public Integer doSomethingWithLine(String line, Integer value) {
				return value * Integer.valueOf(line);
			}
		};
		
		return fileReadTemplate(filepath, multiplyCallback, 1);
	}
	
	/**
	 * 파일의 모든 줄에 써있는 문자를 한 줄로 연결함
	 * 
	 * @param filepath 대상 파일의 경로
	 * @return 모든 줄에 써있는 문자를 연결한 문자열
	 * @throws IOException
	 */
	public String concatenate(String filepath) throws IOException {
		
		LineCallback<String> concatenateCallback = new LineCallback<String>() {
			@Override
			public String doSomethingWithLine(String line, String value) {
				return value + line;
			}
		};
		
		return fileReadTemplate(filepath, concatenateCallback, "");
	}
	
	/**
	 * 파일을 읽어서 callback메소드를 실행
	 * 
	 * @param filepath 파일 경로
	 * @param callback 실행 메소드를 담은 객체
	 * @param initVal 계산 결과를 저장할 변수의 초기값
	 * @return callback실행 결과
	 * @throws IOException
	 */
	public <T> T fileReadTemplate(String filepath, LineCallback<T> callback, T initVal) throws IOException {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(filepath));
			
			T res = initVal;
			String line = null;
			while((line = br.readLine()) != null) {
				//반복문 안에서의 계산을 콜백 객체에게 위임
				res = callback.doSomethingWithLine(line, res);
			}
			
			return res;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}

}
