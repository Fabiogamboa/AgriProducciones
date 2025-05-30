<!DOCTYPE html>
<html>
    <head>
        <title>Inicio de Sesión | AgriProducciones</title>
        <link rel="stylesheet" href="estilosGlobalesGogo.css"/>
    </head>
    <body>
        <div class="contenedorDatitos">
            <h1>Iniciar Sesión</h1>
            <%
                String error = (String) request.getAttribute("error");
                if (error != null && !error.isEmpty()) {
            %>
            <p class="mensajitoMaloPiumPium"><%= error%></p>
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