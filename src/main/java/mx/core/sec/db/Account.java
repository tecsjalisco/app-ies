package mx.core.sec.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import mx.core.util.MD5;

/**
 * Entidad Persistente Cuentas
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.sec.db.Account")
@Table(name="SecAccounts")
public class Account implements Serializable {
    
    private Integer id;
    private Rol rol;
    private String name;
    private String phone;
    private String email;
    private String NIP;

    public Account(){
        email = "";
        NIP = MD5.encriptar("123456");
    }

    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_ACCOUNT")
    public Integer getId() {
        return id;
    }
    /**
    * @param id Identificador
    */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
    * @return Rol
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_ROL")
    public Rol getRol() {
        return rol;
    }
    /**
    * @param rol Rol
    */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
    * @return Nombre
    */
    @Column(name="name")
    public String getName() {
        return name;
    }
    /**
    * @param name Nombre
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * @return Correo electrónico
    */
    @Column(name="email")
    public String getEmail() {
        return email;
    }
    /**
    * @param email Correo electrónico
    */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
    * @return Teléfono
    */
    @Column(name="phone")
    public String getPhone() {
        return phone;
    }
    /**
    * @param phone Teléfono
    */
    public void setPhone(String phone) {
        this.phone = phone;
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
}
