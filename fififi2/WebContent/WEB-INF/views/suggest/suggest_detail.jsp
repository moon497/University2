<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/>
	
<section class="category-content col-sm-9">
    <h2 class="category-title">건의사항</h2> 
      

<div id="postlist">
	<div class="panel">
		<div class="panel-heading">
			<div class="text-center">
				<div class="row">
					<div class="col-sm-9">
						<h3 class="pull-left">${sug.title }</h3>
					</div>
					<div class="col-sm-3">
						<h4 class="pull-right">
							<small><em>${fn:substring(sug.wdate,0,10) }</em></small>
						</h4>
					</div>
				</div>
				<hr
					style="margin-top: 0; margin-bottom: 0.5em; border-top-color: #ccc;">
				<c:if test="${sug.filename != '-1' }">
					<div class="row" style="text-align: -webkit-auto;">
						<div class="col-sm-2">
							<span>첨부파일:</span>
						</div>
						<div class="col-sm-10">
							<span><a
								href="${pageContext.request.contextPath }/upload/file/${sug.filename}"
								download="${sug.org_filename }">${sug.org_filename }</a></span>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		<div class="panel-body">
			<span>${sug.content }</span>
		</div>
		<c:if test="${login.user_id == sug.user_id || login.user_auth == 300 }">
			<div class="panel-footer" style="text-align: right;">
				<button type="button" class="btn btn-warning btn-xs"
					onclick="location.href='./suggestUpdate.do?seq=${sug.suggest_seq }'">수정</button>
				<button type="button" class="btn btn-danger btn-xs"
					onclick="location.href='./suggestDelete.do?seq=${sug.suggest_seq }&page=${param.page}'">삭제</button>
			</div>
		</c:if>
	</div>
</div>


</section>

