package kh.com.model;

import java.io.Serializable;

/*CREATE TABLE USERS(
USER_ID VARCHAR2(50) PRIMARY KEY,               --SYSDATE(2017)+MAJOR_NUMBER(100)+USER_SEQ(1,2,3...)
USER_PW VARCHAR2(50) NOT NULL,
USER_NAME VARCHAR2(50)  NOT NULL,
USER_EMAIL VARCHAR2(50) NOT NULL,
USER_PHONE VARCHAR2(50) NOT NULL,
USER_ADDRESS VARCHAR2(255) NOT NULL,
USER_BIRTH VARCHAR2(50) NOT NULL, 
USER_AUTH VARCHAR2(50) NOT NULL,          --학생:100,교수:200,관리자:300
MAJOR VARCHAR2(50) NOT NULL,      
USER_STATUS VARCHAR2(50) NOT NULL )

DROP TABLE USERS
CASCADE CONSTRAINT;*/

public class MemberDto implements Serializable{
   
   String user_id;
   String user_pw ;
   String user_name;
   String user_email;
   String user_phone;
   String user_address;
   String user_birth;
   String user_auth;
   String user_status;
   
   //학생
   String student_regidate;
   int student_term;
   int student_year;
   int student_total_credit;
   int student_term_grade;
   int student_total_grade;
   String student_major;
   String student_first_major;
   
   //교수
   String prof_regidate;
   String prof_position;
   String prof_room;
   String prof_degree;
   String prof_major;
   
   //교직원
   String admin_regidate;
   String admin_department;
   String admin_position;
   
      public MemberDto() {}


   public MemberDto(String user_id, String user_pw, String user_name, String user_email, String user_phone,
         String user_address, String user_birth, String user_auth, String user_status, String student_regidate,
         int student_term, int student_year, int student_total_credit, int student_term_grade,
         int student_total_grade, String student_major, String student_first_major) {
      this.user_id = user_id;
      this.user_pw = user_pw;
      this.user_name = user_name;
      this.user_email = user_email;
      this.user_phone = user_phone;
      this.user_address = user_address;
      this.user_birth = user_birth;
      this.user_auth = user_auth;
      this.user_status = user_status;
      this.student_regidate = student_regidate;
      this.student_term = student_term;
      this.student_year = student_year;
      this.student_total_credit = student_total_credit;
      this.student_term_grade = student_term_grade;
      this.student_total_grade = student_total_grade;
      this.student_major = student_major;
      this.student_first_major = student_first_major;
   }


   public MemberDto(String user_id, String user_pw, String user_name, String user_email, String user_phone,
         String user_address, String user_birth, String user_auth, String user_status, String prof_regidate,
         String prof_position, String prof_room, String prof_degree, String prof_major) {
      this.user_id = user_id;
      this.user_pw = user_pw;
      this.user_name = user_name;
      this.user_email = user_email;
      this.user_phone = user_phone;
      this.user_address = user_address;
      this.user_birth = user_birth;
      this.user_auth = user_auth;
      this.user_status = user_status;
      this.prof_regidate = prof_regidate;
      this.prof_position = prof_position;
      this.prof_room = prof_room;
      this.prof_degree = prof_degree;
      this.prof_major = prof_major;
   }

   public MemberDto(String user_id, String user_pw, String user_name, String user_email, String user_phone,
         String user_address, String user_birth, String user_auth, String user_status, String admin_regidate,
         String admin_department, String admin_position) {
      this.user_id = user_id;
      this.user_pw = user_pw;
      this.user_name = user_name;
      this.user_email = user_email;
      this.user_phone = user_phone;
      this.user_address = user_address;
      this.user_birth = user_birth;
      this.user_auth = user_auth;
      this.user_status = user_status;
      this.admin_regidate = admin_regidate;
      this.admin_department = admin_department;
      this.admin_position = admin_position;
   }

   public String getUser_id() {
      return user_id;
   }

   public void setUser_id(String user_id) {
      this.user_id = user_id;
   }

   public String getUser_pw() {
      return user_pw;
   }

   public void setUser_pw(String user_pw) {
      this.user_pw = user_pw;
   }

   public String getUser_name() {
      return user_name;
   }

   public void setUser_name(String user_name) {
      this.user_name = user_name;
   }

   public String getUser_email() {
      return user_email;
   }

   public void setUser_email(String user_email) {
      this.user_email = user_email;
   }

   public String getUser_phone() {
      return user_phone;
   }

   public void setUser_phone(String user_phone) {
      this.user_phone = user_phone;
   }

   public String getUser_address() {
      return user_address;
   }

   public void setUser_address(String user_address) {
      this.user_address = user_address;
   }

   public String getUser_birth() {
      return user_birth;
   }

   public void setUser_birth(String user_birth) {
      this.user_birth = user_birth;
   }

   public String getUser_auth() {
      return user_auth;
   }

   public void setUser_auth(String user_auth) {
      this.user_auth = user_auth;
   }

   public String getUser_status() {
      return user_status;
   }

   public void setUser_status(String user_status) {
      this.user_status = user_status;
   }

   public String getStudent_regidate() {
      return student_regidate;
   }

   public void setStudent_regidate(String student_regidate) {
      this.student_regidate = student_regidate;
   }

   public int getStudent_term() {
      return student_term;
   }

   public void setStudent_term(int student_term) {
      this.student_term = student_term;
   }

   public int getStudent_year() {
      return student_year;
   }

   public void setStudent_year(int student_year) {
      this.student_year = student_year;
   }

   public int getStudent_total_credit() {
      return student_total_credit;
   }

   public void setStudent_total_credit(int student_total_credit) {
      this.student_total_credit = student_total_credit;
   }

   public int getStudent_term_grade() {
      return student_term_grade;
   }

   public void setStudent_term_grade(int student_term_grade) {
      this.student_term_grade = student_term_grade;
   }

   public int getStudent_total_grade() {
      return student_total_grade;
   }

   public void setStudent_total_grade(int student_total_grade) {
      this.student_total_grade = student_total_grade;
   }

   public String getStudent_major() {
      return student_major;
   }

   public void setStudent_major(String student_major) {
      this.student_major = student_major;
   }

   public String getProf_regidate() {
      return prof_regidate;
   }

   public void setProf_regidate(String prof_regidate) {
      this.prof_regidate = prof_regidate;
   }

   public String getProf_position() {
      return prof_position;
   }

   public void setProf_position(String prof_position) {
      this.prof_position = prof_position;
   }

   public String getProf_room() {
      return prof_room;
   }

   public void setProf_room(String prof_room) {
      this.prof_room = prof_room;
   }

   public String getProf_degree() {
      return prof_degree;
   }

   public void setProf_degree(String prof_degree) {
      this.prof_degree = prof_degree;
   }

   public String getProf_major() {
      return prof_major;
   }

   public void setProf_major(String prof_major) {
      this.prof_major = prof_major;
   }

   public String getAdmin_regidate() {
      return admin_regidate;
   }

   public void setAdmin_regidate(String admin_regidate) {
      this.admin_regidate = admin_regidate;
   }

   public String getAdmin_department() {
      return admin_department;
   }

   public void setAdmin_department(String admin_department) {
      this.admin_department = admin_department;
   }

   public String getAdmin_position() {
      return admin_position;
   }

   public void setAdmin_position(String admin_position) {
      this.admin_position = admin_position;
   }
   
   

   public String getStudent_first_major() {
      return student_first_major;
   }


   public void setStudent_first_major(String student_first_major) {
      this.student_first_major = student_first_major;
   }


   @Override
   public String toString() {
      return "MemberDto [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_email="
            + user_email + ", user_phone=" + user_phone + ", user_address=" + user_address + ", user_birth="
            + user_birth + ", user_auth=" + user_auth + ", user_status=" + user_status + ", student_regidate="
            + student_regidate + ", student_term=" + student_term + ", student_year=" + student_year
            + ", student_total_credit=" + student_total_credit + ", student_term_grade=" + student_term_grade
            + ", student_total_grade=" + student_total_grade + ", student_major=" + student_major
            + ", student_first_major=" + student_first_major + ", prof_regidate=" + prof_regidate
            + ", prof_position=" + prof_position + ", prof_room=" + prof_room + ", prof_degree=" + prof_degree
            + ", prof_major=" + prof_major + ", admin_regidate=" + admin_regidate + ", admin_department="
            + admin_department + ", admin_position=" + admin_position + "]";
   }

}