package springbook.learningtest.jdk.proxy;

public class HelloTarget implements Hello {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public String sayHi(String name) {
		return "Hi " + name;
	}

	@Override
	public String sayThankYou(String name) {
		return "Thank You " + name;
	}

	@Override
	public String saidHello(String name) {
		return "Hello " + name;
	}

	@Override
	public Integer sayNumber(String num) {
		return Integer.parseInt(num);
	}

}
