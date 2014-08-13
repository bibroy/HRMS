<%-- 
    Document   : EmpTimesheet
    Created on : Dec 15, 2010, 5:50:48 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page buffer="256kb"%>
<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib  uri="http://displaytag.sf.net" prefix="display"%>

<%@page import="java.util.List" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS :: Employee Time Sheet </title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
        <link rel="stylesheet" href="../css/displaytagex.css"/>
        <script type="text/javascript" src="../js/ajaxpagefetcher.js"></script>

        <script LANGUAGE="JavaScript">

            function popUp(URL,h,w) {
                day = new Date();
                id = day.getTime();
                eval("page" + id + " = window.open(URL, '" + id + "', 'toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=1,width="+w+",height="+h+",left = 0,top = 0');");
            }

            function getdesc(form){
                var taskid=form.task.value;

                var taskDes="loadTaskDesc.do?method=loadTaskDesc&hiddenId="+taskid;
                ajaxpagefetcher.load('taskDesc',taskDes,true);
            }

            function starttask(form){
                form.method.value="saveTaskEmp";
                form.hiddenId.value="started";
                form.submit();
            }

            function suspendtask(form){
                form.method.value="saveTaskEmp";
                form.hiddenId.value="suspended";
                form.submit();
            }

            function completetask(form){
                form.method.value="saveTaskEmp";
                form.hiddenId.value="completed";
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
                                                                <td class="body_mid" style="padding:0 0 0 5px;" valign="top" width="600">


                                                                    <display:table export="true" class="dataTable"  name="sessionScope.taskList" style="cellpadding:5; width=600px;" sort="list"  requestURI="../loadEmpTS.do?method=loadEmpTimesheet"  pagesize="5"  >

                                                                        <display:column property="projectId" title="Project Id" sortable="true" />
                                                                        <display:column property="startTime" title="Start Time" sortable="true" />
                                                                        <display:column property="task" title="Task"   />
                                                                        <display:column property="remarks" title="Remarks"  />
                                                                        <display:column property="workStatus" title="Work Status"/>

                                                                        <display:caption style="color:red; font-size:25px;">Task Allocation Details </display:caption>
                                                                        <display:setProperty name="export.pdf.class" value="com.CHANGE.IT.export.NicePdfExport.java"/>
                                                                        <display:setProperty name="export.export name.include_header" value="true"/>
                                                                        <display:setProperty name="pdf.export.pdf.header" value="Employees Birthday List"/>
                                                                        <display:setProperty name="export.pdf" value="true" />
                                                                        <display:setProperty name="export.excel" value="true" />
                                                                        <display:setProperty name="export.csv" value="true" />
                                                                        <display:setProperty name="export.xml" value="true" />

                                                                    </display:table>

                                                                    <html:form action="loadEmpTS">
                                                                        <fieldset>
                                                                            <table width="80%" border="0" cellspacing="4" cellpadding="2" >
                                                                                <tr>
                                                                                    <td align="left" valign="top" colspan="3"><div id="errorMsg" ></div>
                                                                                        <logic:messagesPresent message="true">

                                                                                            <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                                        </logic:messagesPresent>
                                                                                        <logic:messagesPresent >

                                                                                            <html:messages id="error"><bean:write name="error"/></html:messages>

                                                                                        </logic:messagesPresent >
                                                                                    </td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="2" nowrap="nowrap"><span class="normal_black_text" style="font-weight: bold">Fill Up all Mandatory fields(</span><span class="normal_black_text"><span class="style3">*</span></span><span class="normal_black_text" style="font-weight: bold">):- </span></td>
                                                                                    <td width="30%" nowrap="nowrap"></td>

                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Tasks: </td>
                                                                                    <td align="right" valign="middle" nowrap="nowrap">
                                                                                        <html:select property="task" onchange="getdesc(this.form);">
                                                                                            <html:option value="">--Select--</html:option>
                                                                                            <logic:present name="taskList" scope="session">
                                                                                                <html:options collection="taskList" labelProperty="task" property="task"/>
                                                                                            </logic:present>
                                                                                        </html:select>
                                                                                    </td>
                                                                                    <td></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap>Task Description </td>
                                                                                    <td align="right" valign="middle" nowrap id="taskDesc"><html:textarea property="taskDesc" rows="4" readonly="true"/></td>
                                                                                    <td align="left" ></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap>Remarks</td>
                                                                                    <td align="right" valign="middle" nowrap><html:textarea property="remarks" rows="4"/></td>
                                                                                    <td align="left"></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap>
                                                                                        <html:button property="button" value="Start" onclick="starttask(this.form);"/>
                                                                                    </td>
                                                                                    <td align="left" valign="middle" nowrap>
                                                                                        <html:button property="button" value="Suspend" onclick="suspendtask(this.form);"/>
                                                                                    </td>
                                                                                    <td align="left" valign="middle" nowrap>
                                                                                        <html:button property="button" value="Complete" onclick="completetask(this.form);"/>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </fieldset>
                                                                        <html:hidden property="method"/>
                                                                        <html:hidden property="hiddenId"/>
                                                                    </html:form>
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

