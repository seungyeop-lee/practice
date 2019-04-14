-- 테이블 명은 tbl_로 시작하는 것을 추천 (데이터베이스 내 여러 종류의 객체와 혼란을 피하기 위해)
create table tbl_member (
	userid varchar(50) not null,
    userpw varchar(50) not null,
    username varchar(50) not null,
    email varchar(100),
    -- 최초로 데이터가 생긴 시점
    regdate timestamp default now(),
    -- 최종적으로 데이터가 변경된 시점
    updatedate timestamp default now(),
    primary key(userid)
);

create table tbl_board (
	bno INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(200) NOT NULL,
	content TEXT NULL,
	writer VARCHAR(50) NOT NULL,
	regdate TIMESTAMP NOT NULL DEFAULT now(),
	viewcnt INT DEFAULT 0,
	PRIMARY KEY (bno)
);