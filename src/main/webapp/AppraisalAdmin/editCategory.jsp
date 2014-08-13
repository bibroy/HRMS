<%--
    Document   : addQuestions
    Created on : Oct 7, 2009, 3:06:42 AM
    Author     : Swarnendu Mukherjee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<script type="text/JavaScript">

    function edit(form){

        form.submit();
        window.close();

    }
    function calcel()
    {
        window.close();
    }

</script>


<html:html>
    <html:base/>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Appraisal Categories</title>
    </head>
    <body>
        <jsp:include page="include/header.jsp" />
        <a href="editCategory.jsp">Edit</a><br><br>
        <form action="editCategory.do" method="post">
            <table align="center" >
                <tr><td colspan="2">
                        <logic:present name="counter" scope="session">
                            <logic:iterate id="itr" name="counter" indexId="no">
                                <logic:present name="categorydetails${no}" scope="session">
                                    <logic:iterate id="qitr" name="categorydetails${no}" >
                                        <table align="center" cellpadding="0" cellspacing="0" >
                                            <tr bgcolor="goldenrod">
                                                <td colspan="3" align="center">
                                                    <font color="white"><b><bean:write  name="qitr" property="category_name"/></b></font>
                                                </td>
                                            </tr>
                                            <tr><td>
                                                    <table bgcolor="cornsilk" cellpadding="0" cellspacing="0" border="1">
                                                        <tr bgcolor="cornsilk"><td><b>Category Name</b></td>
                                                            <td>&nbsp;&nbsp;&nbsp;<input type="hidden" name="category_code" value="<bean:write  name="qitr" property="category_code"/>"</td>
                                                            <td><input type="text" name="category_name" value="<bean:write  name="qitr" property="category_name"/>"/></td></tr>
                                                        <tr bgcolor="cornsilk">
                                                            <td><b>Category Description</b></td>
                                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                                            <td><textarea name="category_description" cols="30"><bean:write  name="qitr" property="category_description"/></textarea></td>
                                                        </tr>
                                                    </table>
                                                </td>
                                            </tr>

                                        </table><br><br>
                                    </logic:iterate>
                                </logic:present>
                            </logic:iterate>
                        </logic:present>
                    </td></tr>
                <tr align="center">
                    <td><input type="button" value="Edit" onclick="edit(this.form)"/><input type="hidden" name="method" value="editAppraisalCategory"/>
                        <input type="button" value="Cancel" onclick="calcel()"/></td>
                </tr>
            </table>
        </form>
    </body>
</html:html>
