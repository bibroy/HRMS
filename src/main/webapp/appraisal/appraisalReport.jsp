<%--
Document   : login.jsp
Created on : Dec 18, 2009, 12:20:55 AM
Author     : Swarnendu Mukherjee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html:html>
<html:base/>
 <head>
     <title></title>
     <script src="js/graphs.js"></script>
</head>
<body bgcolor="#FFE87C" >
  
    <script>
       var graph = new BAR_GRAPH("vBar");
graph.values = "<logic:present name="appraisalReport" scope="request"><logic:iterate id="itr" name="appraisalReport" indexId="no"> <bean:write  name="itr" property="score"/>+\% ,</logic:iterate></logic:present>";
graph.labels = "<logic:present name="appraisalReport" scope="request"><logic:iterate id="itr" name="appraisalReport" indexId="no"> <b><bean:write  name="itr" property="appraisal_date"/></b><br>,</logic:iterate></logic:present>";
graph.showValues = 1;
graph.barWidth = 20;
graph.barLength = 1;
graph.labelSize = 12;
graph.absValuesSize = 12;
graph.percValuesSize = 1;
graph.graphPadding = 10;
graph.graphBGColor = "goldenrod";
graph.graphBorder = "1px solid blue";
graph.barColors = "#800517";
graph.barBGColor = "	#FFE87C";
graph.barBorder = "2px orangered";
graph.labelColor = "#000000";
graph.labelBGColor = "#C0E0FF";
graph.labelBorder = "2px groove white";
graph.absValuesColor = "#000000";
graph.absValuesBGColor = "#FFFFFF";
graph.absValuesBorder = "2px  #FFFFFF";
document.write(graph.create()); 

    </script>
<br>
</body>
</html:html>
