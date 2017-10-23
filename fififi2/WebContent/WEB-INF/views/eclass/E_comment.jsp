<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src='${pageContext.request.contextPath }/js/NoticeBbsWrite.js' ></script>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/NoticeBbsWrite.css' />
<fmt:requestEncoding value="utf-8"/>

<div class="row">
	<div class="col-sm-9">
		<h3></h3>
	</div>
</div>
<div class="row">
	<div class="comment">
		<div id="comment">
			</div>
		</div>
</div>

<form>
<table>
<c:if test="${empty clist}">
 		<tr style="text-align: center;">
 			<td colspan="5"> 작성된 글이 없습니다.</td>
 		</tr>
 </c:if>
 
<c:forEach items="${clist }" var="comments">
<div class="panel panel-default">
		<div class="panel-heading">
			<strong>${comments.user_name }</strong>
			<c:choose>
				<c:when test="${comments.filename != '-1' and login.user_id eq comments.user_id}">
					<div class="row" style="text-align: -webkit-auto;">
					<div class="col-sm-10">
	                	<span> 첨부파일 : <a href="${pageContext.request.contextPath }/upload/${comments.filename}" download="${comments.org_filename }">${comments.org_filename }</a></span>
		       		</div>
	          	</div>
				</c:when>
				
				<c:when test="${comments.filename != '-1' and login.user_auth eq 200}">
					<div class="row" style="text-align: -webkit-auto;">
					<div class="col-sm-10">
	                	<span> 첨부파일 : <a href="${pageContext.request.contextPath }/upload/${comments.filename}" download="${comments.org_filename }">${comments.org_filename }</a></span>
		       		</div>
	          	</div>
				</c:when>
				
            </c:choose>
		</div>
	 	<div class="panel-body">
			<span>${comments.c_content }</span>					
		</div>
		<div class="panel-footer" style="text-align: -webkit-right;">				
				<div style="display: -webkit-inline-box;">
				<c:if test="${login.user_id eq comments.user_id }">
					<span class="label label-default"><a href="deleteComment.do?seq=${param.seq }&sub_seq=${param.sub_seq}&c_seq=${comments.c_seq }">삭제</a></span>
				</c:if>
				</div>
		</div>
</div>
 </c:forEach>
</table>
</form>

<!-- 댓글 등록 -->
<div class="row">
	<div class="col-md-3">
		<h4>과제 제출</h4>	
	</div>
</div>   
<div class="row">   
	<div class="col-md-12">
		<form action="E_comment_write.do" method="POST" enctype="multipart/form-data">
	 	<input type="hidden" name="user_id" value="${login.user_id }" />
		<input type="hidden" name="eclass_pds_bbs_seq" value="${param.seq }">
		<input type="hidden" name="sub_seq" value="${param.sub_seq}">
		<div class="panel panel-default">
				<div class="panel-heading">
					<strong>${login.user_name }</strong>
			   <div class="form-group">
			   <input type="file" id="fileload" name="fileload" class="file" style="visibility: hidden; position: absolute;">
					<div class="input-group col-xs-12">
					     <span class="input-group-addon"><i class="fa fa-file"></i></span>
					     <input type="text" class="form-control input-lg" disabled placeholder="파일 업로드">
					     <span class="input-group-btn">
							<button class="browse btn btn-primary input-lg" type="button"><i class="glyphicon glyphicon-search"></i> 파일</button>
					     </span>
				    </div>
				</div> 
		</div>
				<div class="panel-body" style="padding: inherit;">
				<textarea name="c_content" style="width: -webkit-fill-available;border: 0px;height: 10em;" placeholder="과제를 제출해주세요." ></textarea>				
				</div>
				<div class="panel-footer" style="text-align: -webkit-right;">				
					<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> 제출</button>
				</div>
		</div>
		</form>
	</div>       
</div>