package Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import sqlgogo.conexionesActivasXd;

@WebServlet(name = "Servlet2", urlPatterns = {"/Servlet2"})
public class Servlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id"); // Recibe el ID del registro a eliminar

        if (id != null && !id.isEmpty()) {
            Connection conn = null;
            PreparedStatement stmt = null;

            try {
                conn = conexionesActivasXd.getConexion(); // Usa tu clase de conexión
                String sql = "DELETE FROM registros WHERE id = ?"; // ⚠ Cambia "registros" por tu tabla real
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(id));
                stmt.executeUpdate(); // Ejecuta la eliminación
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (stmt != null) stmt.close(); } catch (Exception e) {}
                try { if (conn != null) conn.close(); } catch (Exception e) {}
            }
        }

        // Vuelve a cargar la página con los registros
        response.sendRedirect("Mostrar_Busqueda.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet que elimina registros desde Mostrar_Busqueda.jsp";
    }

}
