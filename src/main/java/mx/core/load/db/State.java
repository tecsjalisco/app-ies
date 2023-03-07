package mx.core.load.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Persistente Estado
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.load.db.State")
@Table(name="LoadStates")
public class State implements Serializable {
    
    private Integer id;
    private String code;
    private String name;
    
    public State(){
        this.name = "";
    }
    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_STATE")
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
    * @return Clave
    */
    @Column(name="code")
    public String getCode() {
        return code;
    }
    /**
    * @param code clave
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
}
