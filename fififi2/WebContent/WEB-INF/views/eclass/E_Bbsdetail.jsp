<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<script src='{% static "js/jquery-1.11.1.min.js" %}'></script>
<script src="https://code.jquery.com/jquery-1.11.1.js"></script>
<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>

<form name="frmForm" id="_frmForm" method="post" action="E_Bbsupdate.do">
<input type="hidden" name="seq" value="${edto.eclass_notice_bbs_seq }">
<section class="category-content col-sm-9">
	<div id="postlist">        
        <div class="panel">
                <div class="panel-heading">
                    <div class="text-center">
                        <div class="row">
                            <div class="col-sm-9">
                                <h3 class="pull-left">${edto.title }</h3>
                            </div>                                
                            <div class="col-sm-3">
                                <h4 class="pull-right">
                                <small>${edto.wdate }</small>
                                </h4>
                            </div>
                            <div class="col-sm-1">
                                <h4 class="pull-right">
                                <small>${edto.user_id }</small>
                                </h4>
                            </div>
                        </div>
                        <hr style="margin-top: 0;    margin-bottom: 0.5em;    border-top-color: #ccc;">
                        <c:if test="${edto.filename != '-1' }">
                        <div class="row" style="text-align: -webkit-auto;">
                        	<div class="col-sm-2">
                        		<span>첨부파일:</span>
                        	</div>
                        	<div class="col-sm-10">
                        		<span><a href="${pageContext.request.contextPath }/upload/${edto.filename}" download="${edto.org_filename }">${edto.org_filename }</a></span>
                        	</div>
                        </div>
                        </c:if>
                    </div>
                </div>
	            <div class="panel-body">
	                <span>${edto.content }</span>
	            </div>
  			<div class="panel-footer">
                <span class="label label-default"><a href="./E_Bbsupdate.do?seq=${edto.eclass_notice_bbs_seq }">수정</a></span> <span class="label label-default"><a href="./delete.do?seq=${edto.eclass_notice_bbs_seq  }&page=${param.page}">삭제</a></span>
            </div>
        </div>
    </div>
</section>
</form>
<!-- 파일 다운로드 -->
<form name="delfileup" action="fileDownload.do" method="post">
	<input type="hidden" name="z" />
	<input type="hidden" name="filename" />
	<input type="hidden" name="org_filename" />
</form>

<script type="text/javascript">
function filedowns(filename,org_filename){
	alert("다운");
	var doc=document.delfileup;
	doc.filename.value=filename;
	doc.org_filename.value=org_filename;
	//doc.seq.value=seq;
	doc.submit();
}
$("#_btnUpdate").click(function() {	
	alert('글수정하기');		
	$("#_frmForm").attr({ "target":"_self", "action":"E_Bbsupdate.do" }).submit();
});
</script>



