import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AfterHuman5Test {
    @Test
    public void testBuilder() {
        AfterHuman5 human = AfterHuman5.builder()
                .name("Seungyeop Lee")
                .age(33)
                .build();
        assertThat(human.toString(), is("AfterHuman5(name=Seungyeop Lee, age=33)"));
    }
}