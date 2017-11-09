--테이블 삭제
DROP TABLE boards
CASCADE CONSTRAINT;

DROP SEQUENCE boards_SEQ;

--테이블 생성
CREATE TABLE boards(
	board_seq number primary key,
	BOARD_URL VARCHAR2(50) NOT NULL,
	status varchar2(50)  DEFAULT '공개' not null
);

--시퀀스 생성
CREATE SEQUENCE boards_SEQ
START WITH 1 INCREMENT BY 1;

--데이터 조회
SELECT * FROM boards

--더미데이터 넣기
INSERT INTO boards(
	board_seq, BOARD_URL
)
VALUES(
	1,'notice'
)
INSERT INTO boards(
	board_seq, BOARD_URL
)
VALUES(
	2,'today'
)
INSERT INTO boards(
	board_seq, BOARD_URL
)
VALUES(
	3,'free'
)