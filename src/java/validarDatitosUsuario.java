import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "validarDatitosUsuario" , urlPatterns = {"/validarDatitosUsuario"})
public class validarDatitosUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");

        if ("admin202".equals(usuario) && "quesoconarroz".equals(contraseña)) {
            response.sendRedirect("paginaPrincipal.jsp"); 
        } else {
            request.setAttribute("error", "Ta mal, t falta bro");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}