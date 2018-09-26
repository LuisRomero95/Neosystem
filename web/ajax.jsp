<%@page contentType="text/html" pageEncoding="UTF-8"%><%
    String usuario = "";
    usuario = request.getParameter("txtNombre");
    if (usuario.equals("pepe")) {
        out.print("si");
    } else {
        out.print("no");
    }
%>