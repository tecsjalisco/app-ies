package mx.core.doc.xb;

import java.io.InputStream;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import mx.core.util.RSA;

@XmlRootElement(name = "FirmaResponsable")
public class Resp {

    private String name;
    private String firstName;
    private String secondName;
    private String curp;
    private Integer idPosition;
    private String position;
    private String level;
    private String key;
    private String certificate;
    private String idCertificate;

    public Resp(){}
    
    @XmlAttribute(name = "nombre", required = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "primerApellido", required = true)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlAttribute(name = "segundoApellido")
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    
    @XmlAttribute(name = "curp", required = true)
    public String getCurp() {
        return curp;
    }
    public void setCurp(String value) {
        this.curp = value;
    }

    @XmlAttribute(name = "idCargo", required = true)
    public Integer getIdPosition() {
        return idPosition;
    }
    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    @XmlAttribute(name = "cargo", required = true)
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    @XmlAttribute(name = "abrTitulo")
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    @XmlAttribute(name = "sello", required = true)
    public String getKey() {
        return key;
    }
    public void setKey(InputStream keyFile) {
        RSA rsa = new RSA();
        //this.key = rsa.signSHARSA(keyFile, this.cadOrigen); 
    }

    @XmlAttribute(name = "certificadoResponsable", required = true)
    public String getCertificate() {
        return certificate;
    }
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @XmlAttribute(name = "noCertificadoResponsable", required = true)
    public String getIdCertificate() {
        return idCertificate;
    }
    public void setIdCertificate(String idCertificate) {
        this.idCertificate = idCertificate;
    }
}
