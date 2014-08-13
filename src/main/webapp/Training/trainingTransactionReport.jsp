<%-- 
    Document   : newjsp2
    Created on : Nov 18, 2010, 2:37:47 PM
    Author     : computer2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<html:base/>
<html:html lang="true">
    <head>

        <title>Training Master</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

		<script type="text/javascript" src="../js/jquery.1.9.12.js"></script>
        <script type="text/javascript" src="../js/jquery-ui.js"></script>
        <script type="text/javascript" src="../css/jquery-ui.css"></script>

        <script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>
        <script type="text/javascript" src="../js/calender/viewCalendar.js"> </script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>
        <script src="../js/scripts.js"></script>
        <script type="text/javascript">

            <%-- javascript add here --%>


            <%-- javascript add here --%>

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
               <td width="100%" colspan="3" align="left" valign="top"><img src="../images/Training.jpg" width="100%" height="138" /></td>
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
                                                    <td align="left" valign="top" style="text-align: center">

                                                        <h3>Employees Training Request</h3>
                                                        
                                                        <table border="1" align="center">
                                                            <tr>
                                                                <td align="left">
                                                                    <b>Training Name</b>
                                                                </td>

                                                                <td>
                                                                    <b>Employee Code</b>
                                                                </td>
                                                                <td align="left">
                                                                    <b>Employee Name</b>
                                                                </td>

                                                                <td>
                                                                    <b>Training From</b>
                                                                </td>
                                                                <td>
                                                                    <b>Training To</b>
                                                                </td>
                                                                <td>

                                                                    <a href="../trainingApprovalHOD.do?method=viewApprovedFrmHOD"><b>Add</b></a>

                                                                    <b> View </b>
                                                                </td>
                                                            </tr>
                                                            <logic:present name="trainingTransactions" scope="request">
                                                                <logic:iterate id="training" name="trainingTransactions" scope="request">
                                                                    <tr>
                                                                        <td align="left">

                                                                            <bean:write name="training" property="trainingName" />

                                                                        </td>
                                                                        <!-- Add new -->

                                                                        <td align="left">
                                                                            <bean:write name="training" property="employeeId" />
                                                                        </td>
                                                                        <td align="left">
                                                                            <bean:write name="training" property="employeeName" />
                                                                        </td>

                                                                        <td align="left">
                                                                            <bean:write name="training" property="fromDate" />
                                                                        </td>
                                                                        <td align="left">
                                                                            <bean:write name="training" property="toDate" />
                                                                        </td>
                                                                        <!-- Add new -->
                                                                        <td align="left">
                                                                            <a href="../trainingApprovalHOD.do?method=viewApprovedFrmHOD&trainingId=<bean:write name='training' property='trainingId' />&empId=<bean:write name='training' property='applyId' />&empName=<bean:write name='training' property='employeeName' />&requestId=<bean:write name='training' property='requestId' />">view</a>
                                                                        </td>
                                                                    </tr>
                                                                </logic:iterate>
                                                            </logic:present>
                                                        </table>
                                                        <%--Page load here --%>
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
        <script type="text/javascript">
        $(function() {
        	//loadAccordions();
	        	$( "#accrdins" ).accordion({
	        		collapsible: true,
	        		active: 3
	        	});
        	});

        </script>


        <style type="text/css">

            .applemenu{
                margin: 5px 0;
                padding: 0;
                width: 170px; /*width of menu*/
                border: 1px solid #9A9A9A;
            }

            .applemenu div.silverheader a{
                background: black url(../images/lightmaroon.png) repeat-x center left;
                font: normal 12px Tahoma, "Lucida Grande", "Trebuchet MS", Helvetica, sans-serif;
                color: white;
                display: block;
                position: relative; /*To help in the anchoring of the ".statusicon" icon image*/
                width: auto;
                padding: 5px 0;
                padding-left: 8px;
                text-decoration: none;
            }


            .applemenu div.silverheader a:visited, .applemenu div.silverheader a:active{
                color: white;
            }


            .applemenu div.selected a, .applemenu div.silverheader a:hover{
                background-image: url(../images/lightmaroon.png);
                color: white;
            }

            .applemenu div.submenu{ /*DIV that contains each sub menu*/
                                    background: white;
                                    padding: 5px;
                                    height: 300px; /*Height that applies to all sub menu DIVs. A good idea when headers are toggled via "mouseover" instead of "click"*/
                                    background-color: #CBCADF;
            }

        </style>
    </body>
</html:html>

