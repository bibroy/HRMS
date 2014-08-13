<%-- 
   Author--pradipto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<%@page  import="java.util.*" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS :: Employee Exit Details</title>
        <script type="text/javascript" src="../js/jquery.1.9.12.js"></script>
        <script type="text/javascript" src="../js/jquery-ui.js"></script>
        <script type="text/javascript" src="../css/jquery-ui.css"></script>
        <script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>
        <script type="text/javascript" src="../js/calender/viewCalendar.js"> </script>
        <script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>
        <script language="javascript" type="text/JavaScript" src="../js/tabMenu.js"></script>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

        <script language="JavaScript" type="text/javascript">

            function RetreivingExistingList(form)
            {
                form.method.value="loadDetails";
                

                if(EmployeeIdvalidation(form))
                {
                    form.submit();
                }
               
                

                else
                {


                    return false;

                }

            }

            function EmployeeIdvalidation(form)
            {

                if(!checkBlank(form.employeeId,'Employee ID'))
                {
                    //document.getElementById("errorMsg").innerHTML=" First Name Can't Blank";
                    // document.getElementById("errorMsg").className="errorMsg";

                    return false;
                }
                else{

                    document.getElementById("errorMsg").innerHTML="";
                    return true;
                }


            }


              



            function EditFnctnCall(form)
            {
                form.method.value="EmployeeExitDetailEditORsave";


              
               
            

                if(ipFieldValidation(form)){

                    form.submit();


                    //    document.getElementById("empCerationForm").className="submitAction";
                    //   document.getElementById("submitBtn").disabled = true;

                }
                else{




                    return false;
                }




            }



            function ipFieldValidation(form){

                if(!checkBlank(form.employeeId,'Employee ID'))
                {
                    //document.getElementById("errorMsg").innerHTML=" First Name Can't Blank";
                    // document.getElementById("errorMsg").className="errorMsg";

                    return false;
                }
                else{

                    document.getElementById("errorMsg").innerHTML="";
                }

                if(!checkBlank(form.firstName,'Name'))
                {
                    return false;
                }



                if(!checkBlank(form.designationId,'DesignationID'))
                {
                    return false;
                }


                if(!checkBlank(form.branchId,'Branch ID'))
                {
                    return false;
                }

                if(!checkBlank(form.dateOfJoin,'Date of Join'))
                {
                    return false;
                }
                if(!checkBlank(form.departmentId,'Department ID'))
                {
                    return false;
                }


                if(!checkBlank(form.nationality,'Nationality '))
                {
                    return false;
                }


                if(!checkBlank(form.status,'Status'))
                {
                    return false;
                }






                if(!checkBlank(form.employeeStatus,'Employee Status '))
                {
                    return false;
                }


                if(!checkBlank(form.reasonOfLeaving,'Reason of leaving job. '))
                {
                    return false;
                }






                else{
                    return true;

                }

            }

            function loadTask(form){
                form.method.value="load";
                alert(form.method.value);
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
               <td width="100%" colspan="3" align="left" valign="top"><img src="images/Employee.jpg" width="100%" height="138" /></td>
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


                                                        <html:form action="empexitdetailserverpath"  styleClass="none" styleId="empCerationForm">
                                                            <font color="red" face="verdana" size="4"> Employees exit details Information page</font>
                                                                        <hr/>
                                                            <!--Start Main table-->
                                                            <table width="100%"  cellpadding="0" cellspacing="4">
                                                                <tr>
                                                                    <td align="left" valign="top"><div id="errorMsg" ></div>

                                                                        <logic:messagesPresent message="true">

                                                                            <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                        </logic:messagesPresent>
                                                                        <logic:messagesPresent >

                                                                            <html:messages id="error"><bean:write name="error"/></html:messages>

                                                                        </logic:messagesPresent >

                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="top"><!--Start Personal Info table-->
                                                                        
                                                                        <table width="80%" border="0" cellspacing="4" cellpadding="2" >
                                                                            <tr><h3><td>Employee ID:</td></h3><td><html:text property="employeeId"  /></td><td><html:button property="button"  value="View" onclick="RetreivingExistingList(this.form);" /></td></tr>

                                                                <tr><td></td><td></td></tr>

                                                                <tr> <td>Name:</td><td><html:text property="firstName" readonly="true"/></td></tr>










                                                                <tr><td>Designation ID:</td><td><html:text property="designationId" readonly="true" />

                                                                    </td>
                                                                    <td>Branch ID:</td><td><html:text property="branchId" readonly="true"/></td></tr>
                                                                <tr><td>Date of Join:</td>
                                                                    <td nowrap><html:text property="dateOfJoin" readonly="true" />

                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].dateOfJoin,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" />

                                                                    </td>


                                                                    <td nowrap>Department ID: </td>
                                                                    <td><html:text property="departmentId" readonly="true" />
                                                                    </td>
                                                                </tr>

                                                                <tr><td>Nationality: </td>
                                                                    <td><html:text property="nationality" readonly="true" />
                                                                    </td>


                                                                    <td>Status: </td>
                                                                    <td><html:text property="status" readonly="true" />
                                                                    </td>
                                                                </tr>



                                                                <tr><td> Entered Date: </td>
                                                                    <td><html:text property="entryDate" readonly="true" />

                                                                    </td>


                                                                    <td>Employee Status: </td>
                                                                    <td><html:text property="employeeStatus" readonly="true"/>

                                                                </tr>





                                                                <tr><td nowrap valign="top" >Employee Reason of leaving job

                                                                    </td><td   colspan="2"><html:textarea property="reasonOfLeaving" cols="35" rows="4"/></td><td valign="top"><html:checkbox property="runaway" title="Employee status" value="runaway" >Runaway</html:checkbox></td>

                                                                </tr>











                                                                <tr><td><html:button property="button"  value="submit the details" onclick="EditFnctnCall(this.form);" /></td>


                                                            </table>
                                                                
                                                                
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="left" valign="top"></td>
                                                    </tr>
                                                    <tr>
                                                        <td align="left" valign="top">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td align="left" valign="top">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td align="left" valign="top">&nbsp;</td>
                                                    </tr>
                                                </table>
                                                                <hr/>
                                                <!--End Main Table-->
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
<script type="text/javascript">
        $(function() {
        	//loadAccordions();
	        	$( "#accrdins" ).accordion({
	        		collapsible: true,
	        		active: 6
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
</html>

