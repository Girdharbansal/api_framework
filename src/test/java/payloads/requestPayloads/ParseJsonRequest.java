package payloads.requestPayloads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParseJsonRequest {

private static String resouceFilePath ="src/test/resources/payloads/request/";
    public static String requestPayload(String fileName) throws IOException {
        String completePath = resouceFilePath +fileName;
        return new String(Files.readAllBytes(Paths.get(completePath)));
    }
}
