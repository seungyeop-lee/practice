package org.zerock.persistence;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface SampleMapper {

	@Select("select now()")
	public String getTime();
	
	//@Param을 이용하면 인수로 받은 값을 SQL문에 활용 가능
	@Select("select email from tbl_member where userid = #{id} and userpw = #{pw}")
	public String getEmail(@Param("id") String id, @Param("pw") String pw);
	
	//인터페이스를 사용하지 않고, xml파일에 직접 SQL을 작성하여 매핑하는 방법 혼용가능
	public String getUserName(@Param("id") String id, @Param("pw") String pw);
	
	//특정 클래스의 특정 메소드에 매개변수로 받은 값을 넣어서 반환받은 문자열을 SQL로 사용
	@SelectProvider(type=SampleProvider.class, method="searchUserName")
	public String search(@Param("type") String type, @Param("keyword") String keyword);
	
}
