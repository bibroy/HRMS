<%--
Document   : login.jsp
Created on : Feb 17, 2009, 12:20:55 AM
Author     : pranav kumar
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
        <script type="text/javascript" src="js/graphs.js"></script>
    </head>
    <body bgcolor="palegoldenrod" >
       
        <script>
            var graph = new BAR_GRAPH("vBar");
            graph.values = "<logic:present name="attendanceutil" scope="request"><logic:iterate id="itr" name="attendanceutil" indexId="no"> <bean:write  name="itr" property="regularHrs"/>,</logic:iterate></logic:present>";
            graph.labels = "<logic:present name="attendanceutil" scope="request"><logic:iterate id="itr" name="attendanceutil" indexId="no"><bean:write  name="itr" property="month"/>,</logic:iterate></logic:present>";
            graph.showValues = 1;
            graph.barWidth = 20;
            graph.barLength = 1;
            graph.labelSize = 12;
            graph.absValuesSize = 12;
            graph.percValuesSize = 12;
            graph.graphPadding = 10;
            graph.graphBGColor = "goldenrod";
            graph.graphBorder = "1px solid blue";
            graph.barColors = "#800517";
            graph.barBGColor = "#FFE87C";
            graph.barBorder = "2px orangered";
            graph.labelColor = "#000000";
            graph.labelBGColor = "#C0E0FF";
            graph.labelBorder = "2px groove white";
            graph.absValuesColor = "#000000";
            graph.absValuesBGColor = "#FFFFFF";
            graph.absValuesBorder = "2px  #FFFFFF";
            document.write(graph.create());

        </script>
            <br/>
        <logic:present name="attendanceutil" scope="request">
            <logic:iterate id="itr" name="attendanceutil" indexId="no">

                     <APPLET CODE="Pie3D.class" WIDTH=400 HEIGHT=200>
                    <PARAM name="title" value="Attendance record of  <bean:write  name="itr" property="empName"/>">">
                    <PARAM name="aspect_fudge" value="1.5">
                    <PARAM name="transparency" value=".3">
                    <PARAM name="show_values_on_slices">
                    <PARAM name="show_percents_on_legend">
                    <PARAM name="show_legend_on_right">

                    <PARAM name="val_1" value="<bean:write  name="itr" property="regularHrs"/>">
                    <PARAM name="description_1" value="Total Working Hour">

                    <PARAM name="val_2" value="<bean:write  name="itr" property="absent"/>">
                    <PARAM name="description_2" value="Absent">

                    </APPLET>
                    
                    <table style="background-color: #FFEECA" border="1" width="400" >

                        <tr><td><b>Regular Working Hour :</b></td><td><bean:write  name="itr" property="regularHrs"/></td></tr>
                        <tr><td><b>Total Absent:</b></td><td><bean:write  name="itr" property="absent"/></td></tr>
                        <tr><td><b>Month:</b></td><td><bean:write  name="itr" property="month"/></td></tr>

                    </table>
                        <br/>
                
            </logic:iterate>
        </logic:present>
    </body>
</html:html>
