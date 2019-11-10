package chap01;


abstract class Price {

    abstract int getPriceCode();

    abstract double getCharge(int dayRented);

    int getFrequentRentalPoints(int dayRented) {
        return 1;
    }

}

class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    double getCharge(int dayRented) {
        double result = 1.5;
        if (dayRented > 3) {
            result += (dayRented - 3) * 1.5;
        }
        return result;
    }
}

class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int dayRented) {
        return dayRented * 3;
    }

    @Override
    int getFrequentRentalPoints(int dayRented) {
        return (dayRented > 1) ? 2 : 1;
    }
}

class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int dayRented) {
        double result = 2;
        if (dayRented > 2) {
            result += (dayRented - 2) * 1.5;
        }
        return result;
    }
}