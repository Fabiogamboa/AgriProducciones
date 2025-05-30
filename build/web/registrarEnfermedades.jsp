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
            font-family: "Comic Sans MS";
            background-image: url("https://img.freepik.com/vector-premium/fondo-pixel-art-granja-otonal_23-2149597070.jpg");
            background-size: cover;
            background-repeat:no-repeat;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
          select {
             width: 100%;
                padding: 10px;
                border: 2px solid #4CAF50;
                border-radius: 8px;
                background-color: #f9f9f9;
                font-size: 16px;
                color: #333;
                outline: none;
                transition: border-color 0.3s;
        }

        select:focus {
          border-color: #2e7d32;
          background-color: #fff;
        }

    </style>
    <body class = "bodyPersonalizao">
    <div class="contenedorDatitos">
        <h1>Iniciar Sesión</h1>
        <%
            String error = (String) request.getAttribute("error");
            String gogobien = (String) request.getAttribute("gogobien");
            if (error != null && !error.isEmpty()) {
        %>
            <p class="mensajitoMaloPiumPium"><%= error %></p>
        <%
            } else if (gogobien != null && !gogobien.isEmpty()){
        %>
            <p class="mensajitoBuenoPiumPium"><%=gogobien%></p>
        <%
            }
        %>
       <form action="${pageContext.request.contextPath}/gesti2" method="post">
            <div class="formulariogogo">
                <label>Tipo de enfermedad</label>
                <input type="text" id="username" name="huertocorral" required>
            </div>
            <div class="formulariogogo">
                <label for="password">Sintomas observados</label>
                <input type="text" id="password" name="animalvegetal" required>
            </div>
            <div class="formulariogogo">
                <label for="password">Fecha de detección</label>
                <input type="text" id="password" name="humedad" required>
            </div>
            <button type="submit">crear</button>
        </form>
    </div>
    </body>
</html>
