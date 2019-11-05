package chap01.test;

import chap01.Customer;
import chap01.Movie;

import java.util.Map;

public class HtmlStatementTest {

    Map<String, Customer> customers;
    Map<String, Movie> movies;

    public HtmlStatementTest(Map<String, Customer> customers, Map<String, Movie> movies) {
        this.customers = customers;
        this.movies = movies;
    }

    public void testHtmlStatement() {
        StringBuilder result = new StringBuilder();
        result.append("[htmlStatement method test]\n");

        String childrenCustomerHtmlStatement = customers.get("childrenCustomer").htmlStatement();
        boolean childrenCustomerHtmlStatementResult = childrenCustomerHtmlStatement.equals(
                "<h1><em>Children Customer 고객님의 대여 기록</em></h1><p>\n" +
                "Star Wars: 1.5<br>\n" +
                "Love Story: 4.5<br>\n" +
                "</p><p>누적 대여료: <em>6.0</em></p>\n" +
                "<p>적립 포인트: <em>2</em></p>"
        );
        result.append("childrenCustomerHtmlStatement: ");
        if (childrenCustomerHtmlStatementResult) {
            result.append("OK\n");
        } else {
            result.append("NG\n");
            result.append(childrenCustomerHtmlStatement+"\n");
        }

        String regularCustomerStatement = customers.get("regularCustomer").htmlStatement();
        boolean regularCustomerStatementResult = regularCustomerStatement.equals(
                "<h1><em>Regular Customer 고객님의 대여 기록</em></h1><p>\n" +
                "Star Wars: 2.0<br>\n" +
                "Love Story: 6.5<br>\n" +
                "</p><p>누적 대여료: <em>8.5</em></p>\n" +
                "<p>적립 포인트: <em>2</em></p>"
        );
        result.append("regularCustomerStatement: ");
        if (regularCustomerStatementResult) {
            result.append("OK\n");
        } else {
            result.append("NG\n");
            result.append(regularCustomerStatement+"\n");
        }

        String newCustomerStatement = customers.get("newCustomer").htmlStatement();
        boolean newCustomerStatementResult = newCustomerStatement.equals(
                "<h1><em>New Customer 고객님의 대여 기록</em></h1><p>\n" +
                "Star Wars: 3.0<br>\n" +
                "Love Story: 15.0<br>\n" +
                "</p><p>누적 대여료: <em>18.0</em></p>\n" +
                "<p>적립 포인트: <em>3</em></p>"
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
