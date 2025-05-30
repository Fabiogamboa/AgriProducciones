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

        String tipoContenedorxd = request.getParameter("huertocorral");
        String tipoDeContenidoHuerto = request.getParameter("animalvegetal");
        String humedadSuelo = request.getParameter("humedad");
        boolean xdprueba = false;
        String mensaje = null;

        try {
            modeloControlHumedad objModeloCorrales = new modelos.modeloControlHumedad();
            xdprueba = objModeloCorrales.guardarInfo(tipoContenedorxd, tipoDeContenidoHuerto, humedadSuelo);

            if (xdprueba) {
                mensaje = "¡Datos guardados correctamente!3";
                request.setAttribute("gogobien", mensaje);
            } else {
                mensaje = "No se pudo guardar la información.3";
                request.setAttribute("error", mensaje);
            }

        } catch (SQLException ex) {
            Logger.getLogger(gesti.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "No se puede guardar en base de datos, revisa los datos.3";
            request.setAttribute("error", mensaje);
        }

        request.getRequestDispatcher("controlHumedad.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Puedes redirigir al JSP directamente si quieres mostrar el formulario
        request.getRequestDispatcher("controlHumedad.jsp").forward(request, response);
    }
}
