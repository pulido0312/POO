package Clases;
import java.util.ArrayList;
import es.uva.inf.poo.maps.GPSCoordinate;

/**
 * Implementacion de la clase Puerto, que te permite tanto crear muelles, como eliminarlos, obtener una lista 
 * de los muelles que estan vacios, el espacio que puede tener un muelle. Ademas tambien te devuelve una lista de los
 * muelles que se encuentran a una distancia inferior de una dada, entre sus coordenadas y un punto GPS.
 * 
 * @author Dargago, Carloma, AlePuli
 *
 */	
public class Puerto {
	private static String NombrePais;
	private static String CodCiudad;
	private int Hueco;
	private	static String nomPuerto;
	private int Operativo;
	private int numeroPlazas;
	private int idMuelle;
	private GPSCoordinate coordenadasGPS;
	private double PuntoGPS;
	private double Coordenadas;
	
	
	/**
	 * Creamos un Puerto a partir del codigo de una ciudad y el nombre de un pais
	 * @param CodCiudad
	 * @param NombrePais
	 */
	
	public Puerto(String CodCiudad, String NombrePais) {
		setnomPuerto(NombrePais, CodCiudad);
		numeroPlazas=1;
	}

	/**
	 * Hacemos un set del Id del Muelle2siempre que sea un numero entre 0 y 99 sino excepcion
	 * @param idMuelle
	 */
	public int setidMuelle(int idMuelle) {
		if((idMuelle>=0)&&(idMuelle<=99)) {
			return this.idMuelle2= idMuelle;
		}else {
			throw new IllegalArgumentException("Id incorrecto");
		}
	}
	
	/**
	 * Devuelve los dos digitos que representan un Muelle
	 * @return idMuelle
	 */
	
	public int getidMuelle() {
		return idMuelle;
	}
	
	
	/**
	 * Establecemos un set para el Puerto
	 * @param NombrePais
	 * @param CodCiudad
	 */

	public void setnomPuerto( String NombrePais, String CodCiudad) {
		Puerto.nomPuerto = getNombrePais() + "-" + getCodCiudad();
	}

	/**
	 * Establecemos un set para el NombrePais
	 * @param NombrePais
	 */

	public String setNombrePais(String NombrePais) {
		return Puerto.NombrePais = NombrePais;
	}

	/**
	 * Establecemos un set para CodCiudad
	 * @param CodCiudad
	 */

	public String setCodCiudad (String CodCiudad) {
		return Puerto.CodCiudad = CodCiudad;
	}

	/**
	 * Establecemos un set para determinar el hueco de un muelle
	 * @param Hueco
	 */
	
	public void setHueco(int Hueco) {
		this.Hueco = Hueco;
	}

	/**
	 * Devolvemos el String que representa el pais 
	 * @return NombrePais
	 */
	
	public static String getNombrePais() {
		return NombrePais;
	}

	/**
	 * Devolvemos el String que representa la ciudad
	 * @return CodCiudad
	 */
	
	public static String getCodCiudad() {
		return CodCiudad;
	}

	/**
	 * Devolvemos el hueco que tiene un muelle
	 * @return Hueco
	 */
	
	public int getHueco(int Hueco) {
		return Hueco;
	}

	/**
	 * Devolvemos el String que represneta el puerto
	 * @return nomPuerto
	 */
	
	public static String getnomPuerto() {
		return nomPuerto;
	}

	/**
	 * Devolvemos un int que representa si el Muelle2esta operativo o no
	 * @return Operativo
	 */
	
	public int getOperativo() {
		return Operativo;
	}
	
	/**
	 * Establecemos un set para ver si el Muelle2esta operativo o no
	 * @param Operativo
	 */
	
	public int setOperativo(int Operativo) {
		return this.Operativo = Operativo;
	}

	/**
	 * Devolvemos el numero de plazas que tiene un muelle
	 * @return numeroPlazas
	 */
	
	public int getPlazas() {
		return numeroPlazas;
	}
	
	/**
	 * Hacemos un set para las plazas de un Muelle
	 * @return numeroPlazas
	 */
	public int setPlazas(int numeroPlazas) {
		return this.numeroPlazas = numeroPlazas;
	}
	/**
	 * Devolvemos las coordenadas de un Muelle
	 * @return coordenadasGPS
	 */
	
	public GPSCoordinate getcoordenadasGPS() {
		return coordenadasGPS;
	}
	
	/**
	 * Devolvemos un Punto GPS 
	 * @return PuntoGPS
	 */
	
	public double getPuntoGPS() {
		return PuntoGPS;
	}
	
	/**
	 * Hacemos un set para el Punto GPS
	 * @param PuntoGPS 
	 */
	public double setPuntoGPS(double PuntoGPS){
		return this.PuntoGPS = PuntoGPS;
	}
	
	/**
	 * Hacemos un set de las coordenadas de un Muelle2en double
	 * @param Coordenadas
	 **/
	
	public double setCoordenadas(double Coordenadas) {
		return this.Coordenadas=Coordenadas;
	}
	
	/**
	 * Devolvemos las coordenadas GPS de un Muelle2en double
	 * @return Coordenadas
	 */
	public double getCoordenadas() {
		return Coordenadas;
	}
	
	
	/**
	 * Crear un Muelle2a partir de , 2 digitos, estado operativo,una posicion GPS
	 * @param nomPuerto
	 * @param idMuelle
	 * @param Operativo
	 * @param numeroPlazas
	 * @param coordenadasGPS
	 * @return ListaMue
	 * @throws IllegalArgumentException si el numero introducido para crear el Muelle2es <00 >99
	 * @throws IllegalArgumentException si el int de operativo es distinto de 0 y de 1
	 */
	
	public ArrayList<Muelle> CrearMuelle(String nomPuerto, int idMuelle, int Operativo, int numeroPlazas,GPSCoordinate coordenadasGPS) {
		ArrayList <Muelle> ListaMuelles = new ArrayList<Muelle>();
		if(getidMuelle()<99 || getidMuelle()>0) {
				int nMuelle2= 0; 
				nMuelle2+=1;
				Muelle2nuevoMuelle2= new Muelle(idMuelle,Operativo,numeroPlazas,coordenadasGPS);
				ListaMuelles.add(nuevoMuelle);	}
		ArrayList<Muelle> ListaMue = new ArrayList<Muelle>(ListaMuelles);
		return ListaMue;
}

	/**
	 * Eliminar un Muelle2poniendo un menos y los digitos del Muelle2al que se refiere
	 * @param nomPuerto
	 * @param nMuelle
	 * @param idMuelle
	 * @param Operativo
	 * @param numeroPlazas
	 * @param ArrayList <Muelle> ListaMuelles
	 * @return ListaMue
	 * @throws IllegalArgumentException si el numero para eliminar el Muelle2es positivo o tiene >00 <-99
	 */

	public ArrayList<Muelle> EliminarMuelle(String nomPuerto, int idMuelle,int Operativo, int numeroPlazas, GPSCoordinate coordenadasGPS) {
		ArrayList <Muelle> ListaMuelles = new ArrayList<Muelle>();
		if (getidMuelle()>-99 | getidMuelle()<0) {
			Muelle2nuevoMuelle2= new Muelle(0,0,1,getcoordenadasGPS());
			ListaMuelles.add(nuevoMuelle);
		}
		ArrayList<Muelle> ListaMue = new ArrayList<Muelle>(ListaMuelles);
		return ListaMue;
	}
	
	/**
	 * Retorna si hay hueco o no en el muelle, retornando false si no hay hueco y true si si lo hay
	 * @param numeroVacia
	 * @return boolean
	 * @throws IllegalArgumentException si el numero de plazas libres es negativo
	 */
	public boolean Espacio(int numeroVacia) {
		if(numeroVacia == 0) {
			setHueco(numeroVacia);
			return false;
		}else if(numeroVacia > 0){
				setHueco(numeroVacia);
				return true;
		}else {
			throw new IllegalArgumentException("No puede haber un numero negativo de plazas libres");
		}
	}
	
	/**
	 * Devuelve si un  Muelle2esta operativo o no, con un booleano true, SI esta operativo o false, NO lo esta
	 * @param idMuelle
	 * @param numeroPlazas
	 * @param coordenadasGPS
	 * @param Operativo
	 * @return boolean
	 * @throws IllegalArgumentException Debido a que lo que define si el Muelle2es operativo o no es un 0 o un 1, si es distinto suelta la excepcion
	 */

	public static boolean DiOperativo(int idMuelle, int Operativo, int numeroPlazas,GPSCoordinate coordenadasGPS) {
		if (Operativo == 0) {
			return false;
		}
		else if(Operativo == 1){
			return true;
		}else{
			throw new IllegalArgumentException("Operativo solo admite 0 o 1");
		}
	}
	/**
	 * Metodo que devuelve el numero de muelles totales en un puerto
	 * @param nMuelle
	 * @return nMuelle
	 * @throws IllegalArgumentException si el numero de muelles totales es negativo
	 */
	public int NumeroMuelle(int nMuelle) {
		if(nMuelle2> 0 | nMuelle2== 0) {
			return nMuelle;
		}else{
			throw new IllegalArgumentException("No puede haber un numero negativo de muelles");
		}
	}

	/**
	 * Devuelve una lista de los muelles que tienen espacios
	 * @param numeroVacia
	 * @return ListaEsp
	 * @throw IllegalArgumentException si el numero de plazas vacias es negativo
	 */

	public  ArrayList<Muelle> ListEspacio(int numeroVacia) {
		ArrayList <Muelle> ListaEspacio = new ArrayList<Muelle>();
		if (numeroVacia > 0) {
			ListaEspacio.add(new Muelle(getidMuelle(), getOperativo(), getPlazas(),getcoordenadasGPS()));	
		}else if(numeroVacia == 0){
			ListaEspacio.add(new  Muelle(0,0,1,getcoordenadasGPS()));
		}else {
			throw new IllegalArgumentException("No puede haber espacio negativo");
		}
		ArrayList<Muelle> ListaEsp = new ArrayList<Muelle>(ListaEspacio);
		return ListaEsp;
	}
	
	/**
	 * Devuelve una lista de los muelles queestan operativos 
	 * @param DiOperativo
	 * @return ListaOp
	 * @throws new IllegalArgumentException no se puede introducir un Muelle2no operativo
	 */
	
	public ArrayList<Muelle> ListOperativo(boolean DiOperativo) {
		ArrayList <Muelle> ListaOperativo = new ArrayList<Muelle>();
		if(DiOperativo == true) {
			ListaOperativo.add(new Muelle(getidMuelle(), getOperativo(), getPlazas(),getcoordenadasGPS()));
		}else if(DiOperativo == false) {
			throw new IllegalArgumentException("No se puede introducir un Muelle2no operativo");
		}
		ArrayList <Muelle> ListaOp = new ArrayList<Muelle>(ListaOperativo);

		return ListaOp;	
	}
	
	/**
	 * Devuelve una lista de los muelles que se encuentran a una distancia inferior dada de un punto GPS
	 * @param Distancia
	 * @param PuntoGPS
	 * @param Coordenada
	 * @return ListaDist
	 * @throws new IllegalArgumentException cuando el Muelle2este auna distancia superior de la dada
	 */
	
	public ArrayList<Muelle> ListDistancia (double Distancia, double PuntoGPS, double Coordenada ){
		ArrayList <Muelle> ListaDistancia = new ArrayList<Muelle>();
		double distancia2 = PuntoGPS - Coordenada;
		if(distancia2 <= Distancia) {
			ListaDistancia.add(new Muelle(getidMuelle(), getOperativo(), getPlazas(),getcoordenadasGPS()));
		}else if(distancia2 > Distancia) {
			throw new IllegalArgumentException("No se pueden almacenar Muelle2que esten a una distancia superior");
		}
		
		ArrayList <Muelle> ListaDist = new ArrayList<Muelle> (ListaDistancia);
	
		return ListaDist;
	}
}
