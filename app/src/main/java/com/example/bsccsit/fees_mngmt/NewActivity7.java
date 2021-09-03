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
import android.widget.Toast;

public class NewActivity7 extends AppCompatActivity {
    Databasehelpera mydb;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    Spinner s1;
    Button b1,b2,b3,b4,b5,b6,b7;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.f7);
        ed1 = (EditText) findViewById(R.id.e1);
        ed2 = (EditText) findViewById(R.id.e2);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);
        ed5 = (EditText) findViewById(R.id.editText5);
        ed6 = (EditText) findViewById(R.id.editText6);
        ed7 = (EditText) findViewById(R.id.pdate);
        ed8 = (EditText) findViewById(R.id.ddate);
        s1 = (Spinner) findViewById(R.id.s1);
        b1 = (Button) findViewById(R.id.insert);
        b2 = (Button) findViewById(R.id.update);
        b3 = (Button) findViewById(R.id.delete);
        b4 = (Button) findViewById(R.id.view);
        b6 = (Button) findViewById(R.id.view2);
        b7 = (Button) findViewById(R.id.view3);
        b5=(Button)findViewById(R.id.viewr) ;

        mydb = new Databasehelpera(this);

        String[] classes = {"FYBSC CS", "SYBSC CS", "TYBSC CS"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, classes);
        s1.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roll=ed1.getText().toString().trim();
                String name=ed2.getText().toString().trim();
                String spinner=s1.getSelectedItem().toString().trim();

                if(name.length()==0)
                {
                    ed2.setError("You must enter student Name");
                }
                else if (s1.getSelectedItem().toString().equals("FYBSC CS"))
                {
                    boolean isInserted = mydb.insert( ed2.getText().toString(), s1.getSelectedItem().toString(),
                            ed3.getText().toString(), ed4.getText().toString(), ed5.getText().toString(), ed6.getText().toString(),ed7.getText().toString(),ed8.getText().toString());
                    if (isInserted == true)
                        Toast.makeText(NewActivity7.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(NewActivity7.this, "Data could not be Inserted", Toast.LENGTH_LONG).show();
                }
                else if (s1.getSelectedItem().toString().equals("SYBSC CS"))
                {
                    boolean isInserted = mydb.insert3( ed2.getText().toString(), s1.getSelectedItem().toString(),
                            ed3.getText().toString(), ed4.getText().toString(), ed5.getText().toString(), ed6.getText().toString(),ed7.getText().toString(),ed8.getText().toString());
                    if (isInserted == true)
                        Toast.makeText(NewActivity7.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(NewActivity7.this, "Data could not be Inserted", Toast.LENGTH_LONG).show();
                }
                else {

                    boolean isInserted = mydb.insert4( ed2.getText().toString(), s1.getSelectedItem().toString(),
                            ed3.getText().toString(), ed4.getText().toString(), ed5.getText().toString(), ed6.getText().toString(),ed7.getText().toString(),ed8.getText().toString());
                    if (isInserted == true)
                        Toast.makeText(NewActivity7.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(NewActivity7.this, "Data could not be Inserted", Toast.LENGTH_LONG).show();

                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = mydb.updateData(ed1.getText().toString(), ed2.getText().toString(), s1.getSelectedItem().toString(),
                        ed3.getText().toString(), ed4.getText().toString(), ed5.getText().toString(), ed6.getText().toString(),ed7.getText().toString(),ed8.getText().toString());
                if (isInserted == true)
                    Toast.makeText(NewActivity7.this, "Data updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(NewActivity7.this, "Data could not be updated", Toast.LENGTH_LONG).show();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String roll=ed1.getText().toString().trim();
                if(roll.length()==0)
                {
                    ed1.setError("You must enter student Name");
                }
                else{
                Integer deletedRows = mydb.deleteData(ed1.getText().toString(),s1.getSelectedItem().toString());
                if(deletedRows > 0)
                    Toast.makeText(NewActivity7.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(NewActivity7.this,"Data could not be Deleted",Toast.LENGTH_LONG).show();

            }}
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res=mydb.getAllData();
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Id:"+res.getString(0)+"\n\n");
                    buffer.append("Name :"+ res.getString(1)+"\n\n");
                    buffer.append("Class :"+ res.getString(2)+"\n\n");
                    buffer.append("First Installation :"+ res.getString(3)+"\n\n");
                    buffer.append("Tution Fees:"+ res.getString(4)+"\n\n");
                    buffer.append(" Comp. Fees:"+ res.getString(5)+"\n\n");
                    buffer.append(" ID fees :"+ res.getString(6)+"\n\n");
                    buffer.append(" Paid Date:"+ res.getString(7)+"\n\n");
                    buffer.append(" Due Date :"+ res.getString(8)+"\n\n");

                }
                showMessage("Data",buffer.toString());


            }

            private void showMessage(String title, String message) {
                AlertDialog.Builder builder= new AlertDialog.Builder(NewActivity7.this);
                builder.create();
                builder.setCancelable(true);
                builder.setTitle(title);
                builder.setMessage(message);
                builder.show();


            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res=mydb.getAllData3();
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Id:"+res.getString(0)+"\n\n");
                    buffer.append("Name :"+ res.getString(1)+"\n\n");
                    buffer.append("Class :"+ res.getString(2)+"\n\n");
                    buffer.append("First Installation :"+ res.getString(3)+"\n\n");
                    buffer.append("Tution Fees:"+ res.getString(4)+"\n\n");
                    buffer.append(" Comp. Fees:"+ res.getString(5)+"\n\n");
                    buffer.append(" ID fees :"+ res.getString(6)+"\n\n");
                    buffer.append(" Paid Date:"+ res.getString(7)+"\n\n");
                    buffer.append(" Due Date :"+ res.getString(8)+"\n\n");
                }
                showMessage("Data",buffer.toString());


            }

            private void showMessage(String title, String message) {
                AlertDialog.Builder builder= new AlertDialog.Builder(NewActivity7.this);
                builder.create();
                builder.setCancelable(true);
                builder.setTitle(title);
                builder.setMessage(message);
                builder.show();


            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res=mydb.getAllData4();
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Id:"+res.getString(0)+"\n\n");
                    buffer.append("Name :"+ res.getString(1)+"\n\n");
                    buffer.append("Class :"+ res.getString(2)+"\n\n");
                    buffer.append("First Installation :"+ res.getString(3)+"\n\n");
                    buffer.append("Tution Fees:"+ res.getString(4)+"\n\n");
                    buffer.append(" Comp. Fees:"+ res.getString(5)+"\n\n");
                    buffer.append(" ID fees :"+ res.getString(6)+"\n\n");
                    buffer.append(" Paid Date:"+ res.getString(7)+"\n\n");
                    buffer.append(" Due Date :"+ res.getString(8)+"\n\n");
                }
                showMessage("DATA",buffer.toString());


            }

            private void showMessage(String title, String message) {
                AlertDialog.Builder builder= new AlertDialog.Builder(NewActivity7.this);
                builder.create();
                builder.setCancelable(true);
                builder.setTitle(title);
                builder.setMessage(message);
                builder.show();


            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ed1.getText().toString();
                String spinner=s1.getSelectedItem().toString().trim();

                if(id.equals(String.valueOf(""))){
                    ed1.setError("Enter id to get data");
                    return;
                }
                Cursor res = mydb.getData(id,spinner);
                String data = null;
                if (res.moveToFirst()) {

                    data = "Id:"+res.getString(0)+"\n\n"+
                            "Name :"+ res.getString(1)+"\n\n"+
                            "Class :"+ res.getString(2)+"\n\n"+
                            "First Installation :"+ res.getString(3)+"\n\n"
                            +
                            " Tution Fees:"+ res.getString(4)+"\n\n"
                            +
                            "Comp. Fees :"+ res.getString(5)+"\n\n"
                            +
                            "ID :"+ res.getString(6)+"\n\n"
                    +
                            "Paid Date :"+ res.getString(7)+"\n\n"
                            +
                            "Due Date :"+ res.getString(8)+"\n\n";


                }
                showMessage("Data", data);


            }

            private void showMessage(String data, String data1) {
                AlertDialog.Builder builder= new AlertDialog.Builder(NewActivity7.this);
                builder.create();
                builder.setCancelable(true);
                builder.setTitle(data);
                builder.setMessage(data1);
                builder.show();
            }
        });







    }}







