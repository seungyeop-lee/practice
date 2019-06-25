import lombok.*;

@Getter
@Setter
@ToString   //IDE의 toString자동 완성과 같은 메소드 오버라이드를 수행
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class BeforeHuman4 {
    @NonNull private String name;
    private int age = 0;
}
