// https://www.devmedia.com.br/trabalhando-com-excecoes-em-java/27601
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class ExemploDivisao {
     
    public static int calculaQuociente(int numerador, int denominador) throws ArithmeticException{
        return numerador / denominador;
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continua = true;
         
        do{
            try{
                System.out.print("Numerador: ");
                int numerador = sc.nextInt();
                 
                System.out.print("Denominador: ");
                int denominador = sc.nextInt();
                 
                int resultador = calculaQuociente(numerador, denominador);
                System.out.println("Resultado: "+resultador);
                 
                continua = false;
     
            }catch (InputMismatchException erro1) {
                System.err.println("N�o � permitido inserir letras, informe apenas n�meros inteiros!");
                sc.nextLine(); //descarta a entrada errada do usu�rio
            }catch(ArithmeticException erro2){
                System.err.println("O n�mero do divisor deve ser diferente de 0!");
            }finally{
                System.out.println("Execu��o do Finally!");
            }
        }while(continua);       
    }
}