package src;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public String cantidadNormalizada(double cant){
        String cantNormalizada=String.valueOf(cant);
        if(cant>=10000000) {
            cantNormalizada =  String.valueOf((long) cant);
        }
        return cantNormalizada;
    }

    Moneda hacerConversion(String monedaPrincipal,String monedaSecundaria,double cantidad) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/849e69ac7d249e2b62744bed/pair" + "/" + monedaPrincipal +
                "/" + monedaSecundaria + "/" + cantidadNormalizada(cantidad));

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
