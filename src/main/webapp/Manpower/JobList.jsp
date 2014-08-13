<%-- 
    Document   : JobList
    Created on : Feb 24, 2011, 1:28:06 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <select name="job" id="jobs" onchange="loadDesc(this)">
            <option value="">--Select--</option>
            <logic:present name="jobList" scope="request">
                <logic:iterate id="j" collection="${requestScope.jobList}">
                    <option value="${j.id}">${j.jobName}</option>
                </logic:iterate>
            </logic:present>
        </select>
    </body>
</html>
