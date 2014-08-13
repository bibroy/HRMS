<%-- 
    Document   : EmpProjDesc
    Created on : Feb 26, 2011, 12:33:51 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <logic:messagesPresent>

            <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

        </logic:messagesPresent>
        <logic:present name="empdetail" scope="request">
            <table style="background-color: seashell ; border-left: thin solid #AD3333; border-top: thin solid #AD3333; border-right: thin solid #AD3333; border-bottom: thin solid #AD3333;" title="Employee's Currenct Allocation Details">
                <tr>
                    <td width="190">
                        Project Name :
                    </td>
                    <td>
                        <input type="text" value="${requestScope.empdetail.project.projectName}" readonly="true"/>
                    </td>
                    <td width="150"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>
                        Job Name :
                    </td>
                    <td>
                        <input type="text" value="${requestScope.empdetail.job.jobName}" readonly="true"/>
                    </td>
                    <td align="right">Allocation Date :</td>
                    <td>
                        <input type="text" value="${requestScope.empdetail.allocationDate}" readonly="true"/>
                    </td>
                </tr>
            </table>
        </logic:present>
    </body>
</html>
