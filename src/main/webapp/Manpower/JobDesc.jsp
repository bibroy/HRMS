<%-- 
    Document   : JobDesc
    Created on : Feb 24, 2011, 3:42:49 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <logic:present name="jobDescription">
            <table width="100%" style="background-color: seashell ; border-left: thin solid #AD3333; border-top: thin solid #AD3333; border-right: thin solid #AD3333; border-bottom: thin solid #AD3333;" title="Job Description">
                <tr>
                    <td  valign="top" align="left" nowrap>
                        Job Description :
                    </td>
                    <td   colspan="3" nowrap>
                        <textarea name="jobDesc" cols="53" rows="3" readonly="true"><bean:write name="jobDescription" property="jobDesc"/></textarea>
                    </td>
                </tr>
                <tr>
                    <td width="190" align="left" nowrap>
                        Required Manpower :
                    </td>
                    <td nowrap>
                        <input type="text" value="<bean:write name="jobDescription" property="manpowerReq"/>" readonly="true"/>
                    </td>
                    <td align="left" nowrap>
                        Allocated Manpower :
                    </td>
                    <td nowrap>
                        <input type="text" value="<c:if test="${jobDescription.allocatedManpower==null}">0</c:if><c:if test="${jobDescription.allocatedManpower!=null}"><bean:write name="jobDescription" property="allocatedManpower"/></c:if>"  readonly="true"/>
                    </td>
                </tr>
            </table>
        </logic:present>
    </body>
</html>
