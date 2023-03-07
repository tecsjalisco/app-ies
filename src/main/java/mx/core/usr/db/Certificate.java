package mx.core.usr.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Persistente Certificados
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.usr.db.Certificate")
@Table(name="UsrCertificates")
public class Certificate implements Serializable {
    
    private Long id;
    private String code;

    public Certificate(){
        this.code = "";
    }

    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_CERTIFICATE")
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
    * @return Número
    */
    @Column(name="code")
    public String getCode() {
        return code;
    }
    /**
    * @param code Número
    */
    public void setCode(String code) {
        this.code = code;
    }

}
