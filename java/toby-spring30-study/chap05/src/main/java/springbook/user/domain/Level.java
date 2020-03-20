package springbook.user.domain;

//enum을 사용하면 범위를 벗어나는 값을 사용하거나, 다른 종류의 정보를 넣는 실수를 컴파일 단계에서 방지 가능
public enum Level {
	//같은 타입의 enum 값을 참조하려면, 참조할 값이 먼저 선언되어야 한다. 
	GOLD(3, null), SILVER(2, GOLD), BASIC(1, SILVER);
	
	//DB저장용 값
	private final int value;
	private final Level next;	//레벨 상향 시, 다음 레벨
	
	private Level(int value, Level next) {
		this.value = value;
		this.next = next;
	}
	
	public int intValue() {
		return value;
	}
	
	public Level nextLevel() {
		return next;
	}
	
	public static Level valueOf(int value) {
		switch (value) {
		case 1:
			return BASIC;
		case 2:
			return SILVER;
		case 3:
			return GOLD;
		default:
			throw new AssertionError("Unknown value: " + value);
		}
	}
}
