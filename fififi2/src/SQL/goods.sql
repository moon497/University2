--테이블 삭제
DROP TABLE MARKETS
CASCADE CONSTRAINT;

DROP SEQUENCE MARKETS_SEQ;

CREATE TABLE Goods(
	status VARCHAR2(20) DEFAULT '판매중' NOT NULL,
	seq NUMBER PRIMARY KEY,
	category VARCHAR2(300) NOT NULL,
	userId VARCHAR2(50) NOT NULL,
	userName VARCHAR2(50) NOT NULL,
	title VARCHAR2(300) NOT NULL,
	content VARCHAR2(4000) NOT NULL,
	price NUMBER DEFAULT 0 NOT NULL,
	address VARCHAR2(500) NOT NULL,
	phone VARCHAR2(50) NOT NULL,
	wdate DATE DEFAULT SYSDATE NOT NULL
);

--시퀀스 생성
--CREATE SEQUENCE Goods_SEQ
--START WITH 1 INCREMENT BY 1;

--!!!!!!!MAIN_BBS_SEQ를 공유한다!!!


--데이터 조회
SELECT * FROM GOODS;

SELECT 
	status, seq, category, userId, userName, title, 
	content, price, address, phone, wdate
FROM (
		SELECT status, seq, category, userId, userName, title, 
				content, price, address, phone, wdate, 
				ROW_NUMBER() OVER (ORDER BY seq desc) R
		FROM GOODS
		WHERE status != '삭제'
)
WHERE R BETWEEN 1 and 10