import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);

		int parametroUm = 0;
		int parametroDois = 0;

		do {
            System.out.println("Digite o primeiro par�metro");
            try {
                parametroUm = terminal.nextInt();
            } catch (InputMismatchException e) {
                terminal.nextLine();
                System.out.println("Caractere inv�lido. Digite os par�metros novamente.");
                continue;
            }
            
            System.out.println("Digite o segundo par�metro");
            try {
                parametroDois = terminal.nextInt();
            } catch (InputMismatchException e) {
                terminal.nextLine();
                System.out.println("Caractere inv�lido. Digite os par�metros novamente.");
                continue;
            }

            try {
                contar(parametroUm, parametroDois);
            } catch (ParametrosInvalidosException e) {
                System.out.println(e.getMessage());
                System.out.println("Digite os par�metros novamente.");
            }
        } while (parametroUm >= parametroDois);

        terminal.close();
    }

	static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
		if (parametroUm >= parametroDois) {
			throw new ParametrosInvalidosException("O segundo par�metro deve ser maior que o primeiro");
		}

		int contagem = parametroDois - parametroUm;

		for (int i = 1; i <= contagem; i++) {
			System.out.println("Imprimindo o n�mero " + i);
		}
	}
}