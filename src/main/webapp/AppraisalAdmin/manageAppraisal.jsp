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
        <title>HRMS::Manage Appraisal</title>
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />
        <script type="text/javascript" src="js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="js/HRMS.js"></script>

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
        <script type="text/JavaScript">

            function hold(form){
                confirm("Do You Realy Want to hold the process !!");
                form.method.value="manageSetup";
                form.status.value="Hold";
                form.submit();
            }
            function activate1(form)
            {
                form.status.value="Active";
                form.method.value="manageSetup";
                form.submit();
            }
            function stop(form)
            {
                form.status.value="Stop";
                form.method.value="manageSetup";
                form.submit();
            }


        </script>
        <style>
            .Active {   color:green; } .Stop { color:red;  } .Hold {color:gray; }
        </style>

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
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/Appraisal.jpg" width="100%" height="138" /></td>
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


                                                        <table width="761" border="0" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td class="body_top">&nbsp;</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="body_mid" style="padding:0 0 0 5px;" valign="middle">

                                                                    <form action="manageAppraisal.do" method="post">
                                                                        <table align="left" >
                                                                            <tr>
                                                                                <td  colspan="2" align="left" valign="top"><div id="errorMsg" ></div>

                                                                                    <logic:messagesPresent message="true">

                                                                                        <font color="green"> <b><img src="images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                                    </logic:messagesPresent>
                                                                                    <logic:messagesPresent >

                                                                                        <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                                    </logic:messagesPresent >
                                                                                </td>

                                                                            </tr>
                                                                            <tr><td colspan="2">
                                                                                    <table align="left" cellpadding="0" cellspacing="0" border="0" >
                                                                                        <tr>
                                                                                            <td colspan="3" align="center" height="10" valign="top">
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr><td>
                                                                                                <table  cellpadding="0" cellspacing="0" border="0" align="center" bgcolor="palegoldenrod" width="600">
                                                                                                    <tr bgcolor="goldenrod" align="center">

                                                                                                        <td ><font color="white" ><b>Appraisal Type</b></font></td>
                                                                                                        <td>&nbsp;&nbsp;</td>
                                                                                                        <td ><font color="white" ><b>Company</b></font></td>
                                                                                                        <td>&nbsp;&nbsp;</td>
                                                                                                        <td><font color="white" ><b>Duration</b></font></td>
                                                                                                        <td>&nbsp;&nbsp;</td>
                                                                                                        <td><font color="white" ><b>Department</b></font></td>
                                                                                                        <td>&nbsp;&nbsp;</td>
                                                                                                        <td><font color="white" ><b>Current Status</b></font></td>
                                                                                                    </tr>
                                                                                                    <logic:present name="appraisalsetup" scope="request">
                                                                                                        <logic:iterate id="itr" name="appraisalsetup" indexId="counter">
                                                                                                            <tr align="justify" bgcolor="<c:if test='${counter%2!=0}'>cornsilk</c:if><c:if test='${counter%2==0}'>white</c:if>">
                                                                                                                <td><input type="checkbox"  name="id" value="<bean:write  name="itr" property="id"/>" />

                                                                                                                    <b> <bean:write  name="itr" property="category_name"/></b></td>
                                                                                                                <td>&nbsp;&nbsp;</td>
                                                                                                                <td><b><bean:write  name="itr" property="company_name"/></b></td>
                                                                                                                <td>&nbsp;&nbsp;</td>
                                                                                                                <td><b><bean:write  name="itr" property="duration"/></b></td>
                                                                                                                <td>&nbsp;&nbsp;</td>
                                                                                                                <td align="center"><b><bean:write  name="itr" property="department_name"/></b></td>
                                                                                                                <td>&nbsp;&nbsp;</td>
                                                                                                                <td align="center"><b>
                                                                                                                        <font class="<bean:write  name="itr" property="status"/>"/><bean:write  name="itr" property="status"/></b></td>
                                                                                                            </tr>
                                                                                                        </logic:iterate>
                                                                                                    </logic:present>
                                                                                                </table>
                                                                                                <input type="hidden" name="method" value=""/>
                                                                                                <input type="hidden" name="status" value=""/>
                                                                                            </td>
                                                                                        </tr>
                                                                                    </table><br><br>
                                                                                </td></tr>
                                                                            <tr align="center">
                                                                                <td><input type="button" value="Hold Process" onclick="hold(this.form)" />
                                                                                    <input type="button" value="Start Process" onclick="activate1(this.form)"/>
                                                                                    <input type="button" value="Stop Process" onclick="stop(this.form)" />
                                                                                    <input type="button" value="Cancel" onclick="cancel(this.form)"/></td>
                                                                            </tr>
                                                                        </table>
                                                                    </form>

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
	        		active: 7
	        	});
        	});

        </script>
    </body>
</html>
