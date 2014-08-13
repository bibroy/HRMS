<%-- 
    Document   : index
    Created on : Oct 7, 2009, 3:47:37 AM
    Author     : swarnendum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="../appraisalCategoryAction.do?method=getAllCategories" >Appraisal Category</a><br>
        <a href="../questions.do?method=getAllCategories" >Add questions</a><br>
        <br>
        <a href="../appraisalSetupPage.do?method=showSetupPage" >Appraisal Setup</a><br>
        <a href="../appraisalprocess1.do?method=getSetupInfo" >Appraise form</a><br>
        <a href="../manageAppraisalPage.do?method=getAllsetup" >Manage Appraisal</a><br>

        <a href="statistics.jsp" >Appraisal Report</a><br>
        <a href="../#" >grade report</a><br>
        <a href=".#" >employee wise report</a><br>
        <a href="#" >Appraisal rules</a><br>
        <a href="#" >Depart ment wise report</a><br>

    </body>
</html>
