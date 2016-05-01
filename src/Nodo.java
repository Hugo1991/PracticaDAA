import java.util.ArrayList;

public class Nodo implements Comparable {
	private ArrayList<Integer> pastelerosSinAsignar;
	private ArrayList<Integer> pastelerosAsignados;
	private int beneficioActual;
	private int[][] matrizBeneficios;
	private int ultimoPastelero;

	public Nodo() {
	}

	public Nodo(ArrayList<Integer> pastelerosSinAsignar, ArrayList<Integer> pastelerosAsignados, int beneficioActual,
			int[][] matrizBeneficios, int ultimoPastelero) {
		super();
		this.pastelerosSinAsignar = pastelerosSinAsignar;
		this.pastelerosAsignados = pastelerosAsignados;
		this.beneficioActual = beneficioActual;
		this.matrizBeneficios = matrizBeneficios;
		this.ultimoPastelero = ultimoPastelero;
	}

	public ArrayList<Integer> getPastelerosSinAsignar() {
		return pastelerosSinAsignar;
	}

	public void setPastelerosSinAsignar(ArrayList<Integer> pastelerosSinAsignar) {
		this.pastelerosSinAsignar = pastelerosSinAsignar;
	}

	public ArrayList<Integer> getPastelerosAsignados() {
		return pastelerosAsignados;
	}

	public void setPastelerosAsignados(ArrayList<Integer> pastelerosAsignados) {
		this.pastelerosAsignados = pastelerosAsignados;
	}

	public int getBeneficioActual() {
		//TODO por hacer funcion
		return beneficioActual;
	}

	public void setBeneficioActual(int beneficioActual) {
		this.beneficioActual = beneficioActual;
	}

	public int[][] getMatrizBeneficios() {
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

	private ArrayList<Nodo> complecciones(Nodo nodo) {
		ArrayList<Nodo> hijos = new ArrayList<>();
		for(Integer pastelero:getPastelerosSinAsignar()){
			Nodo hijo=new Nodo();
			int pedido=getUltimoPastelero()+1;
			hijo.copiaNodo(nodo);
			hijo.setBeneficioActual(getBeneficioActual());
			hijo.setUltimoPastelero(pedido);
			hijo.getPastelerosAsignados().set(pedido-1, pastelero);
			hijo.getPastelerosSinAsignar().remove(pastelero);
			hijos.add(hijo);
		}
		return hijos;
	}

	/**
	 * funcion que se encarga de copiar un nodo en otro
	 * 
	 * @param n
	 */
	public void copiaNodo(Nodo n) {
		
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
