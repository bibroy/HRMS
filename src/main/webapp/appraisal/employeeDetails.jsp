<%--
    Document   : bankAdd
    Created on : Aug 12, 2009, 1:57:31 AM
    Author     : Swarnendu Mukherjee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<script type="text/JavaScript">

    function refreshParent()
    {
        window.opener.location.href=window.opener.location.href;
        if(window.opener.progressWindow)
            {
                window.opener.progressWindow.close();
            }
            window.close();
    }


    function add(form){

        form.submit();
        refreshParent();
        window.close();

    }
    function cancel()
    {
        window.close();
    }

</script>
<html:html>
    <html:base/>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Appraisal Category</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />
    </head>
    <body >
      <table bgcolor="palegoldenrod" align="center" width="480" >
          <tr bgcolor="goldenrod"><td colspan="2" align="center" height="6"><font color="white"><b>Employee Details</b></font></td></tr>
     <logic:present name="empinfo" scope="request">
    <logic:iterate id="itr" name="empinfo" indexId="no">
        <tr bgcolor="cornsilk">
       <td><strong>Name</strong></td><td><bean:write  name="itr" property="employee_name"/></td> 
        </tr>
        <tr>
        <td><strong>Gender</strong></td><td><bean:write  name="itr" property="gender"/></td>
        </tr>        
        <tr bgcolor="cornsilk">
        <td><strong>Company Name</strong></td><td><bean:write  name="itr" property="company"/></td>
        </tr>
        <tr>
        <td><strong>Department</strong></td><td><bean:write  name="itr" property="department"/></td>
        </tr>
        <tr bgcolor="cornsilk">
        <td><strong>Designation</strong></td><td><bean:write  name="itr" property="designation"/></td>
        </tr>
        <tr>
       <td><strong>Status</strong></td><td><bean:write  name="itr" property="employment_status"/></td>
        </tr>
        <tr bgcolor="cornsilk">
         <td><strong>Days in company</strong></td><td><bean:write  name="itr" property="days_of_experience"/></td>
        </tr>
        <tr><td colspan="2" height="10"></td></tr>
        <tr><td colspan="2" align="center"><input type="button" onclick="cancel()" Value="Close"/><input type="button" onclick="" Value="Print"/></td></tr>
      </logic:iterate>
    </logic:present>  
    </table>







    

    

    </body>
</html:html>