<%-- 
    Document   : SuccessionPlanning
    Created on : Jan 6, 2011, 10:45:37 AM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page buffer="256kb"%>
<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib  uri="http://displaytag.sf.net" prefix="display"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HRMS ::Skill Report </title>
<link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
<link rel="stylesheet" href="../css/newstyle1.css" />
<link rel="stylesheet" href="../css/displaytagex.css"/>
<script type="text/javascript" src="../js/calender/viewCalendar.js"> </script>
<script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>
<script language="JavaScript" type="text/javascript">


    function SubmitKeyPosition(form){
        form.method.value="SuccesorSave";
        alert(form.method.value);
        form.submit();

    }



</script>

<%@page import="java.util.List" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
        --%>
        <link rel="stylesheet" href="../css/displaytagex.css"/>
        <title>Employee List</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <center><h3 style="background-color:  cornsilk;border-color:burlywood; width:500px; "> Employee skill submition page</h3></center>
        <br>
        <br>
        <br>
        <center>

            <html:form action="keypositionskill" >


                <hr/>

                <tr>
                    <td align="left" valign="top"><div id="errorMsg" ></div>

                        <logic:messagesPresent message="true">

                            <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                        </logic:messagesPresent>
                        <logic:messagesPresent >

                            <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                        </logic:messagesPresent >
                    </td>

                </tr>


                <table width="80%" border="1" cellspacing="4"   cellpadding="7" style="Background: cornsilk " >
                    <tr style="background-color: #ccffcc">
                        <th>
                            Employee ID
                        </th>
                        <th>
                            Skills
                        </th>

                        <th>
                            Proficiency
                        </th>

                        <th>
                            Select
                        </th>




                    </tr>
                    <logic:present name="emplistsuccession" >
                        <logic:iterate id="candidate" name="emplistsuccession" >
                            <tr>

                                <td><bean:write name="candidate" property="employeid" /></td>
                                <td><bean:write name="candidate" property="skills" /></td>
                                <td><bean:write name="candidate" property="proficiency" /></td>



                                <td><input type="checkbox" name="employee" onchange="" value="<bean:write name="candidate" property="employeid" />"/>Select
                                </td>

                            </tr>


                        </logic:iterate>
                    </logic:present>
                    <tr>
                        <td>Available type </td><td><html:select property="type">

                                <html:option value="">select

                                </html:option>


                                <html:option value="1">Ready now

                                </html:option>

                                <html:option value="2"> Ready after one Year

                                </html:option>

                            </html:select>
                        <td rowspan="2"><html:button property="button" value="Submit the details" onclick="SubmitKeyPosition(this.form)"/></td>

                    </tr>


                </table>
                <br>
                <br>
                <hr>


            </center>

                        <center><font style="background-color:  cornsilk;" size=3 ><a href="successionemp.do?method=getKeyPosition">View Key position details of employee</a></font></center>


            <html:hidden property="method"/>
            <html:hidden property="positionID" value="${requestScope.posid}"/>
        </html:form>

    </body>
</html>
