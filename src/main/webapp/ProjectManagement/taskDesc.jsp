<%-- 
    Document   : taskDesc
    Created on : Dec 15, 2010, 6:53:37 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task Description</title>
    </head>
    <body>
        <input type="text" style="height: 30px;" name="taskDesc" value="<%=request.getAttribute("tsk")%>" size="25" readonly="true" id="desc"/>
    </body>
</html>
