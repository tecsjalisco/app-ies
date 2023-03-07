package mx.core.sec.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Persistente Rol
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.sec.db.Rol")
@Table(name="SecRoles")
public class Rol implements Serializable {
    
    private Integer id;
    private String name;

    public Rol(){
        name = "";
    }
    
    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_ROL")
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
    
}
