package mx.core.doc.xb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement(name = "Antecedente")
public class Study {

    private String center;
    private Integer idLevel;
    private String level;
    private String idState;
    private String state;
    private XMLGregorianCalendar start;
    private XMLGregorianCalendar end;
    private String code;

    @XmlAttribute(name = "institucionProcedencia", required = true)
    public String getCenter() {
        return center;
    }
    public void setCenter(String center) {
        this.center = center;
    }

    @XmlAttribute(name = "idTipoEstudioAntecedente", required = true)
    public Integer getIdLevel() {
        return idLevel;
    }
    public void setIdLevel(Integer idLevel) {
        this.idLevel = idLevel;
    }

    @XmlAttribute(name = "tipoEstudioAntecedente", required = true)
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    @XmlAttribute(name = "idEntidadFederativa", required = true)
    public String getIdState() {
        return idState;
    }
    public void setIdState(String idState) {
        this.idState = idState;
    }
    
    @XmlAttribute(name = "entidadFederativa")
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
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

    @XmlAttribute(name = "noCedula")
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
