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
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>HOME</title>
<link rel="stylesheet" href="../css/style.css" type="text/css" media="screen" />

<script type="text/javascript" src="../js/accordion/javascript/prototype.js"></script>
<script type="text/javascript" src="../js/accordion/javascript/effects.js"></script>
<script type="text/javascript" src="../js/accordion/javascript/accordion.js"></script>
<script src="../js/scripts.js"></script>
<script src="appraisal.js/AppraisalJSFile.js"></script>


<style type="text/css">

#dhtmltooltip{
position: absolute;
width: 150px;
border: 2px solid black;
padding: 2px;
background-color: lightyellow;
visibility: hidden;
z-index: 100;
/*Remove below line to remove shadow. Below line should always appear last within this CSS*/
filter: progid DXImageTransform.Microsoft.Shadow(color=gray,direction=135);
}
</style>
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
<script>
function edit(form){
form.method.value="getCategoryDetails";
form.submit();
NewWindow('callerPage.jsp','name','600','400','yes');

}
function del(form)
{
form.method.value="deleteAppraisalCategory";
form.submit();

}
</script>
<script language="javascript" type="text/javascript">
    function increamentTxtBox(id){
        var id=id+1;
        //alert(id);
        var id2=id+1;
        document.getElementById(id).innerHTML='<table  cellpadding="0" cellspacing="0" border="1"> <tr bgcolor="white"><td><b>Question:</b>&nbsp;&nbsp;&nbsp;</td><td><input type="text" name="question" size="40"/></td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>Type:&nbsp;&nbsp;&nbsp;</b></td><td><select name="category_code"><option>Select Category</option><logic:present name="categorylist" scope="request"><logic:iterate id="itr" name="categorylist"><option value="<bean:write  name="itr" property="category_code"/>"><bean:write  name="itr" property="category_name"/></option></logic:iterate></logic:present></select></td></tr></table></div><div id="'+id2+'"></div>';
        document.getElementById("divAddMore").innerHTML ='<label title="No. of Text Box'+id+'"  onclick="increamentTxtBox('+id+')" style="cursor:pointer" ><input type="button" value="Add More >>"></label>';



        document.getElementById("remove").innerHTML='<label  title="No. of Text Box'+id+'"  onclick="removeTxtBox('+id+')" style="cursor:pointer" ><input type="button" value="remove" src="images/submit_button.jpg"></label>';

    }



    function removeTxtBox(id){
        if(id > 1){
            document.getElementById(id).innerHTML='';
            id=id-1;
            document.getElementById("divAddMore").innerHTML ='<label title="No. of Text Box'+id+'"  onclick="increamentTxtBox('+id+')" style="cursor:pointer" ><input type="button" value="Add More >>"></label>';
            document.getElementById("remove").innerHTML='<label title="No. of Text Box'+id+'"  onclick="removeTxtBox('+id+')" style="cursor:pointer" ><input type="button" value="remove" src="images/submit_button.jpg"></label>';
        }
        else{
            alert("You Must Use Atleast One Text Input");
            document.getElementById("remove").innerHTML='';

        }

    }

</script>

</head>

<body bottommargin="0" leftmargin="0" topmargin="0" rightmargin="0">
<table border="0" cellspacing="0" cellpadding="0" align="center" class="main_table">
<tr>
<td align="left" class="header_logo" valign="bottom">
<table width="980" height="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
<td width="950">&nbsp;</td>
<td width="30" height="106px" align="right" valign="bottom">
<a href="#"><img src="images/logout_icon.gif" border="0" /></a>
</td>
</tr>
</table>
</td>
</tr>
<tr>
<td align="center">
<table width="100%" align="left" border="0" cellpadding="0" cellspacing="0">
<tr>
<td align="left" valign="middle" class="header_marque"><marquee direction="left" scrolldelay="200">News/Birthday/Anniversary</marquee></td>
<td class="nav_mid"></td>
<td class="nav_right" align="left">Welcome, </td>
</tr>
</table>
</td>
</tr>
<tr>
<td class="main_body" valign="top">
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>
<!-- ************************ LEFT STARTS *********************** -->
<td align="left" valign="top" width="200px">
<table width="200px" cellpadding="0" cellspacing="0" border="0">
<tr>
<td class="left_nav_top"></td>
</tr>
<tr>
<td class="left_nav_mid" valign="top">
<div id="vertical_container" >
<h1 class="accordion_toggle"><a href="#">Title Bar 1</a></h1>
<div class="accordion_content"></div>
<h1 class="accordion_toggle"><a href="#">Title Bar 2</a></h1>
<div class="accordion_content">

<div id="vertical_nested_container" >

<h3 class="vertical_accordion_toggle"><a href="#">Hablo pig-latin?</a></h3>
<div class="vertical_accordion_content">
<p>
sub menu 2
</p>
</div>

</div>
</div>
</div>
</td>
</tr>
<tr>
<td class="left_nav_bottom"></td>
</tr>
</table>
</td>
<!-- ************************ LEFT ENDS ************************* -->
<!-- ======================== BODY STARTS ======================= -->
<td align="left" valign="top" style="padding:3px 0 3px 3px;">
<table width="100%" align="left" border="0" cellpadding="0" cellspacing="0" style="border: 2px solid #B76C35; height: 360px;">
<tr>
<td align="left" valign="top" height="35" bgcolor="#FFF3DB">
<table width="100%" border="0" cellspacing="3" cellpadding="0">
<tr>
<td width="70%">
<table width="100%" border="0" cellspacing="3" cellpadding="0">
<tr>
<td width="11" height="20" valign="middle"><img src="images/bullet.png" width="11" height="11" border="0" /></td>
<td valign="middle">Shorcuts 1</td>
<td width="11" valign="middle"><img src="images/bullet.png" width="11" height="11" border="0" /></td>
<td valign="middle">Shorcuts 2</td>
<td width="11" valign="middle"><img src="images/bullet.png" width="11" height="11" border="0" /></td>
<td valign="middle">Shorcuts 2</td>
<td width="11" valign="middle"><img src="images/bullet.png" width="11" height="11" border="0" /></td>
<td valign="middle">Shorcuts 2</td>
<td width="11" valign="middle"><img src="images/bullet.png" width="11" height="11" border="0" /></td>
<td valign="middle">Shorcuts 2</td>
</tr>
</table>
</td>
<td width="30%">
<form name="frmSearch" id="frmSearch" method="post" action="">
<table width="100%" border="0" cellspacing="3" cellpadding="0">
<tr>
<td><input type="text" name="search" id="search" class="search_text" /></td>
<td><input type="image" src="images/go.jpg" /></td>
</tr>
</table>
</form>
</td>
</tr>
</table>
</td>
</tr>
<tr>
<td valign="top" align="center" style="padding:5px 0 1px 0;">
<table width="761px" border="0" cellspacing="0" cellpadding="0" align="left">
<tr>
<td valign="top" align="left">
<!-- *************************** POLULAR TABS STARTS ************************* -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td valign="top" align="left">
<!--<div id="sidebar-tabs"> -->
<div id="mostPopWidget">

<div style="display:block; height: 21px; margin:0px; padding: 0px;">
<ul class="tabs">
<li class="selected"><strong><label style="cursor:pointer">Appraisal Type</label></strong></li>
<li><strong><label style="cursor:pointer">Appraisal Questions</label></strong></a></li>
<li><strong><label style="cursor:pointer">Appraisal Grade</label></strong></li>
</ul>
</div>

<div class="tabContent tabContentActive" id="mostViewed">
<ul>
<li>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

<tr>
<td style="padding: 5px 5px 0 0px;">
<table width="761" border="0" cellspacing="0" cellpadding="0">
<tr>
<td class="body_top">&nbsp;</td>
</tr>
<tr>
    <td class="body_mid" style="padding:0 0 0 5px;" valign="middle" align="left">
    <form  action="../appraisalEditPage.do" >
        <table width="500" border="0" cellspacing="4" cellpadding="2" bgcolor="palegoldenrod">

<logic:present name="categorylist" scope="request">
<logic:iterate id="itr" name="categorylist" indexId="counter">
<tr bgcolor="<c:if test='${counter%2!=0}'>cornsilk</c:if><c:if test='${counter%2==0}'>white</c:if>">
<td align="left" valign="middle"><span class="style3"><input type="checkbox" name="category_code" value="<bean:write  name="itr" property="category_code"/>" /></span></td>
<td align="left" valign="middle"><strong><bean:write  name="itr" property="category_name"/></strong></td>
<td align="left" valign="middle"><a href="#" onMouseover="ddrivetip('<bean:write  name="itr" property="category_description"/>','cornsilk', 200)" onMouseout="hideddrivetip()"><img src="images/app.details.gif" border="0" /></a></td>
</tr>
</logic:iterate>
</logic:present>
<tr>
<td align="left" valign="middle">&nbsp;</td>
<td colspan="3" align="left" valign="middle">
<table width="30%" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<td height="30"><input type="hidden" name="method" /></td>
<td ><a href="addCategory.jsp" onclick="NewWindow(this.href,'name','500','300','yes');return false"><input  type="submit"  src="images/submit_button.jpg" value="Add Category" /></a>
</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp; </td>
<td ><input  type="button"  src="images/submit_button.jpg" value="Edit Category" onclick="edit(this.form)" /></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input  type="button"  src="images/submit_button.jpg" value="Delete Category" onclick="del(this.form)" />                                  </td>
</tr>
</table></td> </tr>


</table>
</form>
</td>
</tr>
<tr>
<td class="body_bottom">&nbsp;</td>
</tr>
</table>
</td>
</tr>
</table>
</li>
</ul>
</div>

<div class="tabContent" id="mostCommented">

<ul>
<li>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

<tr>
<td style="padding: 5px 5px 0 0px;">
<table width="761" border="0" cellspacing="0" cellpadding="0">
<tr>
<td class="body_top">&nbsp;</td>
</tr>
<tr>
    <td class="body_mid" style="padding:0 0 0 5px;" valign="middle" align="center">
<form action="../addQuestions.do" method="post">
    <table align="left" bgcolor="palegoldenrod"  width="200" width="1000">
<tr align="center" bgcolor="goldenrod">
<td colspan="5"><font color="white"><b>Add Question</b></font></td>
</tr>
<tr>
<td align="center"><div id="1">
        <table   cellpadding="0" cellspacing="0"  border="1"> <tr bgcolor="white">
<td><b>Question:</b>&nbsp;&nbsp;&nbsp;</td>
<td> <input type="text" name="question"  size="40"/></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><b> Type:&nbsp;&nbsp;&nbsp;</b></td>
<td>
<select name="category_code">
<option>Select Category</option>
<logic:present name="categorylist" scope="request">
<logic:iterate id="itr" name="categorylist">
<option value="<bean:write name="itr" property="category_code"/>"><bean:write  name="itr" property="category_name"/></option>
</logic:iterate>
</logic:present>
</select>
</td>
</tr>
</table>
</div><div id="2"></div>
</td>

</tr>
<tr>
<td>
<table align="center">
<tr>
<td><div id="divAddMore"><label onclick="increamentTxtBox(1)" style="cursor:pointer" ><input type="button" value="Add More >>"></label></div></div></td>
<td> <div id="remove"></div></td>
<td> <input type="hidden" name="method" value="addQuestion" />
<input type="submit" value="OK" src="images/submit_button.jpg"></td>
<td><input type="button" value="Cancel" src="images/submit_button.jpg"></td>
</tr>
</table>
</td></tr></table>
</form>
</td>
</tr>
<tr>
<td class="body_bottom">&nbsp;</td>
</tr>
</table>
</td>
</tr>
</table>
</li>
</ul>
</div>

<div class="tabContent" id="topRated">
<ul>
<li>
 <table width="100%" border="0" cellspacing="0" cellpadding="0">

<tr>
<td style="padding: 5px 5px 0 0px;">
<table width="761" border="0" cellspacing="0" cellpadding="0">
<tr>
<td class="body_top">&nbsp;</td>
</tr>
<tr>
    <td class="body_mid" style="padding:0 0 0 5px;" valign="middle" align="left">   
    
        <table align="left" bgcolor="palegoldenrod"  width="500">
           <logic:present name="gradeList" scope="request">
           <logic:iterate id="itr" name="gradeList" indexId="counter">
            <tr bgcolor="<c:if test='${counter%2!=0}'>cornsilk</c:if><c:if test='${counter%2==0}'>white</c:if>">
                <td><input type="checkbox" name="grade_code" value="<bean:write  name="itr" property="grade_code"/>"/></td>
                <td><strong><bean:write  name="itr" property="grade_name"/></strong></td>
                <td><strong><bean:write  name="itr" property="grade_point"/></strong></td>
            </tr>
           </logic:iterate>
           </logic:present>
        </table> 
        
  </td>
</tr>
<tr>
<td class="body_bottom">&nbsp;</td>
</tr>
</table>
</td>
</tr>
</table>
</li>
</ul>
</div>

<script type="text/javascript">new Popular("mostPopWidget");</script>
</div>
<!--</div> -->
</td>
</tr>
</table>
<!-- *************************** POPULAR TABS ENDS *************************** -->
</td>
</tr>
</table>

</td>
</tr>
</table>
</td>
<!-- ======================== BODY ENDS ======================= -->
</tr>
</table>
</td>
</tr>
<tr>
<!-- *************************** FOOTER STARTS ************************* -->
<td class="footer_bg" valign="bottom">

</td>
<!-- *************************** FOOTER ENDS *************************** -->
</tr>
</table>
</body>
</html:html>
