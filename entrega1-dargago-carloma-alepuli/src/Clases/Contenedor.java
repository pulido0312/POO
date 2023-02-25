package Clases;
/**
 * Implementaciñn de la clase contenedor, contendrñ toda la informaciñn necesaria de esta estructura de transporte.
 * 
 * @author Dargago, Carloma, AlePuli
 */
public class Contenedor {
	private String coDueño;		
	private char equip;			
	private int nSerie;			
	private int nControl;		
	private double tara;		
	private double cargaMax;	
	private double volumen;		
	private boolean estado;		
	private boolean techo;		
	private double pesoCargado; 
	private Trayecto[] trayectos;
	private Double[] precioTrayecto;
	private int nTrayectos;
	
	/**
	 * Creaciñn de un contenedor dados los parametros necesarios:
	 * @param inf 		El parametro define la siguiente informacion escrita consecutivamente: Codigo del dueño(3 mayusculas) + Letra del equipamiento (U,J,Z) + Nñmero de serie (6 dñgitos). Ejemplo: "CSQU305438"
	 * @param peso 		El peso de la tara, podra ser definido en kilogramos añadiendo "Kg" al final de la cantidad, o en libras añadiendo "Lb". Ejemplo: "4356Kg"
	 * @param carga 	La maxima carga util permitida, podra ser definida en kilogramos o libras del mismo modo que el peso, añadiendo "kg" o "Lb" al final de la cantidad. Ejemplo: "9603.336Lb"
	 * @param volumen 	El volumen, podra ser definido en metros cubicos o en pies cubicos, añadiendo al final de la cantidad "M3" y "P3" respectivamente.	Ejemplo: "300M3" 
	 * @param estado	El estado en el que se encuentra, dos posibles estados: Transito (1) o Recogida (0).
	 * @param techo 	Indicacion del techo del contenedor, dos posibles casos: Posee techo (1) o No posee techo (0). 
	 * @throws IllegalArgumentException Si alguna cadena en nula, de tamaño incorrecto (en caso de la cadena de informacion), o si no posee magnitud o no sea la correspondiente.
	 */
	public Contenedor(String inf, String peso ,String carga, String volumen,int estado,int techo) {
		setInformacion(inf,peso,carga,volumen,estado,techo);
	}
	private void setInformacion(String i, String p,String c, String v,int e,int t) {
		if(i == null || i.length()!=10) throw new IllegalStateException("Codigo incorrecto");
		if(p == null || p.length()<3) throw new IllegalStateException("Peso incorrecto");
		if(c == null || c.length()<3) throw new IllegalStateException("Carga incorrecto");
		if(v == null || v.length()<3) throw new IllegalStateException("Volumen incorrecto");
		setCoDueño(i.substring(0,3));
		setEquip(i.charAt(3));
		setNSerie(Integer.parseInt(i.substring(4,i.length())));
		setNControl();
		int b = p.indexOf("Kg");
		int d = p.indexOf("Lb");
		if(b!=-1)	setTaraKg(Double.parseDouble(p.substring(0,b)));
		else if(d!=-1) setTaraLb(Double.parseDouble(p.substring(0,d)));
		else throw new IllegalStateException("Unidad de masa indefinida");
		b = c.indexOf("Kg");
		d = c.indexOf("Lb");
		if(b>0)	setCargaMaxKg(Double.parseDouble(c.substring(0,b)));
		else if(d>0) setCargaMaxLb(Double.parseDouble(c.substring(0,d)));
		else throw new IllegalStateException("Unidad de masa indefinida");
		b = v.indexOf("M3");
		d = v.indexOf("P3");
		if(b>0)	setVolumenM3(Double.parseDouble(v.substring(0,b)));
		else if(d>0) setVolumenP3(Double.parseDouble(v.substring(0,d)));
		else throw new IllegalStateException("Unidad de volumen indefinida");
		setEstado(e);
		setTecho(t);
		setPesoCargadoKg(0);
		precioTrayecto = new Double[2];
		trayectos = new Trayecto[2];
	}
	private int getDigito() {
		int n=0;
		int ascii;
		for(int i=0; i<=getCoDueño().length();i++) {
			if(i == getCoDueño().length()) ascii = (int) getEquip();
			else ascii = (int) getCoDueño().charAt(i);
			
			ascii = ascii - 55;
			if(ascii<=20) {
				if(ascii!=10)
				ascii++;
			}
			else if(ascii<=30) ascii+=2;
			else ascii+=3;
			ascii =  ascii * (int) Math.pow(2, i);
			n = n + ascii;
		}
		ascii = getNSerie();
		int j = 0;
		for(int i=0; i<6;i++) {
			j = ascii%10;
			ascii = ascii/10;
			j = j * (int) Math.pow(2, 9-i);
			n = n + j;
		}
		double s = (double) n/11;
		String str = String.valueOf(s);
		j = Integer.parseInt(str.substring(0, str.indexOf('.')));
		j = j*11;
		n = n-j;
		return n;
	}
	
	/**
	 * Consulta el codigo del dueño.
	 * @return Codigo del Dueño.
	 */
	public String getCoDueño() {
		return coDueño;
	} 
	/**
	 * Consulta el tipo equipamiento.
	 * @return Caracter que indica el equipamiento.
	 */
	public char getEquip() {
		return equip;
	}
	/**
	 * Consulta el numero de serie.
	 * @return Numero de serie.
	 */
	public int getNSerie() {
		return nSerie;
	}
	/**
	 * Consulta el numero de control.
	 * @return Numero de control.
	 */
	public int getNControl() {
		return nControl;
	}

	/**
	 * Consulta el peso del contenedor.
	 * @return Peso en unidad de kilogramos.
	 */
	public double getTaraKg() {
		return tara;
	}
	/**
	 * Consulta el peso del contenedor.
	 * @return Peso en unidad de libras.
	 */
	public double getTaraLb() {
		return tara * 2.20462;
	}
	/**
	 * Consulta la carga maxima permitida del contenedor.
	 * @return Carga en unidad de kilogramos.
	 */
	public double getCargaMaxKg() {
		return cargaMax;
	}
	/**
	 * Consulta la carga maxima permitida del contenedor.
	 * @return Carga en unidad de libras.
	 */
	public double getCargaMaxLb() {
		return cargaMax * 2.205;
	}
	/**
	 * Consulta el peso actual cargado en el contenedor.
	 * @return Peso en unidad de kilogramos.
	 */
	public double getPesoCargadoKg() {
		return pesoCargado;
	}
	/**
	 * Consulta el peso actual cargado en el contenedor.
	 * @return Peso en unidad de libras.
	 */
	public double getPesoCargadoLb() {
		return pesoCargado * 2.205;
	}
	/**
	 * Consulta la carga actual permitida por el contenedor.
	 * @return Carga en unidad de kilogramos.
	 */
	public double getCargaDisponibleKg() {
		return getCargaMaxKg()-getPesoCargadoKg();
	}
	/**
	 * Consulta la carga actual permitida por el contenedor.
	 * @return Carga en unidad de libras.
	 */
	public double getCargaDisponibleLb() {
		return getCargaMaxLb()-getPesoCargadoLb();
	}
	/**
	 * Consulta el volumen del contenedor.
	 * @return Volumen en unidad de metros cñbicos.
	 */
	public double getVolumenM3() {
		return volumen;
	}
	/**
	 * Consulta el volumen del contenedor.
	 * @return Volumen en unidad de pies cñbicos.
	 */
	public double getVolumenP3() {
		return volumen*35.315;
	}
	/**
	 * Consulta el estado en el que se encuentra el contenedor, en transito o en recogida.
	 * @return Boolean del estado, si estñ en trñnsito devolverñ true, sino false.
	 */
	public boolean getEstado() {
		return estado;
	}
	/**
	 * Consulta si contenedor posee techo.
	 * @return Boolean del estado del techo, si posee devolvera true, sino false.
	 */
	public boolean getTecho() {
		return techo;
	}
	
	private void setCoDueño(String a) {
		for(int i=0;i<a.length()-1;i++) {
			if(!(Character.isUpperCase(a.charAt(i))))
					throw new IllegalStateException("Codigo incorrecto");	
		}
		coDueño = a;
	}
	private void setEquip(char a) {	
		if(a!=(int) 'U' && a!=(int) 'J' && a!=(int) 'Z')
			throw new IllegalStateException("Equipamiento incorrecto");	
		equip = a;
	}
	private void setNSerie(int n) {
		if(n < 0)
			throw new IllegalStateException("Numero de serie incorrecto");
		nSerie = n;
	}
	private void setNControl() {
		nControl = getDigito();
	}
	private void setTaraKg(double t) {
		if(t <= 0)
			throw new IllegalStateException("Peso nulo o negativo");
		tara = t;
	}
	private void setTaraLb(double t) {
		if(t <= 0)
			throw new IllegalStateException("Peso nulo o negativo");
		tara = t/2.205;
	}
	private void setCargaMaxKg(double c) {
		if(c < 0)
			throw new IllegalStateException("Carga mñxima negativa");
		cargaMax = c;
	}
	private void setCargaMaxLb(double c) {
		if(c < 0)
			throw new IllegalStateException("Carga mñxima negativa");
		cargaMax = c/2.205;
	}
	private void setVolumenM3(double v) {
		if(v <= 0)
			throw new IllegalStateException("Volumen nulo o negativo");
		volumen = v;
	}
	private void setVolumenP3(double v) {
		if(v <= 0)
			throw new IllegalStateException("Volumen nulo o negativo");
		volumen = v/35.3147;
	}
	/**
	 * Almacena el peso actualmente cargado en el contenedor.
	 * @param Peso en kilogramos.
	 * @throws IllegalArgumentException Peso cargado negativo
	 * @throws IllegalArgumentException Peso cargado se excede de la carga maxima
	 */
	public void setPesoCargadoKg(double p) {
		if(p < 0 || p > getCargaMaxKg() )
			throw new IllegalStateException("Peso cargado incorrecto");
		pesoCargado = p;
	}
	/**
	 * Almacena el peso actualmente cargado en el contenedor.
	 * @param Peso en libras.
	 * @throws IllegalArgumentException Peso cargado negativo
	 * @throws IllegalArgumentException Peso cargado se excede de la carga maxima
	 */
	public void setPesoCargadoLb(double p) {
		if(p < 0)
			throw new IllegalStateException("Peso cargado negativo");
		if(p > getCargaMaxLb())
			throw new IllegalStateException("Peso cargado excedido");
		pesoCargado = p/2.205;
	}

	/**
	 * Almacena trayecto asignado al contenedor.
	 * @param a				Trayecto asignado
	 * @param costeDia		Coste por dña del trayecto (en euros)
	 * @param costeMilla	coste por milla marina (en euros)
	 */
	public void setTrayecto(Trayecto a) {
		if( getNumTrayectos()>=getTrayectosList().length)
			duplicar();
		getTrayectosList()[ getNumTrayectos()] = a;
		getTrayectosPrecio()[ getNumTrayectos()] = a.getPrecio();
		nTrayectos++;
	}
	private void duplicar() {
		Trayecto[] aux = new Trayecto[getTrayectosList().length*2];
		for(int i=0; i <  getNumTrayectos(); i++) 
			aux[i] = getTrayectosList(i);
		setTrayec(aux);
		Double[] auxPrecios = new Double[getTrayectosPrecio().length*2];
		for(int i=0; i <  getNumTrayectos(); i++) 
			auxPrecios[i] = getTrayectosPrecio(i);
		setPrecio(auxPrecios);
	}
	private void setTrayec(Trayecto[] a) {
		trayectos = a;
	}
	private void setPrecio(Double[] a) {
		precioTrayecto = a;
	}
	/**
	 * Borra un trayecto de la lista de trayectos asignados, en caso de que existan dos trayectos iguales borrara el primero que se encuentre en la lista
	 * @param a Trayecto que se desea borrar
	 * @throws IllegalArgumentException El trayecto no estaba asignado al contenedor
	 */
	public void borraTrayecto(Trayecto a) {
		if(getNumTrayectos() == 0)
			throw new IllegalStateException("Trayecto no asignado");
		int i=0;
		boolean eliminado = false;
		while(i<getNumTrayectos()) {
			if(getTrayectosList(i) == a) {
				eliminado = true;
				getTrayectosList()[i] = null;
				getTrayectosPrecio()[i] = 0.0;
				break;
			}
			i++;
		}
		if(eliminado) {
			if(i<getNumTrayectos()-1) {
				System.arraycopy(getTrayectosList(),i+1,getTrayectosList(),i,getNumTrayectos()-(i+1));
				System.arraycopy(getTrayectosPrecio(),i+1,getTrayectosPrecio(),i,getNumTrayectos()-(i+1));
			}
			
			nTrayectos--;
		}
		else
			throw new IllegalStateException("Trayecto no asignado");
	}
	/**
	 * Almacena el estado en el que se encuentra el contenedor
	 * @param Estado del contenedor, dos estados posibles: en trñnsito (1) o en recogida (0).
	 * @throws IllegalArgumentException indicacion n distinta de 1 y 0
	 */
	public void setEstado(int n) {
		if(n!=0 && n!=1)
			throw new IllegalStateException("Estado de trñnsito incorrecto");
		if(n==1)  
			estado = true;
		else
			estado = false;
	}
	/**
	 * Almacena si la indicacion de que el contenedor posea o no techo
	 * @param Un numero (1 o 0) que indica si posee techo (1) o si no posee techo (0).
	 * @throws IllegalArgumentException indicacion n distinta de 1 y 0
	 */
	public void setTecho(int n) {
		if(n!=0 && n!=1)
			throw new IllegalStateException("Estado de techo incorrecto");
		if (n==0)	techo = false;
		else techo = true;
	}
	/**
	 * Consulta el precio del transporte total 
	 * @return Precio en euros
	 * @throws IllegalArgumentException No hay trayectos asignados
	 */
	public double precio() {
		if(getNumTrayectos() == 0)
			throw new IllegalStateException("Sin trayectos asginados");
		double precio = 0;
		for(int i=0;i<getNumTrayectos();i++)
			precio = precio + getTrayectosPrecio(i);
		return precio;
	}
	/**
	 * Consulta el numero de trayectos asignados para el contendor
	 * @return Numero de trayectos
	 */
	public int getNumTrayectos() {
		return nTrayectos;
	}
	private Trayecto getTrayectosList(int i) {
		return trayectos[i];
	}
	private Trayecto[] getTrayectosList() {
		return trayectos;
	}
	private Double getTrayectosPrecio(int i) {
		return precioTrayecto[i];
	}
	private Double[] getTrayectosPrecio() {
		return precioTrayecto;
	}
	/**
	 * Consulta la informacion de todos los trayectos asignados
	 * @return Informacion de cada trayecto separadas por " || "
	 * @throws IllegalArgumentException No hay trayectos asignados
	 */
	public String getTrayectos() {
		if(getNumTrayectos() == 0)
			throw new IllegalStateException("Sin trayectos asginados");
		String nombres = "";
		for(int i=0;i<getNumTrayectos();i++) 
			nombres = nombres+" || "+getTrayectosList(i).getInfoTrayecto();
		return nombres;
	}
	
}
