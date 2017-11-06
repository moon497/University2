<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int totalRecordCount;	// 전체 글수
	int pageNumber;			// 현재 페이지 번호
	int pageCountPerScreen;	// 스크린당 페이지수
	int recordCountPerPage;	// 페이지당 글수

	String st1 = request.getParameter("totalRecordCount");
	if(st1 == null)	totalRecordCount = 0;
	else			totalRecordCount = Integer.parseInt(st1);
	
	String st2 = request.getParameter("pageNumber");
	if(st2 == null) pageNumber = 0;
	else			pageNumber = Integer.parseInt(st2);
	
	String st3 = request.getParameter("pageCountPerScreen");
	if(st3 == null) pageCountPerScreen = 0;
	else			pageCountPerScreen = Integer.parseInt(st3);
	
	String st4 = request.getParameter("recordCountPerPage");
	if(st4 == null) recordCountPerPage = 0;
	else			recordCountPerPage = Integer.parseInt(st4);
	
	int totalPageCount = totalRecordCount / recordCountPerPage; // 페이지수
	//		1		=		12			/		10
	
	if((totalRecordCount % recordCountPerPage) != 0){
		totalPageCount++;	//  +1 	-> 총페이지는 2페이지
	}
	
	int screenStartPageIndex = ((pageNumber+1) / pageCountPerScreen) * pageCountPerScreen;
	//			0			=		0 + 1  			10						10	 

	int screenEndPageIndex = (((pageNumber+1) / pageCountPerScreen) * pageCountPerScreen) + pageCountPerScreen; 		
	//			10			=		0 + 1			10						10					10		
	// [1][2] ~ [10]
			
			
	if(screenEndPageIndex > totalPageCount){
		screenEndPageIndex = totalPageCount;	// 끝 페이지가 2가 된다 [1][2]
	}
	
	if (((pageNumber+1) % pageCountPerScreen) == 0){								
	    screenStartPageIndex = (((pageNumber+1) / pageCountPerScreen) * pageCountPerScreen) - pageCountPerScreen;
	    screenEndPageIndex = pageNumber+1;
	}
	

	
	
%>

 <div style="text-align: center;">
    <div class="pagination pagination-lg">
	<a href="#none" title="처음페이지" onclick="goPage('0')">
		<i class="fa fa-angle-double-left"></i>
	</a>&nbsp;

	<%
	// 이전 페이지
	if(screenStartPageIndex >= 1){
		%>	
		<a href="#none" title="이전페이지" onclick="goPage('<%=screenStartPageIndex-1 %>')">
			<i class="fa fa-angle-left"></i>
		</a>&nbsp;		
		<%
	}	
	%>
	
	<!-- 페이지 블록 [1][2].. -->
	<%
	for(int i = screenStartPageIndex;i < screenEndPageIndex; i++){
		if(i == pageNumber){	// 현재 페이지		[1] 2 [3] [4]
			%>
			<span style="font-size: 9pt; color: #000000; font-weight: bold;">
				<%=i+1 %>
			</span>
			<%			
		}else{					// 블록들
			%>
			<a href="#none" title="<%=i+1 %>페이지" onclick="goPage('<%=i %>')"
				style="font: 7.5pt; color: #000000; font-weight: normal;">
				[<%=i+1 %>]
			</a>		
			<%
		}		
	}	
	%>
	
	<%
	// 다음 페이지
	if(screenEndPageIndex <= totalPageCount){
		%>	
		<a href="#none" title="다음페이지" onclick="goPage('<%=screenEndPageIndex %>')">
			<i class="fa fa-angle-right"></i>
		</a>&nbsp;			
		<%
	}	
	int end_page = 0;
	if(totalPageCount > 0){
		end_page = totalPageCount - 1;
	}	
	%>
	
	<a href="#none" title="마지막페이지" onclick="goPage('<%=end_page %>')">
		<i class="fa fa-angle-double-right"></i>
	</a>


	</div>
</div>

<div style="float: left; width: 4%; text-align: center;">
	<span style="font-size: 1em; color: #000000">
		<%=pageNumber+1 %>/<%=totalPageCount %>
	</span>
</div>









