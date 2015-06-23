package com.faravy.bitmtrainer401.webserviceexample;

import android.app.Application;
import android.app.DownloadManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by BITM Trainer 401 on 16/6/2015.
 */
public class ServiceHelper extends Application {
    private RequestQueue requestQueue;
    private static ServiceHelper instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized ServiceHelper getInstance() {
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public void addToRequest(Request req) {
        getRequestQueue().add(req);
    }

}

