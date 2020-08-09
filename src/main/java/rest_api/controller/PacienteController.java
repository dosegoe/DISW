package rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.Valid;


import rest_api.entity.Paciente;
import rest_api.model.MPaciente;
import rest_api.service.PacienteService;

import java.util.List;

@CrossOrigin(origins = "*")
//esto mapea la app en requests URL->HTTP
@RestController
//localhost:puerto/api/medicos
@RequestMapping("/pacientes")
public class PacienteController{

  @Autowired
  @Qualifier("ServicioPaciente")
  PacienteService service;

  @PostMapping("")
  public ResponseEntity<Paciente> addPaciente (@RequestBody Paciente paciente)
  {
      try{
          System.out.println(paciente.getId());
          Paciente pacient = service.saveOrUpdatePaciente(paciente);
          return new ResponseEntity<Paciente>(pacient, HttpStatus.CREATED);

      }catch(Exception e){
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Creo que otro mensaje tiene la prioridad cuando el estado es un string por ejemplo, pero igual retorna HTTP 400 Bad Request entonces está bien
      }
  }
  
    @GetMapping("")
    public List<MPaciente> getPacientes()
    {
        return service.listAll();
    }
  
    @GetMapping("/{id}")
    public ResponseEntity<MPaciente> getPacienteById(@PathVariable("id") Long id)
    {
        try{
            service.listOne(id);
            return new ResponseEntity<MPaciente>(service.listOne(id), HttpStatus.OK);
            }catch(Exception e){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<MPaciente>> getPacientesByEstado(@RequestParam(value="estado") Long estado)
    {
        try {
            return new ResponseEntity<>(service.listByEstado(estado), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    // @GetMapping("/pabellon")
    // public ResponseEntity<List<MPaciente>> getPacientesByPabellon(@RequestParam(value="idPabellon") Long idPabellon)
    // {
    //     try {
    //         return new ResponseEntity<>(service.listByPabellon(idPabellon), HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //     }
    // }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody MPaciente paciente)
    {
        Paciente newpac = service.convert(paciente);
        newpac.setId(id);
        System.out.println(id);
        Paciente pacient = service.saveOrUpdatePaciente(newpac);
        return new ResponseEntity<Paciente>(pacient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Long id)
    {
        try{
            service.deletePaciente(id);
            return new ResponseEntity<>(
            "Se borro con exito",
            HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(
            "Ocurrio un error",
            HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>("Estado no válido", HttpStatus.BAD_REQUEST);
        
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleTypeMismatch(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>("Estado no válido", HttpStatus.BAD_REQUEST);
        
    }

}
