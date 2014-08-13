<%-- 
    Document   : Image
    Created on : Dec 29, 2010, 1:06:52 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="image/gif" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page  import="com.util.ImageUtil" %>
<%@page  import="java.io.*" %>
<jsp:useBean id="photo" scope="session" class="com.util.ImageUtil"/>
<%
    int iNumPhoto;

        if(request.getParameter("imgId")!=null)
        {
            iNumPhoto=Integer.parseInt(request.getParameter("imgId"));
            try {
                        byte[] imgData=photo.getPhoto(iNumPhoto);
                      //  response.setContentType("image/gif");
                        OutputStream o=response.getOutputStream();


                        o.write(imgData);
                        o.flush();
                       // o.close();
                 } catch (Exception e) {

                }
            out.clear();
            out=pageContext.pushBody();
        }
%>