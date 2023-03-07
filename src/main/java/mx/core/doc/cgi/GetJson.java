package mx.core.doc.cgi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.core.doc.db.Doc;
import mx.core.util.HibernateUtil;
import org.hibernate.Transaction;

/**
 * Función      Devuelve los objetos de Usuarios en formato JSON
 * Parametros:  entity      Tipo de objeto
 *              id          Identificador del objeto
 * Author       Gabriel Cisneros Landeros
 * since        sicyt
 * version      1.0.0
 */
@WebServlet(name = "getDocJson", urlPatterns = {"/doc/getDocJson"})
public class GetJson extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        String entity = request.getParameter("entity");
        //org.hibernate.Session db = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Session db = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = db.beginTransaction();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status","1");
        jsonObject.addProperty("msn","");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            if(entity.equals("doc")){
                Doc doc = (Doc) db.get(Doc.class,Long.parseLong(request.getParameter("id")));
                jsonObject.addProperty("id",doc.getId()); jsonObject.addProperty("code",doc.getCode()); jsonObject.addProperty("name",doc.getName());
                jsonObject.addProperty("firstName",doc.getFirstName());jsonObject.addProperty("secondName",doc.getSecondName());jsonObject.addProperty("CURP",doc.getCURP()); 
                jsonObject.addProperty("email",doc.getEmail()); jsonObject.addProperty("date",doc.getDate()); jsonObject.addProperty("center",doc.getCenter().getId());
                jsonObject.addProperty("centerName",doc.getCenter().getName()); jsonObject.addProperty("program",doc.getProgram().getId());jsonObject.addProperty("mode",doc.getProto().getMode().getId());
                jsonObject.addProperty("proto",doc.getProto().getDate()); jsonObject.addProperty("soc",doc.getProto().getSoc().getId());jsonObject.addProperty("center2",doc.getStudy().getName());
                jsonObject.addProperty("level",doc.getStudy().getLevel().getId()); jsonObject.addProperty("state",doc.getStudy().getState().getId());
                jsonObject.addProperty("start2",doc.getStart());
                jsonObject.addProperty("end2",doc.getEnd());
                jsonObject.addProperty("start1",doc.getStudy().getStart());
                jsonObject.addProperty("end1",doc.getStudy().getEnd());
                jsonObject.addProperty("ced",doc.getStudy().getCode());
            }
            out.print(gson.toJson(jsonObject));
            transaction.commit();
            db.close();
        } catch (Exception ex){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            //if(db.isOpen()){db.close();}
            db.close();
            jsonObject.addProperty("status","0");
            jsonObject.addProperty("msn",ex.getMessage());
            out.print(gson.toJson(jsonObject));
        } finally {
            out.close();
        }
    }
}
