package rest_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


//basicamente una tabla de la BD 

@Entity
@Table(name = "medico")
public class Medico implements Serializable {
    
    public Medico()
    {

    }
    public Medico(String nombre, String cargo, String estado){
        this.nombre = nombre;
        this.cargo = cargo;
        this.estado = estado;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "estado")
    private String estado;


    public Long getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getCargo()
    {
        return cargo;
    }

    public String getEstado()
    {
        return estado;
    }


    public void setId(Long id)
    {
        this.id = id;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setCargo(String cargo)
    {
        this.cargo = cargo;
    }
    
    public void setEstado(String estado)
    {
        this.estado = estado;
    }    
    


}