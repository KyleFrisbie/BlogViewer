package com.kylefrisbie.blogviewer.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class ListActivity extends ActionBarActivity {



    protected static ArrayList<String> getContenxtWeb() {
        String pagina = "", devuelve = "";
        JSONArray jsonArray;
        ArrayList<JSONObject> joAry= new ArrayList<JSONObject>();
        ArrayList<String> titleAry = new ArrayList<String>();


        URL url;
        try {
            url = new URL("http://www.kylefrisbie.com/api/blogposts");
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

            return titleAry;
        } catch (Exception ex) {
            return titleAry;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        Log.w("TAG", "entering getContenxtWeb()");

//        ListView myListView = (ListView)findViewById(R.id.listView);
//        adapter = new CustomAdapter(getActivity(), R.layout.row, myStringArray1);
//        myListView.setAdapter(new );

        getContenxtWeb();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_list, container, false);
            return rootView;
        }
    }
}
