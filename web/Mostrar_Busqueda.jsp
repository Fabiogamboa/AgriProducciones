<%-- 
    Document   : mensaje_buscar
    Created on : 13/06/2025, 7:29:45 a. m.
    Author     : DIEGO
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>informacion</title>
         <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            background-image: url("https://us.123rf.com/450wm/enaria/enaria2308/enaria230800003/210138573-valle-de-p%C3%ADxeles-con-monta%C3%B1as-y-fondo-de-lago-colorido-paisaje-natural-de-8-bits-con-%C3%A1rboles.jpg?ver=6");
            background-size: cover;
            background-repeat: no repeat;
            min-height: 100vh;
            font-family: "Times New Roman", serif;
            margin: 0;
        }

        h1 {
            color: black;
            text-align: center;
            margin-bottom: 30px;
            font-size: 32px;
            font-family:monospace;
        }
        .container {
            width: 90%;
            max-width: 180px;
            padding: 30px;
            background-color: rgba(0, 128, 0, 0.1);
            border-radius: 20px;
            border: 4px solid green;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);
        }

        .botones {
            display: grid;
            grid-template-columns: repeat;
            gap: 20px;
            margin-top: 20px;
        }

        button {
            padding: 15px;
            font-size: 18px;
            font-weight: bold;
            border: 3px solid green;
            border-radius: 12px;
            cursor: pointer;
            background-color: #d1f0d1;
            transition: 0.3s;
            color: #1a1a1a;
        }

        button:hover {
            background-color: #a8e6a1;
            transform: scale(1.05);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
        }
        #boton_config{
            margin-top: 10px;
        }
        ol{
            width: 100px;
            background: #7fcf2f;
            border-radius: 10px;
            padding-right: 40px;
        }
        li{
            font-family:sans-serif;
            
        }
        
    </style>
    </head>
    <body>
        <div class="container">
        <h1>Informacion</h1>
     <ol>
   <%
    session = request.getSession(false);
    ArrayList<String> productos = (ArrayList<String>) session.getAttribute("datos_lista");

    if (productos != null) {
        for (int i = 0; i < productos.size(); i += 3) {
%>
    <li><strong>Registro <%= (i / 3 + 1) %>:</strong>
        <ul>
            <% if (i < productos.size()) { %><li><%= productos.get(i) %></li><% } %>
            <% if (i + 1 < productos.size()) { %><li><%= productos.get(i + 1) %></li><% } %>
            <% if (i + 2 < productos.size()) { %><li><%= productos.get(i + 2) %></li><% } %>
        </ul>

        <!-- Botón para eliminar este registro -->
        <form method="post" action="Servlet2" onsubmit="return confirm('¿Estás seguro de eliminar este registro?');">
            <input type="hidden" name="id" value="<%= productos.get(i) %>">
            <button type="submit">Eliminar</button>
        </form>
    </li>
<%
        }
    }
%>

</ol>


        <button id="boton_config" onclick="location.href='buscar.jsp'">Atrás</button>
        <button id="boton_config" onclick="location.href='paginaPrincipal.jsp'">Menú</button>
        </div>
    </body>
</html>