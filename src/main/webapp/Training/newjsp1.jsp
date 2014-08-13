<%-- 
    Document   : newjsp1
    Created on : Nov 16, 2010, 2:34:11 PM
    Author     : computer2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><table border="1">

            <tbody>
                <tr>
                    <td>
                        <a href="../trainingRequestEmployee.do?method=reqFromEmploye">Training Employee</a>
                    </td>
                </tr>
                <tr>
                    <td> <a href="../trainingRequestHOD.do?method=reqFromHOD">Training Hod</a></td>

                </tr>
                <tr>
                    <td><a href="../trainingTransaction.do?method=trainingTransactionList&status=ereq">Trainig Report Employee</a></td>

                </tr>
                <tr><td>
                <a href="../trainingTransaction.do?method=trainingTransactionList&status=hodapprove">Training Approval</a></td>
        </tr>
        <tr>
            <td>
                <a href="../trainingTransaction.do?method=trainingTransactionList&status=hodreq">Trainig Report Hod</a></td>

        </tr>
            </tbody>
        </table>

      
    </body>
</html>
