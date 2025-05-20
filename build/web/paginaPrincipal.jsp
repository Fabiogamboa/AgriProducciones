<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Panel de Administración Agrícola</title>
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
        }
        .container {
            width: 90%;
            max-width: 800px;
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

    </style>
</head>
<body>
    <div class="container">
        <h1>Bienvenido, aquí están sus opciones:</h1>
        <div class="botones">
            <button onclick="location.href='gestionarHuertosCorrales.jsp'">Crear Huerto/Corral</button>
            <button onclick="location.href='registrarEnfermedades.jsp'">Registrar Enfermedades</button>
            <button onclick="location.href='controlHumedad.jsp'">Control de Humedad del Terreno</button>
        </div>
    </div>
</body>
</html>
