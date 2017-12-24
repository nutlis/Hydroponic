package com.example.nut.hydroponic;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import az.plainpie.PieView;
import az.plainpie.animation.PieAngleAnimation;


public class MainActivity extends AppCompatActivity {
    TextView textviewph,textviewdis;
    FirebaseDatabase database;
    DatabaseReference myRefBoard1,myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ImageView stats = (ImageView) findViewById(R.id.imageviewstats);
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this ,DataActivity.class);
                startActivity(i);
            }
        });
        String ControllerId = "1123";
        database = FirebaseDatabase.getInstance();
        myRefBoard1 = database.getReference("controller/"+ControllerId+"/board1");
        myRef = database.getReference("controller/"+ControllerId);
        textviewph = findViewById(R.id.textviewph);
        textviewdis = findViewById(R.id.textviewdis);



        myRefBoard1.child("levelwater").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                double phsensor = dataSnapshot.child("phsensor").getValue(Double.class);
                textviewph.setText(String.valueOf(phsensor));


                Log.d("phsenser", "" + phsensor);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        myRefBoard1.child("levelwater").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                double distance = dataSnapshot.child("distance").getValue(Double.class);
                textviewdis.setText(String.valueOf(18 - distance));


                Log.d("Distance", "" + distance);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


}
