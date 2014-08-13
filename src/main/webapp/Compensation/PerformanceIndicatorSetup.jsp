<%-- 
    Document   :Performance indicator setup
    Created on : Feb 22, 2011, 12:36:05 PM
    Author     : computer1
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
        <title>HRMS ::Compensation indicator Form</title>
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />
        <script type="text/javascript" src="js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="js/HRMS.js"></script>

        <script type="text/javascript">

            function save(form)
            {
                form.method.value="savePerformanceIndicator";
                if(!checkBlank(form.company,'company'))
                {
                    return;
                }
                if(!checkBlank(form.department,'department'))
                {
                    return;
                }

                if(!checkBlank(form.designation,'designation'))
                {
                    return;
                }
                if(!checkBlank(form.indicator, 'indicator'))
                {
                    return;
                }
                 if(!checkBlank(form.measure,'measure'))
                {
                    return;
                }

                if(!checkPercentage(form.measure,'percent measure'))
                {
                    return;
                }


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
            function getDepartment(sel)
            {
                var cont=sel.value;
                var page="Compensation.do?method=getDepartment&company="+cont;
                ajaxpagefetcher.load("dept", page, true);




            }


        </script>

    </head>
    <style> h5{

            text-align: left;
            font-style: normal;
            font-size: 20pt;
            font-family: monospace;

        }
        td.label{
            color: red;
            text-align: left;
            font-style:normal;
            font-size:  small;

        }</style>
    <body background="palegoldenrod">

        <jsp:include page="../include/header.jsp" />
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="8"></td>
                <td height="8"></td>
                <td height="8"></td>
            </tr>
          <tr>
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/Compensation.jpg" width="100%" height="138" /></td>
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

                                                        <html:form action="/performance" enctype="multipart/form-data">

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
                                                                            <legend>Increment band</legend>
                                                                            <table width="80%" border="0" cellspacing="10" cellpadding="2">



                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">company name:</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">
                                                                                        <html:select property="company" onchange="getDepartment(this);" size="1" >
                                                                                            <html:option value="">--Select Company--</html:option>

                                                                                            <logic:present name="companylist" scope="request">
                                                                                                <html:options collection="companylist" property="companyCode" labelProperty="companyName"/>
                                                                                            </logic:present>

                                                                                        </html:select>

                                                                                </tr>
                                                                                <tr>

                                                                                    <td align="left" valign="middle" nowrap="nowrap">Department name:</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap" id="dept" rowspan="2">
                                                                                        <select name="department" size="1">
                                                                                            <option value="">--Select Department--</option>
                                                                                        </select>
                                                                                            <br/>
                                                                                            <br/>
                                                                                        <select name="designation" size="1">
                                                                                            <option value="">--Select Designation--</option>
                                                                                        </select>
                                                                                    </td>
                                                                                    <td align="right" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">                                </td>

                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">Designation name:</td>

                                                                                    <td align="right" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">                                </td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">Indicator:</td>
                                                                                    <td>
                                                                                 <select name="indicator">
                                                                                      <option value="">--Select Indicator--</option>
                                                                                 <logic:present name="indicatorlist" scope="request">

                                                                                  <logic:iterate id="ind" name="indicatorlist" scope="request">
                                                                                       
                                                                                    <option value="${ind.id}">${ind.indicator}</option>
                                                                                 </logic:iterate>
                                                                                 </logic:present>
                                                                                  </select>
                                                                                   </td>

                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap="nowrap">Measures(%):</td>
                                                                                    <td  align="left" valign="middle" nowrap="nowrap"> <html:text property="measure"/></td>

                                                                                </tr>






                                                                                <tr>
                                                                                    <td> <html:button property="button" value="Submit"  onclick="return save(this.form)" /></td>

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
	        		active: 8
	        	});
        	});

        </script>
    </body>
</html:html>


