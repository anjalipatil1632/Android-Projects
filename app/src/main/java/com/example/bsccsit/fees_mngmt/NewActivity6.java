package com.example.bsccsit.fees_mngmt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NewActivity6 extends AppCompatActivity {
    EditText e1,e2;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.f6);
        Button b1= (Button) findViewById(R.id.ok);
        Button b2= (Button) findViewById(R.id.cancel);
        Spinner s1=(Spinner)findViewById(R.id.s1) ;
        e1=(EditText)findViewById(R.id.e1) ;
        e2=(EditText)findViewById(R.id.e2) ;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm=e1.getText().toString();
                String rn=e2.getText().toString();
                if(nm.length()==0)
                {
                    e1.setError("You must enter your Name");
                }
                else if(rn.length()==0)
                {
                    e2.setError("You must enter your Roll No.");
                }
                else {
                    Intent i = new Intent(NewActivity6.this, NewActivity7.class);
                    startActivity(i);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String [] classes ={"FYBSC CS","SYBSC CS","TYBSC CS"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,classes);
        s1.setAdapter(adapter);


    }


}
