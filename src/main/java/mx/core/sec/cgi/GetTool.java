package mx.core.sec.cgi;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "getTool", urlPatterns = {"/sec/getTool"})
public class GetTool extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.print("[");
         switch(request.getParameter("code")){
                case "CORE01" :
                    out.print("{'id': 'DOC01', 'type': 'button', 'img': 'DOC01_1.png', 'imgdis': 'DOC01_0.png', 'text': 'Títulos Electrónicos'},");
                    out.print("{'id': 'EXT01', 'type': 'button', 'img': 'EXT01_1.png', 'imgdis': 'EXT01_0.png', 'text': 'Cerrar Sesión' },");
                    break;
                case "DOC01" :
                    out.print("{'id': 'DOC01_SEE', 'type': 'button', 'img': 'SEE_1.png', 'imgdis': 'SEE_0.png', 'title': 'Consultar Título' },");
                    out.print("{'id': 'DOC01_VALID', 'type': 'button', 'img': 'VALID_1.png', 'imgdis': 'VALID_0.png', 'title': 'Validar Título' }");
                    break;
            }
            out.print("]");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
