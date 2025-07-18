/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.genesisandy.proyecto.servicio;

import com.genesisandy.proyecto.modelo.Tarea;
import java.util.List;

public interface ITareaServicio {
    void agregarTarea(Tarea tarea);
    void completarTarea(int index);
    List<Tarea> obtenerTodasLasTareas();
    int contarTareasPendientes();
}

