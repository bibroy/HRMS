<%--
    Document   : selfAppraisalform
    Created on : feb 14, 2010, 4:36:13 PM
    Author     : pranav Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS::Appraisal Form</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
        <link rel="stylesheet" href="../css/style1.css" type="text/css"/>
        <link rel="stylesheet" href="../css/style.css" type="text/css"/>
        <script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="../js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>
        <script type="text/javascript" src="../js/accordion/javascript/prototype.js"></script>
        <script type="text/javascript" src="../js/accordion/javascript/effects.js"></script>
        <script type="text/javascript" src="../js/accordion/javascript/accordion.js"></script>

        <script type="text/javascript" src="../js/scripts.js"></script>

        <script type="text/javascript">

            //
            //  In my case I want to load them onload, this is how you do it!
            //
            Event.observe(window, 'load', loadAccordions, false);

            //
            //	Set up all accordions
            //
            function loadAccordions() {
                /*var topAccordion = new accordion('horizontal_container', {
        classNames : {
        toggle : 'horizontal_accordion_toggle',
        toggleActive : 'horizontal_accordion_toggle_active',
        content : 'horizontal_accordion_content'
        },
        defaultSize : {
        width : 525
        },
        direction : 'horizontal'
        });*/

                var bottomAccordion = new accordion('vertical_container');

                var nestedVerticalAccordion = new accordion('vertical_nested_container', {
                    classNames : {
                        toggle : 'vertical_accordion_toggle',
                        toggleActive : 'vertical_accordion_toggle_active',
                        content : 'vertical_accordion_content'
                    }
                });

                // Open first one
                //bottomAccordion.activate($$('#vertical_container .accordion_toggle')[0]);

                // Open second one
                //topAccordion.activate($$('#horizontal_container .horizontal_accordion_toggle')[2]);
            }

        </script>
        <% int loop = 1;%>
        <logic:present name="setup" scope="request">
            <logic:iterate id="itr" name="setup" indexId="no">
                <% loop++;%>
            </logic:iterate>
        </logic:present>
        <script language="javascript" type="text/javascript">
            function tabMenu(id){
                var iLoop=0;
                var loopId=1;
                for(iLoop=0; iLoop<<%=loop%> ; iLoop++){
                    document.getElementById(loopId).className = "invisible";
                    loopId++;
                }
                document.getElementById(id).className = "visible";
            }
        </script>

        <script language="javascript" type="text/javascript">

            /*
Auto center window script- Eric King (http://redrival.com/eak/index.shtml)
Permission granted to Dynamic Drive to feature script in archive
For full source, usage terms, and 100's more DHTML scripts, visit http://dynamicdrive.com
             */

            var win = null;
            function NewWindow(mypage,myname,w,h,scroll){
                LeftPosition = (screen.width) ? (screen.width-w)/2 : 0;
                TopPosition = (screen.height) ? (screen.height-h)/2 : 0;
                settings =
                    'height='+h+',width='+w+',top='+TopPosition+',left='+LeftPosition+',scrollbars='+scroll+',resizable'
                win = window.open(mypage,myname,settings)
            }

        </script>
        <script type="text/javascript">

            function appraise(form)
            {

                form.submit();

            }
        </script>
        <style type="text/css">
            .Active {   color:green; } .Stop { color:red;  } .Hold {color:gray; }
        </style>

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


                                                        <table width="100%" align="left" border="0" cellpadding="0" cellspacing="0" style="border: 2px solid #B76C35; height: 360px;">
                                                            <tr>
                                                                <td align="left" valign="top" height="35" bgcolor="#FFF3DB">
                                                                    <table width="100%" border="0" cellspacing="3" cellpadding="0">
                                                                        <tr>
                                                                            <td width="70%">
                                                                                <table width="100%" border="0" cellspacing="3" cellpadding="0">
                                                                                    <tr>
                                                                                        <td valign="middle"><b>Appraisal For:
                                                                                                <logic:present name="empinfo" scope="session">
                                                                                                    <logic:iterate id="itr" name="empinfo" indexId="no">
                                                                                                        <bean:write  name="itr" property="employee_name"/>
                                                                                                    </logic:iterate>
                                                                                                </logic:present>



                                                                                            </b> </td>

                                                                                    <td valign="middle"><a href="getAttendanceReport.do?method=getSelfAttendance"  onclick="NewWindow(this.href,'name','450','700','yes');return false"><img src="../images/report.gif" style="border-style:none"/>Attendance</a></td>
                                                                                        <td valign="middle"><a href="getReport.do?method=getselfAppraisalReport"  onclick="NewWindow(this.href,'name','500','300','yes');return false"><img src="../images/report.gif" style="border-style:none"/>Appraisal</a></td>
                                                                                                <%--
                                                                                                <td valign="middle"><a href="#"><img src="../images/images.gif" style="border-style:none"/></a></td>
                                                                                                <td valign="middle"><a href="#"><img src="../images/report.gif" style="border-style:none"/></a></td>
                                                                                                --%>


                                                                                    </tr>
                                                                                </table>

                                                                            </td>

                                                                        </tr>
                                                                    </table>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" align="center" style="padding:5px 0 1px 0;">
                                                                    <table width="761px" border="0" cellspacing="0" cellpadding="0" align="left">
                                                                        <tr>
                                                                            <td valign="top" align="left">
                                                                                <!-- *************************** POLULAR TABS STARTS ************************* -->
                                                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                                                    <tr>
                                                                                        <td valign="top" align="left">
                                                                                            <!--<div id="sidebar-tabs"> -->
                                                                                            <div id="mostPopWidget">

                                                                                                <div style="display:block; height: 21px; margin:0px; padding: 0px;">
                                                                                                    <ul class="tabs">

                                                                                                    </ul>
                                                                                                </div>

                                                                                                <div class="tabContent tabContentActive" id="mostViewed">
                                                                                                    <ul>
                                                                                                        <li>
                                                                                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                                                                                <tr>
                                                                                                                    <td style="padding: 5px 5px 0 0px;">
                                                                                                                        <table width="761" border="0" cellspacing="0" cellpadding="0">

                                                                                                                            <tr>
                                                                                                                                <td class="body_top">&nbsp;</td>
                                                                                                                            </tr>
                                                                                                                            <tr>
                                                                                                                                <td class="body_mid" style="padding:0 0 0 5px;" valign="middle">
                                                                                                                                    <div  class="visible" id="1" >
                                                                                                                                        <table bgcolor="palegoldenrod" align="left" width="550" >

                                                                                                                                            <tr bgcolor="goldenrod"><td colspan="4" align="center" height="6"><font color="white"><b>Appraisee  Details </b></font></td></tr>
                                                                                                                                            <logic:present name="empinfo" scope="session">
                                                                                                                                                <logic:iterate id="itr" name="empinfo" indexId="no">
                                                                                                                                                    <tr bgcolor="cornsilk">
                                                                                                                                                        <td><strong>Name</strong></td><td><bean:write  name="itr" property="employee_name"/></td>


                                                                                                                                                        <td><strong>Gender</strong></td><td><bean:write  name="itr" property="gender"/></td>
                                                                                                                                                    </tr>
                                                                                                                                                    <tr bgcolor="cornsilk">
                                                                                                                                                        <td><strong>Company Name</strong></td><td><bean:write  name="itr" property="company"/></td>

                                                                                                                                                        <td><strong>Department</strong></td><td><bean:write  name="itr" property="department"/></td>
                                                                                                                                                    </tr>
                                                                                                                                                    <tr bgcolor="cornsilk">
                                                                                                                                                        <td><strong>Designation</strong></td><td><bean:write  name="itr" property="designation"/></td>

                                                                                                                                                        <td><strong>Status</strong></td><td><bean:write  name="itr" property="employment_status"/></td>
                                                                                                                                                    </tr>
                                                                                                                                                    <tr bgcolor="cornsilk">
                                                                                                                                                        <td><strong>Days in company</strong></td><td><bean:write  name="itr" property="days_of_experience"/></td>
                                                                                                                                                    </tr>
                                                                                                                                                    <tr><td colspan="2" height="10"></td></tr>
                                                                                                                                                    <tr>
                                                                                                                                                        <td colspan="4" align="center">
                                                                                                                                                            <input type="button" value="Continue>>" onclick="javascript:tabMenu(2)"  />
                                                                                                                                                        </td>
                                                                                                                                                    </tr>
                                                                                                                                                </logic:iterate>
                                                                                                                                            </logic:present>
                                                                                                                                        </table>

                                                                                                                                    </div>

                                                                                                                                    <form action="selfappraise.do"   class="form" id="form1">


                                                                                                                                        <%int i = 2;%>
                                                                                                                                        <logic:present name="setup" scope="request">
                                                                                                                                            <logic:iterate id="itr" name="setup" indexId="no">
                                                                                                                                                <div  class="invisible" id="<%=i%>" >
                                                                                                                                                    <table width="100%" border="0" align="left" cellpadding="2" cellspacing="2">
                                                                                                                                                        <tr>
                                                                                                                                                            <td height="184"><table width="80%" border="0" align="left" cellpadding="4" cellspacing="1" bordercolor="#B27138" >
                                                                                                                                                                    <tr>
                                                                                                                                                                        <td width="2%" valign="bottom"><h3><font color="brown"><i><u><img src="../images/arrow.gif" height="16" width="16"/><bean:write  name="itr" property="category_name"/></u></i></font></h3></td>
                                                                                                                                                                        <td align="left" valign="middle" class="normal_black_text"></td>
                                                                                                                                                                        <td width="51" align="center" valign="top"><img src="../images/poor_button.jpg" width="51" height="39" /></td>
                                                                                                                                                                        <td width="51" align="center" valign="top"><img src="../images/fair_button.jpg" width="51" height="39" /></td>
                                                                                                                                                                        <td width="51" align="center" valign="top"><img src="../images/good_button.jpg" width="51" height="39" /></td>
                                                                                                                                                                        <td width="79" align="center" valign="top"><img src="../images/verygood_button.jpg" width="79" height="39" /></td>
                                                                                                                                                                        <td width="95" align="center" valign="top"><img src="../images/outstanding_button.jpg" width="95" height="39" /></td>
                                                                                                                                                                    </tr>
                                                                                                                                                                    <logic:present name="questions${no}" scope="request" >
                                                                                                                                                                        <logic:iterate id="qitr" name="questions${no}" indexId="counter" >
                                                                                                                                                                            <tr bgcolor="<c:if test='${counter%2!=0}'>cornsilk</c:if><c:if test='${counter%2==0}'>palegoldenrod</c:if>">
                                                                                                                                                                                <td align="center" valign="middle" ><img src="../images/tick_bullets.jpg" width="10" height="10" /><input type="hidden" name="question_code" value="<bean:write  name="qitr" property="question_code"/>"</td>
                                                                                                                                                                                <td align="left" valign="middle" class="normal_black_text"><bean:write  name="qitr" property="question"/></td>
                                                                                                                                                                                <td align="center" valign="middle"><input name="answer" type="checkbox" value="1" /></td>
                                                                                                                                                                                <td align="center" valign="middle" ><input name="answer" type="checkbox" value="2"/></td>
                                                                                                                                                                                <td align="center" valign="middle" ><input name="answer" type="checkbox" value="3"/></td>
                                                                                                                                                                                <td align="center" valign="middle" ><input name="answer" type="checkbox" value="4"/></td>
                                                                                                                                                                                <td align="center" valign="middle" ><input name="answer" type="checkbox"  value="5"/><input type="hidden" name="category_code" value="<bean:write  name="itr" property="category_id"/>"/></td>
                                                                                                                                                                            </tr>

                                                                                                                                                                        </logic:iterate>
                                                                                                                                                                    </logic:present>
                                                                                                                                                                </table></td>
                                                                                                                                                        </tr>
                                                                                                                                                        <tr>
                                                                                                                                                            <td><table width="60%" border="0" align="center" cellpadding="4" cellspacing="4">

                                                                                                                                                                    <tr>
                                                                                                                                                                        <td align="center" valign="middle">
                                                                                                                                                                            <input type="hidden" name="method" value="saveSelfAppraisalMarks" />



                                                                                                                                                                            <% if (i < loop) {%>
                                                                                                                                                                            <input type="button" value="Continue>>" onclick="javascript:tabMenu(<%=i + 1%>)"/>
                                                                                                                                                                            <% }%>
                                                                                                                                                                            <% if (i > 2) {%>
                                                                                                                                                                            <input type="button" value="<<Back" onclick="javascript:tabMenu(<%=i - 1%>)"  />
                                                                                                                                                                            <% }%>

                                                                                                                                                                            <% if (i == loop) {%>
                                                                                                                                                                            <input type="button" value="Appraise" onclick="appraise(this.form)" />
                                                                                                                                                                            <% }%>
                                                                                                                                                                        </td>
                                                                                                                                                                    </tr>
                                                                                                                                                                </table></td>
                                                                                                                                                        </tr>
                                                                                                                                                        <tr>
                                                                                                                                                            <td align="center" valign="middle"><b><font color="green">Percent complete - <% out.print(Math.round((i - 2) * 1.0 / (loop - 1) * 100));%></font></b></td>

                                                                                                                                                        </tr>
                                                                                                                                                    </table>
                                                                                                                                                </div>
                                                                                                                                                <% i = i + 1;%>
                                                                                                                                            </logic:iterate>
                                                                                                                                        </logic:present>



                                                                                                                                    </form>

                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                            <tr>
                                                                                                                                <td class="body_bottom">&nbsp;</td>
                                                                                                                            </tr>
                                                                                                                        </table>
                                                                                                                    </td>
                                                                                                                </tr>
                                                                                                            </table>
                                                                                                        </li>
                                                                                                    </ul>
                                                                                                </div>


                                                                                                <div class="tabContent" id="topRated">
                                                                                                    <ul>
                                                                                                        <li>Text 4</li>
                                                                                                    </ul>
                                                                                                </div>

                                                                                                <script type="text/javascript">new Popular("mostPopWidget");</script>
                                                                                            </div>
                                                                                            <!--</div> -->
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                                <!-- *************************** POPULAR TABS ENDS *************************** -->
                                                                            </td>
                                                                        </tr>
                                                                    </table>

                                                                </td>
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
