<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<script type="text/javascript" src='${pageContext.request.contextPath }/js/NoticeBbsWrite.js' ></script>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/NoticeBbsWrite.css' />

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<!-- include summernote-ko-KR -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/lang/summernote-ko-KR.js"></script>

<script type="text/javascript">
/* summerNote */
$(document).ready(function() {
	$('#summernote').summernote({
		height: 200,				// set editor height
		minHeight: null,			// set minimum height of editor
		maxHeight: null,			// set maximum height of editor
		focus: true,				// set focus to editable area after initializing summernote
		lang : 'ko-KR',				// 기본 메뉴언어 US->KR로 변경
		toolbar: [
		    ['style', ['style']],
		    ['font', ['bold', 'italic', 'underline', 'clear']],
		    ['fontname', ['fontname']],
		    ['color', ['color']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['height', ['height']],
		    ['table', ['table']],
		    ['insert', ['link', 'video']],
		    ['help', ['help']]
		  ]
	});
});

function postUpdate() {
	var content = $('#summernote').summernote("code");
	
	$('#bbsContent').val(content);
 
	/* $('#postUpdate').submit(); */
	document.getElementById('hiddenBtn').click();
	
}
</script>
<form id="postUpdate" action="./update.do" method="POST" enctype="multipart/form-data">
<input type="hidden" name="bbsSeq" value="${param.seq }" />
<input type="hidden" id="bbsContent" name="bbsContent" value="" />
<input type="hidden" id="bbsContent" name="bbsOrgFileName" value="${bbs.bbsOrgFileName }" />
<input type="hidden" id="bbsContent" name="bbsStoredFileName" value="${bbs.bbsStoredFileName }" />

<div class="col-md-12">
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
		<div id="summernote">${bbs.bbsContent }</div>
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
		<button class="btn btn-warning " name="button" type="button" onclick="postUpdate();">수정하기</button>
	<button id="hiddenBtn" type="submit" style="display: none;"></button>
	</div>
	
	
</div>
</form>