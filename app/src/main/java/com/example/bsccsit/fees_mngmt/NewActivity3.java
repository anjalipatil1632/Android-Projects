package com.example.bsccsit.fees_mngmt;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NewActivity3 extends AppCompatActivity {
    EditText rollno;
    Button ok;
    Spinner class1;
    Databasehelpera mydb;
    DatabaseHelper mydb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.f3);
        class1=(Spinner)findViewById(R.id.spin);
        rollno=(EditText)findViewById(R.id.abc);
        ok=(Button)findViewById(R.id.button3);
        mydb = new Databasehelpera(this);


        String [] classes ={"FYBSC CS","SYBSC CS","TYBSC CS"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,classes);
        class1.setAdapter(adapter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rollno1 = rollno.getText().toString().trim();
                String spinner = class1.getSelectedItem().toString().trim();


                if (rollno1.length() == 0) {
                    rollno.setError("plz enter your Roll no.");
                } else {

                    if (rollno1.equals(String.valueOf(""))) {
                        rollno.setError("Enter id to get data");
                        return;
                    }
                    Cursor res = mydb.getData(rollno1, class1.getSelectedItem().toString());
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
                                +
                                "Due Date :"+ res.getString(8)+"\n\n"
                        ;
                    }
                    showMessage("FEES DETAILS:", data);

                }
            }




            private void showMessage(String data, String data1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NewActivity3.this);
                builder.create();
                builder.setCancelable(true);
                builder.setTitle(data);
                builder.setMessage(data1);
                builder.show();
            }






        });



    }



}
