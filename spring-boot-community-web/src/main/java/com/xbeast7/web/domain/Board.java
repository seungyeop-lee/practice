package com.xbeast7.web.domain;

import com.xbeast7.web.domain.enums.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Board implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 키 생성을 지정(strategy로 id 역할의 값 생성을 지정)
    private Long idx;

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)    //Enum타입 매핑용 어노테이션, 데이터베이스에는 문자열로 저장 함을 지정
    private BoardType boardType;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    //Board와 User의 관계가 1:1임을 지정, 실제 DB에는 User의 PK값이 저장 됨
    @OneToOne(fetch = FetchType.LAZY)   //lazy로 설정 함으로서 User객체를 사용 할 때 데이터를 로딩
    private User user;

    @Builder
    public Board(String title, String subTitle, String content, BoardType boardType,
                 LocalDateTime createdDate, LocalDateTime updatedDate, User user) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.boardType = boardType;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.user = user;
    }
}
