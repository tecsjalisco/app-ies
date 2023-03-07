package mx.core.sec.cgi;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Función      Cierra una sesión activa
 * Author       Gabriel Cisneros Landeros
 * version      1.0.0
 */
@WebServlet(name = "logout", urlPatterns = {"/sec/logout"})
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession websession = request.getSession();
            String url = request.getContextPath()+"/login.jsp";
            //websession.removeAttribute("user");
            //websession.removeAttribute("center");
            websession.invalidate();
            response.sendRedirect("http://tituloelectronico.jalisco.gob.mx:8080/ies2/login.jsp");
        } finally {
            out.close();
        }
    }
}
