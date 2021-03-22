
import java.util.Scanner;

public class TestaEnergetico {

    public static void main(String[] args) {

        //Variáveis do Sistema
        Scanner entrada = new Scanner(System.in);
        String nomeSuper, continua = "S";
        int qtdComprada;
        double valorEnergetico = 4.50;
        double total, totalGeral, desconto = 0;
        double icms = 0, ipi = 0, pis = 0, cofins = 0, totalImpostos, totalMercadoria;

        while (continua.equalsIgnoreCase("S")) {

            energetico.exibeCabecalho();  // Invoca método para exibir o cabeçalho inicial + Mensagem de Desconto de 10%.

            System.out.println("Digite o nome do supermercado :");
            nomeSuper = entrada.next();     // Captura nome do Supermercado
            entrada.nextLine();

            System.out.println("Digite a quantidade de energético(s):");
            qtdComprada = entrada.nextInt();    // Captura quantidade de energético comprada.

            totalImpostos = icms + ipi + pis + cofins;
            totalMercadoria = qtdComprada * valorEnergetico;
            total = valorEnergetico * qtdComprada + totalImpostos;
            totalGeral = totalImpostos + totalMercadoria;

            // Aqui é invocado método exibirSaida, que já vem formatado lá da classe energetico
            energetico.exibeSaida(nomeSuper, qtdComprada, valorEnergetico, icms, ipi, pis, cofins, totalImpostos, totalMercadoria, total, totalGeral, desconto);
            System.out.println("                                                                                                                              ");
            System.out.println(" DESEJA CONTINUAR?");
            System.out.println("   S[SIM] N[NÃO] ");
            continua = entrada.next();

        }
        System.out.println("===============================");
        System.out.println("##    PROGRAMA ENCERRADO     ##");
        System.out.println("===============================");
    }
}


