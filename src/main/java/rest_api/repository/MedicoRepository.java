package rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.io.Serializable;

import rest_api.entity.Medico;
//esto implementa las operaciones CRUD para ser usadas
@Repository("RepositoryMedico")
public interface MedicoRepository extends JpaRepository<Medico, Serializable>,
    PagingAndSortingRepository<Medico, Serializable>
{
    public abstract Medico findById(long id);

    public abstract List<Medico> findAll();
    
    public abstract List<Medico> findByEstado(String estado);
    
    public abstract void deleteById(long id);
}