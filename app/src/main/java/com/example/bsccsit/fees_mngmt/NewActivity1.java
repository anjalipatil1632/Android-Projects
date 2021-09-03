package com.example.bsccsit.fees_mngmt;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class NewActivity1 extends AppCompatActivity {
    Button login,cancel;
    EditText usrnm,password;

    Databasehelpera mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f2);
        mydb = new Databasehelpera(this);
        login = (Button)findViewById(R.id.button);
        usrnm = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        cancel = (Button)findViewById(R.id.button2);
        //tx1 = (TextView)findViewById(R.id.textView3);
        //tx1.setVisibility(View.GONE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usrnm.getText().toString().equals("anjalipatil") &&
                        password.getText().toString().equals("anjalipatil123")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();

                    boolean isInserted=mydb.insert1(usrnm.getText().toString(),password.getText().toString());
                    /*if (isInserted==true)
                    {
                        Toast.makeText(NewActivity1.this,"Data inserted",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(NewActivity1.this,"Data not inserted",Toast.LENGTH_LONG).show();
                    }*/

                    Intent i = new Intent(NewActivity1.this,NewActivity7.class);
                    startActivity(i);

                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Password Or Username",Toast.LENGTH_SHORT).show();


                }
            }

        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}