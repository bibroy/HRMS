<%-- 
    Document   : menu1
    Created on : Nov 28, 2010, 12:33:46 PM
    Author     : Sumit Kumar
--%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
    <head>
        <script type="text/javascript" src="js/jquery.1.9.12.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <script type="text/javascript" src="css/jquery-ui.css"></script>


        <script type="text/javascript">
        $(function() {
        	//loadAccordions();
	        	$( "#accrdins" ).accordion({
	        		collapsible: true,
	        		active: false
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
                background: black url(./images/lightmaroon.png) repeat-x center left;
                font: normal 12px Tahoma, "Lucida Grande", "Trebuchet MS", Helvetica, sans-serif;
                color: white;
                display: block;
                position: relative; /*To help in the anchoring of the ".statusicon" icon image*/
                width: auto;
                padding: 5px 0;
                padding-left: 8px;
                text-decoration: none;
                font-weight: bold;
            }


            .applemenu div.silverheader a:visited, .applemenu div.silverheader a:active{
                color: white;
            }


            .applemenu div.selected a, .applemenu div.silverheader a:hover{
                background-image: url(./images/lightmaroon.png);
                color: white;
            }

            .applemenu div.submenu{ /*DIV that contains each sub menu*/
                                    background: white;
                                    padding: 5px;
                                    height: auto; /*Height that applies to all sub menu DIVs. A good idea when headers are toggled via "mouseover" instead of "click"*/
                                    background-color: #CBCADF;
            }

        </style>

    </head>
    <body>
    
        <table border="1" bgcolor="cornsilk" cellpadding="0" cellspacing="0">

            <logic:present name="menu" scope="session">

                <div class="applemenu" id="accrdins">

                    <div class="silverheader"><a href="#" >Requests</a></div>
                    <div class="submenu">
                        <logic:iterate id="itr" name="menu" indexId="no">
                            <c:if test="${itr.module == 'req'}">
                                <html:link href="${itr.pageLink}" ><bean:write  name="itr" property="menuText"/></html:link><br />
                            </c:if>
                        </logic:iterate>
                    </div>


                    <div class="silverheader"><a href="#" >Self Service</a></div>
                    <div class="submenu">
                        <logic:iterate id="itr" name="menu" indexId="no">
                            <c:if test="${itr.module == 'emp'}">
                                <a href="<bean:write  name="itr" property="pageLink"/>" ><bean:write  name="itr" property="menuText"/></a><br />
                            </c:if>
                        </logic:iterate>
                    </div>
                    <div class="silverheader"><a href="#" >Project Management</a></div>
                    <div class="submenu">
                        <logic:iterate id="itr" name="menu" indexId="no">
                            <c:if test="${itr.module == 'prj'}">
                                <a href="<bean:write  name="itr" property="pageLink"/>" ><bean:write  name="itr" property="menuText"/></a><br />
                            </c:if>
                        </logic:iterate>
                    </div>

                    <div class="silverheader"><a href="#">Training</a></div>
                    <div class="submenu">
                        <logic:iterate id="itr" name="menu" indexId="no">
                            <c:if test="${itr.module == 'trn'}">
                                <a href="<bean:write  name="itr" property="pageLink"/>" ><bean:write  name="itr" property="menuText"/></a><br />
                            </c:if>
                        </logic:iterate>
                    </div>

                    <div class="silverheader"><a href="#">Recruitment</a></div>
                    <div class="submenu">
                        <logic:iterate id="itr" name="menu" indexId="no">
                            <c:if test="${itr.module == 'rec'}">
                                <a href="<bean:write  name="itr" property="pageLink"/>" ><bean:write  name="itr" property="menuText"/></a><br />
                            </c:if>
                        </logic:iterate>
                    </div>

                    <div class="silverheader"><a href="#">Login</a></div>
                    <div class="submenu">
                        <logic:iterate id="itr" name="menu" indexId="no">
                            <c:if test="${itr.module == 'log'}">
                                <a href="<bean:write  name="itr" property="pageLink"/>" ><bean:write  name="itr" property="menuText"/></a><br />
                            </c:if>
                        </logic:iterate>
                    </div>
                    <div class="silverheader"><a href="#">Admin</a></div>
                    <div class="submenu">
                        <logic:iterate id="itr" name="menu" indexId="no">
                            <c:if test="${itr.module == 'adm'}">
                                <a href="<bean:write  name="itr" property="pageLink"/>" ><bean:write  name="itr" property="menuText"/></a><br />
                            </c:if>
                        </logic:iterate>
                    </div>
                    <div class="silverheader"><a href="#">Appraisal</a></div>
                    <div class="submenu">
                        <logic:iterate id="itr" name="menu" indexId="no">
                            <c:if test="${itr.module == 'app'}">
                                <a href="<bean:write  name="itr" property="pageLink"/>" ><bean:write  name="itr" property="menuText"/></a><br />
                            </c:if>
                        </logic:iterate>
                    </div>
                    <div class="silverheader"><a href="#">Compensation</a></div>
                    <div class="submenu">
                        <logic:iterate id="itr" name="menu" indexId="no">
                            <c:if test="${itr.module == 'cmp'}">
                                <a href="<bean:write  name="itr" property="pageLink"/>" ><bean:write  name="itr" property="menuText"/></a><br />
                            </c:if>
                        </logic:iterate>
                    </div>
                    <div class="silverheader"><a href="#">Succession</a></div>
                    <div class="submenu">
                        <logic:iterate id="itr" name="menu" indexId="no">
                            <c:if test="${itr.module == 'suc'}">
                                <a href="<bean:write  name="itr" property="pageLink"/>" ><bean:write  name="itr" property="menuText"/></a><br />
                            </c:if>
                        </logic:iterate>
                    </div>
                    <div class="silverheader"><a href="#">Reports</a></div>
                    <div class="submenu" style="height:auto;">
                        <logic:iterate id="itr" name="menu" indexId="no">
                            <c:if test="${itr.module == 'rep'}">
                                <a href="<bean:write  name="itr" property="pageLink"/>" ><bean:write  name="itr" property="menuText"/></a><br />
                            </c:if>
                        </logic:iterate>
                    </div>
                </div>
            </logic:present>
            <%--
                <logic:present name="menu" scope="session">
                   <logic:iterate id="itr" name="menu" indexId="no">
                       <tr><td><a href="<bean:write  name="itr" property="pageLink"/>" ><B><bean:write  name="itr" property="menuText"/></B></a></td></tr>
                   </logic:iterate>
            </logic:present>
            --%>
        </table>
    </body>
</html>