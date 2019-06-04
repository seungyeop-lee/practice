package springbook.learningtest.spring.factorybean;


import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/FactoryBeanTest-context.xml")
public class FactoryBeanTest {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void getMessageFromFactoryBean() {
		
		//팩토리 빈을 통해 Message객체 획득
		Object message = context.getBean("message");
		
		assertThat(message, is(instanceOf(Message.class)));
		assertThat(((Message)message).getText(), is("Factory Bean"));
		
	}
	
	@Test
	public void getFactoryBean() throws Exception {
		
		//팩토리 빈 자체를 획득
		Object factory = context.getBean("&message");
		
		assertThat(factory, is(instanceOf(MessageFactoryBean.class)));
		
	}
}