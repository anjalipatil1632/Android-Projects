package com.example.bsccsit.fees_mngmt;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewActivity4 extends AppCompatActivity {
    Databaseparents mydb;
    EditText e1,e2,e3,e4,e5,e6;
    Spinner s1;
    Databasehelpera mydb1;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.f4);
        s1=(Spinner)findViewById(R.id.spinner3);
        e1=(EditText)findViewById(R.id.e1) ;
        e2=(EditText)findViewById(R.id.e2) ;
        e3=(EditText)findViewById(R.id.e4) ;
        e4=(EditText)findViewById(R.id.e5) ;
        e5=(EditText)findViewById(R.id.e6) ;
        e6=(EditText)findViewById(R.id.e7) ;
        mydb = new Databaseparents(this);
        mydb1 = new Databasehelpera(this);
        Button b1=(Button)findViewById(R.id.b1);
        Button b2=(Button)findViewById(R.id.b2);
        String [] classes ={"FYBSC CS","SYBSC CS","TYBSC CS"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,classes);
        s1.setAdapter(adapter);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm=e1.getText().toString();
                String rn=e2.getText().toString();
                String phn=e3.getText().toString();
                String email=e4.getText().toString();
                String pass=e5.getText().toString();
                String cpass=e6.getText().toString();
                String spinner=s1.getSelectedItem().toString().trim();

                if(nm.length()==0)
                {
                    e1.setError("You must enter your Name");
                }
                else if(nm.length()<2)
                {
                    e1.setError("You must enter Valid Name");
                }

                else if(rn.length()==0)
                {
                    e2.setError("You must enter your Roll No.");
                }
                else if(phn.length()==0)
                {
                    e3.setError("You must enter your Phone number");
                }
                else if(phn.length()<10)
                {
                    e3.setError("You must enter valid Phone number");
                }
                else if(phn.length()>10)
                {
                    e3.setError("You must enter valid Phone number");
                }
                else if(email.length()==0)
                {
                    e4.setError("You must enter your Email");
                }
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                    e4.setError("Please enter valid email!");
                }
                else if(pass.length()==0)
                {
                    e5.setError("You must enter your Password");
                }

                else if(pass.length()<6)
                {
                    e4.setError("Please enter valid password");
                }
                else if(cpass.length()==0)
                {
                    e5.setError("You must enter your Confirm Password");
                }
                else if(!(pass).equals(cpass))
                {
                    e5.setError("Password and confirm password must be same");
                }

                else {
                    boolean isInserted=mydb.insert(e1.getText().toString(),e2.getText().toString(),s1.getSelectedItem().toString(),e3.getText().toString(),e4.getText().toString(),e5.getText().toString(),e6.getText().toString());
                   /* if (isInserted == true)
                        Toast.makeText(NewActivity4.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(NewActivity4.this, "Data could not be Inserted", Toast.LENGTH_LONG).show();*/

                    Toast.makeText(getApplicationContext(),"Successfully Registered !!!",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(NewActivity4.this, NewActivity3.class);
                    startActivity(i);


                   int permissioncheck= ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS);
                    if(permissioncheck == PackageManager.PERMISSION_GRANTED)
                    {
                        Mymsg();

                    }
                    else {
                        ActivityCompat.requestPermissions(NewActivity4.this, new String[]{Manifest.permission.SEND_SMS}, 1000);
                    }
                }
            }

            private void Mymsg() {

                SmsManager sms=SmsManager.getDefault();
                PendingIntent sentPI;

                Cursor res = mydb1.getData(e2.getText().toString(),s1.getSelectedItem().toString());
                String data = null;
                if (res.moveToFirst()) {

                    data = "Id:" + res.getString(0) + "\n\n" +
                            "Name :" + res.getString(1) + "\n\n" +
                            "Class :" + res.getString(2) + "\n\n" +
                            "First Installation :" + res.getString(3) + "\n\n"
                            +
                            " Tution Fees:" + res.getString(4) + "\n\n"
                            +
                            "Comp. Fees :" + res.getString(5) + "\n\n"
                            +
                            "ID Fees :" + res.getString(6) + "\n\n"

                            +
                            "Paid Date :"+ res.getString(7)+"\n\n"




                    ;
                }
                String SENT="sms sent";

                sentPI=PendingIntent.getBroadcast(NewActivity4.this,1000,new Intent(SENT),0);
                sms.sendTextMessage(e3.getText().toString(),null,e1.getText().toString()+" Welcome to fees manager !!! \n You are just registered " ,sentPI,null);
                sms.sendTextMessage(e3.getText().toString(),null,"Your Fees Details : \n\n "+data+"",sentPI,null);


                //Toast.makeText(getApplicationContext(),"msg sent",Toast.LENGTH_LONG).show();
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
