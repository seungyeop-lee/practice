package part1.chap4.verse2

// 리스트 선언 및 정의
myList = [1,2,3]

// 리스트의 요소 확인
assert myList.size() == 3
assert myList[0] == 1
// 리스트 객체의 타입 확인
assert myList instanceof ArrayList

// 빈 리스트 선언 및 정의
emptyList = []
assert emptyList.size() == 0

// toList()를 이용한 리스트 획득
longList = (0..1000).toList()
assert longList[555] == 555

// 기존의 리스트를 이용해 Java Collection Framework 생성
// ArrayList + addAll()
explicitList = new ArrayList<>()
explicitList.addAll(myList)
assert explicitList.size() == 3
explicitList[0] = 10
assert explicitList[0] == 10

// LinkedList
explicitList = new LinkedList<>(myList)
assert explicitList.size() == 3
explicitList[0] = 10
assert explicitList[0] == 10