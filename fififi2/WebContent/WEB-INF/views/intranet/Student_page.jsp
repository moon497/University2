<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<fmt:requestEncoding value="utf-8"/> 
<style>
#studentGrade_table{
	width: 100%;
}
#studentGrade_table * {
	font-size: 12px;
}
#studentGrade_table th, td {
	color: #404040;
	border-collapse: collapse;
	border: 1px solid #e7e7e7;
	text-align: center;
}
#studentGrade_table th {
	font-size: 13px;
	text-align: left;
	width:20%;
	padding-left: 11px;
}
#studentGrade_table tr {
	height: 35px;
}
#studentGrade_table td {
	width: 80%;
	text-align: left;
	padding-left: 11px;
}
.question {
	text-align: left;
}
.removeInputStyle {
	border: none;
	border-right: 0px;
	border-top: 0px;
	text-align: center;
	width: 100%;
}
input {
	border: 0px;
}
</style>
<section class="category-content col-sm-9">
    <h2 class="category-title">내정보(학생)</h2> 

<!-- 로그아웃 -->
<c:if test="${empty login.user_id}">
<table id="assesment_table" style="width: 100%;">
	<colgroup>
		<col width="100">
	</colgroup>
	<tr>
		<td>로그인 해주세요.</td>
	</tr>
</table>
</c:if>

<c:if test="${not empty login.user_id}">
<form id="updateStudentInfo">
<table id="studentGrade_table">
	<colgroup>
		<col width="100">
		<col width="100">
	</colgroup>
<tr>
	<th rowspan="4" style="padding: 0px;">
		<img src="${pageContext.request.contextPath }/upload/reg/${basicinfo.user_photo }" style="width:100%;">
	</th>
	<th>학번</th>
	<td>
		<input type="text" name="student_id" readonly value="${basicinfo.student_id }">
	</td>
</tr>
<tr>
	<th>학생이름</th>
	<td>
		<input type="text" name="student_name" readonly value="${basicinfo.student_name }">
	</td>
</tr>
<tr>
	<th>전화번호</th>
	<td>
		<input type="text" name="user_phone" readonly value="${basicinfo.user_phone }">
	</td>
</tr>
<tr>
	<th>이메일</th>
	<td>
		<input type="text" name="user_email" readonly value="${basicinfo.user_email }">
	</td>
</tr>
</table>

<br style="height:30px;">

<table id="studentGrade_table">
	<colgroup>
		<col width="100">
		<col width="100">
	</colgroup>
<tr>
	<th>입학년도</th>
	<td>
		<input type="text" name="student_regidate" readonly value="${basicinfo.student_regidate }">
	</td>
</tr>
<tr>
	<th>집주소</th>
	<td>
		<input type="text" name="user_address" readonly value="${basicinfo.user_address }">
	</td>
</tr>
<tr>
	<th>졸업여부</th>
	<td>
		<input type="text" name="user_status" readonly value="${basicinfo.user_status }">
	</td>
</tr>
</table>
</form>
<button id="updateStudentInfoBtn">정보수정</button>
<button id="successStudentInfoBtn">수정완료</button>

<script>
/*
 * 수정완료버튼 초기 숨김
 */
$('#successStudentInfoBtn').hide();
/*
 * 정보수정 클릭시 readOnly
 */
$('#updateStudentInfoBtn').click(function () {
	// 전화번호
	$('input[name=user_phone]').removeAttr("readonly");
	$('input[name=user_phone]').css({"border":"1px solid #e7e7e7", 
										   "padding-left":"3px"});
	// 이메일
	$('input[name=user_email]').removeAttr("readonly");
	$('input[name=user_email]').css({"border":"1px solid #e7e7e7", 
										   "padding-left":"3px"});
	// 주소
	$('input[name=user_address]').removeAttr("readonly");
	$('input[name=user_address]').css({"border":"1px solid #e7e7e7", 
										   "padding-left":"3px"});
	// 정보수정 최종버튼 보여주기
	$('#successStudentInfoBtn').show();
});
/*
 * 정보변경 클릭시 정보변경Controller .do 부르기
 */
$('#successStudentInfoBtn').click(function () {
	// 클릭 후 이벤트
	$.ajax({
	       type : "POST",
	       data : { 
	          "student_id"   : $('input[name=student_id]').val() ,
	          "user_phone"   : $('input[name=user_phone]').val() ,
	          "user_email"   : $('input[name=user_email]').val() ,
	          "user_address" : $('input[name=user_address]').val()
	       },
	       url : "./updateStudentInfo.do",
	       success : function(data) {
	    	   alert(data);
	    	   window.location.reload();
	       },
	       error : function(xhr, status, error) {
	          alert("통신불가");
	       }
    });
});

</script>
</c:if>


</section> <!-- layout.xml 상 꼭 있어야함 지우지마세요! -->