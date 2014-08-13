<%-- 
    Document   : index
    Created on : Nov 25, 2010, 11:39:45 AM
    Author     : Administrator
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/JavaScript">
    function loadData(form){

        form.method.value="load";

        form.submit();
    }


</script>
<html:html lang="true">
    <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
    <link rel="stylesheet" href="../css/newstyle1.css" />

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body style="background-color:inherit">

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <h3 align="center">Project Management</h3>
        <p>
            <!--html:form action="loadEditEmployee.do" method="post"-->


            <html:link href="clientGroupAdd.jsp">ClientGroup</html:link>
            <br>
            <br>
            <br>

            <html:link href="../loadclientadd.do?method=load">Client Information SetUp </html:link>
            <br>
            <br>
            <br>


            <html:link href="../loadclientedit.do?method=load">Edit Client Setup</html:link>
            <br>
            <br>
            <br>
            <html:link href="../loadprojectadd.do?method=load"> Project Setup</html:link>
            <br>
            <br>
            <br>
            <html:link href="../loadprojectedit.do?method=load"> Project Setup Edit</html:link>
            <br>
            <br>
            <br>
            <html:link href="../taskadd.do?method=load">Task SetUp</html:link>
        </p>
        <p>
            <html:link href="../loadtaskedit.do?method=load">Task SetUpChange</html:link>

            <html:link href="../managerlogin.do?method=load">Manager Login</html:link>



            <!--/html:form-->


        </p>
    </body>
</html:html>
