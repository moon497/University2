<%@page import="kh.com.model.AssessmentDto"%>
<%@page import="kh.com.model.SubjectDto"%>
<%@page import="java.util.List"%>
<%@page import="java.awt.Button"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<head>
<fmt:requestEncoding value="utf-8"/>  
<style type="text/css">
.buttoncss{
    border: #337ab7 solid 1px;
    color: white;
    padding: 0px;
	width: 100px;
    border-bottom-width: 1px;
    background-color: 337ab7;
    height: 26px;
}

</style>
</head>
<body>

<section class="category-content col-sm-9">
    <h2 class="category-title">성적입력</h2> 
    <!-- 과목 리스트 탭 -->
    
    
<c:if test="${not empty subList}">
<ul class="nav nav-tabs">	
	  <c:forEach items="${subList }" var="sub" varStatus="vs">
	  <li><a href="gradeinput.do?seq=${sub.sub_seq }">${sub.sub_name}</a></li>
	  </c:forEach>
</ul>

	<form id="listform" action="gradeUpdate.do" method="POST">
		<input type="hidden" id="seq" name="seq" value="${param.seq }" />
		
		<c:if test="${not empty list}">
			<table border="1" style="text-align: center" class="table table-bordered table-hover">
			<colgroup>
				<col width="80">
				<col width="250">
				<col width="150">
				<col width="100">
				<col width="30">
			</colgroup>
		<tr>
			<td>번호</td> <td>과목이름</td> <td>학번</td> <td>학생 이름</td> <td>점수</td>
		</tr>
			<c:forEach items="${list }" var="as" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>${as.sub_name}</td>
					<td>${as.student_id}</td>
					<td>${as.student_name}</td>
					<td><input type="number" name="${as.student_id}" value="${as.student_score }" required="required" min="0" max="100"></td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
		<input type="submit" class="buttoncss" value="성적제출">
		<jsp:include page="./gradInputChart.jsp?list=${list }" flush="false"/> 
		</c:if>
	</form>
	

</c:if>
</section>

</body>
</html>