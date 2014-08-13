<%-- 
    Document   : projectAdd
    Created on : Nov 22, 2010, 5:25:41 PM
    Author     : computer2
--%>


<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <html:base/>
        <title>HRMS :: Add New Project</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

       <script type="text/javascript" src="../js/jquery.1.9.12.js"></script>
        <script type="text/javascript" src="../js/jquery-ui.js"></script>
        <script type="text/javascript" src="../css/jquery-ui.css"></script>

        <!--script type="text/JavaScript" src="../js/accordion/javascript/calender/viewCalendar.js"></script-->
        <script language="javascript" type="text/JavaScript" src="../js/calender/viewCalendar.js"></script>
        <script type="text/JavaScript" src="../js/HRMS.js"></script>

        <script src="js/scripts.js"></script>
        <script type="text/JavaScript">
            function Add(form){
                form.method.value="saveOrEdit";
                 if(!checkBlank(form.clientId,'clientId'))
                {
                    return;
                }
                if(!checkBlank(form.projectCode,'projectCode'))
                {
                    return;
                }
                 if(!checkBlank(form.projectName,'projectName'))
                {
                    return;
                }
                if(!checkBlank(form.startDate,'startDate'))
                {
                    return;
                }
                  if(!checkBlank(form.dueDate,'dueDate'))
                {
                    return;
                }
                   if(!checkBlank(form.endDate,'endDate'))
                {
                    return;
                }
                  if(!checkBlank(form.month,'month'))
                {
                    return;
                }
                if(!checkBlank(form.department_id,'department_id'))
                {
                    return;
                }
                 if(!checkBlank(form.maximum_resource,'maximum_resource'))
                {
                    return;
                }
                if(!checkBlank(form.projectStatus,'projectStatus'))
                {
                    return;
                }
                 if(!checkNum(form.maximum_resource,'maximum_resource'))
                {
                    return;
                }


                /*             // if(!checkBlank(form.projectCode,'Project Code')){
                    return;
                }
                if(!checkBlank(form.projectName,'Project Name')){
                    return;
                }
                //if(!checkBlank(form.clientId,'Client Name')){
                   // return;
                //}
                 //if(!checkBlank(form.startDate,'Start Date')){
                    return;
                }
                // if(!checkBlank(form.dueDate,'Due Date')){
                    return;
                }
                // if(!checkBlank(form.projectStatus,'Project Status')){
                    return;
                }
               //if(confirm("Do you want to save?"))*/

                form.submit();



            }
            /*function showManagerselection(m)
                {
                alert(m);
                if(m==1)
                {
                        document.getElementById("managerSelection").className='visible'
                        document.getElementById("mansel").innerHTML='<a href="" onclick="javascript:showManagerselection(0)">Manager Selection:</a>'
                }
                else if(m==0)
                        document.getElementById("managerSelection").className='invisible'
                        document.getElementById("mansel").innerHTML='<a href="" onclick="javascript:showManagerselection(1)">Manager Selection:</a>'
                }*/

            function dateDifference(form){

                var frm_date=document.forms[0].startDate.value;
                var end_date=document.forms[0].dueDate.value;
                frm_date=frm_date.split("/");
                frm_date=frm_date[2]+frm_date[1]+frm_date[0];
                end_date=end_date.split("/");
                end_date=end_date[2]+end_date[1]+end_date[0];




                if (frm_date > end_date)
                {
                    alert("Start date cannot be greater than Due date");
                    document.forms[0].startDate.focus();
                    return false;
                }
                var vDateSplit = document.forms[0].startDate.value.split("/");
                vDate1 = vDateSplit[1] + "/" + vDateSplit[0] + "/" + vDateSplit[2];
                //alert(vDate1);
                var vDateSplit = document.forms[0].dueDate.value.split("/");
                vDate2 = vDateSplit[1] + "/" + vDateSplit[0] + "/" + vDateSplit[2];

                var d1 = new Date(vDate1)// + " " + document.forms[0].hours1[document.forms[0].hours1.selectedIndex].value + ":" + document.forms[0].minutes1[document.forms[0].minutes1.selectedIndex].value);
                //alert(d1)
                var d2 = new Date(vDate2)// + " " + document.forms[0].hours2[document.forms[0].hours2.selectedIndex].value + ":" + document.forms[0].minutes2[document.forms[0].minutes2.selectedIndex].value);
                //alert(d2)
                var vDifference = Math.round(((d2-d1)/(24*60*60*1000)+1)/30);

                document.forms[0].month.value = vDifference;
            }


        </script>


        <script type="text/javascript">
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

        <script type="text/JavaScript">
            function Edit(form){
                form.method.value="saveOrEdit";

                form.submit();

            }
            function loadData(form){
                //alert();

                form.method.value="load";

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
                <td width="100%" colspan="3" align="left" valign="top"><img src="../images/ProjectMangement.jpg" width="100%" height="138" /></td>
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
                                                        <html:form action="projectAdd">
                                                            <table width="80%" border="0" align="left" cellpadding="2" cellspacing="4" style="left: 655px; top: 370px;">

                                                                <tr>
                                                                    <td align="left" valign="top" colspan="2"><div id="errorMsg" ></div>

                                                                        <logic:messagesPresent message="true">

                                                                            <font color="green"> <b><img src="../images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                        </logic:messagesPresent>
                                                                        <logic:messagesPresent >

                                                                            <font color="red">  <html:messages id="error"><bean:write name="error"/></html:messages></font>

                                                                        </logic:messagesPresent >

                                                                    </td>
                                                                </tr>
                                                                        
                                                                <tr>
                                                                    <td height="30" colspan="2" align="center" valign="top" nowrap="nowrap"><font color="#990000" size="3"><b>New Project SetUp</b></font></td>
                                                                </tr>


                                                                <%-- <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Select Company Name:</td>
                                                                    <td align="left" valign="middle"><html:select property="company_code" onchange="loadData(this.form)">
                                                                           <!-- <html:option value="">---Select---</html:option>
                                                                           <!-- <logic:present name="companyList" scope="request" >
                                                                                <html:options collection="companyList" property="companyCode" labelProperty="companyName"/>
                                                                            </logic:present>
                                                                        </html:select> !--> <!--                     COMPANY IS NOT READY SO I CANT POPULATE COMPANY                                           -->
                                                                    </td>
                                                                </tr>

                                                                                                                <tr>
                                                                                                                    <td align="left" valign="middle" nowrap="nowrap">Select Branch Name:</td>
                                                                                                                    <td align="left" valign="middle" id="c"><html:select property="branch_code">
                                                                                                                            <html:option value="">---Select---</html:option>
                                                                                                                            <logic:present name="companyList" scope="request" >
                                                                                                                                <html:options collection="companyList" property="companyCode" labelProperty="companyName"/>
                                                                                                                            </logic:present>
                                                                                                                        </html:select>   <!--                     BRANCH IS NOT READY SO I CANT POPULATE BRANCH                                           -->
                                                                                                                    </td>
                                                                                                                </tr>!--%>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Select Client Name:</td>
                                                                    <td align="left" valign="middle" id="c"><html:select property="clientId" >
                                                                            <html:option value="">--Select Please--</html:option>
                                                                            <logic:present name="client" scope="request">
                                                                                <html:options collection="client" labelProperty="clientName" property="clId" />
                                                                            </logic:present>

                                                                        </html:select></td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Project Code:</td>
                                                                    <td align="left" valign="middle"><html:text property="projectCode" /></td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Project Name:</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:text property="projectName" /> </td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Project Description:</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:textarea  property="desc" rows="5"/></td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Project Start Date:</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:text  property="startDate"/>&nbsp;
                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].startDate,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" /></td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">DueDate:</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:text  property="dueDate"  onblur="dateDifference(this.form)"/>&nbsp;

                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].dueDate,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" /> </td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Project End Date:</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:text  property="endDate"/>&nbsp;
                                                                        <html:img onclick="javascript:popUpCalendar(this,document.forms[0].endDate,'dd/mm/yyyy')" src="../images/tlsCalendarIcon.gif" /></td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Planned Time (month):</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:text  property="month"/></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Select Department :</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:select property="department_id">
                                                                            <html:option value="">---Select---</html:option>
                                                                            <logic:present name="deptList" scope="request" >
                                                                                <html:options collection="deptList" property="departmentId" labelProperty="departmentName"/>
                                                                            </logic:present>
                                                                        </html:select>						</td>
                                                                </tr>

                                                                <tr>
                                                                    <td colspan="2" align="center" valign="middle" nowrap="nowrap" >
                                                                        <div style="margin-top:5px; width:20px;">
                                                                            <h4><img src="../images/expand.gif" alt="Show Div" height="25" border="0" style="margin-right:6px; margin-top:3px; margin-bottom:-3px; cursor:pointer;" onclick="showContent(this);" />Manager Selection</h4>
                                                                            <div style="margin-top:5px; display:none;">
                                                                                <table width="627" border="1">

                                                                                    <tr>
                                                                                        <td width="1">  </td>
                                                                                        <td width="132" align="center">
                                                                                            <strong>ManagerName</strong></td>
                                                                                        <td width="130" align="center">
                                                                                            <strong>Email Address</strong> </td>
                                                                                        <td width="91" align="center"><strong>Department Id</strong> </td>
                                                                                       
                                                                                    </tr>

                                                                                    <logic:present name="managerList" scope="request">

                                                                                        <logic:iterate id="itr" name="managerList" indexId="no">
                                                                                            <tr align="center">
                                                                                                <td>
                                                                                                    <input type="checkbox" name="manager_id"  value="<bean:write name="itr" property="managerId"></bean:write>"/>
                                                                                                </td>

                                                                                                <td><bean:write name="itr" property="firstName"></bean:write></td>
                                                                                                <td><bean:write name="itr" property="emailAddress"></bean:write></td>
                                                                                                <td><bean:write name="itr" property="departmentId"></bean:write></td>
                                                                                              <%--  <td><bean:write name="itr" property="taskName"></bean:write></td>
                                                                                                <td><bean:write name="itr" property="projectStatus"></bean:write></td> --%>

                                                                                            </tr>
                                                                                        </logic:iterate>
                                                                                    </logic:present>
                                                                                </table>
                                                                            </div></div>						   </td>
                                                                </tr>

                                                                <tr>
                                                                    <td align="left" valign="middle">                   </td>

                                                                    <td colspan="3" align="left" valign="middle"></td>
                                                                </tr>
                                                                <tr>

                                                                    <td align="left" valign="middle" nowrap="nowrap">Maximum Resource:</td>
                                                                    <td align="left" valign="middle">
                                                                        <html:text  property="maximum_resource"/></td>
                                                                </tr>


                                                                <tr>
                                                                    <td align="left" valign="middle" nowrap="nowrap">Project  Status: </td>
                                                                    <td align="left" valign="middle">
                                                                        <html:select property="projectStatus">
                                                                            <html:option value="">---Select---</html:option>
                                                                            <html:option value="OPEN">OPEN</html:option>
                                                                            <html:option value="CLOSE">CLOSE</html:option>
                                                                        </html:select></td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="3" align="left" valign="middle">					                                  </td>
                                                                    <td align="left" valign="middle">&nbsp; </td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="4" align="center" valign="middle">  <html:button property="button" value="Save" onclick = "Add(this.form)"/>
                                                                        <html:hidden property="method"/>                   </td>
                                                                </tr>

                                                                <tr>
                                                                    <td colspan="3" align="right" valign="middle"><html:link href="../loadprojectview.do?method=load"><font color="#5E2F2F" size="3"><b>�View Project Details</b></font></html:link>					                                  </td>
                                                                    <td align="left" valign="middle">&nbsp; </td>
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
        <script type="text/javascript">
        $(function() {
        	//loadAccordions();
	        	$( "#accrdins" ).accordion({
	        		collapsible: true,
	        		active: 2
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

