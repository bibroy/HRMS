<%-- 
    Document   : ViewLeaveRequestDetails
    Created on : Nov 22, 2010, 2:16:32 PM
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
        <title>View Leave Request Details</title>
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />
        <script type="text/javascript" src="js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="js/HRMS.js"></script>
        <style>
            .visible
            {
                display:block;
            }
            .invisible
            {
                display:hidden;
            }
        </style>

        <script type="text/javascript">

        $(function() {
        	//loadAccordions();
	        	$( "#accrdins" ).accordion({
	        		collapsible: true,
	        		active: 1
	        	});
        	});




            function loadData(form){

                form.method.value="viewLeaveRequestData";
                alert("form.method.value");
                form.submit();
            }
            function approve(form,idval1)
            {
                var id = document.getElementsByName("empId");
                alert("  id "+idval1);
                //document.getElementsByName("hiddenId")=id;
                // window.location.href="Approval.do?method=approveLeaveRequest&hiddenId="+idval1;
                window.location.href="Approval.do?method=approveLeaveRequest&hiddenId="+idval1;
                //form.method.value="approveLeaveRequest";
                alert("***************");
                form.submit();
            }
            function reject(form,idval2)
            {

                var whyReject=form.whyReject.value;
                alert(whyReject);

                window.location.href="Rejection.do?method=rejectLeaveRequest&hiddenId="+idval2+"&whyReject="+whyReject;
                alert(" id "+idval2);
                form.submit();
            }

            function openWindow(empId){
                // --- alert("open the popup");
                fnFurtherDetail(empId);
                return false;
            }

            function fnFurtherDetail(empId) {

                //var linkPage="/gmswar/jspmodule1/Popup.do?dueDate="+dueDate+"&accMgr="+accMgr+"&reminder="+reminder+"&tasks="+tasks+"&orgnm="+orgname+"&orgno="+orgno+"&trust="+trust+"&foundation="+foundation+"&popup=PopUp&flg=Popup&reminderId="+reminderId+"&grantId="+grantId+"&lastUpdtBy="+lastUpdtBy+"&flgaction=update";
                var linkPage="../EmployeeDetailsForLeave.do?method=getSingleEmployeeDetails&empId="+empId;
                //alert(linkPage);
                window.open (linkPage,'PopUp','left=270,top=200,toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, directories=no, status=no,width=697,height=277');
                //document.forms[0].submit();
            }

            function showContent(vThis)
            {
                // alert(vThis.parentNode.nextSibling.nodeType);
                // http://www.javascriptjunkie.com
                // alert(vSibling.className + " " + vDef_Key);
                vParent = vThis.parentNode;
                vSibling = vParent.nextSibling;
                while (vSibling.nodeType==3) { // Fix for Mozilla/FireFox Empty Space becomes a TextNode or Something
                    vSibling = vSibling.nextSibling;
                };


                if(vSibling.style.display == "none")
                {
                    //vThis.src="/img/collapse.gif";
                    vThis.alt = "Hide Div";
                    vSibling.style.display = "block";
                } else {
                    vSibling.style.display = "none";
                    //vThis.src="/img/expand.gif";
                    vThis.alt = "Show Div";
                }
                return;
            }


            function close(vthis)
            {
                vParent = vThis.parentNode;
                vSibling = vParent.nextSibling;
                while (vSibling.nodeType==3) { // Fix for Mozilla/FireFox Empty Space becomes a TextNode or Something
                    vSibling = vSibling.nextSibling;
                };


                if(vSibling.style.display == "none")
                {
                    //vThis.src="/img/collapse.gif";
                    vThis.alt = "Hide Div";
                    vSibling.style.display = "block";
                } else {
                    vSibling.style.display = "none";
                    //vThis.src="/img/expand.gif";
                    vThis.alt = "Show Div";
                }
                return;


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


                                                        <logic:messagesPresent message="true">

                                                            <font color="green"> <b><img src="images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                        </logic:messagesPresent>
                                                        <logic:messagesPresent >

                                                            <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                        </logic:messagesPresent >

                                                        <table width="88%" border="0" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td class="body_top">&nbsp;</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="body_mid" style="padding:0 0 0 5px;" valign="bottom">
                                                                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
                                                                        <tr>
                                                                            <td width="7%" height="33" align="center" valign="middle" bgcolor="#B27138" class="menu_bg">Request Id</td>
                                                                            <td width="6%" align="center" valign="middle" bgcolor="#8A4117" class="menu_bg">  Employee Id  </td>
                                                                            <td width="9%" align="center" valign="middle" bgcolor="#B27138" class="menu_bg"> Leave Type  </td>
                                                                            <td width="6%" align="center" valign="middle" bgcolor="#B27138" class="menu_bg">From Date </td>
                                                                            <td width="6%" align="center" valign="middle" bgcolor="#B27138" class="menu_bg">To Date </td>

                                                                            <td width="5%" align="center" valign="middle" bgcolor="#B27138" class="menu_bg"> Reason</td>
                                                                            <td width="21%" align="center" valign="middle" bgcolor="#B27138" class="menu_bg">Contact address on Leave</td>
                                                                            <td width="20%" align="center" valign="middle" bgcolor="#B27138" class="menu_bg">Contact number on Leave</td>
                                                                            <td width="5%" align="center" valign="middle" bgcolor="#B27138" class="menu_bg">Personal Email</td>
                                                                            <td width="5%" align="center" valign="middle" bgcolor="#B27138" class="menu_bg">Request Date</td>

                                                                            <td width="5%" align="center" valign="middle" bgcolor="#B27138" class="menu_bg"> Action</td>
                                                                            <td width="5%" height="30" align="center" valign="middle" bgcolor="#B27138" class="menu_bg"> Action</td>
                                                                        </tr>

                                                                        <logic:present name="empList" scope="request">
                                                                            <logic:iterate id="itr" name="empList" indexId="no">
                                                                                <html:form action="ViewLeaveRequestDetails" method="post">
                                                                                    <tr bgcolor="<c:if test="${no%2!=0}" >cornsilk</c:if><c:if test="${no%2==0}" >white</c:if>" align="center">
                                                                                        <td>
                                                                                            <bean:write name="itr" property="requestId" ></bean:write>

                                                                                        </td>

                                                                                        <td>

                                                                                            <bean:write name="itr" property="empId" ></bean:write>
                                                                                            <br/>
                                                                                            <a href="#" onclick="return openWindow(<bean:write name='itr' property='empId'/>);" >View Employee Details</a>

                                                                                        </td>

                                                                                        <td>
                                                                                            <bean:write name="itr" property="leavetype"></bean:write>
                                                                                        </td>

                                                                                        <td>
                                                                                            <bean:write name="itr" property="fromDt"></bean:write>
                                                                                        </td>

                                                                                        <td>
                                                                                            <bean:write name="itr" property="toDt"></bean:write>
                                                                                        </td>

                                                                                        <td>
                                                                                            <bean:write name="itr" property="reason"></bean:write>
                                                                                        </td>

                                                                                        <td>
                                                                                            <bean:write name="itr" property="leaveAddress"></bean:write>
                                                                                        </td>

                                                                                        <td>
                                                                                            <bean:write name="itr" property="leaveContactNo"></bean:write>
                                                                                        </td>


                                                                                        <td>
                                                                                            <bean:write name="itr" property="email"></bean:write>
                                                                                        </td>
                                                                                        <td>
                                                                                            <bean:write name="itr" property="requestDate"></bean:write>
                                                                                        </td>

                                                                                        <td>
                                                                                            <%--<html:button property="button" value="Approve"  />--%>
                                                                                            <input type="button" value="Approve" onclick="approve(this.form,<bean:write name='itr' property='requestId'/>)"/>
                                                                                        </td>
                                                                                        <td>
                                                                                            <%-- <div>
                                                                                            <input type="button" value="Reject" alt="Show Div" onclick="showContent(this)" />
                                                                                            <div style="margin-top:5px; display:none; border:1px solid red;">
                                                                                           <p> THis is the content of the #1 div</p>
                                                                                            </div>
                                                                                            </div>--%>
                                                                                            <div style="margin-top:5px;">
                                                                                                <h4><input type="button" value="Reject" alt="Show Div" border="0" style="margin-right:6px; margin-top:3px; margin-bottom:-3px; cursor:pointer;" onclick="showContent(this);" /></h4>
                                                                                                <div style="margin-top:5px; display:none;">
                                                                                                    <table>
                                                                                                        <tr>
                                                                                                            <td>
                                                                                                                <%-- <input type="text" name="whyReject" />--%>
                                                                                                                <html:text property="whyReject"/>
                                                                                                            </td>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <td>
                                                                                                                <input type="button" value="Submit" onclick="reject(this.form,<bean:write name='itr' property='requestId'/>)"/>
                                                                                                                <input type="button" value="Cancel" onclick="close()"/>
                                                                                                            </td>
                                                                                                        </tr>
                                                                                                    </table>

                                                                                                </div></div>
                                                                                        </td>
                                                                                        <td>

                                                                                        </td>
                                                                                        <%--  <td>
                                                                                              <input type="button" value="Reject" onclick="reject(this.form,<bean:write name='itr' property='requestId'/>)"/>
                                                                                          </td>--%>
                                                                                    </tr>

                                                                                    <html:hidden property="method"/>
                                                                                </html:form>
                                                                            </logic:iterate>
                                                                        </logic:present>

                                                                    </table>

                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td class="body_bottom">&nbsp;</td>
                                                            </tr>
                                                        </table>


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
	        		active: 0
	        	});
        	});
        </script>
    </body>
</html>
