<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<fmt:requestEncoding value="utf-8"/>
<!-- navbar 선택 스크립트 -->
<script type="text/javascript">
$(document).ready(function() {
   console.log('${requestScope["javax.servlet.forward.request_uri"]}');
   var url = '${requestScope["javax.servlet.forward.request_uri"]}';
   
   if (url.indexOf('assessment.do') != -1) {
      $('#sidebar-assessment > li:nth-child(1)').attr('class','current');      
   } else if (url.indexOf('student_grade.do') != -1) {
      $('#sidebar-assessment > li:nth-child(2)').attr('class','current');      
   } else if (url.indexOf('updateInfo.do') != -1) {
      $('#sidebar-assessment > li:nth-child(3) > ul > li:nth-child(1)').attr('class','current');      
   } else if (url.indexOf('semesterGrade.do') != -1) {
      $('#sidebar-assessment > li:nth-child(3) > ul > li:nth-child(2)').attr('class','current');
   }   
   
})
</script>
<aside class="sidebar col-sm-3">
   <div class="widget">
      <h4>SERVICES</h4>
      <ul id="sidebar-assessment">
         <li class="clicks"><a href="assessment.do">교수평가</a></li>
         <li class="clicks"><a href="student_grade.do">성적확인</a></li>
         <li class="clicks"><a href="updateInfo.do" class="studentbasic">내정보</a>
            <ul class="stBasicList">
               <li class="clicks"><a href="updateInfo.do" class="studentbasic">기본정보</a></li>
               <li class="clicks"><a href="semesterGrade.do" class="studentbasic">학기별 성적</a></li>
            </ul>
         </li>      
      </ul>
   </div>
</aside>