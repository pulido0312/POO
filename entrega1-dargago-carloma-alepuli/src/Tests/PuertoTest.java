package Tests;
import static org.junit.Assert.*;
import org.junit.Test;
import Clases.Muelle;
import Clases.Puerto;
import es.uva.inf.poo.maps.GPSCoordinate;
/**
 * @author Dargago, Carloma, AlePuli
 */

public class PuertoTest{
	private static GPSCoordinate coor = new GPSCoordinate(0.0, 0.0);
	
	@Test 
	public void testNombrePuertoCorrecto() {
		Puerto prueba = new Puerto("ES","VAL");
		prueba.getnomPuerto();
	}
	
	@Test
	public void testSetPlazas() {
		int numeroPlazas = 5;
		Puerto prueba = new Puerto("ES","VAL");
		assertEquals(prueba.setPlazas(numeroPlazas),5);
	}
	@Test 
	public void testNombrePuertoCorrectoPrueba2() {
		Puerto prueba = new Puerto("FR","PAR");
		prueba.getnomPuerto();
	}
	
	@Test
	public void testObtenerIDdelMuelle() {
		Muelle2prueba = new Muelle(32,0,5,coor);
		assertEquals(prueba.getIdenMuelle(),32);
	}
	
	@Test
	public void testObtenerIDdelMuelleValor99() {
		Muelle2prueba = new Muelle(99,0,5,coor);
		assertEquals(prueba.getIdenMuelle(),99);
	}
	
	@Test
	public void testObtenerIDdelMuelleValor00() {
		Muelle2prueba = new Muelle(00,0,5,coor);
		assertEquals(prueba.getIdenMuelle(),00);
	}

	@Test
	public void testObtenerOperativo() {
		@SuppressWarnings("unused")
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(true,Puerto.DiOperativo(5, 1, 6, coor));
	}
	
	@Test
	public void testSetOperativo() {
		int Operativo = 1;
		Puerto prueba = new Puerto("ES","VAL");
		assertEquals(prueba.setOperativo(Operativo),1);
	}
	
	@Test
	public void testSetOperativoCon0() {
		int Operativo = 0;
		Puerto prueba = new Puerto("ES","VAL");
		assertEquals(prueba.setOperativo(Operativo),0);
	}
	

	@Test 
	public void testOperativoValor0() {
		@SuppressWarnings("unused")
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(false,Puerto.DiOperativo(5,0,5,coor));
	}
	
	@Test
	public void testGetHueco() {
		int Hueco = 4;
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(prueba.getHueco(Hueco),4);
	}
	
	@Test
	public void testObtenerPlazas() {
		Muelle2prueba = new Muelle(32,1,5,coor);
		assertEquals(prueba.getPlazas(),5);
	}
	
	@Test
	public void testIDMuelle() {
		int idMuelle2= 99;
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(prueba.setidMuelle(idMuelle),99);
	}
	
	@Test
	public void testIDMuelle2() {
		int idMuelle2= 00;
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(prueba.setidMuelle(idMuelle),00);
	}
	
	@Test
	public void testIDMuelle3() {
		int idMuelle2= 25;
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(prueba.setidMuelle(idMuelle),25);
	}
	
	@Test
	public void testCodCiudad() {
		String CodCiudad = "VAL";
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(prueba.setCodCiudad(CodCiudad),"VAL");
	}
	
	@Test
	public void testNombrePais() {
		String NombrePais = "ES";
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(prueba.setNombrePais(NombrePais),"ES");
	}
	
	
	@Test
	public void testObtenerOp(){
	Puerto prueba = new Puerto("ES", "VAL");
	assertEquals(0,prueba.getOperativo());
	} 
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testObtenerPlazasConValor0() {
		Muelle2prueba = new Muelle(32,1,0,coor);
		assertEquals(prueba.getPlazas(),0);
	}
	
	@Test
	public void testObtenerPlazasConValorPositivo() {
		Muelle2prueba = new Muelle(32,1,9,coor);
		assertEquals(prueba.getPlazas(),9);
	}

	@Test
	public void testProbarNumeroDeMuelles0() {
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(0,prueba.NumeroMuelle(0));
	}
	
	@Test
	public void testProbarNumerodeMuelles() {
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(5,prueba.NumeroMuelle(5));
	} 
	
	@Test
	public void testProbarNumerodeMuellesValor1() {
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(1,prueba.NumeroMuelle(1));
	} 
	
	@Test
	public void testProbarEspacio() {
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(true,prueba.Espacio(3));
	}
	
	@Test
	public void testProbarEspacioNoEspacio() {
		Puerto prueba = new Puerto("ES", "VAL");
		assertEquals(false, prueba.Espacio(0));
	}
	
	@Test
	public void testProbarArraylist() {
		Puerto prueba2 = new Puerto("ES","VAL");
		prueba2.CrearMuelle("ES-VAL", 32, 1, 5, coor);
	}
	
	@Test
	public void testProbarArraylist2() {
		Puerto prueba2 = new Puerto("ES","VAL");
		prueba2.CrearMuelle("ES-VAL", 32, 1, 6, coor);
	}
	
	@Test
	public void testProbarArraylist3() {
		Puerto prueba2 = new Puerto("ES","VAL");
		prueba2.CrearMuelle("ES-VAL", 99, 1, 6, coor);
	}
	
	@Test
	public void testProbarArraylist4() {
		Puerto prueba2 = new Puerto("ES","VAL");
		prueba2.CrearMuelle("ES-VAL", 00, 1, 6, coor);
	}
	
	@Test
	public void testProbarArraylistEliminar() {
		Puerto prueba2 = new Puerto("ES","VAL");
		prueba2.EliminarMuelle("ES-VAL", -54, 1, 6, coor);
	}
	
	@Test
	public void testProbarArraylistEliminar2() {
		Puerto prueba2 = new Puerto("ES","VAL");
		prueba2.EliminarMuelle("ES-VAL", -1, 1, 6, coor);
	}
	
	@Test
	public void testProbarArraylistEliminar3() {
		Puerto prueba2 = new Puerto("ES","VAL");
		prueba2.EliminarMuelle("ES-VAL", -100, 1, 6, coor);
	}
	
	@Test
	public void testcoordenadaGPS() {
		Muelle2prueba = new Muelle(32,1,9,coor);
		assertEquals(prueba.getcoordenadasGPS(),coor);
	}
	@Test
	public void testgetCoordenadas() {
		Puerto prueba2 = new Puerto("ES","VAL");
		prueba2.getCoordenadas();
	}
	
	@Test
	public void testsetCoordenadas() {
		Puerto prueba2 = new Puerto("ES","VAL");
		double Coordenadas = 35.1;
		prueba2.setCoordenadas(Coordenadas);
	}
	
	@Test
	public void testgetPuntoGPS() {
		Puerto prueba2 = new Puerto("ES","VAL");
		prueba2.getPuntoGPS();
	}
	
	@Test
	public void testsetPuntoGPS() {
		Puerto prueba2 = new Puerto("ES","VAL");
		double PuntoGPS = 35.1;
		prueba2.setPuntoGPS(PuntoGPS);
	}
	
	@Test
	public void testListaOperativoOperativo() {
		Puerto prueba = new Puerto("ES", "VAL");
		@SuppressWarnings("unused")
		Muelle2prueba2 = new Muelle(32,1,9,coor);
		prueba.ListOperativo(true);
	}
	
	@Test 
	public void testListaDistanciaDistaciaInferior() {
		Puerto prueba = new Puerto("ES", "VAL");
		prueba.ListDistancia(150.2,32.1,2.1);
	}
	
	@Test
	public void testListaEspacioNumeroVaciasPositivo() {
		Puerto prueba = new Puerto("ES", "VAL");
		prueba.ListEspacio(8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testListaEspacioNumeroVacias0() {
		Puerto prueba = new Puerto("ES", "VAL");
		prueba.ListEspacio(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProbarCrearMuelleMal() {
		@SuppressWarnings("unused")
		Puerto prueba = new Puerto("ES","VAL");
		Muelle2prueba2 = new Muelle(132,1,9,coor);
		prueba2.getIdenMuelle();
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIDMuelleError() {
		int idMuelle2= -2;
		Puerto prueba = new Puerto("ES", "VAL");
		prueba.setidMuelle(idMuelle);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testOperativoDistintode0y1() {
		Puerto.DiOperativo(5,5,5,coor);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testOperativoNegativo() {
		Puerto.DiOperativo(5,-5,5,coor);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testProbarEspacioNegativo() {
		Puerto prueba = new Puerto("ES", "VAL");
		prueba.Espacio(-1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testProbarEspacioNegativoGrande() {
		Puerto prueba = new Puerto("ES", "VAL");
		prueba.Espacio(-320);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testProbarNumeroDeMuellesNegativo() {
		Puerto prueba = new Puerto("ES", "VAL");
		prueba.NumeroMuelle(-1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testListaEspacio() {
		Puerto prueba = new Puerto("ES", "VAL");
		prueba.ListEspacio(-1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testListaOperativoNooperativo() {
		Puerto prueba = new Puerto("ES", "VAL");
		prueba.ListOperativo(false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testListaDistanciaDistaciaSuperior() {
		Puerto prueba = new Puerto("ES", "VAL");
		prueba.ListDistancia(15.2,32.1,2.1);
	}
}