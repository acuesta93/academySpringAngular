package es.acuesta.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acuesta.academy.model.Asignatura;
import es.acuesta.academy.service.AsignaturaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping({ "/api" })
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @PostMapping("/asignatura")
    public Asignatura create(Asignatura asignatura) {
        return asignaturaService.create(asignatura);
    }

    @GetMapping("/asignaturas")
    public List<Asignatura> findAll() {
        return null;
    }

    @GetMapping(path = { "/{id}" })
    public Asignatura find() {
        return null;
    }

    @PutMapping
    public Asignatura update(Asignatura asignatura) {
        return asignaturaService.create(asignatura);
    }

    @DeleteMapping(path = { "/{id}" })
    public void delete(Asignatura asignatura) {
        asignaturaService.delete(asignatura);
    }

}
