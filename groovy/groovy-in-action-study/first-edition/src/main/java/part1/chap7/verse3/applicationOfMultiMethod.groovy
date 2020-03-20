package part1.chap7.verse3

class Equalizer {
    boolean equals(Equalizer e) {
        return true
    }
}

Object same = new Equalizer()
Object other = new Object()

assert  new Equalizer().equals(same)
assert !new Equalizer().equals(other)

// 자바에서 동일한 동작을 수행하려 할 경우
public class EqualizerJava {
    @Override
    boolean equals(Object obj) {
        if (obj == null) return false;
        if(!(obj instanceof Equalizer)) return false;
        Equalizer w = (Equalizer) obj;
        return true;
    }
}