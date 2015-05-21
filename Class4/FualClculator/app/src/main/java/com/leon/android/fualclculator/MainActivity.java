package com.leon.android.fualclculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    EditText distance;
    EditText fualEfficiency;
    EditText tk;
    TextView fualCost;
    TextView requiredAmount;
    Button calculate;

    int totalCost;
    int amountInGal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distance = (EditText) findViewById(R.id.distance);
        fualEfficiency = (EditText) findViewById(R.id.fualEfficiency);
        tk = (EditText) findViewById(R.id.tk);
        calculate = (Button) findViewById(R.id.calculate);
        fualCost = (TextView) findViewById(R.id.fualCost);
        requiredAmount = (EditText) findViewById(R.id.requiredAmount);


        calculate.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                int a = Integer.parseInt(distance.getText().toString());
                int b = Integer.parseInt(fualEfficiency.getText().toString());
                int c = Integer.parseInt(tk.getText().toString());

                amountInGal = a / b;
                totalCost = amountInGal * c;

                fualCost.setText(String.valueOf(totalCost));
                requiredAmount.setText(String.valueOf(amountInGal));

            }
        });

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
