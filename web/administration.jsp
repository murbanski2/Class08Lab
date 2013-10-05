<%-- 
    Document   : administration
    Created on : Oct 4, 2013, 10:54:08 PM
    Author     : Mark
--%>

<%@page import="model.MenuItem"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration Page</title>
    </head>

    <body>
        <h1>Menu Item Administration</h1>

        <br/>
        <table class:adminTable>
            <tr>
                <td>ID</td>
                <td>Item Name</td>
                <td>Price</td>
                <td>Choices</td>
            </tr>
            <%
                List<MenuItem> menu = (List) request.getAttribute("menu");
                if (menu != null) {
                    for (MenuItem m : menu) {
                        String id = m.getId() + "";
                        String name = m.getName();
                        double price = m.getPrice() ;

                        

            %>
            <tr>
                <td><%= id %></td>
                <td><%= name %></td>
                <td>$<fmt:formatNumber pattern="0.00" value="<%= price %>"/></td>
                <td>Choices</td>
            </tr>
            <%
                    }
                }
            %>




        </table>
    </body>
</html>
