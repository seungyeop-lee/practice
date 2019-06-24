import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AfterHuman1Test {

    @Test
    public void getterAndSetterTest() {
        int age = 33;
        String name = "Seungyeop Lee";

        AfterHuman1 human = new AfterHuman1();
        human.setAge(age);
        human.setName(name);

        assertThat(human.getAge(), is(age));
        assertThat(human.getName(), is(name));
    }

}