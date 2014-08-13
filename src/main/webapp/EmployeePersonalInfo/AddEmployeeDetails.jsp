<%--
    Document   : ADD EMPLOYEE FORM
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
        <title>HRMS ::Employee Details Report</title>
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />
        <link rel="stylesheet" href="css/displaytagex.css"/>
        <script type="text/javascript" src="js/calender/viewCalendar.js"> </script>
        <script language="JavaScript" type="text/javascript">




            function SubmitEmployeeInformation(form){
                form.method.value="SubmitEmployeeInformation";
                alert(form.method.value);

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



                if(!checkBlank(form.lastName,'Last name'))
                {
                    return false;
                }


                if(!checkBlank(form.presentAddress,'Present Address'))
                {
                    return false;
                }

                if(!checkBlank(form.permanentAddress,'Parmanent Address'))
                {
                    return false;
                }
                if(!checkBlank(form.emailAddress,'Email Address'))
                {
                    return false;
                }


                if(!checkBlank(form.mobileNo,'Contact number '))
                {
                    return false;
                }


                if(!checkBlank(form.bloodGroup,'bloodGroup'))
                {
                    return false;
                }






                if(!checkBlank(form.dateOfBirth,'Date of Birth '))
                {
                    return false;
                }


                if(!checkBlank(form.gender,'Gender. '))
                {
                    return false;
                }


                if(!checkBlank(form.religion,'Religion'))
                {
                    return false;
                }

                if(!checkBlank(form.nationality,'Nationality'))
                {
                    return false;
                }


                if(!checkBlank(form.languageKnown,'Language Known'))
                {
                    return false;
                }
                if(!checkBlank(form.hobby,'Hobby'))
                {
                    return false;
                }



                if(!checkBlank(form.identificationMark,'Identification Mark'))
                {
                    return false;
                }


                if(!checkChar(form.firstName,'Name'))
                {
                    return false;
                }



                if(!checkChar(form.lastName,'Last name'))
                {
                    return false;
                }


                if(!checkAddress(form.presentAddress,'Present Address'))
                {
                    return false;
                }

                if(!checkAddress(form.permanentAddress,'Parmanent Address'))
                {
                    return false;
                }
                if(!checkEmail(form.emailAddress,'Email Address'))
                {
                    return false;
                }


                if(!checkPhnNo(form.mobileNo,'Contact number '))
                {
                    return false;
                }

                if(!checkChar(form.religion,'Religion'))
                {
                    return false;
                }

                if(!checkChar(form.nationality,'Nationality'))
                {
                    return false;
                }


                if(!checkChar(form.languageKnown,'Language Known'))
                {
                    return false;
                }
                if(!checkChar(form.hobby,'Hobby'))
                {
                    return false;
                }



                if(!checkChar(form.identificationMark,'Identification Mark'))
                {
                    return false;
                }






                form.submit();

            }


                





            function loadAllmaster(form){
                form.method.value="LoadAllMaster";
                
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

                                                        <table width="600" border="0" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td class="body_top">&nbsp;</td>
                                                            </tr>
                                                            <tr>
                                                                <td class="body_mid" style="padding:0 0 0 5px;" valign="top" width="600">

                                                                    <html:form action="addEmployee.do" styleClass="none" styleId="empCerationForm" enctype="multipart/form-data">

                                                                        <center><h4 style="background-color: window;border-color:burlywood; width:500px; "><font color="red">Personal Information</font></h4></center>

                                                                        <hr/>
                                                                        <br>
                                                                        <table width="600" border="0" cellspacing="4" style="border:none;"  cellpadding="2" style="Background:oldlace" >
                                                                            <br>
                                                                            <tr>
                                                                                <td align="left" valign="top" style="border:none;"><div id="errorMsg" ></div>

                                                                                    <logic:messagesPresent message="true">

                                                                                        <font color="green"> <b><img src="images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                                    </logic:messagesPresent>
                                                                                    <logic:messagesPresent >

                                                                                        <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                                    </logic:messagesPresent >
                                                                                </td>

                                                                            </tr>
                                                                            <table width="600" border="0" cellspacing="4"   cellpadding="2" style="Background:cornsilk" >
                                                                                <tr>
                                                                                    <td nowrap="true"  valign="top">Candidate Image</td>
                                                                                    <td valign="top"><html:file property="imageFile" style="Background:#F4F4F4" onblur="loadpic(this,this.form);"/></td>

                                                                                    <td align="left" valign="middle" nowrap rowspan="4" ><img  name="canImage" style="visibility: hidden; height: 150px; width: 135px;" alt="Browse and click here for Candidate's Picture"  src="" onclick="return false;" /> </td></tr>
                                                                                <tr>


                                                                                    <td nowrap="true" valign="top">Enter Employee ID:</td><td valign="top"><html:text property="employeeId" style=" Background:#F4F4F4 " /></td></tr>
                                                                                <tr>


                                                                                    <td nowrap="true" valign="top">Enter first name:</td><td valign="top"><html:text property="firstName" style=" Background:#F4F4F4 " /></td></tr>
                                                                                <tr>
                                                                                    <td nowrap="true" valign="top">Enter last name:</td><td valign="top"><html:text property="lastName" style=" Background:#F4F4F4 " /></td></tr>




                                                                            </table>

                                                                            <br>










                                                                            <table width="600" border="0" cellspacing="4"   cellpadding="2" style="Background:cornsilk" >




                                                                                <tr valign="top"><td colspan="2">Present address:</td><td colspan="2"><html:textarea property="presentAddress"  cols="47"  rows="3" style=" Background:#F4F4F4 " /></td></tr>
                                                                                <tr valign="top"> <td colspan="2">Permanent address:</td><td colspan="2"><html:textarea property="permanentAddress" cols="47"  rows="3" style=" Background:#F4F4F4 " /></td></tr>






                                                                                <tr><td nowrap="true">Email address:</td><td><html:text property="emailAddress" style=" Background:#F4F4F4 " /></td>
                                                                                    <td>Contact number:</td><td><html:text property="mobileNo" style=" Background:#F4F4F4 " /></td></tr>
                                                                                <tr><td>Blood group:</td><td><html:text property="bloodGroup" style=" Background:#F4F4F4 " /></td>
                                                                                    <td>Date of birth:</td><td><html:text property="dateOfBirth" style=" Background:#F4F4F4 " />

                                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].dateOfBirth,'dd/mm/yyyy')" src="images/tlsCalendarIcon.gif" />
                                                                                    </td></tr>

                                                                                <tr><td>Gender:</td><td><html:select  property="gender" style=" Background:#F4F4F4 ">
                                                                                            <html:option value="male"> </html:option>



                                                                                            <html:option value="female">

                                                                                            </html:option></html:select></td>
                                                                                    <td>Religion:</td><td><html:text property="religion" style=" Background:#F4F4F4 " /></td></tr>


                                                                                <tr><td>Nationality:</td><td><html:text property="nationality" style=" Background:#F4F4F4 " /></td>
                                                                                    <td>Language known:</td><td><html:text property="languageKnown" style=" Background:#F4F4F4 " /></td></tr>

                                                                                <tr><td>Hobby:</td><td><html:text property="hobby" style=" Background:#F4F4F4 " /></td>
                                                                                    <td>Identification Mark:</td><td><html:text property="identificationMark" style=" Background:#F4F4F4 " /></td></tr>

                                                                                <tr>
                                                                                    <td nowrap="true">Employee Status:</td><td><html:select property="status" style=" Background:#F4F4F4 "  >
                                                                                            <html:option value="Y">

                                                                                            </html:option>

                                                                                            <html:option value="N">

                                                                                            </html:option>
                                                                                        </html:select></td></tr>









                                                                            </table>




                                                                            <br>

                                                                            <hr>
                                                                            <h4><font color="red">Official Information</font></h4>
                                                                            <br>

                                                                            <table width="600" border="0" cellspacing="4"   cellpadding="2" style="Background:oldlace" >
                                                                                <tr><td>Department</td><td>

                                                                                        <html:select property="deptId" style=" Background:#F4F4F4 " >
                                                                                            <html:option value="">--Select Please--</html:option>
                                                                                            <logic:present name="department" scope="request">
                                                                                                <html:options collection="department" labelProperty="departmentName" property="departmentId"  />
                                                                                            </logic:present>
                                                                                        </html:select>

                                                                                    </td>
                                                                                    <td>Branch Name:</td><td><html:select property="brId" style=" Background:#F4F4F4 " >
                                                                                            <html:option value="">--Select Please--</html:option>
                                                                                            <logic:present name="Branches" scope="request">
                                                                                                <html:options collection="Branches" labelProperty="branchName" property="branchId"  />
                                                                                            </logic:present>
                                                                                        </html:select></td></tr>



                                                                                <tr> <td>Supervisor Name:</td><td><html:select property="supervisorId"  style=" Background:#F4F4F4 ">
                                                                                            <html:option value="">--Select Please--</html:option>
                                                                                            <logic:present name="supervisor" scope="request">
                                                                                                <html:options collection="supervisor" labelProperty="supervisorId" property="supervisorId"  />
                                                                                            </logic:present>
                                                                                        </html:select></td>


                                                                                    <td>Designation Name:</td><td><html:select property="designation_id"  style=" Background:#F4F4F4 ">
                                                                                            <html:option value="">--Select Please--</html:option>
                                                                                            <logic:present name="designation" scope="request">
                                                                                                <html:options collection="designation" labelProperty="designationName" property="designationId"  />
                                                                                            </logic:present>
                                                                                        </html:select></td></tr>

                                                                                <tr>
                                                                                    <td rowspan="2">Role ID   </td>
                                                                                    <td><html:select property="roleID"  style=" Background:#F4F4F4 ">
                                                                                            <html:option value="">--Select Please--</html:option>
                                                                                            <logic:present name="Roles" scope="request">
                                                                                                <html:options collection="Roles" labelProperty="roleName" property="roleId"  />
                                                                                            </logic:present>
                                                                                        </html:select>
                                                                                    </td>

                                                                                    <td rowspan="2">Job Type  </td>
                                                                                    <td>
                                                                                        <html:select property="jobtypeId"  style=" Background:#F4F4F4 ">
                                                                                            <html:option value="">--Select Please--</html:option>
                                                                                            <logic:present name="allJobs" scope="request">
                                                                                                <html:options collection="allJobs" labelProperty="jobname" property="typeId"  />
                                                                                            </logic:present>
                                                                                        </html:select>
                                                                                    </td>
                                                                                </tr>

                                                                            </table>

                                                                        </table>
                                                                        <br>
                                                                        <br>

                                                                        <center> <html:button property="button" style=" Background:#F4F4F4 "  value="submit the details" onclick="SubmitEmployeeInformation(this.form);" /><html:reset property="reset" /></center>
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
	        		active: 1
	        	});
        	});

        </script>
    </body>

</html>
