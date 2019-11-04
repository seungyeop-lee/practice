package chap01;

public class TestMain {
    public static void main(String[] args) {
        Customer childrenCustomer = new Customer("Children Customer");
        Customer regularCustomer = new Customer("Regular Customer");
        Customer newCustomer = new Customer("New Customer");

        Movie starWarsRegular = new Movie("Star Wars", Movie.REGULAR);
        Movie starWarsNew = new Movie("Star Wars", Movie.NEW_RELEASE);
        Movie starWarsChildren = new Movie("Star Wars", Movie.CHILDREN);
        Movie loveStoryRegular = new Movie("Love Story", Movie.REGULAR);
        Movie loveStoryNew = new Movie("Love Story", Movie.NEW_RELEASE);
        Movie loveStoryChildren = new Movie("Love Story", Movie.CHILDREN);

        childrenCustomer.addRental(new Rental(starWarsChildren, 1));
        childrenCustomer.addRental(new Rental(loveStoryChildren, 5));
        String childrenCustomerStatement = childrenCustomer.statement();
        boolean result1 = childrenCustomerStatement.equals(
                "Children Customer 고객님의 대여 기록\n" +
                "\tStar Wars\t1.5\n" +
                "\tLove Story\t4.5\n" +
                "누적 대여료: 6.0\n" +
                "적립 포인트: 2"
        );
        if (result1) {
            System.out.println("children: OK");
        } else {
            System.out.println("children: NG");
            System.out.println(childrenCustomerStatement);
        }

        regularCustomer.addRental(new Rental(starWarsRegular, 1));
        regularCustomer.addRental(new Rental(loveStoryRegular, 5));
        String regularCustomerStatement = regularCustomer.statement();
        boolean result2 = regularCustomerStatement.equals(
                "Regular Customer 고객님의 대여 기록\n" +
                "\tStar Wars\t2.0\n" +
                "\tLove Story\t6.5\n" +
                "누적 대여료: 8.5\n" +
                "적립 포인트: 2"
        );
        if (result2) {
            System.out.println("regular: OK");
        } else {
            System.out.println("regular: NG");
            System.out.println(regularCustomerStatement);
        }

        newCustomer.addRental(new Rental(starWarsNew, 1));
        newCustomer.addRental(new Rental(loveStoryNew, 5));
        String newCustomerStatement = newCustomer.statement();
        boolean result3 = newCustomerStatement.equals(
                "New Customer 고객님의 대여 기록\n" +
                "\tStar Wars\t3.0\n" +
                "\tLove Story\t15.0\n" +
                "누적 대여료: 18.0\n" +
                "적립 포인트: 3"
        );
        if (result3) {
            System.out.println("new: OK");
        } else {
            System.out.println("new: NG");
            System.out.println(newCustomerStatement);
        }
    }
}
