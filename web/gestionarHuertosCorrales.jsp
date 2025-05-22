<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilosGlobalesGogo.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>crear huertos</title>
    </head>
    <style>
        .bodyPersonalizao{
            font-family: "Times-new-roman";
            background-color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
    </style>
    <body>
    <div class="contenedorDatitos">
        <h1>Iniciar Sesión</h1>
        <%
            String error = (String) request.getAttribute("error");
            String gogobien = (String) request.getAttribute("gogobien");
            if (error != null && !error.isEmpty() || gogobien != null && !gogobien.isEmpty()) {
        %>
            <p class="mensajitoMaloPiumPium"><%= error %></p>
            <p class="mensajitoBuenoPiumPium"><%=gogobien%></p>
        <%
            }
        %>
        <form action="gestionHuertos" method="post">
            <div class="formulariogogo">
                <label>Digite el nombre del huerto o corral</label>
                <input type="text" id="username" name="huerto-corral" required>
            </div>
            <div class="formulariogogo">
                <label for="password">Tipo de animal 0 vegetal</label>
                <input type="text" id="password" name="animal-vegetal" required>
            </div>
            <div class="formulariogogo">
                <label for="password">Humedad del terreno</label>
                <input type="text" id="password" name="" required>
            </div>
            <button type="submit">crear</button>
        </form>
    </div>
    </body>
</html>
