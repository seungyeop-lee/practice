package chap06.replaceTempWithQuery;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
    public void getPrice() {
        assertThat(product1.getPrice(), is(490.0));
        assertThat(product2.getPrice(), is(1900.0));
        assertThat(product3.getPrice(), is(5700.0));
    }
}