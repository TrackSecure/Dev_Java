package school.sptech;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

public class Main implements RequestHandler<S3Event, String> {
    private final AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
    private static final String DESTINATION_BUCKET = "trusted-stocks-teste";

    @Override
    public String handleRequest(S3Event s3Event, Context context) {
        String sourceBucket = s3Event.getRecords().get(0).getS3().getBucket().getName();
        String sourceKey = s3Event.getRecords().get(0).getS3().getObject().getKey();
        InputStream s3InputStream = s3Client.getObject(sourceBucket, sourceKey).getObjectContent();
        try {
            if (sourceKey.contains(".json")) {
                TrackSecureMapper mapper = new TrackSecureMapper();
                List<TrackSecure> track = mapper.map(s3InputStream);
                CSVWriter csvWriter = new CSVWriter();
                ByteArrayOutputStream csvOutputStream = csvWriter.writeCsv(track);
                InputStream csvInputStream = new ByteArrayInputStream(csvOutputStream.toByteArray());

                s3Client.putObject(DESTINATION_BUCKET, sourceKey.replace(".json", ".csv"), csvInputStream, null);
                return "Sucesso no processamento";
            } else {
                CSVSplitter csvSplitter = new CSVSplitter();
                csvSplitter.writeCsv(s3InputStream, DESTINATION_BUCKET, s3Client);

                return "Sucesso no processamento";
            }
        } catch (Exception e) {
            context.getLogger().log("Erro: " + e.getMessage());
            return "Erro no processamento";
        }
    }
}