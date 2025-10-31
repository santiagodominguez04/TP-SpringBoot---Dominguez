
package com.utn.tareas.repository;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class TareaRepository {
    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(0); // Para generar IDs únicos

    public TareaRepository() {
        // Inicializamos con tareas de ejemplo
        guardar(new Tarea(null, "Estudiar Spring Boot", false, Prioridad.ALTA));
        guardar(new Tarea(null, "Hacer el Trabajo Práctico", false, Prioridad.ALTA));
        guardar(new Tarea(null, "Limpiar el escritorio", false, Prioridad.MEDIA));
        guardar(new Tarea(null, "Pasear al perro", true, Prioridad.BAJA));
    }

    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(tareas);
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream()
                .filter(tarea -> tarea.getId().equals(id))
                .findFirst();
    }

    public Tarea guardar(Tarea tarea) {
        if (tarea.getId() == null) {
            tarea.setId(contador.incrementAndGet()); // Asigna un nuevo ID
        }
        // Elimina la tarea antigua si ya existe para simular una actualización
        tareas.removeIf(t -> t.getId().equals(tarea.getId()));
        tareas.add(tarea);
        return tarea;
    }

    public void eliminarPorId(Long id) {
        tareas.removeIf(tarea -> tarea.getId().equals(id));
    }
}
