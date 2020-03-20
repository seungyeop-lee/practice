package chap06.introduceExplainingVariable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProductTest {

    Product product1;
    Product product2;
    Product product3;

    @Before
    public void setUp() throws Exception {
        product1 = new Product(1, 500);
        product2 = new Product(2, 1000);
        product3 = new Product(3, 2000);
    }

    @Test
    public void price() {
        assertThat(product1.price(), is(550.0));
        assertThat(product2.price(), is(2100.0));
        assertThat(product3.price(), is(6100.0));
    }
}