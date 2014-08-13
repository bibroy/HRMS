<%-- 
    Document   : trainingMaster
    Created on : Nov 15, 2010, 4:54:07 PM
    Author     : computer2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<html:base/>
<html:html lang="true">
<head>

<title>Training Master</title>
<link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />


<!--script type="text/javascript" src="../js/accordion/javascript/prototype.js"></script>
<script type="text/javascript" src="../js/accordion/javascript/effects.js"></script>
<script type="text/javascript" src="../js/accordion/javascript/accordion.js"></script-->
<script type="text/javascript" src="../js/ajaxpagefetcher.js"> </script>
<script type="text/javascript" src="../js/calender/viewCalendar.js"> </script>
<script language="javascript" type="text/JavaScript" src="../js/HRMS.js"></script>
<script src="../js/scripts.js"></script>

	<script type="text/javascript">

	function addTraining(form){
        form.method.value="addTraining";
        //alert("control is here") ;
        //return false;
        if(chkAllFields(form)){
            form.submit();
        }
        else{
            return false;
        }
    }

    function winRefreshMaster(form){
        //window.location.href="../HRMS/trainingAdd.do?method=viewDtl";
        // === window.location.href="./trainingAdd.do?method=trainingReport";
        // === return false;
        // === alert("Inside");
        form.method.value="menuPage";
        // === alert("after set");
        form.submit();
    }

    /*** ajax implimentation ***/
        /***
         *get JobType through ajax call
         */
        function desSelJobType(sel){

        //alert("--- value ---"+sel.options[sel.selectedIndex].value);

         var deptId=sel.options[sel.selectedIndex].value;
         //if(sel.options.selectedIndex == 0){
              //window.alert('Please choose an option as Country');
              //return false;
          // }
          var add="../loadJobType.do?method=viewJobTypeAgainstDept&deptId="+deptId;
         //document.location.href=add;
         //alert("$$$"+add);
         ajaxpagefetcher.load('jobTypes',add,true);
    }

        /***
         *get skills through ajax call
         */
        function desSkills(sel){
            var typeId=sel.options[sel.selectedIndex].value;
            if(sel.options.selectedIndex == 0){
              window.alert('Please choose an option as JobType Nature');
              return false;
           }

            var add="../loadSkills.do?method=showSkillsAgainstJobType&typeId="+typeId;
            ajaxpagefetcher.load('skillTypes',add,true);
        }
        /***
         *get consultancy through ajax call
         */
        function desSelState(sel){
        //alert("--- value ---"+sel.options[sel.selectedIndex].value);
         var skilId=sel.options[sel.selectedIndex].value;
         if(sel.options.selectedIndex == 0){
              window.alert('Please choose an option as Consultant Nature');
              return false;
           }
          var add="../loadConsultancy.do?method=populateConsultancyList&skillId="+skilId;
         //document.location.href=add;
         //alert("$$$"+add);
         ajaxpagefetcher.load('consult',add,true);
    }


    /*** ajax implimentation ***/
    /***
     * Check all fields
     */
    function chkAllFields(form){
            //alert("-- ---"+form.ddlTrainingMode.selectedIndex);
            if(!checkBlank(form.trainingName,' Training Name')){
                return false;
            }
            else if(!checkOption(form.department,' Department')){
                return false;
            }

            else if(!checkBlank(form.trainerName,' Trainer Name')){
                return false;
            }
            else if(!checkOption(form.jobType,' JobType')){
                    return false;
    	   }
            else if(!checkOption(form.ddlSkillsName,' Skill Set')){
                    return false;
    	   }
           else if(!checkOption(form.ddlTrainingMode,' Mode of Trainer')){
                    return false;
           }
           else if(form.ddlTrainingMode.selectedIndex==2){
                    if((!checkOption(form.ddlConsultancy,'Consultant"\'\"s Nature'))){
                        return false;
                    }
                    else{
                        return true;
                    }
    	   }
          // else if((checkOption(form.ddlConsultancy,'Consultancy'))&& form.ddlTrainingMode.selectedIndex==1){
           else if((form.ddlConsultancy.selectedIndex > 0)&& form.ddlTrainingMode.selectedIndex==1){
                   alert("For internal training Consultancy must be blank");
                   return false;
           }
           else{
                return true;
            }
        }


    /***
     * Check all fields
     */

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
               <td width="100%" colspan="3" align="left" valign="top"><img src="../images/Training.jpg" width="100%" height="138" /></td>
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

                                                                                                                <html:form action="/trainingAdd" method="post" >
                                                                                                                           <table >
                                                                                                                            <tr>
                                                                                                                                <td width="1%">&nbsp;</td>
                                                                                                                                <td width="99%"><div id="errorMsg" ></div></td>
                                                                                                                                <td width="0%">&nbsp;</td>
                                                                                                                            </tr>
                                                                                                                            <tr>
                                                                                                                                <td colspan="2" align="left"><span class="normal_black_text" style="font-weight: bold">Fill Up all Mandatory fields(</span><span class="normal_black_text"><span class="style3">*</span></span><span class="normal_black_text" style="font-weight: bold">):- </span></td>
                                                                                                                            </tr>
                                                                                                                            <tr>
                                                                                                                                <td valign="middle"><span class="style3">*</span>Training Name</td>
                                                                                                                                <td valign="middle" align="left"><html:text property="trainingName" indexed="trainingName" /></td>
                                                                                                                            </tr>
                                                                                                                             <tr>
                                                                                                                                 <td valign="middle"><span class="style3">*</span>Department</td>
                                                                                                                                 <td valign="middle" align="left">
                                                                                                                                     <html:text property="department" /> 
                                                                                                                                    <html:select property="department" onchange="return desSelJobType(this)" style="width:23%">
                                                                                                                                           <html:option value="" >-Select-</html:option>
                                                                                                                                        <logic:present name="departments" scope="request">
                                                                                                                                                <html:options collection="departments" property="departmentId" labelProperty="departmentName" />
                                                                                                                                         </logic:present>
                                                                                                                                    </html:select>
                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                            <add jobtype based on department>
                                                                                                                            <tr>
                                                                                                                                <td valign="middle"><span class="style3">*</span>JobType</td>
                                                                                                                                <td id="jobTypes" valign="middle" align="left">
                                                                                                                                     <html:text property="department" /> 
                                                                                                                                    <html:select property="jobType" onchange="return desSkills(this)" indexed="jobId" style="width:23%">
                                                                                                                                        <html:option value="" >-Select-</html:option>
                                                                                                                                        <logic:present name="jobTypes" scope="request">
                                                                                                                                                <html:options collection="jobTypes" property="typeId" labelProperty="jobName" />
                                                                                                                                         </logic:present>
                                                                                                                                    </html:select>
                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                            <add jobtype based on department>
                                                                                                                            <add skills based on jobType >
                                                                                                                            <tr>
                                                                                                                                <td valign="middle"><span class="style3">*</span>Skill Set</td>
                                                                                                                                <td id="skillTypes" valign="middle" align="left">
                                                                                                                                    <html:select property="ddlSkillsName" onchange="return desSelState(this)" indexed="skillId" style="width:23%">
                                                                                                                                        <html:option value="" >-Select-</html:option>
                                                                                                                                        <logic:present name="skills" scope="request">
                                                                                                                                                <html:options collection="skills" property="skillId" labelProperty="skillName" />
                                                                                                                                         </logic:present>
                                                                                                                                    </html:select>
                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                            <add jobtype based on jobType >
                                                                                                                             <tr>
                                                                                                                                 <td valign="middle">Consultant's Nature</td>
                                                                                                                                 <td id="consult" valign="middle" align="left">
                                                                                                                                    <html:select property="ddlConsultancy" indexed="consultancyId" style="width:23%">
                                                                                                                                        <html:option value="">-Select-</html:option>
                                                                                                                                        <logic:present name="consultancyList" scope="request">
                                                                                                                                                <html:options collection="consultancyList" property="consultancyId" labelProperty="consultancyName" />
                                                                                                                                         </logic:present>
                                                                                                                                    </html:select>
                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                            <tr>
                                                                                                                                <td valign="middle"><span class="style3">*</span>Mode of Trainer</td>
                                                                                                                                <td valign="middle" align="left">
                                                                                                                                    <html:select property="ddlTrainingMode" style="width:23%">
                                                                                                                                        <html:option value="">-Select-</html:option>
                                                                                                                                        <html:option value="internal">Internal</html:option>
                                                                                                                                        <html:option value="external">External</html:option>
                                                                                                                                    </html:select>
                                                                                                                                </td>
                                                                                                                            </tr>

                                                                                                                            <tr>
                                                                                                                                <td valign="middle">Trainer Name</td>
                                                                                                                                <td align="left"><html:text  property="trainerName" indexed="trainerName" /></td>
                                                                                                                            </tr>

                                                                                                                            <tr>
                                                                                                                                <td valign="top"><span class="style3">*</span>Training Position</td>
                                                                                                                                <td align="left">
                                                                                                                                    <html:select property="ddlPosition" size="7" multiple="true" indexed="positionId"  style="width:23%">
                                                                                                                                       <logic:present name="positions" scope="request">
                                                                                                                                           <html:options collection="positions" property="city_id" labelProperty="city_name" />
                                                                                                                                        </logic:present>
                                                                                                                                    </html:select>
                                                                                                                                </td>
                                                                                                                            </tr>


                                                                                                                            
                                                                                                                            <tr>
                                                                                                                                <td align="right">Designation</td>
                                                                                                                                <td><html:text  property="designation"/></td>
                                                                                                                            </tr>
                                                                                                                            
                                                                                                                            <tr>
                                                                                                                                <td valign="middle"><span class="style3">*</span>Status</td>
                                                                                                                                <td align="left">
                                                                                                                                    <html:select property="ddlStatus" style="width:23%">
                                                                                                                                       <html:option value="initiated">Initiated</html:option>
                                                                                                                                        <html:option value="hold">Hold</html:option>
                                                                                                                                    </html:select>
                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                            
                                                                                                                            <tr>
                                                                                                                                <td valign="top">
                                                                                                                                    Training Session
                                                                                                                                </td>
                                                                                                                                <td align="left">
                                                                                                                                    <html:select property="ddlsessionType" indexed="sessionTypeId" multiple="true">
                                                                                                                                        <logic:present name="trainingTypes" scope="request">
                                                                                                                                                <html:options collection="trainingTypes" property="trainingTypeId" labelProperty="typeName" />
                                                                                                                                         </logic:present>
                                                                                                                                    </html:select>
                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                                   
                                                                                                                          

                                                                                                                            <tr>
                                                                                                                                <td valign="middle">Training For</td>
                                                                                                                                <td align="left">
                                                                                                                                    <select name="expLavel">
                                                                                                                                        <option>-select-</option>
                                                                                                                                        <option value="0-1">0-1</option>
                                                                                                                                        <option value="1-3">1-3</option>
                                                                                                                                        <option value="3-4">3-4</option>
                                                                                                                                        <option value="4-">4-above</option>
                                                                                                                                    </select>
                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                            
                                                                                                                            <tr>
                                                                                                                                <td align="right">
                                                                                                                                    <html:button property="save" value="Save" onclick="return addTraining(this.form)"/>
                                                                                                                                    <html:hidden property="method" value="addTraining"/><html:hidden property="trainingId" />
                                                                                                                                    <html:hidden property="departmentId" />
                                                                                                                                </td>
                                                                                                                                <td align="left">
                                                                                                                                    <html:cancel property="cancel" onclick="return winRefreshMaster(this.form);" />
                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                        </table>
                                                                                                                </html:form>
                                                                                                                    <Page load here >

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

