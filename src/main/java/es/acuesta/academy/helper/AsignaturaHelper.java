package es.acuesta.academy.helper;

import org.springframework.stereotype.Component;

import es.acuesta.academy.dto.AsignaturaDTO;
import es.acuesta.academy.model.Asignatura;

@Component
public class AsignaturaHelper {
	
	public AsignaturaDTO entityToDTO(Asignatura asignatura) {
		AsignaturaDTO dto = new AsignaturaDTO();
		dto.setId(asignatura.getId());
		dto.setNombre(asignatura.getNombre());
		dto.setDescripcion(asignatura.getDescripcion());
		dto.setFechaIngreso(asignatura.getFechaIngreso());
		dto.setHorasSemana(asignatura.getHorasSemana());
		dto.setPrecioHora(asignatura.getPrecioHora());
		return dto;
	}
	
	public Asignatura dtoToEntity (AsignaturaDTO asignaturaDto) {
		Asignatura asignatura = new Asignatura();
		asignatura.setId(asignaturaDto.getId());
		asignatura.setNombre(asignaturaDto.getNombre());
		asignatura.setDescripcion(asignaturaDto.getDescripcion());
		asignatura.setFechaIngreso(asignaturaDto.getFechaIngreso());
		asignatura.setHorasSemana(asignaturaDto.getHorasSemana());
		asignatura.setPrecioHora(asignaturaDto.getPrecioHora());
		return asignatura;
	}

}
