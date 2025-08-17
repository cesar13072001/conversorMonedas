package org.caz.api;

import com.google.gson.Gson;
import org.caz.model.CodigoResponse;
import org.caz.model.ConversionResponse;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ConsultaAPI {

    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "TU_API";




    public ConversionResponse consultaConversion(String base, String destino, double monto) {
        try {
            // URL con la consulta
            String url_str = URL_BASE + API_KEY + "/pair/" +base+ "/" + destino + "/" + monto;
            URL url = new URL(url_str);

            // Conexión HTTP
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Usando Gson para convertir JSON en objeto
            Gson gson = new Gson();
            ConversionResponse response = gson.fromJson(
                    new InputStreamReader((InputStream) request.getContent()),
                    ConversionResponse.class
            );

            return response;
        }  catch (IOException e) {
            // Error de red, sin internet o API caída
            System.out.println("No se pudo conectar con el servidor. Verifique su conexión a internet.");
        } catch (Exception e) {
            // Error genérico
            System.out.println("Ocurrió un error al procesar la consulta.");
        }
        return null;
    }

    public ArrayList<ArrayList<String>> consultaMonedas() {
        try {
            // URL con la consulta
            String url_str = URL_BASE + API_KEY + "/codes/";
            URL url = new URL(url_str);

            // Conexión HTTP
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Usando Gson para convertir JSON en objeto
            Gson gson = new Gson();
            CodigoResponse response = gson.fromJson(
                    new InputStreamReader((InputStream) request.getContent()),
                    CodigoResponse.class
            );

            return response.supported_codes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
