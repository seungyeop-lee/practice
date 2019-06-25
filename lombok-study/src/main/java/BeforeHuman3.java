import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"name"})
public class BeforeHuman3 {
    @NonNull private String name;
    private int age = 0;

    public BeforeHuman3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public BeforeHuman3() {
    }

    public BeforeHuman3(String name) {
        this.name = name;
    }

}
