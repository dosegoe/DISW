package rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;
import rest_api.repository.SillonPabPacienteRepository;
import rest_api.entity.SillonPabPaciente;
import rest_api.model.MSillonPabPaciente;
import rest_api.converter.ConvertidorSillonPabPaciente;

import org.springframework.transaction.annotation.Transactional;

@Service("ServicioSillonPabPaciente")
public class SillonPabPacienteService {

    @Autowired
    @Qualifier("RepositorySillonPabPaciente")
    private SillonPabPacienteRepository repositorio;

    @Autowired
    @Qualifier("ConSillonPabPaciente")
    private ConvertidorSillonPabPaciente convertidor;

    public List<MSillonPabPaciente> listAll() {
        return convertidor.convertirLista(repositorio.findAll());
    }

    public MSillonPabPaciente listOne(Long id) {
        return convertidor.convertir(repositorio.findById(id));
    }

    public List<MSillonPabPaciente> listByidPaciente(Long idPaciente) {
        return convertidor.convertirLista(repositorio.findByidPaciente(idPaciente));
    }

    public SillonPabPaciente saveOrUpdateSillonPabPaciente(SillonPabPaciente sillonpabpaciente) {
        return repositorio.save(sillonpabpaciente);
    }

    public SillonPabPaciente convert(MSillonPabPaciente sillonpabpaciente) {
        return convertidor.convertirmtoe(sillonpabpaciente);
    }

    @Transactional
    public void deleteSillonPabPaciente(Long id) {
        repositorio.deleteById(id);
    }
}