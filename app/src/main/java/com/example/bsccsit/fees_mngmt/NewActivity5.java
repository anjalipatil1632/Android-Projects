
package com.example.bsccsit.fees_mngmt;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class NewActivity5 extends AppCompatActivity {
    TextView t1;
    Button b1,b2,s1;
    EditText e1,e2;
    DatabaseHelper mydb;
    Databasehelpera mydb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.f5);
        mydb = new DatabaseHelper(this);

        Button b1=(Button)findViewById(R.id.student);
        Button b2=(Button)findViewById(R.id.button2) ;
        TextView t1=(TextView)findViewById(R.id.reg) ;
        e1=(EditText)findViewById(R.id.editText) ;
        e2=(EditText)findViewById(R.id.editText2) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usrnm=e1.getText().toString();
                String pass=e2.getText().toString();
                if(usrnm.length()==0)
                {
                    e1.setError("You must enter your username");
                }
                else if(usrnm.length()<=5)
                {
                    e1.setError("Username is too short");
                }
                else if(pass.length()==0)
                {
                    e2.setError("You must enter your Password");
                }
                else if(pass.length()<6)
                {
                    e2.setError("Please enter valid password");
                }
                else {
                     boolean res=mydb.checkuser(usrnm,pass);
                     if(res==true) {
                         Toast.makeText(NewActivity5.this, "login successfull", Toast.LENGTH_LONG).show();


                         Intent i = new Intent(NewActivity5.this, NewActivity3.class);
                         startActivity(i);

                     }
                     else
                     {
                         Toast.makeText(NewActivity5.this, "You are not registered yet..\n Please Register ", Toast.LENGTH_LONG).show();
                     }

                    }


                }


        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(NewActivity5.this,NewActivity8.class);
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
        
        

    }





