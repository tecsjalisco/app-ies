package mx.core.usr.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import mx.core.org.db.Center;
import mx.core.org.db.Position;
import mx.core.prg.db.Level;

/**
 * Entidad Persistente Usuario
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.usr.db.User")
@Table(name="Users")
public class User implements Serializable {
    
    private Long id;
    private Position position;
    private Center center;
    private Level level;
    private String name;
    private String firstName;
    private String secondName;
    private String CURP;
    private Certificate certificate;
    private String email;
    private String NIP;
    private Byte status;

    public User(){
        this.name = "";
        this.firstName = "";
        this.secondName = "";
        this.CURP = "";
        this.email = "";
        this.NIP = "";
        this.status = new Byte("1");
    }

    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_USER")
    public Long getId() {
        return id;
    }
    /**
    * @param id Identificador
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    * @return Centro de Estudios
    */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_CENTER")
    public Center getCenter() {
        return center;
    }
    /**
    * @param center Centro de Estudios
    */
    public void setCenter(Center center) {
        this.center = center;
    }
    
    /**
    * @return Puesto
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_POSITION")
    public Position getPosition() {
        return position;
    }
    /**
    * @param position Position
    */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
    * @return Nivel de Estudios
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_LEVEL")
    public Level getLevel() {
        return level;
    }
    /**
    * @param level Level
    */
    public void setLevel(Level level) {
        this.level = level;
    }
    
    /**
    * @return Nombre
    */
    @Column(name="name")
    public String getName() {
        return name;
    }
    /**
    * @param name Name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * @return Apellido Paterno
    */
    @Column(name="firstName")
    public String getFirstName() {
        return firstName;
    }
    /**
    * @param firstName Apellido Paterno
    */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
    * @return Apellido Materno
    */
    @Column(name="secondName")
    public String getSecondName() {
        return secondName;
    }
    /**
    * @param secondName Apellido Materno
    */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
    * @return CURP
    */
    @Column(name="CURP")
    public String getCURP() {
        return CURP;
    }
    /**
    * @param CURP CURP
    */
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    /**
    * @return Certificado
    */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_CERTIFICATE")
    public Certificate getCertificate() {
        return certificate;
    }
    /**
    * @param certificate Certificado
    */
    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    /**
    * @return Email
    */
    @Column(name="email")
    public String getEmail() {
        return email;
    }
    /**
    * @param email Email
    */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
    * @return NIP
    */
    @Column(name="NIP")
    public String getNIP() {
        return NIP;
    }
    /**
    * @param NIP NIP
    */
    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    /**
    * @return Estatus
    */
    @Column(name="status")
    public Byte getStatus() {
        return status;
    }
    /**
    * @param status Estatus
    */
    public void setStatus(Byte status) {
        this.status = status;
    }

}
