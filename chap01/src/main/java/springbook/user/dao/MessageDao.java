package springbook.user.dao;

public class MessageDao {
	
	private ConnectionMaker connectionMaker;
	
	public MessageDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	//Message관련 dao로직
	
}
