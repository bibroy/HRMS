<%-- 
    Document   : clientAdd
    Created on : Nov 22, 2010, 2:31:19 PM
    Author     : computer2
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html lang="true">
    <head>
        
        <%@page  import="java.util.*" %>

        <script type="text/JavaScript">
            function Add(form){
                form.method.value="saveOrEdit";
                 if(!checkBlank(form.gr_master_id,'gr_master_id'))
                {
                    return;
                }
                 if(!checkBlank(form.clientCode,'clientCode'))
                {
                    return;
                }
                 if(!checkBlank(form.clientName,'clientName'))
                {
                    return;
                }
                if(!checkBlank(form.contactPerson,'contactPerson'))
                {
                    return;
                }
                 if(!checkBlank(form.address,'address'))
                {
                    return;
                }
                 if(!checkBlank(form.phone,'phone'))
                {
                    return;
                }
                 if(!checkBlank(form.email,'email'))
                {
                    return;
                }
                 if(!checkEmail(form.email,'email'))
                {
                    return;
                }
                if(!checkPhnNo(form.phone,'phone'))
                {
                    return;
                }
                   if(!checkAddress(form.address,'address'))
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
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />


        <script src="js/scripts.js"></script>

        <style type="text/css">
            <!--
            .style1 {
                color: #804040;
                font-size: 14px;
                font-weight: bold;
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
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/ProjectMangement.jpg" width="100%" height="138" /></td>
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
                                                        <html:form action="clientadd">
                                                            <table width="80%" border="0" align="left" cellpadding="2" cellspacing="4">

                                                                <tr>
                                                                    <td align="left" valign="top" colspan="2"><div id="errorMsg" ></div>

                                                                        <logic:messagesPresent message="true">

                                                                            <font color="green"> <b><img src="images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                        </logic:messagesPresent>
                                                                        <logic:messagesPresent >

                                                                            <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                        </logic:messagesPresent >

                                                                    </td>
                                                                </tr>

                                                                <tr>
                                                                    <td height="55" colspan="4" align="center" valign="middle"><span class="normal_black_text" style="font-weight: bold"> Client SetUp</span><span class="normal_black_text" style="font-weight: bold"></span></td>
                                                                    <td>&nbsp;</td>
                                                                    <td>&nbsp;</td>
                                                                </tr>
                                                                
                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Select Client Group: </td>

                                                                    <td  align="left" valign="middle">
                                                                        <html:select property="gr_master_id">
                                                                            <html:option value="">--Select Please--</html:option>
                                                                            <logic:present name="clientGrp" scope="request">
                                                                                <html:options collection="clientGrp" labelProperty="grName" property="grId" />
                                                                            </logic:present>
                                                                        </html:select>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Client Code : </td>

                                                                    <td  align="left" valign="middle">
                                                                        <html:text property="clientCode" /></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Client Name:</td>
                                                                    <td align="left" valign="middle"><html:text  property="clientName"/></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Contact Person:</td>
                                                                    <td align="left" valign="middle"><html:text  property="contactPerson"/> </td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Address:</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:text  property="address"/> </td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Phone No:</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:text  property="phone"/> </td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Mobile No:</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:text  property="mobile"/> </td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Fax:</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:text  property="fax"/> </td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Email:</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:text  property="email"/> </td>
                                                                </tr>


                                                                <tr>
                                                                    <td align="left" valign="middle">                   </td>

                                                                    <td colspan="3" align="left" valign="middle"></td>
                                                                </tr>


                                                                <tr>
                                                                    <td align="center" valign="middle"><html:button property="button" value="Save" onclick = "Add(this.form)"/>
                                                                        <html:hidden property="method"/>                   </td>

                                                                    <td colspan="3" align="left" valign="middle"></td>
                                                                </tr>

                                                                <tr>
                                                                    <td colspan="4" align="right" valign="middle"><html:link href="../loadclientedit.do?method=load"><span class="style1">Edit Client Setup</span></html:link> </td>
                                                                </tr>
                                                            </table>
                                                        </html:form></td>
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
	        		active: 2
	        	});
        	});
        </script>
    </body>
</html:html>

