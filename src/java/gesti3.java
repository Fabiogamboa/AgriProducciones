import modelos.modeloControlHumedad;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "gesti3", urlPatterns = {"/gesti3"})
public class gesti3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String humedadSuelo = request.getParameter("humedad");
        String fechaDato = request.getParameter("fecha");
        String metodo = request.getParameter("metodoRiego");
        boolean xdprueba = false;
        String mensaje = null;

        try {
            modeloControlHumedad objModelohumedad = new modelos.modeloControlHumedad();
            xdprueba = objModelohumedad.guardarInfo(humedadSuelo, fechaDato, metodo);

            if (xdprueba) {
                mensaje = "¡Datos guardados correctamente!";
                request.setAttribute("gogobien", mensaje);
            } else {
                mensaje = "No se pudo guardar la información.";
                request.setAttribute("error", mensaje);
            }

        } catch (SQLException ex) {
            Logger.getLogger(gesti3.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "No se puede guardar en base de datos, revisa los datos.";
            request.setAttribute("error", mensaje);
        }
    request.getRequestDispatcher("controlHumedad.jsp").forward(request, response);
}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("controlHumedad.jsp").forward(request, response);
    }
}
