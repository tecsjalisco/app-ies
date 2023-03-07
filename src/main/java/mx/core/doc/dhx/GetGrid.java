package mx.core.doc.dhx;

import com.dhtmlx.connector.GridConnector;
import com.dhtmlx.connector.ThreadSafeConnectorServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.core.usr.db.User;
import mx.core.util.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;

/**
 * Función      Devuelve el conjunto de objetos de Usuarios formato DhtmlxGrid
 * Parametros:  entity      Tipo de objeto
 *              id          Identificador del objeto
 * Author       Gabriel Cisneros Landeros
 * since        sicyt
 * version      1.0.0
 */
@WebServlet(name = "getDocGrid", urlPatterns = {"/doc/getDocGrid"})
public class GetGrid extends ThreadSafeConnectorServlet {

   @Override
    protected void configure(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession websession = request.getSession();
        User user = (User) websession.getAttribute("user");
        String entity = request.getParameter("entity");
        //org.hibernate.Session db = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Session db = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = db.beginTransaction();
        SessionImplementor s = (SessionImplementor) db;
        try{
            GridConnector grid  = new GridConnector(s.connection());
            grid.dynamic_loading(50);
            grid.servlet(request,response);
            String sql = "";
            String fields = "";
            String id  ="id";
            if(entity.equals("docs")){
                sql = "SELECT * FROM DOC01V1 WHERE status <> 'ELIMINADO' AND center =  "+user.getCenter().getId();
                fields = "code,name,firstName,secondName,CURP,programName,ies,rvoe,status";
            }
            grid.render_sql(sql,id,fields);
            transaction.commit();
            db.close();
        } catch (Exception  ex) {
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            //if(db.isOpen()){db.close();}
            db.close();
        }
    }
    
}
