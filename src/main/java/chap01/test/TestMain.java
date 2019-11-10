package chap01.test;

import chap01.Customer;
import chap01.Movie;
import chap01.Rental;

import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        // 손님 생성
        Customer childrenCustomer = new Customer("Children Customer");
        Customer regularCustomer = new Customer("Regular Customer");
        Customer newCustomer = new Customer("New Customer");

        // 영화 생성
        Movie starWarsRegular = new Movie("Star Wars", Movie.REGULAR);
        Movie starWarsNew = new Movie("Star Wars", Movie.NEW_RELEASE);
        Movie starWarsChildren = new Movie("Star Wars", Movie.CHILDREN);
        Movie loveStoryRegular = new Movie("Love Story", Movie.REGULAR);
        Movie loveStoryNew = new Movie("Love Story", Movie.NEW_RELEASE);
        Movie loveStoryChildren = new Movie("Love Story", Movie.CHILDREN);

        // 손님 별 대여 생성
        childrenCustomer.addRental(new Rental(starWarsChildren, 1));
        childrenCustomer.addRental(new Rental(loveStoryChildren, 5));
        regularCustomer.addRental(new Rental(starWarsRegular, 1));
        regularCustomer.addRental(new Rental(loveStoryRegular, 5));
        newCustomer.addRental(new Rental(starWarsNew, 1));
        newCustomer.addRental(new Rental(loveStoryNew, 5));

        Map<String, Customer> customers = Map.of(
                "childrenCustomer", childrenCustomer,
                "regularCustomer", regularCustomer,
                "newCustomer", newCustomer
        );

        Map<String, Movie> movies = Map.of(
                "starWarsRegular", starWarsRegular,
                "starWarsNew", starWarsNew,
                "starWarsChildren", starWarsChildren,
                "loveStoryRegular", loveStoryRegular,
                "loveStoryNew", loveStoryNew,
                "loveStoryChildren", loveStoryChildren
        );

        new StatementTest(customers, movies).testStatement();
        new HtmlStatementTest(customers, movies).testHtmlStatement();
    }
}
