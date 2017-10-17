<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 
<section class="category-content col-sm-9">
    <h2 class="category-title">학교소개</h2>
        <!-- 버튼 목록 -->
        
    <c:if test="${login.user_auth == 300}">
			<div class="button-group" align="right">
				<div class="arc-comment">
					<a href="./introBbswrite.do" title="Comment"><i class="fa fa-comments">글쓰기</i> </a>
				</div>
			</div>
	</c:if> <br><br>
	
		    
    <ul class="media-list">
    	
		<c:forEach items="${list }" var="list" varStatus="vs">
	        <li class="media">
	            <div class="media-left">
	                <a href="introBbsDetail.do?seq=${list.intro_bbs_seq }" title="Post">
	                	<img src="${pageContext.request.contextPath }/upload/intro/${list.filename}"  
	                	class="media-object" alt="Post" style="width: 262px; height: 200px; "> </a>
	            </div>
	            <div class="media-body">
	                <h3 class="media-heading"><a href="introBbsDetail.do?seq=${list.intro_bbs_seq }" title="Post Title">${list.title}</a></h3>
	                <p>${list.content} </p>
	                <aside class="meta category-meta">
	                    <div class="pull-left">
	                        <div class="arc-comment"> 조회수  ${list.readcount }</div>
	                        <div class="arc-date">${list.wdate }</div>
	                    </div>

	                </aside>                                
	            </div>
	        </li>
        </c:forEach>
        
                        
    </ul>                    
</section>