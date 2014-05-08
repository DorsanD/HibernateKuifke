<%-- 
    Document   : results
    Created on : Apr 11, 2014, 2:38:57 PM
    Author     : jx3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>results!</h1>
          <c:forEach items="${Scoutslid}" var="scouts">
        ${scouts.getNaam()}<br/>
        ${scouts.getScoutsnaam()}<br/>
        ${scouts.getEmailadres()}<br/>
        <br/>
        </c:forEach>
        
    </body>
</html>
