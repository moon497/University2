<%@page import="kh.com.model.ProfEvaluationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<fmt:requestEncoding value="UTF-8"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>

<style>
table {
    border-collapse: collapse;
}

table, th{
    border: 1px solid black;
    text-align: center;
}

td{
	text-align: center;
}
</style>


<c:set var="login" value="${login.user_id }" />
					<c:if test="${login eq null}">
						    <script type="text/javascript">
						       alert("로그인 후 이용해주세요.");
						       location.href = "login.do";
						    </script>
					</c:if>
<table class="table table-hover table-bordered">
<colgroup>
<col class="col-sm-1" />
<col class="col-sm-3" />
<col class="col-sm-1" />
<col class="col-sm-1" />
<col class="col-sm-2" />
<col class="col-sm-2" />
<col class="col-sm-1" />
<col class="col-sm-1" />
</colgroup>
<tr>
<th>전공/교양</th><th>과목명</th><th>학년</th><th>교수명</th><th>시간</th>
<th>학과</th><th>학점</th><th>E-Class</th>
</tr>

<c:if test="${empty eclist }">
	<tr><td colspan="9">등록된 수업이 없습니다</td></tr>
</c:if>

<c:forEach items="${eclist }" var="ec" varStatus="ecC">
	<tr>
		<td>
			<c:if test="${ec.sub_category eq '100' }">전공</c:if>
			<c:if test="${ec.sub_category eq '200' }">교양</c:if>
		</td>
		<td>${ec.sub_name }</td>
		<td>${ec.sub_grade }</td>
		<td>${ec.professor_name }</td>
		<td>${ec.sub_s_class }교시 ~ ${ec.sub_e_class } 교시 </td>
		<c:set var="major" value="${ec.major_number }" />
		<td>
		${ec.major_number }
		</td>
		<td>${ec.sub_point }</td>
		<td><a href="#" onclick="seqSumit('${ec.sub_seq}')" ><i class="fa fa-arrow-right" style="color:black;"></i></a></td>
	</tr>
	</c:forEach>
</table>

<script type="text/javascript">
function seqSumit(sub_seq) {
	location.href = 'E_Bbslist.do?sub_seq=' + sub_seq;
}
</script>
