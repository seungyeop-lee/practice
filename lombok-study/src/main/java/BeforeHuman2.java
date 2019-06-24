import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class BeforeHuman2 {
    private String name;
    private int age = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeforeHuman2 human = (BeforeHuman2) o;
        return age == human.age &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
