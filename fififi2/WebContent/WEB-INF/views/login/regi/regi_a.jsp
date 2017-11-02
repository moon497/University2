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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<style type="text/css">
td, th {
    padding: 5;
}
</style>

</head>
<body>


<div class="category-content col-sm-9" style="margin-top: 1em;">

<form action="regiAf.do" id ="regiform"  method="POST" enctype="multipart/form-data"> 
			<input type="hidden" value="100" name="user_status">
			<input type="hidden" value="300" name="user_auth">
			
		<table class="table table-bordered table-hover">
		<tr>
			<td>사진</td>
			<td>
				<input type="file" name="file" required="required">
			</td>
		</tr>
		<tr>
		<td>부서</td>
			<td>
				<select name="admin_department" id="admin_department" data-msg="학과" style="width: 180px;" required="required">
					<option value="" >부서선택</option>
					<option value="대학본부" >대학본부</option>
					<option value="입학처">입학처</option>
					<option value="교육처">교육처</option>
					<option value="기획처">기획처</option>
					<option value="교육처">교육처</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>사번 </td>
			<td><input type="text" name="user_id" required="required">(학번8자리입력)</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="user_pw" required="required"> </td>
		</tr>
		<tr>
			<td>이름 </td>
			<td><input type="text" name="user_name" required="required"> </td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>
			<input type="date" name="user_birth" required="required" max="2017-01-01" min=1950-12-31">
			</td>
		</tr>
		<tr>
			<td>이메일 </td>
			<td><input type="email" name="user_email" required="required"></td>
		</tr>
		<tr>
			<td>핸드폰번호 </td>
			<td>	
			<input type="text" name="user_phone" id="user_phone" required="required" onkeyup="phone(this)" maxlength="13">
		</tr>
		<tr>
			<td>주소 </td>
			<td>
			<input type="text" id="sample4_postcode" placeholder="우편번호" required="required" style="margin-bottom: 5px;">
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호" required="required"><br>
			<input type="text" id="sample4_roadAddress" placeholder="도로명주소"  required="required" onkeyup="address(this)">
			<input type="text" id="detail_address" required="required" placeholder="상세주소" onkeyup="address(this)">
			<input type="hidden" name="user_address" id="user_address">
			</td>
		</tr>
	<!-- 교직원 추가입력 -->
		<tr>
			<td>입사일</td>
			<td><input type="date" name="admin_regidate" required="required"  max="2000-01-01" min=1979-12-31"></td>
		</tr>

		<tr>
			<td>직위</td>
			<td><input type="text" name="admin_position"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="회원가입">
			</td>
		</tr>
		</table>
</form> 
</div>

<script type="text/javascript">
//주소합치기
function address(obj) {
	  var p = document.getElementById('sample4_postcode').value ;
	  var r = document.getElementById('sample4_roadAddress').value ;
	  var d = document.getElementById('detail_address').value ;
	  document.getElementById('user_address').value= p+r+d;
}


//핸드폰 
function phone(obj) {
	var val = obj.value.trim();
	val = phonecheck(val) ;
	document.getElementById('user_phone').value = val;
}
function phonecheck(val) {
	val = val.replace(/[^0-9]/g, '');
	var tmp = '';
	if( val.length < 4){
		return str;
	}else if(val.length < 7){
		tmp += val.substr(0, 3);
		tmp += '-';
		tmp += val.substr(3);
		return tmp;
	}else if(val.length < 11){
		tmp += val.substr(0, 3);
		tmp += '-';
		tmp += val.substr(3, 3);
		tmp += '-';
		tmp += val.substr(6);
		return tmp;
	}else{				
		tmp += val.substr(0, 3);
		tmp += '-';
		tmp += val.substr(3, 4);
		tmp += '-';
		tmp += val.substr(7);
		return tmp;
	}
	return tmp;
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




</body>
</html>