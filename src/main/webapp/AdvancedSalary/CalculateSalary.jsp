<%--

----------------------------
    Document   : CalculateSalary
    Created on : Nov 16, 2010, 1:00:10 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculate Salary</title>
    </head>
    <body>
       <input type="text" name="totalSal" value="<%=request.getAttribute("totalSalary")%>" size="18" readonly="true" id="sal"/>
    </body>
</html>
