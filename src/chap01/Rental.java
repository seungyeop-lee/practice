package chap01;

public class Rental {
    private Movie _movie;
    private int _dayRented;

    public Rental(Movie _movie, int _dayRented) {
        this._movie = _movie;
        this._dayRented = _dayRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDayRented() {
        return _dayRented;
    }

    // 비디오 종류별 대여료 계산 기능을 빼내어 별도의 함수를 작성
    double getCharge() {
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDayRented() > 2) {
                    result += (getDayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += getDayRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (getDayRented() > 3) {
                    result += (getDayRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    int getFrequentRentalPoints() {
        // 최신물을 이틀 이상 대여하면 2포인트 지급하고, 그 외엔 1포인트 지급하는 코드를 빼내
        // getFrequentRentalPoints 메서드로 만들고 이 Rental 클래스로 옮겼다.
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDayRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
