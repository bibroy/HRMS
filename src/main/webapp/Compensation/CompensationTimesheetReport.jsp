<%--
    Document   : TimesheetApprove
    Created on : Dec 13, 2010, 12:33:10 PM
    Author     : pranav Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page buffer="256kb"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib  uri="http://displaytag.sf.net" prefix="display"%>


<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS ::Timesheet approve</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
        <link rel="stylesheet" href="../css/displaytagex.css"/>
        <script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="../js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>

        <script type="text/javascript">
            function load(form)
            {
                form.method.value="loadTimesheetDetail";
                if(!checkBlank(form.timesheetdate,'indicator'))
                {
                    return;
                }
                form.submit();

            }

        </script>

    </head>
    <style type="text/css"> h5{

            text-align: left;
            font-style: normal;
            font-size: 20pt;
            font-family: monospace;

        }
        th.label{
            color:white;
            text-align: left;
            font-style:normal;
            font-size:  small;

        }
        tr.odd{
            background-color: #FFD680;
        }

    </style>
    <body background="palegoldenrod">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="box" style="background-color: ghostwhite;">
            <tr>
                <td width="10" class="box_left_bg"><img src="../images/box_left_top_corner.jpg" width="10" height="10" /></td>
                <td class="box_top_bg">&nbsp;</td>
                <td width="11" align="right" valign="top" class="box_right_bg"><img src="../images/box_right_top_corner.jpg" width="11" height="10" /></td>
            </tr>
            <tr>
                <td class="box_left_bg">&nbsp;</td>
                <td align="center" valign="middle">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tr style="height: 200px;">
                            <td align="left" valign="top">

                                <%-- Main Page Content Starts Here --%>

                                <html:form action="/performancesheet.do">
                                    <table width="761" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td align="left" valign="top" colspan="3" ><div id="errorMsg" ></div>

                                                <logic:messagesPresent message="true">

                                                    <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                </logic:messagesPresent>
                                                <logic:messagesPresent >

                                                    <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                </logic:messagesPresent >
                                            </td>
                                        </tr>
                                        <tr>


                                            <td>
                                                <table width="70%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td width="31%" align="center" valign="middle" nowrap="nowrap">Date</td>
                                                        <td  align="right" valign="middle" nowrap="nowrap"><html:text property="timesheetdate" readonly="true"/><html:img onclick="javascript:popUpCalendar(this,document.forms[0].timesheetdate,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" /></td>
                                                        <td>&nbsp;&nbsp;
                                                            <html:button  value="show" property="button" onclick="load(this.form);" />
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">
                                                <logic:present name="detail" scope="request" >

                                                    <table border="0" width="100%" >
                                                        <tr style="background-color: goldenrod">
                                                            <th width="14.2%" class="label" nowrap="nowrap">EMPLOYEE ID</th>
                                                            <th width="14.2%" class="label">PROJECT ID</th>
                                                            <th width="15.2%" align="left" valign="middle" nowrap="nowrap" class="label">TIMESLOT</th>
                                                            <th width="14.2%" align="left" valign="middle" nowrap="nowrap" class="label">DESCRIPTION</th>
                                                            <th width="14.2%" align="left" valign="middle"  class="label">OVERTIME STATUS</th>
                                                            <th width="14.2%" align="left" valign="middle" nowrap="nowrap" class="label">STATUS</th>
                                                        </tr>
                                                        <logic:iterate id="candidate" name="detail" indexId="i">
                                                            <tr class="<c:if test='${(i%2)==0}'>even</c:if><c:if test='${(i%2)!=0}'>odd</c:if>">
                                                                <td >
                                                                    <bean:write name="candidate" property="empid" />
                                                                </td>
                                                                <td> <bean:write name="candidate" property="projectid" /></td>
                                                                <td align="left" valign="middle" nowrap="nowrap"> <bean:write name="candidate" property="timeslot" /></td>
                                                                <td  align="left" valign="middle" nowrap="nowrap"> <bean:write name="candidate" property="description" /></td>
                                                                <td  align="left" valign="middle" nowrap="nowrap"><bean:write name="candidate" property="overtimestatus" /></td>
                                                                <td align="left" valign="middle" nowrap="nowrap"><bean:write name="candidate" property="approvestatus"/>
                                                                </td>
                                                            </tr>
                                                        </logic:iterate>

                                                    </table>
                                                </logic:present>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td colspan="3">&nbsp; <br/></td>
                                        </tr>


                                    </table>
                                    <html:hidden property="method"/>
                                </html:form>


                                <%-- Main Page Content Ends Here --%>

                            </td>
                        </tr>
                    </table></td>
                <td class="box_right_bg">&nbsp;</td>
            </tr>
            <tr>
                <td align="left" valign="bottom" class="box_left_bg"><img src="../images/box_left_buttom_corner.jpg" width="10" height="12" /></td>
                <td class="box_buttom_bg">&nbsp;</td>
                <td align="right" valign="bottom" class="box_right_bg"><img src="../images/box_right_buttom_corner.jpg" width="11" height="12" /></td>
            </tr>
        </table>
    </body>
</html:html>

