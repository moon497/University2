<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/> 
<section class="grid-area">
<!-- 상품 리스트 -->
<c:forEach items="${list }" var="good" varStatus="status">
<c:if test="${status.index % 6 == 0 }">
<div class="row row-eq-height">
</c:if>
	<div class="col-sm-2" style="text-align: -webkit-center;">
      	<a href="./detail.do?seq=${good.seq }">
	      <div class="thumbnail" style="overflow: hidden;">      	
	      <c:if test="${good.imgUrl == null }">
	   		<img src="https://placehold.it/160x200?text=Not Image" class="media-object" alt="Good" style="float:left">
	      </c:if>
	      <c:if test="${good.imgUrl != null }">
	        <img src="${good.imgUrl }" class="media-object" alt="Good">
	      </c:if>	      
	      </div>
	      
	      <div class="context">
	      	<h4 class="desc_content" style="color: white; text-shadow: -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000;"><strong>${good.status }</strong></h4>
	        <strong>[${good.category }] ${good.title }</strong>
	        <p> ${good.price } 원</p>
	        <button class="btn">상품 보기</button>
	       </div>
        </a>
	</div>
<c:if test="${status.index % 6 == 5 }">
</div>
</c:if>
</c:forEach>


<!-- 페이징 -->
<div class="row" style="text-align: center;">
	<div class="col-sm-12">
	    <ul class="pagination pagination-lg">
	    	<!-- 10페이지 이전 -->
	    	<c:choose>
		  	<c:when test="${pagination.currPage <= pagination.pageLimit }">
		  		<li class="disabled"><a href="#"><i class="fa fa-angle-double-left" style="font-size: x-large;"></i></a></li>	  	
		  	</c:when>
		  	<c:otherwise>
		  		<li><a href="./list.do?page=${pagination.currPage - pagination.pageLimit }"><i class="fa fa-angle-double-left" style="font-size: x-large;"></i></a></li>	 	  	
		  	</c:otherwise>
		  </c:choose> 
		  <!-- 1페이지 이전 -->
		  <c:choose>
		  	<c:when test="${pagination.currPage == 1 }">
		  		<li class="disabled"><a href="#"><i class="fa fa-angle-left" style="font-size: x-large;"></i></a></li>	  	
		  	</c:when>
		  	<c:otherwise>
		  		<li><a href="./list.do?page=${pagination.currPage - 1 }"><i class="fa fa-angle-left" style="font-size: x-large;"></i></a></li>	 	  	
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
		  		<li class="disabled"><a href="#"><i class="fa fa-angle-right" style="font-size: x-large;"></i></a></li>	  	
		  	</c:when>
		  	<c:otherwise>
		  		<li><a href="./list.do?page=${pagination.currPage + 1 }"><i class="fa fa-angle-right" style="font-size: x-large;"></i></a></li>	 	  	
		  	</c:otherwise>
		  </c:choose>
		  <!-- 10페이지 이후 -->
		  <c:choose>
		  	<c:when test="${pagination.currPage + pagination.pageLimit > pagination.finalEndPage }">
		  		<li class="disabled"><a href="#"><i class="fa fa-angle-double-right" style="font-size: x-large;"></i></a></li>	  	
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