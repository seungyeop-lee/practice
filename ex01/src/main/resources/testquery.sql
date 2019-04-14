-- 새로운 게시물의 등록에 사용하는 SQL
insert into tbl_board (title, content, writer)
values('제목입니다`, '내용입니다', 'user00');

-- 게시물의 조회에 사용하는 SQL
select * from tbl_board where bno = 1;

-- 게시물의 전체 목록에 사용하는 SQL
select * from tbl_board
where bno > 0
order by bno desc;

-- 게시물의 수정에 사용하는 SQL
update tbl_board
set title='수정된 제목'
where bno = 1;

-- 게시물의 삭제에 사용하는 SQL
delete from tbl_board
where bno = 1;