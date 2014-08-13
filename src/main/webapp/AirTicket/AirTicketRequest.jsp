<%-- 
    Document   : AirTicketRequest
    Created on : Nov 16, 2010, 4:23:17 PM
    Author     : Sumit Kumar
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
        <title>HRMS :: Air Ticket Request</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

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

        <script type="text/JavaScript">
            function addRequest(form){
                form.method.value="applyForTicket";
                alert(form.method.value);
                if(!checkBlank(form.empId,'Employee Id'))
                {
                    return;
                }
                if(!checkBlank(form.airlineName,'Airline Name'))
                {
                    return;
                }
                if(!checkBlank(form.destination,'Destination'))
                {
                    return;
                }
                if(!checkBlank(form.purOfTrip,'Purpose Of Trip'))
                {
                    return;
                }
                if(!checkBlank(form.depDate,'Departure Date'))
                {
                    return;
                }
                if(!checkBlank(form.returnDate,'Return Date'))
                {
                    return;
                }
                form.submit();
            }

            function showContent(vThis)
            {
                // http://www.javascriptjunkie.com
                // alert(vSibling.className + " " + vDef_Key);
                vParent = vThis.parentNode;
                vSibling = vParent.nextSibling;
                while (vSibling.nodeType==3) { // Fix for Mozilla/FireFox Empty Space becomes a TextNode or Something
                    vSibling = vSibling.nextSibling;
                };
                if(vSibling.style.display == "none")
                {
                    vThis.src="../images/collapse.gif";
                    vThis.alt = "Hide Div";
                    vSibling.style.display = "block";
                } else {
                    vSibling.style.display = "none";
                    vThis.src="../images/expand.gif";
                    vThis.alt = "Show Div";
                }
                return;
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
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/AirTicket.jpg" width="100%" height="138" /></td>
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


                                                        <html:form action="AirTicketRequest">
                                                            <table width="80%" border="0" align="left" cellpadding="2" cellspacing="4">
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
                                                                <tr>
                                                                    <td colspan="3" align="left" valign="middle"><span class="normal_black_text" style="font-weight: bold">Fill Up all Mandatory fields(</span><span class="normal_black_text"><span class="style3">*</span></span><span class="normal_black_text" style="font-weight: bold">):- </span></td>
                                                                    <td align="left" valign="middle" >&nbsp;</td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle"><span class="style3">*</span>Employee Id </td>
                                                                    <td align="left" valign="middle"><html:text property="empId" size="18" readonly="true"/></td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle">Airline Name</td>
                                                                    <td align="left" valign="middle"><html:text property="airlineName" size="18"/></td>

                                                                    <td align="left" valign="middle">Purpose Of Trip </td>
                                                                    <td align="left" valign="middle">
                                                                        <html:select property="purOfTrip">
                                                                            <html:option value="conference">Conference </html:option>
                                                                            <html:option value="meeting">Meeting </html:option>
                                                                            <html:option value="personal">Personal</html:option>
                                                                            <html:option value="sales">Sales</html:option>
                                                                            <html:option value="clientInterview">Client Interview</html:option>

                                                                        </html:select>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle">From</td>
                                                                    <td align="left" valign="middle"><html:text property="from" size="18"/></td>
                                                                    <td align="left" valign="middle">Destination</td>
                                                                    <td align="left" valign="middle"><html:text property="destination" size="18"/></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle"> Departure Date</td>
                                                                    <td align="left" valign="middle"> <html:text property="depDate" size="20"/>
                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].depDate,'dd/mm/yyyy')" src="images/tlsCalendarIcon.gif"  /></td>
                                                                    <td align="left" valign="middle"> Departure Time</td>
                                                                    <td align="left" valign="middle"> <html:select property="departureTime" >
                                                                            <html:option value="Any Time">Any Time</html:option>
                                                                            <html:option value="morning">Morning</html:option>
                                                                            <html:option value="afternoon">Afternoon</html:option>
                                                                            <html:option value="evening">Evening</html:option>
                                                                            <html:option value="night">Night</html:option>
                                                                        </html:select>

                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle"> Return Date </td>
                                                                    <td align="left" valign="middle"><html:text property="returnDate"/>
                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].returnDate,'dd/mm/yyyy')" src="images/tlsCalendarIcon.gif"  /></td>
                                                                    <td align="left" valign="middle">Return Time</td>
                                                                    <td align="left" valign="middle"><html:select property="returnTime">
                                                                            <html:option value="Any Time">Any Time</html:option>
                                                                            <html:option value="morning">Morning</html:option>
                                                                            <html:option value="afternoon">Afternoon</html:option>
                                                                            <html:option value="evening">Evening</html:option>
                                                                            <html:option value="night">Night</html:option>
                                                                        </html:select>

                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle"><html:checkbox property="includeHotel" value="includeHotel"/>Include Hotel</td>
                                                                    <td align="left" valign="middle"><html:checkbox property="includeCar" value="includeCar"/>Include Car</td>

                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle">
                                                                        <html:checkbox property="nonSmokingRoom" value="nonSmokingRoom"/>Non smoking hotel room required
                                                                    </td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle">Trip Class</td>
                                                                    <td align="left" valign="middle"><html:select property="tripClass">

                                                                            <html:option value="economy/coach">Economy/Coach</html:option>
                                                                            <html:option value="buisness">Business</html:option>
                                                                            <html:option value="First">First</html:option>
                                                                            <html:option value="executive">Executive</html:option>
                                                                            <html:option value="any">Any</html:option>
                                                                        </html:select>
                                                                    </td>
                                                                    <td align="left" valign="middle">Car class</td>
                                                                    <td align="left" valign="middle"><html:select property="carClass">
                                                                            <html:option value="compact">Compact</html:option>
                                                                            <html:option value="Full sizze">Full size</html:option>
                                                                            <html:option value="Luxury">Luxury</html:option>
                                                                            <html:option value="any">Any</html:option>
                                                                        </html:select></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle">Seat Location</td>
                                                                    <td align="left" valign="middle"><html:select property="seatLocation">
                                                                            <html:option value="Aisle">Aisle</html:option>
                                                                            <html:option value="Middle">Middle</html:option>
                                                                            <html:option value="Window">Window</html:option>
                                                                            <html:option value="any">Any</html:option>
                                                                        </html:select></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle"><table width="30%" border="0" align="left" cellpadding="0" cellspacing="0">
                                                                            <tr>
                                                                                <td align="right" valign="middle"><html:button  value="Submit Request" property="button" onclick="addRequest(this.form)"/>
                                                                                </td>
                                                                                <td width="4" align="left" valign="middle">&nbsp;</td>
                                                                                <td align="left" valign="middle"><html:reset  value="Reset" /></td>
                                                                            </tr>
                                                                        </table></td>
                                                                    <td align="right" valign="middle">&nbsp;</td>
                                                                    <td align="left" valign="middle">&nbsp;</td>
                                                                </tr>
                                                                <%--
                                                                <tr>
                                                                    <td colspan="3">
                                                                        <div style="margin-top:5px;">
                                                                            <h4><input type="button"  value="Add Passengers Details" alt="Show Div" border="0"  onclick="showContent(this);"/></h4>
                                                                            <div style="margin-top:5px; display:none;">
                                                                                <table width="500" border="1">

                                                        <tr>
                                                            <td width="133" align="center">
                                                                Select Member
                                                            </td>
                                                            <td nowrap>Member Id</td>
                                                            <td width="133" align="center">
                                                                Member Name</td>
                                                            <td width="140" align="center">
                                                                Relation</td>
                                                            <td width="142" align="center">
                                                                Date Of Birth</td>
                                                        </tr>

                                                        <logic:present name="familyMemberList" scope="request">

                                                            <logic:iterate id="itr" name="familyMemberList" indexId="no">
                                                                <tr align="center">
                                                                    <td>
                                                                        <html:checkbox property="status" value="${itr.id}">
                                                                            <bean:write name='itr' property='id'/>
                                                                        </html:checkbox>
                                                                    </td>

                                                                    <td><bean:write name="itr" property="familyMemberName"></bean:write></td>
                                                                    <td><bean:write name="itr" property="relation"></bean:write></td>

                                                                    <td><bean:write name="itr" property="dobOfMember"></bean:write></td>

                                                                </tr>
                                                            </logic:iterate>
                                                        </logic:present>

                                                    </table>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                                                --%>
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
</html>
