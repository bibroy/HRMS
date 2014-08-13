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
<html>
    <head>
        <title></title>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <% int loop = 1;%>
        <logic:present name="setup" scope="request">
            <logic:iterate id="itr" name="setup" indexId="no">
                <% loop++;%>
            </logic:iterate>
        </logic:present>
        <script language="javascript">
            function tabMenu(id){
                var iLoop=0;
                var loopId=1;
                for(iLoop=0; iLoop<<%=loop%> ; iLoop++){
                    document.getElementById(loopId).className = "invisible";
                    loopId++;
                }
                document.getElementById(id).className = "visible";
            }
        </script>


        <link rel="stylesheet" href="css/style1.css" />
    </head>
    <body>
        <jsp:include page="include/header.jsp" />
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="8"></td>
                <td height="8"></td>
                <td height="8"></td>
            </tr>
            <tr>
               <td width="100%" colspan="3" align="left" valign="top"><img src="images/Appraisal.jpg" width="100%" height="138" /></td>
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
                                <div  class="visible" id="1" >
                                    <table align="left">
                                        <tr align="left">
                                            <td>
                                                <input type="button" value="Continue>>" onclick="javascript:tabMenu(2)"  />
                                            </td>
                                        </tr>

                                    </table>
                                </div>
                                <form action="appraise.do"   class="form" id="form1">
                                    <%int i = 2;%>
                                    <logic:present name="setup" scope="request">
                                        <logic:iterate id="itr" name="setup" indexId="no">

                                            <div  class="invisible" id="<%=i%>" >
                                                <table width="100%" border="0" align="left" cellpadding="2" cellspacing="2">
                                                    <tr>
                                                        <td align="left" valign="top" class="heading"><font color="Brown"><u><bean:write  name="itr" property="category_name"/></u></font> </td>
                                                    </tr>                                                   
                                                    <tr>
                                                        <td height="184"><table width="80%" border="0" align="left" cellpadding="4" cellspacing="1" bordercolor="#B27138">
                                                                <tr>
                                                                    <td width="2%">&nbsp;</td>
                                                                    <td align="left" valign="middle" class="normal_black_text">&nbsp;</td>
                                                                    <td width="51" align="center" valign="top"><img src="images/poor_button.jpg" width="51" height="39" /></td>
                                                                    <td width="51" align="center" valign="top"><img src="images/fair_button.jpg" width="51" height="39" /></td>
                                                                    <td width="51" align="center" valign="top"><img src="images/good_button.jpg" width="51" height="39" /></td>
                                                                    <td width="79" align="center" valign="top"><img src="images/verygood_button.jpg" width="79" height="39" /></td>
                                                                    <td width="95" align="center" valign="top"><img src="images/outstanding_button.jpg" width="95" height="39" /></td>
                                                               
                                                                </tr>
                                                                <logic:present name="questions${no}" scope="request">
                                                                    <logic:iterate id="qitr" name="questions${no}" >
                                                                        <tr>
                                                                            <td align="center" valign="middle" bgcolor="#FADB9A"><img src="images/tick_bullets.jpg" width="10" height="10" /><input type="hidden" name="question_code" value="<bean:write  name="qitr" property="question_code"/>"</td>
                                                                            <td align="left" valign="middle" bgcolor="#FADB9A" class="normal_black_text"><bean:write  name="qitr" property="question"/></td>
                                                                            <td align="center" valign="middle" bgcolor="#FADB9A"><input type="radio" name="answer"   value="1" /></td>
                                                                            <td align="center" valign="middle" bgcolor="#FADB9A"><input name="answer" type="radio" value="2" /></td>
                                                                            <td align="center" valign="middle" bgcolor="#FADB9A"><input name="answer" type="radio" value="3" /></td>
                                                                            <td align="center" valign="middle" bgcolor="#FADB9A"><input name="answer" type="radio" value="4" /></td>
                                                                            <td align="center" valign="middle" bgcolor="#FADB9A"><input name="answer" type="radio" value="5" /><input type="hidden" name="category_code" value="<bean:write  name="itr" property="category_id"/>"/></td>
                                                                           

                                                                        </tr>
                                                                    </logic:iterate>
                                                                </logic:present>
                                                            </table></td>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td><table width="60%" border="0" align="center" cellpadding="4" cellspacing="4">
                                                                <tr>
                                                                    <td align="center" valign="middle">
                                                                        <input type="hidden" name="method"  value="submitForm" />
                                                                        <% if (i < loop) {%>
                                                                        <input type="button" value="Continue>>" onclick="javascript:tabMenu(<%=i + 1%>)"/>
                                                                        <% }%>
                                                                        <% if (i > 2) {%>
                                                                        <input type="button" value="<<Back" onclick="javascript:tabMenu(<%=i - 1%>)"  />
                                                                        <% }%>

                                                                        <% if (i == loop) {%>
                                                                        <input type="submit" value="Appraise" />
                                                                        <% }%>
                                                                    </td>
                                                                </tr>
                                                            </table></td>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center" valign="middle"><b><font color="green">Percent complete - <%out.print((i - 2) * 1.0 / (loop - 1) * 100);%></font></b></td>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                    </tr>
                                                </table>
                                            </div>
                                            <% i = i + 1;%>
                                        </logic:iterate>
                                    </logic:present>
                                </form></td>
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
            </tr>
        </table>
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="3"></td>
            </tr>
        </table>
        <jsp:include page="include/footer.jsp" />
    </body>
</html>
