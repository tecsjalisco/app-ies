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
import mx.core.org.db.Center;
import mx.core.prg.db.Program;

/**
 * Entidad Persistente Titulos
 * @author Gabriel Cisneros
 * @version 1.0.0
 * @since sicyt 1.0.0
*/
@Entity(name="mx.core.doc.db.Doc")
@Table(name="Docs")
public class Doc implements Serializable {
    
    private Long id;
    private Center center;
    private Program program;
    private Study study;
    private Proto proto;
    private String code;
    private String name;
    private String firstName;
    private String secondName;
    private String CURP;
    private String email;
    private String start;
    private String end;
    private String date;
    private String status;
    
    public Doc(){
    }
    /**
    * @return Identificador
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_DOC")
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
    * @return Centro Estudio
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_CENTER")
    public Center getCenter() {
        return center;
    }
    /**
    * @param center Centro Estudio
    */
    public void setCenter(Center center) {
        this.center = center;
    }
    /**
    * @return Carrera
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_PROGRAM")
    public Program getProgram() {
        return program;
    }
    /**
    * @param program Carrera
    */
    public void setProgram(Program program) {
        this.program = program;
    }
    /**
    * @return Estudios Antecedente
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_STUDY")
    public Study getStudy() {
        return study;
    }
    /**
    * @param study Estudios Antecendentes
    */
    public void setStudy(Study study) {
        this.study = study;
    }

    /**
    * @return Protocolo
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_PROTO")
    public Proto getProto() {
        return proto;
    }
    /**
    * @param proto Protocolo
    */
    public void setProto(Proto proto) {
        this.proto = proto;
    }

    /**
    * @return Folio
    */
    @Column(name="code")
    public String getCode() {
        return code;
    }
    /**
    * @param code Folio
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
    * @return Apellido Paterno
    */
    @Column(name="firstName")
    public String getFirstName() {
        return firstName;
    }
    /**
    * @param firstName Apellido Paterno
    */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
    * @return Apellido Materno
    */
    @Column(name="secondName")
    public String getSecondName() {
        return secondName;
    }
    /**
    * @param secondName Apellido Materno
    */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    /**
    * @return CURP
    */
    @Column(name="CURP")
    public String getCURP() {
        return CURP;
    }
    /**
    * @param CURP CURP
    */
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }
    /**
    * @return Email
    */
    @Column(name="email")
    public String getEmail() {
        return email;
    }
    /**
    * @param email Email
    */
    public void setEmail(String email) {
        this.email = email;
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
