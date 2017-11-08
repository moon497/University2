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
		// image upload  
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
	//formdata == image file
    var form_data = new FormData();
    form_data.append('file', file);
    
    //ajax
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

function suggestUpdate(seq) {
	var content = $('#summernote').summernote("code");
	
	$('#Content').val(content);
 
	$('#suggestUpdate').submit();
	
}
</script>


<section class="category-content col-sm-9">
    <h2 class="category-title">건의사항</h2>


<form id="suggestUpdate" action="./suggestUpdateAf.do" method="POST" enctype="multipart/form-data">
<input type="hidden" id="Content" name="Content" value="" />

<div class="col-md-12">
	<div class="form-group"> <!-- userId field -->
		<input type="hidden" id="suggest_seq" name="suggest_seq" value="${suggest.suggest_seq }">
		<label class="control-label " for="user_id">아이디</label>
		<input class="form-control" id="user_id" name="user_id" type="text" value="${login.user_id }" readonly="readonly"/>
	</div>
	
	<div class="form-group"> <!-- "title" field -->
		<label class="control-label " for="title">제목</label>
		<input class="form-control" id="title" name="title" type="text" value="${suggest.title }" />
	</div>
	
	<div class="form-group"> <!-- content field -->
		<label class="control-label " for="content">내용</label>
		<div id="summernote">${suggest.content }</div>
	</div>
	
	
	<!-- 파일 업로드
	<div class="form-group"> File field
	   <input type="file" id="file" name="file" class="file" style="visibility: hidden;position: absolute;">
	   <div class="input-group col-xs-12">
	     <span class="input-group-addon"><i class="fa fa-file"></i></span>
	     <input type="text" class="form-control input-lg" disabled placeholder="파일 업로드">
	     <span class="input-group-btn">
	       <button class="browse btn btn-primary input-lg" type="button"><i class="glyphicon glyphicon-search"></i> 파일</button>
	     </span>
	   </div>
	</div>	
	 -->
	 
	<div class="form-group pull-right">
		<button class="btn btn-primary " name="button" type="button" onclick="suggestUpdate();">수정</button>
	</div>
	
</div>
</form>


</section>