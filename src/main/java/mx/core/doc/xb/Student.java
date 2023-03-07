package mx.core.doc.xb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Profesionista")
public class Student {
    
    private String curp;
    private String name;
    private String firstName;
    private String secondName;
    private String email;

    @XmlAttribute(name = "curp", required = true)
    public String getCurp() {
        return curp;
    }
    public void setCurp(String value) {
        this.curp = value;
    }

    @XmlAttribute(name = "nombre", required = true)
    public String getName() {
        return name;
    }
    public void setNombre(String name) {
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

    @XmlAttribute(name = "correoElectronico", required = true)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
