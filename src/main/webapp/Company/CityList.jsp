<%-- 
    Document   : CityList
    Created on : Jan 21, 2011, 12:20:11 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>
                    <select name="cityId" id="city" size="3">
                        <option value="">--Select City--</option>
                        <logic:present name="citylist" scope="request">
                            <logic:iterate id="city" collection="${requestScope.citylist}">
                                <option value="${city.cityId}">${city.cityName}</option>
                            </logic:iterate>
                        </logic:present>
                    </select>
                </td>
                <td>
                    Currency:
                </td>
                <td>
                    <input type="text" value="${requestScope.currency}" name="currency" readonly="true"/>
                </td>
            </tr>
        </table>
    </body>
</html>
