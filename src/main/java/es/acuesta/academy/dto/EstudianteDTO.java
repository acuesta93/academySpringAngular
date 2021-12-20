package es.acuesta.academy.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import es.acuesta.academy.model.Asignatura;

public class EstudianteDTO {
	
	private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDateTime fechNacimiento;
    private int edad;
    private int curso;
    private AsignaturaDTO asignaturaDto;
    
	public EstudianteDTO() {
		super();
	}

	public EstudianteDTO(String nombre, String apellido, String direccion, String telefono, String email,
			LocalDateTime fechNacimiento, int edad, int curso, AsignaturaDTO asignaturaDto) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.fechNacimiento = fechNacimiento;
		this.edad = edad;
		this.curso = curso;
		this.asignaturaDto = asignaturaDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getFechNacimiento() {
		return fechNacimiento;
	}

	public void setFechNacimiento(LocalDateTime fechNacimiento) {
		this.fechNacimiento = fechNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public AsignaturaDTO getAsignaturaDto() {
		return asignaturaDto;
	}

	public void setAsignaturaDto(AsignaturaDTO asignaturaDto) {
		this.asignaturaDto = asignaturaDto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstudianteDTO other = (EstudianteDTO) obj;
		return id == other.id;
	}
    
	
    

}
