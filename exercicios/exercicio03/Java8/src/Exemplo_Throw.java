// https://www.devmedia.com.br/trabalhando-com-excecoes-em-java/27601
// import java.util.InputMismatchException;
// import java.util.Scanner;


public class Exemplo_Throw {
	public static void saque(double valor) {
        if(valor > 400) {
            IllegalArgumentException erro = new IllegalArgumentException();
            throw erro;
        }else {
            System.out.println("Valor retirado da conta: R$" + valor);
        }
    }
     
    public static void main(String[] args) {
        saque(1500);
    }
}
