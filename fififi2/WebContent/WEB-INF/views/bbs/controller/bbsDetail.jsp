<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 
<c:choose>
	<%-- 댓글 없는 곳 --%>
	<c:when test="${boardUrl == 'notice'}">
	    <%@ include file="../image/bbsDetail.jsp" %>
 	    <%@ include file="../admin/bbsList.jsp" %>
	</c:when>
	<c:when test="${boardUrl == 'free'}">
	    <%@ include file="../image/bbsDetail.jsp" %>
	    <%@ include file="../common/comment.jsp" %>
 	    <%@ include file="../admin/bbsList.jsp" %>
	</c:when>
	<%-- 이미지 있는 곳 --%>
	<c:when test="${boardUrl == 'today'}">
	    <%@ include file="../image/bbsDetail.jsp" %>
 	    <%@ include file="../admin/bbsList.jsp" %>
	</c:when>
	<c:otherwise>
	    <%@ include file="../common/bbsDetail.jsp" %>
	</c:otherwise>
</c:choose>