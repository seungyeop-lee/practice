import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AfterHuman4Test {
    private final int age = 33;
    private final String name = "Seungyeop Lee";
    private AfterHuman4 h1;
    private AfterHuman4 h2;

    @Before
    public void setUp() {
        h1 = new AfterHuman4();
        h2 = new AfterHuman4();
    }

    @Test
    public void getterAndSetterTest() {
        AfterHuman4 human = new AfterHuman4();
        human.setAge(age);
        human.setName(name);

        assertThat(human.getAge(), is(age));
        assertThat(human.getName(), is(name));
    }

    @Test
    public void equalsTest() {
        //같은 객체이면 true
        assertThat(h1.equals(h1), is(true));

        //타입이 다르면 false
        assertThat(h1.equals(new Object()), is(false));

        //초기화된 값이 같으므로 true
        assertThat(h1.equals(h2), is(true));

        //나이가 같아도 이름이 다르면 false
        h1.setName("lee");
        h1.setAge(20);
        h2.setName("kim");
        h2.setAge(20);
        assertThat(h1.equals(h2), is(false));

        //이름이 같아도 나이가 다르면 false
        h1.setName("park");
        h1.setAge(10);
        h2.setName("park");
        h2.setAge(20);
        assertThat(h1.equals(h2), is(false));

        //이름과 나이가 같아야 true
        h1.setName(name);
        h1.setAge(age);
        h2.setName(name);
        h2.setAge(age);
        assertThat(h1.equals(h2), is(true));
    }

    @Test
    public void HashCodeTest() {
        //같은 객체이면 true
        assertThat(h1.hashCode() == h1.hashCode(), is(true));

        //타입이 다르면 false
        assertThat(h1.hashCode() == new Object().hashCode(), is(false));

        //초기화된 값이 같으므로 true
        assertThat(h1.hashCode() == h2.hashCode(), is(true));

        //나이가 같아도 이름이 다르면 false
        h1.setName("lee");
        h1.setAge(20);
        h2.setName("kim");
        h2.setAge(20);
        assertThat(h1.hashCode() == h2.hashCode(), is(false));

        //이름이 같아도 나이가 다르면 false
        h1.setName("park");
        h1.setAge(10);
        h2.setName("park");
        h2.setAge(20);
        assertThat(h1.hashCode() == h2.hashCode(), is(false));

        //이름과 나이가 같아야 true
        h1.setName(name);
        h1.setAge(age);
        h2.setName(name);
        h2.setAge(age);
        assertThat(h1.hashCode() == h2.hashCode(), is(true));
    }

    @Test
    public void testToString() {
        h1.setAge(age);
        h1.setName(name);
        assertThat(h1.toString(), is("AfterHuman4(name=Seungyeop Lee, age=33)"));
    }

}