import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = {"name"})
@AllArgsConstructor //모든 필드를 파라미터로 하는 생성자를 생성
@NoArgsConstructor  //기본 생성자를 생성
@RequiredArgsConstructor    //@NonNull이 붙은 필드만 파라미터로 하는 생성자를 생성
public class AfterConstructorHuman {
    @NonNull private String name;
    private int age = 0;
}
