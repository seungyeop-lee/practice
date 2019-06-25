import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class AfterHuman3Test {

    @Test
    public void constructorTest() {
        int age = 33;
        String name = "Seungyeop Lee";

        //@AllArgsConstructor 확인
        AfterHuman3 h1 = new AfterHuman3(name, age);
        assertThat(h1, notNullValue());

        //@NoArgsConstructor 확인
        AfterHuman3 h2 = new AfterHuman3();
        assertThat(h2, notNullValue());

        //@RequiredArgsConstructor 확인
        AfterHuman3 h3 = new AfterHuman3(name);
        assertThat(h3, notNullValue());
    }
}