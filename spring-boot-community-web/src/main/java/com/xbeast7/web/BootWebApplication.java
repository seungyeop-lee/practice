package com.xbeast7.web;

import com.xbeast7.web.domain.Board;
import com.xbeast7.web.domain.User;
import com.xbeast7.web.domain.enums.BoardType;
import com.xbeast7.web.repository.BoardRepository;
import com.xbeast7.web.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class BootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootWebApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(    //애플리케이션 구동 후 실행 될 코드를 반환
            UserRepository userRepository,  //파라미터로 Bean주입
            BoardRepository boardRepository) throws Exception {
        return args -> {
            User user = userRepository.save(User.builder()
                    .name("havi")
                    .password("test")
                    .email("havi@gmail.com")
                    .createdDate(LocalDateTime.now())
                    .build());

            IntStream.rangeClosed(1, 200).forEach(  //1부터 200까지의 Stream을 만든 후 각 숫자별로 코드 실행
                    index -> boardRepository.save(Board.builder()
                            .title("게시글" + index)
                            .subTitle("순서" + index)
                            .content("콘텐츠")
                            .boardType(BoardType.free)
                            .createdDate(LocalDateTime.now())
                            .updatedDate(LocalDateTime.now())
                            .build())
            );
        };
    }

}
