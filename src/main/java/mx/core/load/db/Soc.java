package mx.core.load.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Persistente Servicio Social
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.load.db.Soc")
@Table(name="LoadSoc")
public class Soc implements Serializable {
    
    private Integer id;
    private String name;
    
    public Soc(){
        this.name = "";
    }
    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_SOC")
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
