<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- icon -->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- AJAX -->
<script type="text/javascript">
$(document).ready(function() {
	//init
	var bbsSeq;
	var commentList;
	
	//set
	bbsSeq = ${param.seq};
	
	$.ajax({
		type: 'GET',
		url: '../comment/list.do',
		data: {
			"bbsSeq" : bbsSeq
		},		
		async: true, 
		success: function(data) {
			commentList = data.commentList;
			console.log(commentList);
			
 			$.each(commentList, function(index, item) {
 				console.log(commentList[index]);
 				//댓글 만들기
 				$('#comment').prepend(setHtml(commentList[index]));
			}); 
		}
	});
});
function setHtml(comment) {
	var html;
	
	if (comment.commentShape == '0') {
		html = '<div id="comment_'+comment.commentSeq+'" class="panel panel-default">'
		+ '<div class="panel-heading">'
			+ '<strong>'+comment.userId+'</strong> <span class="text-muted">'+comment.commentCreateAt+'</span>'
			+ '<div style="display: -webkit-inline-box;float: right;">'
			+ '<button type="button" class="btn btn-info btn-xs" onclick="commentReply('+comment.commentGroupNo+', '+comment.commentSeq+', \''+comment.commentShape+'\')">답변</button> '
				+ ' <button type="button" class="btn btn-warning btn-xs" onclick="commentUpdate('+comment.commentSeq+')">수정</button> '
				+ ' <button type="button" class="btn btn-danger btn-xs" onclick="location.href=\'../comment/delete.do?seq='+comment.commentSeq+'&page=${param.page}&boardUrl=${boardUrl}&bbsSeq=${bbs.bbsSeq}\'">삭제</button>'
			+ '</div>'
	+ '</div>'
		+ '<div class="panel-body">'
			+ '<span>'+comment.commentContent+'</span>'					
		+ '</div>'
	+'</div>';
	} else {
		html = '		<div class="row">   '
			+'		<div class="col-sm-'+comment.commentShape.length+'" style="text-align: right;">'
			+'			<i class="material-icons">subdirectory_arrow_right</i>'
			+'		</div>'
			+'		<div class="col-sm-'+(12 - comment.commentShape.length)+'">'
			+'<div id="comment_'+comment.commentSeq+'" class="panel panel-default">'
				+ '<div class="panel-heading">'
				+ '<strong>'+comment.userId+'</strong> <span class="text-muted">'+comment.commentCreateAt+'</span>'
				+ '<div style="display: -webkit-inline-box;float: right;">'
				+ '<button type="button" class="btn btn-info btn-xs" onclick="commentReply('+comment.commentGroupNo+', '+comment.commentSeq+', \''+comment.commentShape+'\')">답변</button> '
					+ ' <button type="button" class="btn btn-warning btn-xs" onclick="commentUpdate('+comment.commentSeq+')">수정</button> '
					+ ' <button type="button" class="btn btn-danger btn-xs" onclick="location.href=\'../comment/delete.do?seq='+comment.commentSeq+'&page=${param.page}&boardUrl=${boardUrl}&bbsSeq=${bbs.bbsSeq}\'">삭제</button>'
				+ '</div>'
			+ '</div>'
			+ '<div class="panel-body">'
			+ '<span>'+comment.commentContent+'</span>'					
		+ '</div>'
			+ '</div>'
		+'</div>'
		+'</div>';
	}
	
	return html;
}
</script>
<script type="text/javascript">
/* 댓글 수정시 다같이 수정되는 문제 */
function commentUpdate(i) {	
	var div = $("#comment_"+i);
	console.log(div);
	$("#comment_"+ i).wrap('<form action="../comment/updateAf.do" method="POST"></form>');
	$("#comment_"+ i).prepend(
			'<input type="hidden" name="boardUrl" value="${boardUrl}">'
			+ '<input type="hidden" name="userId" value="${login.user_id}" />'
			+ '<input type="hidden" name="bbsSeq" value="${bbs.bbsSeq}" />'
			+ '<input type="hidden" name="page" value="${param.page}" />'
			+ '<input type="hidden" name="commentSeq" value="'+i+'" />'
	);
 	$("#comment_"+ i + " > div.panel-heading > div").html('');
	$("#comment_"+ i + " > div.panel-body").html(
			'<textarea name="commentContent" style="width: -webkit-fill-available;border: 0px;height: 10em;" placeholder="댓글을 수정하세요" >'
			+'</textarea>'
	);
	$("#comment_"+ i).append(
			'<div class="panel-footer" style="text-align: -webkit-right;">'				
			+ '<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> 댓글 수정</button>'
			+ '</div>'
	);
}
/* 답변 */
function commentReply(groupNo, i, shape) {
	$("#comment_"+ i).after(
			'<div class="row">   '
			+'	<div class="col-sm-12">'
			+'		<form action="../comment/reply.do" method="POST">'
			+'		<input type="hidden" name="boardUrl" value="${boardUrl}">'
			+'		<input type="hidden" name="userId" value="${login.user_id }" />'
			+'		<input type="hidden" name="bbsSeq" value="${bbs.bbsSeq}" />'
			+'		<input type="hidden" name="commentGroupNo" value="'+groupNo+'" />'
			+'		<input type="hidden" name="page" value="${param.page}" />'
			+'		<input type="hidden" name="commentShape" value="'+shape+'" />'
			+'		<div class="col-sm-1">'
			+'			<i class="material-icons">subdirectory_arrow_right</i>'
			+'		</div>'
			+'		<div class="col-sm-11">'
			+'		<div class="panel panel-default">'
			+'				<div class="panel-heading">'
			+'				<strong>${login.user_name }</strong>'
			+'				</div>'
			+'				<div class="panel-body" style="padding: inherit;">'
			+'				<textarea name="commentContent" style="width: -webkit-fill-available;border: 0px;height: 10em;" placeholder="글쓴이는 댓글이 필요해요!" ></textarea>'
			+'				</div>'
			+'				<div class="panel-footer" style="text-align: -webkit-right;">'
			+'				<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> 대댓글 달기</button>'
			+'				</div>'
			+'		</div><!-- Status Upload  -->'
			+'		</div>'
			+'		</form>'
			+'	</div>'
			+'</div>'
	);
}
</script>
<!-- comment -->
<div class="row">
	<div class="col-sm-12">
		<h3>댓글</h3>
	</div><!-- /col-sm-12 -->
</div><!-- /row -->
<div class="row">
	<div class="comment">
		<div id="comment" class="col-sm-11 col-sm-offset-1">
			<!-- 댓글 목록이 삽입되는 자리 -->
		</div><!-- /col-sm-5 -->
	</div><!-- /comment -->
</div><!-- /row -->

<c:if test="${login != null }">
<!-- 댓글 등록 -->
<div class="row">
	<div class="col-md-3">
		<h3>댓글 쓰기</h3>	
	</div>
</div>   
<div class="row">   
	<div class="col-md-12">
		<form action="../comment/writeAf.do" method="POST">
		<input type="hidden" name="boardUrl" value="${boardUrl}">
		<input type="hidden" name="userId" value="${login.user_id }" />
		<input type="hidden" name="bbsSeq" value="${bbs.bbsSeq}" />
		<input type="hidden" name="page" value="${param.page}" />
		<div class="panel panel-default">
				<div class="panel-heading">
					<strong>${login.user_name }</strong>
				</div>
				<div class="panel-body" style="padding: inherit;">
				<textarea name="commentContent" style="width: -webkit-fill-available;border: 0px;height: 10em;" placeholder="글쓴이는 댓글이 필요해요!" ></textarea>				
				</div>
				<div class="panel-footer" style="text-align: -webkit-right;">				
					<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> 댓글 달기</button>
				</div>
		</div><!-- Status Upload  -->		
		</form>
	</div>       
</div>
</c:if>