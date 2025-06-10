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

    public conexionesActivasXd() throws SQLException {
        usuario = "root";
        url = "jdbc:mysql://localhost:3306/agriproducciones";
        clave = "";
        conex = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver JDBC de MySQL", e);
        }
        conex = DriverManager.getConnection(url, usuario, clave);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxxxxxxx");
    }


    public boolean guardarDatos(ArrayList<String> datitos) throws SQLException {
        if (conex == null) {
            throw new SQLException("La conexion no existe aun xd.");
        }
        String sql = "INSERT INTO datoshuertos (huerto, contenido, humedad ) VALUES (?, ?, ?)";
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
    
     public boolean guardarDatosEnfermedades(ArrayList<String> datos) throws SQLException {
        if (conex == null) {
            throw new SQLException("La conexión no existe :v");
        }
    
        String sql = "INSERT INTO enfermedad (tipo_enfermedad, sintomas, fecha) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conex.prepareStatement(sql)) {
            pstmt.setString(1, datos.get(0));
            pstmt.setString(2, datos.get(1));
            pstmt.setString(3, datos.get(2));
            pstmt.executeUpdate();
            System.out.println("Datos de enfermedad guardados correctamente.");
            return true;
        } catch (SQLException e) {
            System.err.println("Error al guardar datos de enfermedad: " + e.getMessage());
            throw e;
        }
    }
     
     
    public boolean guardarDatosHumedad(ArrayList<String> datos) throws SQLException {
        if (conex == null) {
            throw new SQLException("La conexión no existe :v");
        }
    
        String sql = "INSERT INTO humedadCampo (humedad, fecha, metodoRiego) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conex.prepareStatement(sql)) {
            pstmt.setString(1, datos.get(0));
            pstmt.setString(2, datos.get(1));
            pstmt.setString(3, datos.get(2));
            pstmt.executeUpdate();
            System.out.println("Datos de humedad guardados correctamente.");
            return true;
        } catch (SQLException e) {
            System.err.println("Error al guardar datos de humedad :v : " + e.getMessage());
            throw e;
        }
    }
}