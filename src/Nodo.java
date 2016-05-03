import java.util.ArrayList;

/**
 * 
 * @author Ignacio de Lucas Noguero
 * @author Hugo Fernandez Visier
 *
 */
public class Nodo implements Comparable<Object> {
	private ArrayList<Integer> pastelerosSinAsignar;
	private ArrayList<Integer> pastelerosAsignados;
	private int beneficioActual;
	private static int[][] matrizBeneficios;
	private int ultimoPastelero;

	/**
	 * Constructor padre
	 */
	public Nodo() {
		this.pastelerosAsignados = new ArrayList<Integer>();
		this.pastelerosSinAsignar = new ArrayList<Integer>();
	}

	/**
	 * Constructor pasandole la matriz de beneficios pastelero_pastel
	 * 
	 * @param puntuacionPasteles
	 *            matriz beneficio pastelero_pastel
	 */
	public Nodo(int[][] puntuacionPasteles) {
		super();
		matrizBeneficios = puntuacionPasteles;
		this.pastelerosAsignados = new ArrayList<Integer>();
		this.pastelerosSinAsignar = new ArrayList<Integer>();
		inicializarAsignados();
		inicializarNoAsignados();
		this.ultimoPastelero = 0;
	}

	// METODOS GET Y SET
	public ArrayList<Integer> getPastelerosSinAsignar() {
		return pastelerosSinAsignar;
	}

	public void setPastelerosSinAsignar(ArrayList<Integer> pastelerosSinAsignar) {
		this.pastelerosSinAsignar = (ArrayList<Integer>) pastelerosSinAsignar;
	}

	public ArrayList<Integer> getPastelerosAsignados() {
		return pastelerosAsignados;
	}

	public void setPastelerosAsignados(ArrayList<Integer> pastelerosAsignados) {
		this.pastelerosAsignados = (ArrayList<Integer>) pastelerosAsignados;
	}

	public int getBeneficioActual() {
		return beneficioActual;
	}

	public void setBeneficioActual(int beneficioActual) {
		this.beneficioActual = beneficioActual;
	}

	public static int[][] getMatrizBeneficios() {
		return matrizBeneficios;
	}

	public void setMatrizBeneficios(int[][] matrizBeneficios) {
		this.matrizBeneficios = matrizBeneficios;
	}

	public int getUltimoPastelero() {
		return ultimoPastelero;
	}

	public void setUltimoPastelero(int ultimoPastelero) {
		this.ultimoPastelero = ultimoPastelero;
	}

	// METODOS DE NODO

	/**
	 * Inicializa el arrayList pasteleros asignados
	 */
	private void inicializarAsignados() {
		for (int p : matrizBeneficios[0]) {
			pastelerosAsignados.add(-1);
		}
	}

	/**
	 * Inicializa el arrayList los pasteleros no asignados
	 */
	private void inicializarNoAsignados() {
		for (int i = 0; i < matrizBeneficios[0].length; i++) {
			pastelerosSinAsignar.add(i);
		}
	}

	/**
	 * Metodo encargado de crear los hijos del nodo dado que se le pasa a la
	 * funcion
	 * 
	 * @param n
	 *            objeto tipo Nodo
	 * @return ArrayList de nodos hijos
	 */
	public ArrayList<Nodo> complecciones(Nodo n) {
		ArrayList<Nodo> hijos = new ArrayList<>();
		Nodo hijo = new Nodo();
		for (int pastelero : pastelerosSinAsignar) {
			hijo = Nodo.copia(n);
			int numPedido = hijo.getUltimoPastelero() + 1;
			hijo.getPastelerosSinAsignar().remove((Integer) pastelero);
			hijo.setUltimoPastelero(numPedido);
			hijo.getPastelerosAsignados().set(numPedido - 1, pastelero);
			hijo.generarBeneficioEstimado();
			hijos.add(hijo);
		}
		return hijos;
	}

	/**
	 * funcion que se encarga de copiar un nodo en otro
	 * 
	 * @param n
	 *            objeto tipo Nodo
	 */
	public static Nodo copia(Nodo n) {
		Nodo copia = new Nodo();
		copia.beneficioActual = n.getBeneficioActual();
		copia.pastelerosAsignados = (ArrayList<Integer>) n.getPastelerosAsignados().clone();
		copia.ultimoPastelero = n.getUltimoPastelero();
		copia.pastelerosSinAsignar = (ArrayList<Integer>) n.getPastelerosSinAsignar().clone();
		return copia;
	}

	/**
	 * Devuelve true si el arrayList de pasteleros esta vacia.
	 * 
	 * @return booleano
	 */
	public boolean estaTerminado() {
		return pastelerosSinAsignar.isEmpty();
	}

	/**
	 * Este metodo se encarga de generar el beneficio maximo de cada pastelero y
	 * sumarlo al beneficio actual
	 */
	private void generarBeneficioEstimado() {
		int beneficio = 0;
		int contador = 0;
		for (int pasteleroElegido : pastelerosAsignados) {
			if (pasteleroElegido != -1) {
				beneficio += matrizBeneficios[contador][pasteleroElegido];
			} else {
				int beneficioMayor = 0;
				int asignar=0;
				for (int i = 0; i < matrizBeneficios.length; i++) {
					if(getPastelerosSinAsignar().contains(i) && beneficioMayor<=matrizBeneficios[contador][i]){
						asignar=i;
						beneficioMayor = matrizBeneficios[contador][i];
					}
				}
				
				beneficio += beneficioMayor;
				getPastelerosAsignados().set((Integer)contador, asignar);
				getPastelerosSinAsignar().remove((Integer) asignar);
			}
			contador++;
		}
		this.setBeneficioActual(beneficio);
	}

	/**
	 * funcion que se encarga de decir si el beneficio actual del nodo actual es
	 * mayor que el nodo que se le pasa
	 */
	@Override
	public int compareTo(Object o) {
		Nodo aux = (Nodo) o;
		if (aux.beneficioActual > this.beneficioActual) {
			return 1;
		}
		if (aux.beneficioActual < this.beneficioActual) {
			return -1;
		} else {
			return 0;
		}
	}

}
