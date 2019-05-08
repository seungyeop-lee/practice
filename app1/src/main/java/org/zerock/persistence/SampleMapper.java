package org.zerock.persistence;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SampleMapper {

	@Select("select now()")
	public String getTime();
	
	//@Param을 이용하면 인수로 받은 값을 SQL문에 활용 가능
	@Select("select email from tbl_member where userid = #{id} and userpw = #{pw}")
	public String getEmail(@Param("id") String id, @Param("pw") String pw);
	
	//인터페이스를 사용하지 않고, xml파일에 직접 SQL을 작성하여 매핑하는 방법 혼용가능
	public String getUserName(@Param("id") String id, @Param("pw") String pw);
	
}
