package es.acuesta.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.acuesta.academy.dto.AsignaturaDTO;
import es.acuesta.academy.service.AsignaturaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping({ "/api" })
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @PostMapping("/asignatura")
    public Long create(AsignaturaDTO asignatura) {
        return asignaturaService.create(asignatura);
    }

    @GetMapping("/asignaturas")
    public ResponseEntity <List<AsignaturaDTO>> findAll() {
		List<AsignaturaDTO> asignatura = asignaturaService.findAll();
		return new ResponseEntity<List<AsignaturaDTO>>(asignatura, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
	@ResponseBody
    public AsignaturaDTO findById(@PathVariable(name = "id") Long id) {
        return asignaturaService.findById(id);
    }

    @PutMapping
    public Long update(@RequestBody AsignaturaDTO asignatura) {
        return asignaturaService.create(asignatura);
    }

    @DeleteMapping(path = { "/{id}" })
    public void deleteById(@PathVariable (name = "id") Long id) {
        asignaturaService.deleteById(id);
    }

}
