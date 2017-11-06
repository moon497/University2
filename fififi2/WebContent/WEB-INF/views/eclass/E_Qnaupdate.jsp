<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:requestEncoding value="UTF-8"/>

<form action="./E_QnaupdateAf.do" method="post">
<input type="hidden" name="eclass_qna_bbs_seq" value="${eqna.eclass_qna_bbs_seq }" />
<input type="hidden" id="sub_seq" name="sub_seq" value="${param.sub_seq }"> 

<div class="col-md-9">
<div class="form-group"> <!-- userId field -->
      <label class="control-label " for="user_id">아이디</label>
      <input class="form-control" id="user_id" name="user_id" type="text" value="${eqna.user_name }" readonly="readonly"/>
</div>
<div class="form-group"> <!-- "title" field -->
      <label class="control-label " for="title">제목</label>
      <input class="form-control" id="title" name="title" type="text" value="${eqna.title }"/>
</div>
   
<div class="form-group"> <!-- content field -->
		<label class="control-label " for="content">내용</label>
		<input type="checkbox" name="secret" value="1" id="secret">비밀 글
      <textarea class="form-control" cols="40" id="content" name="content" rows="10">${eqna.content }</textarea>
</div>
<div class="form-group pull-right">
      <button class="btn btn-primary " name="submit" type="submit">글 수정</button>
</div>
</div>
</form>