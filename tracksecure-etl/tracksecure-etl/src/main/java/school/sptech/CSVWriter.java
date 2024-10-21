package school.sptech;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CSVWriter {

    public ByteArrayOutputStream writeCsv(List<TrackSecure> track) throws IOException {
        // Criar um CSV em memória utilizando ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Maquina", "SO", "PorcentCPU", "FreqCPU", "UsoRAM", "PorcentRAM", "UsoDisco", "PorcentDisco"));

        // Processar e escrever cada objeto no CSV
        for (TrackSecure trackSecure : track) {
            csvPrinter.printRecord(
                    trackSecure.getMaquina(),
                    trackSecure.getSO(),
                    trackSecure.getPorcentCPU(),
                    trackSecure.getFreqCPU(),
                    trackSecure.getUsoRAM(),
                    trackSecure.getPorcentRAM(),
                    trackSecure.getUsoDisco(),
                    trackSecure.getPorcentDisco()
            );
        }

        // Fechar o CSV para garantir que todos os dados sejam escritos
        csvPrinter.flush();
        writer.close();

        // Retornar o ByteArrayOutputStream que contém o CSV gerado
        return outputStream;
    }
}
