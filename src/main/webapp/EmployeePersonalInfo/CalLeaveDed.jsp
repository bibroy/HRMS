<%-- 
    Document   : CalLeaveDed
    Created on : Dec 14, 2010, 5:00:26 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculate Leave Deduction</title>
    </head>
    <body>
         <input type="text" name="leaveDed" value="<%=request.getAttribute("leaveDed")%>" size="18" readonly="true" id="leaveded"/>
    </body>
</html>
