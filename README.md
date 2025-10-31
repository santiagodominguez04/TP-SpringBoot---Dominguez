Este proyecto es una aplicacion desarrollado con Spring Boot como parte del trabajo practico de la materia Desarrollo de Software de la Universidad Tecnologica Nacional Regional Mendoza. La aplicacion permite gestionar una lista de tareas usando los conceptos del framework Spring.

Descripcion del proyecto:
La aplicacion gestiona tareas en memoria y su comportamiento dependiendo el entorno de ejecucion (dos posibles: desarrollo o produccion).
El proyecto implementa los siguientes conceptos clave:
  -Inyección de Dependencias (DI) por constructor para desacoplar los componentes.
  -Estereotipos (@Service, @Repository) para definir una arquitectura clara por capas.
  -Configuración Externa mediante archivos application.properties para gestionar parámetros de la aplicación.
  -Spring Profiles para gestionar diferentes configuraciones y comportamientos según el entorno (dev, prod).
  -Beans Condicionales (@Profile) para instanciar componentes específicos de un perfil.

Las tecnologias usadas en este proyecto son:
  -Java 21
  -Spring Boot 3
  -Maven
  -Lombok


Capturas de Consola en modo PRODUCCION
== Iniciando Gestor de Tareas (PROD) ==
--- Configuración de la Aplicación ---
Nombre: Gestor de Tareas UTN
Límite de Tareas: 1000
Mostrar Estadísticas: false
------------------------------------

>> Listando tareas iniciales:
Tarea(id=1, descripcion=Estudiar Spring Boot, completada=false, prioridad=ALTA)
Tarea(id=2, descripcion=Hacer el Trabajo Práctico, completada=false, prioridad=ALTA)
Tarea(id=3, descripcion=Limpiar el escritorio, completada=false, prioridad=MEDIA)
Tarea(id=4, descripcion=Pasear al perro, completada=true, prioridad=BAJA)

>> Agregando nueva tarea...

>> Listando tareas PENDIENTES:
Tarea(id=1, descripcion=Estudiar Spring Boot, completada=false, prioridad=ALTA)
Tarea(id=2, descripcion=Hacer el Trabajo Práctico, completada=false, prioridad=ALTA)
Tarea(id=3, descripcion=Limpiar el escritorio, completada=false, prioridad=MEDIA)
Tarea(id=5, descripcion=Comprar leche, completada=false, prioridad=BAJA)

>> Marcando tarea con ID 1 como completada...

>> Mostrando estadísticas:
Las estadísticas están desactivadas en la configuración.

>> Listando tareas COMPLETADAS:
Tarea(id=4, descripcion=Pasear al perro, completada=true, prioridad=BAJA)
Tarea(id=1, descripcion=Estudiar Spring Boot, completada=true, prioridad=ALTA)

== Cerrando aplicación. ==


Capturas de Consola en modo DESARROLLO
******************************************
** BIENVENIDO AL GESTOR DE TAREAS (DEV) **
** Entorno de Desarrollo Activo    **
******************************************
--- Configuración de la Aplicación ---
Nombre: Gestor de Tareas UTN
Límite de Tareas: 10
Mostrar Estadísticas: true
------------------------------------

>> Listando tareas iniciales:
Tarea(id=1, descripcion=Estudiar Spring Boot, completada=false, prioridad=ALTA)
Tarea(id=2, descripcion=Hacer el Trabajo Práctico, completada=false, prioridad=ALTA)
Tarea(id=3, descripcion=Limpiar el escritorio, completada=false, prioridad=MEDIA)
Tarea(id=4, descripcion=Pasear al perro, completada=true, prioridad=BAJA)

>> Agregando nueva tarea...

>> Listando tareas PENDIENTES:
Tarea(id=1, descripcion=Estudiar Spring Boot, completada=false, prioridad=ALTA)
Tarea(id=2, descripcion=Hacer el Trabajo Práctico, completada=false, prioridad=ALTA)
Tarea(id=3, descripcion=Limpiar el escritorio, completada=false, prioridad=MEDIA)
Tarea(id=5, descripcion=Comprar leche, completada=false, prioridad=BAJA)

>> Marcando tarea con ID 1 como completada...

>> Mostrando estadísticas:
Estadísticas: Total: 5, Completadas: 2, Pendientes: 3

>> Listando tareas COMPLETADAS:
Tarea(id=4, descripcion=Pasear al perro, completada=true, prioridad=BAJA)
Tarea(id=1, descripcion=Estudiar Spring Boot, completada=true, prioridad=ALTA)

>> Finalizando ejecución en modo DEV. ¡Hasta pronto!

En este proyecto podemos entender cómo Spring Boot simplifica la configuracion y el desarrollo.

Santiago Dominguez
50882
