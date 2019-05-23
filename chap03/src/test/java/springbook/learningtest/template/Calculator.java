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
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(filepath));
			
			Integer sum = 0;
			String line = null;
			while((line = br.readLine()) != null) {
				sum += Integer.valueOf(line);
			}
			
			return sum;
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
