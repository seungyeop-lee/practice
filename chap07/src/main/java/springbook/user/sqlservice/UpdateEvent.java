package springbook.user.sqlservice;

public class UpdateEvent {

	public static final String KEY_ID = "KEY";
	public static final String SQL_ID = "SQL";
	
	private String key;
	private String sql;
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	public String get(String id) {
		if(KEY_ID.equals(id)) {
			return key;
		} else if(SQL_ID.equals(id)) {
			return sql;
		} else {
			throw new IllegalArgumentException();
		}
	}

}
