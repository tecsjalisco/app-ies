package mx.core.doc.xb;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "firmaResponsables",
    "institucion",
    "carrera",
    "profesionista",
    "expedicion",
    "antecedente",
    "autenticacion"
})
@XmlRootElement(name = "TituloElectronico")
public class Degree {
    
    private ArrayList<Resp> sings;
    private Center campus;
    private Program program;
    private Student student;
    private Doc expedition;
    private Study study;
    private Auth auth;
    private String version;
    private String code;
    
    public Degree(String code){
        this.version = "1.0";
        this.code = code;
    }
    
    @XmlElementWrapper(name = "FirmaResponsables", required = true)
    @XmlElement(name = "FirmaResponsable")
    public ArrayList<Resp> getSings() {
        return sings;
    }
    public void setSings(ArrayList<Resp> sings) {
        this.sings = sings;
    }

    @XmlElement(name = "Institucion", required = true)
    public Center getCampus() {
        return campus;
    }
    public void setCampus(Center campus) {
        this.campus = campus;
    }

    @XmlElement(name = "Carrera", required = true)
    public Program getProgram() {
        return program;
    }
    public void setProgram(Program program) {
        this.program = program;
    }

    @XmlElement(name = "Profesionista", required = true)
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @XmlElement(name = "Expedicion", required = true)
    public Doc getExpedition() {
        return expedition;
    }
    public void setExpedition(Doc expedition) {
        this.expedition = expedition;
    }

    @XmlElement(name = "Antecedente", required = true)
    public Study getStudy() {
        return study;
    }
    public void setStudy(Study study) {
        this.study = study;
    }

    @XmlElement(name = "Autenticacion")
    public Auth getAuth() {
        return auth;
    }
    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @XmlAttribute(name = "version", required = true)
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAttribute(name = "folioControl", required = true)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}