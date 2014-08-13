<%-- 
    Document   : hrCreation
    Created on : Nov 19, 2010, 10:35:14 AM
    Author     : Sumit Kumar
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
        <title>HRMS :: HR Creation</title>
        <script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>
        <script type="text/javascript" src="../js/calender/viewCalendar.js"> </script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>
        <script language="javascript" type="text/JavaScript" src="../js/tabMenu.js"></script>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

        <script type="text/JavaScript">

            function addRec(form){
                form.method.value="addEmployeePersonalInfo";


                if(ipFieldValidation(form)){

                    form.submit();


                    document.getElementById("empCerationForm").className="submitAction";
                    document.getElementById("submitBtn").disabled = true;

                }
                else{

                    return false;
                }

            }

            function selDselField(form,id){

                if(form.reEmpStatus.checked==true){

                    document.getElementById(id).disabled=false;
                }
                else if(form.reEmpStatus.checked==false){

                    document.getElementById(id).disabled=true;

                }
            }
        </script>
        <script language="javascript" type="text/javascript">
            function ipFieldValidation(form){

                if(!checkBlank(form.firstName,'First Name'))
                {
                    //document.getElementById("errorMsg").innerHTML=" First Name Can't Blank";
                    // document.getElementById("errorMsg").className="errorMsg";

                    return false;
                }
                else{

                    document.getElementById("errorMsg").innerHTML="";
                }

                if(!checkChar(form.firstName,'First Name'))
                {
                    return false;
                }



                if(!checkBlank(form.lastName,'Last Name'))
                {
                    return false;
                }


                if(!checkChar(form.lastName,'Last Name'))
                {
                    return false;
                }

                if(!checkBlank(form.dateOfBirth,'Date of  Birth'))
                {
                    return false;
                }

                else{
                    return true;

                }

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
                <td width="100%" colspan="3" align="left" valign="top"><img src="../images/Employee.jpg" width="100%" height="138" /></td>
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


                                                        <html:form action="createHr" method="get"  styleClass="none" styleId="empCerationForm">
                                                            <!--Start Main table-->
                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
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

                                                                        <table width="80%" border="0" cellspacing="4" cellpadding="2" >
                                                                            <tr>
                                                                                <td colspan="2" nowrap="nowrap"><span class="normal_black_text" style="font-weight: bold">Fill Up all Mandatory fields(</span><span class="normal_black_text"><span class="style3">*</span></span><span class="normal_black_text" style="font-weight: bold">):- </span></td>
                                                                                <td width="30%" nowrap="nowrap"></td>
                                                                                <td width="13%" nowrap="nowrap">&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="31%" align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>First Name: </td>
                                                                                <td width="29%" align="left" valign="middle" nowrap="nowrap"><html:text property="firstName"   /></td>
                                                                                <td align="right" valign="middle" nowrap="nowrap">Middle Name: </td>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><html:text property="middleName" /></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Last Name:</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><html:text property="lastName"  /></td>
                                                                                <td align="right" valign="middle" nowrap="nowrap"><span class="style3">*</span>Date of Birth:</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><html:text property="dateOfBirth" readonly="true"  />
                                                                                    <html:img onclick="javascript:popUpCalendar(this,document.forms[0].dateOfBirth,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" /></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Gender:</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap">
                                                                                    <html:select property="gender" >
                                                                                        <html:option value="">-Select-</html:option>
                                                                                        <html:option value="Male">Male</html:option>
                                                                                        <html:option value="Female">Female</html:option>
                                                                                    </html:select></td>
                                                                                <td align="right" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap">                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="left" valign="middle" nowrap="nowrap"> <span class="style3">*</span>Branch:</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap">
                                                                                    <html:text property="brId" readonly="true"   />							  </td>
                                                                                <td align="right" valign="middle" nowrap="nowrap"><span class="style3">*</span>Dapartment:</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap">

                                                                                    <html:text property="deptId"   /></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Designation</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap">

                                                                                    <html:select property="designation_id" >


                                                                                        <html:option value="3">Employee</html:option>
                                                                                    </html:select></td>
                                                                                <td align="right" valign="middle" nowrap="nowrap">Domain / Industry:</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><html:text property="domainId"   /></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Comformation Due Date </td>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><html:text property="confDueDate" readonly="true"  />
                                                                                    <html:img onclick="javascript:popUpCalendar(this,document.forms[0].confDueDate,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" /></td>
                                                                                <td align="right" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap"></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="31%" align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Date of Join : </td>
                                                                                <td width="29%" align="left" valign="middle" nowrap="nowrap"><html:text property="dateOfJoin" readonly="true"  />
                                                                                    <html:img onclick="javascript:popUpCalendar(this,document.forms[0].dateOfJoin,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" /></td>
                                                                                <td width="30%" align="right" valign="middle" nowrap="nowrap"><span class="style3">*</span>Effective From:: </td>
                                                                                <td width="13%" align="left" valign="middle" nowrap="nowrap" > <html:text property="dateOfEffective" readonly="true"  />
                                                                                    <html:img onclick="javascript:popUpCalendar(this,document.forms[0].dateOfEffective,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" />            </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Re-Employee Status: </td>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><html:checkbox property="reEmpStatus" onclick="selDselField(this.form,'oldemployeeId')"  /></td>
                                                                                <td align="right" valign="middle" nowrap="nowrap">Old Employeement No.: </td>
                                                                                <td align="left" valign="middle" nowrap="nowrap">

                                                                                    <html:text property="oldemployeeId" styleId="oldemployeeId"   />                     </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="left" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><table width="30%" border="0" align="left" cellpadding="0" cellspacing="0">
                                                                                        <tr>
                                                                                            <td align="right" valign="middle">
                                                                                                <%--    <html:button property="button" value="Submit"  onclick="return addRec(this.form)" styleClass="submitButton"/> --%>
                                                                                                <html:button property="button" value="Submit"  onclick="return addRec(this.form)" />
                                                                                            </td>
                                                                                            <td width="4" align="left" valign="middle">&nbsp;</td>
                                                                                            <td align="left" valign="middle">
                                                                                                <%--   <html:reset property="Reset" value="Clear" styleClass="resetButton" /> --%>
                                                                                                <html:reset property="Reset" value="Clear" />
                                                                                            </td>
                                                                                        </tr>
                                                                                    </table></td>
                                                                                <td align="right" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                            </tr>
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

