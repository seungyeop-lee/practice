import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeforeHuman5 {
    @NonNull private String name;
    private int age = 0;

    public static HumanBuilder builder() {
        return new HumanBuilder();
    }

    private static class HumanBuilder {
        private String name;
        private int age;

        HumanBuilder() {
        }

        public HumanBuilder name(String name) {
            this.name = name;
            return this;
        }

        public HumanBuilder age(int age) {
            this.age = age;
            return this;
        }

        public BeforeHuman5 build() {
            return new BeforeHuman5(name, age);
        }

        @Override
        public String toString() {
            return "HumanBuilder{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
