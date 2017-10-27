<%@page import="kh.com.model.I_semesterGradeDTO"%>
<%@page import="java.util.ArrayList"%>
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
#studentGrade_table *, #totalGradeTable * {
	font-size: 12px;
}

#studentGrade_table th, td, #totalGradeTable th, td {
	color: #404040;
	border-collapse: collapse;
	border: 1px solid #e7e7e7;
	text-align: center;
}

#studentGrade_table th, #totalGradeTable th {
	font-size: 13px;
}

#studentGrade_table tr, #totalGradeTable tr {
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

.year, .semester {
	width: 80px;
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

<!-- 로그인 -->
<c:if test="${not empty login.user_id}">
<input type="hidden" name="student_id" value="${login.user_id }">
학년 
<select class="year">
<option>선택</option>
<c:forEach var="years" begin="1" end="${maxYear}" step="1">
	<option>
		${years}
	</option>
</c:forEach>
</select>
학기 
<select class="semester">
<option>학기선택</option>
</select>
<script>
/*
 * 학년에 따라 학기를 다르게 보여줌.
 */
var year = "";
$('.year').change(function () {
	year = $('.year option:selected').val();
	if(year == 1){
		$(".semester").html("<option>선택</option><option value='1'>1 학기 </option><option value='2'>2 학기 </option>");
	}else if(year == 2){
		$(".semester").html("<option>선택</option><option value='3'>1 학기 </option><option value='4'>2 학기 </option>");
	}else if(year == 3){
		$(".semester").html("<option>선택</option><option value='5'>1 학기 </option><option value='6'>2 학기 </option>");
	}else if(year == 4){
		$(".semester").html("<option>선택</option><option value='7'>1 학기 </option><option value='8'>2 학기 </option>");
	}else if(year = '선택'){
		$(".semester").html("<option>선택</option>");
	}; 
});

/*
 * 학기선택
 */
$('.semester').change(function () {
$('#studentGrade_table > tbody').empty();
// 클릭 후 이벤트 - Ajax로 semesterGradechoice.do 호출
$.ajax({
       type : "POST",
       dataType : "json",
       data : { 
          "student_id" : $('input[name=student_id]').val()   ,
            "semester" : $('.semester option:selected').val()
       },
       traditional : true,
       url : "./semesterGradechoice.do",
       async : true,
       success : function(data) {
    	   console.log(data);
    	   dataCount(data);
    	   $.each(data, function(i, item) {
               console.log(data[i]);
               $('#totalGradeTable > tbody').prepend(setHtml(data[i]));
           }); 
    	   var TotalstudentScore = getTotalStudentScore(totalStudentScore); // 총 학점
           $('#totalGradeTable > tbody > tr:nth-child(1) > td').text(getTotalStudentScore(totalStudentScore));
       },
       error : function(xhr, status, error) {
          alert("통신불가");
       }
    });
    
// ------------------ 변수 선언 --------------------
var totalStudentScore = 0; 		//총점수
var totalStudentSubScore; 		// 이수학점
//---------------------------------------------

/*
 * semesterGradechoice.do 에서 
 * 성공적으로 리스트를 가져오게 되면 아래 함수를 호출
 */
function setHtml(comment) {
	// ------------------ 변수 선언 ------------------
	var totalStudentscore;	// 점수
	var sub_category; 		// 전공 & 비전공
	// -------------------------------------------
	if(comment.sub_category == 100){
		sub_category = "전공";
	}else{
		sub_category = "비전공";
	};
	
	// --------------- 총학점을 구하기 위한 변수 선언 ---------------
	var StudentScore = parseInt(comment.student_score); 			// 학생점수 가져오기
	totalStudentScore = totalStudentScore + parseInt(StudentScore); // 받은 점수를 더하기
	// ---------------------------------------------------
	// 첫 번째 테이블에 그리기 (학년, 학기, 과목이름, 구분, 점수, 학점, 이수학점)
	$('#studentGrade_table > tbody').append('<tr><td>'+comment.sub_semester +'</td>' +
												'<td>'+comment.sub_semester +'</td>' + 
												'<td>'+comment.sub_info +'</td>' +
												'<td>'+sub_category +'</td>' + 
												'<td>'+comment.student_score +'</td>' + 
												'<td>'+getStudentScore(comment) +'</td>' + 
												'<td>'+comment.sub_point +'</td></tr>'
												);
	// 두 번째 테이블에 그리기(총 학점, 총 이수학점)
	$('#totalGradeTable > tbody > th').append('<td>' + totalStudentScore +'</td>');
}
});

/*
 * 총학점 계산을 위해 총 과목수를 알기 위한 함수
 */
var dataCounts = 0; // 총 갯수
function dataCount(data){
	var data_length = data.length ; //json의 length
	for(var i=1; i<=data_length; i++){
		dataCounts = i;
	}
}

/*
 * 학생 학점 
 */
function getStudentScore(comment) {
	var student_score; 
	if(comment.student_score <= 100 && comment.student_score >= 95){
		student_score = "A+";
	}else if(comment.student_score <= 94 && comment.student_score >= 90){
		student_score = "A0";
	}else if(comment.student_score <= 89 && comment.student_score >= 85){
		student_score = "B+";
	}else if(comment.student_score <= 84 && comment.student_score >= 80){
		student_score = "B0";
	}else if(comment.student_score <= 79 && comment.student_score >= 75){
		student_score = "C+";
	}else if(comment.student_score <= 74 && comment.student_score >= 70){
		student_score = "C0";
	}else if(comment.student_score <= 69 && comment.student_score >= 65){
		student_score = "D+";
	}else if(comment.student_score <= 64 && comment.student_score >= 60){
		student_score = "D0";
	}else if(comment.student_score <= 59 && comment.student_score >= 0){
		student_score = "F";
	};
	return student_score;
};

/*
 * 학생 총학점 
 */
function getTotalStudentScore(totalStudentScore) {
	totalStudentScore = totalStudentScore / dataCounts;
	var student_final;
	if(totalStudentScore <= 100 && totalStudentScore >= 95){
		student_final = "A+";
	}else if(totalStudentScore <= 94 && totalStudentScore >= 90){
		student_final = "A0";                                       
	}else if(totalStudentScore <= 89 && totalStudentScore >= 85){
		student_final = "B+";                                  
	}else if(totalStudentScore <= 84 && totalStudentScore >= 80){
		student_final = "B0";                                  
	}else if(totalStudentScore <= 79 && totalStudentScore >= 75){
		student_final = "C+";                                  
	}else if(totalStudentScore <= 74 && totalStudentScore >= 70){
		student_final = "C0";                                  
	}else if(totalStudentScore <= 69 && totalStudentScore >= 65){
		student_final = "D+";                             
	}else if(totalStudentScore <= 64 && totalStudentScore >= 60){
		student_final = "D0";
	}else if(totalStudentScore <= 59 && totalStudentScore >= 0){
		student_final = "F";
	}
	return student_final;
}
</script>

<form>
	<table id="studentGrade_table" style="width:100%;">
	 <colgroup>
	 	<col width="50">
	 	<col width="50">
	 	<col width="250">
	 	<col width="70">
	 	<col width="70">
	 	<col width="70">
	 	<col width="70">
	 	<col width="70">
	 	<col width="70">
	 	<col width="70">
	 </colgroup>
	 <thead>
		<tr>
			<th>학년</th>
			<th>학기</th>
			<th>과목이름</th>
			<th>구분</th>
			<th>점수</th>
			<th>학점</th>
			<!-- <th>총학점</th> -->
			<th>이수학점</th>
			<!-- <th>총이수학점</th> -->
		</tr>
	</thead>
	<!-- --------------------------------------------------------------- 총 점수 및 학점을 위한 영역  -->
	<!-- 총 이수학점 -->
	<c:set var = "sumsub_point" value = "0" />
	<!-- 총 점수 -->
	<c:set var = "totalStudentscore" value = "0" />
	<c:forEach var="allgrade" items="${Allgradelist }" varStatus="gds">
		<!-- 총 이수 학점 -->
		<c:set var= "sumsub_point" value="${sumsub_point + allgrade.sub_point}" />
		<!-- 총 점수 -->
		<c:set var= "totalStudentscore" value="${totalStudentscore + allgrade.student_score}" />
		<!-- 총 학점 -->
		<c:set var= "totalsub_point" value="${totalStudentscore / gds.count}" />
	</c:forEach>
	<!-- --------------------------------------------------------------- 총 점수 및 학점을 위한 영역  -->
	<tbody>
	<c:forEach var="grade" items="${gradelist }" varStatus="gds">
		<tr>
			<td>
				<!-- 학년 -->
				<c:if test="${grade.student_term >= 1 && grade.student_term <= 2}">
					1
				</c:if>
				<c:if test="${grade.student_term >= 3 && grade.student_term <= 4}">
					2
				</c:if>
				<c:if test="${grade.student_term >= 5 && grade.student_term <= 6}">
					3
				</c:if>
				<c:if test="${grade.student_term >= 7 && grade.student_term <= 8}">
					4
				</c:if>
				학년
			</td>
			<td>
				<!-- 학기 -->
				${grade.sub_semester }
			</td>
			<td>
				<!-- 과목명 -->
				${grade.sub_info }
			</td>
			<td><!-- 전공 / 비전공 -->
				<c:if test="${grade.sub_category == 100 }">
					전공
				</c:if>
				<c:if test="${grade.sub_category == 200 }">
					비전공
				</c:if>
			</td>
			<td><!-- 점수 -->
				${grade.student_score }
			</td>
			<td><!-- 학점 -->
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
			<td><!-- 이수학점 -->
				${grade.sub_point }
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	
	<table id="totalGradeTable" style="width:100%; margin-top: 10px;">
	<colgroup>
		<col width="35">
		<col width="180">
	</colgroup>
		<tr>
			<th>총 학점</th>
			<td>
				<c:if test="${totalsub_point <= 100 && totalsub_point >= 95 }">
					A+
				</c:if>
				<c:if test="${totalsub_point <= 94 && totalsub_point >= 90 }">
					A0
				</c:if>
				<c:if test="${totalsub_point <= 89 && totalsub_point >= 85 }">
					B+
				</c:if>
				<c:if test="${totalsub_point <= 84 && totalsub_point >= 80 }">
					B0
				</c:if>
				<c:if test="${totalsub_point <= 79 && totalsub_point >= 75 }">
					C+
				</c:if>
				<c:if test="${totalsub_point <= 74 && totalsub_point >= 70 }">
					C0
				</c:if>
				<c:if test="${totalsub_point <= 69 && totalsub_point >= 65 }">
					D+
				</c:if>
				<c:if test="${totalsub_point <= 64 && totalsub_point >= 60 }">
					D0
				</c:if>
				<c:if test="${totalsub_point <= 59 && totalsub_point >= 0 }">
					F
				</c:if>
			</td>
		</tr>
		<tr>
			<th>총 이수학점</th>
			<td>${sumsub_point }</td>
		</tr>
	</table>
</form>
</c:if>


















</section> <!-- layout.xml 상 꼭 있어야함 지우지마세요! -->
