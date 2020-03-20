package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		//namespace 내부의 구문id는 .을 통해 접근
		return sqlSession.selectOne(namespace + ".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace + ".insertMember", vo);
	}
	
	@Override
	public MemberVO readMember(String userid) throws Exception {
		return sqlSession.selectOne(namespace + ".selectMember", userid);
	}
	
	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		//Map으로 전달 할 경우 Mapper.xml에서 #{}으로 값의 접근이 가능하다.
		return sqlSession.selectOne(namespace + ".readWithPW", paramMap);
	}
	
}
