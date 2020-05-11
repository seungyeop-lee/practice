package set;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InstrumentedHashSet<String> languages = new InstrumentedHashSet<>();
        languages.addAll(Arrays.asList("Java", "Ruby", "Scala"));
        System.out.println(languages);  // InstrumentedHashSet{addCount=3}
    }
}
