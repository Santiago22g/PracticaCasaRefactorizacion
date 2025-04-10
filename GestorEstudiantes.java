package refactorizacion_practica;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorEstudiantes {

    // Logger para registrar eventos
    private static final Logger logger = Logger.getLogger(GestorEstudiantes.class.getName());

    // Lista para almacenar los nombres de los estudiantes
    private List<String> estudiantes = new ArrayList<>();

    // Mapa para almacenar las calificaciones de los estudiantes
    private Map<String, Integer> calificaciones = new HashMap<>();

    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();

        gestor.agregarEstudiante("Juan", 80);
        gestor.agregarEstudiante("Ana", 95);
        gestor.agregarEstudiante("Luis", 72);
        gestor.agregarEstudiante(null, 90); // Caso con entrada incorrecta

        gestor.calcularPromedio();
        gestor.mostrarEstudiantes();
        gestor.buscarEstudiante("Ana");
    }

    public void agregarEstudiante(String nombre, int calificacion) {
        if (nombre != null && !nombre.isEmpty() && calificacion >= 0 && calificacion <= 100) {
            estudiantes.add(nombre);
            calificaciones.put(nombre, calificacion);
            logger.log(Level.INFO, "Estudiante agregado: {0} con calificación {1}", new Object[]{nombre, calificacion});
        } else {
            logger.warning("Datos de estudiante inválidos.");
        }
    }

    public void calcularPromedio() {
        int suma = 0;
        for (String estudiante : estudiantes) {
            suma += calificaciones.get(estudiante);
        }
        int promedio = estudiantes.isEmpty() ? 0 : suma / estudiantes.size();
        logger.log(Level.INFO, "Promedio de calificaciones: {0}", promedio);
    }

    public void mostrarEstudiantes() {
        for (String estudiante : estudiantes) {
            logger.log(Level.INFO, "Estudiante: {0}, Calificación: {1}", new Object[]{estudiante, calificaciones.get(estudiante)});
        }
    }

    public void buscarEstudiante(String nombre) {
        if (estudiantes.contains(nombre)) {
            logger.log(Level.INFO, "Estudiante encontrado: {0}, Calificación: {1}", new Object[]{nombre, calificaciones.get(nombre)});
        } else {
        	logger.log(Level.WARNING,"Estudiante no encontrado: {0}",nombre);
        }
    }
}
