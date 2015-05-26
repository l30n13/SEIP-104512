package com.android.tonmoy.sharedpreferrence;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends Activity {

    public static final String MyPREFERENCE = "MyPreference";
    public static final String Name = "nameKey";
    public static final String PhoneNo = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedPreferences;

    EditText name;
    EditText phoneNo;
    EditText email;
    CheckBox rememberMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        phoneNo = (EditText) findViewById(R.id.phoneNo);
        email = (EditText) findViewById(R.id.email);
        rememberMe = (CheckBox) findViewById(R.id.remember);
        sharedPreferences = getSharedPreferences(MyPREFERENCE, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Name) && sharedPreferences.contains(PhoneNo) && sharedPreferences.contains(Email)) {
            name.setText(sharedPreferences.getString(Name, ""));
            phoneNo.setText(sharedPreferences.getString(PhoneNo, ""));
            email.setText(sharedPreferences.getString(Email, ""));
        }

    }

    public void saveMe(View view) {

        if (rememberMe.isChecked()) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Name, name.getText().toString());
            editor.putString(PhoneNo, phoneNo.getText().toString());
            editor.putString(Email, email.getText().toString());

            editor.commit();
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Name, "");
            editor.putString(PhoneNo, "");
            editor.putString(Email, "");

            editor.commit();
        }
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
