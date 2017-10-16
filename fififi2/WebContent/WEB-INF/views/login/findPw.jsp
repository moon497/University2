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
.inputtextcss{
    width: 200px;
    height: 25px;
    padding: 5px;
    border: 1px solid #e2e2e2; 
}
.buttoncss{
    border: #337ab7 solid 1px;
    color: white;
    padding: 0px;
	width: 100px;
    border-bottom-width: 1px;
    background-color: 337ab7;
}
.tablecss tr{
	height:5px;
}
.tablecss td{
	padding: 5px; 
	padding-right: 50px;
} 
</style>
</head>
<body>

<section class="category-content col-sm-9">
    <h2 class="category-title">비밀번호 검색</h2> 
  <button type="button" id="find_id" class="buttoncss">아이디찾기</button>
  <button type="button" id="find_pw" class="buttoncss">비밀번호찾기</button>
  <br><br>

<form action="findPwAf.do" id="findPw" method="post"> 
    <table class="tablecss">
    <tr>
    	<td>아이디(학번)</td>
    	<td><input type="text" name="user_id" id="user_id" data-msg="아이디" class="inputtextcss"></td>
    </tr>
    <tr>
    	<td>성명</td>
    	<td><input type="text" name="user_name" id="user_name" data-msg="이름" class="inputtextcss"></td>
    </tr>
    <tr>
    	<td>학과(소속)</td>
    	<td>
    	<select name="major_number" id="major_number" data-msg="학과" style="width: 200px;">
			<option value="">학과선택</option>
			<option value="100">기계공학과</option>
			<option value="200" >간호학과</option>
			<option value="300">컴퓨터공학과</option>
			<option value="400">경영학과</option>
			<option value="500">시각디자인학과</option>
			<option value="600">국어교육과</option>
			<option value="700">사회복지학과</option>
		</select>
		</td>
    </tr>
	 <tr>
    	<td>이메일</td>
    	<td><input type="text" name="user_email" id="user_email" data-msg="이메일" class="inputtextcss"></td>
    </tr>
    </table>
 
    <button id="find" >조회</button>
</form>
     
</section>   
<script type="text/javascript">
 $("#find_pw").click(function() {
	location.href="findPw.do";
 });   
 $("#find_id").click(function() {
	location.href="findId.do";
});    
 
 
 $("#find").click(function() {
		if($("#user_name").val() == ""){
			alert($("#user_name").attr("data-msg") + " 입력해 주십시오" );
			$("#user_name").focus();
		} else if($("#major_number").val() == ""){
			alert($("#major_number").attr("data-msg") + " 입력해 주십시오" );
			$("#user_pw").focus();
		} else if($("#user_email").val() == ""){
			alert($("#user_email").attr("data-msg") + " 입력해 주십시오" );
			$("#user_email").focus();
		} else if($("#user_id").val() == ""){
			alert($("#user_id").attr("data-msg") + " 입력해 주십시오" );
			$("#user_id").focus();
		}  
		else{
			$("#findPw").attr("target", "_self").submit();
		}	
});
 
$(function() {
	    $("input").focus(function () {
	        $(this).css("border", "2px solid #337ab7");
	    });
	    $("input").blur(function () { //포커스를 잃었을때
	        $(this).css("border", "1px solid #e2e2e2");
	    });
});

 
</script>


</body>
</html>