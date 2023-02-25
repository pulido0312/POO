package Tests;
import static org.junit.Assert.*;
import org.junit.Test;
import Clases.Contenedor;
import Clases.Muelle2;
import Clases.Puerto;
import Clases.Trayecto;
import es.uva.inf.poo.maps.GPSCoordinate;

/**
 * @author Dargago, Carloma, AlePuli
 */
public class ContenedorTest {
		private double errorAdmisible = 0.1; 
		private static GPSCoordinate coor = new GPSCoordinate(0.0, 0.0);
		private Puerto p = new Puerto("ES","VAL");
		private Muelle2 m = new Muelle2(1,1,10,coor);
		//private Trayecto t1 = new Trayecto(m,p,m,p,"23/6/2008","23/6/2008");
		//private Trayecto t2 = new Trayecto(m,p,m,p,"11/11/2011","11/11/2040");
		//private Trayecto t3 = new Trayecto(m,p,m,p,"12/12/2012","13/12/2012");
		
		
										//CASOS VALIDOS
		@Test
		 public void testInicializacionCerosAlPrincipio() {
			Contenedor a = new Contenedor("CSQU305438", "04356.89Kg", "0903.336Kg", "00300.8M3", 1, 0);
			assertEquals(4356.89,a.getTaraKg(),errorAdmisible);
			assertEquals(903.336,a.getCargaMaxKg(),errorAdmisible);
			assertEquals(300.8,a.getVolumenM3(),errorAdmisible);
		 }
		@Test
		 public void testInicializacionGet() {
			Contenedor a = new Contenedor("CSQU305438", "04356.89Kg", "0903.336Kg", "00300.8M3", 1, 0);
			assertEquals("CSQ",a.getCoDueño());
			assertEquals('U',a.getEquip());
			assertEquals(305438,a.getNSerie());
			assertEquals(true,a.getEstado());
			assertEquals(false,a.getTecho());
		 }
		@Test
		 public void testInicializacionEnKgM3() {
			Contenedor a = new Contenedor("CSQU305438", "5Kg", "11.0231Lb", "45M3", 1, 0);
			assertEquals(5,a.getTaraKg(),errorAdmisible);
			assertEquals(5,a.getCargaMaxKg(),errorAdmisible);
			assertEquals(45,a.getVolumenM3(),errorAdmisible);
			assertEquals(11.0231,a.getTaraLb(),errorAdmisible);
			assertEquals(11.0231,a.getCargaMaxLb(),errorAdmisible);
			assertEquals(1589.16,a.getVolumenP3(),errorAdmisible);
		 }
		@Test
		 public void testInicializacionEnLbP3() {
			Contenedor a = new Contenedor("CSQU305438", "23Lb", "74.45Lb", "147.54P3", 1, 0);
			assertEquals(23,a.getTaraLb(),errorAdmisible);
			assertEquals(74.45,a.getCargaMaxLb(),errorAdmisible);
			assertEquals(147.54,a.getVolumenP3(),errorAdmisible);
			assertEquals(10.4326,a.getTaraKg(),errorAdmisible);
			assertEquals(33.769952,a.getCargaMaxKg(),errorAdmisible);
			assertEquals(4.17786755,a.getVolumenM3(),errorAdmisible);
		 }
		@Test
		 public void testCargaCargadaKgDisponibleKg() {
			Contenedor a = new Contenedor("CSQU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
			a.setPesoCargadoKg(234.56);
			assertEquals(234.56,a.getPesoCargadoKg(),errorAdmisible);
			assertEquals(517.116282,a.getPesoCargadoLb(),errorAdmisible);
			assertEquals(903.336-234.56,a.getCargaDisponibleKg(),errorAdmisible);
			assertEquals(1474.65,a.getCargaDisponibleLb(),errorAdmisible);
		 }
		@Test
		 public void testCargaCargadaKgDisponibleLb() {
			Contenedor a = new Contenedor("CSQU305438", "4356.89Kg", "903.336Lb", "300.8M3", 1, 0);
			a.setPesoCargadoLb(789.89);
			assertEquals(789.89,a.getPesoCargadoLb(),errorAdmisible);
			assertEquals(358.288077,a.getPesoCargadoKg(),errorAdmisible);
			assertEquals(903.336-789.89,a.getCargaDisponibleLb(),errorAdmisible);
		 }
		@Test
		 public void testInicializacionCalculoCheckDigit() {
			Contenedor a = new Contenedor("CSQU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
			assertEquals(3,a.getNControl());
		 }
		@Test
		 public void testInicializacionSinTrayecto() {
			Contenedor a = new Contenedor("CSQU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
			assertEquals(0,a.getNumTrayectos());
		 }
		@Test
		 public void testInicializacionAsignacionUnTrayecto() {
			Contenedor a = new Contenedor("CSQU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
			a.setTrayecto(t1);
			assertEquals(1,a.getNumTrayectos());
			assertEquals(0,a.precio(),errorAdmisible);
			a.borraTrayecto(t1);
			assertEquals(0,a.getNumTrayectos());
		 }
		@Test
		 public void testInicializacionAsignacionDosTrayectos() {
			Contenedor a = new Contenedor("CSQU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
			a.setTrayecto(t1);
			a.setTrayecto(t2);
			assertEquals(2,a.getNumTrayectos());
			assertEquals(0,a.precio(),errorAdmisible);
			a.borraTrayecto(t2);
			assertEquals(1,a.getNumTrayectos());
			a.setTrayecto(t2);
			a.borraTrayecto(t2);
			assertEquals(" || null null 23/6/2008 null null 23/6/2008",a.getTrayectos());
			assertEquals(1,a.getNumTrayectos());
		 }
		@Test
		 public void testInicializacionAsignacionVariosTrayectos() {
			Contenedor a = new Contenedor("CSQU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
			a.setTrayecto(t2);
			a.setTrayecto(t3);
			a.setTrayecto(t1);
			assertEquals(3,a.getNumTrayectos());
			assertEquals(0,a.precio(),errorAdmisible);
			a.borraTrayecto(t1);
			assertEquals(2,a.getNumTrayectos());
			a.borraTrayecto(t2);
			a.borraTrayecto(t3);
			assertEquals(0,a.getNumTrayectos());
			a.setTrayecto(t1);
			a.setTrayecto(t3);
			assertEquals(" || null null 23/6/2008 null null 23/6/2008 || null null 12/12/2012 null null 13/12/2012",a.getTrayectos());
			assertEquals(2,a.getNumTrayectos());
		 }
														//CASOS NO VALIDOS
		
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionInformacionNull() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor(null, "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionInformacionLongitudMenor() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU30543", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionInformacionLongitudMayorLetra() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQQU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionInformacionLongitudMayorNumero() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU7305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionCodigoDueñoLetrasMinusculasUna() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("GfDU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionCodigoDueñoLetrasMinusculasDos() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("hfDU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionCodigoDueñoLetrasMinusculasTodas() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("ghjU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionCodigoDueñoNumero() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("S4AU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionCodigoDueñoDosNumeros() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("24AU305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionCodigoDueñoTodoNumeros() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("485U305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionEquipamientoMinuscula() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("GJHu305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionEquipamientoIncorrectoLetra() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("GJHI305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionEquipamientoIncorrectoNumero() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("GJH9305438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionNumeroSerieNegativo() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU-65438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class)  
		public void testInicializacionNumeroSerieUnaLetra() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQUD65438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class) 
		public void testInicializacionNumeroSerieDosLetras() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU7AS438", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class)  
		public void testInicializacionNumeroSerieTresLetras() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU7AS4r8", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class) 
		public void testInicializacionNumeroSerieCuatroLetras() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU7AS4cv", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class) 
		public void testInicializacionNumeroSerieCincoLetras() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQUxAS4cv", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class)  
		public void testInicializacionNumeroSerieTodoLetras() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQUoASgcv", "4356.89Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTaraCero() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "0Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTaraNegativaKg() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "-4587Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionTaraNegativaLb() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "-4587Lb", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTaraSinMagnitud() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "4587", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class) 
		public void testInicializacionTaraUnaLetra() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "3g65Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class)  
		public void testInicializacionTaraVariasLetras() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "Fg68Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class)  
		public void testInicializacionTaraTodoLetras() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "Fg68Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionTaraMagnitudIncorrecta1() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "544kG", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionTaraMagnitudIncorrecta2() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "544kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTaraMagnitudIncorrecta3() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "544lb", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTaraMagnitudIncorrecta4() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "544LB", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionTaraMagnitudIncorrecta5() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "544LB", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionTaraMagnitudIncorrecta6() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "544KG", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTaraMagnitudDiferente() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "544M3", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionTaraSoloMagnitud() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "Kg", "903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class) 
		public void testInicializacionTaraMagnitudAlPrincipio() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "Kg5678", "903.336Kg", "300.8M3", 1, 0);
		}
		
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionTaCargaNegativaKg() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","-4587Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionTaCargaNegativaLb() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","-4587Lb", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionCargaSinMagnitud() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "903.336Kg","4587", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class)  
		public void testInicializacionCargaUnaLetra() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","3g65Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class) 
		public void testInicializacionCargaVariasLetras() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","Fg68Kg", "300.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class) 
		public void testInicializacionCargaTodoLetras() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","Fg68Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionCargaMagnitudIncorrecta1() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","544kG", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionCargaMagnitudIncorrecta2() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "544kg","903.336Kg", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionCargaMagnitudIncorrecta3() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "903.336Kg", "544lb","300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionCargaMagnitudIncorrecta4() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "903.336Kg", "544LB", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionCargaMagnitudIncorrecta5() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "903.336Kg","544LB", "300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionCargaMagnitudIncorrecta6() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","544KG", "300.8M3", 1, 0);
		}	
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTaVolumenCeroM3() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","4587Kg", "0M3", 1, 0);
		}	
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionTaVolumenCeroP3() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","4587Kg", "0P3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTaVolumenNegativoM3() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","4587Kg", "-300.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTaVolumenNegativoP3() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","4587Kg", "-300.8P3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionVolumenSinMagnitud() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "903.336Kg","4587Kg", "300.7", 1, 0);
		}
		@Test(expected=NumberFormatException.class)  
		public void testInicializacionVolumenUnaLetra() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","4587Kg", "30e.8M3", 1, 0);
		}
		@Test(expected=NumberFormatException.class)  
		public void testInicializacionVolumenVariasLetras() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","4587Kg", "S40.tM3", 1, 0);
		}
		@Test(expected=NumberFormatException.class)  
		public void testInicializacionVolumenTodoLetras() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","4587Kg", "erttyM3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionVolumenMagnitudIncorrecta1() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","4587Kg", "300.8m3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionVolumenMagnitudIncorrecta2() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "544Kg","4587Kg", "300.8p3", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionVolumenMagnitudIncorrecta3() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "903.336Kg", "4587Kg","300.8M", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionVolumenMagnitudIncorrecta4() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "903.336Kg", "4587Kg", "300.8M2", 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionVolumenMagnitudIncorrecta5() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "903.336Kg","4587Kg", "300.8P2", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionVolumenMagnitudIncorrecta6() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","4587Kg", "300.8P", 1, 0);
		}	
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionVolumenMagnitudDiferente() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","4587Kg", "300.8Kg", 1, 0);
		}	
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTaraNull() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",null,"4587Kg", "4567.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionCargaNull() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg",null, "4567.8M3", 1, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionVolumenNull() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "903.336Kg","4587Kg", null, 1, 0);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTechoNegativo() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "4587Kg","4587Kg", "4567.8M3", 1, -1);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionTechoDistinta() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "4587Kg","4587Kg", "4567.8M3", 0, 4);
		}
		@Test(expected=IllegalStateException.class) 
		public void testInicializacionEstadoNegativo() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438", "4587Kg","4587Kg", "4567.8M3", -1, 1);
		}
		@Test(expected=IllegalStateException.class)  
		public void testInicializacionEstadoDistinto() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "4587Kg","4587Kg", "4567.8M3", 5, 0);
		}
		@Test(expected=IllegalStateException.class)  
		public void testGetTrayectosSinTrayecto() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "4587Kg","4587Kg", "4567.8M3", 1, 0);
			a.getTrayectos();
		}
		@Test(expected=IllegalStateException.class)  
		public void testPrecioSinTrayecto() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "4587Kg","4587Kg", "4567.8M3", 1, 0);
			a.precio();
		}
		@Test(expected=IllegalStateException.class)  
		public void testBorrarSinTrayecto() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "4587Kg","4587Kg", "4567.8M3", 1, 0);
			a.borraTrayecto(t1);
		}
		@Test(expected=IllegalStateException.class)  
		public void testBorrarTrayectoNoAsignado() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "4587Kg","4587Kg", "4567.8M3", 1, 0);
			a.setTrayecto(t1);
			a.borraTrayecto(t2);
		}
		@Test(expected=IllegalStateException.class)  
		public void testBorrarDosVecesMismoTrayecto() {	
			@SuppressWarnings("unused")
			Contenedor a = new Contenedor("CSQU305438",  "4587Kg","4587Kg", "4567.8M3", 1, 0);
			a.setTrayecto(t3);
			a.setTrayecto(t1);
			a.borraTrayecto(t3);
			a.borraTrayecto(t3);
		}
		 
	}
