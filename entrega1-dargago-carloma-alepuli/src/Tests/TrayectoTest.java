package Tests;
import static org.junit.Assert.*;
import org.junit.Test;
import Clases.Muelle;
import Clases.Puerto;
import Clases.Trayecto;
import es.uva.inf.poo.maps.GPSCoordinate;
/** 
 * @author Dargago, Carloma, AlePuli
 */
public class TrayectoTest {
	private double errorAdmisible = 0.1; 
	private static GPSCoordinate coor = new GPSCoordinate(0.0, 0.0);
	private Puerto p = new Puerto("ES","VAL");
	private Puerto pDestino = new Puerto("ES","VAL");
	private Muelle2m = new Muelle(1,1,10,coor);
	private Muelle2mDestino = new Muelle(0,1,10,coor);
	
	@Test
	public void testInicializacionFechasConCeros() {
		Trayecto t = new Trayecto(m,p,m,p,"023/006/02008","0003/010/002018");
		assertEquals("23/6/2008",t.getFechaInicio());
		assertEquals("3/10/2018",t.getFechaFin());
	}
	@Test
	public void testInicializacionFechasMuyLejanas() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/6/20","23/6/2028");
	}
	@Test
	public void testInicializacionFechasIguales() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"31/1/2028","31/1/2028");
	}
	@Test
	public void testInicializacionFechaInicioEnero() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"31/1/2008","1/1/2030");
	}
	@Test
	public void testInicializacionFechaFinEnero() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/1/2008","31/1/2030");
	}
	@Test
	public void testInicializacionFechaInicioFebreroAñoNoBisiesto() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"28/1/2019","31/1/2030");
	}
	@Test
	public void testInicializacionFechaFinFebreroAñoNoBisiesto() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"28/12/2001","28/1/2019");
	}
	@Test
	public void testInicializacionFechaInicioFebreroAñoBisiesto() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"29/1/2020","31/1/2030");
	}
	@Test
	public void testInicializacionFechaFinFebreroAñoBisiesto() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"28/5/2001","29/1/2020");
	}
	@Test
	public void testInicializacionFechaInicioMarzo() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"31/3/2008","1/1/2030");
	}
	@Test
	public void testInicializacionFechaFinMarzo() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/1/2008","31/3/2030");
	}
	@Test
	public void testInicializacionFechaInicioAbril() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"30/4/2008","1/1/2030");
	}
	@Test
	public void testInicializacionFechaFinAbril() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/1/2008","30/4/2030");
	}
	@Test
	public void testInicializacionFechaInicioMayo() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"31/5/2008","1/1/2030");
	}
	@Test
	public void testInicializacionFechaFinMayo() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/1/2008","31/5/2030");
	}
	@Test
	public void testInicializacionFechaInicioJunio() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"30/6/2008","1/1/2030");
	}
	@Test
	public void testInicializacionFechaFinJunio() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/1/2008","30/6/2030");
	}
	@Test
	public void testInicializacionFechaInicioJulio() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"31/7/2008","1/1/2030");
	}
	@Test
	public void testInicializacionFechaFinJulio() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/1/2008","31/7/2030");
	}
	@Test
	public void testInicializacionFechaInicioAgosto() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"31/8/2008","1/1/2030");
	}
	@Test
	public void testInicializacionFechaFinAgosto() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/1/2008","31/8/2030");
	}
	@Test
	public void testInicializacionFechaInicioSeptiembre() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"30/9/2008","1/1/2030");
	}
	@Test
	public void testInicializacionFechaFinSeptiembre() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/1/2008","30/9/2030");
	}
	@Test
	public void testInicializacionFechaInicioOctubre() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"31/10/2008","1/1/2030");
	}
	@Test
	public void testInicializacionFechaFinOctubre() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/1/2008","31/10/2030");
	}
	@Test
	public void testInicializacionFechaInicioNoviembre() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"30/11/2008","1/1/2030");
	}
	@Test
	public void testInicializacionFechaFinNoviembre() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/1/2008","30/11/2030");
	}
	@Test
	public void testInicializacionFechaInicioDiciembre() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"31/12/2008","1/1/2030");
	}
	@Test
	public void testInicializacionFechaFinDiciembre() {
		@SuppressWarnings("unused")
		Trayecto t = new Trayecto(m,p,m,p,"23/1/2008","31/12/2030");
	}
	@Test
	public void testGetPrecio() {
		Trayecto t = new Trayecto(m,p,mDestino,pDestino,"31/3/2008","1/1/2030");
		assertEquals(0,t.getPrecio(),errorAdmisible);
	}

	@Test
	public void testGetInfoTrayecto() {
		Trayecto t = new Trayecto(m,p,mDestino,pDestino,"31/3/2008","1/1/2030");
		assertEquals("null null 31/3/2008 null null 1/1/2030",t.getInfoTrayecto());
	}

	@Test
	public void testFechFinSuperior() {
		Trayecto t = new Trayecto(m,p,mDestino,pDestino,"31/3/2008","1/1/2030");
		assertEquals(true,t.fechaFinSuperior("31/1/2029"));
		assertEquals(false,t.fechaFinSuperior("2/1/2030"));
	}

	@Test
	public void testGetMuelleOrigen() {
		Trayecto t = new Trayecto(m,p,mDestino,pDestino,"31/3/2008","1/1/2030");
		assertEquals(m,t.getMuelleOrigen());
	}

	@Test
	public void testGetMuelleDestino() {
		Trayecto t = new Trayecto(m,p,mDestino,pDestino,"31/3/2008","1/1/2030");
		assertEquals(mDestino,t.getMuelleDestino());
	}

	@Test
	public void testGetPuerOrigen() {
		Trayecto t = new Trayecto(m,p,mDestino,pDestino,"31/3/2008","1/1/2030");
		assertEquals(p,t.getPuertoOrigen());
	}

	@Test
	public void testGetPuerDestino() {
		Trayecto t = new Trayecto(m,p,mDestino,pDestino,"31/3/2008","1/1/2030");
		assertEquals(pDestino,t.getPuertoDestino());
	}

	@Test
	public void testGetFechaInicio() {
		Trayecto t = new Trayecto(m,p,mDestino,pDestino,"31/3/2008","1/1/2030");
		assertEquals("31/3/2008",t.getFechaInicio());
	}

	@Test
	public void testGetFechaFin() {
		Trayecto t = new Trayecto(m,p,mDestino,pDestino,"31/3/2008","1/1/2030");
		assertEquals("1/1/2030",t.getFechaFin());
	}

	@Test
	public void testNumeroDias() {
		Trayecto t = new Trayecto(m,p,mDestino,pDestino,"31/3/2008","31/3/2009");
		assertEquals(365,t.getNumeroDias());
	}

	
	
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"23/12/2008","23/10/2008");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioDiaNegativo() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"-3/10/2008","1/12/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinDiaNegativo() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","-13/12/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioMesNegativo() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/-10/2008","1/12/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinMesNegativo() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","13/-11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioAñoNegativo() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/-2008","1/12/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinAñoNegativo() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","13/11/-2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaInicioAñoIncorrecto() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2.008","1/12/2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaFinAñoIncorrecto() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","13/11/20.18");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaInicioDiaIncorrecto() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3.5/10/2008","1/12/2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaFinDiaIncorrecto() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","1.3/11/2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaInicioMesIncorrecto() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/1.2/2.008","1/12/2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaFinMesIncorrecto() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","13/1.1/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioMesMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/13/2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinMesMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","13/13/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioFebreroDiaMayorAñoNoBisiesto() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"29/2/2001","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinFebreroDiaMayorAñoNoBisiesto() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"31/1/2018","29/2/2021");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioFebreroDiaMayorAñoBisiesto() {	
		@SuppressWarnings("unused")	
		Trayecto t1 = new Trayecto(m,p,m,p,"30/2/2020","28/2/2021");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinFebreroDiaMayorAñoBisiesto() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","30/2/2020");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioMarzoDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"32/3/2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinMarzoDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","32/3/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaAbrilMarzoDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"31/4/2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinAbrilDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","31/4/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioMayoDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"32/5/2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinMayoDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","32/5/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioJunioDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"31/6/2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinJunioDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","31/6/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioJulioDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"32/7/2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinMayoJulioDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","32/7/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioAgostoDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"32/8/2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinAgostoDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","32/8/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioSeptiembreDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"31/9/2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinSeptiembreDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","31/9/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioOctubreDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"32/10/2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinOctubreDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","32/10/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioNoviembreDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"31/11/2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinNoviembreDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","31/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioDiciembreDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"32/12/2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinDiciembreDiaMayor() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","32/12/2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaInicioDiaLetras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"a/10/2008","1/12/2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaFinDiaLetras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","a3/11/2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaInicioMesLetras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"2/1S/2008","1/12/2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaFinMesLetras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","1/b/2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaInicioAñoLetras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"1/10/2OO8","1/12/2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaFinAñoLetras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","2/11/202e");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaInicioTodoLetras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"a/d3/2OO8","1/12/2018");
	}
	@Test(expected=NumberFormatException.class)  
	public void testInicializacionFechaFinTodoLetras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","a1/3R/eads");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioSinBarras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"32122008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaSinBarras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","32122018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioUnaBarra() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"32/122008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaUnaBarra() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","32/122018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioGuiones() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"32-12-2008","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinGuiones() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"3/10/2008","32-12-2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioSoloBarras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"//","13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinSoloBarras() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,"13/11/2018","//");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaInicioNull() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,null,"13/11/2018");
	}
	@Test(expected=IllegalStateException.class)  
	public void testInicializacionFechaFinNull() {	
		@SuppressWarnings("unused")
		Trayecto t1 = new Trayecto(m,p,m,p,null,"32-12-2018");
	}
}