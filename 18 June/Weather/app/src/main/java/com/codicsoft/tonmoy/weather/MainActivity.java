package com.codicsoft.tonmoy.weather;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    ImageView weather;
    EditText search;
    TextView cityName;
    TextView maxTemp;
    TextView minTemp;

    JSONObject jsonObject;
    JSONArray jArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weather = (ImageView) findViewById(R.id.weather);
        search = (EditText) findViewById(R.id.search);
        cityName = (TextView) findViewById(R.id.cityName);
        maxTemp = (TextView) findViewById(R.id.maxTemp);
        minTemp = (TextView) findViewById(R.id.minTemp);

        startWeatherService("http://api.openweathermap.org/data/2.5/find?q=Dhaka&units=metric");

    }

    private void startWeatherService(String url) {
        StringRequest stringRequest = new StringRequest(Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            jsonObject = new JSONObject(response);
                            jArray = jsonObject.getJSONArray("list");
                            jsonObject = jArray.getJSONObject(0);
                            getCityOrCountryName(jsonObject);

                            jsonObject = jsonObject.getJSONObject("main");
                            String mintemp = jsonObject.getString("temp_min");
                            String maxtemp = jsonObject.getString("temp_max");
                            maxTemp.setText(maxtemp);
                            minTemp.setText(mintemp);
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        ServiceHelper.getInstance().addToRequest(stringRequest);
    }

    private void getCityOrCountryName(JSONObject jsonObject) throws JSONException {
        String cityname = jsonObject.getString("name");
        cityName.setText(cityname);
        if (cityname.isEmpty()) {
            jsonObject = jsonObject.getJSONObject("sys");
            cityname = jsonObject.getString("country");
            cityName.setText(cityname);
        }
    }

    public void searchLocation(View view) {
        startWeatherService("http://api.openweathermap.org/data/2.5/find?q=" + search.getText() + "&units=metric");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
