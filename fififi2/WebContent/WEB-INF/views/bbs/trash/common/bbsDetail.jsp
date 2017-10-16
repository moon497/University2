<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- body -->
	<div id="postlist">        
        <div class="panel">
                <div class="panel-heading">
                    <div class="text-center">
                        <div class="row">
                            <div class="col-sm-9">
                                <h3 class="pull-left">${bbs.bbsTitle }</h3>
                            </div>
                            <div class="col-sm-3">
                                <h4 class="pull-right">
                                <small><em>${bbs.bbsWdate }</em></small>
                                </h4>
                            </div>
                        </div>
                        <hr style="margin-top: 0;    margin-bottom: 0.5em;    border-top-color: #ccc;">
                        <c:if test="${bbs.bbsStoredFileName != '-1' }">
                        <div class="row" style="text-align: -webkit-auto;">
                        	<div class="col-sm-2">
                        		<span>첨부파일:</span>
                        	</div>
                        	<div class="col-sm-10">
                        		<span><a href="${pageContext.request.contextPath }/upload/file/${bbs.bbsStoredFileName}" download="${bbs.bbsOrgFileName }">${bbs.bbsOrgFileName }</a></span>
                        	</div>
                        </div>
                        </c:if>
                    </div>
                </div>
            <div class="panel-body">
                <span>${bbs.bbsContent }</span>
            </div>
    		<c:if test="${login.user_id == bbs.userId || login.user_auth == 300 }">
            <div class="panel-footer">
                <span class="label label-default"><a href="./update.do?seq=${bbs.bbsSeq }">수정</a></span> 
                <span class="label label-default"><a href="./delete.do?seq=${bbs.bbsSeq }&page=${param.page}">삭제</a></span>
            </div>
            </c:if>
        </div>
    </div>