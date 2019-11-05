package chap01;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private int _priceCode;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public void setPriceCode(int arg) {
        this._priceCode = arg;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    // 비디오 종류별 대여료 계산 기능을 빼내어 별도의 함수를 작성
    double getCharge(int dayRented) {
        double result = 0;
        switch (getPriceCode()) {
            case REGULAR:
                result += 2;
                if (dayRented > 2) {
                    result += (dayRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                result += dayRented * 3;
                break;
            case CHILDREN:
                result += 1.5;
                if (dayRented > 3) {
                    result += (dayRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    int getFrequentRentalPoints(int dayRented) {
        // 최신물을 이틀 이상 대여하면 2포인트 지급하고, 그 외엔 1포인트 지급하는 코드를 빼내
        // getFrequentRentalPoints 메서드로 만들고 이 Rental 클래스로 옮겼다.
        if ((getPriceCode() == NEW_RELEASE) && dayRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
