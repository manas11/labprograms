package com.example.weather;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity
{
    TextView temperaturemin;
    TextView temperaturemax;
    TextView humidity;
    TextView weather;
    EditText city;
    ImageButton search;
    URL url2 = null;
    String url;
    String id;
    JSONObject data;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         search=findViewById(R.id.imageView);

search.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v){
    new jsoonp().execute();

    }
});


    }
    class jsoonp extends AsyncTask<String,String,JSONObject>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
temperaturemax=findViewById(R.id.maxtemp);
temperaturemin=findViewById(R.id.mintemp);
humidity=findViewById(R.id.humidity);
weather=findViewById(R.id.weather);
city=findViewById(R.id.city);
        }

        @Override
        protected JSONObject doInBackground(String... strings)
        {
            url="https://api.openweathermap.org/data/2.5/weather?q=";
            id="fbdc56e2ccbd299c460a6b9f6868907f";
            String ci = city.getText().toString();
            final String url1 = url + ci + "&APPID=" + id;
            try {
                url2 = new URL(url1);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                HttpURLConnection connection = (HttpURLConnection) url2.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                if (reader == null)
                    System.out.println("null !");
                StringBuilder json = new StringBuilder(1024);
                String temp = "";
                while ((temp = reader.readLine()) != null)
                    json.append(temp).append("\n");
                reader.close();
                data = new JSONObject(json.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override protected void onPostExecute(JSONObject object)
        {
            try {
                Double d;
                JSONObject main = data.getJSONObject("main");
                JSONArray jsonArray=data.getJSONArray("weather");
                weather.setText(jsonArray.getJSONObject(0).getString("description"));
                d= Double.valueOf(main.getString("temp_max"));
                d=d-273.15;
                int i;
                d+=0.005;
                i= (int) (d*100);
                Double b = Double.valueOf(i/100);
                String s = b.toString();
                temperaturemax.setText(s+ " C");
                d= Double.valueOf(main.getString("temp"));
                d=d-273.15;
                d+=0.005;
                i=(int)(d*100);
                b=Double.valueOf(i/100);
                s=b.toString();
                temperaturemin.setText(s+" C");
                humidity.setText(main.getString("humidity"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
