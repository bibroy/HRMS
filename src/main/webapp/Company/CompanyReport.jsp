<%-- 
    Document   : CompanyReport
    Created on : Nov 27, 2010, 4:34:25 PM
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
        <title>HRMS :: Company Report</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

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

                                                        <table width="761" border="0" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td class="body_top">&nbsp;</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="body_mid" style="padding:0 0 0 5px;" valign="top">
                                                                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
                                                                        <tr>
                                                                            <td width="7%" height="33" align="center" valign="middle" bgcolor="#B27138" class="menu_bg">Company Id</td>
                                                                            <td width="6%" align="center" valign="middle" bgcolor="#8A4117" class="menu_bg">  Company Name </td>
                                                                            <td width="9%" align="center" valign="middle" bgcolor="#B27138" class="menu_bg"> Reg Address </td>
                                                                            <td width="6%" align="center" valign="middle" bgcolor="#B27138" class="menu_bg">Nature of Business </td>
                                                                        </tr>

                                                                        <logic:present name="compList" scope="request">
                                                                            <logic:iterate id="itr" name="compList" indexId="no">
                                                                                <html:form action="ViewAllLoanApplicationDetails" >
                                                                                    <tr bgcolor="<c:if test="${no%2!=0}" >cornsilk</c:if><c:if test="${no%2==0}" >white</c:if>">

                                                                                        <td align="center">
                                                                                            <bean:write name="itr" property="companyCode" ></bean:write>
                                                                                        </td>

                                                                                        <td align="center">
                                                                                            <bean:write name="itr" property="companyName" ></bean:write>

                                                                                        </td>

                                                                                        <td align="center">
                                                                                            <bean:write name="itr" property="regaddress"></bean:write>
                                                                                        </td>

                                                                                        <td align="center">
                                                                                            <bean:write name="itr" property="natureOfBusiness"></bean:write>
                                                                                        </td>
                                                                                    </tr>
                                         
                                                                        <html:hidden property="method"/>
                                                                    </html:form>
                                                                </logic:iterate>
                                                            </logic:present>
                                                        </table>

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
