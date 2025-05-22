package sqlgogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class conexionesActivasXd {
    String usuario;
    String url;
    String clave;
    Connection conex;

    public conexionesActivasXd() {
        usuario = "root";
        url = "jdbc:mysql://localhost:3306/agriproducciones";
        clave = "";
        conex = null;
    }

    public void hacerConexion() throws SQLException {
        conex = DriverManager.getConnection(url, usuario, clave);
        System.out.println("Conexión exitosa: " + conex);
    }

    public boolean guardarDatos(ArrayList datitos) throws SQLException {
        if (conex == null) {
            throw new SQLException("La conexion no existe aun xd.");
        }
        String sql = "INSERT INTO datoshuertos (huerto, contenido, humedad ) VALUES (?, ?; ?)";
        try (PreparedStatement pstmt = conex.prepareStatement(sql)) {
            pstmt.setString(1, (String) datitos.get(0));
            pstmt.setString(2, (String) datitos.get(1));
            pstmt.setString(3, (String) datitos.get(2));

            pstmt.executeUpdate();
            System.out.println("Datos guardados bien xd.");
            return true;
        } catch (SQLException e) {
            System.err.println("Error al guardar esos datitos: " + e.getMessage());
            throw e;
        }
    }
}