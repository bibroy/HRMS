<%-- 
    Document   : SuccessionPlanning
    Created on : Jan 6, 2011, 10:45:37 AM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page buffer="256kb"%>
<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib  uri="http://displaytag.sf.net" prefix="display"%>

<%@page import="java.util.List" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
        --%>
        <link rel="stylesheet" href="../css/displaytagex.css"/>
        <title>Employee List</title>
    </head>
    <body>


        <display:table export="true" class="dataTable"  name="requestScope.emplist" style="cellpadding:5; width=600px;" sort="list"  requestURI="../succession.do?method=getEmployeeBySkill"  pagesize="10"  >


            <display:column property="employeid" title="Employee Id"  sortable="true" />
            <display:column property="skills" title="Skills" />
            <display:column property="proficiency" title="Proficiency" />


            <display:caption style="color:red; font-size:25px;">Suitable Employees</display:caption>
            <display:setProperty name="export.pdf.class" value="com.CHANGE.IT.export.NicePdfExport.java"/>
            <display:setProperty name="export.export name.include_header" value="true"/>
            <display:setProperty name="pdf.export.pdf.header" value="Candiate List"/>
            <display:setProperty name="export.pdf" value="true" />
            <display:setProperty name="export.excel" value="true" />
            <display:setProperty name="export.csv" value="true" />
            <display:setProperty name="export.xml" value="true" />

        </display:table>


   
    








</body>
</html>
