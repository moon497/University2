<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>    

<html>
<head>
<title>layouts-tiles</title>
<!-- (css, js)스타일 영역 -->
<tiles:insertAttribute name="head"/>
</head>
<body>
	<!-- 상단메뉴영역 -->
	<tiles:insertAttribute name="navbar"/>
	<!-- 안에콘텐츠영역 -->
	<main class="site-main category-main" style="margin-top: 10px;">		
		<div class="container">
			<section class="category-content col-sm-9">
				<tiles:insertAttribute name="main"/>
			</section>
			<aside class="sidebar col-sm-3" style="margin-top: 10px;">
				<tiles:insertAttribute name="sidebar"/>
			</aside>
		</div>
	</main>
	<!-- 푸터영역 -->
	<tiles:insertAttribute name="footer"/>
</body>
</html>







