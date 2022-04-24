package com.example.bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class CheckBalance extends AppCompatActivity {

    Toolbar toolbar;
    Button checkbal;
    TextView blanceshow;
    private FirebaseDatabase database;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_check_balance );

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );
        Objects.requireNonNull( getSupportActionBar( ) ).setDisplayHomeAsUpEnabled( true);

        blanceshow = findViewById(R.id.checkbal_txt);
        checkbal = findViewById(R.id.checkbal_btn);
        checkbal.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                database = FirebaseDatabase.getInstance();
                database.getReference().child("Balance").addValueEventListener( new ValueEventListener( ) {
                    @Override
                    public void onDataChange (@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()){
                            String ans = data.getValue().toString();
                            blanceshow.setText(ans);
                            break;
                        }
                    }

                    @Override
                    public void onCancelled (@NonNull DatabaseError error) {

                    }
                } );
            }
        } );
    }


}