<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:requestEncoding value="UTF-8"/>
<form>
<input type="hidden" id="sub_seq" name="sub_seq" value="${param.sub_seq }"> 
<div class="col-md-9">
<div class="form-group"> <!-- userId field -->
		<label class="control-label " for="user_id">아이디</label>
		<input class="form-control" id="user_id" name="user_id" type="text" value="${login.user_name }" readonly="readonly"/>
</div>
<div class="form-group"> <!-- "title" field -->
		<label class="control-label " for="title">제목</label>
		<input class="form-control" id="title" name="title" type="text"/>
</div>
	
<div class="form-group"> <!-- content field -->
		<label class="control-label " for="content">내용</label>
		<textarea class="form-control" cols="40" id="content" name="content" rows="10"></textarea>
</div>

<div class="form-group"> <!-- File field -->
	   <input type="file" id="fileload" name="fileload" class="file" style="visibility: hidden; position: absolute;">
	<div class="input-group col-xs-12">
	     <span class="input-group-addon"><i class="fa fa-file"></i></span>
	     <input type="text" class="form-control input-lg" disabled placeholder="파일 업로드">
	     <span class="input-group-btn">
			<button class="browse btn btn-primary input-lg" type="button"><i class="glyphicon glyphicon-search"></i> 파일</button>
	     </span>
    </div>
</div> 
	<div class="form-group pull-right">
		<button class="btn btn-primary " name="submit" type="submit">공지추가</button>
	</div>
</div>
</form>
