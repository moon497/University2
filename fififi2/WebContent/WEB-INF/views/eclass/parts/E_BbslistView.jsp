<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<fmt:requestEncoding value="utf-8"/>
<style>
.th{
	text-align: center;
	}
</style>

<!-- list-style -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/list-style.css" />

<!-- body -->
<h2 class="category-title">공지</h2>

<div class="row">
<div class="col-sm-11">
<div class="table-responsive">
<form action="E_BbswriteAf.do" id=""></form> 
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
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
 	<!-- 				게시물 불러오기				 -->
 	<c:if test="${empty ebbslist}">
 		<tr style="text-align: center;">
 			<td colspan="5">작성된 글이 없습니다.</td>
 		</tr>
 	</c:if>
 	<c:forEach items="${ebbslist }" var="bbs" varStatus="ebbsS">
      <tr>
        <td>${ebbsS.count}</td>
        <td>
        	<a href="./E_Bbsdetail.do?seq=${bbs.eclass_notice_bbs_seq }&sub_seq=${bbs.sub_seq }&page=${pagination.currPage}">${bbs.title }</a> 
        	<c:if test="${bbs.filename != '-1' }"><i class="fa fa-file"></i></c:if>
        </td>
        <td>${bbs.user_name }</td>
        <td>${fn:substring(bbs.wdate,0,10) }</td>
      </tr>
   	</c:forEach>      
    </tbody>
  </table>
  </div>
</div>
</div>
<!-- 버튼 목록 -->
	<div class="button-group">
		<div class="arc-comment">
		<c:if test="${login.user_auth eq 200 }">
				<a href="E_Bbswrite.do?sub_seq=${param.sub_seq }"><i class="fa fa-comments"></i> 글쓰기</a>
		</c:if>
		</div>
	</div>
<!-- 페이징 -->
    <div style="text-align: center;">
    <ul class="pagination pagination-lg">
    	<!-- 10페이지 이전 -->
    	<c:choose>
	  	<c:when test="${pagination.currPage <= pagination.pageLimit }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-double-left"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="./E_Bbslist.do?page=${pagination.currPage - pagination.pageLimit }&sub_seq=${param.sub_seq}"><i class="fa fa-angle-double-left"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose> 
	  <!-- 1페이지 이전 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage == 1 }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-left"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="./E_Bbslist.do?page=${pagination.currPage - 1 }&sub_seq=${param.sub_seq}"><i class="fa fa-angle-left"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	  <!-- 페이징 설정만큼 돌리기 -->
	  <c:forEach var="i" begin="${pagination.startPage }" end="${pagination.endPage }" step="1">
	  	<c:choose>
	  		<c:when test="${i == pagination.currPage }">
	 			<li class="active">
	 				<a href="./E_Bbslist.do?page=${i }&sub_seq=${param.sub_seq}">${i }</a>
	 			</li>	  		
	  		</c:when>
	  		<c:otherwise>
	  			<li><a href="./E_Bbslist.do?page=${i }&sub_seq=${param.sub_seq}">${i }</a></li>	  		
	  		</c:otherwise>
	  	</c:choose>
	  </c:forEach>
	  <!-- 1페이지 이후 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage == pagination.finalEndPage }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-right"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="./E_Bbslist.do?page=${pagination.currPage + 1 }&sub_seq=${param.sub_seq}"><i class="fa fa-angle-right"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	  <!-- 10페이지 이후 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage + pagination.pageLimit > pagination.finalEndPage }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-double-right"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="./E_Bbslist.do?page=${pagination.currPage + pagination.pageLimit }&sub_seq=${param.sub_seq}"><i class="fa fa-angle-double-right"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	</ul>
</div>