package com.leon.android.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Home extends ActionBarActivity {

    Button One;
    Button Two;
    Button Three;
    Button Four;
    Button Five;
    Button Six;
    Button Seven;
    Button Eight;
    Button Nine;
    Button Zero;
    Button Dot;
    Button Plus;
    Button Minus;
    Button Mul;
    Button Div;
    Button Equal;
    Button Clear;
    TextView ans;

    double number = 0;
    String getNumber = "";

    public void showInAns() {
        ans = (TextView) findViewById(R.id.ans);
        ans.setText(getNumber);
    }

    public void one(View view) {
        getNumber += "1";
        showInAns();
    }

    public void two(View view) {
        getNumber += "2";
        showInAns();
    }

    public void three(View view) {
        getNumber += "3";
        showInAns();
    }

    public void four(View view) {
        getNumber += "4";
        showInAns();
    }

    public void five(View view) {
        getNumber += "5";
        showInAns();
    }

    public void six(View view) {
        getNumber += "6";
        showInAns();
    }

    public void seven(View view) {
        getNumber += "7";
        showInAns();
    }

    public void eight(View view) {
        getNumber += "8";
        showInAns();
    }

    public void nine(View view) {
        getNumber += "9";
        showInAns();
    }

    public void zero(View view) {
        getNumber += "0";
        showInAns();
    }

    public void dot(View view) {
        getNumber += ".";
        showInAns();
    }

    public void plus(View view) {
        number = Double.parseDouble(getNumber);
    }

    public void minus(View view) {

    }

    public void mul(View view) {

    }

    public void div(View view) {

    }

    public void equal(View view) {

    }

    public void clear(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
