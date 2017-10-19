<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/> 

<!-- body -->
	<div id="postlist">        
        <div class="panel">
                <div class="panel-heading">
                    <div class="text-center">
                        <div class="row">
                            <div class="col-sm-9">
                                <h3 class="pull-left"><span  style="    color: tomato;">[${good.category }]</span> <span  style="    color: #222;">${good.title }</span></h3>
                            </div>
                            <div class="col-sm-3">
                                <h4 class="pull-right">
                                <small><em>${fn:substring(good.wdate,0,10) }</em></small>
                                </h4>
                            </div>
                        </div>
                        <div class="row" style="text-align: -webkit-auto;">
                        	<div class="col-sm-12">
                        		<h2  style="color: crimson;    display: -webkit-inline-box;">[${good.status }]</h2>
                        	    <h2 style="color: black;    display: -webkit-inline-box;">${good.price } 원</h2>
                        	</div>
                        </div>
                        <hr style="margin-top: 0;    margin-bottom: 0.5em;    border-top-color: #ccc;">
                        <div class="row" style="text-align: -webkit-auto;">
                        	<div class="col-sm-3">
                        	    <span style="color: black;">${good.userName }</span>
                        	</div>
                        	<div class="col-sm-5">
                        	    <span style="color: black;">${good.address }</span>
                        	</div>
                        	<div class="col-sm-2">
                        	    <span style="color: black;">${good.phone }</span>
                        	</div>
                        	<div class="col-sm-2">
                        	    <span style="color: black;">${fn:substring(good.wdate,0,10) }</span>
                        	</div>
                        </div>
                        <hr style="margin-top: 0;    margin-bottom: 0.5em;    border-top-color: #ccc;">
                    </div>
                </div>
            <div class="panel-body">
                <span>${good.content }</span>
            </div>
          <div class="panel-footer">
				<button type="button" class="btn btn-info btn-xs" onclick="location.href='list.do'">돌아가기</button>
               
               <c:if test="${login.user_id == good.userId || login.user_auth == 300 }">
               <div style="    float: right;    padding-right: 1em;">
                <button type="button" class="btn btn-danger btn-xs" onclick="location.href='./delete.do?seq=${good.seq }'">삭제</button>
               </div>
               </c:if> 
          </div>
        </div>
    </div>