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

import es.acuesta.academy.dto.EstudianteDTO;
import es.acuesta.academy.service.EstudianteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping({ "/estudiante" })
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/estudiante")
    public Long create(@RequestBody EstudianteDTO estudiante) {
    	return estudianteService.create(estudiante);
    }

    @GetMapping("/estudiantes")
    public ResponseEntity <List<EstudianteDTO>> findAll() {
    	List<EstudianteDTO> estudiante = estudianteService.findAll();
		return new ResponseEntity<List<EstudianteDTO>>(estudiante, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
	@ResponseBody
    public EstudianteDTO findById(@PathVariable(name = "id") Long id) {
    	return estudianteService.findById(id);
    }

    @PutMapping("/detalle")
	@ResponseBody
    public Long update(@RequestBody EstudianteDTO estudiante) {
        return estudianteService.create(estudiante);
    }

    @DeleteMapping(path = { "/{id}" })
    public void deleteById(@PathVariable (name = "id") Long id) {
        estudianteService.deleteById(id);
    }

}
