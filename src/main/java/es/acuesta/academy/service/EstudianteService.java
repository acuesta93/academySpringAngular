package es.acuesta.academy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acuesta.academy.model.Estudiante;
import es.acuesta.academy.repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante create(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> findAll() {
        return null;
    }

    public Estudiante find(Estudiante estudiante) {
        return estudianteRepository.findById(estudiante.getId());
    }

    public Estudiante update(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public void delete(Estudiante estudiante) {
        estudianteRepository.deleteById(estudiante.getId());
    }
}
