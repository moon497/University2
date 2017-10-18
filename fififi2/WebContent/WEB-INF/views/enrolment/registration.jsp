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
<input type="hidden" value="${user.user_id }" id="professor_id" name="professor_id">
<input type="hidden" id="professor_name" name="professor_name" value="${user.user_name }" readonly="readonly">
<section class="category-content col-sm-9">
      <form action="registrationAf.do" method="post">
      <div class="table-responsive">
         <table class="table table-bordered table-hover">
         <colgroup>
         <col width="100"/><col width="400"/>   
         </colgroup>
         <tr>
            <th class="text-center">교수명</th>
            <td>
               <h4>${user.user_name }</h4>
            </td>
         </tr>
         <tr>
            <th class="text-center">전공</th>
            <td>
               <select name="sub_category" id="sub_category">
                  <option value="100">전공</option>
                  <option value="200">교양</option>         
               </select>
            </td>
         </tr>
         <tr>
            <th class="text-center">과목명</th>
            <td>
               <input type="text" size="50" id="sub_name" name="sub_name">
            </td>
         </tr>
         <tr>
            <th class="text-center">학년</th>
            <td>
               <select name="sub_grade" id="sub_grade">
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
               </select>
            </td>
         </tr>
         <tr>
            <th class="text-center">학기</th>
            <td>
               <select name="sub_semester" id="sub_semester">
                  <option value="1">1</option>
                  <option value="2">2</option>         
               </select>
            </td>
         </tr>
         <tr>
            <th class="text-center">요일</th>
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
            <th class="text-center">교시</th>
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
            <th class="text-center">인원수</th>
            <td>
               <select name="sub_max_student" id="sub_max_student">
                  <option value="0">0</option>
                  <option value="40">40</option>
                  <option value="50">50</option>   
                  <option value="60">60</option>            
                  <option value="70">70</option>   
                  <option value="80">80</option>   
               </select>
            </td>
         </tr>
         <tr>
            <th class="text-center">학점</th>
            <td>
               <select name="sub_point" id="sub_point">
                  <option value="2">2</option>
                  <option value="3">3</option>                  
               </select>
            </td>
         </tr>
         <tr>
            <th class="text-center">강의실</th>
            <td>
               <input type="text" size="50" id="sub_room" name="sub_room">
            </td>
         </tr>
         <tr>
            <th class="text-center">강의소개</th>
            <td>
               <textarea rows="10" cols="40" id="sub_info" name="sub_info"></textarea>
            </td>
         </tr>
         <tr>
            <td colspan="2">
               <input type="submit" size="30" id="addBtn" name="addBtn" value="등록">
               <input type="reset" value="취소">
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