package Tests;
import static org.junit.Assert.*;
import org.junit.Test;
import Clases.Muelle2;
import Clases.Contenedor;
import es.uva.inf.poo.maps.GPSCoordinate;
/** 
 * @author Dargago, Carloma, AlePuli
 */
public class MuelleTest {

	@Test
	public void numeroVacias() {
		GPSCoordinate coor = new GPSCoordinate(0.0, 0.0);
		Contenedor a = new Contenedor("CSQU305438", "04356.89Kg", "0903.336Kg", "00300.8M3", 1, 1);
		Contenedor b = new Contenedor("CSQU305439", "04356.89Kg", "0903.336Kg", "00300.8M3", 1, 0);
		Contenedor c = new Contenedor("CSQU305430", "04350.89Kg", "0903.336Kg", "00300.8M3", 1, 0);
		Contenedor d = new Contenedor("CSQU305431", "04350.89Kg", "0903.336Kg", "00300.8M3", 1, 1);
		Contenedor e = new Contenedor("CSQU305432", "04350.89Kg", "0903.336Kg", "00300.8M3", 1, 0);
		Contenedor f = new Contenedor("CSQU305433", "04350.89Kg", "0903.336Kg", "00300.8M3", 1, 1);
		Muelle2 prueba = new Muelle2(01,1,10,coor,false,false);
		prueba.insertarContenedor(a);
		prueba.insertarContenedor(b);
		prueba.insertarContenedor(c);
		prueba.desapilarContenedor(a);
		prueba.insertarContenedor(d);
		prueba.desapilarContenedor(b);
		prueba.insertarContenedor(e);
		prueba.insertarContenedor(f);
		assertEquals(prueba.nivelContenedor(a),1);
		assertEquals(prueba.nivelContenedor(b),2);
		assertEquals(prueba.nivelContenedor(c),1);
		assertEquals(prueba.nivelContenedor(d),1);
		assertEquals(prueba.nivelContenedor(e),2);
		assertEquals(prueba.nivelContenedor(f),1);
	}
}