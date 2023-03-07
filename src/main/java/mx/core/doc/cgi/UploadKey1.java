package mx.core.doc.cgi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import mx.core.doc.db.CadOrigen;
import mx.core.doc.xb.Center;
import mx.core.doc.xb.Program;
import mx.core.doc.xb.Resp;
import mx.core.doc.xb.Student;
import mx.core.doc.xb.Study;
import mx.core.usr.db.User;
import mx.core.util.Date;
import mx.core.util.HibernateUtil;
import mx.core.util.SAT;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.hibernate.Query;
import org.hibernate.Transaction;


@WebServlet(name = "uploadKey1", urlPatterns = {"/doc/uploadKey1"})
public class UploadKey1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        HttpSession websession = request.getSession();
        User resp = (User) websession.getAttribute("user");
        String cer = (String) websession.getAttribute("cer");
        PrintWriter out = response.getWriter();
        String fileName = "";
        //org.hibernate.Session db = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Session db = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = db.beginTransaction();
        File file1 = null;
        File file2 = null;
        try {
            List items;
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            items = upload.parseRequest(request);
            Iterator itr = items.iterator();
            InputStream fileKey = null;   
            while(itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if(!item.isFormField() && item.getFieldName().equalsIgnoreCase("file")) {
                    fileKey = item.getInputStream();
                    fileName = item.getName().replaceAll("[^\\dA-Za-z.]", "");
                }
            }
            //File targetFile = new File("/Users/sistemas/key/" +fileName);
            File targetFile = new File("/home/sicyt/key/" +fileName);
            FileUtils.copyInputStreamToFile(fileKey, targetFile);
            Query query = db.createSQLQuery("SELECT * FROM Docs WHERE ID_DOC in ("+request.getParameter("ids")+") AND status = 'ELABORADO' ").addEntity(mx.core.doc.db.Doc.class);
            List<mx.core.doc.db.Doc> docs = query.list();            
            for(mx.core.doc.db.Doc doc  : docs){
                Center xb_center = new Center();
                xb_center.setCode(doc.getCenter().getCode());
                xb_center.setName(doc.getCenter().getName());
                Resp xb_resp = new Resp();
                xb_resp.setCurp(resp.getCURP());
                xb_resp.setName(resp.getName());
                xb_resp.setFirstName(resp.getFirstName());
                xb_resp.setSecondName(resp.getSecondName());
                xb_resp.setIdPosition(resp.getPosition().getId());
                xb_resp.setPosition(resp.getPosition().getName());
                xb_resp.setLevel(resp.getLevel().getCode());
                xb_resp.setCertificate(cer);
                Program xb_program = new Program();
                xb_program.setCode(doc.getProgram().getCode());
                xb_program.setName(doc.getProgram().getName());
                xb_program.setStart(Date.fechaXML(doc.getStart()));
                xb_program.setEnd(Date.fechaXML(doc.getEnd()));
                xb_program.setIdAuth(doc.getProgram().getReco().getId());
                xb_program.setAuth(doc.getProgram().getReco().getName());
                xb_program.setRvoe(doc.getProgram().getRVOE());
                Student xb_student = new Student();
                xb_student.setCurp(doc.getCURP());
                xb_student.setNombre(doc.getName());
                xb_student.setFirstName(doc.getFirstName());
                xb_student.setSecondName(doc.getSecondName());
                xb_student.setEmail(doc.getEmail());
                Study xb_study = new Study();
                xb_study.setCenter(doc.getStudy().getName());
                xb_study.setIdLevel(doc.getStudy().getLevel().getId());
                xb_study.setLevel(doc.getStudy().getLevel().getName());
                xb_study.setIdState(doc.getStudy().getState().getCode());
                xb_study.setState(doc.getStudy().getState().getName());
                xb_study.setStart(Date.fechaXML(doc.getStudy().getStart()));
                xb_study.setEnd(Date.fechaXML(doc.getStudy().getEnd()));
                
                xb_study.setCode(doc.getStudy().getCode());
                mx.core.doc.xb.Doc xb_doc = new mx.core.doc.xb.Doc();
                xb_doc.setDate(Date.fechaXML(doc.getDate()));
                xb_doc.setIdMode(doc.getProto().getMode().getId());
                xb_doc.setMode(doc.getProto().getMode().getName());
                if (doc.getProto().getMode().getId().equals(1)) {
                    xb_doc.setDateExamPro(Date.fechaXML(doc.getProto().getDate()));
                } else {
                    xb_doc.setDateExenPro(Date.fechaXML(doc.getProto().getDate()));
                }
                if (!doc.getProto().getSoc().getId().equals(5)) {
                    xb_doc.setSoc(1);
                    xb_doc.setIdLegalSoc(doc.getProto().getSoc().getId());
                    xb_doc.setLegalSoc(doc.getProto().getSoc().getName());
                }else{
                    xb_doc.setSoc(0);
                    xb_doc.setIdLegalSoc(doc.getProto().getSoc().getId());
                    xb_doc.setLegalSoc(doc.getProto().getSoc().getName());
                }
                xb_doc.setIdState(14);
                xb_doc.setState("JALISCO");

                file1 = new File("/home/sicyt/cadenas/CadenaOrigen_" + doc.getCode() + ".txt");
                //file1 = new File("/Users/sistemas/cadenas/CadenaOrigen_" + doc.getCode() + ".txt");
                file1.createNewFile();
                CadOrigen cad = new CadOrigen(doc.getCode(), xb_center, xb_resp, xb_program, xb_student, xb_doc, xb_study);
                //FileWriter fw = new FileWriter(file1);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1, false), StandardCharsets.UTF_8));
                //BufferedWriter bw = new BufferedWriter(fw);
                
                bw.write(cad.parseString());
                bw.close();

                InputStream key = Files.newInputStream(Paths.get("/home/sicyt/key/"+fileName));
                //InputStream key = Files.newInputStream(Paths.get("/Users/sistemas/key/"+fileName));
                String tmp = SAT.sing(key, request.getParameter("nip"), cad.parseString());

                file2 = new File("/home/sicyt/cadenas/FirmaOrigen_" + doc.getCode() + ".txt");
                //file2 = new File("/Users/sistemas/cadenas/FirmaOrigen_" + doc.getCode() + ".txt");
                file2.createNewFile();
                //fw = new FileWriter(file2);
                //bw = new BufferedWriter(fw);
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, false), StandardCharsets.UTF_8));
                bw.write(tmp);
                bw.close();
            
                doc.setStatus("VALIDADO");
                db.update(doc);
            
            }
            out.print("{state: true, name:'"+fileName+"', extra: {info: '', param: ''}}");
            transaction.commit();
            db.close();
            targetFile.delete();
        } catch (Exception  ex) {
            Logger.getLogger(UploadKey1.class.getName()).log(Level.SEVERE, null, ex);
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            //if(db.isOpen()){db.close();}
            db.close();
            out.print("{state: false, name:'"+fileName+"', extra: {info: '"+ex.getMessage()+"', param: ''}}");
            file1.delete();
            file2.delete();
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
