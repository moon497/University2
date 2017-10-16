<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<fmt:requestEncoding value="UTF-8"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<style>
table {
    border-collapse: collapse;
    border: 1px solid black;
}

table, th{
    text-align: left;
}

td{
	text-align: left;
}


</style>

<%
int s_class = 0;
int e_class = 0;
%>

<form action="addRegAf.do" method="post">
<table style="width:60%; text-align: center; border: 1px solid black; margin: auto">
<colgroup>
<col width="100"/><col width="400"/>	
</colgroup>
<tr>
	<th>교수명</th>
	<td>
		<input type="hidden" id="sub_seq" name="sub_seq" value="${sub.sub_seq }">
		<input type="hidden" id="major_number" name="major_number" value="${sub.major_number }">
		<input type="hidden" id="professor_id" name="professor_id" value="${sub.professor_id }">
		<input type="hidden" id="sub_parent" name="sub_parent" value="${sub.sub_seq }">
		<input type="hidden" id="sub_ref" name="sub_ref" value="${sub.sub_ref }">
		
		<input type="text" size="50" id="professor_name" name="professor_name" value="${sub.professor_name }" readonly="readonly">
	</td>
</tr>
<tr>
	<th>전공</th>
	<td>
		<input type="text" size="50" id="sub_category" name="sub_category" value="${sub.sub_category }" readonly="readonly">
	</td>
</tr>
<tr>
	<th>과목명</th>
	<td>
		<input type="text" size="50" id="sub_name" name="sub_name" value="${sub.sub_name }" readonly="readonly">
	</td>
</tr>
<tr>
	<th>학년</th>
	<td>
		<input type="text" size="50" id="sub_grade" name="sub_grade" value="${sub.sub_grade }" readonly="readonly">	
	</td>
</tr>
<tr>
	<th>학기</th>
	<td>
		<input type="text" size="50" id="sub_semester" name="sub_semester" value="${sub.sub_semester }" readonly="readonly">
	</td>
</tr>
<tr>
	<th>요일</th>
	<td>
		<select name="sub_week" id="sub_week">
			<option value="월">월요일</option>
			<option value="화">화요일</option>
			<option value="수">수요일</option>
			<option value="목">목요일</option>
			<option value="금">금요일</option>			
		</select>
	</td>
</tr>
<tr>
	<th>교시</th>
	<td>
		<select id="sub_s_class" name="sub_s_class" onchange="startclass(this)">
			<%
			for(int i = 1; i < 10; i++){
				%>	
				<option <%=(s_class+"").equals(i+"")?"selected='selected'":"" %>value="<%=i %>">
					<%=i %>
				</option>
				<%	
			}						
			%>	
			
		</select>
		~
		<select id="sub_e_class" name="sub_e_class">
			<%
			for(int i = 1; i <= 10; i++){
				%>	
				<option id="EclsOpt<%=i %>" <%=(e_class+"").equals(i+"")?"selected='selected'":"" %>value="<%=i %>">
					<%=i %>
				</option>
				<%	
			}						
			%>	
		</select>
	</td>
</tr>

<tr>
	<th>인원수</th>
	<td>
		<input type="text" size="50" id="sub_max_student" name="sub_max_student" value="${sub.sub_max_student }" readonly="readonly">
	</td>
</tr>
<tr>
	<th>학점</th>
	<td>
		<input type="text" size="50" id="sub_point" name="sub_point" value="${sub.sub_point }" readonly="readonly">
	</td>
</tr>
<tr>
	<th>강의실</th>
	<td>
		<input type="text" size="50" id="sub_room" name="sub_room" value="${sub.sub_room }" readonly="readonly">
	</td>
</tr>
<tr>
	<th>강의소개</th>
	<td>
		<textarea rows="10" cols="40" id="sub_info" name="sub_info" readonly="readonly">${sub.sub_info }</textarea>
	</td>
</tr>
<td colspan="2">
	<input type="submit" size="30" id="addBtn" name="addBtn" value="등록">
	<input type="reset" value="취소">
</td>

</table>
</form>
<script type="text/javascript">
function startclass(me){		
	var num = me.options[me.selectedIndex].value;
//	alert(num);
//	console.log(me);
//	console.log(num);
	$("#sub_e_class").empty();
	for (var i = num; i <= 10; i++) {
		$("#sub_e_class").append($("<option value=" + "'" + i + "'" + ">" + i + "</option>"));
	}
	$("#sub_e_class").val(num);
	
}
$("#addBtn").click(function(){
	alert("시간표 추가");
});

</script>







