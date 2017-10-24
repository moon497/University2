<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<script type="text/javascript" src='${pageContext.request.contextPath }/js/NoticeBbsWrite.js' ></script>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/NoticeBbsWrite.css' />

<%
Calendar cal = Calendar.getInstance();

int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH);
int tday = cal.get(Calendar.DATE);
%>

<form action="./E_PdswriteAf.do" method="post" enctype="multipart/form-data">
 <input type="hidden" name="sub_seq" value="${param.sub_seq }"> 
  
<div class="col-md-9">
<div class="form-group"> <!-- userId field -->
		<label class="control-label " for="user_id">글쓴이</label>
		<input class="form-control" id="user_id" name="user_id" type="hidden" value="${login.user_id}" readonly="readonly"/>
		<input class="form-control" type="text" value="${login.user_name}" readonly="readonly"/>
</div>
<div class="form-group"> <!-- "title" field -->
		<label class="control-label " for="title">제목</label>
		<input class="form-control" id="title" name="title" type="text"/>
</div>
<div class="form-group"> <!-- "date" field -->
<label class="control-label " for="user_id">과제 기한</label>
		<select name="syear">
		<%
		for(int i=tyear; i<tyear+6; i++){
			%>
			<option <%=(tyear+"").equals(i+"")?"selected='selected'":""%> value="<%=i%>">
				<%=i %>
			</option>
			<%
		}
		%>
		</select>년
		<select name="smonth">
		<%
		for(int i=1; i<=12; i++){
			%>
			<option <%=(tmonth+1+"").equals(i+"")?"selected='selected'":""%> value="<%=i%>">
				<%=i %>
			</option>
			<%
		}
		%>
		</select>일
		<select name="sday">
		<%
		for(int i=tday; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
			%>
			<option <%=(tday+"").equals(i+"")?"selected='selected'":""%> value="<%=i%>">
				<%=i %>
			</option>
			<%
		}
		%>
		</select>일
		~
		<select name="eyear">
		<%
		for(int i=tyear; i<tyear+6; i++){
			%>
			<option <%=(tyear+"").equals(i+"")?"selected='selected'":""%> value="<%=i%>">
				<%=i %>
			</option>
			<%
		}
		%>
		</select>년
		<select name="emonth">
		<%
		for(int i=1; i<=12; i++){
			%>
			<option <%=(tmonth+1+"").equals(i+"")?"selected='selected'":""%> value="<%=i%>">
				<%=i %>
			</option>
			<%
		}
		%>
		</select>일
		<select name="eday">
		<%
		for(int i=tday; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
			%>
			<option <%=(tday+"").equals(i+"")?"selected='selected'":""%> value="<%=i%>">
				<%=i %>
			</option>
			<%
		}
		%>
		</select>일
</div>
<div class="form-group"> <!-- content field -->
		<label class="control-label " for="content">내용</label>
		<textarea class="form-control" cols="40" id="content" name="content" rows="10"></textarea>
</div>

<div class="form-group">
	   <input type="file" id="fileload" name="fileload" class="file" style="visibility: hidden; position: absolute;">
	<div class="input-group col-xs-12">
	     <span class="input-group-addon"><i class="fa fa-file"></i></span>
	     <input type="text" class="form-control input-lg" disabled placeholder="파일 업로드">
	     <span class="input-group-btn">
			<button class="browse btn btn-primary input-lg" type="button"><i class="glyphicon glyphicon-search"></i> 파일</button>
	     </span>
    </div>
</div> 
	<div class="form-group pull-right">
		<button class="btn btn-primary " name="submit" type="submit">공지추가</button>
	</div>
</div>
</form>

<script>
$(document).ready(function(){
	$("select[name='syear']").change(function(){
		var lastday = (new Date($("select[name='syear']").val() + "",
								$("select[name='smonth']").val() + "",0)).getDate();
		var str="";
		for(i=1; i<=lastday; i++){
			str+="<option value='" +i+ "'>" + i + "</option>";
		}
		$("select[name='sday']").html(str);
	});
	
	$("select[name='smonth']").change(function(){
		var lastday = (new Date($("select[name='syear']").val() + "",
				$("select[name='smonth']").val() + "",0)).getDate();
		var str="";
		for(i=1; i<=lastday; i++){
		str+="<option value='" +i+ "'>" + i + "</option>";
		}
		$("select[name='sday']").html(str);
	});	
	
	$("select[name='eyear']").change(function(){
		var lastday = (new Date($("select[name='eyear']").val() + "",
								$("select[name='emonth']").val() + "",0)).getDate();
		var str="";
		for(i=1; i<=lastday; i++){
			str+="<option value='" +i+ "'>" + i + "</option>";
		}
		$("select[name='eday']").html(str);
	});
	
	$("select[name='emonth']").change(function(){
		var lastday = (new Date($("select[name='eyear']").val() + "",
								$("select[name='emonth']").val() + "",0)).getDate();
		var str="";
		for(i=1; i<=lastday; i++){
		str+="<option value='" +i+ "'>" + i + "</option>";
		}
		$("select[name='eday']").html(str);
	});	
});
</script>