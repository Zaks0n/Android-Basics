package com.example.sqllitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, college;
    CoreDatabase coreDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        college = findViewById(R.id.college);
        coreDatabase = new CoreDatabase(this);
    }

    public void doSave(View view) {
        coreDatabase.insertData(name.getText().toString(), college.getText().toString());
    }

    public void doLoad(View view) {
       coreDatabase.getAll();
    }


}
