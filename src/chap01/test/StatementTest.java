package chap01.test;

import chap01.Customer;
import chap01.Movie;

import java.util.Map;

public class StatementTest {

    Map<String, Customer> customers;
    Map<String, Movie> movies;

    public StatementTest(Map<String, Customer> customers, Map<String, Movie> movies) {
        this.customers = customers;
        this.movies = movies;
    }

    public void testStatement() {
        StringBuilder result = new StringBuilder();
        result.append("[statement method test]\n");

        String childrenCustomerStatement = customers.get("childrenCustomer").statement();
        boolean childrenCustomerStatementResult = childrenCustomerStatement.equals(
                "Children Customer 고객님의 대여 기록\n" +
                        "\tStar Wars\t1.5\n" +
                        "\tLove Story\t4.5\n" +
                        "누적 대여료: 6.0\n" +
                        "적립 포인트: 2"
        );
        result.append("childrenCustomerStatement: ");
        if (childrenCustomerStatementResult) {
            result.append("OK\n");
        } else {
            result.append("NG\n");
            result.append(childrenCustomerStatement+"\n");
        }

        String regularCustomerStatement = customers.get("regularCustomer").statement();
        boolean regularCustomerStatementResult = regularCustomerStatement.equals(
                "Regular Customer 고객님의 대여 기록\n" +
                        "\tStar Wars\t2.0\n" +
                        "\tLove Story\t6.5\n" +
                        "누적 대여료: 8.5\n" +
                        "적립 포인트: 2"
        );
        result.append("regularCustomerStatement: ");
        if (regularCustomerStatementResult) {
            result.append("OK\n");
        } else {
            result.append("NG\n");
            result.append(regularCustomerStatement+"\n");
        }

        String newCustomerStatement = customers.get("newCustomer").statement();
        boolean newCustomerStatementResult = newCustomerStatement.equals(
                "New Customer 고객님의 대여 기록\n" +
                        "\tStar Wars\t3.0\n" +
                        "\tLove Story\t15.0\n" +
                        "누적 대여료: 18.0\n" +
                        "적립 포인트: 3"
        );
        result.append("newCustomerStatement: ");
        if (newCustomerStatementResult) {
            result.append("OK\n");
        } else {
            result.append("NG\n");
            result.append(newCustomerStatement+"\n");
        }

        System.out.println(result.toString());
    }
}
