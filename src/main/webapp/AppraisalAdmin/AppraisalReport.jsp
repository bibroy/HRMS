<%--
    Document   : addQuestions
    Created on : Oct 7, 2009, 3:06:42 AM
    Author     : Swarnendu Mukherjee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<script type="text/JavaScript">
    function edit(form){
        form.submit();
        window.close();
    }
    function calcel()
    {
        window.close();
    }

</script>
<script language="javascript">
function tabMenu(id){
var iLoop=0;
var loopId=1;
for(iLoop=0; iLoop<2 ; iLoop++){
document.getElementById(loopId).className = "invisible";
loopId++;
}
document.getElementById(id).className = "visible";
}
</script>
<script type="text/javascript" src="AppraisalAdmin/include/graphs.js"></script>
<link rel="stylesheet" href="css/style1.css" />
    <body>
<jsp:include page="include/header.jsp" />
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="8"></td>
    <td height="8"></td>
    <td height="8"></td>
  </tr>
  <tr>
      <td width="448" align="left" valign="top"><img src="images/appriasal.jpg" width="448" height="138" /></td>
    <td align="right" valign="middle" bgcolor="#FADB9A"><img src="images/baner_text.jpg" width="295" height="39" /></td>
    <td width="20" align="right" valign="top"><img src="images/banner_right.jpg" width="20" height="138" /></td>
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
	<jsp:include page="include/menu.jsp" />
	</td>
    <td align="left" valign="top" bgcolor="#FFFFFF"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="8" align="left" valign="top">&nbsp;</td>
        <td height="8" align="left" valign="top"></td>
        <td height="8" align="right" valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td width="8" height="8" align="left" valign="top"><img src="images/left_round_top_gray_border.jpg" width="8" height="8" /></td>
        <td height="8" align="left" valign="top" background="images/top_gray_border.jpg"></td>
        <td width="8" height="8" align="right" valign="top"><img src="images/right_round_top_gray_border.jpg" width="8" height="8" /></td>
      </tr>
      <tr>
       <td align="left" valign="top" background="images/left_gray_border.jpg">&nbsp;</td>
       <td align="left" valign="top">
       <a href="../detailReport.do?method=getDetailrRport&employee_code=1">click</a>
       <div  class="visible" id="1" >
        <logic:present name="result" scope="request">
        <logic:iterate id="itr" name="result" indexId="loop">
        <c:if test="${loop==0}">
            <table bgcolor="gray" align="center">
                <tr align="center" bgcolor="blue"><td colspan="7"><b>Appraisal Report </b></tr>
            <tr>
                       <td><b>Employee Name:</b></td><td>&nbsp;&nbsp;&nbsp;</td> <td> <bean:write name="itr" property="employee_name"/></td>
 <td>&nbsp;&nbsp;&nbsp;</td><td><b>Gender</b></td><td>&nbsp;&nbsp;&nbsp;</td><td> <bean:write name="itr" property="gender"/></td>
            </tr>
            <tr>
                       <td><b>Department:</b></td><td>&nbsp;&nbsp;&nbsp;</td><td> <bean:write name="itr" property="department"/></td>
 <td>&nbsp;&nbsp;&nbsp;</td><td><b>Employee Designation:</b></td><td>&nbsp;&nbsp;&nbsp;</td><td> <bean:write name="itr" property="designation"/></td>
            </tr>
            <tr>
                <td><b>Employment Status</b></td><td>&nbsp;&nbsp;&nbsp;</td><td> <bean:write name="itr" property="employment_status"/></td>
 <td>&nbsp;&nbsp;&nbsp;</td><td><b>Year Of Experience:</b></td><td>&nbsp;&nbsp;&nbsp;</td><td> <bean:write name="itr" property="experience"/></td>
            </tr>
            <tr><td colspan="3" height="15" valign="bottom">
               <input type="button" value="Continue>>"  onclick="javascript:tabMenu(2)"/></td>
            </tr>
            </table>
            </c:if>
           </logic:iterate>
           </logic:present>
        </div>
 <div  class="invisible" id="2" >
     <table align="center">
         <tr><td>
<script>
var graph = new BAR_GRAPH("hBar");
graph.values = "<logic:present name="result" scope="request"><logic:iterate id="itr" name="result" indexId="loop"><bean:write name="itr" property="score"/>,</logic:iterate> </logic:present>";
graph.labels = "<logic:present name="result" scope="request"><logic:iterate id="itr" name="result" indexId="loop"><bean:write name="itr" property="question"/>,</logic:iterate> </logic:present>";
graph.showValues = "2";
graph.barWidth = 10;
graph.barLength = 15;
graph.labelSize = 12;
graph.absValuesSize = 12;
graph.percValuesSize = 12;
graph.graphPadding = 1;
graph.graphBGColor = "#ABCDEF";
graph.graphBorder = "1px solid blue";
graph.barColors = "#A0C0F0";
graph.barBGColor = "#E0F0FF";
graph.barBorder = "2px outset white";
graph.labelColor = "#000000";
graph.labelBGColor = "#C0E0FF";
graph.labelBorder = "2px groove white";
graph.absValuesColor = "#000000";
graph.absValuesBGColor = "#FFFFFF";
graph.absValuesBorder = "2px groove white";
document.write(graph.create());
            </script>
             </td></tr>
     </table>
            </div>
       </td>
        <td align="right" valign="top" background="images/right_gray_border.jpg">&nbsp;</td>
      </tr>
      <tr>
        <td align="left" valign="top" background="images/left_gray_border.jpg">&nbsp;</td>
        <td align="left" valign="top">&nbsp;</td>
        <td align="right" valign="top" background="images/right_gray_border.jpg">&nbsp;</td>
      </tr>
      <tr>
        <td width="8" align="left" valign="top"><img src="images/left_round_bottom_gray_bord.jpg" width="8" height="8" /></td>
        <td background="images/bottom_gray_border.jpg"></td>
        <td width="8" align="right" valign="top"><img src="images/right_round_bottom_gray_bor.jpg" width="8" height="8" /></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="16" align="left" valign="top" bgcolor="#FFFFFF"><img src="images/body_left_bottom_round.jpg" width="16" height="14" /></td>
    <td bgcolor="#FFFFFF">&nbsp;</td>
    <td width="16" align="right" valign="top" bgcolor="#FFFFFF"><img src="images/body_right_bottom_round.jpg" width="16" height="14" /></td>
  </tr>  </table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>
<jsp:include page="include/footer.jsp" />
</body>
</html>
