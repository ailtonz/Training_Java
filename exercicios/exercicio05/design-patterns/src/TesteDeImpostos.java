//Como fazer códigos mais simples com Design Patterns Java I 
// https://www.youtube.com/watch?v=QgVIwrid_4E&t=160s

public class TesteDeImpostos {
	public static void main(String[] args) {
	Imposto iss = new ISS();
	Imposto icms = new ICMS();
	
	Orcamento orcamento = new Orcamento(500.0);

	CalculadorDeImpostos calculador = new CalculadorDeImpostos();
	
	calculador.realizaCalculo(orcamento, iss);
	calculador.realizaCalculo(orcamento, icms);
	
	
	}
}
