package part1.chap2.verse3

// 클로저의 기본 구조예제
[1, 2, 3].each { entry -> println entry }


// 파티에서 나를 제외한 모든 사람과 '짠!'을 했을 경우
// 총 몇번의 '짠!'이 발생하는가?

// 그루비 버전 (upto 메소드 사용)
def totalClinks = 0
def partyPeople = 100
1.upto(partyPeople) { guestNumber ->
    clinksWithGuest = guestNumber - 1
    totalClinks += clinksWithGuest
}
assert  totalClinks == (partyPeople * (partyPeople - 1)) / 2

// 자바 버전 (for문 사용)
int totalClinksJ = 0;
for(int guestNumber = 1;
        guestNumber <= partyPeople;
        guestNumber++) {
    int clinksWithGuest = guestNumber - 1;
    totalClinksJ += clinksWithGuest;
}
assert  totalClinksJ == totalClinks