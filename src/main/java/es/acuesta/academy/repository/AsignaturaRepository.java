package es.acuesta.academy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.acuesta.academy.model.Asignatura;

@Repository
public interface AsignaturaRepository extends CrudRepository<Asignatura, Long> {

}
