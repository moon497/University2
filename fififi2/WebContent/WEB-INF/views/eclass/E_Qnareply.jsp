<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src='${pageContext.request.contextPath }/js/NoticeBbsWrite.js' ></script>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/NoticeBbsWrite.css' />
<fmt:requestEncoding value="utf-8"/>
<section class="category-content col-sm-9">
	<div id="postlist">        
        <div class="panel">
                <div class="panel-heading">
                    <div class="text-center">
                        <div class="row">
                            <div class="col-sm-12">
                                <h3 class="pull-left">${eqna.title }</h3>
                            </div>
                            <div class="col-sm-12">
                                <h4 class="pull-right">
                                <small>작성일 : ${fn:substring(eqna.wdate,0,10)}</small>
                                </h4>
                            </div>
                            <div class="col-sm-12">
                                <h4 class="pull-right">
                                <small>${eqna.user_name }</small>
                                </h4>
                            </div>
                        </div>
                        <hr style="margin-top: 0;    margin-bottom: 0.5em;    border-top-color: #ccc;">                        
                    </div>
                </div>
	            <div class="panel-body">
	                <span>${eqna.content }</span>
	            </div>
	          </div>
		</div>
</section>

<section>
<form method="post" action="E_QnaanswerAf.do">
<input type="text" name="eclass_qna_bbs_seq" value="${eqna.eclass_qna_bbs_seq}" />
<input type="hidden" id="sub_seq" name="sub_seq" value="${param.sub_seq }"> 
<input type="hidden" id="ref" name="ref" value="${eqna.ref }">
<input type="hidden" id="user_name " name="user_name" value="${login.user_name }">
<input type="text" id="answer_id" name="answer_id" value="${eqna.answer_id}">

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
	    <span><a href="./E_Qnalist.do?seq=${param.seq }&sub_seq=${param.sub_seq}"><img src="${pageContext.request.contextPath}/img/list.png"></a></span>
	</div>

</div>
</form>
</section>