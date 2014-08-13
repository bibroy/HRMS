<%-- 
    Document   : ViewRequestStatus
    Created on : Feb 10, 2011, 12:29:59 PM
    Author     : Sumit Kumar
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
        <title>HRMS :: View Request Status</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
        <link rel="stylesheet" href="../css/displaytagex1.css"/>
        <script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>

        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>

        <script type="text/javascript">

            function sendRequest(form)
            {
                form.method.value="saveRequest";
                if(!checkBlank(form.employeeid,'Employee Id'))
                {
                    return;
                }
                if(!checkBlank(form.facilityname,'Facility Name'))
                {
                    return;
                }

                if(!checkBlank(form.reason,'Reason'))
                {
                    return;
                }

                form.submit();
            }


        </script>

    </head>
    <body background="palegoldenrod">

        <jsp:include page="../include/header.jsp" />
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="8"></td>
                <td height="8"></td>
                <td height="8"></td>
            </tr>
            <tr>
                <td width="100%" colspan="3" align="left" valign="top"><img src="../images/banner.jpg" width="100%" height="138" /></td>
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

                                                        <table border="0" cellpadding="1" cellspacing="5" style="text-align: center;" width="600">
                                                            <tr>
                                                                <td style="font-weight: bold">
                                                                    <u>Loan Request Status:</u>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td nowrap="true">
                                                                    <display:table export="false" class="dataTable"  name="requestScope.loanlist" style="cellpadding:5; width=90%;" sort="list"  requestURI="requestFacility.do?method=getAllRequestStatus"  pagesize="5" >
                                                                        <display:column property="requestid" title="ReqId" sortable="true" />
                                                                        <display:column property="loanamount" title="Loan Amount" sortable="true" />
                                                                        <display:column property="noofinstallment" title="Installments"   />
                                                                        <display:column property="approvalstatus" title="Approval"  /> 
                                                                    </display:table>
                                                                </td>

                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    &nbsp;
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td style="font-weight:bold">
                                                                    <u>Leave Request Status:</u>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td nowrap="true">
                                                                    <display:table export="false" class="dataTable"  name="requestScope.leavelist" style="cellpadding:5; width=90%;" sort="list"  requestURI="requestFacility.do?method=getAllRequestStatus"  pagesize="5" >
                                                                        <display:column property="requestid" title="ReqId" sortable="true" />
                                                                        <display:column property="fromDate" title="From Date" sortable="true" />
                                                                        <display:column property="toDate" title="To Date" />
                                                                        <display:column property="noofdays" title="No of Days" />
                                                                        <display:column property="leavestatus" title="Status"/>
                                                                    </display:table>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    &nbsp;
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td style="font-weight:bold">
                                                                    <u>Advanced Salary Status:</u>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td nowrap="true">
                                                                    <display:table export="false" class="dataTable"  name="requestScope.advlist" style="cellpadding:5; width=90%;" sort="list"  requestURI="requestFacility.do?method=getAllRequestStatus"  pagesize="5" >
                                                                        <display:column property="requestid" title="ReqId" sortable="true" />
                                                                        <display:column property="appliedamount" title="Amount" sortable="true" />
                                                                        <display:column property="noofinstallment" title="Installments" />
                                                                        <display:column property="approvalstatus" title="Status" />
                                                                    </display:table>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    &nbsp;
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td style="font-weight: bold">
                                                                    <u>Airticket Request</u>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td nowrap="true">
                                                                    <display:table export="false" class="dataTable"  name="requestScope.airlist" style="cellpadding:5; width=90%;" sort="list"  requestURI="requestFacility.do?method=getAllRequestStatus"  pagesize="5" >
                                                                        <display:column property="requestid" title="ReqId" sortable="true" />
                                                                        <display:column property="airlineName" title="Airline" sortable="true" />
                                                                        <display:column property="destination" title="Destination" />
                                                                        <display:column property="departureDate" title="Departure Date" />
                                                                        <display:column property="approvalstatus" title="Status"/>
                                                                    </display:table>
                                                                </td>
                                                            </tr>
                                                              <tr>
                                                                <td>
                                                                    &nbsp;
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td style="font-weight: bold">
                                                                    <u>Conference Room Booking Request</u>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <display:table export="false" class="dataTable"  name="requestScope.conflist" style="cellpadding:5; width=90%;" sort="list"  requestURI="requestFacility.do?method=getAllRequestStatus"  pagesize="5" >
                                                                        <display:column property="conferenceroombookingcode" title="ReqId" sortable="true" />
                                                                        <display:column property="roomno" title="Room No" sortable="true" />
                                                                        <display:column property="fromtime" title="From Time" />
                                                                        <display:column property="totime" title="To Time" />
                                                                        <display:column property="status" title="Status"/>
                                                                    </display:table>
                                                                </td>
                                                            </tr>
                                                             <tr>
                                                                <td>
                                                                    &nbsp;
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td style="font-weight: bold">
                                                                    <u>Visa Request Status</u>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <display:table export="false" class="dataTable"  name="requestScope.visalist" style="cellpadding:5; width=90%;" sort="list"  requestURI="requestFacility.do?method=getAllRequestStatus"  pagesize="5" >
                                                                        <display:column property="id" title="ReqId" sortable="true" />
                                                                        <display:column property="visa" title="Visa" sortable="true" />
                                                                        <display:column property="noOfVisa" title="No of Visa" />
                                                                        <display:column property="status" title="Status"/>
                                                                    </display:table>
                                                                </td>
                                                            </tr>
                                                            
                                                        </table>


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
                <td width="16" align="left" valign="top" bgcolor="#FFFFFF"><img src="../images/body_left_bottom_round.jpg" width="16" height="14" /></td>
                <td bgcolor="#FFFFFF">&nbsp;</td>
                <td width="16" align="right" valign="top" bgcolor="#FFFFFF"><img src="../images/body_right_bottom_round.jpg" width="16" height="14" /></td>
            </tr>
        </table>
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="3"></td>
            </tr>
        </table>
        <jsp:include page="../include/footer.jsp" />
    </body>
</html:html>

