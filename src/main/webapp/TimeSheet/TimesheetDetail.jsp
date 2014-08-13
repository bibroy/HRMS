<%--
    Document   : Timesheet Detail Entry
    Created on : feb 1, 2010, 3:25:50 PM
    Author     : pranav Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html:html>
    <html:base/>
    <head>
        <title>HRMS :: TimesheetDetail Entry</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

        <script language="javascript" type="text/JavaScript" src="../js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>

        <script language="javascript" type="text/javascript">

            function increamentTxtBox   (id){
                var od=document.getElementById("od").innerHTML;
                if(id<=od){
                var id=id+1;
                //alert(id);
                var id2=id+1;
                document.getElementById(id).innerHTML='<table  border="1" cellpadding="0" cellspacing="0" bgcolor="cornsilk" > <tr><td>'+document.getElementById("ovr").innerHTML+'</td><td width="80%"><input type="text" name="desc" style="width:100%"/></td></tr></table></div><div id="'+id2+'"></div>';
                document.getElementById("divAddMore").innerHTML ='<label title="No. of Text Box'+id+'"  onclick="increamentTxtBox('+id+')" style="cursor:pointer" ><input type="button" value="Add overtime >>"></label>';



                document.getElementById("remove").innerHTML='<label  title="No. of Text Box'+id+'"  onclick="removeTxtBox('+id+')" style="cursor:pointer" ><input type="button" value="remove" src="images/submit_button.jpg"></label>';

            }
            else{
                window.alert("you have no more over time for the day");
            }
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
               <td width="100%" colspan="3" align="left" valign="top"><img src="../images/timesheet.jpg" width="100%" height="138" /></td>
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
                    <br><br><br>
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

                                                        <logic:messagesPresent message="true">

                                                            <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                        </logic:messagesPresent>
                                                        <logic:messagesPresent >

                                                            <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                        </logic:messagesPresent >

                                                        <html:form action="timesheet1" method="post">
                                                            <table align="center" bgcolor="ghostwhite" width="500">
                                                                <tr align="center" bgcolor="goldenrod">
                                                                    <td colspan="5"><font color="white"><b>Time Sheet Of Today</b></font></td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="center">
                                                                        <div id="1">
                                                                            <table  border="1" cellpadding="0" cellspacing="0" bgcolor="cornsilk" width="100%">

                                                                                <tr>
                                                                                    <td width="20%"><b>Project Id:</b> </td>
                                                                                    <td width="80%"><input type="text" name="projectId"></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td width="20%"><b>Time Slot</b></td>
                                                                                    <td width="80%"><b>Description</b></td>

                                                                                </tr>
                                                                                <logic:present name="timeslot" scope="request">
                                                                                <logic:iterate id="slt" name="timeslot" scope="request" indexId="id">
                                                                                    <tr>
                                                                                        <td width="20%"><input type="text" name="slot"  readonly="true" value="<bean:write name="slt"/>" /></td>
                                                                                        <td width="80%"><input type="text" name="desc" style="width:100%"/></td>
                                                                                    </tr>
                                                                                </logic:iterate>
                                                                                </logic:present>

                                                                            </table>

                                                                            <p align="center" style="background-color: goldenrod"><font color="white"><b>Over Time Detail</b></font></p>
                                                                        </div>  
                                                                        <div id="2"></div>


                                                                    </td>

                                                                </tr>

                                                                <tr>
                                                                    <td>

                                                                        <table align="center">

                                                                            <tr>


                                                                                <td><div id="divAddMore"><label onclick="increamentTxtBox(1)" style="cursor:pointer" ><input type="button" value="Add overtime >>"></label></div></td>
                                                                                <td> <div id="remove"></div></td>
                                                                                <td> <input type="hidden" name="method" value="saveTimesheetDetail" />
                                                                                    <input type="submit" value="OK" src="../images/submit_button.jpg"></td>
                                                                                <td><input type="reset" value="Cancel" src="../images/submit_button.jpg"></td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td id="ovr" style="visibility: hidden;">

                                                                        <select  name="slot" >
                                                                            <option value="">--Select--</option>
                                                                            <logic:present  name="overtime" scope="request">
                                                                                <logic:iterate id="ti" scope="request" name="overtime">
                                                                                    <option value="${ti}">${ti}</option>
                                                                                </logic:iterate>
                                                                            </logic:present>
                                                                        </select>

                                                                    </td>
                                                                    <td  id="od" style="visibility: hidden;">
                                                                        <logic:present name="timesheetheader" scope="request">
                                                                        <bean:write name="timesheetheader" property="overtimeduration" scope="request" />
                                                                        </logic:present>
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