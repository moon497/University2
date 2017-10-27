<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/>

<section class="category-content col-sm-9">
	<div id="postlist">        
        <div class="panel">
                <div class="panel-heading">
                    <div class="text-center">
                        <div class="row">
                            <div class="col-sm-12">
                                <h3 class="pull-left">${eqna.title }</h3>
                            </div>                                
                            <div class="col-sm-12">
                                <h4 class="pull-right">
                                <small>작성일 : ${fn:substring(eqna.wdate,0,10)}</small>
                                </h4>
                            </div>
                            <div class="col-sm-12">
                                <h4 class="pull-right">
                                <small>${eqna.user_name }</small>
                                </h4>
                            </div>
                        </div>
                        <hr style="margin-top: 0;    margin-bottom: 0.5em;    border-top-color: #ccc;">                        
                    </div>
                </div>
	            <div class="panel-body">
	                <span>${eqna.content }</span>
	            </div>
  			<div class="panel-footer">
  			<c:if test="${login.user_id eq eqna.user_id }">
                <span class="label label-default"><a href="./E_Qnaupdate.do?seq=${param.seq }&sub_seq=${param.sub_seq}">수정</a></span>
                <span class="label label-default"><a href="./E_Qnadelete.do?seq=${param.seq}&sub_seq=${param.sub_seq}&page=${param.page}">삭제</a></span>
            </c:if>
            	<span class="label label-default"><a href="./E_Qnareply.do?seq=${param.seq }&sub_seq=${param.sub_seq}&page=${param.page}">답변</a></span>
            </div>
        </div>
    </div>
     <div style="text-align: right; font-size: 20;">
	     <span><a href="./E_Qnalist.do?seq=${eqna.eclass_qna_bbs_seq }&sub_seq=${param.sub_seq}"><img src="${pageContext.request.contextPath}/img/list.png"></a></span>
     </div>
</section>



