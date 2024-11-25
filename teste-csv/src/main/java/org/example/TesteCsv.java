package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteCsv {
    private String linha;
    private BufferedReader csvReader;
    private PrintWriter csvWriter;

    public void writeCsv(String csv) throws IOException {
        csvReader = new BufferedReader(new FileReader(csv, Charset.forName("Cp1252")));
        csvWriter = new PrintWriter("LinhaAzul.csv", StandardCharsets.UTF_8);

        for (int i = 1; i < 93; i++) {
            linha = csvReader.readLine();
            if (i == 6 || i == 36 || i == 57 || i == 81) {
                linha = linha.substring(0, linha.lastIndexOf(";")-8);
            } else {
                linha = linha.substring(0, linha.lastIndexOf(";")-2);
            }
            linha = linha.replace("¹", "");
            linha = linha.replace("²", "");
            linha = linha.replace("é2", "é");
            if (i == 36) {
                csvWriter.close();
                csvWriter = new PrintWriter("LinhaVerde.csv", StandardCharsets.UTF_8);
            } else if (i == 57) {
                csvWriter.close();
                csvWriter = new PrintWriter("LinhaVermelha.csv", StandardCharsets.UTF_8);
            } else if (i == 81) {
                csvWriter.close();
                csvWriter = new PrintWriter("LinhaPrata.csv", StandardCharsets.UTF_8);
            }
            if ((i > 5 && i < 30) || (i > 35 && i < 51) || (i > 56 && i < 76) || i > 80) {
                csvWriter.println(linha);
            }
        }
        csvWriter.close();
        csvReader.close();
    }
}

