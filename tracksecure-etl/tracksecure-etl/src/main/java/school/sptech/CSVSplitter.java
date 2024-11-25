package school.sptech;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CSVSplitter {
    private String linha;
    private BufferedReader csvReader;
    private PrintWriter csvWriter;

    public void writeCsv(InputStream inputStream, String bucket, AmazonS3 client) throws IOException {
        BufferedReader csvReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("Cp1252")));
        ByteArrayOutputStream csvOutputStream = new ByteArrayOutputStream();
        BufferedWriter csvWriterAzul = new BufferedWriter(new OutputStreamWriter(csvOutputStream, StandardCharsets.UTF_8));
        BufferedWriter csvWriterVerde = null;
        BufferedWriter csvWriterVermelho = null;
        BufferedWriter csvWriterPrata = null;
        InputStream csvInputStream;

        for (int i = 1; i <= 93; i++) {
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
                csvWriterAzul.flush();
                csvWriterAzul.close();
                csvInputStream = new ByteArrayInputStream(csvOutputStream.toByteArray());
                client.putObject(bucket, "LinhaAzul.csv", csvInputStream, null);
                csvOutputStream = new ByteArrayOutputStream();
                csvWriterVerde = new BufferedWriter(new OutputStreamWriter(csvOutputStream, StandardCharsets.UTF_8));
            } else if (i == 57) {
                csvWriterVerde.flush();
                csvWriterVerde.close();
                csvInputStream = new ByteArrayInputStream(csvOutputStream.toByteArray());
                client.putObject(bucket, "LinhaVerde.csv", csvInputStream, null);
                csvOutputStream = new ByteArrayOutputStream();
                csvWriterVermelho = new BufferedWriter(new OutputStreamWriter(csvOutputStream, StandardCharsets.UTF_8));
            } else if (i == 81) {
                csvWriterVermelho.flush();
                csvWriterVermelho.close();
                csvInputStream = new ByteArrayInputStream(csvOutputStream.toByteArray());
                client.putObject(bucket, "LinhaVermelha.csv", csvInputStream, null);
                csvOutputStream = new ByteArrayOutputStream();
                csvWriterPrata = new BufferedWriter(new OutputStreamWriter(csvOutputStream, StandardCharsets.UTF_8));
            } else if (i == 93) {
                csvWriterPrata.flush();
                csvWriterPrata.close();
                csvInputStream = new ByteArrayInputStream(csvOutputStream.toByteArray());
                client.putObject(bucket, "LinhaPrata.csv", csvInputStream, null);
            }
            if (i > 5 && i < 30) {
                csvWriterAzul.write(linha + "\n");
            } else if (i > 35 && i < 51) {
                csvWriterVerde.write(linha + "\n");
            } else if (i > 56 && i < 76) {
                csvWriterVermelho.write(linha + "\n");
            } else if (i > 80) {
                csvWriterPrata.write(linha + "\n");
            }
        }
        csvWriterPrata.flush();
        csvWriterPrata.close();
        csvReader.close();
    }
}
