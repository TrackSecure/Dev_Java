package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String csv = "Entrada de Passageiros por Estação - Média Dias Úteis - 2024_6.csv";
        TesteCsv testeCsv = new TesteCsv();
        try {
            testeCsv.writeCsv(csv);
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}