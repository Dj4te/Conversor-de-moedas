package br.dj4te.com.conversor.metodos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private String chave = "1eb9c4a2dcd7468808f97e53";

    public Moedas conversorMoeda (String moedaBase, String moedaDestino, double valor) {
        String enderecoBusca =  "https://v6.exchangerate-api.com/v6/" + chave + "/pair/" + moedaBase + "/" + moedaDestino + "/" + valor;

        try {
            URI uri = URI.create(enderecoBusca);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpResponse response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            Moedas moedasConvertidas = gson.fromJson((String) response.body(), Moedas.class);
            System.out.printf("%-181s: %s\n", "Moeda de origem", moedasConvertidas.getMoedaBase());
            System.out.printf("%-18s: %s\n", "Moeda de destino", moedasConvertidas.getMoedaDestino());
            System.out.printf("%-18s: %.2f\n", "Quantidade", valor);
            System.out.printf("%-18s: %.4f\n", "Taxa de câmbio", moedasConvertidas.getCambio());
            System.out.printf("%-18s: %.2f\n", "Valor convertido", moedasConvertidas.getValorConversao());

            return moedasConvertidas;
        } catch (IOException e) {
            throw new RuntimeException("Erro I/O de acesso a API.");
        } catch (InterruptedException e) {
            throw new RuntimeException("A solicitação foi interrompida");
        }
    }
}
