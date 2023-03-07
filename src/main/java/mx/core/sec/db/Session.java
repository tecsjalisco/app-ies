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
 * Entidad Persistente Sesión
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.sec.db.Session")
@Table(name="SecSessions")
public class Session implements Serializable {
    
    private Long id;
    private Account account;
    private String start;
    private String end;
    private String ip;
    private String status;

    public Session(){
        this.start = "";
        this.end = "";
        this.ip = "127.0.0.1";
        this.status = "ACTIVO";
    }
    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_SESSION")
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
    * @return Cuenta
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_ACCOUNT")
    public Account getAccount() {
        return account;
    }
    /**
    * @param account Cuenta
    */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
    * @return Fecha y hora de inicio
    */
    @Column(name="start")
    public String getStart() {
        return start;
    }
    /**
    * @param start Fecha y hora de inicio
    */
    public void setStart(String start) {
        this.start = start;
    }

    /**
    * @return Fecha y hora de termino
    */
    @Column(name="end")
    public String getEnd() {
        return end;
    }
    /**
    * @param end Fecha y hora de termino
    */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
    * @return IP
    */
    @Column(name="IP")
    public String getIp() {
        return ip;
    }
    /**
    * @param ip IP
    */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
    * @return Status
    */
    @Column(name="status")
    public String getStatus() {
        return status;
    }
    /**
    * @param status Status
    */
    public void setStatus(String status) {
        this.status = status;
    }
}
