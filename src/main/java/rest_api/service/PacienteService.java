package rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;
import rest_api.repository.PacienteRepository;
import rest_api.entity.Paciente;
import rest_api.model.MPaciente;
import rest_api.converter.ConvertidorPaciente;

import org.springframework.transaction.annotation.Transactional;

@Service("ServicioPaciente")
public class PacienteService{

  @Autowired
  @Qualifier("RepositoryPaciente")
  private PacienteRepository repositorio;

  @Autowired
  @Qualifier("ConPaciente")
  private ConvertidorPaciente convertidor;

  // request
  public List<MPaciente> listAll() {
    return convertidor.convertirLista(repositorio.findAll());
  }

  public MPaciente listOne(Long id) {
    return convertidor.convertir(repositorio.findById(id));
  }
  public List<MPaciente> listByEstado(Long estado)
  {
    return convertidor.convertirLista(repositorio.findByEstado(estado));
  }
  public List<MPaciente> listByPabellon(Long idPabellon)
  {
    return convertidor.convertirLista(repositorio.findByPabellon(idPabellon));
  }
  //create & update
  public Paciente saveOrUpdatePaciente(Paciente paciente)
  {
    return repositorio.save(paciente);
  }
  public Paciente convert(MPaciente paciente){
    return convertidor.convertirmtoe(paciente);
  }

  //delete
  @Transactional
  public void deletePaciente(Long id)
  {
    repositorio.deleteById(id);
  }

}
