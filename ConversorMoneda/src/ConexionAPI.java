import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionAPI {
    private String monedaBase;
    private String monedaDestino;
    private double cantidad;
    final private String key = "4c0bfb95c42208f8c572816b";

    public ConexionAPI(String monedaBase, String monedaDestino, double cantidad) {
        this.monedaDestino = monedaDestino;
        this.monedaBase = monedaBase;
        this.cantidad = cantidad;
    }

    public String consultaAPI() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccionAPI()))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);
        return json;
    }
    public String direccionAPI (){
        String direccion = "https://v6.exchangerate-api.com/v6/"+ key +"/pair/" +
                monedaBase + "/" + monedaDestino + "/" + cantidad;
        //System.out.println(direccion);
        return direccion;
    }

}
