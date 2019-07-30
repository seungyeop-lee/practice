package part1.chap2.verse3

//배열의 각각 요소를 출력
[1, 2, 3].each { entry -> println entry}

//클로저를 사용한 반복작업, 자바의 람다식과 다르게 바깥변수의 값의 재정의가 가능
def totalClinks = 0
def partyPeople = 100
1.upto(partyPeople) {   //1부터 partyPeople(100)까지 반복
    guestNumber ->  //guestNumber에 현재 반복 중인 숫자가 설정 됨
        clinksWithGuest = guestNumber - 1
        totalClinks += clinksWithGuest
}
assert totalClinks == (partyPeople * (partyPeople - 1)) / 2

//for문을 사용한 반복작업 (자바 스타일)
totalClinks = 0;
partyPeople = 100;
for(int guestNumber = 1; guestNumber <= partyPeople; guestNumber++) {
    int clinksWithGuest = guestNumber - 1;
    totalClinks += clinksWithGuest;
}
assert totalClinks == (partyPeople * (partyPeople - 1)) / 2
