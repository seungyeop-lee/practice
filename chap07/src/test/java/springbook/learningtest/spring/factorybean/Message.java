package springbook.learningtest.spring.factorybean;

public class Message {
	String text;
	
	//외부에서 new 키워드로 새로운 객체를 생성 할 수 없도록 private생성자 선언
	private Message(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	//새로운 객체를 반환하는 스태틱 팩토리 메소드
	public static Message newMessage(String text) {
		return new Message(text);
	}
}
