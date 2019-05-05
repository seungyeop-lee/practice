-- 지금까지의 작성한 댓글 숫자와 tbl_board의 replycnt를 일치시키도록 수정
update tbl_board
set replycnt = 
	(select count(rno)
	from tbl_reply
	where bno = tbl_board.bno)
where bno > 0;