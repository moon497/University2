<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<script type="text/javascript" src='${pageContext.request.contextPath }/js/NoticeBbsWrite.js' ></script>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/NoticeBbsWrite.css' />

<!-- 글 수정시 -->
<form action="./updateAf.do" method="POST" enctype="multipart/form-data">
<input type="hidden" name="bbsSeq" value="${bbs.bbsSeq }" />
    <%@ include file="./parts/bbsWriteView.jsp" %>
</form>