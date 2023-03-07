package mx.core.doc.xb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement(name = "Expedicion")
public class Doc {

    private XMLGregorianCalendar date;
    private Integer idMode;
    private String mode;
    private XMLGregorianCalendar dateExamPro;
    private XMLGregorianCalendar dateExenPro;
    private Integer soc;
    private Integer idLegalSoc;
    private String legalSoc;
    private Integer idState;
    private String state;


    @XmlAttribute(name = "fechaExpedicion", required = true)
    @XmlSchemaType(name = "date")
    public XMLGregorianCalendar getDate() {
        return date;
    }
    public void setDate(XMLGregorianCalendar date) {
        this.date = date;
    }

    @XmlAttribute(name = "idModalidadTitulacion", required = true)
    public Integer getIdMode() {
        return idMode;
    }
    public void setIdMode(Integer idMode) {
        this.idMode = idMode;
    }

    @XmlAttribute(name = "modalidadTitulacion", required = true)
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }

    @XmlAttribute(name = "fechaExamenProfesional")
    @XmlSchemaType(name = "date")
    public XMLGregorianCalendar getDateExamPro() {
        return dateExamPro;
    }
    public void setDateExamPro(XMLGregorianCalendar dateExamPro) {
        this.dateExamPro = dateExamPro;
    }

    @XmlAttribute(name = "fechaExencionExamenProfesional")
    @XmlSchemaType(name = "date")
    public XMLGregorianCalendar getDateExenPro() {
        return dateExenPro;
    }
    public void setDateExenPro(XMLGregorianCalendar dateExenPro) {
        this.dateExenPro = dateExenPro;
    }

    @XmlAttribute(name = "cumplioServicioSocial", required = true)
    public Integer getSoc() {
        return soc;
    }
    public void setSoc(Integer soc) {
        this.soc = soc;
    }

    @XmlAttribute(name = "idFundamentoLegalServicioSocial", required = true)
    public Integer getIdLegalSoc() {
        return idLegalSoc;
    }
    public void setIdLegalSoc(Integer idLegalSoc) {
        this.idLegalSoc = idLegalSoc;
    }
    
    @XmlAttribute(name = "fundamentoLegalServicioSocial", required = true)
    public String getLegalSoc() {
        return legalSoc;
    }
    public void setLegalSoc(String legalSoc) {
        this.legalSoc = legalSoc;
    }

    @XmlAttribute(name = "idEntidadFederativa", required = true)
    public Integer getIdState() {
        return idState;
    }
    public void setIdState(Integer idState) {
        this.idState = idState;
    }

    @XmlAttribute(name = "entidadFederativa", required = true)
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
