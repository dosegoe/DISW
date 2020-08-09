package rest_api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

import rest_api.entity.SillonPabPaciente;

@Repository("RepositorySillonPabPaciente")
public interface SillonPabPaciente extends JpaRepository<SillonPabPaciente, Serializable>,
    PagingAndSortingRepository<SillonPabPaciente, Serializable> {
        public abstract SillonPabPaciente findById(Long id);

        public abstract List<SillonPabPaciente> findAll();

        public abstract List<Paciente> findByidPaciente(Long idPaciente);

        public abstract void deleteById(Long id);
    }