<%--
Document   : appraisalSetup
Created on : Oct 9, 2009, 1:29:36 AM
Author     : Swarnendu Mukherjee
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
        <title>Appraisal Setup</title>
        <script type="text/javascript" src="../js/jquery.1.9.12.js"></script>
        <script type="text/javascript" src="../js/jquery-ui.js"></script>
        <script type="text/javascript" src="../css/jquery-ui.css"></script>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
        <script type="tetext/javascript" src="../js/scripts.js"></script>
        <script language="javascript">
            function tabMenu(id){
                var iLoop=0;
                var loopId=1;
                for(iLoop=0; iLoop<4 ; iLoop++){
                    document.getElementById(loopId).className = "invisible";
                    loopId++;
                }
                document.getElementById(id).className = "visible";
            }
         

            function chooseAppraiser(param)
            {
                if(param==1)
                {
                    document.getElementById('desExternal').disabled=true;
                    document.getElementById('desInternal').disabled=false;
                }
                else if(param==0)
                {
                    document.getElementById('desExternal').disabled=false;
                    document.getElementById('desInternal').disabled=true;
                }
            }
        </script>
        
    <body background="palegoldenrod">

        <jsp:include page="../include/header.jsp" />
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="8"></td>
                <td height="8"></td>
                <td height="8"></td>
            </tr>
            <tr>
                <td width="100%" colspan="3" align="left" valign="top"><img src="../images/Appraisal.jpg" width="100%" height="138" /></td>
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
                                                                <td class="body_mid" style="padding:0 0 0 5px;" valign="middle" align="center">

                                                                    <logic:messagesPresent message="true">

                                                                        <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                    </logic:messagesPresent>
                                                                    <logic:messagesPresent>

                                                                        <font color="red"><html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                    </logic:messagesPresent>

                                                                    <form action="../initiateAppraisal.do" method="post">

                                                                        <div  class="visible" id="1" >
                                                                            <table align="left" border="0"  >
                                                                                <tr>
                                                                                    <td  align="center" valign="top" height="30">
                                                                                        <font color="maroon" size="3"><b>Choose Appraisal Templates</b></font>
                                                                                    </td>
                                                                                </tr>
                                                                                <tr><td align="center">
                                                                                        <table align="center" bgcolor="palegoldenrod">
                                                                                            <tr bgcolor="goldenrod" align="center">

                                                                                                <td width="300" colspan="2"><font color="white"><b>Category Name</b></font></td>
                                                                                                <td width="300"><font color="white"><b>Category Description</b></font></td>
                                                                                            </tr>
                                                                                            <logic:present name="appraisalCategory" scope="request">
                                                                                                <logic:iterate id="itr" name="appraisalCategory" indexId="no">
                                                                                                    <tr align="justify" bgcolor="<c:if test='${no%2!=0}'>cornsilk</c:if><c:if test='${no%2==0}'>white</c:if>">
                                                                                                        <td ><input type="checkbox" name="category_id" value="<bean:write  name="itr" property="category_code"/>"/>
                                                                                                        </td>
                                                                                                        <td><span class="normal_black_text" style="font-weight: bold;"><bean:write  name="itr" property="category_name"/></span></td>
                                                                                                        <td><span class="normal_black_text" style="font-weight: 100"><bean:write  name="itr" property="category_description"/></span></td>
                                                                                                    </tr>
                                                                                                </logic:iterate>
                                                                                            </logic:present>
                                                                                            <tr><td colspan="3" height="10"></td></tr>
                                                                                            <tr align="left">
                                                                                                <td colspan="3" align="center" >
                                                                                                    <input type="button"  onclick="javascript:tabMenu(2)" value="Continue>>"/>
                                                                                                </td></tr>
                                                                                        </table>
                                                                                    </td></tr>
                                                                            </table>
                                                                        </div>
                                                                        <div  class="invisible" id="2" >
                                                                            <table align="left" border="0" cellspacing="0" cellpadding="0" >
                                                                                <tr>
                                                                                    <td colspan="4" align="center" valign="top" height="10">
                                                                                        <h3><font color="maroon" ><b>Deparment and Duration Details</b>
                                                                                            </font></h3>
                                                                                    </td>
                                                                                </tr>
                                                                                <tr align="center">

                                                                                    <td><table  bgcolor="palegoldenrod"><tr>
                                                                                                <td>  <span class="normal_black_text" style="font-weight: bold">Department Name::</span>
                                                                                                    <select name="department">
                                                                                                        <option>Select Department</option>
                                                                                                        <logic:present name="department" scope="request">
                                                                                                            <logic:iterate id="itr" name="department" indexId="no">
                                                                                                                <option value="<bean:write  name="itr" property="departmentId"/>"><bean:write  name="itr" property="departmentName"/></option>
                                                                                                            </logic:iterate>
                                                                                                        </logic:present>
                                                                                                    </select>
                                                                                                </td>
                                                                                                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                                                                <td><span class="normal_black_text" style="font-weight: bold">Select Duration::</span></td>
                                                                                                <td>
                                                                                                    <select name="duration">
                                                                                                        <option>Select Duration</option>
                                                                                                        <option value="Q">Quaterly</option>
                                                                                                        <option value="H">Half Yearly</option>
                                                                                                        <option value="Y">Yearly</option>
                                                                                                    </select>
                                                                                                </td>
                                                                                            </tr>
                                                                                            <tr><td colspan="3" height="10"></td></tr>
                                                                                            <tr align="left">
                                                                                                <td colspan="3">
                                                                                                    <input type="button" value="Continue>>" onclick="javascript:tabMenu(3)"  />
                                                                                                    <input type="button" value="<<Back" onclick="javascript:tabMenu(1)"  />
                                                                                                </td>
                                                                                            </tr></table></td></tr>
                                                                            </table>
                                                                        </div>
                                                                        <div  class="invisible" id="3" >
                                                                            <table align="left" border="0"  >
                                                                                <tr>
                                                                                    <td colspan="7" align="center">
                                                                                        <h2> <font color="maroon">Appraisal Details</font></h2>
                                                                                    </td>
                                                                                </tr>
                                                                                <tr align="left">
                                                                                    <td><span class="normal_black_text" style="font-weight: bold">Appraiser:</span></td>
                                                                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td><input name="choose" type="radio" onclick="chooseAppraiser(1)"/>Internal :&nbsp;&nbsp;
                                                                                        <select name="appraiser" id="desInternal">
                                                                                            <option>Select Appraiser</option>
                                                                                            <logic:present name="designation" scope="request">
                                                                                                <logic:iterate id="itr" name="designation" indexId="no">
                                                                                                    <option value="<bean:write  name="itr" property="designationId"/>"><bean:write  name="itr" property="designationName"/></option>
                                                                                                </logic:iterate>
                                                                                            </logic:present>
                                                                                        </select>
                                                                                    </td>
                                                                                    <td>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;</td>
                                                                                    <td><span class="normal_black_text" style="font-weight: bold"><input name="choose" type="radio" onclick="chooseAppraiser(0)"/>External:</span>

                                                                                        <select name="appraiser" id="desExternal">
                                                                                            <option>Select External Contributer</option>
                                                                                            <option>xyz consultancy</option>
                                                                                        </select>
                                                                                    </td>
                                                                                </tr>
                                                                                <tr><td colspan="7" height="7"></tr>
                                                                                <tr align="left">
                                                                                    <td><span class="normal_black_text" style="font-weight: bold">Appraisal Type</span>


                                                                                        <select name="response_type">
                                                                                            <option>Appraisal Type</option>
                                                                                            <option value="1">subordinate</option>
                                                                                            <option value="2">supirior</option>
                                                                                            <option value="3">360 Degree</option>
                                                                                        </select>
                                                                                    </td>
                                                                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                                                    <td><span class="normal_black_text" style="font-weight: bold">Inform appraise about status of appraisal?</span>
                                                                                        <input type="radio" name="feedback_status" value="Y" />Yes &nbsp;&nbsp;&nbsp;&nbsp;
                                                                                        <input type="radio" name="feedback_status" value="N" />No
                                                                                    </td>
                                                                                </tr>
                                                                                <tr><td colspan="3" height="10"></td></tr>
                                                                                <tr align="left">
                                                                                    <td colspan="2" >
                                                                                        <input type="button" value="Continue>>" onclick="javascript:tabMenu(4)"  />
                                                                                        <input type="button" value="<<Back" onclick="javascript:tabMenu(2)"  />
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                        <div  class="invisible" id="4" >
                                                                            <table align="center" border="0"  >
                                                                                <tr>
                                                                                    <td colspan="3" align="center">
                                                                                        <h2> <font color="maroon">Message to Appraiser(Optional)</font></h2>
                                                                                    </td>
                                                                                </tr>
                                                                                <tr align="center">
                                                                                    <td> <textarea  name="message" cols="50"></textarea></td>
                                                                                </tr>
                                                                                <tr align="left">
                                                                                    <td>
                                                                                        
                                                                                        <input type="hidden" name="method" value="setAppraisal"/>
                                                                                        <input type="submit" value="Submit" />
                                                                                        <input type="button" value="<<Back" onclick="javascript:tabMenu(3)" />
                                                                                    </td>

                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                          
                                                                    </form>

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
        <script type="text/javascript">
        $(function() {
        	//loadAccordions();
	        	$( "#accrdins" ).accordion({
	        		collapsible: true,
	        		active: 7
	        	});
        	});

        </script>


        <style type="text/css">

            .applemenu{
                margin: 5px 0;
                padding: 0;
                width: 170px; /*width of menu*/
                border: 1px solid #9A9A9A;
            }

            .applemenu div.silverheader a{
                background: black url(../images/lightmaroon.png) repeat-x center left;
                font: normal 12px Tahoma, "Lucida Grande", "Trebuchet MS", Helvetica, sans-serif;
                color: white;
                display: block;
                position: relative; /*To help in the anchoring of the ".statusicon" icon image*/
                width: auto;
                padding: 5px 0;
                padding-left: 8px;
                text-decoration: none;
            }


            .applemenu div.silverheader a:visited, .applemenu div.silverheader a:active{
                color: white;
            }


            .applemenu div.selected a, .applemenu div.silverheader a:hover{
                background-image: url(../images/lightmaroon.png);
                color: white;
            }

            .applemenu div.submenu{ /*DIV that contains each sub menu*/
                                    background: white;
                                    padding: 5px;
                                    height: 300px; /*Height that applies to all sub menu DIVs. A good idea when headers are toggled via "mouseover" instead of "click"*/
                                    background-color: #CBCADF;
            }

        </style>
    </body>
</html:html>