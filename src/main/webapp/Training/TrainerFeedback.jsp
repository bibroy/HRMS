<%--
    Document   : Trainer Feedback
    Created on : 
    Author     : Pradipto Roy
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
<script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>

<%@page import="java.util.List" %>
<%@page  import="com.pojo.EmployeeMaster" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS ::Trainer Feedback form</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
        <link rel="stylesheet" href="../css/displaytagex.css"/>
        <script type="text/javascript" src="../js/calender/viewCalendar.js"> </script>
        <script language="JavaScript" type="text/javascript">




            function retreivetrainingid(form){
                form.method.value="trainingidretreiving";
                 if(!checkBlank(form.trainingid,'trainingid'))
                {
                    return;
                }
            
                form.submit();

            }



            function SubmitEmployeeInformation(form){
                form.method.value="SubmitEmployeeInformation";
                 if(!checkBlank(form.score,'score'))
                {
                    return;
                }
             if(!checkNumber(form.score,'score'))
                {
                    return;
                }
            


                form.submit();

            }


                





            function loadEmployeeID(form){
                form.method.value="loadEmployeeID";
                
                form.submit();
            }
            function loadpic(file,form)
            {

                /* document.getElementById("dispic").src=file.value;
                document.getElementById("dispic").style.visibility="visible"; */

                /*  document.getElementsByName("canImage")[0].src=file.value;
                alert(document.getElementsByName("canImage")[0].src);
                document.getElementsByName("canImage")[0].style.visibility="visible";
                 */
                if(file.files){
                    //fix for mozilla firefox
                    document.getElementsByName("canImage")[0].src=file.files.item(0).getAsDataURL();

                    document.getElementsByName("canImage")[0].style.visibility="visible";
                }
                else
                {
                    //for IE and others
                    document.getElementsByName("canImage")[0].src=file.value;

                    document.getElementsByName("canImage")[0].style.visibility="visible";
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
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/Training.jpg" width="100%" height="138" /></td>
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

                                                        <table width="600" border="0" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td class="body_top">&nbsp;</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="body_mid" style="padding:0 0 0 5px;" valign="top" width="600">

                                                                    <html:form action="trainerfeedback" styleClass="none" styleId="empCerationForm" enctype="multipart/form-data">

                                                                        <h3 style="background-color: window;border-color:burlywood; width:500px; "><font color="red">Trainer Feedback </font></h3>

                                                                        <hr/>
                                                                        <br>
                                                                        <table width="600" border="0" cellspacing="4"   cellpadding="2" style="Background:oldlace" >
                                                                            <br>
                                                                            <tr>
                                                                                <td align="left" valign="top"><div id="errorMsg" ></div>

                                                                                    <logic:messagesPresent message="true">

                                                                                        <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                                    </logic:messagesPresent>
                                                                                    <logic:messagesPresent >

                                                                                        <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                                    </logic:messagesPresent >
                                                                                </td>

                                                                            </tr>
                                                                             <table width="600" border="0" cellspacing="12"   cellpadding="5" style="Background:oldlace" >
                                                                                    <tr>

                                                                                        <td  nowrap="true" valign="top">Training ID:</td><td colspan="4" valign="top" >

                                                                                            <html:text property="trainingid"/><html:button property="button" style=" Background:#F4F4F4 "  value="load" onclick="retreivetrainingid(this.form);" />
                                                                                        </td>

                                                                                    </tr>
                                                                                    <tr><td>Maximum Score is:</td><td><input type="text" name="maxmarks" value="100" /></td></tr>
                                                                                    <tr style="background-color: gold">
                                                                                        <th nowrap="true">
                                                                                            Employee id:
                                                                                        </th>


                                                                                        <th nowrap="true">
                                                                                            Employee name:
                                                                                        </th>

                                                                                        <th nowrap="true">
                                                                                            Start Date:
                                                                                        </th>

                                                                                        <th nowrap="true">
                                                                                            End Date:
                                                                                        </th>

                                                                                        <th nowrap="true">
                                                                                            Score:
                                                                                        </th>

                                                                                    </tr>

                                                                                    <logic:present name="trainingid">

                                                                                        <logic:iterate  id="tra" name="trainingid">

                                                                                            <tr>
                                                                                                <td><input type="text" name="employeeID" readonly="true" size="11" value="<bean:write name="tra" property="employeeId"/>" />
                                                                                                </td>



                                                                                                <td><input type="text" name="employeename" readonly="true" size="11" value="<bean:write name="tra" property="employeename"/>"/>
                                                                                                </td>

                                                                                                <td><input type="text" name="startdate" readonly="true" size="11" value="<bean:write name="tra" property="fromDate"/>" />
                                                                                                </td>

                                                                                                <td><input type="text" name="endDate" readonly="true" size="11" value="<bean:write name="tra" property="toDate"/>" />
                                                                                                </td>

                                                                                                <td><input type="text" name="score"  size="11"  />
                                                                                                </td>


                                                                                                <td><input type="hidden" name="trainingid" size="11" value="<bean:write name="tra" property="trainingname"/>" />
                                                                                                </td>





                                                                                            </tr>



                                                                                        </logic:iterate>
                                                                                        <tr><td><html:button property="button" style=" Background:#F4F4F4 "  value="submit the details" onclick="SubmitEmployeeInformation(this.form);" /></td></tr>


                                                                                    </logic:present>



                                                                                </table>

                                                                            <br>


                                                                        </table>
                                                                        <br>
                                                                        <br>


                                                                        <html:hidden property="method"/>
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
