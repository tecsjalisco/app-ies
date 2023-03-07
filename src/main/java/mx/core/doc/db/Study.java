package mx.core.doc.db;

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
import mx.core.load.db.Level;
import mx.core.load.db.State;

/**
 * Entidad Persistente Modalidad
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.doc.db.Study")
@Table(name="DocStudies")
public class Study implements Serializable {
    
    private Long id;
    private State state;
    private Level level;
    private String name;
    private String start;
    private String end;
    private String code;
    
    public Study(){
    }
    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_STUDY")
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
    * @return Estado
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_STATE")
    public State getState() {
        return state;
    }
    /**
    * @param state Estado
    */
    public void setState(State state) {
        this.state = state;
    }
    /**
    * @return Nivel de Estudio
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_LEVEL")
    public Level getLevel() {
        return level;
    }
    /**
    * @param level Nivel de Estudio
    */
    public void setLevel(Level level) {
        this.level = level;
    }
    /**
    * @return nombre
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
    * @return Fecha de Inicio
    */
    @Column(name="start")
    public String getStart() {
        return start;
    }
    /**
    * @param start Fecha de Inicio
    */
    public void setStart(String start) {
        this.start = start;
    }
    /**
    * @return Fecha de Termino
    */
    @Column(name="end")
    public String getEnd() {
        return end;
    }
    /**
    * @param end Fecha de Termino
    */
    public void setEnd(String end) {
        this.end = end;
    }
    /**
    * @return Número de cedula
    */
    @Column(name="code")
    public String getCode() {
        return code;
    }
    /**
    * @param code Número de cedula
    */
    public void setCode(String code) {
        this.code = code;
    }

}
