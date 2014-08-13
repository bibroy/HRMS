<%-- 
    Document   : clientEdit
    Created on : Nov 22, 2010, 3:06:56 PM
    Author     : computer2
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <html:base/>
        <title>HOME</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />


        <script type="text/javascript" src="../js/accordion/javascript/prototype.js"></script>
        <script type="text/javascript" src="../js/accordion/javascript/effects.js"></script>
        <script type="text/javascript" src="../js/accordion/javascript/accordion.js"></script>

        <script src="js/scripts.js"></script>

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
            function Edit(form){
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
                if(!checkBlank(form.status,'status'))
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
                //alert();

                form.method.value="load";

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
                                                        <html:form action="/clientedit.do" method="get">

                                                            <table width="787" height="98" border="0" style="border-bottom:solid 1px">

                                                                <tr bgcolor="#B35900">
                                                                    <td width="59" height="39">
                                                                        <font color="#FFFFFF" size="3">Change Option </font> </td>
                                                                    <td width="192" align="center">
                                                                        <font color="#FFFFFF" size="3">ClientName</font></td>
                                                                    <td width="108" align="center">
                                                                        <font color="#FFFFFF" size="3">ContactPerson</font></td>
                                                                    <td width="92" align="center">
                                                                        <font color="#FFFFFF" size="3">Email</font></td>
                                                                    <td width="51" align="center">
                                                                        <font color="#FFFFFF" size="3">Fax</font></td>
                                                                    <td width="56" align="center">
                                                                        <font color="#FFFFFF" size="3">Mobile</font></td>
                                                                    <td width="52" align="center">
                                                                        <font color="#FFFFFF" size="3">Phone</font></td>
                                                                    <td width="130" align="center">
                                                                        <font color="#FFFFFF" size="3">Address</font></td>

                                                                </tr>

                                                                <logic:present name="client" scope="request">
                                                                    <logic:iterate id="itr" name="client" indexId="no">
                                                                        <tr bgcolor="<c:if test="${no%2!=0}" >#FFCC66</c:if><c:if test="${no%2==0}" >#CE8160</c:if>" align="center">
                                                                            <td>
                                                                                <input type="checkbox" name="clid" value="<bean:write name="itr" property="clId"></bean:write>" Id="<c:out value="no"/>" onclick="loadData(this.form)" />

                                                                            </td>
                                                                            <td><font size="2"><bean:write name="itr" property="clientName"></bean:write></font></td>
                                                                            <td><font size="2"><bean:write name="itr" property="contactPerson"></bean:write></font></td>
                                                                            <td><font size="2"><bean:write name="itr" property="email"></bean:write></font></td>
                                                                            <td><font size="2"><bean:write name="itr" property="fax"></bean:write></font></td>
                                                                            <td><font size="2"><bean:write name="itr" property="mobile"></bean:write></font></td>
                                                                            <td><font size="2"><bean:write name="itr" property="phone"></bean:write></font></td>
                                                                            <td width="9"><font size="2">
                                                                                    <bean:write name="itr" property="address"></bean:write></font></td>

                                                                        </tr>
                                                                    </logic:iterate>
                                                                </logic:present>

                                                            </table>

                                                            <table width="80%" border="0" align="left" cellpadding="2" cellspacing="4" style="top: 454px; left: 545px;">

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
                                                                        </html:select></td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Client Name:</td>
                                                                    <td align="left" valign="middle"> <html:select property="clid" onchange="loadData(this.form)">

                                                                            <html:option value="">--Select Please--</html:option>
                                                                            <logic:present name="client" scope="request">
                                                                                <html:options collection="client" labelProperty="clientName" property="clId" />
                                                                            </logic:present>

                                                                        </html:select></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Client Code : </td>

                                                                    <td  align="left" valign="middle">
                                                                        <html:text property="clientCode" /></td>
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
                                                                    <td align="left" valign="middle" nowrap="nowrap">Status: </td>
                                                                    <td align="left" valign="middle">
                                                                        <html:select property="status" >
                                                                            <html:option value="">-Select-</html:option>
                                                                            <html:option value="E">Enable</html:option>
                                                                            <html:option value="D">Disable</html:option>
                                                                        </html:select></td>
                                                                </tr>


                                                                <tr>
                                                                    <td colspan="4" align="center" valign="middle"><html:button property="button" value="Save" onclick = "Edit(this.form)"/>
                                                                        <html:hidden property="method"/>                   </td>
                                                                </tr>
                                                            </table>
                                                        </html:form>

                                                    </td>										    </tr>
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
</html:html>

