package mx.core.org.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Persistente Centro de Estudios
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.org.db.Center")
@Table(name="OrgCenters")
public class Center implements Serializable {
    
    private Long id;
    private String code;
    private String name;
    private Byte status;
    
    public Center(){
        this.code = "";
        this.name = "";
        this.status = new Byte("1");
    }
    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_CENTER")
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
    * @return Clave Institucional
    */
    @Column(name="code")
    public String getCode() {
        return code;
    }
    /**
    * @param code Clave Institucional
    */
    public void setCode(String code) {
        this.code = code;
    }

    /**
    * @return Nombre completo
    */
    @Column(name="name")
    public String getName() {
        return name;
    }
    /**
    * @param name Nombre completo
    */
    public void setName(String name) {
        this.name = name;
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
