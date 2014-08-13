
<%--
    Document   : addQuestions
    Created on : Oct 7, 2009, 3:06:42 AM
    Author     : Swarnendu Mukherjee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<script type="text/JavaScript">

    function hold(form){
        confirm("Do You Realy Want to hold the process !!");
        form.method.value="manageSetup";
        form.status.value="Hold";
        form.submit();
    }
    function activate(form)
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


<html:html>
    <html:base/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Appraisal Categories</title>
    </head>
    <%
	response.setHeader("Cache-Control","no-store"); //HTTP 1.1
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setDateHeader ("Expires", 0);
%>
    <body>
<jsp:include page="include/header.jsp" />
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
	<jsp:include page="include/menu.jsp" />
	</td>
    <td align="left" valign="top" bgcolor="#FFFFFF"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
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
        </table></td>
      </tr>
      <tr>
          <td><table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" class="box">
            <tr>
              <td width="10" class="box_left_bg"><img src="images/box_left_top_corner.jpg" width="10" height="10" /></td>
              <td class="box_top_bg">&nbsp;</td>
              <td width="11" align="right" valign="top" class="box_right_bg"><img src="images/box_right_top_corner.jpg" width="11" height="10" /></td>
            </tr>
            <tr>
              <td class="box_left_bg">&nbsp;</td>
              <td align="center" valign="middle"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td align="left" valign="top">
                       
<form action="manageAppraisal.do" method="post">
    <table align="left" >
                <tr><td colspan="2">
                        <table align="left" cellpadding="0" cellspacing="0" border="0" >
                                       <tr>
                                           <td colspan="3" align="center" height="10" valign="top">
                                           
                                         </td>
                                            </tr>
                                            <tr><td>
                                                    <table  cellpadding="0" cellspacing="0" border="0" align="center">
                                                        <tr bgcolor="goldenrod" align="center">

                                                            <td ><font color="white" ><b>Appraisal Type</b></font></td>
                                                            <td>&nbsp;&nbsp;</td>
                                                            <td><font color="white" ><b>Last Date</b></font></td>
                                                            <td>&nbsp;&nbsp;</td>
                                                            <td><font color="white" ><b>Initiated for the Department</b></font></td>
                                                            <td>&nbsp;&nbsp;</td>
                                                            <td><font color="white" ><b>Current Status</b></font></td>
                                                        </tr>
                                                        <logic:present name="appraisalsetup" scope="request">
                                                        <logic:iterate id="itr" name="appraisalsetup" indexId="counter">
                                                        <tr align="justify" bgcolor="<c:if test='${counter%2!=0}'>cornsilk</c:if><c:if test='${counter%2==0}'>white</c:if>">
                                                                <td><input type="checkbox"  name="id" value="<bean:write  name="itr" property="id"/>" />

                                                           <b> <bean:write  name="itr" property="category_name"/></b></td>
                                                            <td>&nbsp;&nbsp;</td>
                                                            <td><b><bean:write  name="itr" property="duration"/></b></td>
                                                            <td>&nbsp;&nbsp;</td>
                                                            <td align="center"><b><bean:write  name="itr" property="company_name"/></b></td>
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
                        <input type="button" value="Start Process" onclick="activate(this.form)"/>
                        <input type="button" value="Stop Process" onclick="stop(this.form)" />
                        <input type="button" value="Cancel" onclick="cancel(this.form)"/></td>
                </tr>
            </table>
        </form>
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
<jsp:include page="include/footer.jsp" />
</body>
</html:html>

