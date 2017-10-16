<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:requestEncoding value="UTF-8"/>
<form name="frmForm" id="_frmForm" action="./E_BbsupdateAf.do" method="post" 
enctype="multipart/form-data">
<input type="hidden" name="eclass_notice_bbs_seq" value="${edto.eclass_notice_bbs_seq }" />
<table class="list_table" style="width:85%;">
<colgroup>
<col style="width:200px;" />
<col style="width:auto;" />
</colgroup>
<tr>
<th>아이디</th>
<td style="text-align: left"><input type="text" name='user_id' readonly="readonly"
value="${login.user_id}" size="50"/></td>
</tr>
<tr>
<th>제목</th>
<td style="text-align: left"><input type="text" name='title' size="50" value="${edto.title }"/></td>
</tr>
<tr>
<th>파일업로드</th>
<td style="text-align: left"><input type="file" name="fileload" style=" width : 400px;"></td>
</tr>
<tr>
<th>내용</th>
<td style="text-align: left"><textarea rows="10" cols="50" name='content' id="_content">${edto.content }</textarea></td>
</tr>
<tr>
<td colspan="2" style="height:50px; text-align:center;">
	<input type="submit" value="전송">
	<span><a href="#none" id="_btnUpdate" title="글수정"><img src="image/bupdate.png" alt="글수정" /></a>
</span>
</td>
</tr>
</table>
</form>
<script type="text/javascript">
$("#_btnUpdate").click(function() {	
	$("#_frmForm").submit();
});

</script>