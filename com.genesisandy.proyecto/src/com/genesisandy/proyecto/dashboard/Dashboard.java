/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    package com.genesisandy.proyecto.dashboard;

import com.genesisandy.proyecto.modelo.Tarea;
import com.genesisandy.proyecto.servicio.ITareaServicio;
import com.genesisandy.proyecto.servicio.TareaServicioImpl;
import java.util.List;
import java.util.Scanner;

public class Dashboard {
    public static void main(String[] args) {
        ITareaServicio servicio = new TareaServicioImpl();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== GESTOR DE TAREAS POO ===");
        System.out.println("Tareas precargadas:");
        mostrarTareas(servicio.obtenerTodasLasTareas());

        while (true) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Completar tarea");
            System.out.println("3. Mostrar todas las tareas");
            System.out.println("4. Mostrar tareas pendientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    agregarTarea(servicio, scanner);
                    break;
                case 2:
                    completarTarea(servicio, scanner);
                    break;
                case 3:
                    mostrarTareas(servicio.obtenerTodasLasTareas());
                    break;
                case 4:
                    mostrarTareasPendientes(servicio);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void agregarTarea(ITareaServicio servicio, Scanner scanner) {
        System.out.print("\nNombre de la tarea: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        servicio.agregarTarea(new Tarea(nombre, descripcion));
        System.out.println("¡Tarea agregada con éxito!");
    }

    private static void completarTarea(ITareaServicio servicio, Scanner scanner) {
        List<Tarea> tareas = servicio.obtenerTodasLasTareas();
        System.out.println("\n=== TAREAS ===");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println(i + ". " + tareas.get(i));
        }
        
        System.out.print("\nÍndice de tarea a completar: ");
        int index = scanner.nextInt();
        servicio.completarTarea(index);
        System.out.println("Tarea marcada como completada");
    }

    private static void mostrarTareas(List<Tarea> tareas) {
        System.out.println("\n=== LISTA COMPLETA ===");
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println(i + ". " + tareas.get(i));
            }
        }
    }

    private static void mostrarTareasPendientes(ITareaServicio servicio) {
        System.out.println("\n=== TAREAS PENDIENTES ===");
        System.out.println("Total: " + servicio.contarTareasPendientes());
        for (Tarea t : servicio.obtenerTodasLasTareas()) {
            if (!t.isCompletada()) {
                System.out.println("- " + t);
            }
        }
    }
}
