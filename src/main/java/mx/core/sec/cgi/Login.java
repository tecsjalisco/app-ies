package mx.core.sec.cgi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.core.org.db.Center;
import mx.core.usr.db.User;
import mx.core.util.CoreException;
import mx.core.util.HibernateUtil;
import mx.core.util.MD5;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 * Función      Valida el inicio de sesión de los diferentes tipos de usuario
 * Parametros:  email       Identificador de la cuenta de usuario
 *              passwd      Contraseña de la cuenta de usuario
 * Excepciones  SEC001      El usuario no se encuentra registrado
 *              SEC002      El usuario tiene mas de dos cuentas
 *              SEC003      EL password es incorrecto
 *              SEC004      La cuenta no esta activada
 * Author       Gabriel Cisneros Landeros
 * version      1.0.0
 */
@WebServlet(name = "login", urlPatterns = {"/sec/login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //org.hibernate.Session db = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Session db = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = db.beginTransaction();
        HttpSession wsession = request.getSession();
        try {
            String band = "CORE000";
            String NIP = MD5.encriptar(request.getParameter("NIP"));
            Query query = db.createSQLQuery("SELECT * FROM OrgCenters WHERE (code = '" +request.getParameter("center")+"') OR ( ID_CENTER = "+request.getParameter("center")+" ) ").addEntity(Center.class);
            if(!query.list().isEmpty()){
                Center center = (Center) query.list().get(0);
                query = db.createSQLQuery("SELECT * FROM Users WHERE email = '" +request.getParameter("email")+"' AND ID_CENTER =  "+center.getId()+" ").addEntity(User.class);
                List<User> list = query.list();
                if (list == null || list.isEmpty()) {
                    throw new CoreException("SEC001");
                }else{
                    if(list.size() == 1 ){
                        User user = list.get(0);
                        if (user.getNIP().equals(NIP)) {
                            wsession.setAttribute("user", user);
                            wsession.setAttribute("cer", user.getCertificate().getCode());
                            wsession.setAttribute("center", center.getId());
                            band = "CORE000";
                        } else {
                            throw new CoreException("SEC003");
                        }
                    }else{
                        throw new CoreException("SEC002");
                    }
                }
            }else{
                throw new CoreException("SEC004");
            }
            transaction.commit();
            db.close();
            out.print(band);
        } catch (CoreException ex){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            db.close();
            out.print(ex.getMessage());
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
