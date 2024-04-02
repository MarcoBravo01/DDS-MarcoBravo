package domain.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
  private String nombre;
  private List<Materia> correlativas;

  public List<Materia> getCorrelativas(){
    return this.correlativas;
  }
  public Materia(String n){
    nombre = n;
    correlativas = new ArrayList<>();
  }
  void setCorrelativas(Materia ... materias){
    Collections.addAll(this.correlativas, materias);
  }
  String getNombre(){
    return this.nombre;
  }
}
