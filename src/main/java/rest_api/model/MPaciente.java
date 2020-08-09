package rest_api.model;

import rest_api.entity.Paciente;

import java.io.Serializable;

public class MPaciente implements Serializable{

  public MPaciente(){

  }

  public MPaciente(Paciente paciente){
    this.id = paciente.getId();
    this.idmedico = paciente.getIdmedico();
    this.estado = paciente.getEstado();
    this.idPabellon = paciente.getIdPabellon();
    this.idCamaPabellon = paciente.getIdCamaPabellon();
  }

  public MPaciente(Long id, Long idmedico, Long estado, Long idPabellon, Long idCamaPabellon){
    this.id = id;
    this.idmedico = idmedico;
    this.estado = estado;
    this.idPabellon = idPabellon;
    this.idCamaPabellon = idCamaPabellon;
  }

  private Long id;
  private Long idmedico;
  private Long estado;
  private Long idPabellon;
  private Long idCamaPabellon;

  public Long getId()
  {
      return id;
  }

  public Long getIdmedico()
  {
      return idmedico;
  }

  public Long getEstado()
  {
      return estado;
  }

  public Long getIdPabellon()
  {
      return idPabellon;
  }

  public Long getIdCamaPabellon()
  {
      return idCamaPabellon;
  }

  public void setId(Long id)
  {
      this.id = id;
  }

  public void setNombre(Long idmedico)
  {
      this.idmedico = idmedico;
  }

  public void setEstado(Long estado)
  {
      this.estado = estado;
  }

  public void setIdPabellon(Long idPabellon)
  {
      this.idPabellon = idPabellon;
  }

  public void setIdCamaPabellon(Long idCamaPabellon)
  {
      this.idCamaPabellon = idCamaPabellon;
  }
}
