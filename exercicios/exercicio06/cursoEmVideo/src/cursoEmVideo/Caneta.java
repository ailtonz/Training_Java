package cursoEmVideo;

public class Caneta {
	public String modelo;
	public String cor;
	public float ponta;
	protected int carga;
	private boolean tampada;
	
	public void status() {
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Uma caneta: " + this.cor);
		System.out.println("Ponta: "+ this.ponta);
		System.out.println("Carga: " + this.carga);
		System.out.println("Está Tampada? " + this.tampada);
	}
	
	public void rabiscar() {
		if(this.tampada) {
			System.out.println("ERROR! não posso rabiscar");
		}else {
			System.out.println("Rabiscando");
		}
	}
	
	public void tampar() {
		this.tampada = true;
	}
	
	public void destampar() {
		this.tampada = false;
	}
}
