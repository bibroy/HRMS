<%-- 
    Document   : statistics
    Created on : Sep 3, 2009, 6:53:45 AM
    Author     : swarnendum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.applet.*"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <center>
    <APPLET CODE="Pie3D.class" WIDTH=500 HEIGHT=300>

<PARAM name="title" value="Performence Comparision">
<PARAM name="aspect_fudge" value="1.5">
<PARAM name="transparency" value=".8">

<PARAM name="show_values_on_slices">
<PARAM name="show_percents_on_legend">
<PARAM name="show_legend_on_right">

<PARAM name="val_1" value="60">
<PARAM name="description_1" value="Knowladge Appraisal">

<PARAM name="val_2" value="50">
<PARAM name="description_2" value="Performence Appraisal">


<PARAM name="val_3" value="80">
<PARAM name="description_3" value="Self Appraisal">

<PARAM name="val_4" value="10">
<PARAM name="description_4" value="Skill Test">
<PARAM name="val_5" value="10">
<PARAM name="description_5" value="Attendance">
<PARAM name="val_6" value="10">
<PARAM name="description_6" value="Puntuality">
</APPLET>

        <table border="1" width="500" ><tr><td><b>Employee Name:</b></td><td>&nbsp</td><td>Sudip Biswas</td></tr>
        <tr><td><b>Designation:</b></td><td>&nbsp</td><td>Software developer</td></tr>
        <tr><td><b>Company:</b></td><td>&nbsp</td><td>Orbit Web solutions</td></tr>
        <tr><td><b>Department:</b></td><td>&nbsp</td><td>Development</td></tr>
        <tr><td><b>Appraiser:</b></td><td>&nbsp</td><td>Krishnasish Banerjee</td></tr>
        <tr><td><b>Overall Score:</b></td><td>&nbsp</td><td>A++</td></tr>

        </table>
        </center>
    </body>
</html>
