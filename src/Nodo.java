
public class Nodo {
	private int beneficio;
	private int beneficioO;
	private int paso;
	private int[] PastelerosAsignados;
	private int[][] TablaBeneficios;

	public int getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(int beneficio) {
		this.beneficio = beneficio;
	}

	public int getBeneficioO() {
		return beneficioO;
	}

	public void setBeneficioO(int beneficioO) {
		this.beneficioO = beneficioO;
	}

	public int getPaso() {
		return paso;
	}

	public void setPaso(int paso) {
		this.paso = paso;
	}

	public int[] getPastelerosAsignados() {
		return PastelerosAsignados;
	}

	public void setPastelerosAsignados(int[] pastelerosAsignados) {
		PastelerosAsignados = pastelerosAsignados;
	}

	public int[][] getTablaBeneficios() {
		return TablaBeneficios;
	}

	public void setTablaBenecifios(int[][] tablaBeneficios) {
		TablaBeneficios = tablaBeneficios;
	}

	public Nodo(int beneficio, int beneficioO, int paso, int[] pastelerosAsignados, int[][] tablaBeneficios) {
		super();
		this.beneficio = beneficio;
		this.beneficioO = beneficioO;
		this.paso = paso;
		PastelerosAsignados = pastelerosAsignados;
		TablaBeneficios = tablaBeneficios;
	}

}
