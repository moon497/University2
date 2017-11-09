<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>

<script type="text/javascript" src='${pageContext.request.contextPath }/js/NoticeBbsWrite.js' ></script>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/NoticeBbsWrite.css' />



<!-- 글 생성시 -->
<form action="./introBbswriteAf.do" method="post" enctype="multipart/form-data">


    <div class="col-md-9">
	<div class="form-group"> <!-- userId field -->
		<label class="control-label " for="userId">아이디</label>
		<input class="form-control" id="user_id" name="user_id" type="text" readonly="readonly" value="${login.user_id }"/>
	</div>
	
	<div class="form-group"> <!-- "title" field -->
		<label class="control-label " for="title">제목</label>
		<input class="form-control" id="title" name="title" type="text" required="required"/>
	</div>
	
	<div class="form-group"> <!-- content field -->
		<label class="control-label " for="content">내용</label>
		<textarea class="form-control" cols="40" id="content" name="content" rows="10" required="required"></textarea> 
	</div>
	
	<div class="form-group"> <!-- File field -->
	   <input type="file" id="file" name="file" class="file" style="visibility: hidden;position: absolute;">
	   <div class="input-group col-xs-12">
	     <span class="input-group-addon"><i class="fa fa-file"></i></span>
	     <input type="text" class="form-control input-lg" disabled placeholder="파일 업로드">
	     <span class="input-group-btn">
	       <button class="browse btn btn-primary input-lg" type="button"><i class="glyphicon glyphicon-search"></i> 파일</button>
	     </span>
	   </div>
	</div>
	
	<div class="form-group pull-right">
		<button class="btn btn-primary " name="submit" type="submit" id="introWrite()" >글쓰기</button>
		<button id="hiddenBtn" type="submit" style="display: none;"></button>
	</div>
	
	</div>
</form>

<script>
function introWrite() {	
	document.getElementById('hiddenBtn').click();
	
}
</script>
