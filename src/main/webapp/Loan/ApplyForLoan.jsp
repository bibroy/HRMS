<%-- 
    Document   : ApplyForLoan
    Created on : Nov 16, 2010, 11:43:45 AM
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
        <title>HRMS :: Apply For Loan</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

        <script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="../js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>

        <script type="text/javascript" src="../js/accordion/javascript/prototype.js"></script>
        <script type="text/javascript" src="../js/accordion/javascript/effects.js"></script>
        <script type="text/javascript" src="../js/accordion/javascript/accordion.js"></script>
        <script type="text/javascript" src="../js/scripts.js"></script>

        <script type="text/javascript">

            //
            //  In my case I want to load them onload, this is how you do it!
            //
            Event.observe(window, 'load', loadAccordions, false);

            //
            //	Set up all accordions
            //
            function loadAccordions() {
                /*var topAccordion = new accordion('horizontal_container', {
                                classNames : {
                                        toggle : 'horizontal_accordion_toggle',
                                        toggleActive : 'horizontal_accordion_toggle_active',
                                        content : 'horizontal_accordion_content'
                                },
                                defaultSize : {
                                        width : 525
                                },
                                direction : 'horizontal'
                        });*/

                var bottomAccordion = new accordion('vertical_container');

                var nestedVerticalAccordion = new accordion('vertical_nested_container', {
                    classNames : {
                        toggle : 'vertical_accordion_toggle',
                        toggleActive : 'vertical_accordion_toggle_active',
                        content : 'vertical_accordion_content'
                    }
                });

                // Open first one
                //bottomAccordion.activate($$('#vertical_container .accordion_toggle')[0]);

                // Open second one
                //topAccordion.activate($$('#horizontal_container .horizontal_accordion_toggle')[2]);
            }

        </script>

        <script language="javascript" type="text/javascript" >
            function addRequest(form){
                form.method.value="applyForLoan";
                alert(form.method.value);

                if(!checkBlank(form.empId,'Employee Id'))
                {
                    return;
                }
                if(!checkBlank(form.totalSal,'Total Salary'))
                {
                    return;
                }
                if(!checkBlank(form.reqAmt,'Required Amount'))
                {
                    return;
                }
                if(!checkBlank(form.installment,'No Of Installment'))
                {
                    return;
                }
                if(!checkBlank(form.deductstartmonth,'Deduction start month'))
                {
                    return;
                }
                if(!checkBlank(form.reason,'Reason'))
                {

                    return;
                }

                form.submit();
            }

            //Ajax started

            function chkRegId(sel){

                var regId=sel.value;

                var add="GetSalaryForLoan.do?method=getTotalSalary&hiddenId="+regId;
                //document.location.href=add;

                ajaxpagefetcher.load('demoRegId', add, true);


                //alert("VAlue=====>"+demoRegId);

            }

            function chekAmount(amt,form)
            {
                var amount=amt.value;

                var totalSalary= document.getElementById("sal").value;

                if(amount>(totalSalary/3))
                {
                    alert("Requested amount should not more than 1/3 of gross Salary ");
                    document.forms[0].reqAmt.value=0;
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
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/loan.jpg" width="100%" height="138" /></td>
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

                                                        <html:form action="ApplyLoan">


                                                            <table width="80%" border="0" align="left" cellpadding="2" cellspacing="4">

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
                                                                    <td colspan="3" align="left" valign="middle"><span class="normal_black_text" style="font-weight: bold">Fill Up all Mandatory fields(</span><span class="normal_black_text"><span class="style3">*</span></span><span class="normal_black_text" style="font-weight: bold">):- </span></td>
                                                                    <td align="left" valign="middle" >&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle"><span class="style3">*</span>Employee Id </td>
                                                                    <td align="left" valign="middle"><html:text property="empId" size="18" onblur="return chkRegId(this)" readonly="true"/></td>

                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" >Total Salary</td>
                                                                    <td align="left" valign="middle" id="demoRegId"><html:text property="totalSal" size="18"/>
                                                                    </td>
                                                                    <td align="right" valign="middle">Loan Amount</td>
                                                                    <td align="left" valign="middle"><html:text property="reqAmt" size="18" /></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle">Reason</td>
                                                                    <td align="left" valign="middle"><html:text property="reason" size="18"/></td>
                                                                    <td align="left" valign="middle">&nbsp;</td>
                                                                    <td align="left" valign="middle">&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle">Number Of Installment </td>
                                                                    <td align="left" valign="middle"><html:text property="installment" size="18"/></td>
                                                                    <td align="left" valign="middle">Deduction Starting Month </td>
                                                                    <td align="left" valign="middle"><html:text property="deductstartmonth" size="18" />
                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].deductstartmonth,'dd/mm/yyyy')" src="images/tlsCalendarIcon.gif"  /></td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle">&nbsp;</td>
                                                                    <td align="left" valign="middle">&nbsp;</td>
                                                                    <td align="right" valign="middle">&nbsp;</td>
                                                                    <td align="left" valign="middle">&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle">&nbsp;</td>
                                                                    <td align="left" valign="middle"><table width="30%" border="0" align="left" cellpadding="0" cellspacing="0">
                                                                            <tr>
                                                                                <td align="right" valign="middle"><html:button  value="Submit" property="button" onclick="addRequest(this.form)" />
                                                                                </td>
                                                                                <td width="4" align="left" valign="middle">&nbsp;</td>
                                                                                <td align="left" valign="middle"><html:reset  value="Reset" /></td>
                                                                            </tr>
                                                                        </table></td>
                                                                    <td align="right" valign="middle">&nbsp;</td>
                                                                    <td align="left" valign="middle">&nbsp;</td>
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
