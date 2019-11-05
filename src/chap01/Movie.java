package chap01;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        this._title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            case CHILDREN:
                _price = new ChildrenPrice();
                break;
        }
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    // 비디오 종류별 대여료 계산 기능을 빼내어 별도의 함수를 작성
    double getCharge(int dayRented) {
        return _price.getCharge(dayRented);
    }

    int getFrequentRentalPoints(int dayRented) {
        return _price.getFrequentRentalPoints(dayRented);
    }
}
