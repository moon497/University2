<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main/notice.css" />

<aside class="sidebar col-sm-3">
	<div class="widget">
		<h4>게시판 목록</h4>
		<ul>
			<c:if test="${boardUrl == 'notice' }">
				<li class="current"> <a href="../notice/list.do" title="">공지게시판</a></li>		
				<li><a href="../pds/list.do" title="">자유게시판</a></li>	
			</c:if>
			<c:if test="${boardUrl == 'pds' }">
				<li> <a href="../notice/list.do" title="">공지게시판</a></li>		
				<li class="current"><a href="../pds/list.do" title="">자유게시판</a></li>				
			</c:if>
			
		</ul>
	</div>
</aside>