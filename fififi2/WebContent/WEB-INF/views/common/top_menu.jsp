<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>  


<div class="bread_area">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<ol class="breadcrumb">
					<li><a href="#" title="Post">${doc_title }</a></li>
					<li class="active">${doc_title_sub }</li>
				</ol>
			</div>
		</div>
	</div>
</div>