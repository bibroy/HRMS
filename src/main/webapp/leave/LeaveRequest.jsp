<%-- 
    Document   : LeaveRequest
    Created on : Nov 12, 2010, 4:36:13 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS::Leave Request</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
        <script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="../js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>
        <script type="text/javascript">
            function addLeave(form){

                form.method.value="applyLeave";

                //validation

                if(!checkBlank(form.empId,'Employee Id'))
                {

                    return;

                }

                if(!checkOption(form.leavetype,'Leave Type'))
                {
                    
                    return;

                }

                if(!checkBlank(form.reason,'Reason'))
                {
                    return;

                }

                if(!checkBlank(form.fromDt,'From Date'))
                {
                    return;

                }

                if(!checkBlank(form.toDt,'To Date'))
                {
                    return;

                }
                if(!checkBlank(form.noOfDays,'No Of Days'))
                {
                    return;

                }
                if(!checkBlank(form.leaveAddress,'Address On Leave'))
                {
                    return;

                }
                if(!checkEmail(form.email,'Email'))
                {
                    return;

                }
                if(!checkBlank(form.email,'Email'))
                {
                    return;

                }

                if(!checkBlank(form.leaveContactNo,'Mobile No'))
                {
                    return;

                }
                if(!checkPhnNo(form.leaveContactNo,'Mobile No'))
                {
                    return;

                }

                if(!checkBlank(form.noOfDays,'No Of Days'))
                {
                    return;

                }
                if(!checkBlank(form.day,'Day'))
                {
                    return;

                }

                form.submit();

            }

            function dateDifference(form){


                var frm_date=document.forms[0].fromDt.value;
                var to_date=document.forms[0].toDt.value;



                frm_date=frm_date.split("/");
                frm_date=frm_date[2]+frm_date[1]+frm_date[0];
                to_date=to_date.split("/");
                to_date=to_date[2]+to_date[1]+to_date[0];




                if (frm_date > to_date)
                {
                    alert("Start date cannot be greater than Due date");
                    document.forms[0].toDt.value=null;
                    return false;
                }
                var vDateSplit = document.forms[0].fromDt.value.split("/");
                vDate1 = vDateSplit[1] + "/" + vDateSplit[0] + "/" + vDateSplit[2];

                var vDateSplit = document.forms[0].toDt.value.split("/");
                vDate2 = vDateSplit[1] + "/" + vDateSplit[0] + "/" + vDateSplit[2];

                var d1 = new Date(vDate1)// + " " + document.forms[0].hours1[document.forms[0].hours1.selectedIndex].value + ":" + document.forms[0].minutes1[document.forms[0].minutes1.selectedIndex].value);

                var d2 = new Date(vDate2)// + " " + document.forms[0].hours2[document.forms[0].hours2.selectedIndex].value + ":" + document.forms[0].minutes2[document.forms[0].minutes2.selectedIndex].value);

                var vDifference = Math.round(((d2-d1)/(24*60*60*1000)+1));

                //alert(vDifference)
                document.forms[0].noOfDays.value = vDifference;


            }

            function showContent(vThis)
            {

                // http://www.javascriptjunkie.com
                // alert(vSibling.className + " " + vDef_Key);
                vParent = vThis.parentNode;
                vSibling = vParent.nextSibling;
                while (vSibling.nodeType==3) { // Fix for Mozilla/FireFox Empty Space becomes a TextNode or Something
                    vSibling = vSibling.nextSibling;
                };
                if(vSibling.style.display == "none")
                {
                    vThis.src="../images/collapse.gif";
                    vThis.alt = "Hide Div";
                    vSibling.style.display = "block";
                } else {
                    vSibling.style.display = "none";
                    vThis.src="../images/expand.gif";
                    vThis.alt = "Show Div";
                }
                return;
            }


            function chkRegId(form,sel){




                var  leaveId =document.forms[0].leavetype.value;
                var noOfDays=sel.value;




                var add="../HRNET/ValidateAppliedLeave.do?method=validateAppliedLeave&noOfDays="+noOfDays+"&leavetype="+leaveId;


                //document.location.href=add;

                ajaxpagefetcher.load('demoRegId', add, true);


                //alert("VAlue=====>"+demoRegId);

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
                <td width="100%" colspan="3"  align="left" valign="top"><img src="images/Leave.jpg" width="100%" height="138" /></td>
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

                                                        <html:form action="Add">

                                                            <table width="761" border="0" cellspacing="0" cellpadding="0">
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
                                                                <tr>
                                                                    <td class="body_top">&nbsp;&nbsp;&nbsp; </td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="body_mid" style="padding:0 0 0 5px;" valign="bottom">
                                                                        <fieldset>
                                                                            <table>
                                                                                <tr>
                                                                                    <td align="left" valign="middle"><span class="style3">*</span>Employee Id</td>
                                                                                    <td align="left" valign="middle"><html:text property="empId" readonly="true" size="18" maxlength="30" /></td>

                                                                                </tr>

                                                                                <tr>
                                                                                    <td align="left" valign="middle">Leave Type</td>
                                                                                    <td align="left" valign="middle"><label>
                                                                                            <html:select property="leavetype">
                                                                                                <html:option value="0">select</html:option>
                                                                                                <logic:present name="leaveList" scope="request">
                                                                                                    <html:options collection="leaveList" property="leaveId" labelProperty="leaveType"/>
                                                                                                </logic:present>
                                                                                            </html:select>
                                                                                        </label></td>
                                                                                    <td align="right" valign="middle">Reason</td>
                                                                                    <td align="left" valign="middle"><html:text property="reason" size="18"/></td>


                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle">From Date</td>
                                                                                    <td align="left" valign="middle"><html:text property="fromDt" size="18"/>&nbsp;
                                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].fromDt,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif"  /></td>
                                                                                    <td align="right" valign="middle"> To Date</td>
                                                                                    <td align="left" valign="middle"><html:text property="toDt" size="18" onblur="dateDifference(this.form)"/>&nbsp;
                                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].toDt,'dd/mm/yyyy')" src="images/tlsCalendarIcon.gif" /></td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td align="left" valign="middle" > No. Of Days </td>
                                                                                    <td align="left" valign="middle" id="demoRegId"> <html:text property="noOfDays" readonly="true" size="18" /></td>
                                                                                    <td align="right" valign="middle">Half Day</td>
                                                                                    <td align="left" valign="middle"><html:select property="day">
                                                                                            <html:option value="0.5">On Starting Day</html:option>
                                                                                            <html:option value="0.5">On Ending Day</html:option>
                                                                                            <html:option value="0">Not Applicable</html:option>
                                                                                        </html:select></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle">Contact Address on Leave</td>
                                                                                    <td align="left" valign="middle"><html:text property="leaveAddress" size="18"/></td>
                                                                                    <td align="right" valign="middle">Contact Number on Leave</td>
                                                                                    <td align="left" valign="middle"><html:text property="leaveContactNo" size="18"/></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle">Personal Email</td>
                                                                                    <td align="left" valign="middle"><html:text property="email" size="20"/></td>
                                                                                    <td align="right" valign="middle">&nbsp;</td>
                                                                                    <td align="left" valign="middle">&nbsp;</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle">&nbsp;</td>
                                                                                    <td align="left" valign="middle"><table width="30%" border="0" align="left" cellpadding="0" cellspacing="0">
                                                                                            <tr>
                                                                                                <td align="right" valign="middle"><html:button  value="Submit" property="button" onclick="addLeave(this.form)"/>
                                                                                                </td>
                                                                                                <td width="4" align="left" valign="middle">&nbsp;</td>
                                                                                                <td align="left" valign="middle"><html:reset  value="Reset" /></td>
                                                                                            </tr>
                                                                                        </table></td>
                                                                                    <td align="left" valign="middle">&nbsp;</td>
                                                                                    <td align="left" valign="middle">&nbsp;</td>
                                                                                </tr>
                                                                            </table>
                                                                        </fieldset>
                                                                        <table width="20%" border="0" cellspacing="5" cellpadding="0">
                                                                            <tr>

                                                                                <td>                    <!--For Leave Report-->
                                                                                    <div style="margin-top:5px;">
                                                                                        <h4><input type="button"  value="Your Leave Details" alt="Show Div" border="0"  onclick="showContent(this);"></h4>
                                                                                        <div style="margin-top:5px; display:none;">
                                                                                            <table width="100" border="1" >

                                                                                                <tr style="background-color:goldenrod ; color: #FFFFFF" >

                                                                                                    <td width="133" align="center" nowrap>
                                                                                                        Leave Type</td>
                                                                                                    <td width="140" align="center" nowrap>
                                                                                                        Total Leave</td>
                                                                                                    <td width="142" align="center" nowrap>
                                                                                                        Leave Taken</td>


                                                                                                </tr>

                                                                                                <logic:present name="leaveReportList" scope="request">

                                                                                                    <logic:iterate id="itr" name="leaveReportList" indexId="no">
                                                                                                        <tr align="center" bgcolor="<c:if test="${no%2!=0}" >cornsilk</c:if><c:if test="${no%2==0}" >biege</c:if>" align="center">

                                                                                                            <td nowrap><bean:write name="itr" property="leaveType"></bean:write></td>
                                                                                                            <td nowrap><bean:write name="itr" property="totalLeave"></bean:write></td>

                                                                                                            <td nowrap><bean:write name="itr" property="leaveTaken"></bean:write></td>
                                                                                                        </tr>
                                                                                                    </logic:iterate>
                                                                                                </logic:present>
                                                                                            </table>
                                                                                        </div></div>
                                                                                    <!--End Leave Report--></td>
                                                                            </tr>
                                                                        </table>

                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="body_bottom">&nbsp;</td>
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
</html>
