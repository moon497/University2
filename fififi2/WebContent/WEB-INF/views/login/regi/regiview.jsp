<%@page import="org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument.Include"%>
<%@page import="java.awt.Button"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<fmt:requestEncoding value="utf-8"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
   
<section class="category-content col-sm-9">
  



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


     
<a href="regiview.do?t=1">학생등록</a>
<a href="regiview.do?t=2">교수등록</a>
<a href="regiview.do?t=3">교직원등록</a>


</section>


</body>
</html>