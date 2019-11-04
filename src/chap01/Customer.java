package chap01;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRentalPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = getName() + " 고객님의 대여 기록\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentals.nextElement();

            // 비디오 종류별 대여료 계산 함수를 호출
            thisAmount = amountFor(each);

            // 적립 포인트를 1 포인트 증가
            frequentRentalPoints++;
            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
                frequentRentalPoints++;
            }

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            // 현재까지 누적된 총 대여료
            totalAmount += thisAmount;
        }

        // 푸터 행 추가
        result += "누적 대여료: " + String.valueOf(totalAmount) + "\n";
        result += "적립 포인트: " + String.valueOf(frequentRentalPoints);
        return result;
    }

    // 비디오 종류별 대여료 계산 기능을 빼내어 별도의 함수를 작성
    private double amountFor(Rental aRental) {
        double result = 0;
        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (aRental.getDayRented() > 2) {
                    result += (aRental.getDayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += aRental.getDayRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (aRental.getDayRented() > 3) {
                    result += (aRental.getDayRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
