package com.android.tonmoy.personaldetails;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {

    public static final String MyPREFERENCE = "MyPreference";
    public static final String Name = "nameKey";
    public static final String Birthday = "birthdayKey";
    public static final String Gender = "genderKey";
    SharedPreferences sharedPreferences;

    EditText name;
    TextView birthday;
    RadioGroup gender;
    RadioButton genderFinal;

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        birthday = (TextView) findViewById(R.id.birthday);

        dateView = (TextView) findViewById(R.id.birthday);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);

        sharedPreferences = getSharedPreferences(MyPREFERENCE, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(Name)) {
            name.setText(sharedPreferences.getString(Name, ""));
            birthday.setText(sharedPreferences.getString(Birthday, ""));
            //name.setText(sharedPreferences.getString(Name,""));
        }

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker arg0, int year, int month, int day) {
            showDate(year, month + 1, day);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }

    public void saveAll(View view) {
        int selectedId = gender.getCheckedRadioButtonId();
        genderFinal = (RadioButton) findViewById(selectedId);
        Toast.makeText(getApplicationContext(), "This is test " + genderFinal.getText(), Toast.LENGTH_SHORT).show();
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
