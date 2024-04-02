package domain.entities;
import javax.naming.InsufficientResourcesException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class InscripcionTest {

  private Alumno pepe;
  private Materia ayed;
  private Materia pdp;
  private Materia dds;
  private Materia am1;
  private Materia am2;

  @BeforeEach
  public void init(){
    pepe = new Alumno("Pepe");

    pdp = new Materia("PdP");
    ayed = new Materia("AyED");
    dds = new Materia("DDS");
    am2 = new Materia("AM2");
    am1 = new Materia("AM1");

    pdp.setCorrelativas(ayed);
    am2.setCorrelativas(am1);
    dds.setCorrelativas(ayed, pdp);

  }
@Test
@DisplayName("Pepe puede cursar Análisis Matemático 2")
  public void pepePuedeCursarAM2(){
    pepe.setMateriasAprobadas(am1);
    Assertions.assertTrue(pepe.puedeCursar(am2));
  }

@Test
@DisplayName("La inscripción de Pepe es aceptada")
  public void laInscripcionDePepeSeAcepta(){
  pepe.setMateriasAprobadas(ayed, pdp, am1);
  Inscripcion inscripcion = new Inscripcion(pepe);
  inscripcion.setAsignaturas(dds, am2);

  Assertions.assertTrue(inscripcion.aprobada());

}
@Test
@DisplayName("Pepe no puede cursar Pdp. Necesita aprobar AyED antes")
  public void pepeNoPuedeCursarPdPSinAprobarAyED(){
    pepe.setMateriasAprobadas(am1, am2);
    Assertions.assertFalse(pepe.puedeCursar(pdp));
}
@Test
@DisplayName("La inscripcion se rechaza. Falta aprobar am1")
  public void laInscripcionDePepeSeRechaza(){
    pepe.setMateriasAprobadas(ayed, pdp);

    Inscripcion inscripcion = new Inscripcion(pepe);
    inscripcion.setAsignaturas(am2, dds);

    Assertions.assertFalse(inscripcion.aprobada());
}
}
