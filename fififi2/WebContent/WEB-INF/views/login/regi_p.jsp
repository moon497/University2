<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>    

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.11.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<style type="text/css">
.inputtextcss{
    width: 200px;
    height: 25px;
    padding: 5px;
    border-radius: 5px;
    border: 1px solid #e2e2e2; 
}
.inputtextcss1{
    width: 60px;
    height: 25px;
    padding: 5px;
    border-radius: 5px;
    border: 1px solid #e2e2e2;
}
.formcss{
    border-left-width: 50px;
    padding-left: 50px;
    padding-top: 50px;
    padding-bottom: 50px;
    padding-right: 150px;
}
.buttoncss{
    border: #337ab7 solid 1px;
    color: white;
    padding: 0px;
    height: 34px;
    width: 100px;
    border-bottom-width: 1px;
    background-color: 337ab7;
 
}
.buttoncss1{
    padding: 0px;
    height: 34px;
    width: 100px;
    margin-left: 5px;
}
.tablecss tr{
	height:5px;
}
.tablecss td{
	padding: 5px; 
	padding-right: 50px;
} 
</style>
</head>
<body>


<section class="category-content col-sm-9">
    <h2 class="category-title">professor Registration</h2> 

<button onclick="content(1)">일괄등록</button> <button onclick="content(2)">상세회원가입</button> <br><br>


<form action="" name="regiexcel" id="_regiexcel"  method="post" style="display: none;">
		<input type="file" name="fileread" style=" width : 400px;" id="fileread">
		<button id="_btnRegiexcel">회원가입</button>
</form> 

<form action="" method="post" id="regiform" name="regiform" style="display: none;">
			<input type="hidden" value="100" name="user_status">
			<input type="hidden" value="200" name="user_auth">
		<table class="tablecss">
		<tr>
			<td>학과</td>
			<td>
				<select name="major_number" id="major_number" data-msg="학과" style="width: 180px;">
					<option value="" >학과선택</option>
					<option value="100">기계공학과</option>
					<option value="200">간호학과</option>
					<option value="300">컴퓨터공학과</option>
					<option value="400">경영학과</option>
					<option value="500">시각디자인학과</option>
					<option value="600">국어교육과</option>
					<option value="700">사회복지학과</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>사번 </td>
			<td><input type="text" name="user_id" id="1" data-msg="학번" class="inputtextcss" onblur="idCk(this)"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="user_pw" id="2" data-msg="비밀번호" class="inputtextcss"> </td>
		</tr>
		<tr>
			<td>이름 </td>
			<td><input type="text" name="user_name" id="user_name" data-msg="이름" class="inputtextcss"> </td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>
				<select name="user_birth1" id="user_birth1" data-msg="생년월일" style="width: 60px;">
							<option value="">년도</option>
						<%for(int i=1960; i < 1998; i++){ %>
							<option value="<%=i%>"><%=i%>년</option>
						<%} %>
				</select>
				
			
				<select name="user_birth2" id="user_birth2" data-msg="생년월일" style="width: 60px;">
						<option value="">월</option>
					
					<%for(int i=1; i < 13 ; i++){ %>
						<option value="<%=i%>"><%=i%>월</option>
					<% } %>	 
				</select>
				
				
				<select name="user_birth3" id="user_birth3" data-msg="생년월일" style="width: 60px;">
						<option value="">일</option>
						
					<%Calendar cal = Calendar.getInstance(); %>
					<%for(int i=1; i < 31 ; i++){ %>
						<option value="<%=i%>"><%=i%>일</option>
					<%} %>	
				</select>
			</td>
			
		</tr>
		<tr>
			<td>이메일 </td>
			<td><input type="text" name="user_email" id="user_email" data-msg="이메일" class="inputtextcss"></td>
		</tr>
		<tr>
			<td>핸드폰번호 </td>
			<td>	
			<input type="text"  name="user_phone1" id="user_phone1" data-msg="핸드폰번호" class="inputtextcss1" value="010" onblur="phoneCk1(this)" >  -
			<input type="text" name="user_phone2" id="user_phone2" data-msg="핸드폰번호" class="inputtextcss1" onblur="phoneCk(this)" >  -
			<input type="text" name="user_phone3" id="user_phon3" data-msg="핸드폰번호" class="inputtextcss1" onblur="phoneCk(this)" > </td>
		</tr>
		<tr>
			<td>주소 </td>
			<td>
			<input type="text" name="postcode" id="sample4_postcode" placeholder="우편번호" class="inputtextcss" style="width: 100px; margin-bottom: 5px" >
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호" class="buttoncss1"><br>
			<input type="text" name="roadAddress" id="sample4_roadAddress" placeholder="도로명주소" class="inputtextcss" style="width: 400px; margin-bottom: 5px"><br>
			<input type="text" name="detailAddress" id="detail_address" class="inputtextcss" style="width: 303px; margin-bottom: 5px">
			</td>
		</tr>
		<tr>
		<tr>
			<td>등록일</td>
			<td><input type="text" name="prof_regidate" id="prof_regidate" class="inputtextcss">(ex: 20170301)</td>
		</tr>
		<tr >
			<td>직위</td>
			<td><input type="text" name="prof_position" id="prof_position" class="inputtextcss"> </td>
		</tr>
		<tr>
			<td>최종학력</td>
			<td><input type="text" name="prof_degree" id="prof_degree" class="inputtextcss"> </td>
		</tr>
		<tr>
			<td>연구실</td>
			<td><input type="text" name="prof_room" id="prof_room" class="inputtextcss"> </td>
		</tr>
		<tr>
			<td>
			<button id="_btnRegi">회원가입</button>
			</td>
		</tr>
		</table>
</form>        
</section>


<script type="text/javascript">
function content(n) {
	v = n;
	if(v==1){ //일괄등록 form 펼치기
	$("#_regiexcel").slideToggle("fast");
	}
	else{ //상세등록 form 펼치기
	$("#regiform").slideToggle("fast");
	}
}
</script>





<script type="text/javascript">
//아이디
function idCk(obj) {
	
	if($("#user_id").val().match(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g)){
	      alert("학번 한글 입력될수 없습니다.");
	      $("#user_id").val()=="";
	}
	
	if(obj.value.length > 8){
		alert("학번 8자리 입력");
		      obj.value = obj.value.substring(0, 8);
     }
	
}

//생년월일
$(document).ready(function() {
	$("select[name='user_birth2']").change(function() {
		var lastday = (new Date($("select[name='user_birth1']").val()+ "",
			       $("select[name='user_birth2']").val()+"", 0)).getDate();
		
		// 적용
		var str = "";
		for(i = 1; i<= lastday; i++){
			str += "<option value='"+ i +"'>" + i + "</option>";	
		}
		$("select[name='user_birth3']").html(str);
		
	});
});

//핸드폰
function phoneCk1(obj) {
	   // 숫자만 입력
	   obj.value = obj.value.replace(/[^0-9]/g,'');      
	   // 길이제한
	   if(obj.value.length > 3){
	      obj.value = obj.value.substring(0, 3);
	   }
}
function phoneCk(obj) {
	   // 숫자만 입력
	   obj.value = obj.value.replace(/[^0-9]/g,'');      
	   // 길이제한
	   if(obj.value.length > 4){
	      obj.value = obj.value.substring(0, 4);
	   }
}



//주소
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
        	
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 도로명 조합형 주소 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if(fullRoadAddr !== ''){
                fullRoadAddr += extraRoadAddr;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('sample4_roadAddress').value = fullRoadAddr;
            document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                //예상되는 도로명 주소에 조합형 주소를 추가한다.
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

            } else {
                document.getElementById('guide').innerHTML = '';
            }
        }
    }).open();
}


</script>


<script type="text/javascript">
//파일업로드최종
$("#_btnRegiexcel").click(function() {
	if($("#fileread").val() == ""){
	alert("파일을 업로드 하십시오");
	return;
	}
	else{
		$("#_regiexcel").attr({"target":"_self", "action":"excelread.do" }).submit();
	} 
});


//상세업로드최종
$("#_btnRegi").click(function() {
	if($("#user_auth").val() == ""){
		alert($("#user_auth").attr("data-msg") + " 입력해 주십시오");
		$("#user_auth").focus();
	} 
	else if($("#major_number").val() == ""){
		alert($("#major_number").attr("data-msg") + " 입력해 주십시오");
		$("#major_number").focus();
	} 
	else if($("#user_id").val() == ""){
		alert($("#user_id").attr("data-msg") + " 입력해 주십시오");
		$("#user_id").focus();
	} 
	else if($("#user_pw").val() == ""){
		alert($("#user_pw").attr("data-msg") + " 입력해 주십시오");
		$("#user_pw").focus();
	} 
	else if($("#user_name").val() == ""){
		alert($("#user_name").attr("data-msg") + " 입력해 주십시오");
		$("#user_name").focus();
	} 
	else if($("#user_birth").val() == ""){
		alert($("#user_birth").attr("data-msg") + " 입력해 주십시오");
		$("#user_birth").focus();
	} 
	else if($("#user_birth1").val() == ""){
		alert($("#user_birth1").attr("data-msg") + " 입력해 주십시오");
		$("#user_birth1").focus();
	} 
	else if($("#user_birth2").val() == ""){
		alert($("#user_birth2").attr("data-msg") + " 입력해 주십시오");
		$("#user_birth2").focus();
	} 
	else if($("#user_birth3").val() == ""){
		alert($("#user_birth3").attr("data-msg") + " 입력해 주십시오");
		$("#user_birth3").focus();
	} 
	else if($("#user_email").val() == ""){
		alert($("#user_email").attr("data-msg") + " 입력해 주십시오");
		$("#user_email").focus();
	} 
	else if($("#user_phone1").val() == ""){
		alert($("#user_phone").attr("data-msg") + " 입력해 주십시오");
		$("#user_phone").focus();
	} 
	else if($("#user_phone2").val() == ""){
		alert($("#user_phone").attr("data-msg") + " 입력해 주십시오");
		$("#user_phone").focus();
	}
	else if($("#user_phone3").val() == ""){
		alert($("#user_phone").attr("data-msg") + " 입력해 주십시오");
		$("#user_phone").focus();
	}
	else if($("#user_address").val() == ""){
		alert($("#user_address").attr("data-msg") + " 입력해 주십시오");
		$("#user_address").focus();
	} 
	else{
		$("#regiform").attr({"target":"_self", "action":"regiAf.do" }).submit();
	} 
});



</script>



</body>
</html>