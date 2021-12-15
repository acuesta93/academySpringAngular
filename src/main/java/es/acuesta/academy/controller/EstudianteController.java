package es.acuesta.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acuesta.academy.model.Estudiante;
import es.acuesta.academy.service.EstudianteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping({ "/api" })
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/estudiante")
    public void create(@RequestBody Estudiante estudiante) {
        estudianteService.create(estudiante);
    }

    @GetMapping("/estudiantes")
    public List<Estudiante> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Estudiante find() {
        return null;
    }

    @PutMapping
    public void update(@RequestBody Estudiante estudiante) {
        estudianteService.create(estudiante);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody Estudiante estudiante) {
        estudianteService.delete(estudiante);
    }

}
