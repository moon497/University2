<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<!-- include summernote-ko-KR -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/lang/summernote-ko-KR.js"></script>

<script type="text/javascript">

/* summerNote */
$(document).ready(function() {
	$('#summernote').summernote({
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
</script>
<script type="text/javascript">
function bbsWrite() {
	var content = $('#summernote').summernote("code");
	
	$('#content').val(content);
 
	$('#bbsWrite').submit();
	
}
</script>

<form id="bbsWrite" action="./write.do" method="POST">
<input type="hidden" id="content" name="content" value="" />

<div id="summernote"></div>

<button class="btn btn-primary " name="button" type="button" onclick="bbsWrite();">글쓰기</button>