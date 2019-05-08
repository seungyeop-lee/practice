package org.zerock.persistence;

import java.util.Map;

public class SampleProvider {
	
	//@SelectProvider로 사용 할 메소드는 static이여야 하며, 반환값은 문자열이여야 한다.
	//인터페이스에서 @Param이 key, 인수로 받은 값이 value로 하는 Map객체가 생성되어 매개변수로 설정된다.
	//Map객체는 반환된 SQL에서의 #{}에서도 접근 가능하다.
	public static String searchUserName(Map<String, Object> params) {
		
		String searchFront = "select username " + "from tbl_member " + "where 1 = 1 ";	//1 = 1은 아무 의미 없음
		
		if(params.get("type").equals("id")) {
			searchFront += " and userid = #{keyword}";
		}
		
		return searchFront;
		
	}
}
