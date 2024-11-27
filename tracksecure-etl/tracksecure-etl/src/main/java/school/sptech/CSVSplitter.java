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
        BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(csvOutputStream, StandardCharsets.UTF_8));
        InputStream csvInputStream;
        String nomeArquivo = null;

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
            switch (i) {
                case 36:
                    nomeArquivo = "LinhaAzul.csv";
                    break;
                case 57:
                    nomeArquivo = "LinhaVerde.csv";
                    break;
                case 81:
                    nomeArquivo = "LinhaVermelha.csv";
                    break;
                case 93:
                    nomeArquivo = "LinhaPrata.csv";
                    break;
            }
            if (i == 36 || i == 57 || i == 81 || i == 93) {
                csvWriter.flush();
                csvWriter.close();
                csvInputStream = new ByteArrayInputStream(csvOutputStream.toByteArray());
                client.putObject(bucket, nomeArquivo, csvInputStream, null);
                csvOutputStream = new ByteArrayOutputStream();
                csvWriter = new BufferedWriter(new OutputStreamWriter(csvOutputStream, StandardCharsets.UTF_8));
            }
            if ((i > 5 && i < 30) || (i > 35 && i < 51) || (i > 56 && i < 76) || i > 80) {
                csvWriter.write(linha + "\n");
            }
        }
        csvWriter.flush();
        csvWriter.close();
        csvReader.close();
    }
}
