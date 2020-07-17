package rest_api.model;

import rest_api.entity.Medico;

import java.io.Serializable;



//basicamente una tabla de la BD 


public class MMedico implements Serializable{
    
    public MMedico()
    {

    }
    public MMedico(Medico Medico){
        this.id = Medico.getId();
        this.nombre = Medico.getNombre();
        this.cargo = Medico.getCargo();
        this.estado = Medico.getEstado();
    }
    public MMedico(Long id,String nombre, String cargo, String estado){
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.estado = estado;
    }
    

    private Long id;
    private String nombre;
    private String cargo;
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