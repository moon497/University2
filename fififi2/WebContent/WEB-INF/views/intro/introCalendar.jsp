<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="kh.com.util.CalendarUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kh.com.model.IntroCalendarDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/dncalendar-skin.css" />
<link rel="stylesheet" type="text/css" href="css/dncalendar-skin.min.css">
</head>
<body>
<%

//오늘 날짜 구하기 
Date d = new Date();
SimpleDateFormat ctoday = new SimpleDateFormat("yyyy-MM-dd");
String today = ctoday.format(d);

//일정 불러오기
List<IntroCalendarDto> list=new ArrayList<IntroCalendarDto>();
Object Oflist=request.getAttribute("flist");
if(Oflist!=null){
	list=(List<IntroCalendarDto>)Oflist;
}

//불러온 일정 루프 돌려서 모두 note에 담아주기 
String note ="";
for(int i =0; i < list.size() ; i++){
	
	String ryear = list.get(i).getRdate().substring(0,4);
	String rmonth = list.get(i).getRdate().substring(4,6);
	String rday = list.get(i).getRdate().substring(6,8);
	String ralldate = ryear + "-" + rmonth + "-" +rday ;
	
	note += " { 'date' : '"+  ralldate +"', 'note' : [' "  + list.get(i).getTitle() +"' ] }, ";
}
note = note.substring(0, note.lastIndexOf(","));
%>
	
<section class="category-content col-sm-9">
    <h2 class="category-title">학사일정</h2>
    
		<div id="dncalendar-container">
		</div>
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="js/dncalendar.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			var my_calendar = $("#dncalendar-container").dnCalendar({
				minDate: "2016-01-01",
				maxDate: "2018-12-31",
				defaultDate: "<%=today%>",
				monthNames: [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ], 
				monthNamesShort: [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
				dayNames: [ '일', '월', '화', '수', '목', '금', '토'],
                dayNamesShort: [ '일', '월', '화', '수', '목', '금', '토'],
                dataTitles: { defaultDate: '오늘', today : '일정' },
                notes: [
                		  <%=note%> 
            		],
                showNotes: true,
                startWeek: 'monday',
                dayClick: function(date, view) {
                }
			});

			// init calendar
			my_calendar.build();

			// update calendar
			// my_calendar.update({
			// 	minDate: "2016-01-05",
			// 	defaultDate: "2016-05-04"
			// });
		});
		</script>
		</section>
	
	



</body>
</html>