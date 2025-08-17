package org.caz;

import com.google.gson.JsonParser;

import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultaAPI {

    public String ConsultaConversion(){
        try{

// Setting URL
            String url_str = "https://v6.exchangerate-api.com/v6/API_KEY/pair/USD/PEN/1000";

// Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

// Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

// Accessing object
            String req_result = jsonobj.get("result").getAsString();

        }catch (Exception e){

        }
    }
}
