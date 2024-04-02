package domain.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
  private Alumno alumno;
  private List<Materia> asignaturas;
  public boolean aprobada(){
    // todos los elementos de la lista asignaturas pueden ser cursadas por el alumno.
    return asignaturas.stream().allMatch(m-> alumno.puedeCursar(m));
  }
  void setAsignaturas(Materia ... asignaturas){
    Collections.addAll(this.asignaturas, asignaturas);
  }
  public Inscripcion(Alumno a){
    this.alumno = a;
    asignaturas = new ArrayList<>();
  }

}
