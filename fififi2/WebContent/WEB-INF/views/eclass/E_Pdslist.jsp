<%@page import="java.util.ArrayList"%>
<%@page import="kh.com.util.DateUtil"%>
<%@page import="kh.com.model.E_PdsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src='{% static "js/jquery-1.11.3.min.js" %}'></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<fmt:requestEncoding value="utf-8"/>
<style>
.th{
	text-align: center;
	}
</style>

<%
List<E_PdsDto> epds_list = new ArrayList<E_PdsDto>();
Object oflist = request.getAttribute("epdslist");
if(oflist != null){
	epds_list = (List<E_PdsDto>)oflist;
}
%>


<table border="1" style="text-align: center; width:95%;">
<col width="50" /><col width="50" /><col width="200" />
<col width="100" /><col width="100" /><col width="100" />
<tr>
	<th class="th">번호</th><th class="th">아이디</th><th class="th">제목</th>
	<th class="th">시작일</th><th class="th">끝나는 날</th><th class="th">등록일</th>
</tr>
<%
if(epds_list == null || epds_list.size() == 0){
	%>
	<tr>
		<td colspan="5">작성된 글이 없습니다</td>
	</tr>
<%}%>
<%
for(int i=0; i<epds_list.size(); i++){ 
	E_PdsDto epds = epds_list.get(i);
	%>
	<tr bgcolor="#aabbcc">
		<td><%=i+1 %></td>
		<td><%=epds.getUser_id() %></td>
		<td><%=epds.getTitle() %></td>
		<td><%=epds.getSdate() %></td>
		<td><%=DateUtil.pollState(epds.getEdate()) %><%=epds.getEdate() %></td>
		<td><%=epds.getWdate() %></td>
	</tr>
	<%
}
%>

</table>

<!-- 글 쓰기 -->
<form name="PfrmForm" id="_PfrmForm" method="get" action=""></form>

<div>
	<span>
		<button type="button" onclick="btnAdd()">글쓰기</button>
	</span>
</div>

<script>
function filedowns(filename, seq) {
	var doc = document.delfileup;
	doc.filename.value = filename;
	doc.seq.value = seq;
	doc.submit();
	$("#down_count"+seq).text(Number($("#down_count"+seq).text())+1);
}

function btnAdd() {
	alert("글쓰기");
	$("#_PfrmForm").attr({"target":"_self", "action":"E_Pdswrite.do"}).submit();	
}
</script>
