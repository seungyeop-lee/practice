import lombok.*;

@Data   //@Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor를 한번에 설정해주는 어노테이션
@AllArgsConstructor //@Data와 @AllArgsConstructor가 같이 존재하는경우, @RequiredArgsConstructor는 적용되지 않는다.
@NoArgsConstructor
public class AfterDataHuman {
    @NonNull private String name;
    private int age = 0;
}
