<%-- 
    Document   : newjsp
    Created on : Dec 18, 2009, 2:10:52 AM
    Author     : swarnendum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*"    %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <%
        ArrayList eList=(ArrayList)request.getAttribute("empIdList");
        Iterator itr = eList.iterator();
        while (itr.hasNext()) {
            %>
        <%out.println(itr.next()) ;%><br>
       <% }
        ArrayList eList1=(ArrayList)request.getAttribute("empNameList");
        Iterator itr1 = eList1.iterator();
        while (itr1.hasNext()) {
        out.println(itr1.next()) ;
        }

%>
fgdfhgthghjd
    </body>
</html>
