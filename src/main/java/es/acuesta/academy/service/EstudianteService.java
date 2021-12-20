package es.acuesta.academy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acuesta.academy.dto.EstudianteDTO;
import es.acuesta.academy.exception.CreateEstudianteException;
import es.acuesta.academy.helper.EstudianteHelper;
import es.acuesta.academy.model.Asignatura;
import es.acuesta.academy.model.Estudiante;
import es.acuesta.academy.repository.AsignaturaRepository;
import es.acuesta.academy.repository.EstudianteRepository;

@Service
public class EstudianteService {
	
	private static final Logger logger = Logger.getLogger(EstudianteService.class.getName());

    @Autowired
    private EstudianteRepository estudianteRepository;
    
    @Autowired
    private EstudianteHelper estudianteHelper;
    
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public Long create(EstudianteDTO estudianteDto) {
		if (estudianteDto.getId() != 0) {
			logger.info("No se puede dar de alta al estudiante, ya existe.");
			throw new CreateEstudianteException("El registro introducido ya existe.");
		}
		Estudiante estudiante = estudianteHelper.dtoToEntity(estudianteDto);
		Optional<Estudiante>  optional = estudianteRepository.findById(estudianteDto.getAsignaturaDto().getId());
		if (optional.isPresent()) {
			estudiante.setAsignaturas(optional.get().getAsignaturas());
		} else {
			throw new CreateEstudianteException("La asignatura no existe.");
		}
		logger.info("Estudiante dado de alta.");
		return estudianteRepository.save(estudiante).getId();
	}
    
    public EstudianteDTO findById(Long id) {
		if (id <= 0) {
			logger.info("Id no valido.");
			throw new CreateEstudianteException("El id introducido no es válido.");
		}
		Optional<Estudiante> optional = estudianteRepository.findById(id);
		if (optional.isPresent()) {
			Estudiante modelo = optional.get();
			EstudianteDTO dto = estudianteHelper.entityToDTO(modelo);
			logger.info("Id encontrado, mostrando...");
			return dto;
		} else {
			logger.info("Id de astro no existe");
			throw new CreateEstudianteException("El registro con el id introducido no existe.");
		}
	}
    
    public List<EstudianteDTO> findAll() {
		List<Estudiante> estudiantes = new ArrayList<>();
		estudianteRepository.findAll().forEach(estudiantes::add);

		List<EstudianteDTO> listaDto = new ArrayList<>();
		estudiantes.forEach(p -> listaDto.add(estudianteHelper.entityToDTO(p)));
		logger.info("Mostrando lista de estudiantes...");
		return listaDto;
	}
    
    public EstudianteDTO update(EstudianteDTO estudianteDTO) {
		if (estudianteDTO.getId() <= 0) {
			logger.info("Id no valido.");
			throw new CreateEstudianteException("El id introducido no es válido.");
		}
		Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(estudianteDTO.getId());
		if (optionalEstudiante.isEmpty()) {
			logger.info("El estudiante que esta buscando no existe.");
			throw new CreateEstudianteException("El registro introducido no existe.");
		}

		Estudiante estudiante = estudianteHelper.dtoToEntity(estudianteDTO);
		Optional<Asignatura>  optional = asignaturaRepository.findById(estudianteDTO.getAsignaturaDto().getId());
		if (optional.isPresent()) {
			logger.info("Estudiante actualizado.");
			estudiante.setAsignaturas(optional.get());
		} else {
			logger.info("El astro buscado no existe");
			throw new CreateEstudianteException("El tipo astro no existe");
		}

		estudiante = estudianteRepository.save(estudiante);
		return estudianteHelper.entityToDTO(estudiante);
	}
    
    public void deleteById(Long id) {
		if (id <= 0) {
			logger.info("Id no valido.");
			throw new CreateEstudianteException("El id introducido no es válido.");
		}

		Optional<Estudiante> optional = estudianteRepository.findById(id);
		if (optional.isPresent()) {
			logger.info("Registro borrado.");
			estudianteRepository.deleteById(id);
		} else {
			logger.info("registro no valido");
			throw new CreateEstudianteException("El registro con el id introducido no existe.");
		}
	}

}
