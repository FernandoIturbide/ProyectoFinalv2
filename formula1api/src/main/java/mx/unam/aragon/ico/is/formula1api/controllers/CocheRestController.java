package mx.unam.aragon.ico.is.formula1api.controllers;

import jakarta.validation.Valid;
import mx.unam.aragon.ico.is.formula1api.entities.Formula1Coche;
import mx.unam.aragon.ico.is.formula1api.repositories.CocheRepository;
import mx.unam.aragon.ico.is.formula1api.services.interfaces.CocheService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/formulaone/")
public class CocheRestController {

    @Autowired
    private CocheRepository cocheRepository;
    @Autowired
    private CocheService cocheService;


    @GetMapping("/")
    public ResponseEntity<Iterable<Formula1Coche>> getCoches() {
        //return cocheService.listarTodos();
        //return new ResponseEntity<>(cocheService.listarTodos(),HttpStatus.OK);
        return ResponseEntity.ok().body(cocheService.listarTodos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Formula1Coche> getCoche(@PathVariable Integer id) {
        //return cocheService.buscarPorId(id).orElse(null);
        return ResponseEntity.ok(cocheService.buscarPorId(id).orElse(null));
    }

    @PostMapping("/")
    public ResponseEntity<Formula1Coche> createCoche(
           @Valid @RequestBody Formula1Coche coche) throws URISyntaxException {
        //return cocheService.crear(coche);
        return ResponseEntity.created(new URI("http://localhost:8081/")).body(cocheService.crear(coche));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formula1Coche> updateCoche(@PathVariable Integer id,
                                                     @RequestBody Formula1Coche coche) {
        return ResponseEntity.ok(cocheService.actualizar(id, coche));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Formula1Coche> patchFormula1Coche(@PathVariable Integer id,
                                                            @RequestBody Formula1Coche coche) {
        Optional<Formula1Coche> tmp = cocheService.buscarPorId(id);
        if(tmp.isPresent()) {
            LoggerFactory.getLogger(CocheRestController.class).info("Coche actualizado: " + coche);
            Formula1Coche actual = tmp.get();
            if(coche.getModelo() != null) actual.setModelo(coche.getModelo());
            if(coche.getEquipo() != null) actual.setEquipo(coche.getEquipo());
            if(coche.getPeso() != null) actual.setPeso(coche.getPeso());
            if(coche.getFoto() != null) actual.setFoto(coche.getFoto());
            if(coche.getMotor() != null) actual.setMotor(coche.getMotor());
            return ResponseEntity.ok(cocheService.actualizar(id, actual));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCoche(@PathVariable Integer id) {
        cocheService.eliminar(id);
    }

}
