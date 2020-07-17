package rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;
import rest_api.repository.MedicoRepository;
import rest_api.entity.Medico;
import rest_api.model.MMedico;
import rest_api.converter.ConvertidorMedico;

import org.springframework.transaction.annotation.Transactional;




//esto define que operaciones de las definidas seran usadas
@Service("ServicioMedico")
public class MedicoService
{
    @Autowired
    @Qualifier("RepositoryMedico")
    private MedicoRepository repositorio;

    @Autowired
    @Qualifier("ConMedico")
    private ConvertidorMedico convertidor;

    // request
    public List<MMedico> listAll() {
      return convertidor.convertirLista(repositorio.findAll());
    }

    public MMedico listOne(Long id) {
      return convertidor.convertir(repositorio.findById(id));
    }
    public List<MMedico> listByEstado(String estado)
    {
      return convertidor.convertirLista(repositorio.findByEstado(estado));
    }
    //create & update
    public Medico saveOrUpdateMedico(Medico medico)
    {
      //Save guarda una entidad
      return repositorio.save(medico);
    }
    public Medico convert(MMedico medico){
      return convertidor.convertirmtoe(medico);
    }

    //delete
    @Transactional
    public void deleteMedico(Long id)
    {
      repositorio.deleteById(id);
    }

}
