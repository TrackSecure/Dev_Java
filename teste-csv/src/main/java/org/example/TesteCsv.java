package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class TesteCsv {
    public String linha;
    public BufferedReader csvReader;
    public PrintWriter csvWriter;

    public void writeCsv(String csv) throws IOException {
        csvReader = new BufferedReader(new FileReader(csv, Charset.forName("Cp1252")));
        csvWriter = new PrintWriter("LinhaAzul.csv", Charset.forName("Cp1252"));

        for (int i = 1; i < 93; i++) {
            linha = csvReader.readLine();
            if (i == 6 || i == 36 || i == 57 || i == 81) {
                linha = linha.substring(0, linha.lastIndexOf(";")-7);
            } else {
                linha = linha.substring(0, linha.lastIndexOf(";")-2);
            }
            if (i == 36) {
                csvWriter.close();
                csvWriter = new PrintWriter("LinhaVerde.csv", Charset.forName("Cp1252"));
            } else if (i == 57) {
                csvWriter.close();
                csvWriter = new PrintWriter("LinhaVermelha.csv", Charset.forName("Cp1252"));
            } else if (i == 81) {
                csvWriter.close();
                csvWriter = new PrintWriter("LinhaPrata.csv", Charset.forName("Cp1252"));
            }
            if ((i > 5 && i < 30) || (i > 35 && i < 51) || (i > 56 && i < 76) || i > 80) {
                csvWriter.println(linha);
            }
        }
        csvWriter.close();
        csvReader.close();
    }
}

