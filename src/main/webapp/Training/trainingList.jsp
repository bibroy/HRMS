<%-- 
    Document   : trainingList
    Created on : Nov 16, 2010, 6:09:47 PM
    Author     : computer2
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page import="java.util.*" %>
<%@page import="com.pojo.Training" %>
<link href="css/main.css" type="text/css" rel=stylesheet>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <%
Training training=new Training();
ArrayList trainingList=new ArrayList();
trainingList=(ArrayList)request.getAttribute("trainingList");
Iterator itr=trainingList.iterator();

%>
<select name="ddlTrainingName" >
    <option value="select">-Select-</option>
<%
while(itr.hasNext()){
training=(Training)itr.next();
%>
<option value="<%=training.getTrainingId()%>"><%=training.getTrainingName()%></option>
<%
    }
	%>
</select>
    </body>
</html>