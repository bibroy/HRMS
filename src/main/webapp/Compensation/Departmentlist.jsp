<%-- 
    Document   : Departmentlist
    Created on : Feb 21, 2011, 5:19:52 PM
    Author     : computer1
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
        <table><tr><td>
                    <select name="department">
                        
                        <logic:present name="departmentlist" scope="request">
                            <option value="">..select please...</option>
                            <logic:iterate id="dept" name="departmentlist" scope="request">
                                <option value="${dept.departmentId}">${dept.departmentName}</option>
                            </logic:iterate>
                        </logic:present>
                    </select>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td> <select name="designation">
                        
                        <logic:present name="designationlist" scope="request">
                            <option value="">..select please..</option>
                            <logic:iterate id="des" name="designationlist" scope="request">
                                <option value="${des.designationId}">${des.designationName}</option>
                            </logic:iterate>
                        </logic:present>
                    </select>
                </td>
            </tr>
        </table>
    </body>
</html>