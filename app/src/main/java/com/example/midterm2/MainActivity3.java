package com.example.midterm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    DatabaseHelper db;
    EditText searchid;
    String getsearchid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button search = (Button)findViewById(R.id.srcbtn);
        Button m1 = (Button) findViewById(R.id.mainactivity1);
        searchid = (EditText)findViewById(R.id.idtosearch);
        db = new DatabaseHelper(this);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getsearchid = searchid.getText().toString();
                Cursor cursor = db.getSpecificResult(getsearchid);
                String CID = cursor.getString(0);
                String CName = cursor.getString(1);
                String CEmail = cursor.getString(2);
                String CNumber = cursor.getString(3);
                Toast.makeText(MainActivity3.this, CID + ", " + CName + ", " + CEmail + " ," +CNumber , Toast.LENGTH_LONG).show();

            }
        });
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this,MainActivity2.class));
            }
        });


    }
}