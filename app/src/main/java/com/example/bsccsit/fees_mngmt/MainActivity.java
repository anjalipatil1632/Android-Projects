package com.example.bsccsit.fees_mngmt;


import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

import android.widget.RelativeLayout;
import android.widget.Toast;



import static com.example.bsccsit.fees_mngmt.R.id.nav_student;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    RelativeLayout introMessage;
    RelativeLayout appContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //RelativeLayout rl = new RelativeLayout(R.id.relative);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.draw_layout);


        introMessage = (RelativeLayout) findViewById(R.id.welcome_message_layout);
        appContent = (RelativeLayout) findViewById(R.id.ddd);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open_navigation, R.string.close_navigation);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(nav_student);

        Button admin = (Button) findViewById(R.id.admin);
        Button student = (Button) findViewById(R.id.student);
        Button parent = (Button) findViewById(R.id.parent);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this, NewActivity5.class);
                startActivity(i1);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, NewActivity1.class);
                startActivity(i2);
            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(MainActivity.this, NewActivity4.class);
                startActivity(i3);
            }
        });



    }

    public void dismisWelcomeMessageBox(View view) {
        introMessage.setVisibility(View.INVISIBLE);
        appContent.setVisibility(View.VISIBLE);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.draw_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == nav_student) {
            Toast.makeText(getApplicationContext(),"Helooooo student",Toast.LENGTH_LONG).show();
            // Handle the camera action
        } else if (id == R.id.nav_admin) {

        } else if (id == R.id.nav_parents) {

        } else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_rateus) {

        }

        DrawerLayout drawer = findViewById(R.id.draw_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}