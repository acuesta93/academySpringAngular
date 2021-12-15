package es.acuesta.academy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acuesta.academy.model.Asignatura;
import es.acuesta.academy.repository.AsignaturaRepository;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public Asignatura create(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public Asignatura find(Asignatura asignatura) {
        return asignaturaRepository.findById(asignatura.getId());

    }

    public List<Asignatura> findAll() {
        return null;

    }

    public Asignatura update(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public void delete(Asignatura asignatura) {
        asignaturaRepository.deleteById(asignatura.getId());
    }

}
