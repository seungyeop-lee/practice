package springbook.learningtest.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class MessageFactoryBean implements FactoryBean<Message> {

	String text;
	
	//Message객체 생성 시 필요한 데이터를 DI받는다.
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public Message getObject() throws Exception {
		return Message.newMessage(text);
	}

	@Override
	public Class<? extends Message> getObjectType() {
		return Message.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
