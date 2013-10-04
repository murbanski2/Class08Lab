<%-- 
    Document   : displayTotals
    Created on : Sep 15, 2013, 10:03:29 PM
    Author     : Mark
--%>

<%@page import="model.MenuItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Totals</title>
    </head>
    <body>
        <h1>Your Order</h1> <br/>
        <%
            //String[] choices = request.getParameterValues("item");
            //I am now passing only the menu items that were chosen
            List<MenuItem> menu = (List)request.getAttribute("menu");

        %>
        <%
            if (menu != null){
                for(MenuItem m: menu) {
                    String outItem = m.getName() + "    $" + m.getPrice();
        %>
            <p><%= outItem %></p>            
        <%
                }
            }
            
        %>
        <br/>
        <p>Total = $<fmt:formatNumber pattern="0.00" value="${total}"/></p>
        <p>Tax = $<fmt:formatNumber pattern="0.00" value="${tax}"/></p>
        <p>Grand Total = $<fmt:formatNumber pattern="0.00" value="${grandTotal}"/></p>
        <p>Suggested Tip = $<fmt:formatNumber pattern="0.00" value="${tip}"/></p>
    </body>
</html>
