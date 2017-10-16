<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:requestEncoding value="UTF-8"/>
<script src='{% static "js/jquery-1.11.1.min.js" %}'></script>
<script src="https://code.jquery.com/jquery-1.11.1.js"></script>
<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>

<%
Calendar cal = Calendar.getInstance();

int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH);
int tday = cal.get(Calendar.DATE);
%>
<form action="E_PdswriteAf.do" method="post" enctype="multipart/form-data" id="_frmForm" name="frmForm">
<table class="list_table" style="width:85%">
<col style="width:200px" />
<col style="width:500px" />


<tr>
<th>아이디</th>
<td style="text-align: left"><input type="text" name='user_id' readonly="readonly"
size="50" value="김종희"/></td>
</tr>
<tr>
	<th>과제 기한</th>
	<td style="text-align: left;">
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
		for(int i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
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
		for(int i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
			%>
			<option <%=(tday+"").equals(i+"")?"selected='selected'":""%> value="<%=i%>">
				<%=i %>
			</option>
			<%
		}
		%>
		</select>일
	</td>
</tr>
<tr>
<th>제목</th>
<td style="text-align: left"><input type="text" name='title' size="50"/></td>
</tr>
<tr>
<th>내용</th>
<td style="text-align: left"><textarea rows="10" cols="50" name='content' id="_content"></textarea></td>
</tr>
<tr>
<th>파일업로드</th>
<td style="text-align: left"><input type="file" name="fileload" style=" width : 400px;"></td>
</tr>
<tr>

<tr align="center">
	<td colspan="2">
		<input type="submit" value="과제 등록"/>
	</td>
</tr>
</table>
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
/*  function pollchange(me){
	var num = me.options[me.selectedIndex].value;
	for(i=1; i<=10; i++){
		$("#poll"+i).val("");
		$("#poll"+i).hide();
	}
	for(i=1; i<=num; i++){
		$("#poll"+i).show();
	}
} */
</script>