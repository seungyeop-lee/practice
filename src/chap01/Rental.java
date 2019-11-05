package chap01;

public class Rental {
    private Movie _movie;
    private int _dayRented;

    public Rental(Movie movie, int dayRented) {
        this._movie = movie;
        this._dayRented = dayRented;
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
