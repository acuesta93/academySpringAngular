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
    private long id;

    final private String nombre;
    final private String apellido;
    final private String direccion;
    final private String telefono;
    final private String email;
    final private LocalDateTime fechNacimiento;
    final private int edad;
    final private int curso;

    @ManyToOne
    final private Asignatura asignaturas;

    public Estudiante(String nombre, String apellido, String direccion, String telefono, String email, LocalDateTime fechNacimiento, int edad, int curso, Asignatura asignaturas) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
