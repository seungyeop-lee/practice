import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class AfterConstructorHumanTest {

    @Test
    public void constructorTest() {
        int age = 33;
        String name = "Seungyeop Lee";

        //@AllArgsConstructor 확인
        AfterConstructorHuman h1 = new AfterConstructorHuman(name, age);
        assertThat(h1, notNullValue());

        //@NoArgsConstructor 확인
        AfterConstructorHuman h2 = new AfterConstructorHuman();
        assertThat(h2, notNullValue());

        //@RequiredArgsConstructor 확인
        AfterConstructorHuman h3 = new AfterConstructorHuman(name);
        assertThat(h3, notNullValue());
    }
}