package com.example.bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class NetBanking extends AppCompatActivity {

    Toolbar toolbar;
    EditText ben_name,ben_Acc_no,ifsc,micr,ben_amount;
    Button ben_btn;
    private FirebaseDatabase database;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_net_banking );


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );
        Objects.requireNonNull( getSupportActionBar( ) ).setDisplayHomeAsUpEnabled( true);

        ben_name = findViewById(R.id.benficiary_name);
        ben_Acc_no = findViewById(R.id.benificiary_acc);
        ifsc = findViewById(R.id.enter_ifsc);
        micr = findViewById(R.id.enter_micr);
        ben_amount = findViewById(R.id.ben_amount);
        ben_btn = findViewById(R.id.ben_button);
         String ans ="";
        ben_btn.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                String a = ben_name.getText().toString();
                String b = ben_Acc_no.getText().toString();
                String c = ifsc.getText().toString();
                String d = micr.getText().toString();
                String e = ben_amount.getText().toString();
                if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty() || e.isEmpty()){
                    Toast.makeText( NetBanking.this, "Please Fill Out All The Fields", Toast.LENGTH_SHORT ).show( );
                }else {
                    new AlertDialog.Builder(NetBanking.this)
                            .setTitle("Payment Confirmation")
                            .setMessage("Are You Sure You Want To Send Money To Following Account \n"+a +"\n" +
                                                b+"\n" +
                                                e+"\n")
                            .setCancelable(false)
                            .setPositiveButton( "Yes,Proceed", new DialogInterface.OnClickListener( ) {
                                @Override
                                public void onClick (DialogInterface dialog, int which) {
                                    Toast.makeText( NetBanking.this, e+" Rs. Has Been Send To "+a, Toast.LENGTH_LONG ).show( );
//                                    startActivity(new Intent(NetBanking.this,MainActivity.class));
//                                    finish();
                                }
                            } )
                            .setNegativeButton( "No", new DialogInterface.OnClickListener( ) {
                                @Override
                                public void onClick (DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            } )
                            .show();
                }
            }
        } );
    }


}