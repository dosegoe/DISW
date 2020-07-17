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
@Table(name = "pabellones")
public class Pabellon implements Serializable {
    
    public Pabellon()
    {

    }
    public Pabellon(String nombre, String paciente, String estado){
        this.nombre = nombre;
        this.paciente = paciente;
        this.estado = estado;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Numero")
    private String nombre;
    @Column(name = "estado")
    private String estado;
    @Column(name = "paciente")
    private String paciente;

    public Long getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getPaciente()
    {
        return paciente;
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
    public void setPaciente(String paciente)
    {
        this.paciente = paciente;
    }
    
    public void setEstado(String estado)
    {
        this.estado = estado;
    }    
    


}