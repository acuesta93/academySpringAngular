package es.acuesta.academy.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String descripcion;
    private long horasSemana;
    private long precioHora;
    private LocalDateTime fechaIngreso;

    
    public Asignatura() {
		super();
	}

	public Asignatura(String nombre, String descripcion, long horasSemana, long precioHora, LocalDateTime fechaIngreso) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horasSemana = horasSemana;
        this.precioHora = precioHora;
        this.fechaIngreso = fechaIngreso;
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

    public String getDescripcion() {
        return descripcion;
    }

    public long getHorasSemana() {
        return horasSemana;
    }

    public long getPrecioHora() {
        return precioHora;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }
    
    

    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setHorasSemana(long horasSemana) {
		this.horasSemana = horasSemana;
	}

	public void setPrecioHora(long precioHora) {
		this.precioHora = precioHora;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
        Asignatura other = (Asignatura) obj;
        return id == other.id;
    }

}
