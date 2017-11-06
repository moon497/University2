<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 

<style>
body > main > div > div > section > ul > li > div.media-body > p {
	overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 5;
    -webkit-box-orient: vertical;
    word-wrap: break-word;
    line-height: 1.8em;
    height: 9em;
}
</style>

<section class="category-content col-sm-9">
<form id="_frmFormSearch">
    <h2 class="category-title">학교소개</h2>		    
    <ul class="media-list">
    	
		<c:forEach items="${list }" var="list" varStatus="vs">
	        <li class="media">
	            <div class="media-left">
	                <a href="introBbsDetail.do?seq=${list.intro_bbs_seq }" title="Post">
	                	<c:if test="${list.filename == '-1'}">
	                		<img src="https://placehold.it/262x200?text=Not Image" 
	                		class="media-object" alt="Post">
	                	</c:if>
	                	<c:if test="${list.filename != '-1'}">
	                		<img src="${pageContext.request.contextPath }/upload/intro/${list.filename}"  
	                		class="media-object" alt="Post" style="width: 262px; height: 200px; "> 
	                	</c:if>
                	</a>
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
    <input type="hidden" name="pageNumber" id="_pageNumber" value="${(empty pageNumber)?0:pageNumber }"/>
	<input type="hidden" name="recordCountPerPage" id="_recordCountPerPage" value="${(empty recordCountPerPage)?10:recordCountPerPage }">	
    </form>
    
    <!-- 버튼 목록 -->
    <c:if test="${login.user_auth == 300}">
    <div class="row" style="text-align: right;">
		<div class="col-sm-12">
			<div class="button-group" align="right">
				<div class="arc-comment">	
					<button type="button" class="btn btn-primary" onclick="location.href='./introBbswrite.do'"><i class="fa fa-comments"></i> 글쓰기</button>	
				</div>
			</div>
		</div>
	</div>
	</c:if>

	<jsp:include page="/WEB-INF/views/intro/paging.jsp" flush="false">
		<jsp:param value="${pageNumber }" name="pageNumber"/>
		<jsp:param value="${totalRecordCount }" name="totalRecordCount"/>
		<jsp:param value="${pageCountPerScreen }" name="pageCountPerScreen"/>
		<jsp:param value="${recordCountPerPage }" name="recordCountPerPage"/>
	</jsp:include>
		

	<script type="text/javascript">
	function goPage(pageNumber) {
		$("#_pageNumber").val(pageNumber);
		$("#_frmFormSearch").attr("target","_self").attr("action", "introBbs.do").submit();
	}
	</script>
	
</section>