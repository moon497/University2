<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 

<!-- 개별 CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/NoticeBbsList.css" />

<section class="category-content col-sm-9">
    
    <%@ include file="./parts/E_BbslistView.jsp" %>
    
</section>