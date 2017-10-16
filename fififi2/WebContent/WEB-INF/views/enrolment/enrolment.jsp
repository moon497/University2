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
    border: 1px solid black;
}

table, th{
    text-align: center;
    border-collapse: collapse;
}

td{
	text-align: center;
	border-collapse: collapse;
}


</style>


<%
String major = (String)request.getAttribute("major");	// 검색
if(major == null) major = "0";
%>

<script>
var str = '<%=major %>';
$(document).ready(function(){
	document.form.major.value = str;
});
</script>


<form id="_form" name="form" action="#" method="post"> 
<table style="width:90%; text-align: center; border: 1px solid black; margin: auto">
<colgroup>
<col width="100"/><col width="100"/><col width="50"/><col width="50"/>
<col width="200"/><col width="80"/>
</colgroup>
<tr>
	<th>전공</th><th>이름</th><th>학년</th><th>학기</th>
	<th>과 선택</th><th>조회</th>
</tr>
<tr>
	<td>
		<input type="text" id="user_major" name="user_major" value="${user.major_number }" readonly>
	</td>
	<td>
		<input type="text" id="user_name" name="user_name" value="${user.user_name }" readonly>
	</td>
	<td>
		<input type="text" id="user_grade" name="user_grade" value="" readonly>
	</td>
	<td>
		<input type="text" id="user_semester" name="user_semester" value="" readonly>
	</td>
	
	<td>
		<select id="major" name="major" >			
			<option value="0" selected="selected">----------</option>
			<option value="100">기계공학</option>
			<option value="200">전기공학</option>
			<option value="300">컴퓨터공학</option>
		</select>	
	</td>
	
	<td text-align="center">
		<a href="#" id="_search" title="검색"><i class="fa fa-search" style="color:blue"></i></a>
	</td>
</tr>
</table>
</form>


<br><br>


<table style="width:90%; text-align: center; border: 1px solid black; margin: auto">
<colgroup>
<col width="100"/><col width="100"/><col width="50"/>
<col width="50"/><col width="150"/><col width="100"/>
<col width="100"/><col width="200"/><col width="100"/>
<col width="100"/><col width="100"/><col width="50"/>			
</colgroup>
<tr>
	<th>수강신청</th><th>전공/교양</th><th>학년</th>
	<th>학기</th><th>과목명</th><th>교수명</th>
	<th>강의소개</th><th>시간</th><th>강의실</th>
	<th>최대 인원</th><th>현재 인원</th><th>학점</th>
</tr>

<c:if test="${empty sublist }">
	<tr><td colspan="9" text-align="center">등록된 수업이 없습니다</td></tr>
</c:if>

<c:forEach items="${sublist }" var="sub" varStatus="vs">
<%-- <form id="_form${sub.sub_seq }" name="form2" action="#" method="post"> 

<input type="hidden" name="sub_seq" value="${sub.sub_seq }">
<input type="hidden" name="sub_category" value="${sub.sub_category }">
<input type="hidden" name="major_number" value="${sub.major_number }">
<input type="hidden" name="sub_grade" value="${sub.sub_grade }">
<input type="hidden" name="sub_semester" value="${sub.sub_semester }">
<input type="hidden" name="sub_name" value="${sub.sub_name }">
<input type="hidden" name="professor_id" value="${sub.professor_id }">
<input type="hidden" name="professor_name" value="${sub.professor_name }">
<input type="hidden" name="sub_info" value="${sub.sub_info }">
<input type="hidden" name="sub_room" value="${sub.sub_room }">
<input type="hidden" name="sub_week" value="${sub.sub_week }">
<input type="hidden" name="sub_s_class" value="${sub.sub_s_class }">
<input type="hidden" name="sub_e_class" value="${sub.sub_e_class }">
<input type="hidden" name="sub_max_student" value="${sub.sub_max_student }">
<input type="hidden" name="sub_now_student" value="${sub.sub_now_student }">
<input type="hidden" name="sub_point" value="${sub.sub_point }">
<input type="hidden" name="sub_ref" value="${sub.sub_ref }">
<input type="hidden" name="sub_parent" value="${sub.sub_parent }">
<input type="submit" name="submit" style="display:none;">

</form> --%>


	<tr>
		<td>
			<c:if test="${sub.sub_max_student ne 0 }">
				<a href="#" onclick="confirm(${sub.sub_seq })" id="addSub"><i class="fa fa-calendar-plus-o" style="color:blue"></i></a>
			</c:if>
			
		</td>
		<td>
			<c:if test="${sub.sub_category eq '100' }">전공</c:if>
			<c:if test="${sub.sub_category eq '200' }">교양</c:if>			
		</td>
		<td>${sub.sub_grade }</td>
		<td>${sub.sub_semester }</td>
		<td>${sub.sub_name }</td>
		<td>${sub.professor_name }</td>		
		<td>
			<a href="#" id="subDetail"><i class="fa fa-commenting-o" style="color:green"></i></a>	
		</td>
		<td>${sub.sub_week} / ${sub.sub_s_class } ~ ${sub.sub_e_class }</td>
		<td>${sub.sub_room}</td>
		<td>${sub.sub_max_student}</td>
		<td>${sub.sub_now_student}</td>
		<td>${sub.sub_point}</td>
	</tr>
</c:forEach>
</table>


<br><br>


<!-- 수강신청 결과목록 -->
<table id="answerList" style="width:90%; text-align: center; border: 1px solid black; margin: auto">
<colgroup>
<col width="100"/><col width="100"/><col width="50"/>
<col width="50"/><col width="150"/><col width="100"/>
<col width="100"/><col width="200"/><col width="100"/>
<col width="100"/><col width="100"/><col width="50"/>			
</colgroup>
<thead>
<tr>
	<th>삭제</th><th>전공/교양</th><th>학년</th>
	<th>학기</th><th>과목명</th><th>교수명</th>
	<th>강의소개</th><th>시간</th><th>강의실</th>
	<th>최대 인원</th><th>현재 인원</th><th>학점</th>
</tr>
</thead>
<tbody>
<!-- <tr>
	<th>#</th><th>전공</th><th>1</th>
	<th>2</th><th>수학I</th><th>윤필용</th>
	<th>기초 수학</th><th>2~3</th><th>A302</th>
	<th>25</th><th>8</th><th>3</th>
</tr> -->
</tbody>
</table>

<script type="text/javascript">
$(document).ready(function() {
	viewList();	
});


//검색 버튼 클릭시
$("#_search").click(function(){
	var major = $("#major").val();	
	if(major == 0){
		alert("과를 선택하십시오");
	}else{
		$("#_form").attr({"target":"_self", "action":"subsearch.do" }).submit();	
	}	
});



// 강의 소개 클릭시
$("#subDetail").click(function(){		
	$("#_form").attr({"target":"_self", "action":"subDetail.do" }).submit();		
});
function confirm(seq){
	// 수강신청 클릭시 	
	console.log("1/2");
	console.log("seq: " + seq);
	
	//INSERT 데이터 전송
	$.ajax({
		type: 'POST',
		url: 'addSub.do',
		data: {
			"sub_seq" : seq
		},		
		async: true, 
		success: function() {
			console.log("성공");
		}
	});

	console.log("2/2");
	viewList();
 }
function viewList() {
	$('#answerList > tbody').empty();
	//확인
	console.log("1/2");
	//SELECT 데이터 받기
	$.ajax({
		type: 'POST',
		url: 'asList.do',
		data: {
			"user_id" : '${login.user_id}'
		},
		async: true,
		success: function(data) {
			console.log("성공");
			console.log(data);
			
			$.each(data, function(i, item) {
				var htmlData = trForm(data[i]);
 				$('#answerList > tbody').append(htmlData);
			});
		}
	});
	console.log("2/2");
}
function trForm(json) {
	if (json.major_number == 100) {
		json.major_number = '전공';
	} else if (json.major_number == 200) {
		json.major_number = '교양';
	}
	
	var answer = "<tr>"
				+ "	<th><a href='./asDelete.do?seq="+json.sub_seq+"'>"+"#"+"</a></th><th>"+json.major_number+"</th><th>"+json.sub_grade+"</th>"
				+ "	<th>"+json.sub_semester+"</th><th>"+json.sub_name+"</th><th>"+json.professor_name+"</th>"
				+ "	<th>"+"#"+"</th><th>"+json.sub_week+json.sub_s_class+" ~ "+json.sub_e_class+"</th><th>"+json.sub_room+"</th>"
				+ "	<th>"+json.sub_max_student+"</th><th>"+json.sub_now_student+"</th><th>"+json.sub_point+"</th>"
				+ "</tr>";
				
	return answer;
}
</script>











