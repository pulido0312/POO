package Clases;
import java.util.ArrayList;

import es.uva.inf.poo.maps.GPSCoordinate;
/**
 *Esta clase devuelve el numero de plazas que tiene el muelle, con la posibilidad de conocer el estado de estas(vacias,semi-llenas o llenas).
 *Tambien permite localizar los contenedores y saber en que nivel estan apilados. 
 *Ademas cabe la posibilidad de asignar un contenedor a una plaza y apilarlo encima de otro si es posible y por contra sacarlo de una plaza y desapilarlo.
 *
 * @author Dargago, Carloma, AlePuli
 */
public class Muelle2 { 

	private  int identificadorMuelle;
	private int estadoMuelle;
	private  int numeroPlazas;
	private  ArrayList<Contenedor> lista_muelle;
	private GPSCoordinate coordenadasGPS;
	private Boolean barco;
	private Boolean tren;
	/**
	* Constructor de un nuevo muelle.
	* @param identificadorMuelle
	* @param estadoMuelle
	* @param numeroPlazas
	* @param coordenadasGPS
	* @param barco
	* @param tren
	* @throws IllegalArgumentException Si el identificador de muelle es erroneo, mas de dos dígitos.
	* @throws IllegalArgumentException Si el estado del muelle es erroneo, distinto de 1 o 0.
	* @throws IllegalArgumentException Si el numero de plazas es menor o igual a 0.
	*/
	public Muelle2(int identificadorMuelle, int estadoMuelle, int numeroPlazas,GPSCoordinate coordenadasGPS, Boolean barco, Boolean tren) {
		setIdenMuelle(identificadorMuelle);
		setEstadoMuelle(estadoMuelle);
		setPlazas(numeroPlazas);
		setlista_muelle(crear_lista());
		setcoordenadaGPS(coordenadasGPS);
		setTransporteBarco(barco);
		setTransporteTren(tren);
	}
	/**
	 * Constructor muelle ya existente.
	 * @param identificadorMuelle
	 * @param estadoMuelle
	 * @param numeroPlazas
	 * @param coordenadasGPS
	 * @param barco
	 * @param tren
	 * @param lista_muelle_existente
	 * @throws IllegalArgumentException Si el identificador de muelle es erroneo, mas de dos dígitos.
	 * @throws IllegalArgumentException Si el estado del muelle es erroneo, distinto de 1 o 0.
	 * @throws IllegalArgumentException Si el numero de plazas es menor o igual a 0.
	 */
	public Muelle2(int identificadorMuelle, int estadoMuelle, int numeroPlazas,GPSCoordinate coordenadasGPS,ArrayList<Contenedor> lista_muelle_existente,Boolean barco, Boolean tren) {
		setIdenMuelle(identificadorMuelle);
		setEstadoMuelle(estadoMuelle);
		setPlazas(numeroPlazas);
		setlista_muelle(lista_muelle_existente);
		setcoordenadaGPS(coordenadasGPS);
		setTransporteBarco(barco);
		setTransporteTren(tren);
	}
	/**
	 * Establece el identificador de dos digitos de un muelle
	 * @param identificadorMuelle
	 * @throws IllegalArgumentException Si el identificador es mayor de dos digitos.
	 */
	public void setIdenMuelle(int identificadorMuelle) {
		if((identificadorMuelle>=0)&&(identificadorMuelle<=99)) {
			this.identificadorMuelle=identificadorMuelle;
		}else {
			throw new IllegalArgumentException("Numero de identificador incorrecto");
		}
	}
	/**
	 * Establece el estado de un muelle
	 * @param estadoMuelle
	 * @throws IllegalArgumentException Si el estado del Muelle es distinto a 1(operativo) o a 0(no operativo).
	 */
	public void setEstadoMuelle(int estadoMuelle) {
		if((estadoMuelle==1)||(estadoMuelle==0)) {
			this.estadoMuelle=estadoMuelle;
		}else {
			throw new IllegalArgumentException("Estado de Muelle2incorrecto");
		}
	}
	/**
	 * Establece el numero de plazas de un muelle
	 * @param numeroPlazas
	 * @throws IllegalArgumentException Si el numero de plazas es menor o igual a 0.
	 */
	public void setPlazas(int numeroPlazas) {
		if(numeroPlazas>0) {
			this.numeroPlazas=numeroPlazas;
		}else {
			throw new IllegalArgumentException("Numero de plazas incorrectas");
		}
	}
	/**
	 * Crea una lista para poder operar con un muelle.
	 * @param vectorMUelle
	 */
	public void setlista_muelle(ArrayList<Contenedor>lista_muelle) {
		this.lista_muelle=lista_muelle;
	}
	/**
	 * Establece la coordenada GPS de un muelle
	 * @param coordenadaGPS
	 */
	public void setcoordenadaGPS(GPSCoordinate coordenadasGPS) {
		this.coordenadasGPS=coordenadasGPS;
	}
	/**
	 * Establece si el muelle tiene acceso para barcos
	 * @param barco
	 */
	public void setTransporteBarco(Boolean barco) {
		this.barco=barco;
	}
	/**
	 * Establece si el muelle tiene acceso para trenes
	 * @param tren
	 */
	public void setTransporteTren(Boolean tren) {
		this.tren=tren;
	}
	/**
	 * Devuelve la copia de la lista de un Muelle en forma de lista para poder almacenarlos
	 * @return vectorMuelle
	 */
	public ArrayList<Contenedor> guardarMuelle() {
		return (ArrayList<Contenedor>) lista_muelle.clone();
	}
	/**
	 * Devuelve el identificador de un muelle.
	 * @return identificador muelle
	 */
	public int getIdenMuelle(){
		return identificadorMuelle;
	}
	/**
	 * Devuelve el estado de un muelle.
	 * @return EstadoMuelle
	 */
	public int getEstadoMuelle() {
		return estadoMuelle;
	}
	/**
	 * Devuelve en numero de plazas de un muelle.
	 * @return numero de plazas
	 */
	public int getPlazas() {
		return numeroPlazas;
	}
	/**
	 * Devuelve la coordenada GPS del muelle.
	 * @return coordenadasGPS
	 */
	public GPSCoordinate getcoordenadasGPS() {
		return coordenadasGPS;
	}
	/**
	 * Devuelve si el muelle tiene acceso para barcos
	 * @return barco
	 */
	public Boolean getTransporteBarco() {
		return barco;
	}
	/**
	 * Devuelve si el muelle tiene acceso para trenes
	 * @return tren
	 */
	public Boolean getTransporteTren() {
		return tren;
	}
	/**
	 * Devuelve el numero de plazas que estan vacias.
	 * @return plazasVacias
	 */
	public int numeroVacia() {
		int vacias = 0;
		for(int i=0; i<(lista_muelle.size()/4);i++) {
			if(lista_muelle.get(i*4)==null && lista_muelle.get(i*4+3)==null) {
				vacias++;
			}
		}
		vacias = vacias+(numeroPlazas-(lista_muelle.size()/4));
		return vacias;
	}
	/**
	 * Devuelve el numero de plazas que estan llenas.
	 * @return int plazasLlenas
	 */
	public int numeroLlenas() {
		int llenas = 0;
		for(int i=0; i<(lista_muelle.size()/4);i++) {
			if(lista_muelle.get(i*4)!=null && lista_muelle.get(i*4+3)!=null) {
				llenas++;
			}
		}
		return llenas;
	}
	/**
	 * Devuelve el numero de plazas que estan semillenas.
	 * @return int plazasSemiLlenas
	 */
	public int numeroSemiLlenas() {
		int semillenas = 0;
		for(int i=0; i<lista_muelle.size()/4;i++) {
			if((lista_muelle.get(i*4)!=null)&&(lista_muelle.get(i*4 + 3)==null)) {
				semillenas++;
			}
		}
		return semillenas;
	}
	/**
	 * Devuelve el numero de plaza en el que esta asignado un contenedor.
	 * @param nSerie
	 * @return int locPlaza
	 */
	public int plazaContenedor(Contenedor a) {
		int plaza = 0;
		plaza = lista_muelle.indexOf(a)/4 + 1;
		return plaza;
	}
	/**
	 * Devuelve el nivel en el que esta almacenado un contenedor.
	 * @param nSerie
	 * @return int locNivel
	 */
	public int nivelContenedor(Contenedor a) {
		int nivel = 0;
		int plaza = (plazaContenedor(a)-1)* 4;
		while(lista_muelle.get(plaza)!= a) {
			nivel++;
			plaza++;
		}
		return nivel+1;
	}
	/**
	 * Almacena un contenedor en un nivel y plaza libre.
	 * @param nSerie
	 * @param techo
	 * @return lista_muelle
	 * @throws IllegalArgumentException Si el Muelle2 esta lleno,no se pueden apilar mas contenedores.
	 * @throws IllegalArgumentException Si el contenedor que se va a apilar ya esta almacenado en el muelle.
	 * @throws IllegalStateException si no hay concordancia entre la posibilidad de transporte en barco del muelle y el contenedor.
	 */
	public ArrayList<Contenedor> insertarContenedor(Contenedor a) {
		if(lista_muelle.contains(a)) {
			throw new IllegalArgumentException("El contenedor que intenta almacenar ya esta en el muelle");
		}
		if(numeroLlenas()>=numeroPlazas) {
			throw new IllegalArgumentException("El Muelle  esta completo,no se pueden apilar mas contenedores");
		}
		compruebaBarco(a);
		compruebaTren(a);
		if(lista_muelle.contains(null)){
			if(a.getTecho()) {
				lista_muelle.set(lista_muelle.indexOf(null),a);
			}else {
				for(int i = lista_muelle.indexOf(null);((i)%4)!=0;i++) {
					lista_muelle.set(i,a);
				}
			}
		}	
		else {
			if(a.getTecho()) {
				lista_muelle.add(a);
			}else {
				for(int i = lista_muelle.size();((i+1)%4)!=0;i++) {
					lista_muelle.add(i, a);
				}
				lista_muelle.add(lista_muelle.size(),a);
			}
			aumentar(lista_muelle,a);
		}
		return lista_muelle;
	}
	/**
	 * Desalmacena el contenedor de la plaza donde estaba ubicado.
	 * @param nSerie
	 * @param techo
	 * @return
	 * @throws IllegalArgumentException Si el contenedor que se quiere desapilar no se encuentra almacenado. 
	 */
	public ArrayList<Contenedor> desapilarContenedor(Contenedor a) {
		if(lista_muelle.contains(a)) {
			int lim=0;
			int posicion = lista_muelle.indexOf(a);
			for(int i = lista_muelle.indexOf(a);(i+1)%4!=0;i++) {
				lim++;
			}	
			if(a.getTecho()) {
				gravedad(lista_muelle,posicion,posicion+lim);
				lista_muelle.set(posicion+lim, null);
				rellenar(lista_muelle,posicion+lim-1);
			}else {
				for(int i = posicion;i<=posicion+lim;i++) {
					lista_muelle.set(i, null);
				}	
			}
		}else
			throw new IllegalArgumentException("El contenedor que desea desalmacenar no se encuentra en el muelle");
		return lista_muelle;
	}
	/**
	 * Comprueba si hay concordancia entre las posibilidades de transporte maritimo del muelle y los requisitos de transporte de un contenedor
	 * @param a
	 * @throws IllegalStateException si no hay concordancia entre la posibilidad de transporte en barco del muelle y el contenedor
	 */
	public void compruebaBarco(Contenedor a) {
		if(a.getTransporte.equals("barco")!=barco) {
			throw new IllegalStateException("El contenedor posee unas caracteristicas en el transporte que el muelle no puede satisfacer debido a que no tiene acceso a barcos");
		}
	}
	/**
	 * Comprueba si hay concordancia entre las posibilidades de transporte ferroviaro del muelle y los requisitos de transporte de un contenedor
	 * @param a
	 * @throws IllegalStateException si no hay concordancia entre la posibilidad de transporte en tren del muelle y el contenedor
	 */
	public void compruebaTren(Contenedor a) {
		if(a.getTransporte.equals("tren")!=tren) {
			throw new IllegalStateException("El contenedor posee unas caracteristicas en el transporte que el muelle no puede satisfacer debido a que no tiene acceso a trenes");
		}
	}
	/**
	 * Crea una lista para un muelle nuevo
	 * @return
	 */
	private ArrayList<Contenedor> crear_lista() {
		return new ArrayList<>();
	}

	/**
	 *"Desplaza" los contenedores hacia un nivel inferior en la plaza si tiene un hueco debajo
	 * @param muelle
	 * @param posicion
	 * @param limite
	 * @return vectorMuelle
	 */
	private static ArrayList<Contenedor> gravedad (ArrayList<Contenedor> lista_muelle,int posicion,int limite) {
		if(posicion<=limite) {
			for(int j=posicion; j<=limite;j++) {
				lista_muelle.set(j, lista_muelle.get(j+1));
			}
		}return lista_muelle;
	}
	/**
	 *"Rellena" el ultimo nivel de una plaza si el ultimo contenedor apilado en esta no tiene techo
	 * @param muelle
	 * @param posicion
	 * @return vectorMuelle
	 */
	private static ArrayList<Contenedor> rellenar(ArrayList<Contenedor> lista_muelle,int posicion) {
		if(!lista_muelle.get(posicion).getTecho()) {
			lista_muelle.set(posicion+1, lista_muelle.get(posicion));
		}
		return lista_muelle;
	}
	/**
	 * Rellena la proxima plaza de null para poder contar bien las plazas vacias.
	 * @param lista_muelle
	 * @param a
	 * @return
	 */
	private ArrayList<Contenedor> aumentar(ArrayList<Contenedor> lista_muelle, Contenedor a) {
		for(int i = lista_muelle.lastIndexOf(a)+1;((i)%4)!=0;i++) {
			lista_muelle.add(i,null);
		}
		return lista_muelle;
	}
}
