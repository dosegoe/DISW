package rest_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//TABLA DE BD

@Entity
@Table(name="paciente")
public class Paciente implements Serializable {

  public Paciente(){
  }
  public Paciente(Long id, Long idmedico, Long estado){
    this.id = id;
    this.idmedico = idmedico;
    this.estado = estado;
  }

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name="IdMedico")
  private Long idmedico;
  @Column(name="Estado")
  private Long estado;

  //GETTERS Y SETTERS

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

  public void setIdmedico(Long idmedico)
  {
      this.idmedico = idmedico;
  }

  public void setEstado(Long estado)
  {
      this.estado = estado;
  }
}
