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
#professor_table{
	width: 100%;
}
#professor_table * {
	font-size: 12px;
}
#professor_table th, td {
	color: #404040;
	border-collapse: collapse;
	border: 1px solid #e7e7e7;
	text-align: center;
}
#professor_table th {
	font-size: 13px;
	text-align: left;
	width:20%;
	padding-left: 11px;
}
#professor_table tr {
	height: 35px;
}
#professor_table td {
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
    <h2 class="category-title">내정보(교수)</h2> 

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
<form id="updateProfessorInfo" method="post" action="#">
<table id="professor_table">
	<colgroup>
		<col width="100">
		<col width="100">
	</colgroup>
<tr>
	<th rowspan="4" style="padding: 0px;">
		<img src="${pageContext.request.contextPath }/upload/reg/${prof.user_photo }" style="width:100%;">
	</th>
	<th>아이디</th>
	<td>
		<input type="text" name="user_id" readonly value="${prof.user_id }">
	</td>
</tr>
<tr>
	<th>교수이름</th>
	<td>
		<input type="text" name="user_name" readonly value="${prof.user_name }">
	</td>
</tr>
<tr>
	<th>전화번호</th>
	<td>
		<input type="text" name="user_phone" readonly value="${prof.user_phone }">
	</td>
</tr>
<tr>
	<th>이메일</th>
	<td>
		<input type="text" name="user_email" readonly value="${prof.user_email }">
	</td>
</tr>
</table>

<br style="height:30px;">

<table id="professor_table">
	<colgroup>
		<col width="100">
		<col width="100">
	</colgroup>
<tr>
	<th>임용일</th>
	<td>
		<input type="text" name="prof_regidate" readonly value="${prof.prof_regidate }">
	</td>
</tr>
<tr>
	<th>교수직위</th>
	<td>
		<input type="text" name="prof_position" readonly value="${prof.prof_position }">
	</td>
</tr>
<tr>
	<th>연구실</th>
	<td>
		<input type="text" name="prof_room" readonly value="${prof.prof_room }">
	</td>
</tr>
<tr>
	<th>교수학위</th>
	<td>
		<input type="text" name="prof_degree" readonly value="${prof.prof_degree }">
	</td>
</tr>
</table>
</form>
<button id="updateProfessorInfoBtn">정보수정</button>
<button id="successProfessorInfoBtn">수정완료</button>

<script>
$('#successProfessorInfoBtn').hide();
$('#updateProfessorInfoBtn').click(function () {
	// 전화번호
	$('input[name=user_phone]').removeAttr("readonly");
	$('input[name=user_phone]').css({"border":"1px solid #e7e7e7", 
										   "padding-left":"3px"});
	// 이메일
	$('input[name=user_email]').removeAttr("readonly");
	$('input[name=user_email]').css({"border":"1px solid #e7e7e7", 
										   "padding-left":"3px"});
	// 연구실
	$('input[name=prof_room]').removeAttr("readonly");
	$('input[name=prof_room]').css({"border":"1px solid #e7e7e7", 
										   "padding-left":"3px"});
	// 교수학위
	$('input[name=prof_degree]').removeAttr("readonly");
	$('input[name=prof_degree]').css({"border":"1px solid #e7e7e7", 
										   "padding-left":"3px"});
	// 정보수정 최종버튼 보여주기
	$('#successProfessorInfoBtn').show();
});

$('#successProfessorInfoBtn').click(function () {
	$("#updateProfessorInfo").attr({ "target":"_self", "action":"updateProInfo.do" }).submit();
});

</script>

</c:if>


</section> <!-- layout.xml 상 꼭 있어야함 지우지마세요! -->