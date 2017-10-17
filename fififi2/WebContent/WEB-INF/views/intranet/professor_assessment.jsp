<%@page import="kh.com.model.I_ProfEvaluationDTO"%>
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
#assesment_table * {
	font-size: 12px;
}

#assesment_table th, td {
	color: #404040;
	border-collapse: collapse;
	border: 1px solid #e7e7e7;
	text-align: center;
}

#assesment_table th {
	font-size: 13px;
}

#assesment_table tr {
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
    <h2 class="category-title">교수평가</h2> 
    
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
<c:if test="${empty assessmentList}">
<table id="assesment_table" style="width: 100%;">
	<colgroup>
		<col width="100">
	</colgroup>
	<tr>
		<td>평가가능한 과목이 없습니다.</td>
	</tr>
</table>
</c:if>

<c:if test="${not empty assessmentList}">
<form id="assesment">
<input type="hidden" name="student_id" value="${login.user_id}"> <!-- 학생아이디 -->
<input type="hidden" name="student_name"> <!-- 학생이름 -->
<input type="hidden" name="professor_id"> <!-- 교수아이디 -->
<input type="hidden" name="critics"> <!-- 합한점수 보내주는.. -->

<!-- 교수선택 -->
<select id="choiceProfessor">
	<c:forEach var="pe" items="${assessmentList }" varStatus="PeS">
		<option name="sub_seq" value="${pe.sub_seq }" selected="selected">${pe.professor_name } 교수님 > ${pe.sub_name }</option>
	</c:forEach>
</select>
<!-- 질문테이블 -->
<table id="assesment_table">
<colgroup>
	<col width="100">
	<col width="100">
	<col width="80">
	<col width="300">
	<col width="80">
	<col width="80">
	<col width="50">
	<col width="80">
	<col width="80">
</colgroup>
	<tr>
		<th>교수이름</th>
		<th>과목이름</th>
		<th>문항번호</th>
		<th>내용</th>
		<th>매우별로</th>
		<th>조금별로</th>
		<th>보통</th>
		<th>조금좋다</th>
		<th>매우좋다</th>
	</tr>
	<%
		String [] questionList = {
				"교수는 학생들이 흥미를 갖고 수업에 몰입할 수 있도록 성실히 지도하였다.",
				"교수는 학생의 활동이나 과제에 대해 적절한 피드백을 제공하였다.",
				"수업목표, 내용, 방법에 따른 합리적인 성적평가 방법과 기준이 안내되었다.",
				"교수는 학생의 활동이나 과제에 대해 적절한 피드백을 제공하였다.",
				"강의는 교과와 관련된 실력 향상에 도움을 주었다."
		};
	%>
	<tr>
		<td rowspan="6">
			<input type="text" name="professor_name" readonly="readonly" class="removeInputStyle"> 교수님
		</td>
		<td rowspan="6">
			<input type="text" name="sub_name" readonly="readonly" class="removeInputStyle">
		</td>
		<%
			for(int i=0; i<questionList.length; i++){
		%>
		<td><%=i+1 %>
		</td>
		<td class="question"><%=questionList[i] %></td>
		<td>
			<input type="radio" name="question<%=i+1 %>" value="1">
		</td>
		<td>
			<input type="radio" name="question<%=i+1 %>" value="2">
		</td>
		<td>
			<input type="radio" name="question<%=i+1 %>" value="3">
		</td>
		<td>
			<input type="radio" name="question<%=i+1 %>" value="4">
		</td>
		<td>
			<input type="radio" name="question<%=i+1 %>" value="5">
		</td>
	</tr>
	<%
		}
	%>
	<tr>
		<td>
			기타<br>의견
		</td>
		<td colspan="8">
			<textarea id="othersThings" style="width: 100%; height:59px;">기타의견</textarea>
		</td>
	</tr>
	
</table>
<button type="button" id="submitBtn">제출하기</button>
<button type="reset">처음부터</button>
</form>
</c:if>
</c:if>
<script>
//교수 및 과목선택시
var sub_names = ""; // 과목이름
var professor_names =""; // 교수이름
$('#choiceProfessor').change(function(){ 
	var sub_seq = parseInt($(this).val()); // 받아온 sub_seq
	
	// -------------------------------------------------------
	var sseq = new Array();  			// sub_seq
	var sub_name = new Array();			// 과목명
	var professor_id = new Array();		// 교수ID
	var professor_name = new Array();	// 교수이름
	var student_name = new Array();		// 학생이름
	// -------------------------------------------------------
	
	<c:forEach items="${assessmentList}" var="item1" varStatus="PeS">
		sseq.push("${item1.sub_seq}");		// sub_seq
		sub_name.push("${item1.sub_name}"); // 과목명
		professor_id.push("${item1.professor_id}"); // 과목명
		professor_name.push("${item1.professor_name}"); // 교수이름
		student_name.push("${item1.student_name}"); // 학생이름
	</c:forEach>
		
	for(var i=0; i < sseq.length; i++){
		if(sseq[i] == sub_seq){
			sub_names = sub_name[i];
			professor_id = professor_id[i]; 
			professor_names = professor_name[i]; 
			student_name = student_name[i]; 
			$('input[name=sub_name]').val(sub_names);	// 과목명
			$('input[name=professor_id]').val(professor_id);	// 교수ID
			$('input[name=professor_name]').val(professor_names); // 교수이름
			$('input[name=student_name]').val(student_name); // 학생이름
		}
	} 
});

// 제출하기 버튼 클릭
$("#submitBtn").click(function () {
	questionCheck();
});

// 제출하기 버튼 클릭시 해당매소드 호출
function questionCheck(){
	var list1 = new Array();  // 총 리스트 갯수 구하기
	var sub_name = new Array();   // 과목명
	var sub_seq = new Array();
	<c:forEach items="${assessmentList}" var="item1" varStatus="PeS">
		list1.push("${PeS.count}");
		sub_name.push("${item1.sub_name}")
	</c:forEach>
	
	var questions = ""; // 문항에 답한 값 확인용
	var isNotNull = "pass"; // 문항에 답했는지 확인용
	var critics = "0"; // 답한 값 합하는용
	for(j=1 ; j <= 5; j++){
		// 문항에 checked된 값을 가져온다.
		questions = $('input:radio[name=question'+ j + ']:checked').val();
		critics = parseInt(questions) + parseInt(critics);
		if(questions == null){
			alert(j + "번째 문항에 답하지 않으셨습니다.");
			isNotNull = "fail";
		}
	}
	
	// 모두 입력되었을 때 그 값을 넘겨주는 메소드
    if(isNotNull == "pass"){
		$('input[name=critics]').val(critics);
    	alert("수고하셨습니다.");
		addAssessment(); // AJAX 호출
    }
}

// 컨트롤러로 데이터 전송
function addAssessment(){
	$.ajax({
        type : "POST",
        data : { 
           "sub_seq"  : $('[name="sub_seq"]').val(),
           "student_id" : $('[name="student_id"]').val(),
           "student_name" : $('[name="student_name"]').val(),
           "professor_id" : $('[name="professor_id"]').val(),
           "professor_name" : $('[name="professor_name"]').val(),
           "Air_seatCntInf" : $('[name="Air_seatCntInf"]').val(),
           "professor_name" : $('[name="professor_name"]').val(),
           "critic" : $('[name="critics"]').val()
        },
        url : "./assessmentAf.do",
        success : function(data) {
        	alert(data);
        	window.location.reload();
        },
        error : function(xhr, status, error) {
           alert("통신불가");
        }
     });
}

//기타의견에 값이 있으면..
var ontherthings = "";
$('#othersThings').focusin(function () {
	var confirm = $('#othersThings').val();
	if(ontherthings == ''){
		$('#othersThings').val('');
	}
});

$('#othersThings').focusout(function () {
	var confirm = $('#othersThings').val();
	ontherthings = confirm;
	if(confirm == ''){
		$('#othersThings').val('기타의견');
	}
});

</script>
<!-- F5막는 코드 -->
<script language=JavaScript1.2> 
function noEvent() {
	if (event.keyCode == 116) {
		event.keyCode= 2;
		return false;
	}else if(event.ctrlKey && (event.keyCode==78 || event.keyCode == 82)){
		return false;
	}
}
document.onkeydown = noEvent;
</script> 
</section> <!-- layout.xml 상 꼭 있어야함 지우지마세요! -->