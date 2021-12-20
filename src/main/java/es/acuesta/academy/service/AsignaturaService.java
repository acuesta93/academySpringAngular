package es.acuesta.academy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acuesta.academy.dto.AsignaturaDTO;
import es.acuesta.academy.exception.CreateAsignaturaException;
import es.acuesta.academy.helper.AsignaturaHelper;
import es.acuesta.academy.model.Asignatura;
import es.acuesta.academy.repository.AsignaturaRepository;

@Service
public class AsignaturaService {

	private static final Logger logger = Logger.getLogger(AsignaturaService.class.getName());

	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@Autowired
	private AsignaturaHelper asignaturaHelper;

	public Long create(AsignaturaDTO asignaturaDto) {
		Asignatura asignatura = asignaturaHelper.dtoToEntity(asignaturaDto);
		if (asignaturaDto.getId() != null) {
			logger.info("No se ha podido crear el registro.");
			throw new CreateAsignaturaException("El registro introducido ya existe.");
		}
		logger.info("Se ha podido dar de alta el registro.");
		return asignaturaRepository.save(asignatura).getId();

	}

	public AsignaturaDTO findById(Long id) {

		if (id < 0) {
			throw new CreateAsignaturaException("El id introducido no es válido.");
		}

		Optional<Asignatura> optional = asignaturaRepository.findById(id);
		if (optional.isPresent()) {
			logger.info("Encontrada asignatura.");
			Asignatura modelo = optional.get();
			AsignaturaDTO dto = asignaturaHelper.entityToDTO(modelo);
			return dto;
		} else {
			logger.info("No se ha encontrado la asignatura");
			throw new CreateAsignaturaException("El registro con el id introducido no existe.");
		}

	}

	public List<AsignaturaDTO> findAll() {
		List<Asignatura> asignaturas = new ArrayList<>();
		asignaturaRepository.findAll().forEach(asignaturas::add);

		List<AsignaturaDTO> listaDTO = new ArrayList<>();
		asignaturas.forEach(p -> listaDTO.add(asignaturaHelper.entityToDTO(p)));
		logger.info("Lista de asignaturas.");
		return listaDTO;

	}

	public AsignaturaDTO update(AsignaturaDTO asignaturaDTO) {
		
		if (asignaturaDTO.getId() == null) {
			logger.info("No se ha conseguido la asignatura - Fallo de id");
			throw new CreateAsignaturaException("El registro introducido no existe.");
		}
		if (asignaturaDTO.getId() <= 0) {
			throw new CreateAsignaturaException("El id introducido no es válido.");
		}
		
		Asignatura asignatura = asignaturaHelper.dtoToEntity(asignaturaDTO);
		Optional<Asignatura> optional = asignaturaRepository.findById(asignaturaDTO.getId());
		if (optional.isEmpty()) {
			logger.info("Asignatura no válida.");
			throw new CreateAsignaturaException("El registro introducido no existe.");
		}

		asignatura = asignaturaRepository.save(asignatura);

		logger.info("Asignatura actualizada.");
		return asignaturaHelper.entityToDTO(asignatura);
	}

	public void deleteById(Long id) {
		if (id <= 0) {
			logger.info("Asignatura no válida.");
			throw new CreateAsignaturaException("El id introducido no es válido.");
		}

		Optional<Asignatura> optional = asignaturaRepository.findById(id);
		if (optional.isPresent()) {
			logger.info("Asignatura eliminada.");
			asignaturaRepository.deleteById(id);
		} else {
			logger.info("Id introducido no es válido.");
			throw new CreateAsignaturaException("El registro con el id introducido no existe.");
		}
	}

}
