<%-- 
    Document   : AddCompanyToGroup
    Created on : Jan 22, 2011, 12:46:39 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Company To Group</title>
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
                form.method.value="addGrCompany";
                     if(!checkBlank(form.grcompanyId,'grcompanyId'))
                {
                    return;
                }
                 if(!checkBlank(form.companyName,'companyName'))
                {
                    return;
                }
                if(!checkBlank(form.contactNo,'contactNo'))
                {
                    return;
                }
                  if(!checkBlank(form.regaddress,'regaddress'))
                {
                    return;
                }

                if(!checkBlank(form.corptaddress,'corptaddress'))
                {
                    return;
                }
                 if(!checkBlank(form.businessNature,'businessNature'))
                {
                    return;
                }
                if(!checkBlank(form.companyTypeId,'companyTypeId'))
                {
                    return;
                }
                    if(!checkBlank(form.countryOriginId,'countryOriginId'))
                {
                    return;
                }
                if(!checkBlank(form.cityId,'cityId'))
                {
                    return;
                }
                 if(!checkBlank(form.finstartyear,'finstartyear'))
                {
                    return;
                }
                   if(!checkBlank(form.finstartyear,'finendyear'))
                {
                    return;
                }
                  if(!checkPhnNo(form.contactNo,'contactNo'))
                {
                    return;
                }
                 if(!checkAddress(form.regaddress,'regaddress'))
                {
                    return;
                }
                if(!checkAddress(form.corptaddress,'corptaddress'))
                {
                    return;
                }
                form.submit();
            }
            function loadcity(sel)
            {
                var cont=sel.value;
                var add="loadCity.do?method=loadCity&countryOriginId="+cont;
                ajaxpagefetcher.load("city", add, true);
            }
            function copy()
            {
                var ra=document.forms[0].regaddress.value;

                if((ra!=null)||(ra!=""))
                {
                    document.forms[0].corptaddress.value=ra;
                }
                else
                {
                    alert("Please fill into the Registered Address first");
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

                                                        <fieldset><legend>Add a new company to group company</legend>
                                                            <html:form action="/createcompany.do">
                                                                <table border="0" cellpadding="5" cellspacing="0" style="text-align: left">
                                                                    <tr>
                                                                        <td colspan="2">
                                                                            <logic:messagesPresent message="true">

                                                                                <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                            </logic:messagesPresent>
                                                                            <logic:messagesPresent>

                                                                                <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                            </logic:messagesPresent>
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
                                                                        <td nowrap><span class="style3">*</span>Group Company Name :</td>
                                                                        <td>
                                                                            <html:select property="grcompanyId">
                                                                                <html:option value="">--Select--</html:option>
                                                                                <logic:present name="compList" scope="request">
                                                                                    <html:options collection="compList" labelProperty="companyName" property="companyCode"/>
                                                                                </logic:present>
                                                                            </html:select>
                                                                        </td>
                                                                        <td colspan="2"></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><span class="style3">*</span>Company Name:</td>
                                                                        <td>
                                                                            <html:text property="companyName"/>
                                                                        </td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><span class="style3">*</span>Company Contact No.: </td>
                                                                        <td>
                                                                            <html:text property="contactNo"/>
                                                                        </td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="2">
                                                                            <table>
                                                                                <tr>
                                                                                    <td><span class="style3">*</span>Registered Address</td>
                                                                                    <td></td>
                                                                                    <td><span class="style3">*</span>Corporate Address </td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>
                                                                                        <html:textarea property="regaddress" rows="6"/>
                                                                                    </td>
                                                                                    <td>
                                                                                        <input type="button" value=">>" onclick="copy();"/>
                                                                                    </td>
                                                                                    <td>
                                                                                        <html:textarea property="corptaddress" rows="6"/>
                                                                                    </td>
                                                                                </tr>

                                                                            </table>
                                                                        </td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><span class="style3">*</span>Nature of Business:</td>
                                                                        <td>
                                                                            <html:text property="businessNature"/>
                                                                        </td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><span class="style3">*</span>Company Type:</td>
                                                                        <td>
                                                                            <html:select property="companyTypeId">
                                                                                <html:option value="1">Single Company</html:option>
                                                                                <html:option value="2">Group Company</html:option>
                                                                            </html:select>
                                                                        </td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><span class="style3">*</span>Origin Country:</td>
                                                                        <td>
                                                                            <html:select property="countryOriginId" onchange="loadcity(this);">
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
                                                                                        <html:select property="cityId">
                                                                                            <html:option value="">--Select--</html:option>
                                                                                        </html:select>
                                                                                    </td>
                                                                                    <td>
                                                                                        Currency:
                                                                                    </td>
                                                                                    <td>
                                                                                        <input type="text" value="" readonly="true" />
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><span class="style3">*</span>Financial Year Start:  </td>
                                                                        <td>
                                                                            <html:select property="finstartyear">
                                                                                <html:option value="">..select please..</html:option>
                                                                                <html:option value="Jan">Jan</html:option>
                                                                                <html:option value="Feb">Feb</html:option>
                                                                                <html:option value="Mar">Mar</html:option>
                                                                                <html:option value="Apr">Apr</html:option>
                                                                                <html:option value="May">May</html:option>
                                                                                <html:option value="Jun">Jun</html:option>
                                                                                <html:option value="Jul">Jul</html:option>
                                                                                <html:option value="Aug">Aug</html:option>
                                                                                <html:option value="Sep">Sep</html:option>
                                                                                <html:option value="Oct">Oct</html:option>
                                                                                <html:option value="Nov">Nov</html:option>
                                                                                <html:option value="Dec">Dec</html:option>
                                                                            </html:select>
                                                                        </td>
                                                                        <td><span class="style3">*</span>Financial Year End: </td>
                                                                        <td>
                                                                            <html:select property="finendyear">
                                                                                <html:option value="">..select please..</html:option>
                                                                                <html:option value="Jan">Jan</html:option>
                                                                                <html:option value="Feb">Feb</html:option>
                                                                                <html:option value="Mar">Mar</html:option>
                                                                                <html:option value="Apr">Apr</html:option>
                                                                                <html:option value="May">May</html:option>
                                                                                <html:option value="Jun">Jun</html:option>
                                                                                <html:option value="Jul">Jul</html:option>
                                                                                <html:option value="Aug">Aug</html:option>
                                                                                <html:option value="Sep">Sep</html:option>
                                                                                <html:option value="Oct">Oct</html:option>
                                                                                <html:option value="Nov">Nov</html:option>
                                                                                <html:option value="Dec">Dec</html:option>
                                                                            </html:select>
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

