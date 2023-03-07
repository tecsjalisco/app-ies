package mx.core.doc.dhx;


import com.dhtmlx.connector.GridConnector;
import com.dhtmlx.connector.ThreadSafeConnectorServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.core.util.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;

/**
 * Función      Devuelve los objetos Usuarios en formato DhtmlxGrid
 * Author       Gabriel Cisneros Landeros
 * version      1.0.0
 */
@WebServlet(name = "getDocPop", urlPatterns = {"/doc/getDocPop"})
public class GetPop extends ThreadSafeConnectorServlet {
    
    @Override
    protected void configure(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
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
            String id = "id";
            if(entity.equalsIgnoreCase("centers")){
                sql = "SELECT * FROM OrgCenters WHERE status = 1 ";
                id = "ID_CENTER";
                fields = "code,name";
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
