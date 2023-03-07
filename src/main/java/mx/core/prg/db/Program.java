package mx.core.prg.db;

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
import mx.core.org.db.Center;

/**
 * Entidad Persistente Programa Estudio
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.prg.db.Program")
@Table(name="Programs")
public class Program implements Serializable {
    
    private Integer id;
    private Center center;
    private Reco reco;
    private String code;
    private String name;
    private String RVOE;
    private Byte status;

    public Program(){
        this.code = "";
        this.name = "";
        this.RVOE = "";
        this.status = new Byte("1");
    }

    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_PROGRAM")
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
    * @return Centro de Estudio
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_CENTER")
    public Center getCenter() {
        return center;
    }
    /**
    * @param center Centro de Estudio
    */
    public void setCenter(Center center) {
        this.center = center;
    }
    
    /**
    * @return Reconocimiento
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_RECO")
    public Reco getReco() {
        return reco;
    }
    /**
    * @param reco Reconocimiento
    */
    public void setReco(Reco reco) {
        this.reco = reco;
    }

    /**
    * @return Clave
    */
    @Column(name="code")
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
    * @return RVOE
    */
    @Column(name="RVOE")
    public String getRVOE() {
        return RVOE;
    }
    /**
    * @param RVOE REVOE
    */
    public void setRVOE(String RVOE) {
        this.RVOE = RVOE;
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
