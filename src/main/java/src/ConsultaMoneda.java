package src;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    Moneda hacerConversion(String monedaPrincipal,String monedaSecundaria,double cantidad) {

        String cantidadNormalizada = String.format("%.0f", cantidad);

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/849e69ac7d249e2b62744bed/pair" + "/" + monedaPrincipal +
                "/" + monedaSecundaria + "/" + cantidadNormalizada);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
            return new Gson().fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("Moneda no encontrada");
        }

    }
}
