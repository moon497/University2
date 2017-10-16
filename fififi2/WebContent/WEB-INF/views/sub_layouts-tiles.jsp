<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>    

<html>
<head>
<title>sub_layouts-tiles</title>
<!-- (css, js)스타일 영역 -->
<tiles:insertAttribute name="header"/>
</head>
<body>
	<!-- 상단메뉴영역 -->
	<tiles:insertAttribute name="top_inc"/>
	<!-- 상단메뉴 아래 메뉴영역 -->
	<tiles:insertAttribute name="top_menu"/>
	
	<!-- 콘테이너박스영역(body라고 생각하면되요) -->
	<main class="site-main category-main">
	<div class="container">
		<div class="row">
			<!-- 실제 내용이 보여지는 영역 -->
			<tiles:insertAttribute name="sub_section" />
			<!-- 오른쪽 메뉴 -->
			<tiles:insertAttribute name="sub_right_menu" />
		</div>
	</div>
	</main>
	
	<!-- 푸터영역 -->
	<tiles:insertAttribute name="bottom_inc"/>		
</body>
</html>







