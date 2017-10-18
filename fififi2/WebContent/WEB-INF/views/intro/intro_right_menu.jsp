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
   
   if (url.indexOf('regi.do') != -1) {
      $('#sidebar-admin > li:nth-child(1)').attr('class','current');      
   } else if (url.indexOf('registration.do') != -1) {
      $('#sidebar-admin > li:nth-child(2)').attr('class','current');      
   } else if (url.indexOf('registrationlist.do') != -1) {
      $('#sidebar-admin > li:nth-child(3)').attr('class','current');      
   } else if (url.indexOf('gradeinput.do') != -1) {
      $('#sidebar-admin > li:nth-child(4)').attr('class','current');
   }   
   
});
</script>
<aside class="sidebar col-sm-3">
	<div class="widget">
		<h4>교직원</h4>
		<ul id="sidebar-admin">
			<li><a href="./regi.do" title="">회원가입</a></li>
			<li><a href="./registration.do" title="">강의등록</a></li>
			<li><a href="./registrationlist.do" title="">나의 강의목록</a></li>
			<li><a href="./gradeinput.do" title="">성적등록</a></li>
		</ul>
	</div>
</aside>