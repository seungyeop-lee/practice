import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@EqualsAndHashCode    //전체 필드에 대해 Eqauls와 HashCode를 적용한다.
@EqualsAndHashCode(of = {"name"})   //of를 이용하면 특정 필드만 대상으로 할 수 있다.
public class AfterEqualsAndHashCodeHuman {
    private String name;
    private int age = 0;
}
