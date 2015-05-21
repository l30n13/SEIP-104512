package com.leon.android.studentinfo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
EditText editName;
    EditText editEmail;
    EditText editRegNo;
    ListView listView;
    ArrayList<String> studentInfo=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=(EditText)findViewById(R.id.editNa);
        editEmail=(EditText)findViewById(R.id.editEma);
        editRegNo=(EditText)findViewById(R.id.editReg);
        listView=(ListView)findViewById(R.id.listView);
    }
public void saveButton(View view){
    String name=editName.getText().toString();
    String email=editEmail.getText().toString();
    String regNo=editRegNo.getText().toString();
    String sum=name+ " " + email+" "+ regNo+" ";
    studentInfo.add(sum);
}
public void showButton(View view){
    ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,studentInfo);
    listView.setAdapter(arrayAdapter);
}


}
