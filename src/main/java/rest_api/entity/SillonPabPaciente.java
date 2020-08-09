package rest_api.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table=(name="SillonPabPaciente")
public class SillonPabPaciente implements Serializable {

    public SillonPabPaciente(Long id, Long idPaciente, Long idPabellon, Long idSillon) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idPabellon = idPabellon;
        this.idSillon = idSillon;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idSillonPabPaciente;
    @Column(name="idPaciente")
    private Long idPaciente;
    @Column(name="idPabellon")
    private Long idPabellon;
    @Column(name="idSillon")
    private Long idSillon;

    public Long getId() {
        return id;
    }

    public Long getidPaciente() {
        return idPaciente;
    }

    public Long getidPabellon() {
        return idPabellon;
    }

    public Long getidSillon() {
        return idSillon;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setidPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setidPabellon(Long idPabellon) {
        this.idPabellon = idPabellon;
    }

    public void setidSillon(Long idSillon) {
        this.idSillon = idSillon;
    }
}