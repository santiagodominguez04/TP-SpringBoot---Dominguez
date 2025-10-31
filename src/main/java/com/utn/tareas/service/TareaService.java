package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value; // Importante: importar @Value
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;


    // 1. Inyección de las propiedades desde application.properties
    @Value("${app.nombre}")
    private String appNombre;

    @Value("${app.max-tareas}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas}")
    private boolean mostrarEstadisticas;




    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea agregarTarea(String descripcion, Prioridad prioridad) {

        if (tareaRepository.obtenerTodas().size() >= maxTareas) {

            throw new RuntimeException("Límite máximo de tareas (" + maxTareas + ") alcanzado. No se pueden agregar más.");
        }
        Tarea nuevaTarea = new Tarea(null, descripcion, false, prioridad);
        return tareaRepository.guardar(nuevaTarea);
    }

    public List<Tarea> listarTodas() {
        return tareaRepository.obtenerTodas();
    }

    public List<Tarea> listarPendientes() {
        return tareaRepository.obtenerTodas().stream()
                .filter(tarea -> !tarea.isCompletada())
                .collect(Collectors.toList());
    }

    public List<Tarea> listarCompletadas() {
        return tareaRepository.obtenerTodas().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    public Tarea marcarComoCompletada(Long id) {
        return tareaRepository.buscarPorId(id)
                .map(tarea -> {
                    tarea.setCompletada(true);
                    return tareaRepository.guardar(tarea);
                })
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));
    }

    public String obtenerEstadisticas() {

        if (!mostrarEstadisticas) {
            return "Las estadísticas están desactivadas en la configuración.";
        }

        long total = tareaRepository.obtenerTodas().size();
        long completadas = listarCompletadas().size();
        long pendientes = total - completadas;
        return String.format("Estadísticas: Total: %d, Completadas: %d, Pendientes: %d",
                total, completadas, pendientes);
    }

    public void imprimirConfiguracion() {
        System.out.println("--- Configuración de la Aplicación ---");
        System.out.println("Nombre: " + appNombre);
        System.out.println("Límite de Tareas: " + maxTareas);
        System.out.println("Mostrar Estadísticas: " + mostrarEstadisticas);
        System.out.println("------------------------------------");
    }
}
