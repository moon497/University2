SELECT U.USER_ID, U.USER_NAME, U.USER_EMAIL, U.USER_PHONE, U.USER_ADDRESS, U.USER_AUTH, U.USER_STATUS, U.USER_BIRTH,
				S.STUDENT_REGIDATE, S.STUDENT_TERM, S.STUDENT_YEAR, S.STUDENT_TOTAL_CREDIT, S.STUDENT_TERM_GRADE, S.STUDENT_TOTAL_GRADE, S.STUDENT_MAJOR, S.STUDENT_FIRST_MAJOR
		FROM USERS U, STUDENT S
		WHERE U.USER_ID = S.STUDENT_ID
		AND U.USER_ID='학생1' AND U.USER_PW='학생1'

SELECT * FROM STUDENT;

UPDATE STUDENT
SET STUDENT_TERM = 1
WHERE STUDENT_MAJOR IS NULL;
