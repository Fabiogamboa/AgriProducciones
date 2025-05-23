import modelos.modeloCorralesHuertos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "gestionarHuertos")
public class gestionHuertos extends HttpServlet {
    
    private modeloCorralesHuertos objModeloCorrales;
    private boolean xdprueba;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipoContenedorxd = request.getParameter("huertocorral");
        String tipoDeContenidoHuerto = request.getParameter("animalvegetal");
        String humedadSuelo = request.getParameter("humedad");
        xdprueba = false;
        try {
            objModeloCorrales = new modeloCorralesHuertos();
        } catch (SQLException ex) {
            Logger.getLogger(gestionHuertos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            xdprueba = objModeloCorrales.guardarInfo(tipoContenedorxd,tipoDeContenidoHuerto,humedadSuelo);
            if (xdprueba == true){
            request.setAttribute("gogobien", "tabien");
            request.getRequestDispatcher("gestionarHuertosCorrales.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(gestionHuertos.class.getName()).log(Level.SEVERE, null, ex);
            if (xdprueba == false){
            request.setAttribute("error", "no se puede guardar en base de datos, reisa xd");
            request.getRequestDispatcher("gestionarHuertosCorrales.jsp").forward(request, response);
        }
        }
        
    }
}
