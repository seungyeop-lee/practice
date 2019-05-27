package springbook.user.domain;

//enum을 사용하면 범위를 벗어나는 값을 사용하거나, 다른 종류의 정보를 넣는 실수를 컴파일 단계에서 방지 가능
public enum Level {
	BASIC(1), SILVER(2), GOLD(3);
	
	//DB저장용 값
	private final int value;
	
	private Level(int value) {
		this.value = value;
	}
	
	public int intValue() {
		return value;
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
