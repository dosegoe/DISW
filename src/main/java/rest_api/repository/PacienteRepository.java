package rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.io.Serializable;

import rest_api.entity.Paciente;

@Repository("RepositoryPaciente")
public interface PacienteRepository extends JpaRepository<Paciente, Serializable>,
    PagingAndSortingRepository<Paciente, Serializable>
    {

      public abstract Paciente findById(Long id);

      public abstract List<Paciente> findAll();

      public abstract List<Paciente> findByEstado(Long estado);

      public abstract void deleteById(Long id);
    }
