<!DOCTYPE html>
<html>
    <head>
        <title>Inicio de Sesi�n | AgriProducciones</title>
        <link rel="stylesheet" href="estilosGlobalesGogo.css"/>
    </head>
    <body>
        <div class="contenedorDatitos">
            <h1>Iniciar Sesi�n</h1>
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
                    <label for="password">Contrase�a</label>
                    <input type="password" id="password" name="contrase�a" required>
                </div>
                <button type="submit">Iniciar Sesi�n</button>
            </form>
        </div>
    </body>
</html>