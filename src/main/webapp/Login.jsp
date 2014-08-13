<%-- 
    Document   : Login
    Created on : Oct 23, 2010, 2:18:18 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS::Login Page</title>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        
        <script>
            function login(form)
            {
                form.method.value="hrmsLogin";
                form.submit();
            }
        </script>
    </head>
    <body>
        <table border="0" cellpadding="0" cellspacing="0">
            <tbody>
                <tr>
                    
                    <td colspan="2">
                        <jsp:include page="common/header.jsp"/>
                    </td>
                </tr>

                <tr>
                    <td colspan="2" class="login_top">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="heading">
                        Human Resources Management System
                    </td>
                </tr>
                <tr>
                    <td class="page_right" align="center" colspan="2">

                        <!--page content starts here-->

                        <%--    <fieldset style="border-left-style: solid; width: 250px; color: #AD3333; text-align: left; position: inherit " > --%>
                        <br/>
                        <table id="content"  border="0" cellspacing="0" cellpadding="0" style="background-color: #eff669"  align="center">
                            <tr>
                                <td colspan="2" class="label_head" nowrap="true">
                                    Please identify yourself : <br/><br/>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 250px">

                                    <form action="login.do" method="post">

                                        <table width="100%" border="0" cellspacing="5" cellpadding="0">
                                            <tr>
                                                <td width="129" class="label">Login Id</td>
                                                <td><input type="text" name="user_id" id="txtfield" class="txtfield" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td width="129" class="label">Password</td>
                                                <td><input type="password" name="password" id="pass" border="0" class="txtfield" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td>&nbsp;<input type="hidden" name="method" value="hrmsLogin"/></td>
                                                <td><input type="image" src="images/login_btn.jpg" border="0" onclick="login()"/></td>
                                            </tr>
                                        </table>
                                    </form>
                                </td>
                            </tr>
                            <tr align="center">
                                <td  colspan="2">
                                    <logic:messagesPresent message="true">

                                        <font color="red"> <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></font>

                                    </logic:messagesPresent>
                                    
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center" colspan="2"><a href="#"><strong>Forget Password?</strong></a></td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                            </tr>
                        </table>

                        <%--     </fieldset> --%>
                        <!--page content ends here-->

                    </td>
                </tr>
                <tr>
                    <td colspan="2" >
                        <img src="images/login_bottom.gif" width="963"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <br/>
                        <jsp:include page="common/footer.jsp"/>
                    </td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
