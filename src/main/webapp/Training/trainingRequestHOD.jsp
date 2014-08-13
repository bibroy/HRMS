<%-- 
    Document   : trainingRequestHOD
    Created on : Nov 16, 2010, 2:12:58 PM
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
  <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />


        <script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>
        <script type="text/javascript" src="../js/calender/viewCalendar.js"> </script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>
        <script  type="text/javascript" src="../js/scripts.js"></script>
        <title>Training Request HOD</title>

        <script type="text/javascript">

            <%-- javascript add here --%>

            function addTraining(form){
                form.method.value="addTrainingHOD";
                alert(form.method.value);
                if(chkAllFields(form)){
                    form.submit();
                }else{
                    return false;
                }
            }
            function winRefresh(form){
                //---window.location.href="./trainingRequestHOD.do?method=reqFromHOD";
                // === window.location.href="./login.do?method=hrmsLogin";
                // === return false;
                form.method.value="menuPage";
                // === alert("after set");
                form.submit();
            }
            /*** ajax implimentation ***/

            function desSelState(sel){
                //alert("--- value ---"+sel.options[sel.selectedIndex].value);
                var skilId=sel.options[sel.selectedIndex].value;
                if(sel.options.selectedIndex == 0){
                    window.alert('Please choose an option as Country');
                    return false;
                }
                var add="../loadTraining.do?method=trainingList&skillId="+skilId;
                //document.location.href=add;
                //alert("$$$"+add);
                ajaxpagefetcher.load('training',add,true);
            }
            /***
             *get skills through ajax call
             */
            function desSkills(sel){

                var typeId=sel.options[sel.selectedIndex].value;
                var add="../loadSkills.do?method=showSkillsAgainstJobType&typeId="+typeId;
                ajaxpagefetcher.load('skillTypes',add,true);
            }
            /*** ajax implimentation ***/
            /***
             * Check all fields
             */
            function chkAllFields(form){

                //alert("@@ Employee name  @@"+form.ddlEmployees.selectedIndex);
                //return false;


                //else if(!checkOption(form.ddlEmployees,'Employee Name'))

                if(form.ddlEmployees.selectedIndex==-1){
                    alert("Employee Name cannot be blank");
                    return false;
                }
                else if(!checkOption(form.ddlSkillsName,' Skill Type')){
                    return false;
                }
                else if(!checkOption(form.jobType,' Job Type')){
                    return false;
                }
                else if(!checkOption(form.ddlTrainingName,' Training Name')){
                    return false;
                }
                else if(!checkBlank(form.availableFrom,' Available From')){
                    return false;
                }
                else if(!checkBlank(form.availableTo,' Available To')){
                    return false;
                }
                else if(!dateDifference(form)){
                    return false;
                }
                else{
                    return true;
                }
            }
            /***
             * Check all fields
             */

            /***
             * Check all fields
             */
            /***
             * Check date diffrence
             */

            function dateDifference(form){

                var frm_date=document.forms[0].availableFrom.value;
                var end_date=document.forms[0].availableTo.value;
                frm_date=frm_date.split("/");
                frm_date=frm_date[2]+frm_date[1]+frm_date[0];
                end_date=end_date.split("/");
                end_date=end_date[2]+end_date[1]+end_date[0];

                if (frm_date > end_date)
                {
                    alert("Start date cannot be greater than Due date");
                    document.forms[0].availableFrom.focus();
                    return false;
                }
                else{
                    return true;
                }
            }

            /***
             * Check datediffrence
             */

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
                                                    <td align="left" valign="top">


                                                                                                <html:form action="/trainingRequestHOD">
                                                                                                    <table class="AwordText">
                                                                                                        <tr>
                                                                                                            <td width="1%">&nbsp;</td>
                                                                                                            <td width="99%">

                                                                                                                <logic:messagesPresent message="true">
                                                                                                                    <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>                                    </logic:messagesPresent>
                                                                                                                        <logic:messagesPresent >
                                                                                                                            <html:messages id="error"><bean:write name="error"/></html:messages>
                                                                                                                        </logic:messagesPresent >
                                                                                                                <div id="errorMsg" ></div>

                                                                                                            </td>
                                                                                                            <td width="0%">&nbsp;</td>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <td colspan="2" align="left"><span class="normal_black_text" style="font-weight: bold">Fill Up all Mandatory fields(</span><span class="normal_black_text"><span class="style3">*</span></span><span class="normal_black_text" style="font-weight: bold">):- </span></td>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <td valign="top" nowrap="nowrap">
                                                                                                                Employee Name
                                                                                                            </td>
                                                                                                            <td valign="middle" align="left">

                                                                                                                <html:select property="ddlEmployees" size="3"   multiple="true" indexed="empId">
                                                                                                                    <logic:present name="employees" scope="request">
                                                                                                                        <html:options collection="employees" property="empId" labelProperty="empName" />
                                                                                                                    </logic:present>
                                                                                                                </html:select>

                                                                                                            </td>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <td valign="middle" nowrap="nowrap">
                                                                                                                Department
                                                                                                            </td>
                                                                                                            <td valign="middle" align="left">
                                                                                                                <bean:write name="TrainingTransactionForm" property="departmentName"/>
                                                                                                            </td>
                                                                                                        </tr>

                                                                                                        <tr>
                                                                                                            <td valign="middle" nowrap="nowrap"><span class="style3">*</span>JobType</td>
                                                                                                            <td valign="middle" align="left">
                                                                                                                <html:text property="department" />
                                                                                                                <html:select property="jobType" onchange="return desSkills(this)" indexed="jobId" >
                                                                                                                    <html:option value="" >-Select-</html:option>
                                                                                                                    <logic:present name="jobTypes" scope="request">
                                                                                                                        <html:options collection="jobTypes" property="typeId" labelProperty="jobname" />
                                                                                                                    </logic:present>
                                                                                                                </html:select>
                                                                                                            </td>
                                                                                                        </tr>

                                                                                                        <tr>
                                                                                                            <td valign="middle" nowrap="nowrap"><span class="style3">*</span>Skill Set</td>
                                                                                                            <td id="skillTypes" valign="middle" align="left">
                                                                                                                <html:select property="ddlSkillsName" onchange="return desSelState(this)" indexed="skillId">
                                                                                                                    <html:option value="" >-Select-</html:option>
                                                                                                                    <logic:present name="skills" scope="request">
                                                                                                                        <html:options collection="skills" property="skillId" labelProperty="skillName" />
                                                                                                                    </logic:present>
                                                                                                                </html:select>
                                                                                                            </td>
                                                                                                        </tr>

                                                                                                        <tr>
                                                                                                            <td valign="middle" nowrap="nowrap"><span class="style3">*</span>
                                                                                                                Training Name
                                                                                                            </td>
                                                                                                            <td id="training" valign="middle" align="left">
                                                                                                                <html:select property="ddlTrainingName" indexed="trainingId">
                                                                                                                    <html:option value="select">-Select-</html:option>
                                                                                                                    <logic:present name="trainings" scope="request">
                                                                                                                        <html:options collection="trainings" property="trainingId" labelProperty="trainingName"/>
                                                                                                                    </logic:present>
                                                                                                                </html:select>
                                                                                                            </td>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <td valign="middle" nowrap="nowrap"><span class="style3">*</span>
                                                                                                                Available From
                                                                                                            </td>
                                                                                                            <td valign="middle" align="left">
                                                                                                                <html:text property="availableFrom" indexed="availableFrom" />
                                                                                                                <img onClick="javascript:popUpCalendar(this,document.forms[0].availableFrom,'dd/mm/yyyy')"
                                                                                                                     src="../images/tlsCalendarIcon.gif">
                                                                                                            </td>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <td valign="middle" nowrap="nowrap"><span class="style3">*</span>
                                                                                                                Available To
                                                                                                            </td>
                                                                                                            <td valign="middle" align="left">
                                                                                                                <html:text property="availableTo" indexed="availableTo" />
                                                                                                                <img onClick="javascript:popUpCalendar(this,document.forms[0].availableTo,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif">
                                                                                                            </td>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <td valign="middle">
                                                                                                                <html:button property="save" value="Save" onclick="addTraining(this.form)"/>
                                                                                                                <html:hidden property="method"/>

                                                                                                                <html:hidden property="employeeId"/>
                                                                                                                <html:hidden property="status"/>
                                                                                                            </td>
                                                                                                            <td valign="middle" align="left">
                                                                                                                <html:cancel property="cancel" onclick="return winRefresh(this.form);" />
                                                                                                            </td>
                                                                                                        </tr>
                                                                                                    </table>
                                                                                                </html:form>

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
</html:html>

