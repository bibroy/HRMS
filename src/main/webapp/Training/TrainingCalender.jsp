<%--
    Document   :Trianing DCalender
    Created on : 
    Author     : Pradipto Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page buffer="256kb"%>
<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib  uri="http://displaytag.sf.net" prefix="display"%>

<%@page import="java.util.List" %>
<%@page  import="com.pojo.EmployeeMaster" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS ::Training Calender </title>
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />
        <link rel="stylesheet" href="css/displaytagex.css"/>
        <script type="text/javascript" src="js/calender/viewCalendar.js"> </script>
        <script language="javascript" type="text/JavaScript" src="js/HRMS.js"></script>
        <script language="JavaScript" type="text/javascript">


            function loadTrainingCalender(form){
                form.method.value="loadTrainingCalender";

                form.submit();
            }




            function Traingdetailsave(form)
            {
                form.method.value="TraingCalenderDetailSaveOrEdit";

                form.submit();
               
                if(!checkBlank(form.trainingName,'training name'))
                {
                    return false;
                }
                else
                {
                    document.getElementById("errorMsg").innerHTML="";
                }


                if(!checkBlank(form.fromDate,'fromDate'))
                {
                    return false;
                }


                if(!checkBlank(form.toDate,'Up to date'))
                {
                    return false;
                }

                if(!checkBlank(form.capacityStrenth,'Capacity strenth'))
                {
                    return false;
                }
                if(!checkBlank(form.createdBy,'created by'))
                {
                    return false;
                }


                if(!checkBlank(form.createdDate,'Creation date'))
                {
                    return false;
                }
                 if(!checkNumber(form.capacityStrenth,'Capacity strenth'))
                {
                    return false;
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
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/Training.jpg" width="100%" height="138" /></td>
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
                <td align="left" valign="top" bgcolor="#FFFFFF">
                    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
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
                                                                <td class="body_mid" style="padding:0 0 0 5px;" valign="top" width="600">

                                                                    <html:form action="trainingcalender"  styleClass="none" styleId="empCerationForm">
                                                                        <center><h2 style="background-color: window;border-color:burlywood; width:500px; ">Training Calender</h2></center>

                                                                        <hr/>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="top"><div id="errorMsg" ></div>

                                                                        <logic:messagesPresent message="true">

                                                                            <font color="green"> <b><img src="images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                        </logic:messagesPresent>
                                                                        <logic:messagesPresent >

                                                                            <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                        </logic:messagesPresent >
                                                                    </td>

                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <br>
                                                                        <br>
                                                                         <table width="80%" border="1" cellspacing="4"   cellpadding="7" style="Background: cornsilk " >
                                                                                <tr><td nowrap="true" >Training Start Date:</td><td nowrap="true"><html:text property="fromDate" readonly="true" />
                                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].fromDate,'dd/mm/yyyy')" src="images/tlsCalendarIcon.gif" /></td>
                                                                                    <td nowrap="true">Training upto:</td><td><html:text property="toDate" readonly="true"/>
                                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].toDate,'dd/mm/yyyy')" src="images/tlsCalendarIcon.gif" /></td>
                                                                                </tr>


                                                                                <tr><td nowrap="true">Enter training name:</td><td><html:text property="trainingName" /></td>

                                                                                    <td nowrap="true">Capacity Strenth:

                                                                                    </td>
                                                                                    <td><html:text property="capacityStrenth"/>

                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td>
                                                                                        Created by:
                                                                                    </td><td nowrap="true">

                                                                                        <html:text property="createdBy"  />


                                                                                    </td>
                                                                                    <td>
                                                                                        creation Date:

                                                                                    </td>
                                                                                    <td nowrap="true"><html:text property="createdDate" readonly="true"/>
                                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].createdDate,'dd/mm/yyyy')" src="images/tlsCalendarIcon.gif" />

                                                                                    </td>
                                                                                </tr>


                                                                            </table>
                                                                        <br>
                                                                         <html:button property="button"  value="submit the details" onclick="Traingdetailsave(this.form);" /> <html:reset property="reset"/>
                                                                        <html:hidden property="method"/>
                                                                    </html:form>



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
                    </table>
                </td>
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
	        		active: 3
	        	});
        	});

        </script>
    </body>

</html>
