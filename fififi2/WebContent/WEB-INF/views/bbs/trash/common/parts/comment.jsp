<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 				$('#comment').prepend(
 						'<div id="comment_'+commentList[index].commentSeq+'" class="panel panel-default">'
 							+ '<div class="panel-heading">'
 								+ '<strong>'+commentList[index].userId+'</strong> <span class="text-muted">'+commentList[index].commentCreateAt+'</span>'
 								+ '<div style="display: -webkit-inline-box;float: right;">'
 									+ '<span class="label label-default"><a onclick="commentUpdate('+commentList[index].commentSeq+')">수정</a></span> <span class="label label-default"><a href="../comment/delete.do?seq='+commentList[index].commentSeq+'&page=${param.page}&boardUrl=${boardUrl}&bbsSeq=${bbs.bbsSeq}">삭제</a></span>'
 								+ '</div>'
							+ '</div>'
 							+ '<div class="panel-body">'
 								+ '<span>'+commentList[index].commentContent+'</span>'					
 							+ '</div>'
						+'</div>'
 				);
			}); 
		}
	});
})
</script>
<script type="text/javascript">
/* 댓글 수정시 다같이 수정되는 문제 */
function commentUpdate(i) {	
	var div = $("#comment_"+i);
	console.log(div);
	$("#comment_"+ i).wrap('<form action="../comment/updateAf.do" method="POST"></form>');
	$("#comment_"+ i).prepend(
			'<input type="hidden" name="boardUrl" value="${boardUrl}">'
			+ '<input type="hidden" name="userId" value="asdf" />'
			+ '<input type="hidden" name="bbsSeq" value="${bbs.bbsSeq}" />'
			+ '<input type="hidden" name="page" value="${param.page}" />'
			+ '<input type="hidden" name="commentSeq" value="'+i+'" />'			
	);
 	$("#comment_"+ i + " > div.panel-heading > div").html('');
	$("#comment_"+ i + " > div.panel-body").html(
			'<textarea name="commentContent" style="width: -webkit-fill-available;border: 0px;height: 10em;" placeholder="글쓴이는 댓글이 필요해요!" >'
			+'</textarea>'
	);
	$("#comment_"+ i).append(
			'<div class="panel-footer" style="text-align: -webkit-right;">'				
			+ '<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> Share</button>'
			+ '</div>'
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
		<input type="hidden" name="userId" value="asdf" />
		<input type="hidden" name="bbsSeq" value="${bbs.bbsSeq}" />
		<input type="hidden" name="page" value="${param.page}" />
		<div class="panel panel-default">
				<div class="panel-heading">
					<strong>myusername</strong> <span class="text-muted">commented 5 days ago</span>
				</div>
				<div class="panel-body" style="padding: inherit;">
				<textarea name="commentContent" style="width: -webkit-fill-available;border: 0px;height: 10em;" placeholder="글쓴이는 댓글이 필요해요!" ></textarea>				
				</div>
				<div class="panel-footer" style="text-align: -webkit-right;">				
					<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> Share</button>
				</div>
		</div><!-- Status Upload  -->		
		</form>
	</div>       
</div>