<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/> 
<section class="grid-area">
<div class="row">
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
</div>
<div class="row">
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
</div>
<div class="row">
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
</div>
<div class="row">
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
	<div class="col-sm-3"></div>
</div>

<!-- 페이징 -->
<div class="row" style="text-align: center;">
	<div class="col-sm-12">
	    <ul class="pagination pagination-lg">
	    	<!-- 10페이지 이전 -->
	    	<c:choose>
		  	<c:when test="${pagination.currPage <= pagination.pageLimit }">
		  		<li class="disabled"><a href="#"><i class="fa fa-angle-double-left"></i></a></li>	  	
		  	</c:when>
		  	<c:otherwise>
		  		<li><a href="./list.do?page=${pagination.currPage - pagination.pageLimit }"><i class="fa fa-angle-double-left"></i></a></li>	 	  	
		  	</c:otherwise>
		  </c:choose> 
		  <!-- 1페이지 이전 -->
		  <c:choose>
		  	<c:when test="${pagination.currPage == 1 }">
		  		<li class="disabled"><a href="#"><i class="fa fa-angle-left"></i></a></li>	  	
		  	</c:when>
		  	<c:otherwise>
		  		<li><a href="./list.do?page=${pagination.currPage - 1 }"><i class="fa fa-angle-left"></i></a></li>	 	  	
		  	</c:otherwise>
		  </c:choose>
		  <!-- 페이징 설정만큼 돌리기 -->
		  <c:forEach var="i" begin="${pagination.startPage }" end="${pagination.endPage }" step="1">
		  	<c:choose>
		  		<c:when test="${i == pagination.currPage }">
		 			<li class="active">
		 				<a href="./list.do?page=${i }">${i }</a>
		 			</li>	  		
		  		</c:when>
		  		<c:otherwise>
		  			<li><a href="./list.do?page=${i }">${i }</a></li>	  		
		  		</c:otherwise>
		  	</c:choose>
		  </c:forEach>
		  <!-- 1페이지 이후 -->
		  <c:choose>
		  	<c:when test="${pagination.currPage == pagination.finalEndPage }">
		  		<li class="disabled"><a href="#"><i class="fa fa-angle-right"></i></a></li>	  	
		  	</c:when>
		  	<c:otherwise>
		  		<li><a href="./list.do?page=${pagination.currPage + 1 }"><i class="fa fa-angle-right"></i></a></li>	 	  	
		  	</c:otherwise>
		  </c:choose>
		  <!-- 10페이지 이후 -->
		  <c:choose>
		  	<c:when test="${pagination.currPage + pagination.pageLimit > pagination.finalEndPage }">
		  		<li class="disabled"><a href="#"><i class="fa fa-angle-double-right"></i></a></li>	  	
		  	</c:when>
		  	<c:otherwise>
		  		<li><a href="./list.do?page=${pagination.currPage + pagination.pageLimit }"><i class="fa fa-angle-double-right"></i></a></li>	 	  	
		  	</c:otherwise>
		  </c:choose>
		</ul>
    </div>
</div>
    
<!-- 버튼 목록 -->
<div class="row" style="text-align: right;">
	<div class="col-sm-12">
		<div class="button-group">
			<div class="arc-comment">
				<button type="button" class="btn btn-primary" onclick="location.href='./write.do'"><i class="fa fa-comments"></i> 글쓰기</button>	
			</div>
		</div>
	</div>
</div>
</section>