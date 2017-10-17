<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<fmt:requestEncoding value="UTF-8"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>



<form action="#.do" method="post" id="form">
<table class="table table-bordered table-hover">
<thead>
<tr>
	<th>번호</th><th>전공/교양</th><th>과목명</th>
	<th>강의실</th><th>요일/시간</th><th>최대인원</th>
	<th>시간 추가</th><th>삭제</th>	
</tr>
</thead>

<tbody>
	<c:if test="${empty reglist }">
	<tr><td colspan="9">등록된 강의가 없습니다</td></tr>
	</c:if>

	<c:forEach items="${reglist }" var="reg" varStatus="vs">
	<tr>
		<td>${vs.count }</td>
		<td>
			<c:if test="${reg.sub_category eq '100' }">전공</c:if>
			<c:if test="${reg.sub_category eq '200' }">교양</c:if>
		</td>
		<td>${reg.sub_name }</td>
		<td>${reg.sub_room }</td>
		<td>${reg.sub_week } / ${reg.sub_s_class }교시 ~ ${reg.sub_e_class }교시</td>
		<td>${reg.sub_max_student }</td>		
		<td style="text-align: -webkit-center;">
		<c:if test="${reg.sub_max_student ne 0 }">
			<a href="addReg.do?seq=${reg.sub_seq }"><i class="fa fa-plus-square" style="color:green"></i></a>
		</c:if>
		</td>
		<td style="text-align: -webkit-center;">
			<a onclick="deleteReg('${reg.sub_seq}')" href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
		</td>
	</tr>
	</c:forEach>
	
</tbody>

</table>
</form>
<script type="text/javascript">
function deleteReg(seq){
	if (confirm("정말 삭제하시겠습니까??") == true){//확인
		location.href='delReg.do?seq='+seq;
	}else{   //취소
	    return;
	}
	
}
</script>






