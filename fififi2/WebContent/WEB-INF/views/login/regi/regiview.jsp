<%@page import="org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument.Include"%>
<%@page import="java.awt.Button"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<fmt:requestEncoding value="utf-8"/>  
<!-- nav-tap -->
<script type="text/javascript">

$(document).ready(function() {
var param = '${param.t}';

	if (param == '1') {
		$('#nav-tap-regi > li:nth-child(1)').attr('class','active');
	} else if (param == '2') {
		$('#nav-tap-regi > li:nth-child(2)').attr('class','active');
	} else if (param == '3') {
		$('#nav-tap-regi > li:nth-child(3)').attr('class','active');
	}
})
</script>
<section class="category-content col-sm-9">
  

<div class="row">	
   <c:if test="${t==1}">
    <h2 class="category-title">Student Registration</h2> 
   </c:if> 
	
	<c:if test="${t==2 }">
    <h2 class="category-title">professor Registration</h2> 
   </c:if> 
   
    <c:if test="${t==3 }">
    <h2 class="category-title">Staff Registration</h2> 
   </c:if> 
</div>

<div class="row">
<ul id="nav-tap-regi" class="nav nav-tabs">
  <li><a href="regiview.do?t=1">학생등록</a></li>
  <li><a href="regiview.do?t=2">교수등록</a></li>
  <li><a href="regiview.do?t=3">교직원등록</a></li>
</ul>
</div>
<div class="row">
<!-- 버튼 눌렀을때 regiview.do 갔다가 돌아 온 값  -->
   <c:if test="${t==1}">
   		<jsp:include page="./regi_s.jsp" flush="false"/>
   </c:if> 
	
	<c:if test="${t==2 }">
   		<jsp:include page="./regi_p.jsp" flush="false"/>
   </c:if> 
   
    <c:if test="${t==3 }">
   		<jsp:include page="./regi_a.jsp" flush="false"/>
   </c:if> 
</div>



</section>