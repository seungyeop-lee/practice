import lombok.*;

@Data
@Builder    //해당 클래스의 빌더를 자동 생성
@AllArgsConstructor
@NoArgsConstructor
public class AfterBuilderHuman {
    @NonNull private String name;
    private int age = 0;
}
