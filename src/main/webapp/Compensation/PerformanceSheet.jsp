<%--
    Document   : performance sheet
    Created on : Jan 13, 2011, 12:15:48 PM
    Author     : pranav kumar
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
        <title>HRMS :: Performance sheet</title>
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />
        <script type="text/javascript" src="js/ajaxpagefetcher.js"> </script>
        
        <script language="javascript" type="text/JavaScript" src="js/HRMS.js"></script>

        <script type="text/javascript">

            function add(form)
            {
                form.method.value="getIndicatorForPerformancesheet";
                 if(!checkBlank(form.empid,'Employee id'))
                {
                    return;
                }

                 form.submit();
               
            }

            function save(form)
            {

                form.method.value="savecompensationperformancesheet";
                 if(!checkBlank(form.obtainmeasure,'Obtain measure'))
                {
                    return;
                }

                 form.submit();

            }
             function openWindow(empid,indicatorname){
                // --- alert("open the popup");
                fnFurtherDetail(empid,indicatorname);
                return false;
            }

            function fnFurtherDetail(empid,indicatorname) {

                //var linkPage="/gmswar/jspmodule1/Popup.do?dueDate="+dueDate+"&accMgr="+accMgr+"&reminder="+reminder+"&tasks="+tasks+"&orgnm="+orgname+"&orgno="+orgno+"&trust="+trust+"&foundation="+foundation+"&popup=PopUp&flg=Popup&reminderId="+reminderId+"&grantId="+grantId+"&lastUpdtBy="+lastUpdtBy+"&flgaction=update";
                var linkPage="performancesheet.do?method=getReportForPerformancesheet&empid="+empid+"&indicatorname="+indicatorname;
                //alert(linkPage);
                window.open (linkPage,'PopUp','left=270,top=200,toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, directories=no, status=no,width=697,height=200');
                //document.forms[0].submit();
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

                                                        <html:form action="/performancesheet" enctype="multipart/form-data">

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
                                                                            <legend>performance sheet</legend>
                                                                            <table width="80%" border="0" cellspacing="10" cellpadding="2">
                                                                                <tr>
                                                                                    <td width="31%" align="left" valign="middle" nowrap="nowrap" >ENTER EMPLOYEE ID</td>
                                                                                    <td  width="29%" align="left" valign="middle" nowrap="nowrap"><html:text property="empid"/></td>

                                                                                    <td> <html:button property="button" value="load"  onclick="return add(this.form)" /></td>
                                                                                    

                                                                                </tr>
                                                                                <tr><td colspan="3"><logic:present name="indicator" scope="request">
                                                                                            <table>
                                                                                                <tr>
                                                                                                    <th width="30%">Indicator</th>
                                                                                                    <th width="30%">Total Measure</th>
                                                                                                    <th width="30%">Obtain Measure</th>
                                                                                                </tr>
                                                                                                <logic:iterate id="ind" name="indicator">
                                                                                                    <tr><td>
                                                                                                    <table><tr>
                                                                                                            <td width="30%">
                                                                                                            <bean:write name="ind" property="indicatorname"/>
                                                                                                            <input type="hidden" name="indicatorid" value="<bean:write name="ind" property="indicatorid"/>"
                                                                                                        </td>
                                                                                                        </tr>
                                                                                                    </table></td>
                                                                                                    <td width="30%">
                                                                                                        <input type="text" size="5" name="totalmeasure" readonly="true" value="<bean:write name="ind" property="totalmeasure"/>"
                                                                                                        </td>

                                                                                                        
                                                                                                        

                                                                                                        <td width="30%"> <input type="text" size="5" name="obtainmeasure"/> </td>
                                                                                                        
                                                                                                        <td valign="middle"><a href="#"  onclick="return openWindow(<bean:write name='ind' property='empid'/>,'<bean:write name='ind' property='indicatorname'/>');"><img src="images/report.gif" style="border-style:none"/><bean:write name="ind" property="indicatorname"/></a></td>
                                                                                                        
                                                                                                         
                                                                                                   </tr>

                                                                                                </logic:iterate>
                                                                                                   <tr>  <td> <html:button property="button" value="submit"  onclick="return save(this.form)" /></td>
                                                                                                     </tr>
                                                                                            </table>
                                                                                        </logic:present>
                                                                                    </td>
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

