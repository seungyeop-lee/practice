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
		
		BufferedReaderCallback sumCallback = new BufferedReaderCallback() {
			@Override
			public Integer doSomethingWithReader(BufferedReader br) throws IOException {
				Integer sum = 0;
				String line = null;
				while((line = br.readLine()) != null) {
					sum += Integer.valueOf(line);
				}
				return sum;
			}
		};
		return fileReadTemplate(filepath, sumCallback);
		
	}
	
	/**
	 * 파일의 모든 줄에 써있는 숫자를 곱함
	 * 
	 * @param filepath 대상 파일의 경로 
	 * @return 모든 줄에 써있는 숫자의 곱
	 * @throws IOException
	 */
	public Integer calcMultiply(String filepath) throws IOException {
		BufferedReaderCallback multiplyCallback = new BufferedReaderCallback() {
			@Override
			public Integer doSomethingWithReader(BufferedReader br) throws IOException {
				Integer multiply = 1;
				String line = null;
				while((line = br.readLine()) != null) {
					multiply *= Integer.valueOf(line);
				}
				return multiply;
			}
		};
		return fileReadTemplate(filepath, multiplyCallback);
	}
	
	/**
	 * 파일을 읽어서 callback메소드를 실행
	 * 
	 * @param filepath 파일 경로
	 * @param callback 실행 메소드를 담은 객체
	 * @return callback실행 결과
	 * @throws IOException
	 */
	public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(filepath));
			
			//변하는 부분인 계산 부분을 콜백으로 분리하여 위임한다.
			int ret = callback.doSomethingWithReader(br);
			
			return ret;
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
