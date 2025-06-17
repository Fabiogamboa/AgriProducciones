package sqlgogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class conexionesActivasXd {

    public static Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
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



    public void BuscarDatos(String dato, ArrayList<String> lista) {
        try {
            if ("gestionarHuertosCorrales".equals(dato)) {
                System.out.println("Esto imprime");
                lista.clear();
                String sql = "SELECT huerto, contenido, humedad FROM datoshuertos";
                PreparedStatement stmt = conex.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next ()){
                lista.add(rs.getString("huerto"));
                lista.add(rs.getString("contenido"));
                lista.add(rs.getString("humedad"));
                }                
                
            } else if ("registrarEnfermedades".equals(dato)) {
                 System.out.println("Esto imprime");
                lista.clear();
                String sql = "SELECT tipo_enfermedad, sintomas, fecha FROM enfermedad";
                PreparedStatement stmt = conex.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next ()){
                lista.add(rs.getString("tipo_enfermedad"));
                lista.add(rs.getString("sintomas"));
                lista.add(rs.getString("fecha"));
            } 
            } else if ("controlHumedad".equals(dato)){
                 System.out.println("Esto imprime");
                lista.clear();
                String sql = "SELECT humedad, fecha, metodoRiego FROM humedadCampo";
                PreparedStatement stmt = conex.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next ()){
                lista.add(rs.getString("humedad"));
                lista.add(rs.getString("fecha"));
                lista.add(rs.getString("metodoRiego"));
                        }
            }
        } catch (Exception ex) {
            System.out.println("ERROR");
        }
    }
    // Elimina un huerto por nombre
public void eliminarHuerto(String huerto) throws SQLException {
    if (conex == null) {
        throw new SQLException("No hay conexión establecida.");
    }
    String sql = "DELETE FROM datoshuertos WHERE huerto = ?";
    try (PreparedStatement stmt = conex.prepareStatement(sql)) {
        stmt.setString(1, huerto);
        stmt.executeUpdate();
        System.out.println("Huerto eliminado correctamente.");
    }
}

// Elimina una enfermedad por tipo
public void eliminarEnfermedad(String tipoEnfermedad) throws SQLException {
    if (conex == null) {
        throw new SQLException("No hay conexión establecida.");
    }
    String sql = "DELETE FROM enfermedad WHERE tipo_enfermedad = ?";
    try (PreparedStatement stmt = conex.prepareStatement(sql)) {
        stmt.setString(1, tipoEnfermedad);
        stmt.executeUpdate();
        System.out.println("Enfermedad eliminada correctamente.");
    }
}

// Elimina un registro de humedad por valor
public void eliminarHumedad(String humedad) throws SQLException {
    if (conex == null) {
        throw new SQLException("No hay conexión establecida.");
    }
    String sql = "DELETE FROM humedadCampo WHERE humedad = ?";
    try (PreparedStatement stmt = conex.prepareStatement(sql)) {
        stmt.setString(1, humedad);
        stmt.executeUpdate();
        System.out.println("Registro de humedad eliminado correctamente.");
    }
}


}