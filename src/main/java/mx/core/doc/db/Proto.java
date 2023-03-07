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
import mx.core.load.db.Mode;
import mx.core.load.db.Soc;

/**
 * Entidad Persistente Modalidad
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.doc.db.Proto")
@Table(name="DocProto")
public class Proto implements Serializable {
    
    private Long id;
    private Mode mode;
    private Soc soc;
    private String date;
    
    public Proto(){
    }
    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_PROTO")
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
    * @return Modo
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_MODE")
    public Mode getMode() {
        return mode;
    }
    /**
    * @param mode Modo
    */
    public void setMode(Mode mode) {
        this.mode = mode;
    }
    /**
    * @return Servicio Social
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_SOC")
    public Soc getSoc() {
        return soc;
    }
    /**
    * @param soc Servicio Social
    */
    public void setSoc(Soc soc) {
        this.soc = soc;
    }
    /**
    * @return Fecha
    */
    @Column(name="date")
    public String getDate() {
        return date;
    }
    /**
    * @param date Fecha
    */
    public void setDate(String date) {
        this.date = date;
    }

}
