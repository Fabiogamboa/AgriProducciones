import modelos.modeloRegistrarEnfermedades;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "gesti2", urlPatterns = {"/gesti2"})
public class gesti2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String enfermedad = request.getParameter("tipoEnfermedad");
        String sintomas = request.getParameter("sintomasObs");
        String fecha = request.getParameter("fecha");
        boolean xdprueba = false;
        String mensaje = null;

        try {
            modeloRegistrarEnfermedades objModeloEnfermedades = new modelos.modeloRegistrarEnfermedades();
            xdprueba = objModeloEnfermedades.guardarInfo(enfermedad, sintomas, fecha);

            if (xdprueba) {
                mensaje = "¡Datos guardados correctamente!";
                request.setAttribute("gogobien", mensaje);
            } else {
                mensaje = "No se pudo guardar la información.";
                request.setAttribute("error", mensaje);
            }

        } catch (SQLException ex) {
            Logger.getLogger(gesti2.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "No se puede guardar en base de datos, revisa los datos.";
            request.setAttribute("error", mensaje);
        }

        request.getRequestDispatcher("registrarEnfermedades.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("registrarEnfermedades.jsp").forward(request, response);
    }
}