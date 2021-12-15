package es.acuesta.academy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.acuesta.academy.model.Estudiante;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {

}
