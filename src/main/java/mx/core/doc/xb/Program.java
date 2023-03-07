package mx.core.doc.xb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement(name = "Carrera")
public class Program {

    private String code;
    private String name;
    private XMLGregorianCalendar start;
    private XMLGregorianCalendar end;
    private Integer idAuth;
    private String auth;
    private String rvoe;

    @XmlAttribute(name = "cveCarrera", required = true)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @XmlAttribute(name = "nombreCarrera", required = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "fechaInicio")
    @XmlSchemaType(name = "date")
    public XMLGregorianCalendar getStart() {
        return start;
    }
    public void setStart(XMLGregorianCalendar start) {
        this.start = start;
    }

    @XmlAttribute(name = "fechaTerminacion", required = true)
    @XmlSchemaType(name = "date")    
    public XMLGregorianCalendar getEnd() {
        return end;
    }
    public void setEnd(XMLGregorianCalendar end) {
        this.end = end;
    }

    @XmlAttribute(name = "idAutorizacionReconocimiento", required = true)
    public Integer getIdAuth() {
        return idAuth;
    }
    public void setIdAuth(Integer idAuth) {
        this.idAuth = idAuth;
    }

    @XmlAttribute(name = "autorizacionReconocimiento", required = true)
    public String getAuth() {
        return auth;
    }
    public void setAuth(String auth) {
        this.auth = auth;
    }

    @XmlAttribute(name = "numeroRvoe")
    public String getRvoe() {
        return rvoe;
    }
    public void setRvoe(String rvoe) {
        this.rvoe = rvoe;
    }
}
