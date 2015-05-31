package com.android.tonmoy.exam;

import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;


public class MainActivity extends ActionBarActivity {

    EditText name;
    EditText email;
    EditText regNo;
    ListView savedData;
    private final ArrayList<DataBase> saveDataBases = new ArrayList<>();
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        regNo = (EditText) findViewById(R.id.regNo);
        savedData = (ListView) findViewById(R.id.savedData);

    }

    public void saveAllData(View view) {
        DataBase myDB = new DataBase();
        myDB.setData(name.getText().toString(), email.getText().toString(), regNo.getText().toString());
        saveDataBases.add(myDB);
    }

    public void showAll(View view) {

        ArrayList<String> value = new ArrayList<>();
        for (int i = 0; i < saveDataBases.size(); i++) {
            String[] a = saveDataBases.get(i).getData();
            value.add(a[0] + " " + a[1] + " " + a[2]);
        }

        listAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, value);
        savedData.setAdapter(listAdapter);

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
