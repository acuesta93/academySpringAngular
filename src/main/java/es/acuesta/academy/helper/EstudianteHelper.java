package es.acuesta.academy.helper;

import org.springframework.beans.factory.annotation.Autowired;

import es.acuesta.academy.dto.EstudianteDTO;
import es.acuesta.academy.model.Estudiante;

public class EstudianteHelper {
	
	@Autowired
	private AsignaturaHelper asignaturaHelper;

	public EstudianteDTO entityToDTO(Estudiante estudiante) {
		EstudianteDTO dto = new EstudianteDTO();
		dto.setId(estudiante.getId());
		dto.setNombre(estudiante.getNombre());
		dto.setApellido(estudiante.getApellido());
		dto.setDireccion(estudiante.getDireccion());
		dto.setTelefono(estudiante.getTelefono());
		dto.setFechNacimiento(estudiante.getFechNacimiento());
		dto.setEdad(estudiante.getEdad());
		dto.setCurso(estudiante.getCurso());
		if (estudiante.getAsignaturas() != null) {
			dto.setAsignaturaDto((asignaturaHelper.entityToDTO(estudiante.getAsignaturas())));
			
		}
		dto.setEmail(estudiante.getEmail());
		return dto;
	}

	public Estudiante dtoToEntity(EstudianteDTO dto) {
		Estudiante estudiante = new Estudiante();
		estudiante.setId(dto.getId());
		estudiante.setNombre(dto.getNombre());
		estudiante.setApellido(dto.getApellido());
		estudiante.setDireccion(dto.getDireccion());
		estudiante.setTelefono(dto.getTelefono());
		estudiante.setFechNacimiento(dto.getFechNacimiento());
		estudiante.setEdad(dto.getEdad());
		estudiante.setCurso(dto.getCurso());
		estudiante.setEmail(dto.getEmail());
		return estudiante;
	}

}
