package mx.core.doc.xb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Institucion")
public class Center {
    
    private String code;
    private String name;

    @XmlAttribute(name = "cveInstitucion", required = true)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @XmlAttribute(name = "nombreInstitucion", required = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
