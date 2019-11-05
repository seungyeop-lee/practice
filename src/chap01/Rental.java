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

    public double getCharge() {
        return _movie.getCharge(_dayRented);
    }

    public int getFrequentRentalPoints() {
        return _movie.getFrequentRentalPoints(_dayRented);
    }
}
