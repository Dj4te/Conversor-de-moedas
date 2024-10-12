package br.dj4te.com.conversor.metodos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {
    public void salvaJson(List<Moedas> listaConversoes) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter( "Conversoes.json");
        escrita.write(gson.toJson(listaConversoes));
        escrita.close();
    }
}
