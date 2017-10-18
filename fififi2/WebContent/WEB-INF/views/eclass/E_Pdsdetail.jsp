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
                                <h3 class="pull-left">${epds.title }</h3>
                            </div>                                
                            <div class="col-sm-12">
                                <h4 class="pull-right">
                                <small>기한 : ${DateUtil.pollState(epds.edate)}${fn:substring(epds.sdate,0,10)} ~ ${fn:substring(epds.edate,0,10)}</small>
                                </h4>
                            </div>
                            <div class="col-sm-12">
                                <h4 class="pull-right">
                                <small>${epds.user_name }</small>
                                </h4>
                            </div>
                        </div>
                        <hr style="margin-top: 0;    margin-bottom: 0.5em;    border-top-color: #ccc;">
                        <c:if test="${epds.filename != '-1' }">
                        <div class="row" style="text-align: -webkit-auto;">
                        	<div class="col-sm-2">
                        		<span>첨부파일:</span>
                        	</div>
                        	<div class="col-sm-10">
                        		<span><a href="${pageContext.request.contextPath }/upload/${epds.filename}" download="${epds.org_filename }">${epds.org_filename }</a></span>
                        	</div>
                        </div>
                        </c:if>
                    </div>
                </div>
	            <div class="panel-body">
	                <span>${epds.content }</span>
	            </div>
  			<div class="panel-footer">
  			<c:if test="${login.user_id eq epds.user_id }">
                <span class="label label-default"><a href="./E_Pdsupdate.do?seq=${epds.eclass_pds_bbs_seq }&sub_seq=${param.sub_seq}">수정</a></span>
                <span class="label label-default"><a href="./E_Pdsdelete.do?seq=${epds.eclass_pds_bbs_seq }&sub_seq=${param.sub_seq}&page=${param.page}">삭제</a></span>
            </c:if>
            </div>
        </div>
    </div>
     <%@ include file="E_comment.jsp" %>
     <div style="text-align: right; font-size: 20;">
	     <span><a href="./E_Pdslist.do?seq=${epds.eclass_pds_bbs_seq }&sub_seq=${param.sub_seq}"><img src="${pageContext.request.contextPath}/img/list.png"></a></span>
     </div>
</section>



