package com.example.nut.hydroponic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import az.plainpie.PieView;
import az.plainpie.animation.PieAngleAnimation;

public class DataActivity extends AppCompatActivity {
    TextView textviewdata;
    FirebaseDatabase database;
    DatabaseReference myRefBoard1,myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_data);
        ImageButton back = (ImageButton) findViewById(R.id.imbtnback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DataActivity.this ,MainActivity.class);
                startActivity(i);
            }
        });
        String ControllerId = "1123";
        database = FirebaseDatabase.getInstance();
        myRefBoard1 = database.getReference("controller/"+ControllerId+"/board1");
        myRef = database.getReference("controller/"+ControllerId);

        myRefBoard1.child("/logwater").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("TEST", "TEST: "+dataSnapshot.getChildren().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
