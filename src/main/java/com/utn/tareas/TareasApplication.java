// src/main/java/com/utn/tareas/TareasApplication.java
package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {

    private final TareaService tareaService;
    private final MensajeService mensajeService;

    public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
        this.tareaService = tareaService;
        this.mensajeService = mensajeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TareasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. Mostrar bienvenida
        mensajeService.mostrarBienvenida();

        // 2. Mostrar configuración
        tareaService.imprimirConfiguracion();

        // 3. Listar tareas iniciales
        System.out.println("\n>> Listando tareas iniciales:");
        tareaService.listarTodas().forEach(System.out::println);

        // 4. Agregar una nueva tarea
        System.out.println("\n>> Agregando nueva tarea...");
        tareaService.agregarTarea("Comprar leche", Prioridad.BAJA);

        // 5. Listar tareas pendientes
        System.out.println("\n>> Listando tareas PENDIENTES:");
        tareaService.listarPendientes().forEach(System.out::println);

        // 6. Marcar una tarea como completada
        System.out.println("\n>> Marcando tarea con ID 1 como completada...");
        tareaService.marcarComoCompletada(1L);

        // 7. Mostrar estadísticas
        System.out.println("\n>> Mostrando estadísticas:");
        System.out.println(tareaService.obtenerEstadisticas());

        // 8. Listar tareas completadas
        System.out.println("\n>> Listando tareas COMPLETADAS:");
        tareaService.listarCompletadas().forEach(System.out::println);

        // 9. Mostrar despedida
        System.out.println();
        mensajeService.mostrarDespedida();
    }
}