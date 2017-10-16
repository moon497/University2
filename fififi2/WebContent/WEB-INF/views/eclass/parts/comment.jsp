<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- comment -->
<div class="row">
	<div class="col-sm-12">
		<h3>댓글</h3>
	</div><!-- /col-sm-12 -->
</div><!-- /row -->
<div class="row">
	<div class="comment">
		<div class="col-sm-11 col-sm-offset-1">
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong>myusername</strong> <span class="text-muted">commented 5 days ago</span>
				</div>
				<div class="panel-body">
				<span>댓글 위치입니다</span>
				</div><!-- /panel-body -->
			</div><!-- /panel panel-default -->
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
		<input type="hidden" name="boardAddress" value="${boardName }">
		<input type="hidden" name="userId" value="asdf" />
		<input type="hidden" name="bbsSeq" value="${bbs.bbsSeq}" />
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