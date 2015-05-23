package com.android.tonmoy.multipleintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    public void goUrl(View view) {
        String url = "https://www.google.com";

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);

    }

    public void call(View view) {
        Intent call = new Intent(this, Call.class);
        startActivity(call);
    }

    public void SMS(View view) {
        Intent call = new Intent(this, SendSMS.class);
        startActivity(call);
    }

    public void mail(View view) {
        Intent mail = new Intent(this, SendMail.class);
        startActivity(mail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
