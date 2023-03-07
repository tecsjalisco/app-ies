package mx.core.doc.xb;

import java.io.InputStream;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import mx.core.util.RSA;

@XmlRootElement(name = "Autenticacion")
public class Auth {

    
    private String version;
    private String code;
    private XMLGregorianCalendar date;
    private String sealDegree;
    private String idCertificate;
    private String key;

    public Auth(){
        this.version = "1.0";
    }
    
    @XmlAttribute(name = "version", required = true)
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAttribute(name = "folioDigital", required = true)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @XmlAttribute(name = "fechaAutenticacion", required = true)
    @XmlSchemaType(name = "date")
    public XMLGregorianCalendar getDate() {
        return date;
    }
    public void setDate(XMLGregorianCalendar date) {
        this.date = date;
    }

    @XmlAttribute(name = "selloTitulo", required = true)
    public String getSealDegree() {
        return sealDegree;
    }
    public void setSealDegree(String sealDegree) {
        this.sealDegree = sealDegree;
    }

    @XmlAttribute(name = "noCertificadoAutoridad", required = true)
    public String getIdCertificate() {
        return idCertificate;
    }
    public void setIdCertificate(String idCertificate) {
        this.idCertificate = idCertificate;
    }

    @XmlAttribute(name = "selloAutenticacion", required = true)
    public String getKey() {
        return key;
    }
    public void setSeal(InputStream keyFile) {
        RSA rsa = new RSA();
        this.key = rsa.signSHARSA(keyFile, this.parseString());         
    }
    
    public String parseString(){
        String cadOrigen = "";
        cadOrigen += "||"+this.version; 
        cadOrigen += "|";
        cadOrigen +=  this.code;
        cadOrigen += "|";        
        cadOrigen += this.date; 
        cadOrigen += "|";        
        cadOrigen += this.key;
        cadOrigen += "|";        
        cadOrigen += this.idCertificate;
        cadOrigen += "||"; 
        return cadOrigen;
    }
}
