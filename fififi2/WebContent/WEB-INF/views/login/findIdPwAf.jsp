<%@page import="java.awt.Button"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.11.1.min.js"></script>
<style type="text/css">
.buttoncss{
	border: #337ab7 solid 1px;
    color: white;
    padding: 0px;
    width: 300;
    border-bottom-width: 1px;
    background-color: 337ab7;
    margin-top: 30px;
    margin-bottom: 50px;
    height: 30px;
}
</style>
</head>
<body>


<section class="category-content col-sm-9">
<h2 class="category-title">조회</h2> 

<c:if test="${not empty findid }">
	  <span style="font-size: 15px;">찾으시는 아이디는 ${findid } 입니다.</span><br>
	  <a href="findPw.do" style="color: white; text-decoration: none;"><span class="buttoncss">비밀번호찾기</span></a>
	  <a href="login.do" style="color: white; text-decoration: none;"><span class="buttoncss" >로그인</span></a>
</c:if>

<c:if test="${not empty findpw }">
	  <span style="font-size: 15px;">등록한 이메일 ${findpw }로 해당 비밀번호가 전송되었습니다.</span><br>
	  <a href="findId.do" style="color: white; text-decoration: none;"><span class="buttoncss">아이디찾기</span></a>
	  <a href="login.do" style="color: white; text-decoration: none;"><span class="buttoncss">로그인</span></a>
</c:if>
 
 <c:if test="${empty findid && empty findpw}">
	  <span style="font-size: 30px;"> 조회하신 아이디 또는 비밀번호가 맞지 않습니다.</span><br><br><br>
	 <a href="findId.do" style="color: white; text-decoration: none;"><span class="buttoncss">아이디찾기</span></a>
	 <a href="findPw.do" style="color: white; text-decoration: none;"><span class="buttoncss">비밀번호찾기</span></a>
	 <a href="login.do" style="color: white; text-decoration: none;"><span class="buttoncss">로그인</span></a>
</c:if>
</section>

</body>
</html>