<%@page import="java.awt.Button"%>
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
<style type="text/css">
.inputtextcss{
    width: 200px;
    height: 25px;
    padding: 5px;
    border: 1px solid #e2e2e2; 
}
.buttoncss{
    border: #337ab7 solid 1px;
    color: white;
    padding: 0px;
	 width: 100px;
    border-bottom-width: 1px;
    background-color: 337ab7;
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
    <h2 class="category-title">학번,사번 검색</h2> 
  <button type="button" id="find_id" class="buttoncss">아이디찾기</button>
  <button type="button" id="find_pw" class="buttoncss">비밀번호찾기</button>
  <br><br>

  
<form action="findIdAf.do" id="findId" method="post"> 
    <table class="tablecss">
    <tr>
    	<td>성명</td>
    	<td><input type="text" name="user_name" id="user_name" class="inputtextcss"></td>
    </tr>
	<tr>
		<td>핸드폰번호</td>
		<td>
		 <input type="text" name="user_phone" id="user_phone" class="inputtextcss" onkeyup="phone(this)" maxlength="13">
		</td>
    </tr>
    <tr>
    	<td>이메일</td>
    	<td><input type="text" name="user_email" id="user_email"  class="inputtextcss"></td>
    </tr>
    </table>
    
    <button id="find" >조회</button>
</form>
     
</section>   



<script type="text/javascript">
 $("#find").click(function() {
		if($("#user_name").val() == ""){
			alert($("#user_name").attr("data-msg") + " 입력해 주십시오" );
			$("#user_name").focus();
		} else if($("#major_number").val() == ""){
			alert($("#major_number").attr("data-msg") + " 입력해 주십시오" );
			$("#user_pw").focus();
		} else if($("#user_email").val() == ""){
			alert($("#user_email").attr("data-msg") + " 입력해 주십시오" );
			$("#user_email").focus();
		} 
		else{
			$("#findId").attr("target", "_self").submit();
		}	
});
 

 $(function() {
	    $("input").focus(function () {
	        $(this).css("border", "2px solid #337ab7");
	    });
	    $("input").blur(function () { //포커스를 잃었을때
	        $(this).css("border", "1px solid #e2e2e2");
	    });
});


$("#find_pw").click(function() {
	location.href="findPw.do";
 });   
 
 

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



</script>


</body>
</html>