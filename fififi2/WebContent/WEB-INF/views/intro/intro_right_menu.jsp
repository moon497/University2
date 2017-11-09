<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 
<!-- navbar 선택 스크립트 -->
<script type="text/javascript">
$(document).ready(function() {
   console.log('${requestScope["javax.servlet.forward.request_uri"]}');
   var url = '${requestScope["javax.servlet.forward.request_uri"]}';
   
   if (url.indexOf('introLocation.do') != -1) {
      $('#sidebar-intro > li:nth-child(2)').attr('class','current');      
   }
   else if(url.indexOf('introCalendar.do') != -1) {
      $('#sidebar-intro > li:nth-child(3)').attr('class','current');      
   }
   else if(url.indexOf('suggestlist.do') != -1) {
      $('#sidebar-intro > li:nth-child(4)').attr('class','current');      
   } else {
      $('#sidebar-intro > li:nth-child(1)').attr('class','current');      
   } 
   
});
</script>
<aside class="sidebar col-sm-3">
   <div class="widget">
      <h4> 소개 </h4>
      <ul id="sidebar-intro">
         <li><a href="./introBbs.do" title="">학교 소개</a></li>
         <li><a href="./introLocation.do" title="">오시는 길</a></li>
         <li><a href="./introCalendar.do" title="">학사 일정</a></li>
         <li><a href="./suggestlist.do" title="">건의 사항</a></li>
      </ul>
   </div>

</aside>