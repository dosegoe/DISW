package rest_api.controller;

import java.util.List;

import rest_api.entity.SillonPabpaciente;
import rest_api.model.MSillonPabPaciente;
import rest_api.serviceSillonPabPacienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sppacientes")
public class SillonPabPacienteController {

    @Autowired
    @Qualifier("ServicioSillonPabPaciente")
    SillonPabpacienteService service;

    @PostMapping("")
    public ResponseEntity<SillonPabPaciente> addSillonPabPaciente (@RequestBody SillonPabPaciente sillonpabpaciente) {
        try {
            SillonPabPaciente sillonpabpacient = service.saveOrUpdateSillonPabPaciente(sillonpabpaciente);
            return new ResponseEntity<SillonPabPaciente>(sillonpabpacient, HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public List<MSillonPabPaciente> getSillonPabPacientes() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MSillonPabPaciente> getSillonPabPacientesById(@PathVariable("id") Long id) {
        try {
            service.listOne(id);
            return new ResponseEntity<MSillonPabPaciente>(service.listOne(id), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<MSillonPabPaciente>> getSillonPabPacientesByidPaciente(@RequestParam(value="idPaciente") Long idPaciente) {
        try {
            return new ResponseEntity<>(service.listByidPaciente(idPaciente), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SillonPabPaciente> updateSillonPabPaciente(@PathVariable Long id, @RequestBody MSillonPabPaciente sillonpabpaciente) {
        SillonPabPaciente newsillonpabpac = service.convert(sillonpabpaciente);
        newsillonpabpac.setId(id);
        SillonPabPaciente sillonpabpacient = service.saveOrUpdateSillonPabPaciente(newsillonpabpac);
        return new ResponseEntity<SillonPabPaciente>(sillonpabpacient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Long id) {
        try {
            service.deleteSillonPabPaciente(id);
            return new ResponseEntity<>("Se borro con exito", HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>("Ocurrio un error", HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>("No válido", HttpStatus.BAD_REQUEST);
        
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleTypeMismatch(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>("No válido", HttpStatus.BAD_REQUEST);
        
    }

}
