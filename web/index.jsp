<!DOCTYPE html>
<html>
<head>
    <title>Inicio de Sesión | AgriProducciones</title>
    <style>
        body {
            font-family: "Times-new-roman";
            background-image: url("https://images6.alphacoders.com/137/1370648.jpeg");
            background-size: cover;
            background-repeat: no repeat;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .contenedorDatitos {
            background-color: #ffffff;
            padding: 40px;
            border: 3px solid green;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
        }
        h1 {
            color: #333333;
            margin-bottom: 25px;
            font-weight: 700;
            font-size: 2em;
        }
        .formulariogogo {
            margin-bottom: 20px;
            text-align: left;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #555555;
            font-size: 0.95em;
            font-weight: 500;
        }
        input {
            border: 1px solid green;
            width: 100%;
            padding: 12px;
            border: 1px solid #ced4da;
            border-radius: 8px;
            box-sizing: border-box;
            font-size: 1em;
            transition: border-color 0.3s ease, box-shadow 0.3s ease;
        }
        input:focus {
            border-color: #66bb6a;
            box-shadow: 0 0 0 3px rgba(102, 187, 106, 0.2); 
            outline: none;
        }
        button {
            background-color: #66bb6a;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1.1em;
            font-weight: 700;
            width: 100%;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }
        button:hover {
            background-color: #5cb85c;
            transform: translateY(-2px);
        }
        .mensajitoMaloPiumPium {
            color: #dc3545;
            margin-top: 15px;
            font-size: 0.9em;
            background-color: #f8d7da; 
            border: 1px solid #f5c6cb;
            padding: 10px;
            border-radius: 8px;
            margin-bottom: 20px;
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
                <label for="username">Usuario</label>
                <input type="text" id="username" name="usuario" required>
            </div>
            <div class="formulariogogo">
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="contraseña" required>
            </div>
            <button type="submit">Iniciar Sesión</button>
        </form>
    </div>
</body>
</html>