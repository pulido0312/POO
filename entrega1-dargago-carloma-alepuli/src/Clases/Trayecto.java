package Clases;
import es.uva.inf.poo.maps.GPSCoordinate;
/**
 * Implementacion de la clase Trayecto, contendra toda la informacion necesaria sobre el trayecto que realiza un contenedor.
 * 
 * @author @author Dargago, Carloma, AlePuli
 */
public class Trayecto {
	private Muelle2muelleOrigen;
	private Muelle2muelleDestino;
	private Puerto puerOrigen;
	private Puerto puerDestino;
	private int fechaInicio;
	private int fechaFin;
	private double precio;
	/**
	 * Creacion de un trayecto de un contenedor dados los parametros necesarios, el precio inicial del trayecto serñ cero hasta que se le asigne uno nuevo con sus respectivos costes.
	 * @param muelleOrigen	Muelle2de origen del trayecto.
	 * @param puerOrigen	Puerto de origen del trayecto.
	 * @param mueDestino	Muelle2de destino del trayecto.
	 * @param puerDestino	Puerto de destino del trayecto.
	 * @param fechaInicio	Fecha en la que se inicia el trayecto. Ejemplo: "23/6/2008"
	 * @param fechaFin		Fecha en la que se finaliza el trayecto. Ejemplo: "3/12/2019"
	 * @throws IllegalArgumentException Fecha incoherente o sin el formato descrito
	 * @throws IllegalArgumentException Fecha de inicio mayor que la fecha de fin de trayecto
	 */
	public Trayecto(Muelle2mueOrigen,Puerto puerOrigen,Muelle2mueDestino,Puerto puerDestino,String fechaInicio,String fechaFin){
		setMuelleOrigen(mueOrigen);
		setMuelleDestino(mueDestino);
		setPuerOrigen(puerOrigen);
		setPuerDestino(puerDestino);
		int inicio = traduceFecha(fechaInicio);
		int fin = traduceFecha(fechaFin);
	    if(fin<inicio)
	    	throw new IllegalStateException("Fecha final menor que fecha inicial");
	    setFechaInicio(inicio);
	    setFechaFin(fin);
	    setPrecio(0);
	}
	private static int traduceFecha(String fecha) {
		//Dñas transcurridos desde el 1/1/1920
		if(fecha == null)
			throw new IllegalStateException("Fecha incorrecta");
	    String[] trozos = fecha.split("/");
	    if(trozos.length!=3)
	    	throw new IllegalStateException("Fecha incorrecta");
	    int dia = Integer.parseInt(trozos[0]);
	    int mes = Integer.parseInt(trozos[1]);
	    int año = Integer.parseInt(trozos[2]);
	    if(año<0)
	    	throw new IllegalStateException("Año incorrecto");
	    if(mes<1 || mes >12)
	    	throw new IllegalStateException("Mes incorrecto");
	    if(dia<1 || dia > diaMax(mes,año))
	    	throw new IllegalStateException("Dia incorrecto");
	    return 367*año - (7*(año+5001+(mes-9)/7))/4 + (275*mes)/9 + dia - 692561;
	}
	private static int diaMax(int mes, int año) {
		int n = 0;
		switch (mes) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        	return 31;        
        case 4: case 6: case 9: case 11:
        	return 30;
        case 2:
            if(esBisiesto(año))
            	return 29;
            else
            	return 28;     
		}
		return n;
	}
	private static boolean esBisiesto(int año) {
		if ((año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0)))
			return true;
		else
			return false;
	}
	private static String traduceDias(int d) {
		int dia = 1;
		int mes = 1;
		int año = 1920;
		if(d>=0) {
			while(d>0) {
				dia++;
				d--;
				if(dia>diaMax(mes,año)) {
					mes++;
					if(mes>12) {
						año++;
						mes = 1;
					}
					dia = 1;
				}
				
			}
		}
		else {
			while(d<0) {
				dia--;
				d++;
				if(dia<1) {
					mes--;
					if(mes<1) {
						año--;
						mes = 12;
					}
					dia = diaMax(mes,año);
				}
			}
		}
		String fecha = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(año);
		return  fecha;
	}
	/**
	 * Consulta la distancia del trayecto
	 * @return Distancia en kilometros
	 */
	public double getDistanciaKm() {
		return muelleOrigen.getcoordenadasGPS().getDistanceTo(muelleDestino.getcoordenadasGPS());
	}
	/**
	 * Consulta la distancia del trayecto
	 * @return Distancia en millas marinas
	 */
	public double getDistanciaMillas() {
		return getDistanciaKm()/1.609;
	}
	/**
	 * Consulta el precio del trayecto, sobreescribira el precio asignado anteriormente
	 * @param costeDia		Coste por dña del trayecto (en euros)
	 * @param costeMilla	coste por milla marina (en euros)
	 * @return Precio del trayecto expresado en euros
	 * @throws IllegalArgumentException Coste negativo
	 */
	public double getPrecio(double costeDia,double costeMilla) {
		if(costeDia <0 || costeMilla <0)
			throw new IllegalStateException("Coste negativo");
		double p =getNumeroDias()*costeDia+getDistanciaMillas()*costeMilla;
		setPrecio(p);
		return p;
	}
	private void setPrecio(double n) {
		precio = n;
	}
	/**
	 * Consulta el precio del trayecto asignado, si todavia no se asignado devolvera su precio inicial (cero).
	 * @return Precio del trayecto expresado en euros
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * Consulta la informacion completa del trayecto
	 * @return Las siguientes informaciones separadas por un espacio: Localidad del puerto de origen,pañs de origen,fecha de inicio del trayecto,localidad del puerto de destino,pañs,fecha de fin de trayecto
	 */
	public String getInfoTrayecto() {
		return puerOrigen.getCodCiudad()+" "+puerOrigen.getNombrePais()+" "+getFechaInicio()+" "+puerDestino.getCodCiudad()+" "+puerDestino.getNombrePais()+" "+getFechaFin();
	}
	/**
	 * Consulta si la fecha de fin de trayecto es superior a una dada
	 * @param Fecha 
	 * @return True si la la fecha de fin de trayecto es superior
	 */
	public boolean fechaFinSuperior(String Fecha) {
		int n = traduceFecha(Fecha);
		if(getFechaFinDias()>n)
			return true;
		else
			return false;
	}
	
	/**
	 * Consulta el Muelle2de origen.
	 * @return Nombre del muelle
	 */
	public Muelle2getMuelleOrigen() {
		return muelleOrigen;
	}
	/**
	 * Consulta el Muelle2de destino.
	 * @return Muelle2destino
	 */
	public Muelle2getMuelleDestino() {
		return muelleDestino;
	}
	/**
	 * Consulta el puerto de origen.
	 * @return Puerto origen.
	 */
	public Puerto getPuertoOrigen() {
		return puerOrigen;
	}
	/**
	 * Consulta el puerto de destino.
	 * @return Puerto destino.
	 */
	public Puerto getPuertoDestino() {
		return puerDestino;
	}
	/**
	 * Consulta la fecha de inicio de trayecto.
	 * @return Fecha con formato "XX/XX/XXXX"
	 */
	public String getFechaInicio() {
		return traduceDias(fechaInicio);
	}
	/**
	 * Consulta la fecha de final de trayecto.
	 * @return Fecha con formato "XX/XX/XXXX"
	 */
	public String getFechaFin() {
		return traduceDias(fechaFin);
	}
	/**
	 * Consulta la duracion del trayecto
	 * @return El numero de dias que dura el trayecto
	 */
	public int getNumeroDias() {
		return getFechaFinDias()-getFechaInicioDias();
	}
	private int getFechaInicioDias() {
		return fechaInicio;
	}
	private int getFechaFinDias() {
		return fechaFin;
	}
	private void setMuelleOrigen(Muelle2m) {
		muelleOrigen = m;
	}
	private void setMuelleDestino(Muelle2m) {
		muelleDestino = m;
	}
	private void setPuerOrigen(Puerto p) {
		puerOrigen = p;
	}
	private void setPuerDestino(Puerto p) {
		puerDestino = p;
	}
	private void setFechaInicio(int n) {
		fechaInicio = n;
	}
	private void setFechaFin(int n) {
		fechaFin = n;
	}
}