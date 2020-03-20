package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcContext {

	private DataSource dataSource;

	//Connection객체를 얻기위해 DataSource객체를 주입 받는다.
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = this.dataSource.getConnection();
			
			ps = stmt.makePreparedStatement(c);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if(ps != null) { try { ps.close(); } catch (SQLException e) {} }
			if(c != null) { try { c.close(); } catch (SQLException e) {} }
		}
		
	}
	
	//DAO가 공유 할 수 있도록 컨텍스트 객체로 옮김
	//workWithStatementStrategy메소드와 executeSql메소드는 하나의 목적(쿼리문의 실행)을 위한 코드
	//이러한 경우에는 응집력이 강하다고 할 수 있으므로, 모아놓는 것이 좋다.
	public void executeSql(String query, String... args) throws SQLException {
		workWithStatementStrategy(new StatementStrategy() {
			@Override
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				PreparedStatement ps = c.prepareStatement(query);
				
				int i = 1;
				for (String arg : args) {
					ps.setString(i++, arg);
				}
				
				return ps;
			}
		});
	}
	
}
