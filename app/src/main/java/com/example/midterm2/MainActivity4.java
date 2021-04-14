package com.example.midterm2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    DatabaseHelper db;
    EditText deleteid;
    String getIdToDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        db = new DatabaseHelper(this);
        deleteid = (EditText)findViewById(R.id.idtodelete);
        Button delete = (Button)findViewById(R.id.delete);
        Button getdata = (Button)findViewById(R.id.getData);
        Button gotom1 = (Button)findViewById(R.id.gotom1);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIdToDelete = deleteid.getText().toString();
                db.deletedata(getIdToDelete);
                Toast.makeText(MainActivity4.this,"Successful Delete",Toast.LENGTH_LONG).show();
            }
        });
        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cur = db.viewData();
                StringBuffer buffer = new StringBuffer(); while(cur.moveToNext()) {
                    buffer.append("ID: " + cur.getString(0)+ "\n");
                    buffer.append("Name: " + cur.getString(1)+ "\n");
                    buffer.append("Email: " + cur.getString(2)+ "\n\n");
                    buffer.append("Number: " + cur.getString(3)+ "\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this); builder.setCancelable(true);
                builder.setTitle("All products");
                builder.setMessage(buffer.toString());
                builder.show();
                Toast.makeText(MainActivity4.this,"Successful View",Toast.LENGTH_LONG).show();
            }
        });
        gotom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this,MainActivity2.class));
            }
        });

    }
}