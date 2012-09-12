<%-- 
    Document   : result
    Created on : Sep 12, 2012, 2:06:15 PM
    Author     : JBaldwin
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Advice Response</title>
    </head>
    <body>
    <h1 align="center">Item Recommendations (JSP)</h1>
    <p>

    <%
        List recs = (List)request.getAttribute("recommendations");
        Iterator it = recs.iterator();
        while(it.hasNext()) {
            // Notice we're outputting some HTML. Is that a good idea?
            // Also, notice we do not cast the object returned by the
            // iterator to a String. Why?
            out.print("<br>try: " + it.next());
        }
    %>
    
    <p><a href="form.html">Back
    
    </body>
</html>
