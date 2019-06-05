package springbook.user.service;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.util.PatternMatchUtils;

/**
 * 클래스 필터 기능이 추가된  NameMatchMethodPointcut의 확장 클래스
 *
 */
@SuppressWarnings("serial")
public class NameMatchClassMethodPointcut extends NameMatchMethodPointcut {
	public void setmappedClassName(String mappedClassName) {
		this.setClassFilter(new SimpleClassFilter(mappedClassName));
	}
	
	static class SimpleClassFilter implements ClassFilter {
		String mappedName;
		
		private SimpleClassFilter(String mappedName) {
			this.mappedName = mappedName;
		}
		
		@Override
		public boolean matches(Class<?> clazz) {
			//와일드카드(*)가 들어간 문자열 비교를 지원하는 스프링의 유틸 메소드
			return PatternMatchUtils.simpleMatch(mappedName, clazz.getSimpleName());
		}
	}
}
