package springbook.user.sqlservice;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Unmarshaller;

import springbook.user.dao.UserDao;
import springbook.user.sqlservice.jaxb.SqlMap;
import springbook.user.sqlservice.jaxb.SqlType;

public class OxmSqlService implements SqlService {

	private final OxmSqlReader oxmSqlReader = new OxmSqlReader();
	private SqlRegistry sqlRegistry = new HashMapSqlRegistry();
	
	public void setSqlRegistry(SqlRegistry sqlRegistry) {
		this.sqlRegistry = sqlRegistry;
	}
	
	//OxmSqlReader에서 필요한 splmapFile과 unmarshaller를 주입받아 setter를 통해 넘겨준다.
	public void setSqlmapFile(String sqlmapFile) {
		oxmSqlReader.setSqlmapFile(sqlmapFile);
	}
	public void setUnmarshaller(Unmarshaller unmarshaller) {
		oxmSqlReader.setUnmarshaller(unmarshaller);
	}
	
	@PostConstruct
	public void loadSql() {
		this.oxmSqlReader.read(this.sqlRegistry);
	}
	
	@Override
	public String getSql(String key) throws SqlRetrievalFailureException {
		try {
			return this.sqlRegistry.findSql(key);
		} catch (SqlNotFoundException e) {
			throw new SqlRetrievalFailureException(e);
		}
	}
	
	//OxmSqlService전용 SqlReader
	//응집도를 높이기위해 OxmSqlService클래스의 맴버 클래스로 정의, private이므로 외부에서 직접 접근이 불가
	//빈의 갯수가 줄어들어 관리가 용이해지지만 유연성이 저하된다.
	private class OxmSqlReader implements SqlReader {
		private static final String DEFAULT_SQLMAP_FILE = "sqlmap.xml";
		
		private String sqlmapFile = DEFAULT_SQLMAP_FILE;
		private Unmarshaller unmarshaller;
		
		public void setSqlmapFile(String sqlmapFile) {
			this.sqlmapFile = sqlmapFile;
		}
		public void setUnmarshaller(Unmarshaller unmarshaller) {
			this.unmarshaller = unmarshaller;
		}
		
		@Override
		public void read(SqlRegistry sqlRegistry) {
			try {
				Source source = new StreamSource(UserDao.class.getResourceAsStream(this.sqlmapFile));
				SqlMap sqlMap = (SqlMap)this.unmarshaller.unmarshal(source);
				for(SqlType sql : sqlMap.getSql()) {
					sqlRegistry.registerSql(sql.getKey(), sql.getValue());
				}
			} catch (IOException e) {
				throw new IllegalArgumentException(this.sqlmapFile + "을 가져올 수 없습니다.", e);
			}
		}
	}
	
}
