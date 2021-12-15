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
    private long id;

    final private String nombre;
    final private String descripcion;
    final private long horasSemana;
    final private long precioHora;
    final private LocalDateTime fechaIngreso;

    public Asignatura(String nombre, String descripcion, long horasSemana, long precioHora, LocalDateTime fechaIngreso) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horasSemana = horasSemana;
        this.precioHora = precioHora;
        this.fechaIngreso = fechaIngreso;
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
