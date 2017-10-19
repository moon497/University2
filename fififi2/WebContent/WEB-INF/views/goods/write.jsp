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
		callbacks: {
          onImageUpload: function(files, editor, welEditable) {
            for (var i = files.length - 1; i >= 0; i--) {
              sendFile(files[i], this);
            }
          }
        }
	});
});
function sendFile(file, el) {
    var form_data = new FormData();
    form_data.append('file', file);
    $.ajax({
      data: form_data,
      type: "POST",
      url: '${pageContext.request.contextPath }/file/image/upload.do',
      cache: false,
      contentType: false,
      enctype: 'multipart/form-data',
      processData: false,
      success: function(url) {
    	  console.log(url);
        $(el).summernote('editor.insertImage', url);
        $('#imageBoard > ul').append('<li><img src="'+url+'" width="480" height="auto"/></li>');
      }
    });
}

function bbsWrite() {
	var content = $('#summernote').summernote("code");
	
	$('#content').val(content);
 
	$('#bbsWrite').submit();
	
}
</script>

<section class="write">
<form id="bbsWrite" action="./write.do" method="POST" enctype="multipart/form-data">
<input type="hidden" name="bbsSeq" value="${param.seq }" />
<input type="hidden" id="content" name="content" value="" />
<input type="hidden" id="userId" name="userId" value="${login.user_id }"/>


<div class="row">
	<div class="form-group"> <!-- userId field -->
		<label class="control-label " for="userName">아이디</label>
		<input class="form-control" id="userName" name="userName" type="text" value="${login.user_name }" readonly="readonly"/>
	</div>
</div>
<div class="row">
	<div class="col-sm-2">
		<div class="form-group"> <!-- "category" field -->
		<label class="control-label " for="title">제목</label>
		  <select class="form-control" id="category" name="category">
		    <option value="도서">도서</option>
		    <option value="전자기기">전자기기</option>
		    <option value="생활용품">생활용품</option>
		    <option value="기타">기타</option>
		  </select>
		</div>
	</div>
	<div class="col-sm-9">		
		<div class="form-group" style="margin-top: 2em;"> <!-- "title" field -->
			<input class="form-control" id="title" name="title" type="text" value=""/>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-4">
		<div class="form-group"> <!-- 가격 field -->
			<label class="control-label " for="price">가격</label>
			<input class="form-control" id="price" name="price" type="text" value=""/>
		</div>
	</div>	
	<div class="col-sm-4">
		<div class="form-group"> <!-- 주소 field -->
			<label class="control-label " for="address">주소</label>
			<input class="form-control" id="address" name="address" type="text" value=""/>
		</div>
	</div>
	<div class="col-sm-4">
		<div class="form-group"> <!-- 전화번호 field -->
			<label class="control-label " for="phone">전화번호</label>
			<input class="form-control" id="phone" name="phone" type="text" value=""/>
		</div>
	</div>
</div>
<div class="row">
	<div class="form-group"> <!-- content field -->
		<label class="control-label " for="content">내용</label>
		<div id="summernote"></div>
	</div>
</div>
<div class="row">
	<div class="form-group pull-right">
		<button class="btn btn-primary " name="button" type="button" onclick="bbsWrite();">글쓰기</button>
	</div>
</div>
</form>
</section>