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
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />
        <link rel="stylesheet" href="css/displaytagex.css"/>
        <script type="text/javascript" src="js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="js/HRMS.js"></script>

        <script type="text/javascript">
            function load(form)
            {
                form.method.value="loadTimesheetDetail";
                form.submit();
            }
            function approve(form)
            {
                form.method.value="approveTimesheet";
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

        <jsp:include page="../include/header.jsp" />
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="8"></td>
                <td height="8"></td>
                <td height="8"></td>
            </tr>
            <tr>
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/timesheet.jpg" width="100%" height="138" /></td>
            </tr>
            <tr>
                <td height="3"></td>
                <td height="3"></td>
                <td height="3"></td>
            </tr>
        </table>
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="237" align="right" valign="top" bgcolor="#FFFFFF">
                    <br/>
                    <jsp:include page="../include/menu1.jsp"/>

                </td>
                <td align="left" valign="top" bgcolor="#FFFFFF"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td><table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
                                    <%--
                                <tr>
                                  <td width="141" align="left" valign="top"><a href="test_form1.jsp"><img src="images/tab1_button_roll.jpg" name="Image1" width="141" height="30" border="0" id="Image1" onmouseover="MM_swapImage('Image1','','images/tab1_button_roll.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                                  <td width="2" align="left" valign="top">&nbsp;</td>
                                  <td width="141"><a href="test_form2.jsp"><img src="images/tab2_button_nor.jpg" width="141" height="30" border="0" id="Image2" onmouseover="MM_swapImage('Image2','','images/tab2_button_roll.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                                  <td width="2" align="left" valign="top">&nbsp;</td>
                                  <td width="187"><a href="test_form3.jsp"><img src="images/tab3_button_nor.jpg" width="187" height="30" border="0" id="Image3" onmouseover="MM_swapImage('Image3','','images/tab3_button_roll.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                                  <td width="2">&nbsp;</td>
                                  <td width="141" align="left" valign="top"><a href="test_form4.jsp"><img src="images/tab4_button_nor.jpg" width="141" height="30" border="0" id="Image4" onmouseover="MM_swapImage('Image4','','images/tab4_button_roll.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                                  <td>&nbsp;</td>
                                </tr>
                                    --%>
                                </table></td>
                        </tr>
                        <tr>
                            <td>
                                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="box">
                                    <tr>
                                        <td width="10" class="box_left_bg"><img src="images/box_left_top_corner.jpg" width="10" height="10" /></td>
                                        <td class="box_top_bg">&nbsp;</td>
                                        <td width="11" align="right" valign="top" class="box_right_bg"><img src="images/box_right_top_corner.jpg" width="11" height="10" /></td>
                                    </tr>
                                    <tr>
                                        <td class="box_left_bg">&nbsp;</td>
                                        <td align="center" valign="middle">
                                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                                <tr style="height: 200px;">
                                                    <td align="left" valign="top">

                                                        <%-- Main Page Content Starts Here --%>

                                                        <html:form action="/timesheet2.do">
                                                            <table width="761" border="0" cellspacing="0" cellpadding="0">
                                                                <tr>
                                                                    <td align="left" valign="top" colspan="3" ><div id="errorMsg" ></div>

                                                                        <logic:messagesPresent message="true">

                                                                            <font color="green"> <b><img src="images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                        </logic:messagesPresent>
                                                                        <logic:messagesPresent >

                                                                            <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                        </logic:messagesPresent >
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="31%" align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Candidate Id: </td>
                                                                    <td  align="left" valign="middle">
                                                                        <html:select property="employeeId">
                                                                            <html:option value="">--Select Please--</html:option>
                                                                            <logic:present name="employee" scope="request">
                                                                                <html:options collection="employee" labelProperty="employeeId" property="employeeId" />
                                                                            </logic:present>
                                                                        </html:select>
                                                                    </td>
                                                                    <td>
                                                                        <table width="70%" border="0" cellspacing="0" cellpadding="0">
                                                                            <tr>
                                                                                <td width="31%" align="center" valign="middle" nowrap="nowrap">Date</td>
                                                                                <td  align="right" valign="middle" nowrap="nowrap"><html:text property="timesheetdate" readonly="true"/><html:img onclick="javascript:popUpCalendar(this,document.forms[0].timesheetdate,'dd/mm/yyyy')" src="images/tlsCalendarIcon.gif" /></td>
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
                                                                                    <th width="20px" align="left" valign="middle" nowrap="nowrap" class="label">TIMESLOT</th>

                                                                                    <th width="14.2%" align="left" valign="middle" nowrap="nowrap" class="label">DESCRIPTION</th>
                                                                                    <th width="14.2%" align="left" valign="middle"  class="label">OVERTIME STATUS</th>
                                                                                    <th width="14.2%" align="left" valign="middle" nowrap="nowrap" class="label">APPROVE</th>
                                                                                    <th width="14.2%" align="left" valign="middle" nowrap="nowrap" class="label">REASON</th>


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
                                                                                        <td><input type="checkbox" name="checked" value="<bean:write name="candidate" property="timesheetdetailid"/>"
                                                                                        </td>
                                                                                        <td><input type="text" name="reason"/>
                                                                                        </td>

                                                                                    </tr>


                                                                                </logic:iterate>



                                                                                <tr>
                                                                                    <td><html:button  value="Approve" property="button" onclick="approve(this.form);" />&nbsp;&nbsp;&nbsp;
                                                                                    <td colspan="6"></td>

                                                                                </tr>
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
                                        <td align="left" valign="bottom" class="box_left_bg"><img src="images/box_left_buttom_corner.jpg" width="10" height="12" /></td>
                                        <td class="box_buttom_bg">&nbsp;</td>
                                        <td align="right" valign="bottom" class="box_right_bg"><img src="images/box_right_buttom_corner.jpg" width="11" height="12" /></td>
                                    </tr>
                                </table></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                    </table></td>
            </tr>
        </table>
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="16" align="left" valign="top" bgcolor="#FFFFFF"><img src="images/body_left_bottom_round.jpg" width="16" height="14" /></td>
                <td bgcolor="#FFFFFF">&nbsp;</td>
                <td width="16" align="right" valign="top" bgcolor="#FFFFFF"><img src="images/body_right_bottom_round.jpg" width="16" height="14" /></td>
            </tr>
        </table>
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="3"></td>
            </tr>
        </table>
        <jsp:include page="../include/footer.jsp" />
        <script type="text/javascript">
        $(function() {
        	//loadAccordions();
	        	$( "#accrdins" ).accordion({
	        		collapsible: true,
	        		active: 2
	        	});
        	});

        </script>
    </body>
</html:html>

