<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main/notice.css" />

<div class="widget">
	<h4>게시판 목록</h4>
	<ul>
		<c:if test="${boardUrl == 'notice' }">
			<li><a href="../today/list.do" title="">오늘의 KH</a></li>
			<li class="current"> <a href="../notice/list.do" title="">공지사항</a></li>		
			<li><a href="../free/list.do" title="">자유게시판</a></li>					
		</c:if>
		<c:if test="${boardUrl == 'free' }">
			<li><a href="../today/list.do" title="">오늘의 KH</a></li>
			<li> <a href="../notice/list.do" title="">공지사항</a></li>		
			<li class="current"><a href="../free/list.do" title="">자유게시판</a></li>			
		</c:if>
		<c:if test="${boardUrl == 'today' }">
			<li class="current"><a href="../today/list.do" title="">오늘의 KH</a></li>
			<li> <a href="../notice/list.do" title="">공지사항</a></li>		
			<li><a href="../free/list.do" title="">자유 게시판</a></li>
		</c:if>
		
	</ul>
</div>