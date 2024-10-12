import br.dj4te.com.conversor.metodos.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String moedaBase = "";
        String moedaDestino = "";
        double valorConversao;
        Conversor conversor = new Conversor();
        List<Moedas> listaConversoes = new ArrayList<>();

        System.out.println("Bem vindo ao Conversor de moedas do GUi!");
        System.out.println("""
                Digite: 1 - iniciar nova conversãao;
                        0 - sair.
                """);
        var opcao = scanner.nextInt();

        while (opcao != 0){
            System.out.println("""
                    Modedas disponíveis para conversão:
                    Dinar Kwait - KWD
                    LIBRA ESTERLINA - GBP
                    EURO - EUR
                    FRANCO SUIÇO - CHF
                    DOLAR - USD
                    REAL - BRL
                    PESO ARGENTINO - ARS
                    """);

            System.out.println("Digite a sigla da moeda base: ");
            moedaBase = scanner.next().toUpperCase();

            System.out.println("Digite a sigla da modeda a ser convertida: ");
            moedaDestino = scanner.next().toUpperCase();

            System.out.println("Digite o valor total da moeda base a ser convertida:");
            valorConversao = scanner.nextDouble();

            Moedas conversao = conversor.conversorMoeda(moedaBase, moedaDestino, valorConversao);
            listaConversoes.add(conversao);

            System.out.print("Deseja fazer outra conversão? (1 - Sim, 0 - Não): ");
            opcao = scanner.nextInt();

        }
        try {

            System.out.println(listaConversoes);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(listaConversoes);
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação.");
        }
    }
}
