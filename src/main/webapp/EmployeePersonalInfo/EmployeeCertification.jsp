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
        <title>HRMS :: Employee certification details Creation</title>
        <script type="text/javascript" src="../js/ajaxpagefetcher.js"></script>
        <script type="text/javascript" src="../js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>
        <script language="javascript" type="text/JavaScript" src="../js/tabMenu.js"></script>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

        <script language="JavaScript" type="text/javascript">
            function empcertification(form)
            {
                form.method.value="empcertificationaction";

           if(!checkBlank(form.employeeId,'employeeId'))
                {
                    return;
                }
                if(!checkBlank(form.certificationName,'certificationName'))
                {
                    return;
                }
                if(!checkBlank(form.orgatizationName,'orgatizationName'))
                {
                    return;
                }
                if(!checkBlank(form.subject,'subject'))
                {
                    return;
                }
                if(!checkBlank(form.certifiedOnDate,'certifiedOnDate'))
                {
                    return;
                }
                if(!checkBlank(form.renewedDate,'renewedDate'))
                {
                    return;
                }
                if(!checkBlank(form.renewedOnDate,'renewedOnDate'))
                {
                    return;
                }
                if(!checkChar(form.certificationName,'certificationName'))
                {
                    return;
                }
                if(!checkChar(form.orgatizationName,'orgatizationName'))
                {
                    return;
                }
                if(!checkChar(form.subject,'subject'))
                {
                    return;
                }
                form.submit();
            }


             function loadTask(form){
                form.method.value="load";
                alert(form.method.value);
                form.submit();
             }

               function certificationdetailcall(form){
                form.method.value="certificationdetail";
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


                                                        <html:form action="empcertification.do"  styleClass="none" styleId="empCerationForm">
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
                                                                        <h2>Enter employee certification details</h2>
                                                                        <table width="80%" border="0" cellspacing="4" cellpadding="2" >
                                                                            <tr><td>Enter employee id:</td><td><html:text property="employeeId" /></td></tr>
                                                                            <tr><td>Certification Name:</td><td><html:select property="certificationName" onchange="certificationdetailcall(this.form)">
                                                                            <html:option value="">--Select Please--</html:option>
                                                                            <logic:present name="ecertification" scope="request">
                                                                                <html:options collection="ecertification" labelProperty="certificationName" property="certificationName"  />
                                                                            </logic:present>
                                                                        </html:select></td>

                                                                       





                                                                        </tr>
                                                                        <tr><td>Organization Name:</td><td><html:text property="orgatizationName"/></td></tr>
                                                                        <tr><td>Subject:</td><td><html:text property="subject"/></td></tr>
                                                                        <tr><td>Certified on date:</td>
                                                                            <td><html:text property="certifiedOnDate" />
                                                                                    <html:img onclick="javascript:popUpCalendar(this,document.forms[0].certified_on_date,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" /></td>
                                                                        </tr>

                                                                        <tr><td>Renewed Date: </td>
                                                                            <td><html:text property="renewedDate" />
                                                                                    <html:img onclick="javascript:popUpCalendar(this,document.forms[0].renewed_date,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" /></td>
                                                                        </tr>



                                                                        <tr><td>Renewed on Date:  </td>
                                                                            <td><html:text property="renewedOnDate" />
                                                                                    <html:img onclick="javascript:popUpCalendar(this,document.forms[0].renewed_on_date,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" /></td>
                                                                        </tr>






                                                                        <tr><td><html:button property="button" value="submit the details" onclick="empcertification(this.form);" /></td>
                                                                            <td><html:reset value="clear" /></td></tr>

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

