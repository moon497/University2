-- 테이블 삭제
drop table files
CASCADE CONSTRAINT;

--테이블 생성
CREATE TABLE files(
	seq NUMBER NOT NULL,
	originalFileName VARCHAR2(255) NOT NULL,
	storedFileName VARCHAR2(255) NOT NULL,
	fileSize NUMBER NOT NULL,
	contentType VARCHAR2(100) NOT NULL,
	downCount NUMBER DEFAULT 0 NOT NULL,
	createAt DATE DEFAULT SYSDATE,
	PRIMARY KEY (seq)
);

--시퀀스 생성
CREATE SEQUENCE files_SEQ
START WITH 1 INCREMENT BY 1;

--파일 삽입

--테이블 조회
SELECT * FROM files