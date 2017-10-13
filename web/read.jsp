<%-- 
    Document   : read
    Created on : 06-Oct-2017, 09:15:16
    Author     : btfra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Database</title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>Orestes's Cars</h1>
        <%= table %>
        <a href ="add">Add a New Car</a>
        
    </body>
</html>
