package mobileclass.kylesblogviewer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Kyle on 9/2/2015.
 */
public class HttpGet {
    public static JSONObject getContenxtWeb(String urlS) {
        String pagina = "", devuelve = "";
        JSONArray jsonArray;
        ArrayList<JSONObject> joAry= new ArrayList<>();
        ArrayList<String> titleAry = new ArrayList<>();


        URL url;
        try {
            url = new URL(urlS);
            HttpURLConnection conexion = (HttpURLConnection) url
                    .openConnection();
            conexion.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                while (linea != null) {
                    pagina += linea;
                    linea = reader.readLine();
                }
                reader.close();

                devuelve = pagina;
            } else {
                conexion.disconnect();
                return null;
            }
            conexion.disconnect();

            jsonArray  = new JSONArray(devuelve); // json
            for (int i = 0; i < jsonArray.length(); i++) {
                titleAry.add(i, jsonArray.getJSONObject(i).getString("title"));
            }

            for (int i = 0; i < titleAry.size(); i++) {
                System.out.println(titleAry.get(i));
            }

            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        getContenxtWeb("http://www.kylefrisbie.com/api/blogposts");
    }
}

