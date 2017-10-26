<%@page import="kh.com.model.I_StudentGradeDTO"%>
<%@page import="kh.com.model.ProfEvaluationDTO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<fmt:requestEncoding value="utf-8"/> 
<style>
#studentGrade_table {
	width:100%;
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
}

#studentGrade_table tr {
	height: 35px;
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
    <h2 class="category-title">성적확인</h2> 

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

<!-- 로그인 -->
<c:if test="${not empty login.user_id}">
<input type="hidden" name="student_id" value="${login.user_id }">
<!-- 질문테이블 -->
<c:if test="${confirm == 'existNullgrade' }">
<table id="studentGrade_table">
	<tr>
		<td colspan="7">아직 등록되지 않은 평가과목이 존재합니다.</td>
	</tr>
</table>
</c:if>
<c:if test="${confirm == 'notseason' }">
<table id="studentGrade_table">
	<tr>
		<td colspan="7">성적확인기간이 아닙니다.</td>
	</tr>
</table>
</c:if>

<c:if test="${confirm == 'notexistNullgrade' }">
<table id="studentGrade_table">
<colgroup>
	<col width="150">
	<col width="300">
	<col width="100">
	<col width="150">
	<col width="50">
	<col width="50">
	<col width="100">
	<col width="50">
</colgroup>
	<thead>
	<tr>
		<th>학생이름</th>
		<th>과목명</th>
		<th>전공여부</th>
		<th>담당교수명</th>
		<th colspan="2">점수</th>
		<th>이수학점</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="grade" items="${StudentGrade }" varStatus="gs">
	<tr>
		<td>${grade.student_name }</td>
		<td>${grade.sub_info }</td>
		<td>
			<c:if test="${grade.sub_category == 100}">
			전공
			</c:if>
			<c:if test="${grade.sub_category == 200}">
			교양
			</c:if>
		</td>
		<td>${grade.professor_name }</td>
		<td>${grade.student_score }</td>
		<td>
			<c:if test="${grade.student_score <= 100 && grade.student_score >= 95 }">
				A+
			</c:if>
			<c:if test="${grade.student_score <= 94 && grade.student_score >= 90 }">
				A0
			</c:if>
			<c:if test="${grade.student_score <= 89 && grade.student_score >= 85 }">
				B+
			</c:if>
			<c:if test="${grade.student_score <= 84 && grade.student_score >= 80 }">
				B0
			</c:if>
			<c:if test="${grade.student_score <= 79 && grade.student_score >= 75 }">
				C+
			</c:if>
			<c:if test="${grade.student_score <= 74 && grade.student_score >= 70 }">
				C0
			</c:if>
			<c:if test="${grade.student_score <= 69 && grade.student_score >= 65 }">
				D+
			</c:if>
			<c:if test="${grade.student_score <= 64 && grade.student_score >= 60 }">
				D0
			</c:if>
			<c:if test="${grade.student_score <= 59 && grade.student_score >= 0 }">
				F
			</c:if>
		</td>
		<td>
			${grade.sub_point }
			<input type="hidden" name="grade_confirm" value="${grade.grade_confirm }" >
			<input type="hidden" name="listSize" value="${fn:length(StudentGrade) }" >
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>

<div>
<button id="gradeConfirmBtn">성적확인 완료</button>
</div>
</c:if>
</c:if>
<script>
$(document).ready(function () {
	$('#gradeConfirmBtn').hide();
	
	var gradeConfirm = $('grade_confirm').val();
	var listSize = $('input[name=listSize]').val();
	if(listSize > 0){
		$('#gradeConfirmBtn').show();
	}
});

$('#gradeConfirmBtn').click(function () {
	$.ajax({
        type : "POST",
        data : { 
           "student_id" : $('[name="student_id"]').val()
        },
        url : "./gradeConfirm.do",
        success : function(data) {
        	alert(data);
        	$('#studentGrade_table > thead').empty();
        	$('#studentGrade_table > tbody').empty();
        	$('#studentGrade_table > tbody').prepend("<tr><td colspan='7'>성적을 확인하셨습니다.<br></td></tr>");
        	$('#gradeConfirmBtn').hide();
        },
        error : function(xhr, status, error) {
           alert("통신불가");
        }
     });
});
</script>


</section> <!-- layout.xml 상 꼭 있어야함 지우지마세요! -->