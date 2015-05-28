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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {

    public static final String MyPREFERENCE = "MyProfile";
    public static final String Name = "nameKey";
    public static final String Birthday = "birthdayKey";
    public static final String Gender = "genderKey";
    SharedPreferences sharedPreferences;

    EditText name;
    TextView birthday;
    RadioGroup gender;
    RadioButton genderFinal;
    RadioButton male;
    RadioButton female;

    Calendar calendar;
    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        birthday = (TextView) findViewById(R.id.birthday);
        gender = (RadioGroup) findViewById(R.id.gender);

        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);

        sharedPreferences = getSharedPreferences(MyPREFERENCE, Context.MODE_PRIVATE);

        calendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.YEAR, year);
                updateLabel();
            }
        };

        retrieveData();
    }

    private void updateLabel() {
        String format = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);
        birthday.setText(simpleDateFormat.format(calendar.getTime()));
    }

    public void retrieveData() {

        if (sharedPreferences.contains(Name) && sharedPreferences.contains(Birthday)) {
            name.setText(sharedPreferences.getString(Name, ""));
            birthday.setText(sharedPreferences.getString(Birthday, ""));

            if (male.getId() == sharedPreferences.getInt(Gender, 1)) {
                male.setChecked(true);
            } else {
                female.setChecked(true);
            }
        }
    }

    public void setDate(View view) {
        new DatePickerDialog(MainActivity.this, date, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void saveAll(View view) {
        int selectedId = gender.getCheckedRadioButtonId();
        genderFinal = (RadioButton) findViewById(selectedId);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Name, name.getText().toString());
        editor.putString(Birthday, birthday.getText().toString());
        editor.putInt(Gender, gender.getCheckedRadioButtonId());

        editor.commit();

        //Toast.makeText(getApplicationContext(), "This is test " + selectedId, Toast.LENGTH_SHORT).show();
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
