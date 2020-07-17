package rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.Valid;


import rest_api.entity.Medico;
import rest_api.model.MMedico;
import rest_api.service.MedicoService;

import java.util.List;

@CrossOrigin(origins = "*")
//esto mapea la app en requests URL->HTTP
@RestController
//localhost:puerto/api/medicos
@RequestMapping("/api/medicos")
public class MedicoController
{
    @Autowired
    @Qualifier("ServicioMedico")
    MedicoService service;

    // post 1 medico, requiere un body json equivalente a la clase Medico
    // Post localhost:puerto/api/medicos
    @PostMapping("")
    public ResponseEntity<Medico> addMedico (@RequestBody Medico medico)
    {

        System.out.println(medico.getNombre());
        Medico med = service.saveOrUpdateMedico(medico);
        return new ResponseEntity<Medico>(med, HttpStatus.CREATED);
    }
    // get all medicos
    //Get localhost:puerto/api/medicos
    @GetMapping("")
    public List<MMedico> getMedicos()
    {
        return service.listAll();
    }
    // get 1 medico by id, el parametro esta en la URL
    //GET localhost:puerto/api/medicos/id
    @GetMapping("/{id}")
    public MMedico getMedicoById(@PathVariable("id") Long id)
    {
        return service.listOne(id);
    }
    // get medicos que tengan el estado definido, este es un parametro de la request
    @GetMapping("/filter")
    public List<MMedico> getMedicosByEstado(@RequestParam(value="estado") String estado)
    {
        return service.listByEstado(estado);
    }
    // update 1 medico, sobre su id
    @PutMapping("/{id}")
    public Medico updateMedico(@PathVariable Long id, @RequestBody MMedico medico) 
    {
        MMedico med = service.listOne(id); 
        Medico newmed = service.convert(med);
        newmed.setId(id);
        return service.saveOrUpdateMedico(newmed);
    }
    // delete 1 medico, sobre su id
    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteMedico(@PathVariable Long id)
    {
        try{
            service.deleteMedico(id);
            return new ResponseEntity<>(
            "Se borro con exito", 
            HttpStatus.BAD_REQUEST);
        }catch(Exception e) {
            return new ResponseEntity<>(
            "Ocurrio un error", 
            HttpStatus.BAD_REQUEST);
        }
    }
}