package com.leon.userdefine;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    public void showFullName(View view) {
        ShowName name = new ShowName();

        EditText FirstName = (EditText) findViewById(R.id.firstName);
        EditText MiddleName = (EditText) findViewById(R.id.middleName);
        EditText LastName = (EditText) findViewById(R.id.lastName);
        TextView ShowName = (TextView) findViewById(R.id.showName);

        name.setFirstName(FirstName.getText().toString());
        name.setMiddletName(MiddleName.getText().toString());
        name.setLastName(LastName.getText().toString());

        ShowName.setText(name.getFirstName() + " " + name.getMiddletName() + " " + name.getLastName());
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
