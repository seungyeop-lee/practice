import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AfterGetterSetterHumanTest {

    @Test
    public void getterAndSetterTest() {
        int age = 33;
        String name = "Seungyeop Lee";

        AfterGetterSetterHuman human = new AfterGetterSetterHuman();
        human.setAge(age);
        human.setName(name);

        assertThat(human.getAge(), is(age));
        assertThat(human.getName(), is(name));
    }

}