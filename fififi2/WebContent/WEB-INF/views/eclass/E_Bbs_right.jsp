<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 

<aside class="sidebar col-sm-3">
	<div class="widget">
		<h4>SERVICES</h4>
		<ul>
			<li><a href="E_Bbslist.do?sub_seq=${param.sub_seq }" title="">공지사항</a></li>
			<li><a href="E_Pdslist.do?sub_seq=${param.sub_seq }" title="">과제</a></li>
			<li><a href="E_Qnalist.do?sub_seq=${param.sub_seq }" title="">질의 응답</a></li>
		</ul>
	</div>
</aside>