/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.genesisandy.proyecto.servicio;

import com.genesisandy.proyecto.modelo.Tarea;
import java.util.ArrayList;
import java.util.List;

public class TareaServicioImpl implements ITareaServicio {
    private List<Tarea> tareas = new ArrayList<>();

    public TareaServicioImpl() {
        // Tareas de ejemplo pre-cargadas
        agregarTarea(new Tarea("Estudiar POO", "Repasar herencia y polimorfismo"));
        agregarTarea(new Tarea("Hacer ejercicio", "30 minutos de cardio"));
        agregarTarea(new Tarea("Leer libro", "Cien años de soledad - Capítulo 3"));
        agregarTarea(new Tarea("Comprar víveres", "Pan, leche, huevos y frutas"));
    }

    @Override
    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    @Override
    public void completarTarea(int index) {
        if (index >= 0 && index < tareas.size()) {
            tareas.get(index).setCompletada(true);
        }
    }

    @Override
    public List<Tarea> obtenerTodasLasTareas() {
        return new ArrayList<>(tareas);
    }

    @Override
    public int contarTareasPendientes() {
        int pendientes = 0;
        for (Tarea t : tareas) {
            if (!t.isCompletada()) {
                pendientes++;
            }
        }
        return pendientes;
    }
}


