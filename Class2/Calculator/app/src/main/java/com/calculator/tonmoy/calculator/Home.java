package com.calculator.tonmoy.calculator;

import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Home extends ActionBarActivity {

    String allNumber = "\0";
    double number = 0;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        answer = (TextView) findViewById(R.id.answer);
    }

    public void one(View view) {
        insert("1");
    }

    public void two(View view) {
        insert("2");
    }

    public void three(View view) {
        insert("3");
    }

    public void four(View view) {
        insert("4");
    }

    public void five(View view) {
        insert("5");
    }

    public void six(View view) {
        insert("6");
    }

    public void seven(View view) {
        insert("7");
    }

    public void eight(View view) {
        insert("8");
    }

    public void nine(View view) {
        insert("9");
    }

    public void zero(View view) {
        insert("0");
    }

    public void dot(View view) {
        insert(".");
    }

    public void plus(View view) {
        calculate('+');
    }

    public void minus(View view) {
        calculate('-');
    }

    public void mul(View view) {
        calculate('x');
    }

    public void div(View view) {
        calculate('/');
    }

    public void equal(View view) {
        calculate('=');
    }

    public void clear(View view) {
        allNumber = "\0";
        number = 0;
        answer.setText("0");
    }


    public void insert(String value) {
        allNumber += value;
        answer.setText(allNumber);
    }


    public void calculate(char operator) {
        switch (operator) {
            case '+':
                if (number == 0) {
                    numberIsZero(answer.getText().toString());
                } else {
                    numberIsNotZero(answer.getText().toString(), '+');
                }
                break;
            case '-':
                if (number == 0) {
                    numberIsZero(answer.getText().toString());
                } else {
                    numberIsNotZero(answer.getText().toString(), '-');
                }
                break;
            case 'x':
                if (number == 0) {
                    numberIsZero(answer.getText().toString());
                } else {
                    numberIsNotZero(answer.getText().toString(), 'x');
                }
                break;
            case '/':
                if (number == 0) {
                    numberIsZero(answer.getText().toString());
                } else {
                    numberIsNotZero(answer.getText().toString(), '/');
                }
                break;
            case '=':
                answer.setText(String.valueOf(number));
                break;
        }
    }

    public void numberIsZero(String n) {
        number = Double.parseDouble(n);
        allNumber = "\0";
    }

    public void numberIsNotZero(String n, Character op) {
        switch (op) {
            case '+':
                number += Double.parseDouble(n);
                answer.setText(String.valueOf(number));
                allNumber = "\0";
                break;
            case '-':
                number -= Double.parseDouble(n);
                answer.setText(String.valueOf(number));
                allNumber = "\0";
                break;
            case 'x':
                number *= Double.parseDouble(n);
                answer.setText(String.valueOf(number));
                allNumber = "\0";
                break;
            case '/':
                number /= Double.parseDouble(n);
                answer.setText(String.valueOf(number));
                allNumber = "\0";
                break;
        }
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
