package com.example.bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Objects;

public class DepositMoney extends AppCompatActivity {

    Toolbar toolbar;
    EditText deposit;
    Button btn_dep;
    private FirebaseDatabase database;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_deposit_money );

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );
        Objects.requireNonNull( getSupportActionBar( ) ).setDisplayHomeAsUpEnabled( true);


        deposit = findViewById(R.id.dep_amount);
        btn_dep = findViewById(R.id.dep_money);
        btn_dep.setOnClickListener( v -> {
            String s = deposit.getText().toString();
            if (s.isEmpty()){
                Toast.makeText( DepositMoney.this, "Please Enter Amount", Toast.LENGTH_LONG ).show( );
            }else {
                database = FirebaseDatabase.getInstance();
                database.getReference().child("Balance").child("ans").setValue(s).addOnCompleteListener( new OnCompleteListener<Void>( ) {
                    @Override
                    public void onComplete (@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText( DepositMoney.this, s +" Rs. Has Been Deposited In Your Account ", Toast.LENGTH_SHORT ).show( );
//                            startActivity(new Intent( DepositMoney.this, MainActivity.class));
//                            finish();
                        }else {
                            Toast.makeText( DepositMoney.this, ""+task.getException().getMessage(), Toast.LENGTH_SHORT ).show( );
                        }
                    }
                } );
            }
        } );
    }
}