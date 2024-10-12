package br.dj4te.com.conversor.metodos;

import com.google.gson.annotations.SerializedName;

public class Moedas {
    @SerializedName("base_code")
    private String moedaBase;
    @SerializedName("target_code")
    private String moedaDestino;
    @SerializedName("conversion_rate")
    private double cambio;
    @SerializedName("conversion_result")
    private double valorConversao;

    public String getMoedaBase() {
        return moedaBase;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }

    public double getCambio() {
        return cambio;
    }

    public double getValorConversao() {
        return valorConversao;
    }

    public String toString() {
        return " Moeda base: " + getMoedaBase() + " Moeda Destino: " + getMoedaDestino() + " Valor conversão: " + getValorConversao();
    }
}
