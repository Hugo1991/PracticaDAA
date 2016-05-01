import java.util.ArrayList;

public class Nodo implements Comparable {
	private ArrayList<Integer> pastelerosAsignados;
	private int cotaInferior;
	private ArrayList<Integer> tareasSinAsignar;
	private int beneficioActual; 
	private int[][] costes;
	public Nodo(){}
	
	public Nodo(int[][] costes) {
		this.costes = costes;
	}

	public Nodo(ArrayList<Integer> pastelerosAsignados, int cotaInferior, ArrayList<Integer> tareasSinAsignar,
			int[][] costes, int costeReal) {
		this.pastelerosAsignados = pastelerosAsignados;
		this.cotaInferior = cotaInferior;
		this.tareasSinAsignar = tareasSinAsignar;
		this.beneficioActual = costeReal;
	}


	public ArrayList<Integer> getPastelerosAsignados() {
		return pastelerosAsignados;
	}
	public void setPastelerosAsignados(ArrayList<Integer> pastelerosAsignados) {
		this.pastelerosAsignados = pastelerosAsignados;
	}
	public int getCotaInferior() {
		return cotaInferior;
	}
	public void setCotaInferior(int cotaInferior) {
		this.cotaInferior = cotaInferior;
	}
	public ArrayList<Integer> getTareasSinAsignar() {
		return tareasSinAsignar;
	}
	public void setTareasSinAsignar(ArrayList<Integer> tareasSinAsignar) {
		this.tareasSinAsignar = tareasSinAsignar;
	}
	public int getBeneficioActual() {
		return beneficioActual;
	}
	public void setBeneficioActual(int beneficioActual) {
		this.beneficioActual = beneficioActual;
	}
	public int[][] getCostes() {
		return costes;
	}
	public void setCostes(int[][] costes) {
		this.costes = costes;
	}
	private ArrayList<Integer> complecciones(Nodo nodo) {
		return null;
	}

	/**
	 * funcion que se encarga de copiar un nodo en otro
	 * 
	 * @param n
	 */
	public void copiaNodo(Nodo n) {
		this.setTareasSinAsignar(n.getTareasSinAsignar());
		this.setPastelerosAsignados(n.getPastelerosAsignados());
		this.setBeneficioActual(n.getBeneficioActual());
		this.setCotaInferior(n.getCotaInferior());
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
