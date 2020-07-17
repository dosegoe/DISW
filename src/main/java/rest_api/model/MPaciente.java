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
  }

  public MPaciente(Long id, Long idmedico, Long estado){
    this.id = id;
    this.idmedico = idmedico;
    this.estado = estado;
  }

  private Long id;
  private Long idmedico;
  private Long estado;

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
}
