<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
.inputtextcss{
    width: 300px;
    height: 40px;
    background: #fbfbfb;
    padding: 10px;
    border: 1px solid #e2e2e2;
    font-family: ng;
    font-size: 1.25em;
    color: #7f7f7f;
    float: left;
}
.formcss{
    border-left-width: 50px;
    padding-left: 150px;
    padding-top: 50px;
   /*  padding-bottom: 50px; */
    padding-right: 150px;
}
.buttoncss{
    border: #337ab7 solid 1px;
    color: white;
    padding: 0px;
    height: 34px;
    width: 100px;
    border-bottom-width: 1px;
    background-color: 337ab7;
    margin: 10px;
}
.tablecss tr{
	 height: 50px;
}
</style>
</head>
<body>
<section class="category-content col-sm-9">
    <h2 class="category-title">Login</h2> 

<form action="loginAf.do" id="_loginForm" method="post" class="formcss"> 
	<table>
	<tr style="height: 97px;">
		<td style="width: 90px;">아이디</td>
		<td><input type="text" name="user_id" id="user_id" data-msg="아이디" class="inputtextcss"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td> <input type="password" name="user_pw" id="user_pw" data-msg="비밀번호" class="inputtextcss"></td>
	</tr>
	</table>
</form>

	<div align="center">
		<a href="findId.do">아이디</a> <a href="findPw.do"> / 비밀번호 찾기</a>
		<button type="button" id="_btnLogin" class="buttoncss">로그인</button>
	</div>
	
	<br><br>

	<table class="table table-bordered table-hover">
		<tr>
		<td colspan="2">로그인별 대상 서비스 </td>
		</tr>
		<tr>
		<td style="width: 150px">학부재학생</td>
		<td>
		 	홈페이지 인증 서비스 모두 이용 가능<br>
		 	포털(인트라넷) 이용 가능 신상/주소 확인, 성적확인, 수강신청확인등<br>
		 	로그인 아이디는 별도의 신청없이 학번 사용</td>
		</tr>
		<tr>
		<td>교직원</td>
		<td>
		 	 홈페이지 인증 서비스 모두 이용 가능. 인트라넷 이용 가능<br>
			 로그인 아이디는 신청 후 사용 가능 
	    </td>
	    </tr>
	    <tr>
	    <td>졸업생</td>
		<td>
			홈페이지 인증 서비스 모두 이용 가능.인트라넷 이용 가능<br>
			성적학인, 정보확인<br>
			로그인 아이디는 별도의 신청없이 학번 사용, 아이디/비밀번호 조회
	    </td>
		</tr>
	</table>  
	
</section>


<script type="text/javascript">
$("#_btnLogin").click(function() {
	if($("#user_id").val() == ""){
		alert($("#user_id").attr("data-msg") + " 입력해 주십시오" );
		$("#user_id").focus();
	} else if($("#user_pw").val() == ""){
		alert($("#user_pw").attr("data-msg") + " 입력해 주십시오" );
		$("#user_pw").focus();
	}else{  
	
	$.ajax({
	    type : "POST",
	    data : { 
	       "user_id"   : $("#user_id").val() ,
	       "user_pw"   : $("#user_pw").val()
	    },
	    url : "./loginAf.do",
	    success : function(data) {
	       if(data == "로그인 성공"){
	    	   location.href="./main.do";
	       }else {
	    	   location.href="./login.do";
	       }
	    },
	    error : function(xhr, status, error) {
	       alert("아이디 또는 비밀번호를 다시 확인하세요");
	    }
	});
	
	}
});


$("#user_id").keypress(function(event) {
	if(event.which == "13"){
		event.preventDefault();
		$("#_btnLogin").click();
	}
});

$("#user_pw").keypress(function() {
	if(event.which == "13"){
		event.preventDefault();
		$("#_btnLogin").click();
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

