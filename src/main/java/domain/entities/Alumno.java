package domain.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
  private String nombre;
  private List<Materia> materiasAprobadas;
  public boolean puedeCursar(Materia materia){
    // todas las correlativas de una materia existen en la lista materiasAprobadas
    return materiasAprobadas.containsAll(materia.getCorrelativas());
  }
  public Alumno(String n){
    nombre = n;
    materiasAprobadas = new ArrayList<>();
  }
  void setMateriasAprobadas(Materia ... materias){
    Collections.addAll(this.materiasAprobadas, materias);
  }
  String getNombre(){
    return this.nombre;
  }

}
