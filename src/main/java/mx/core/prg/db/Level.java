package mx.core.prg.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Persistente Nivel de Estudios
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.prg.db.Level")
@Table(name="PrgLevels")
public class Level implements Serializable {
    
    private Integer id;
    private String code;
    private String name;
    
    public Level(){
        this.name = "";
    }
    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_LEVEL")
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
    public String getCode() {
        return code;
    }
    /**
    * @param code Clave
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
