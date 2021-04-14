package com.example.midterm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText name,email,id,number;
    DatabaseHelper db;
    String getname,getemail,getnumber;
    String getId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button add = (Button)findViewById(R.id.add);
        Button m2 = (Button)findViewById(R.id.gotomainactivity2);
        Button m3 = (Button)findViewById(R.id.gotomainacitivty3);
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
        id = (EditText) findViewById(R.id.id);
        email = (EditText) findViewById(R.id.email);
        db = new DatabaseHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getname = name.getText().toString();
                getemail = email.getText().toString();
                getId = id.getText().toString();
                getnumber = number.getText().toString();
                if(!db.adduser(getId,getname,getemail,getnumber)){
                    Toast.makeText(MainActivity2.this,"Insertion Failed",Toast.LENGTH_LONG).show();
                } else{
                    db.adduser(getId,getname,getemail,getnumber);
                    Toast.makeText(MainActivity2.this,"Insertion Successful",Toast.LENGTH_LONG).show();
                }

            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity4.class));
            }
        });
    }
}