<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>

<div class="col-md-9">
	<div class="form-group"> <!-- userId field -->
		<label class="control-label " for="userId">아이디</label>
		<input class="form-control" id="userId" name="userId" type="text" value="${login.user_id }" readonly="readonly"/>
	</div>
	
	<div class="form-group"> <!-- "title" field -->
		<label class="control-label " for="title">제목</label>
		<input class="form-control" id="bbsTitle" name="bbsTitle" type="text" value="${bbs.bbsTitle }"/>
	</div>
	
	<div class="form-group"> <!-- content field -->
		<label class="control-label " for="content">내용</label>
		<textarea class="form-control" cols="40" id="bbsContent" name="bbsContent" rows="10">${bbs.bbsContent }</textarea>
	</div>
	
	<div class="form-group"> <!-- File field -->
	   <input type="file" id="uploadFile" name="uploadFile" class="file" style="visibility: hidden;position: absolute;">
	   <div class="input-group col-xs-12">
	     <span class="input-group-addon"><i class="fa fa-file"></i></span>
	     <input type="text" class="form-control input-lg" disabled placeholder="파일 업로드">
	     <span class="input-group-btn">
	       <button class="browse btn btn-primary input-lg" type="button"><i class="glyphicon glyphicon-search"></i> 파일</button>
	     </span>
	   </div>
	</div>
	
	<div class="form-group pull-right">
		<button class="btn btn-primary " name="submit" type="submit">글쓰기</button>
	</div>
	
</div>