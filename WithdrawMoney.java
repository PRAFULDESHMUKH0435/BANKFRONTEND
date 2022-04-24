package com.example.bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Objects;

public class WithdrawMoney extends AppCompatActivity {

    Toolbar toolbar;
    EditText withdraw,pancard;
    Button with_btn;
    private FirebaseDatabase database;

    @Override
    protected void onCreate (Bundle savedInstanceState)  {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_withdraw_money );

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );
        Objects.requireNonNull( getSupportActionBar( ) ).setDisplayHomeAsUpEnabled( true);

        withdraw = findViewById(R.id.with_amount);
        pancard = findViewById(R.id.pan_card);
        with_btn = findViewById(R.id.with_money);
        with_btn.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                String a = withdraw.getText().toString();
                if (a.isEmpty()){
                    Toast.makeText( WithdrawMoney.this, "Enter Amount", Toast.LENGTH_SHORT ).show( );
                }else {
                    database = FirebaseDatabase.getInstance();
                    database.getReference().child("Balance").addValueEventListener( new ValueEventListener( ) {
                        @Override
                        public void onDataChange (@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot data : snapshot.getChildren()){
                               String j1 = data.getValue().toString();
                               if (Integer.parseInt(a)>Integer.parseInt(j1)){
                                   Toast.makeText( WithdrawMoney.this, "Your Current Balance Is "+j1 +" Please Add Smaller Amount To Withdraw", Toast.LENGTH_SHORT ).show( );
                               }else {
                                   Toast.makeText( WithdrawMoney.this, a+" Rs. Has Been Deducted From Your Account", Toast.LENGTH_SHORT ).show( );
//                                   s1 = String.valueOf(Integer.parseInt(s1)-Integer.parseInt(a));
//                                   database.getReference().child("Balance").child("ans").setValue(s1);
//                                   break;
                               }

                            }
                        }

                        @Override
                        public void onCancelled (@NonNull DatabaseError error) {
                            Toast.makeText( WithdrawMoney.this, ""+error.getMessage(), Toast.LENGTH_SHORT ).show( );
                        }
                    } );
                }
            }
        } );
    }
}