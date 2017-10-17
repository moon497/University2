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
	<td>${basicinfo.student_id       }</td>
</tr>
<tr>
	<th>학생이름</th>
	<td>${basicinfo.student_name     }</td>
</tr>

<tr>
	<th>전화번호</th>
	<td>${basicinfo.user_phone       }</td>
</tr>
<tr>
	<th>이메일</th>
	<td>${basicinfo.user_email       }</td>
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
	<td>${basicinfo.student_regidate }</td>
</tr>
<tr>
	<th>집주소</th>
	<td>${basicinfo.user_address     }</td>
</tr>
<tr>
	<th>졸업여부</th>
	<td>${basicinfo.user_status      }</td>
</tr>
</table>

</c:if>


</section> <!-- layout.xml 상 꼭 있어야함 지우지마세요! -->