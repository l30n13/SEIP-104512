package com.codicsoft.tonmoy.jsonpersing;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    JSONArray jArray;
    ListView poetList;
    ArrayList<String> nameList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poetList = (ListView) findViewById(R.id.poetList);
        nameList = new ArrayList<>();

        showService();
    }

    private void showService() {
        StringRequest stringRequest = new StringRequest(Method.GET, "http://nerdcastlebd.com/web_service/banglapoems/index.php/poets/all/format/json",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            jArray = jsonObject.getJSONArray("poets");
                            for (int i = 0; i < jArray.length(); i++) {
                                String tableName = jArray.getJSONObject(i).getString("name");
                                nameList.add(tableName);
                                adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, nameList);
                            }
                            poetList.setAdapter(adapter);
                        } catch (JSONException e) {

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        ServiceHelper.getInstance().addToRequest(stringRequest);
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
