<%-- 
    Document   : AddBranches
    Created on : Jan 23, 2011, 2:24:40 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Branches</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

        <script type="text/javascript" src="../js/accordion/javascript/prototype.js"></script>
        <script type="text/javascript" src="../js/accordion/javascript/effects.js"></script>
        <script type="text/javascript" src="../js/accordion/javascript/accordion.js"></script>
        <script type="text/javascript" src="../js/scripts.js"></script>
        <script type="text/javascript" src="../js/JQuery.js"></script>
        <script type="text/javascript" src="../js/ajaxpagefetcher.js"></script>


        <script type="text/javascript">
            function create(form)
            {
                form.method.value="addBranch";
                 if(!checkBlank(form.companyId,'companyId'))
                {
                    return;
                }
                 if(!checkBlank(form.branchName,'branchName'))
                {
                    return;
                }
                 if(!checkBlank(form.contactNumber,'contactNumber'))
                {
                    return;
                }
                   if(!checkBlank(form.branchemail,'branchemail'))
                {
                    return;
                }
                  if(!checkBlank(form.branchAddress,'branchAddress'))
                {
                    return;
                }
                  if(!checkBlank(form.branchType,'branchType'))
                {
                    return;
                }
                  if(!checkBlank(form.branchCountryid,'branchCountryid'))
                {
                    return;
                }
                     if(!checkBlank(form.branchCityid,'branchCityid'))
                {
                    return;
                }
                if(!checkPhnNo(form.contactNumber,'contactNumber'))
                {
                    return;
                }
                   if(!checkEmail(form.branchemail,'branchemail'))
                {
                    return;
                }
                  if(!checkAddress(form.branchAddress,'branchAddress'))
                {
                    return;
                }
                form.submit();
            }
            function loadcity(sel)
            {
                var cont=sel.value;
                var add="loadBranchCity.do?method=loadBranchCity&branchCountryid="+cont;
                ajaxpagefetcher.load("city", add, true);
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
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/Company.jpg" width="100%" height="138" /></td>
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

                                                        <fieldset><legend>Add New Branch</legend>
                                                            <html:form action="createBranch">
                                                                <table border="0" cellpadding="5" cellspacing="0" style="text-align: left">
                                                                    <tr>
                                                                        <td colspan="2">
                                                                            <logic:messagesPresent message="true">

                                                                                <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                            </logic:messagesPresent>
                                                                            <logic:messagesPresent >

                                                                                <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                            </logic:messagesPresent >
                                                                        </td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="2" nowrap="nowrap"><span class="normal_black_text" style="font-weight: bold">Fill Up all Mandatory fields(</span><span class="normal_black_text"><span class="style3">*</span></span><span class="normal_black_text" style="font-weight: bold">):- </span></td>
                                                                        <td width="30%" nowrap="nowrap"></td>
                                                                        <td width="13%" nowrap="nowrap">&nbsp;</td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><span class="style3">*</span>Company Name:</td>
                                                                        <td>
                                                                            <html:select property="companyId">
                                                                                <html:option value="">-- Select --</html:option>
                                                                                <logic:present name="compList" scope="request">
                                                                                    <html:options collection="compList" labelProperty="companyName" property="companyCode"/>
                                                                                </logic:present>
                                                                            </html:select>
                                                                        </td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><span class="style3">*</span>Branch Name : </td>
                                                                        <td>
                                                                            <html:text property="branchName" />
                                                                        </td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td nowrap><span class="style3">*</span>Branch Contact No.: </td>
                                                                        <td>
                                                                            <html:text property="contactNumber"/>
                                                                        </td>
                                                                        <td nowrap>Fax Number :</td>
                                                                        <td align="left"><html:text property="branchfax"/></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td nowrap><span class="style3">*</span>Branch Email Id : </td>
                                                                        <td nowrap><html:text property="branchemail"/></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><span class="style3">*</span>
                                                                            Branch Address:
                                                                        </td>
                                                                        <td>
                                                                            <html:textarea property="branchAddress" rows="6"/>
                                                                        </td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>                                                                    
                                                                    <tr>
                                                                        <td><span class="style3">*</span>Branch Type:</td>
                                                                        <td>
                                                                            <html:text property="branchType"/>
                                                                        </td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><span class="style3">*</span>Country :</td>
                                                                        <td>
                                                                            <html:select property="branchCountryid" onchange="loadcity(this);">
                                                                                <html:option value="">--Select--</html:option>
                                                                                <logic:present name="country" scope="request">
                                                                                    <html:options collection="country" labelProperty="countryName" property="countryId"/>
                                                                                </logic:present>
                                                                            </html:select>
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><span class="style3">*</span>Origin City: </td>
                                                                        <td id="city" colspan="3">
                                                                            <table>
                                                                                <tr>
                                                                                    <td>
                                                                                        <html:select property="branchCityid">
                                                                                            <html:option value="">--Select--</html:option>
                                                                                        </html:select>
                                                                                    </td>
                                                                                    <td>
                                                                                        Currency:
                                                                                    </td>
                                                                                    <td>
                                                                                        <input type="text" value="" name="currency" readonly="true" />
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <html:button property="button" value="Submit" onclick="create(this.form);"/>
                                                                        </td>
                                                                        <td>
                                                                            <html:reset value="Reset"/>
                                                                        </td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>
                                                                </table>
                                                                <html:hidden property="method"/>
                                                            </html:form>
                                                        </fieldset>
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

