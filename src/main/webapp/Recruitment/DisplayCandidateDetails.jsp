<%-- 
    Document   : DisplayCandidateDetails
    Created on : Dec 29, 2010, 11:05:44 AM
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
        <title>HRMS :: Display Candidate Details</title>
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />
        <script type="text/javascript" src="js/ajaxpagefetcher.js"> </script>
        <script language="javascript" type="text/JavaScript" src="js/calender/viewCalendar.js"></script>
        <script language="javascript" type="text/JavaScript" src="js/HRMS.js"></script>

        <script type="text/javascript">


            function show(form)
            {
                form.method.value="getCandidateDetails";
                if(!checkBlank(form.id,'Candidate Id'))
                {
                    return;
                }
               
                form.submit();
            }

            function finalize(form)
            {
                form.method.value="loadCandiateMarks";
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
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/Recruitment.jpg" width="100%" height="138" /></td>
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

                                                        <html:form action="addrecruit" enctype="multipart/form-data">

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

                                                                        <table width="90%" border="0" cellspacing="4" cellpadding="2" >
                                                                            <tr>
                                                                                <td align="left" valign="middle" nowrap>Candidate Id:</td>
                                                                                <td align="left" valign="middle" nowrap><html:text property="id"/></td>
                                                                                <td align="left" valign="middle" nowrap> <html:button property="button" value="Submit"  onclick="return show(this.form)" /></td>
                                                                                <td align="left" valign="middle" nowrap></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td colspan="4">
                                                                                    <c:if test="${requestScope.candidate!=null}" >


                                                                                        <table border="0" width="100%">
                                                                                            <tr>
                                                                                            <hr/>
                                                                                            <td align="left" valign="middle" nowrap>Name :</td>
                                                                                            <td align="left" valign="middle" nowrap>
                                                                                                <c:if test="${requestScope.candidate != null}" >
                                                                                                    <bean:write scope="request" name="candidate" property="firstName"/>&nbsp;<bean:write scope="request" name="candidate" property="middleName"/>&nbsp;<bean:write scope="request" name="candidate" property="lastName"/>
                                                                                                </c:if>
                                                                                            </td>
                                                                                            <td align="left" valign="middle" nowrap colspan="2" rowspan="5" width="20%"><img alt="Candidate's Image" src="Recruitment/Image.jsp?imgId=<bean:write  scope="request" name="candidate" property="id"/>" height="150px" width="135px"/></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap>DOB :</td>
                                                                                    <td align="left" valign="middle" nowrap><bean:write scope="request" name="candidate" property="dob"/></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap>Post Applied for :</td>
                                                                                    <td align="left" valign="middle" nowrap><bean:write scope="request" name="candidate" property="postApplied"/></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap>Status :</td>
                                                                                    <td align="left" valign="middle" nowrap><bean:write scope="request" name="candidate" property="status"/></td>

                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap>Phone No :</td>
                                                                                    <td align="left" valign="middle" nowrap><bean:write scope="request" name="candidate" property="phoneNo"/></td>

                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="left" valign="middle" nowrap>Email Id :</td>
                                                                                    <td align="left" valign="middle" nowrap><bean:write scope="request" name="candidate" property="emailId"/></td>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                </tr>
                                                                                <tr>
                                                                                <hr/>
                                                                                <td align="left" valign="middle" nowrap>Skills : </td>
                                                                                <td align="left" valign="middle" nowrap><bean:write scope="request" name="candidate" property="skills"/></td>
                                                                                <td>&nbsp;</td>
                                                                                <td>&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td align="left" valign="middle" nowrap>Experience : </td>
                                                                        <td align="left" valign="middle" nowrap><bean:write scope="request" name="candidate" property="exp"/></td>
                                                                        <td>&nbsp;</td>
                                                                        <td>&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td align="left" valign="middle" nowrap>Experience Description : </td>
                                                                        <td align="left" valign="middle" nowrap><bean:write scope="request" name="candidate" property="expdesc"/></td>
                                                                        <td>&nbsp;</td>
                                                                        <td>&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td align="left" valign="middle" nowrap>Highest Qualification : </td>
                                                                        <td align="left" valign="middle" nowrap><bean:write scope="request" name="candidate" property="quali"/></td>
                                                                        <td>&nbsp;</td>
                                                                        <td>&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="4"></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td align="left" valign="middle" nowrap>&nbsp;</td>
                                                                        <td align="left" valign="middle" nowrap><html:button property="button" value="Finalize" onclick="finalize(this.form)"/></td>
                                                                    </tr>
                                                                </table>
                                                                <hr/>
                                                            </c:if>
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
	        		active: 4
	        	});
        	});

        </script>
</body>
</html:html>
