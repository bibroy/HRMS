<%-- 
    Document   : DepartmentList
    Created on : Jan 31, 2011, 6:11:22 PM
    Author     : pranav kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <select name="department">
            <logic:present name="departmentlist" scope="request">
                <logic:iterate id="dept" name="departmentlist" scope="request">
                    <option value="${dept.departmentId}">${dept.departmentName}</option>
                </logic:iterate>
            </logic:present>
        </select>
    </body>
</html>
