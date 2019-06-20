package springbook.user.sqlservice;

import static springbook.user.sqlservice.UpdateEvent.*;

public class SqlAdminService extends OxmSqlService implements AdminEventListener {

	private UpdatableSqlRegistry updatableSqlRegistry;
	
	public void setUpdatableSqlRegistry(UpdatableSqlRegistry updatableSqlRegistry) {
		this.updatableSqlRegistry = updatableSqlRegistry;
	}
	
	@Override
	public void updateEventListener(UpdateEvent event) {
		this.updatableSqlRegistry.updateSql(event.get(KEY_ID), event.get(SQL_ID));
	}

}
