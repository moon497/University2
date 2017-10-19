<%@page import="kh.com.model.AssessmentDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script> <!-- jquery 동작하기 위해서 필요 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
List<AssessmentDto> list = (List<AssessmentDto>)request.getAttribute("list");
int A = 0;
int B = 0;
int C = 0;
int D = 0;
int F = 0;
String A_charts="";
String B_charts="";
String C_charts="";
String D_charts="";
String F_charts="";

	for(int i =0; i< list.size(); i++){
		
		int score = list.get(i).getStudent_score();

		if(score>=90){
				A ++;
				A_charts +="[ '"+ list.get(i).getStudent_name() +"',"  + list.get(i).getStudent_score() +"], ";
				
		}else if(90>score && score>=80){
				B ++;
				B_charts +="[ '"+ list.get(i).getStudent_name() +"',"  + list.get(i).getStudent_score() +"], ";
				
		}else if(80>score && score>=70){
				C ++;
				C_charts +="[ '"+ list.get(i).getStudent_name() +"',"  + list.get(i).getStudent_score() +"], ";
		}else if(70>score && score>=60){
				D ++;
				D_charts +="[ '"+ list.get(i).getStudent_name() +"',"  + list.get(i).getStudent_score() +"], ";
		}else{
				F ++;
				F_charts +="[ '"+ list.get(i).getStudent_name() +"',"  + list.get(i).getStudent_score() +"], ";
		}

	}
	System.out.println(A + B + C + D +F);
%>


<script type="text/javascript">
//Create the chart
Highcharts.chart('container', {
    chart: {
        type: 'column' },
    title: {
        text: 'Student grades in 2017, first semester'
    },
    subtitle: {
        text: '차트 클릭시 점수별 상세 리스트를 볼 수 있습니다.'
    },
    xAxis: {
        type: 'category'
    },
    yAxis: {
        title: {
            text: 'grade'
        }

    },
    legend: {
        enabled: false
    },
    plotOptions: {
        series: {
            borderWidth: 0,
            dataLabels: {
                enabled: true,
                format: '{point.y:.1f}'
            }
        }
    },

    tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.0f}</b>명<br/>'
    },

    series: [{
        name: '전체 성적',
        colorByPoint: true,
        data: [{
            name: 'A',
            y: <%=A%>,
            drilldown: 'A'
        }, {
            name: 'B',
            y: <%=B%>,
            drilldown: 'B'
        }, {
            name: 'C',
            y: <%=C%>,
            drilldown: 'C'
        }, {
            name: 'D',
            y: <%=D%>,
            drilldown: 'D'
        }, {
            name: 'F',
            y: <%=F%>,
            drilldown: 'F'
        }]
    }],
    drilldown: {
        series: [{
            name: 'A',
            id: 'A',
            data: [ <%=A_charts%> ]
        }, {
            name: 'B',
            id: 'B',
            data: [ <%=B_charts%> ]
        }, {
            name: 'C',
            id: 'C',
            data: [ <%=C_charts%> ]
        }, {
            name: 'D',
            id: 'D',
            data: [ <%=D_charts%>]
        }, {
            name: 'F',
            id: 'F',
            data: [ <%=F_charts%> ]
        }]
    }
});
</script>





</body>
</html>