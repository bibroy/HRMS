<%--
    Document   : EmployeeDetailsForAdvancedSalary
    Created on : Nov 10, 2009, 11:46:25 AM
    Author     : sujatas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page  import="java.util.List" %>
<%@page  import="com.pojo.Leave" %>
<%@page import="java.util.Iterator" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
     <html:base/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>HOME</title>
        <link rel="stylesheet" type="text/css" href="../css/newstyle.css"/>
        <link rel="stylesheet" href="../css/newstyle1.css" />

        <script type="text/javascript" src="js/accordion/javascript/prototype.js"></script>
        <script type="text/javascript" src="js/accordion/javascript/effects.js"></script>
        <script type="text/javascript" src="js/accordion/javascript/accordion.js"></script>

        <script src="js/scripts.js"></script>

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


    </head>

    <body bgcolor="#EE9A4D">



        <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0">
            <logic:present name="employeeList" scope="request">
                <tr >

                    <td width="6%" align="center" valign="middle"> <b> Employee Id </b></td>
                    <td width="16%" align="center" valign="middle"> <b> First Name </b></td>
                    <td width="16%" align="center" valign="middle"><b> Middle Name</b> </td>
                    <td width="11%" align="center" valign="middle"> <b> Last Name </b></td>
                    <td width="12%" align="center" valign="middle"> <b> Department </b> </td>
                    <td width="12%" align="center" valign="middle"><b>Designation </b></td>
                    <td width="12%" align="center" valign="middle"><b> Branch </b></td>
                    <td width="12%" align="center" valign="middle"> <b>Domain </b></td>
                </tr>
                <logic:iterate id="employee" name="employeeList" scope="request">
                    <tr align="center">
                        <td><bean:write name="employee" property="employeeId" /></td>
                        <td><bean:write name="employee" property="firstName" /></td>
                        <td><bean:write name="employee" property="middleName" /></td>
                        <td><bean:write name="employee" property="lastName" /></td>
                        <td><bean:write name="employee" property="departmentName" /></td>
                        <td><bean:write name="employee" property="designationName" /></td>
                        <td><bean:write name="employee" property="branchName" /></td>
                        <td><bean:write name="employee" property="domainId" /></td>








                    </tr>
                </logic:iterate>
            </logic:present>









        </table>

    </body>
</html>
