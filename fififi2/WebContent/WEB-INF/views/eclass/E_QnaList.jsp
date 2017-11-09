<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<fmt:requestEncoding value="utf-8"/>
<style>
.th{
   text-align: center;
   }
</style>


<jsp:useBean id="ubbs" class="kh.com.util.BbsArrow" />
<!-- list-style -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/list-style.css" />

<section class="category-content col-sm-9">
<!-- body -->
<h2 class="category-title">QnA</h2>

<div class="row">
<div class="col-sm-11">
<div class="table-responsive">
<form action="E_PdswriteAf.do" id=""></form> 
  <table class="table table-hover table-bordered">
     <colgroup>
        <col class="col-sm-1" />
        <col class="col-sm-7" />
        <col class="col-sm-2" />
        <col class="col-sm-2" />
     </colgroup>
    <thead>
    <tr class="active">
		<th>번호</th><th>제목</th><th>글쓴이</th><th>작성일</th>
	</tr>
	</thead>

<tbody>
	<c:if test="${empty qnalist}">
       <tr style="text-align: center;">
          <td colspan="5">작성된 글이 없습니다.</td>
       </tr>
    </c:if>
    
	<c:forEach items="${qnalist }" var="qna" varStatus="qnaS">
	<jsp:setProperty property="depth" name="ubbs" value="${qna.depth }"/>
	<tr>
		<td>${qnaS.count }</td>
		<td style="text-align: left">
			<jsp:getProperty property="arrow" name="ubbs"/>
			<c:choose>
				<c:when test="${qna.del eq 1}">
					<i class="fa fa-eraser" aria-hidden="true" style="margin-right: 5px;"></i>삭제된 글입니다.
				</c:when>
				<c:when test="${login.user_auth eq 200 and qna.del eq 0}">				
					<a href="E_Qnadetail.do?seq=${qna.eclass_qna_bbs_seq }&sub_seq=${qna.sub_seq}"> ${qna.title}</a>
				</c:when>
				<c:when test="${qna.answer_id eq login.user_id}">				
					<a href="E_Qnadetail.do?seq=${qna.eclass_qna_bbs_seq }&sub_seq=${qna.sub_seq}"> ${qna.title}</a>
				</c:when>
				<c:when test="${qna.secret eq 1}">
					<i class="fa fa-lock" aria-hidden="true" style="margin-right: 5px;"></i>비밀 글입니다.
				</c:when>
				
				<c:otherwise>
					<a href="E_Qnadetail.do?seq=${qna.eclass_qna_bbs_seq }&sub_seq=${qna.sub_seq}"> ${qna.title}</a>
				</c:otherwise>
			</c:choose>					
		</td>
		<td>${qna.user_name}</td>
		<td>${fn:substring(qna.wdate,0,10)}</td>
	</tr>
	</c:forEach>

</tbody>
</table>

<div class="button-group">
    <div class="arc-comment">
    	<a href="E_Qnawrite.do?sub_seq=${param.sub_seq }"><i class="fa fa-comments"></i> 글쓰기</a>
	</div>
</div>
</div>
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
           <li><a href="./E_Qnalist.do?page=${pagination.currPage - pagination.pageLimit }&sub_seq=${param.sub_seq}"><i class="fa fa-angle-double-left"></i></a></li>            
        </c:otherwise>
     </c:choose> 
     <!-- 1페이지 이전 -->
     <c:choose>
        <c:when test="${pagination.currPage == 1 }">
           <li class="disabled"><a href="#"><i class="fa fa-angle-left"></i></a></li>        
        </c:when>
        <c:otherwise>
           <li><a href="./E_Qnalist.do?page=${pagination.currPage - 1 }&sub_seq=${param.sub_seq}"><i class="fa fa-angle-left"></i></a></li>            
        </c:otherwise>
     </c:choose>
     <!-- 페이징 설정만큼 돌리기 -->
     <c:forEach var="i" begin="${pagination.startPage }" end="${pagination.endPage }" step="1">
        <c:choose>
           <c:when test="${i == pagination.currPage }">
             <li class="active">
                <a href="./E_Qnalist.do?page=${i }&sub_seq=${param.sub_seq}">${i }</a>
             </li>           
           </c:when>
           <c:otherwise>
              <li><a href="./E_Qnalist.do?page=${i }&sub_seq=${param.sub_seq}">${i }</a></li>           
           </c:otherwise>
        </c:choose>
     </c:forEach>
     <!-- 1페이지 이후 -->
     <c:choose>
        <c:when test="${pagination.currPage == pagination.finalEndPage }">
           <li class="disabled"><a href="#"><i class="fa fa-angle-right"></i></a></li>        
        </c:when>
        <c:otherwise>
           <li><a href="./E_Qnalist.do?page=${pagination.currPage + 1 }&sub_seq=${param.sub_seq}"><i class="fa fa-angle-right"></i></a></li>            
        </c:otherwise>
     </c:choose>
     <!-- 10페이지 이후 -->
     <c:choose>
        <c:when test="${pagination.currPage + pagination.pageLimit > pagination.finalEndPage }">
           <li class="disabled"><a href="#"><i class="fa fa-angle-double-right"></i></a></li>        
        </c:when>
        <c:otherwise>
           <li><a href="./E_Qnalist.do?page=${pagination.currPage + pagination.pageLimit }&sub_seq=${param.sub_seq}"><i class="fa fa-angle-double-right"></i></a></li>            
        </c:otherwise>
     </c:choose>
   </ul>
</div>
</section>