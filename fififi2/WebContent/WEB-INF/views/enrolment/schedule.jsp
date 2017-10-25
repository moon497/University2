<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<fmt:requestEncoding value="UTF-8"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<table class="table table-bordered table-hover">
<thead>
	<tr>
		<td>월</td><td>화</td><td>수</td><td>목</td><td>금</td>
	</tr>	
</thead>
<tbody>
	<%for(int i = 0; i < 10; i++){ %>
		<tr>
			<td></td>
		</tr>
	<%} %>
</tbody>
</table>