package es.acuesta.academy.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String email;
	private LocalDateTime fechNacimiento;
	private int edad;
	private int curso;

	@ManyToOne
	private Asignatura asignaturas;

	public Estudiante() {
		super();
	}

	public Estudiante(String nombre, String apellido, String direccion, String telefono, String email,
			LocalDateTime fechNacimiento, int edad, int curso, Asignatura asignaturas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.fechNacimiento = fechNacimiento;
		this.edad = edad;
		this.curso = curso;
		this.asignaturas = asignaturas;
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

	public String getApellido() {
		return apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getFechNacimiento() {
		return fechNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public int getCurso() {
		return curso;
	}

	public Asignatura getAsignaturas() {
		return asignaturas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFechNacimiento(LocalDateTime fechNacimiento) {
		this.fechNacimiento = fechNacimiento;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public void setAsignaturas(Asignatura asignaturas) {
		this.asignaturas = asignaturas;
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
		Estudiante other = (Estudiante) obj;
		return id == other.id;
	}

}
