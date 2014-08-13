<%-- 
    Document   : CreateProjectJobs
    Created on : Feb 23, 2011, 12:40:32 PM
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
        <title>HRMS :: Job Creation</title>
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />
        <script type="text/javascript" src="js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="js/HRMS.js"></script>

        <script type="text/javascript">

            function addRec(form)
            {
                form.method.value="saveProjectJob";
                if(!checkBlank(form.project,'Project Name'))
                {
                    return;
                }
                if(!checkBlank(form.jobName,'Job Name'))
                {
                    return;
                }

                if(!checkBlank(form.jobDesc,'Job Description'))
                {
                    return;
                }
                if(!checkBlank(form.skillsReq,'Required Skills'))
                {
                    return;
                }
                if(!checkBlank(form.manpowerReq,'Required Manpower'))
                {
                    return;
                }
                if(!checkNum(form.manpowerReq,'Number of Manpower required'))
                {
                    return;
                }
                 if(!checkChar(form.jobDesc,'char of Job Description'))
                {
                    return;
                }
                 if(!checkChar(form.jobName,'char of Job Name'))
                {
                    return;
                }
                 if(!checkChar(form.skillsReq,'char of Required Skills'))
                {
                    return;
                }
              

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
               <td width="100%" colspan="3" align="left" valign="top"><img src="images/Manpower.jpg" width="100%" height="138" /></td>
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

                                                        <html:form action="projectJob.do">

                                                            <table width="761" border="0" cellspacing="0" cellpadding="0">
                                                                <tr>
                                                                    <td align="left" valign="top"><div id="errorMsg" ></div>

                                                                        <logic:messagesPresent message="true">

                                                                            <font color="green"> <b><img src="images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                        </logic:messagesPresent>
                                                                        <logic:messagesPresent>

                                                                            <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                        </logic:messagesPresent>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="body_top">&nbsp;&nbsp;&nbsp; </td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="body_mid" style="padding:0 0 0 5px;" valign="bottom">
                                                                        <fieldset>
                                                                            <legend>Add Project Jobs</legend>
                                                                            <table width="80%" border="0" cellspacing="4" cellpadding="2" >
                                                                                <tr>
                                                                                    <td colspan="2" nowrap="nowrap"><span class="normal_black_text" style="font-weight: bold">Fill Up all Mandatory fields(</span><span class="normal_black_text"><span class="style3">*</span></span><span class="normal_black_text" style="font-weight: bold">):- </span></td>
                                                                                    <td width="30%" nowrap="nowrap"></td>
                                                                                    <td width="13%" nowrap="nowrap">&nbsp;</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td width="31%" align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Project Name: </td>
                                                                                    <td width="29%" align="left" valign="middle" nowrap="nowrap">
                                                                                        <html:select property="project">
                                                                                            <html:option value="">--Select--</html:option>
                                                                                            <logic:present name="projectList">
                                                                                                <html:options collection="projectList" labelProperty="projectName" property="id"/>
                                                                                            </logic:present>
                                                                                        </html:select>
                                                                                    </td>
                                                                                    <td align="right" valign="middle" nowrap="nowrap">&nbsp; </td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Job Name:</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"><html:text property="jobName" /></td>
                                                                                    <td align="right" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">&nbsp;
                                                                                    </td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Job Description:</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap" colspan="3">
                                                                                        <html:textarea property="jobDesc" cols="40"></html:textarea>
                                                                                    </td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"> <span class="style3">*</span>Required Skills</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">
                                                                                        <html:text property="skillsReq"/>  </td>
                                                                                    <td align="right" valign="middle" nowrap="nowrap"><span class="style3">*</span>Required Manpower</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">
                                                                                        <html:text property="manpowerReq"  size="3" /></td>
                                                                                </tr>


                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">
                                                                                        <table width="30%" border="0" align="left" cellpadding="0" cellspacing="0">
                                                                                            <tr>
                                                                                                <td align="right" valign="middle">
                                                                                                    <%--    <html:button property="button" value="Submit"  onclick="return addRec(this.form)" styleClass="submitButton"/> --%>
                                                                                                    <html:button property="button" value="Submit"  onclick="return addRec(this.form)" />
                                                                                                </td>
                                                                                                <td width="4" align="left" valign="middle">&nbsp;</td>
                                                                                                <td align="left" valign="middle">
                                                                                                    <%--   <html:reset property="Reset" value="Clear" styleClass="resetButton" /> --%>
                                                                                                    <html:reset  value="Clear" />
                                                                                                </td>
                                                                                            </tr>
                                                                                        </table>
                                                                                    </td>
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


