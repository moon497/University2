<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/> 
<style>
section#posts div.box p {
	overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 3;
    -webkit-box-orient: vertical;
    word-wrap: break-word;
    line-height: 1.3em;
    height: 3.6em;
}
</style>
<section id="posts" class="boxes_area">
    <div class="container">
        <div class="row">
            <c:set var="doneLoop" value="false"/>	
        	<c:forEach items="${noticeList }" var="notice" varStatus="status"> 
              	<c:if test="${not doneLoop}">       	
            <div class="col-sm-4">
                <div class="box">
                    <h3 class="col-sm-11"><a href="${pageContext.request.contextPath }/notice/detail.do?seq=${notice.bbsSeq}">${notice.bbsTitle }</a></h3>
                    <p class="col-sm-12">${notice.bbsContent }</p>                    
                    <i class="fa fa-clipboard"></i>
                </div>
            </div>
                </c:if>
	            <c:if test="${status.count == 3 }">
	            	<c:set var="doneLoop" value="true"/>
	            </c:if>
        	</c:forEach>
        </div>
    </div>
</section>