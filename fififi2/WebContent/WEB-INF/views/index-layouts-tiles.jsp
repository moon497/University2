<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>    

<html>
<head>
<title>layouts-tiles</title>
<!-- (css, js)스타일 영역 -->
<tiles:insertAttribute name="header"/>
</head>
<body>
	<!-- 상단메뉴영역 -->
	<tiles:insertAttribute name="top_inc"/>
	<!-- 안에콘텐츠영역 -->
    <main class="site-main">
	<tiles:insertAttribute name="cover"/>
	<tiles:insertAttribute name="posts"/>
	<tiles:insertAttribute name="service"/>
	<tiles:insertAttribute name="home"/>
	</main>
	<!-- 푸터영역 -->
	<tiles:insertAttribute name="bottom_inc"/>
</body>
</html>