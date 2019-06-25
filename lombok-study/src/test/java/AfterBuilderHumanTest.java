import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AfterBuilderHumanTest {
    @Test
    public void testBuilder() {
        AfterBuilderHuman human = AfterBuilderHuman.builder()
                .name("Seungyeop Lee")
                .age(33)
                .build();
        assertThat(human.toString(), is("AfterBuilderHuman(name=Seungyeop Lee, age=33)"));
    }
}