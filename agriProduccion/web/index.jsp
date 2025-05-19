<!DOCTYPE html>
<html>
<head>
    <title>Inicio de Sesión</title>
    <style>
        body {
            font-family: Times-new-roman;
            background-color: black;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .contenedorDatitos {
            background-color: #cccccc;
            padding: 30px;
            border-radius: 8px;
            width: 300px;
            text-align: center;
        }
        h1 {
            color: black;
            margin-bottom: 20px;
        }
        .formulariogogo {
            margin-bottom: 30px;
            text-align: left;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: black;
            font-size: 1em;
        }
        input {
            width: 100%;
            padding: 10px;
            border: 1px solid red;
            border-radius: 10px;
            box-sizing: border-box;
            font-size: 1em;
        }
        button{
            background-color: #99ff99;
            color: white;
            padding: 10px 10px;
            border: 1px solid red;
            border-radius: 10px;
            cursor: pointer;
            font-size: 1em;
            width: 100%;
        }
        button:hover {
            background-color: #4cae4c;
        }
        .mensajitoMaloPiumPium {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="contenedorDatitos">
        <h1>Iniciar Sesión</h1>
        <%
            String error = (String) request.getAttribute("error");
            if (error != null && !error.isEmpty()) {
        %>
            <p class="mensajitoMaloPiumPium"><%= error %></p>
        <%
            }
        %>
        <form action="validarDatitosUsuario" method="post">
            <div class="formulariogogo">
                <label>Usuario:</label>
                <input type="text" id="username" name="usuario" required>
            </div>
            <div class="formulariogogo">
                <label>Contraseña:</label>
                <input type="password" id="password" name="contraseña" required>
            </div>
            <button type="submit">Iniciar Sesión</button>
        </form>
    </div>
</body>
</html>