<%-- 
   Author--pradipto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<%@page  import="java.util.*" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS :: Employee  Visa Edit details Creation</title>
        <script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>
        <script type="text/javascript" src="../js/calender/viewCalendar.js"> </script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>
        <script language="javascript" type="text/JavaScript" src="../js/tabMenu.js"></script>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

        <script language="JavaScript" type="text/javascript">
            function EditFnctnCall(form)
            {
                form.method.value="EmployeeVisaDetailEditOrSave";
                
               

                if(ipFieldValidation(form)){

                    form.submit();


                    //    document.getElementById("empCerationForm").className="submitAction";
                    //   document.getElementById("submitBtn").disabled = true;

                }
                else{

                    return false;
                }




            }



            function ipFieldValidation(form){

                if(!checkBlank(form.passportNo,'Employee passport number'))
                {
                    //document.getElementById("errorMsg").innerHTML=" First Name Can't Blank";
                    // document.getElementById("errorMsg").className="errorMsg";

                    return false;
                }
                else{

                    document.getElementById("errorMsg").innerHTML="";
                }

                if(!checkBlank(form.passportIssueDate,'Employee Passport issued date'))
                {
                    return false;
                }



                if(!checkBlank(form.passportIssuedBy,'Passport issued by field'))
                {
                    return false;
                }


                if(!checkBlank(form.passportValidUpto,'Passport Valdation field'))
                {
                    return false;
                }

                if(!checkBlank(form.visaNo,'Employee Visa no'))
                {
                    return false;
                }
                if(!checkBlank(form.visaType,'Employee Visa number'))
                {
                    return false;
                }


                if(!checkBlank(form.visaIssuedBy,'Visa issued by '))
                {
                    return false;
                }


                if(!checkBlank(form.visaIssueDate,'Visa issued Date to employee. '))
                {
                    return false;
                }


 



                if(!checkChar(form.passportIssuedBy,'Passport issued by field'))
                {
                    return false;
                }

                if(!checkBlank(form.visaValidUpto,'Employee visa valid upto. '))
                {
                    return false;
                }



                else{
                    return true;

                }

            }

            function loadTask(form){
                form.method.value="load";
                alert(form.method.value);
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
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/Employee.jpg" width="100%" height="138" /></td>
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


                                                        <html:form action="empvisadetailpathserver.do"   styleClass="none" styleId="empCerationForm">
                                                            <!--Start Main table-->
                                                            <table width="100%"  cellpadding="0" cellspacing="0">
                                                                <tr>
                                                                    <td align="left" valign="top"><div id="errorMsg" ></div>

                                                                        <logic:messagesPresent message="true">

                                                                            <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                        </logic:messagesPresent>
                                                                        <logic:messagesPresent >

                                                                            <html:messages id="error"><bean:write name="error"/></html:messages>

                                                                        </logic:messagesPresent >

                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="top"><!--Start Personal Info table-->
                                                                        <h2>Employee Visa edit Details  page</h2>
                                                                        <table width="80%" border="0" cellspacing="4" cellpadding="2" >
                                                                            <tr><h3><td>Your employee id:</td></h3><td><html:text property="employeeId" readonly="true" /></td></tr>
                                                                <tr><td>Employee Passport Number:</td><td><html:text property="passportNo" readonly="true"/></td></tr>



                                                                <tr><td>Employee Passport issue Date:</td><td><html:text property="passportIssueDate" />
                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].passportIssueDate,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" />
                                                                    </td></tr>
                                                                <tr><td>Passport Issued by:</td><td><html:text property="passportIssuedBy" readonly="true"/></td></tr>
                                                                <tr><td>Employee Passport valid date:</td>
                                                                    <td><html:text property="passportValidUpto" readonly="true" />
                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].passportValidUpto,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" />

                                                                    </td>
                                                                </tr>

                                                                <tr><td>Employee Visa number: </td>
                                                                    <td><html:text property="visaNo" />
                                                                    </td>
                                                                </tr>

                                                                <tr><td>Employee Visa type: </td>
                                                                    <td><html:text property="visaType" />
                                                                    </td>
                                                                </tr>

                                                                <tr><td>Visa issued by: </td>
                                                                    <td><html:text property="visaIssuedBy" />
                                                                    </td>
                                                                </tr>



                                                                <tr><td>Visa issued date: </td>
                                                                    <td><html:text property="visaIssueDate" />
                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].visaIssueDate,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" />
                                                                    </td>
                                                                </tr>

                                                                <tr><td>Visa valid date: </td>
                                                                    <td><html:text property="visaValidUpto" />

                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].visaValidUpto,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" />
                                                                    </td>
                                                                </tr>


                                                                <tr><td><html:button property="button" value="submit the details" onclick="EditFnctnCall(this.form);" /></td>
                                                                    <td><html:reset value="clear" /><html:hidden property="id" /></td></tr>

                                                            </table>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="left" valign="top"></td>
                                                    </tr>
                                                    <tr>
                                                        <td align="left" valign="top">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td align="left" valign="top">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td align="left" valign="top">&nbsp;</td>
                                                    </tr>
                                                </table>
                                                <!--End Main Table-->
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

