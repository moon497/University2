<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<script type="text/javascript" src='${pageContext.request.contextPath }/js/NoticeBbsWrite.js' ></script>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/NoticeBbsWrite.css' />

<form action="./E_QnawriteAf.do" method="post">
<input type="hidden" name="sub_seq" value="${param.sub_seq }"> 
  
<div class="col-md-9">
<div class="form-group"> <!-- userId field -->
		<label class="control-label " for="user_id">글쓴이</label>
		<input class="form-control" id="user_id" name="user_id" type="hidden" value="${login.user_id}" readonly="readonly"/>
		<input class="form-control" type="text" value="${login.user_name}" readonly="readonly"/>
</div>
<div class="form-group"> <!-- "title" field -->
		<label class="control-label " for="title">제목</label>
		<input class="form-control" id="title" name="title" type="text"/>
</div>

<div class="form-group"> <!-- content field -->
		<label class="control-label " for="content">내용</label>
		<input type="checkbox" name="secret" value="1" id="secret">비밀 글
		<textarea class="form-control" cols="40" id="content" name="content" rows="10"></textarea>
</div>

	<div class="form-group pull-right">
		<button class="btn btn-primary " name="submit" type="submit">글 작성</button>
	</div>
</div>
</form>
