<%-- 
    Document   : ModifyGoals
    Created on : Feb 21, 2011, 5:05:42 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS :: Recruitment Apply Form</title>
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />
        <script type="text/javascript" src="js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="js/HRMS.js"></script>

        <script type="text/javascript">

            function modify(form)
            {
                form.method.value="saveModifiedGoals";
                  if(!checkBlank(form.goalId,'goal id'))
                {
                    return;
                }
                   if(!checkBlank(form.goalDesc,'goal desscription'))
                {
                    return;
                }
                 if(!checkBlank(form.priority,'priorty desscription'))
                {
                    return;
                }
                if(!checkBlank(form.probableCompletionDate,'probable complete date'))
                {
                    return;
                }
                 if(!checkBlank(form.relatedOrgObjective,'org objective'))
                {
                    return;
                }
                if(!checkBlank(form.newSkillsAcquired,'newSkillsAcquired'))
                {
                    return;
                }
                form.submit();
            }
            function loadDetails(form){
                form.method.value="loadGoalDetails";
                form.submit();
            }
           function closegoal(form){
               form.method.value="closeGoal";
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
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/banner.jpg" width="100%" height="138" /></td>
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

                                                        <html:form action="modifyGoals.do" >

                                                            <table width="761" border="0" cellspacing="0" cellpadding="0">
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
                                                                    <td class="body_top">&nbsp;&nbsp;&nbsp; </td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="body_mid" style="padding:0 0 0 5px;" valign="bottom">
                                                                        <fieldset>
                                                                            <legend>Modify Goals</legend>
                                                                            <table width="80%" border="0" cellspacing="4" cellpadding="2" >
                                                                                <tr>
                                                                                    <td colspan="2" nowrap="nowrap"><span class="normal_black_text" style="font-weight: bold">Fill Up all Mandatory fields(</span><span class="normal_black_text"><span class="style3">*</span></span><span class="normal_black_text" style="font-weight: bold">):- </span></td>
                                                                                    <td width="30%" nowrap="nowrap"></td>
                                                                                    <td width="13%" nowrap="nowrap">&nbsp;</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td >Goal Title:  </td>
                                                                                    <td>
                                                                                        <html:select property="goalId">
                                                                                            <html:option value="">--Select--</html:option>
                                                                                            <logic:present name="goals">
                                                                                                <html:options collection="goals" labelProperty="goalTitle" property="goalId"/>
                                                                                            </logic:present>
                                                                                        </html:select>
                                                                                            <html:button property="button" value="Load" onclick="loadDetails(this.form)"/>
                                                                                    </td>
                                                                                    <td colspan="2"></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td width="31%" align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Goal Description  : </td>
                                                                                    <td width="29%" align="left" valign="middle" nowrap="nowrap" colspan="3"><html:textarea property="goalDesc"  cols="40" /></td>
                                                                                    <html:hidden property="goalTitle"/>
                                                                                    <html:hidden property="currentStatus"/>
                                                                                    <html:hidden property="employeeId"/>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Priority :</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">
                                                                                        <html:select property="priority">
                                                                                            <html:option value="">--Select--</html:option>
                                                                                            <html:option value="1">Highest</html:option>
                                                                                            <html:option value="2">Higher</html:option>
                                                                                            <html:option value="3">Above Normal</html:option>
                                                                                            <html:option value="4">Normal</html:option>
                                                                                            <html:option value="5">Below Normal</html:option>
                                                                                            <html:option value="6">Lower</html:option>
                                                                                            <html:option value="7">Lowest</html:option>
                                                                                        </html:select>
                                                                                    </td>
                                                                                    <td align="right" valign="middle" nowrap="nowrap"><span class="style3">*</span>Goal Set Date:</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"><html:text property="goalSetDate" readonly="true"  />
                                                                                        </td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Probable Completion Date :</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"><html:text property="probableCompletionDate" readonly="true"/>
                                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].probableCompletionDate,'dd/mm/yyyy')" src="images/tlsCalendarIcon.gif" />
                                                                                     </td>
                                                                                    <td align="right" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"> <span class="style3">*</span>Related Organization Objectives: </td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap" colspan="3">
                                                                                        <html:textarea property="relatedOrgObjective"  cols="40"  />							  </td>
                                                                                   
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>New  Skills Acquired :</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap" colspan="3">
                                                                                        <html:textarea property="newSkillsAcquired"  cols="40"/>
                                                                                    </td>
                                                                                </tr>
                                                                                
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"><table width="30%" border="0" align="left" cellpadding="0" cellspacing="0">
                                                                                            <tr>
                                                                                                <td align="right" valign="middle">
                                                                                                    <%--    <html:button property="button" value="Submit"  onclick="return addRec(this.form)" styleClass="submitButton"/> --%>
                                                                                                    <html:button property="button" value="Submit"  onclick="return modify(this.form)" />
                                                                                                </td>
                                                                                                <td width="4" align="left" valign="middle">
                                                                                                    <html:button property="button" value="Goal Achieved" onclick="return closegoal(this.form)"/>
                                                                                                </td>
                                                                                                <td align="left" valign="middle">
                                                                                                    <%--   <html:reset property="Reset" value="Clear" styleClass="resetButton" /> --%>
                                                                                                    <html:reset  value="Clear" />
                                                                                                </td>
                                                                                            </tr>
                                                                                        </table></td>
                                                                                    <td align="right" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                </tr>
                                                                            </table>

                                                                        </fieldset>

                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="body_bottom">&nbsp;</td>
                                                                </tr>
                                                            </table>
                                                            <html:hidden property="method"/>
                                                        </html:form>

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
    </body>
</html:html>
