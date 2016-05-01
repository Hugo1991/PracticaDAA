import java.util.ArrayList;

public class Nodo {
	private ArrayList<Integer> pastelerosAsignados;
	private int cotaSuperior;
	private ArrayList<Integer> tareasSinAsignar;
	private int[][] costes;
	private int costeReal;
	public Nodo(ArrayList<Integer> pastelerosAsignados, int cotaSuperior, ArrayList<Integer> tareasSinAsignar,
			int[][] costes, int costeReal) {
		this.pastelerosAsignados = pastelerosAsignados;
		this.cotaSuperior = cotaSuperior;
		this.tareasSinAsignar = tareasSinAsignar;
		this.costes = costes;
		this.costeReal = costeReal;
	}
	public ArrayList<Integer> getPastelerosAsignados() {
		return pastelerosAsignados;
	}
	public void setPastelerosAsignados(ArrayList<Integer> pastelerosAsignados) {
		this.pastelerosAsignados = pastelerosAsignados;
	}
	public int getCotaSuperior() {
		return cotaSuperior;
	}
	public void setCotaSuperior(int cotaSuperior) {
		this.cotaSuperior = cotaSuperior;
	}
	public ArrayList<Integer> getTareasSinAsignar() {
		return tareasSinAsignar;
	}
	public void setTareasSinAsignar(ArrayList<Integer> tareasSinAsignar) {
		this.tareasSinAsignar = tareasSinAsignar;
	}
	public int[][] getCostes() {
		return costes;
	}
	public void setCostes(int[][] costes) {
		this.costes = costes;
	}
	public int getCosteReal() {
		return costeReal;
	}
	public void setCosteReal(int costeReal) {
		this.costeReal = costeReal;
	}
	private ArrayList<Integer> complecciones(Nodo nodo){
		return null;
	}
}
