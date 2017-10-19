<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<fmt:requestEncoding value="UTF-8"/>

<section class="category-content col-sm-12">
    <h2 class="category-title">수강신청</h2> 

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
	<div class="table-responsive">
		<table class="table table-bordered table-hover">
			<tr>
				<th>전공</th><th>이름</th><th>학년</th><th>학기</th>
				<th>과 선택</th><th>조회</th>
			</tr>
			<tr>
				<td>
					<input class="col-sm-12" type="text" id="student_major" name="student_major" value="${student.student_major }" readonly>
				</td>
				<td>
					<input class="col-sm-12" type="text" id="student_name" name="student_name" value="${student.student_name }" readonly>
				</td>
				<td>
					<input class="col-sm-12" type="text" id="student_year" name="student_year" value="${student.student_year }" readonly>
				</td>
				<td>
					<input class="col-sm-12" type="text" id="student_term" name="student_term" value="${student.student_term }" readonly>
				</td>
				
				<td class="col-sm-2">
					<select id="major" name="major" >			
						<option value="0" selected="selected">----------</option>
						<option value="100">기계공학</option>
						<option value="200">전기공학</option>
						<option value="컴퓨터공학과">컴퓨터공학</option>
						<option value="유아교육학과">유아교육</option>
						<option value="정치외교학과">정치외교</option>
					</select>	
				</td>
				
				<td class="col-sm-1" style="text-align: -webkit-center;">
					<a href="#" id="_search" title="검색"><i class="fa fa-search" style="color:blue"></i></a>
				</td>
			</tr>
		</table>
	</div>
</form>


<br><br>

<!-- 수강신청 과목 목록  -->
<div class="table-responsive">
	<table id="subList" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>수강신청</th>
				<th>전공/교양</th>
				<th>학년</th>
				<th>학기</th>
				<th>과목명</th>
				<th>교수명</th>
				<th>강의소개</th>
				<th>시간</th>
				<th>강의실</th>
				<th>최대 인원</th>
				<th>현재 인원</th>
				<th>학점</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td colspan="12" text-align="center">수강할 과목이 없습니다</td>
			</tr>
		</tbody>
	</table>
</div>

<br><br>


<!-- 수강신청 결과목록 -->
<div class="table-responsive">
	<table id="resultList" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>삭제</th>
				<th>전공/교양</th>
				<th>학년</th>
				<th>학기</th>
				<th>과목명</th>
				<th>교수명</th>
				<th>강의소개</th>
				<th>시간</th>
				<th>강의실</th>
				<th>최대 인원</th>
				<th>현재 인원</th>
				<th>학점</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="12" text-align="center">선택한 과목이 없습니다</td>
			</tr>
		</tbody>
	</table>
</div>

<br><br>


<div class="table-responsive">
	<form action="#" id="_frmForm" method="post">
	<table id="checkPoint" class="table table-bordered table-hover">	
		<thead>
			<tr>
				<th>이름</th>
				<th>학년</th>
				<th>학기</th>
				<th>총 학점</th>
			</tr>
		</thead>

		<tbody>

		</tbody>

		<tfoot>
			<tr>
				<td colspan="4" style="text-align: -webkit-center;">
				<input type="button" onclick="result()" id="complete" class="btn btn-info" value="완료" ></td>
			</tr>
		</tfoot>

	</table>
	</form>
</div>


<div class="container"> 
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
                
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">강의 소개</h4>
        </div>
        
        <div class="modal-body">
          <p>This is a small modal.</p>
        </div>        
        
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
$(document).ready(function() {
	subList('0');	
	resultList();
	checkPoint();
});

//검색 버튼 클릭시
$("#_search").click(function(){
	var major = $("#major").val();
	
	console.log(major);
	
	if(major == 0){
		alert("과를 선택하십시오");
	}else{
		subList(major);		
	}	
	
	
});

// 강의 소개 클릭시
$("#subDetail").click(function(){		
	$("#_form").attr({"target":"_self", "action":"subDetail.do" }).submit();		
});

// 강의목록 표시
function subList(major){	
	$('#subList > tbody').empty();
	//확인
	console.log("subList 1/2");
	//SELECT 데이터 받기
	$.ajax({
		type: 'POST',
		url: 'sublist.do',
		data: {
			"user_id" : '${login.user_id}',
			"major" : major
		},
		async: true,
		success: function(data) {
			console.log("성공");
			console.log(data);
			
			// ajax반복문 
			$.each(data, function(i, item) {
				var htmlData = trForm2(data[i]);
 				$('#subList > tbody').append(htmlData);
			});
		}
	});
	console.log("subList 2/2");
	
}

// 강의목록 표시 보조
function trForm2(data){
	console.log("trform2 1/2");
	if (data.sub_category == 100) {
		data.sub_category = '전공';
	} else if (data.sub_category == 200) {
		data.sub_category = '교양';
	}
		
	var form = "";
	
	if(data.sub_max_student == data.sub_now_student){
		form = "<tr>" 
			+ "<td></td><td>"+ data.sub_category +"</td>"
			+ "<td>"+ data.sub_grade +"</td><td>"+ data.sub_semester +"</td>"
			+ "<td>"+ data.sub_name+"</td><td>"+ data.professor_name +"</td>"
			+ "<td style='text-align: -webkit-center;'>"
			+ "<a href='#' id='subDetail' onclick=\"subDetail('"+ data.sub_info +"')\" data-toggle='modal' data-target='#myModal'><i class='fa fa-commenting-o' style='color:green'></i></a>"
			+ "</td>"
			+ "<td>"+ data.sub_week + "/" + data.sub_s_class + "~" + data.sub_e_class +"</td>"
			+ "<td>"+ data.sub_room +"</td><td>"+ data.sub_max_student +"</td>"
			+ "<td>"+ data.sub_now_student +"</td><td>"+ data.sub_point +"</td>"
			+ "</tr>";		
	}else{
		form = "<tr>" 
			+ "<td style='text-align: -webkit-center;'><a href='#' onclick='confirm("+ data.sub_seq +")' id='addSub'><i class='fa fa-calendar-plus-o' style='color:blue'></i></a></td>"
			+ "<td>"+ data.sub_category +"</td>"
			+ "<td>"+ data.sub_grade +"</td><td>"+ data.sub_semester +"</td>"
			+ "<td>"+ data.sub_name+"</td><td>"+ data.professor_name +"</td>"
			+ "<td style='text-align: -webkit-center;'>"
			+ "<a href='#' id='subDetail' onclick=\"subDetail('"+ data.sub_info +"')\" data-toggle='modal' data-target='#myModal'><i class='fa fa-commenting-o' style='color:green'></i></a>"
			+ "</td>"
			+ "<td>"+ data.sub_week + "/" + data.sub_s_class + "~" + data.sub_e_class +"</td>"
			+ "<td>"+ data.sub_room +"</td><td>"+ data.sub_max_student +"</td>"
			+ "<td>"+ data.sub_now_student +"</td><td>"+ data.sub_point +"</td>"
			+ "</tr>";
	}
	console.log("trform2 2/2");
			
	return form;	
}

function subDetail(info) {
	$(".modal-body").empty();
	$(".modal-body").append(info);
} 
/* 
$(function(){
    $("#popbutton").click(function(){
    	alert("ddd");
        $('div.modal').modal();
    })
});
 */


//수강신청 클릭시 	
function confirm(seq){
	var major = $("#major").val();
	alert("수강 신청");
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
	console.log("메이저 확인: " + major);
	
	resultList();
	subList(major);
	checkPoint();
}


// 화면에 나의 수강목록 표시 
function resultList() {
	$('#resultList > tbody').empty();
	//확인
	console.log("resultList 1/2");
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
			
			// ajax반복문 
			$.each(data, function(i, item) {
				var htmlData = trForm(data[i]);
 				$('#resultList > tbody').append(htmlData);
			});
		}
	});
	console.log("resultList 2/2");
}

// 나의 수강목록 보조
function trForm(json) {	
	if (json.sub_category == 100) {
		json.sub_category = '전공';
	} else if (json.sub_category == 200) {
		json.sub_category = '교양';
	}
	
	var answer = "";
	
	if(json.sub_max_student == json.sub_now_student){
		answer = "<tr>"
			+ "	<td></th>"
			+ " <td>"+json.sub_category+"</td><td>"+json.sub_grade+"</td>"
			+ "	<td>"+json.sub_semester+"</td><td>"+json.sub_name+"</td><td>"+json.professor_name+"</td>"
			+ "<td style='text-align: -webkit-center;'>"
			+ "<a href='#' id='subDetail' onclick=\"subDetail('"+ json.sub_info +"')\" data-toggle='modal' data-target='#myModal'><i class='fa fa-commenting-o' style='color:green'></i></a>"
			+ "</td>"
			+ " <td>"+json.sub_week+json.sub_s_class+" ~ "+json.sub_e_class+"</td><td>"+json.sub_room+"</td>"
			+ "	<td>"+json.sub_max_student+"</td><td>"+json.sub_now_student+"</td><td>"+json.sub_point+"</td>"
			+ "</tr>";
		
	}else {		
		answer = "<tr>"
				+ "	<td style='text-align: -webkit-center;'><a href='#' onclick='deleteSub("+json.sub_seq+")'><i class='fa fa-minus-circle' style='color:red'></i></a></td>"
				+ " <td>"+json.sub_category+"</td><td>"+json.sub_grade+"</td>"
				+ "	<td>"+json.sub_semester+"</td><td>"+json.sub_name+"</td><td>"+json.professor_name+"</td>"
				+ "<td style='text-align: -webkit-center;'>"
				+ "<a href='#' id='subDetail' onclick=\"subDetail('"+ json.sub_info +"')\" data-toggle='modal' data-target='#myModal'><i class='fa fa-commenting-o' style='color:green'></i></a>"
				+ "</td>"
				+ " <td>"+json.sub_week+json.sub_s_class+" ~ "+json.sub_e_class+"</td><td>"+json.sub_room+"</td>"
				+ "	<td>"+json.sub_max_student+"</td><td>"+json.sub_now_student+"</td><td>"+json.sub_point+"</td>"
				+ "</tr>";		
	}	
	return answer;
}

//수강 취소
function deleteSub(seq){
	var major = $("#major").val();
	alert("수강 취소");
	console.log("수강 취소 1/2");	
	$.ajax({
		type: 'POST',
		url: 'asDelete.do',
		data: {
			"sub_seq" : seq
		},		
		async: true, 
		success: function() {
			console.log("성공");
		}
	});	
	console.log("수강 취소 2/2");
	
	subList(major);
	resultList();	
	checkPoint();
}

// 수강 합계
function checkPoint(){
	$('#checkPoint > tbody').empty();
	console.log("수강 합계 1/2");
		
	$.ajax({
		type:'POST',
		url: 'sumpoint.do',
		data: {
			"student_id" : '${login.user_id}'
		},
		async:true,
		success: function(data){
			console.log("checkPoint 성공");
			console.log(data);

			var htmlData = pointForm(data);
			$('#checkPoint > tbody').append(htmlData);
		}
	});
	console.log("수강 합계 2/2");	
	
}
	
function pointForm(data){
	var point = "<tr>"
			+ "<td>" + data.student_name + "</td>"
			+ "<td>" + data.student_year + "</td>"
			+ "<td>" + data.student_term + "</td>"
			+ "<td id='totalPoint'>" + data.totalPoint + "</td>"
			+ "</tr>";
			
	return point;
}

function result(){
	var total = $("#totalPoint").text();
	total = Number(total);
//	alert(typeof total);
//	alert(total);
	
	if(total < 18){
		alert("18학점 이상 채워주세요");
	}else if(total > 23){
		alert("23학점 이하로 들을수 있습니다");
	}else{
		alert("수강신청을 완료하였습니다");
		$("#_frmForm").attr({"target":"_self", "action":"main.do"}).submit();
	}
	
}
</script>



</section> <!-- layout.xml 상 꼭 있어야함 지우지마세요! -->






