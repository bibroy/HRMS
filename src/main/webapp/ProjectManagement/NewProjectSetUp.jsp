<%-- 
    Document   : New Project SetUp
    Created on : Nov 22, 2010, 5:15:38 PM
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
        <title>HOME</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />


        <script type="text/javascript" src="../js/accordion/javascript/prototype.js"></script>
        <script type="text/javascript" src="../js/accordion/javascript/effects.js"></script>
        <script type="text/javascript" src="../js/accordion/javascript/accordion.js"></script>
        <script type="text/JavaScript" src="../js/accordion/javascript/calender/viewCalendar.js"></script>
        <script type="text/JavaScript" src="../js/HRMS.js"></script>

        <script src="js/scripts.js"></script>
        <script type="text/JavaScript">
            function Add(form){
                form.method.value="saveOrEdit";
                /*if(!checkBlank(form.projectCode,'Project Code')){
                    return;
                }
                if(!checkBlank(form.projectName,'Project Name')){
                    return;
                }
                //if(!checkBlank(form.clientId,'Client Name')){
                   // return;
                //}
                 if(!checkBlank(form.startDate,'Start Date')){
                    return;
                }
                 if(!checkBlank(form.dueDate,'Due Date')){
                    return;
                }
                 if(!checkBlank(form.projectStatus,'Project Status')){
                    return;
                }
               if(confirm("Do you want to save?"))*/

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


        <style type="text/css">
            <!--
            .style3 {
                color: #804040;
                font-size: 14px;
                font-weight: bold;
            }
            -->
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
                <td width="100%" colspan="3" align="left" valign="top"><img src="images/ProjectMangement.jpg" width="100%" height="138" /></td>
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

                                                        <table width="200" border="1" style="position:absolute; left: 641px; top: 246px; width: 316px;">
                                                            <tr>
                                                                <td><html:link href="clientGroupAdd.jsp">
                                                                        ClientGroup Add</html:link></td>
                                                                </tr>
                                                                <tr>
                                                                    <td><html:link href="../loadclientadd.do?method=load">Client Information SetUp</html:link>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td><html:link href="../loadprojectadd.do?method=load">New Project SetUp</html:link></td>
                                                            </tr>
                                                        </table>

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

