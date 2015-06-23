package com.faravy.bitmtrainer401.webserviceexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.StringRequest;

import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
    ListView listView;
    JSONArray jArray;
    ArrayList<String> nameList;
    ArrayList<String> biographyList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        nameList = new ArrayList<>();
        showService();
    }

    private void showService() {
        StringRequest stringRequest = new StringRequest(Method.GET, "http://apps.mediasoftbd.com/dc/Api/Table/GetTableByAreaID?areaID=1",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            jArray = new JSONArray(response);
                            for (int i = 0; i < jArray.length(); i++) {
                                String tableName = jArray.getJSONObject(i).getString("TableName");
                                nameList.add(tableName);
                                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, nameList);
                                listView.setAdapter(adapter);
                            }
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
}



