create table tbl_user (
	uid varchar(50) not null,
	upw varchar(50) not null,
	uname varchar(100) not null,
	upoint int(11) not null default 0,
	primary key(uid)
);

create table tbl_message (
	mno int not null auto_increment,
	targetid varchar(50) not null,
	sender varchar(50) not null,
	message text not null,
	opendate timestamp,
	senddate timestamp not null default now(),
	primary key(mno)
);

alter table tbl_message add constraint fk_usertarget
foreign key (targetid) references tbl_user (uid);

alter table tbl_message add constraint fk_usersender
foreign key (sender) references tbl_user (uid);

alter table tbl_board add column replycnt int default 0;

create table tbl_attach (
	fullName varchar(150) not null,
	bno int not null,
	regdate timestamp default now(),
	primary key(fullName)
);

alter table tbl_attach add constraint fk_board_attach
foreign key (bno) references tbl_board (bno);