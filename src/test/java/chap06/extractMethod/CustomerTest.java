package chap06.extractMethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer customer;

    @Before
    public void setUp() throws Exception {
        Vector<Order> orders = new Vector<>();
        orders.add(new Order(10.0));
        orders.add(new Order(20.0));
        orders.add(new Order(30.0));
        customer = new Customer(orders, "Lee");
    }

    @Test
    public void printOwing() {
        customer.printOwing();
    }
}