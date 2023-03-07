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

/**
 * Entidad Persistente Log
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.sec.db.Log")
@Table(name="SecLogs")
public class Log implements Serializable {
    
    private Long id;
    private Session session;
    private String code;
    private String note;
    private String status;

    public Log(){
        this.code = "";
        this.note = "";
        this.status = "SUCCESS";
    }

    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_LOG")
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
    * @return Sesión
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_SESSION")
    public Session getSession() {
        return session;
    }
    /**
    * @param session Sesión
    */
    public void setSession(Session session) {
        this.session = session;
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
    * @return Nota
    */
    @Column(name="note")
    public String getNote() {
        return note;
    }
    /**
    * @param note Nota
    */
    public void setNote(String note) {
        this.note = note;
    }

    /**
    * @return Estatus
    */
    @Column(name="status")
    public String getStatus() {
        return status;
    }
    /**
    * @param status Estatus
    */
    public void setStatus(String status) {
        this.status = status;
    }

}
