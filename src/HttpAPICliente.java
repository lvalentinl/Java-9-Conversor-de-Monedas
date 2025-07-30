import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpAPICliente {
    private static final String API_KEY = "22c41bf25a12103b39a44688";
    private static final HttpClient client = HttpClient.newHttpClient();

    //GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT
    public static TiposDeCambio obtenerTasaCambio(String cambio, String destino, double cantidad) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + cambio + "/" + destino + "/" + cantidad;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.fromJson(response.body(), TiposDeCambio.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error en la conexión con la API: " + e.getMessage());
        }
    }

}
