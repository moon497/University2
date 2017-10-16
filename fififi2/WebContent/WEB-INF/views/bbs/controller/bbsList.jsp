<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 
<c:choose>
	<c:when test="${boardUrl == 'notice' || boardUrl == 'today' }">
	    <%@ include file="../admin/bbsList.jsp" %>
	</c:when>
	<c:when test="${boardUrl == 'free'}">
	    <%@ include file="../common/bbsList.jsp" %>
	</c:when>
	<c:otherwise>
	    <%@ include file="../common/bbsList.jsp" %>
	</c:otherwise>
</c:choose>