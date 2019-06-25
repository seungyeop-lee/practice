import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"name"})
public class BeforeConstructorHuman {
    @NonNull private String name;
    private int age = 0;

    public BeforeConstructorHuman(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public BeforeConstructorHuman() {
    }

    public BeforeConstructorHuman(String name) {
        this.name = name;
    }

}
