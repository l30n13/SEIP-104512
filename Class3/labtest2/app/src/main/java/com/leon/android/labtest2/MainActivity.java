package com.leon.android.labtest2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    //Component Declaration
    EditText studentName;
    EditText e_mail;
    EditText regNo;

    Button display;
    Button save;

    ListView listView;

    ArrayList temporaryStorage=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Component Initialization

        studentName=(EditText)findViewById(R.id.studentName);
        e_mail=(EditText)findViewById(R.id.e_mail);
        regNo=(EditText)findViewById(R.id.regNo);

        display=(Button)findViewById(R.id.display);
        save=(Button)findViewById(R.id.save);

        listView=(ListView)findViewById(R.id.listView);

    }
    public void Save(View v){
        temporaryStorage.add("Name"+studentName.getText().toString());
        temporaryStorage.add("E_mail: "+e_mail.getText().toString());
        temporaryStorage.add("Registration No:"+regNo.getText().toString());
    }
    public void Display(View v){
        ArrayAdapter <String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,temporaryStorage);
        listView.setAdapter(adapter);
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
