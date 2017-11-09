<%@page import="kh.com.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/>


<!-- list-style -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/list-style.css" />
<!-- body -->
<section class="category-content col-sm-9">
    <h2 class="category-title">건의사항</h2>

<div class="row">
<div class="col-sm-12">
<div class="table-responsive">     
     
  <table class="table table-hover table-bordered">
  
  	<colgroup>
  		<col class="col-sm-1" />
  		<col class="col-sm-7" />
  		<col class="col-sm-2" />
  		<col class="col-sm-2" />
  	</colgroup>
  	
    <thead>
      <tr class="active">
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>날짜</th>        
      </tr>
    </thead>
    
    <tbody>    
 	<!-- 				게시물 불러오기				 -->
 	<c:forEach items="${suggestlist }" var="sug">
 	  <c:if test="${sug.del eq 0 }">
 	  	<tr>
        <td>${sug.suggest_seq }</td>
        <td>
        	<a href="./suggestdetail.do?seq=${sug.suggest_seq }&page=${pagination.currPage}">${sug.title } </a> 
        	<c:if test="${sug.filename != '-1' }"><i class="fa fa-file"></i> </c:if>
  	<%-- <c:if test="${sug.totalComment != 0 }"><i class="fa fa-comment"></i> ${sug.totalComment }</c:if> --%>
        </td>
        <td>${sug.user_id }</td>
        <td>${fn:substring(sug.wdate,0,10) }</td>        
      </tr>
 	  </c:if>
 	  <c:if test="${sug.del eq 1 }">
 	  	<tr>
 	  		<td colspan="4">삭제된 글 입니다.</td>
 	  	</tr>
 	  </c:if>
      
   	</c:forEach>   
   	   
    </tbody>
    
  </table>
  
</div>
</div>
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
	  		<li><a href="./suggestlist.do?page=${pagination.currPage - pagination.pageLimit }"><i class="fa fa-angle-double-left"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose> 
	  <!-- 1페이지 이전 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage == 1 }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-left"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="./suggestlist.do?page=${pagination.currPage - 1 }"><i class="fa fa-angle-left"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	  <!-- 페이징 설정만큼 돌리기 -->
	  <c:forEach var="i" begin="${pagination.startPage }" end="${pagination.endPage }" step="1">
	  	<c:choose>
	  		<c:when test="${i == pagination.currPage }">
	 			<li class="active">
	 				<a href="./suggestlist.do?page=${i }">${i }</a>
	 			</li>	  		
	  		</c:when>
	  		<c:otherwise>
	  			<li><a href="./suggestlist.do?page=${i }">${i }</a></li>	  		
	  		</c:otherwise>
	  	</c:choose>
	  </c:forEach>
	  <!-- 1페이지 이후 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage == pagination.finalEndPage }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-right"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="./suggestlist.do?page=${pagination.currPage + 1 }"><i class="fa fa-angle-right"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	  <!-- 10페이지 이후 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage + pagination.pageLimit > pagination.finalEndPage }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-double-right"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="./suggestlist.do?page=${pagination.currPage + pagination.pageLimit }"><i class="fa fa-angle-double-right"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	</ul>
</div>
</div>
  
  
  

<!-- 글쓰기 버튼  -->
<c:if test="${null ne login.user_name }">
<div class="row" style="text-align: right;">
	<div class="col-sm-12">
		<div class="button-group">
			<div class="arc-comment">
				<button type="button" class="btn btn-primary" onclick="location.href='./suggestWrite.do'"><i class="fa fa-comments"></i> 글쓰기</button>	
			</div>
		</div>
	</div>
</div>
</c:if>
</section>
