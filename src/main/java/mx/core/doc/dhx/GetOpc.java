package mx.core.doc.dhx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.core.load.db.Level;
import mx.core.load.db.Mode;
import mx.core.load.db.Soc;
import mx.core.load.db.State;
import mx.core.prg.db.Program;
import mx.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 * Función      Devuelve los objetos de usuarios en formato dhx_combo
 * Parametros:  entity      Tipo de objeto
 * Author       Gabriel Cisneros Landeros
 * since        sicyt
 * version      1.0.0
 */
@WebServlet(name = "getDocOpc", urlPatterns = {"/doc/getDocOpc"})
public class GetOpc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String entity = request.getParameter("entity");
        //org.hibernate.Session db = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Session db = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = db.beginTransaction();
        try {
            out.print("<complete>");
            if(entity.equalsIgnoreCase("program")){
                Query query = db.createSQLQuery("SELECT * FROM Programs WHERE ID_CENTER = "+request.getParameter("center")+" ORDER BY code").addEntity(Program.class);
                List<Program> list = query.list();
                Integer i = 0;
                for(Program program : list){
                    if((request.getParameter("id") != null && Integer.parseInt(request.getParameter("id")) == program.getId())){
                        out.print("<option value='" + program.getId() + "' selected='true' >" + program.getCode()+" - "+program.getName() + "</option>");
                    }else{
                        out.print("<option value='" + program.getId() + "' >" + program.getCode()+" - "+program.getName() + "</option>");
                    }
                    i++;
                }
            }
            if(entity.equalsIgnoreCase("mode")){
                Query query = db.createSQLQuery("SELECT * FROM LoadModes ").addEntity(Mode.class);
                List<Mode> list = query.list();
                Integer i = 0;
                for(Mode mode : list){
                    if((request.getParameter("id") != null && Integer.parseInt(request.getParameter("id")) == mode.getId())){
                        out.print("<option value='" + mode.getId() + "' selected='true' >" + mode.getName()+ "</option>");
                    }else{
                        out.print("<option value='" + mode.getId() + "' >" + mode.getName() + "</option>");
                    }
                    i++;
                }
            }
            if(entity.equalsIgnoreCase("soc")){
                Query query = db.createSQLQuery("SELECT * FROM LoadSoc ").addEntity(Soc.class);
                List<Soc> list = query.list();
                Integer i = 0;
                for(Soc soc : list){
                    if((request.getParameter("id") != null && Integer.parseInt(request.getParameter("id")) == soc.getId())){
                        out.print("<option value='" + soc.getId() + "' selected='true' >" + soc.getName()+ "</option>");
                    }else{
                        out.print("<option value='" + soc.getId() + "' >" + soc.getName() + "</option>");
                    }
                    i++;
                }
            }
            if(entity.equalsIgnoreCase("level")){
                Query query = db.createSQLQuery("SELECT * FROM LoadLevel ").addEntity(Level.class);
                List<Level> list = query.list();
                Integer i = 0;
                for(Level level : list){
                    if((request.getParameter("id") != null && Integer.parseInt(request.getParameter("id")) == level.getId())){
                        out.print("<option value='" + level.getId() + "' selected='true' >" + level.getName()+ "</option>");
                    }else{
                        out.print("<option value='" + level.getId() + "' >" + level.getName() + "</option>");
                    }
                    i++;
                }
            }
            if(entity.equalsIgnoreCase("states")){
                Query query = db.createSQLQuery("SELECT * FROM LoadStates ").addEntity(State.class);
                List<State> list = query.list();
                Integer i = 0;
                for(State state : list){
                    if((request.getParameter("id") != null && Integer.parseInt(request.getParameter("id")) == state.getId())){
                        out.print("<option value='" + state.getId() + "' selected='true' >" + state.getName()+ "</option>");
                    }else{
                        out.print("<option value='" + state.getId() + "' >" + state.getName() + "</option>");
                    }
                    i++;
                }
            }
            out.print("</complete>");
            transaction.commit();
            db.close();
        } catch (Exception ex){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            //if(db.isOpen()){db.close();}
            db.close();
            out.print(ex.getMessage());
        } finally {
            out.close();
        }
    }
}
