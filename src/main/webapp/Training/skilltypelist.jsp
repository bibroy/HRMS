<%-- 
    Document   : skilltypelist
    Created on : Nov 16, 2010, 5:40:51 PM
    Author     : computer2
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page import="java.util.*" %>
<%@page import="com.pojo.Skills" %>
<link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
                    Skills skill = new Skills();
                    ArrayList skillList = new ArrayList();
                    skillList = (ArrayList) request.getAttribute("skills");
                    Iterator itr = skillList.iterator();
        %>
        <select name="ddlSkillsName" id="skillId" onchange="return desSelState(this)">
            <option value="select">select</option>
            <%
                        while (itr.hasNext()) {
                            skill = (Skills) itr.next();
            %>
            <option value="<%=skill.getSkillId()%>"><%=skill.getSkillName()%></option>
            <%
                        }
            %>
        </select>
    </body>
</html>
