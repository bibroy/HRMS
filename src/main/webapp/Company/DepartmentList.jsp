<%-- 
    Document   : DepartmentList
    Created on : Jan 31, 2011, 10:54:38 AM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <select name="deptId" id="city" size="3">
            <option value="">--Select Department--</option>
            <logic:present name="deptList" scope="request">
                <logic:iterate id="dept" collection="${requestScope.deptList}">
                    <option value="${dept.departmentId}">${dept.departmentName}</option>
                </logic:iterate>
            </logic:present>
        </select>
    </body>
</html>
