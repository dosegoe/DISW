package rest_api.model;

import rest_api.entity.SillonPabPaciente;

import java.io.Serializable;

public class MSillonPabPaciente implements Serializable {

    public MPaciente(SillonPabPaciente sillonpabpaciente) {
        this.id = sillonpabpaciente.getId();
        this.idPaciente = sillonpabpaciente.getidPaciente();
        this.idPabellon = sillonpabpaciente.getidPabellon();
        this.idSillon = sillonpabpaciente.getidSillon();
    }
    
    private Long id;
    private Long idPaciente;
    private Long idPabellon;
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