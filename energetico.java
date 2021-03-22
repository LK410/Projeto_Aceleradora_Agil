
public class energetico {

    public static void exibeCabecalho() {
        System.out.println("================================");
        System.out.println("##  Energéticos  Accelerator  ##");
        System.out.println("================================");
        System.out.println("                        ");
        System.out.println(" ## ATENÇÃO!!! Na compra de 100 ou mais energéticos, GANHE 10% de desconto no TOTAL GERAL! ##");
        System.out.println("                        ");
    }

    public static void exibeSaida(String nomeSuper, int qtdComprada, double valorEnergetico, double icms, double ipi, double pis, double cofins, double totalImpostos, double totalMercadoria, double total, double totalGeral, double desconto) {

        System.out.println("                               ");
        System.out.println("=================================");
        System.out.println("##          SAÍDA              ##");
        System.out.println("=================================");
        System.out.println("                              ");
        System.out.println(" NOME DO SUPERMERCADO: " + nomeSuper);

        System.out.println(" QUANTIDADE DE ENERGÉTICO: " + qtdComprada + " unidade(s).");

        if (qtdComprada >= 100) {
            desconto = (totalGeral * 10) / 100;
            System.out.println(" PARABÉNS! VOCÊ RECEBERÁ  10% DE DESCONTO NO TOTAL GERAL! :)");
        } else {
            totalGeral = totalGeral;
            System.out.println(" VOCÊ NÃO RECEBERÁ 10% DE DESCONTO :(");
        }
        System.out.println("                        ");

        icms = energetico.calcularICMS(qtdComprada, valorEnergetico, icms);
        ipi = energetico.calcularIPI(qtdComprada, valorEnergetico, ipi);
        pis = energetico.calcularPIS(qtdComprada, valorEnergetico, pis);
        cofins = energetico.calcularCofins(qtdComprada, valorEnergetico, cofins);

        totalImpostos = icms + ipi + pis + cofins;
        totalMercadoria = qtdComprada * valorEnergetico;
        total = valorEnergetico * qtdComprada + totalImpostos;
        totalGeral = totalImpostos + totalMercadoria;

        // Saída com os valores dos impostos formatado com duas casas depois da virgula.
        System.out.printf(" ICMS: R$ %.2f %n", energetico.calcularICMS(qtdComprada, valorEnergetico, icms));
        System.out.printf(" IPI: R$ %.2f %n", energetico.calcularIPI(qtdComprada, valorEnergetico, ipi));
        System.out.printf(" PIS: R$ %.2f %n", energetico.calcularPIS(qtdComprada, valorEnergetico, pis));
        System.out.printf(" COFINS: R$ %.2f %n", energetico.calcularCofins(qtdComprada, valorEnergetico, cofins));
        System.out.printf(" TOTAL: R$ %.2f %n", energetico.totalizar(valorEnergetico, qtdComprada, totalImpostos, total));
        System.out.println("                           ");
        System.out.printf(" Total de Impostos : R$ %.2f %n", energetico.somarImpostos(icms, ipi, pis, cofins, totalImpostos));
        System.out.printf(" Total Mercadorias : R$ %.2f %n", energetico.totalMercadoria(qtdComprada, valorEnergetico, totalMercadoria));
        System.out.printf(" Total de Desconto : R$ %.2f %n", desconto);
        System.out.printf(" Total Geral : R$ %.2f %n ", energetico.totalGeral(totalImpostos, totalMercadoria, totalGeral, desconto));
    }

    /*Criação dos métodos que vão realizar os devidos cálculos de acordo com o imposto,
    levando em consideração os seus valores que foram apresentados no Projeto.
     */
    public static double calcularICMS(int qtdComprada, double valorEnergetico, double icms) {
        icms = qtdComprada * valorEnergetico * 18 / 100;
        return icms;
    }

    public static double calcularIPI(int qtdComprada, double valorEnergetico, double ipi) {
        ipi = qtdComprada * valorEnergetico * 4 / 100;
        return ipi;
    }

    public static double calcularPIS(int qtdComprada, double valorEnergetico, double pis) {
        pis = qtdComprada * valorEnergetico * 1.86 / 100;
        return pis;
    }

    public static double calcularCofins(int qtdComprada, double valorEnergetico, double cofins) {
        cofins = qtdComprada * valorEnergetico * 8.54 / 100;
        return cofins;
    }

    public static double somarImpostos(double icms, double ipi, double pis, double cofins, double totalImpostos) {
        totalImpostos = icms + ipi + pis + cofins;
        return totalImpostos;
    }

    public static double totalizar(double valorEnergetico, int qtdComprada, double totalImpostos, double total) {
        total = (valorEnergetico * qtdComprada) + totalImpostos;
        return total;
    }

    public static double totalMercadoria(int qtdComprada, double valorEnergetico, double totalMercadoria) {
        totalMercadoria = qtdComprada * valorEnergetico;
        return totalMercadoria;
    }

    public static double totalGeral(double totalImpostos, double totalMercadoria, double totalGeral, double desconto) {
        totalGeral = (totalImpostos + totalMercadoria) - desconto;
        return totalGeral;
    }

}
