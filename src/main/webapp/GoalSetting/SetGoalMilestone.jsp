<%-- 
    Document   : SetGoalMilestone
    Created on : Feb 18, 2011, 1:41:36 PM
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
        <title>HRMS :: Goal Milestone Settings</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
        <script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="../js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>

        <script type="text/javascript">

            function sendRequest(form)
            {
                form.method.value="saveGoalSettings";
                form.submit();
            }

            function increamentTxtBox(id){
                var id=id+1;
                //alert(id);
                var id2=id+1;
                document.getElementById(id).innerHTML='<table  border="1" cellpadding="0" cellspacing="0" bgcolor="cornsilk" > <tr style="vertical-align:top;"><td><input type="text" name="goalTitle" maxlength="30"/></td><td><textarea cols="15" rows="2" name="goalDesc"></textarea></td>' +
                    '<td><select name="priority">'+
                    '<option value="1">Highest</option>'+
                    '<option value="2">Higher</option>'+
                    '<option value="3">Above Normal</option>'+
                    '<option value="4" selected>Normal</option>'+
                    '<option value="5">Below Normal</option>'+
                    '<option value="6">Lower</option>'+
                    '<option value="7">Lowest</option>'+
                    '</select>'+
                    '</td><td><input type="text" name="probableCompletionDate" readonly="true"/><img onclick="javascript:popUpCalendar(this,document.forms[0].probableCompletionDate['+(id-1)+'],\'dd/mm/yyyy\')" src="../images/tlsCalendarIcon.gif" /></td>'+
                    '<td><textarea rows="2" cols="15" name="relatedOrgObjective"></textarea></td>'+
                    '</tr></table><br></div><div id="'+id2+'"></div>';
                document.getElementById("divAddMore").innerHTML ='<label title="No. of Text Box'+id+'"  onclick="increamentTxtBox('+id+')" style="cursor:pointer" ><input type="button" value="Add More >>"></label>';



                document.getElementById("remove").innerHTML='<label  title="No. of Text Box'+id+'"  onclick="removeTxtBox('+id+')" style="cursor:pointer" ><input type="button" value="remove" src="images/submit_button.jpg"></label>';

            }



            function removeTxtBox(id){
                if(id > 1){
                    document.getElementById(id).innerHTML='';
                    id=id-1;
                    document.getElementById("divAddMore").innerHTML ='<label title="No. of Text Box'+id+'"  onclick="increamentTxtBox('+id+')" style="cursor:pointer" ><input type="button" value="Add More >>"></label>';
                    document.getElementById("remove").innerHTML='<label title="No. of Text Box'+id+'"  onclick="removeTxtBox('+id+')" style="cursor:pointer" ><input type="button" value="remove" src="images/submit_button.jpg"></label>';
                }
                else{
                    alert("You Must Use Atleast One Text Input");
                    document.getElementById("remove").innerHTML='';

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
               <td width="100%" colspan="3" align="left" valign="top"><img src="../images/banner.jpg" width="100%" height="138" /></td>
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

                                                        <html:form action="goalSetting.do">

                                                            <table width="761" border="0" cellspacing="0" cellpadding="0">
                                                                <tr>
                                                                    <td align="left" valign="top"><div id="errorMsg" ></div>

                                                                        <logic:messagesPresent message="true">

                                                                            <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                        </logic:messagesPresent>
                                                                        <logic:messagesPresent>

                                                                            <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                        </logic:messagesPresent>
                                                                    </td>

                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <table align="left" bgcolor="ghostwhite" width="200" width="1000">
                                                                            <tr align="center" bgcolor="goldenrod">
                                                                                <td colspan="5"><font color="white"><b>Set Your Goals</b></font></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="center">
                                                                                    <div id="1">
                                                                                        <table  border="1" cellpadding="0" cellspacing="0" bgcolor="cornsilk" >
                                                                                            <tr>
                                                                                                <td><b>Employee Id :</b> </td>
                                                                                                <td align="left" colspan="5"><html:text property="employeeId" size="4" maxlength="6" readonly="true"/></td>

                                                                                            </tr>
                                                                                            <tr>
                                                                                                <td><b>Goal Title</b></td>
                                                                                                <td><b>Goal Description</b></td>
                                                                                                <td><b>Priority</b></td>
                                                                                                <td><b>Probable <br/> Completion Date</b></td>
                                                                                                <td><b>Organizational<br/> Objectives</b></td>
                                                                                            </tr>
                                                                                            <tr style="vertical-align: top;">
                                                                                                <td><input type="text" name="goalTitle" maxlength="30"/></td>
                                                                                                <td><textarea cols="15" rows="2" name="goalDesc"></textarea> </td>
                                                                                                <td> 
                                                                                                    <select name="priority" >
                                                                                                        <option  value="1">Highest</option>
                                                                                                        <option  value="2">Higher</option>
                                                                                                        <option  value="3">Above Normal</option>
                                                                                                        <option  value="4" selected>Normal</option>
                                                                                                        <option  value="5">Below Normal</option>
                                                                                                        <option  value="6">Lower</option>
                                                                                                        <option  value="7">Lowest</option>
                                                                                                    </select>
                                                                                                </td>

                                                                                                <td><input type="text" name="probableCompletionDate" readonly="true"/><html:img onclick="javascript:popUpCalendar(this,document.forms[0].probableCompletionDate,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" />
                                                                                                </td>
                                                                                                <td><textarea rows="2" cols="15" name="relatedOrgObjective"></textarea></td>
                                                                                            </tr>
                                                                                        </table>

                                                                                    </div><div id="2"></div>
                                                                                </td>

                                                                            </tr>
                                                                            <tr>
                                                                                <td>

                                                                                    <table align="center">
                                                                                        <tr>

                                                                                            <td><div id="divAddMore"><label onclick="increamentTxtBox(1)" style="cursor:pointer" ><input type="button" value="Add More >>"></label></div></td>
                                                                                            <td> <div id="remove"></div></td>
                                                                                            <td> <input type="hidden" name="method" value="saveGoalSettings" />
                                                                                                <input type="submit" value="OK" src="../images/submit_button.jpg"></td>
                                                                                            <td><input type="reset" value="Cancel" src="../images/submit_button.jpg"></td>
                                                                                        </tr>
                                                                                    </table>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
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


