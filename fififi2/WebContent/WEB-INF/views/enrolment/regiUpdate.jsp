<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<fmt:requestEncoding value="UTF-8"/>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<style>
div.table-responsive * {
   color: #444;
}
</style>

<%
int s_class = 0;
int e_class = 0;
%>

<script type="text/javascript">
$(document).ready(function() {
 	$('#sub_category').val('${sub.sub_category }').attr('selected','selected');
	$('#sub_grade').val('${sub.sub_grade }').attr('selected','selected');
	$('#sub_semester').val('${sub.sub_semester }').attr('selected','selected');
	$('#sub_week').val('${sub.sub_week }').attr('selected','selected');
	$('#sub_s_class').val('${sub.sub_s_class }').attr('selected','selected');
	$('#sub_e_class').val('${sub.sub_e_class }').attr('selected','selected');
	$('#sub_max_student').val('${sub.sub_max_student }');
});
</script>

<section class="category-content col-sm-9">
<form action="updateRegAf.do" method="post">

	<div class="table-responsive">
	<table class="table table-bordered table-hover">
		<colgroup>
			<col width="100" />
			<col width="400" />
		</colgroup>
		<tr>
			<th class="text-center">교수명</th>
			<td>
				<input type="hidden" value="${user.user_id }" id="professor_id" name="professor_id">
				<input type="hidden" value="${sub.major_number }" id="major_number" name="major_number">
				<input type="hidden" value="${sub.sub_seq }" id="sub_seq" name="sub_seq">
				<input type="text" id="professor_name" name="professor_name" value="${user.user_name }" readonly="readonly">  
			</td>
		</tr>
		<tr>
			<th class="text-center">전공</th>
			<td><select name="sub_category" id="sub_category" value="${sub.sub_category }">
					<option value="100">전공</option>
					<option value="200">교양</option>
			</select></td>
		</tr>
		<tr>
			<th class="text-center">과목명</th>
			<td><input type="text" size="50" id="sub_name" name="sub_name" value="${sub.sub_name }">
			</td>
		</tr>
		<tr>
			<th class="text-center">학년</th>
			<td><select name="sub_grade" id="sub_grade">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
			</select></td>
		</tr>
		<tr>
			<th class="text-center">학기</th>
			<td><select name="sub_semester" id="sub_semester" ${sub.sub_semester }>
					<option value="1">1</option>
					<option value="2">2</option>
			</select></td>
		</tr>
		<tr>
			<th class="text-center">요일</th>
			<td><select name="sub_week" id="sub_week" value="${sub.sub_week }">
					<option value="월">월요일</option>
					<option value="화">화요일</option>
					<option value="수">수요일</option>
					<option value="목">목요일</option>
					<option value="금">금요일</option>
			</select></td>
		</tr>
		<tr>
			<th class="text-center">교시</th>
			<td><select id="sub_s_class" name="sub_s_class"
				onchange="startclass(this)" value="${sub.sub_s_class }">
				<%
           		 for(int i = 1; i < 10; i++){
           		 %>
					<option <%=(s_class+"").equals(i+"")?"selected='selected'":"" %>
							value="<%=i %>">
             			 	 <%=i %>
            		</option>
				<%   
                }                  
                %>

				</select> ~ <select id="sub_e_class" name="sub_e_class" value="${sub.sub_e_class }">
				<%
                for(int i = 1; i <= 10; i++){
                %>
					<option id="EclsOpt<%=i %>"
						<%=(e_class+"").equals(i+"")?"selected='selected'":"" %>
						value="<%=i %>">
              			 <%=i %>
           			 </option>
				<%   
                }                  
                %>
				</select></td>
		</tr>

		<tr>
			<th class="text-center">인원수</th>
			<td><select name="sub_max_student" id="sub_max_student" value="${sub.sub_max_student }">
					<option value="0">0</option>
					<option value="40">40</option>
					<option value="50">50</option>
					<option value="60">60</option>
					<option value="70">70</option>
					<option value="80">80</option>
			</select></td>
		</tr>
		<tr>
			<th class="text-center">학점</th>
			<td><select name="sub_point" id="sub_point" value="${sub.sub_point }">
					<option value="2">2</option>
					<option value="3">3</option>
			</select></td>
		</tr>
		<tr>
			<th class="text-center">강의실</th>
			<td><input type="text" size="50" id="sub_room" name="sub_room" value="${sub.sub_room }">
			</td>
		</tr>
		<tr>
			<th class="text-center">강의소개</th>
			<td>
			<textarea rows="10" cols="40" id="sub_info"name="sub_info">${sub.sub_info } / 학년 : ${sub.sub_grade} / 시작시간 : ${sub.sub_s_class } / 끝 시간 : ${sub.sub_e_class }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" size="30" id="addBtn" name="updateBtn" class="btn btn-info" value="수정">
				<input type="reset" class="btn btn-danger" value="취소">
			</td>
		</tr>
	</table>
	</div>
	
</form>
</section>

<script type="text/javascript">
function startclass(me){      
   var num = me.options[me.selectedIndex].value;
//   alert(num);
//   console.log(me);
//   console.log(num);
   $("#sub_e_class").empty();
   for (var i = num; i <= 10; i++) {
      $("#sub_e_class").append($("<option value=" + "'" + i + "'" + ">" + i + "</option>"));
   }
   $("#sub_e_class").val(num);
   
}

</script>