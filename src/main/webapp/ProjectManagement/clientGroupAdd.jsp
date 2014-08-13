<%-- 
    Document   : clientGroupAdd
    Created on : Nov 18, 2010, 8:39:17 PM
    Author     : computer2
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html lang="true">
    <head>
        <html:base/>
        <%@page  import="java.util.*" %>
        <title>Client Group Add</title>
        <script type="text/JavaScript">
            function Add(form){
                form.method.value="saveOrEdit";
                   if(!checkBlank(form.gr_code,'gr_code'))
                {
                    return;
                }
                 if(!checkBlank(form.gr_name,'gr_name'))
                {
                    return;
                }
                 if(!checkBlank(form.gr_description,'gr_description'))
                {
                    return;
                }
              
                //alert(form.method.value);
                form.submit();

            }
            function loadData(form){

                form.method.value="load";

                form.submit();
            }

        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
<link href="../css/inner_page_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.1.9.12.js"></script>
        <script type="text/javascript" src="../js/jquery-ui.js"></script>
        <script type="text/javascript" src="../css/jquery-ui.css"></script>

        <script src="../js/scripts.js"></script>

        <script type="text/javascript">

            

        </script>
        <style type="text/css">
            <!--
            .style2 {
                font-size: 14px;
                color: #993333;
            }
            -->
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
                <td width="100%" colspan="3" align="left" valign="top"><img src="../images/ProjectMangement.jpg" width="100%" height="138" /></td>
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

                                                        <html:form action="clientgroup.do" method="get" >
                                                            <table width="80%" border="0" align="left" cellpadding="2" cellspacing="4">
                                                                <tr>
                                                                    <td align="left" valign="top" colspan="2"><div id="errorMsg" ></div>

                                                                        <logic:messagesPresent message="true">

                                                                            <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                        </logic:messagesPresent>
                                                                        <logic:messagesPresent >

                                                                            <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                        </logic:messagesPresent >

                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td height="55" colspan="4" align="center" valign="middle"><span class="normal_black_text" style="font-weight: bold">Set Client Group:</span><span class="normal_black_text" style="font-weight: bold"></span></td>
                                                                    <td>&nbsp;</td>
                                                                    <td>&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Client Group Code: </td>

                                                                    <td  align="left" valign="middle">
                                                                        <html:text property="gr_code" /></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Client Group Name:: </td>
                                                                    <td align="left" valign="middle"><html:text  property="gr_name"/></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Client Group Description:</td>
                                                                    <td align="left" valign="middle"><html:textarea  property="gr_description" rows="5"/> </td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="center" valign="middle"><html:button property="button" value="Submit"  onclick = "Add(this.form)"/>
                                                                        <html:hidden property="method"/></td>

                                                                    <td colspan="3" align="right" valign="middle"></td>
                                                                </tr>
                                                                <tr>
                                                                    <%--<td colspan="4" align="right" valign="middle">  <html:link href="../loadclientGroupEdit.do?method=load"><span class="style2">Change ClientGroup Information</span></html:link></td>--%>
                                                                </tr>
                                                            </table>
                                                        </html:form> </td>
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
        <script type="text/javascript">

        $(function() {
        	//loadAccordions();
	        	$( "#accrdins" ).accordion({
	        		collapsible: true,
	        		active: 2
	        	});
        	});
        </script>
    </body>
</html:html>

