package com.example.bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class CreateAccount extends AppCompatActivity {

    Toolbar toolbar;
    EditText name,address,mobile,aadhar;
    Button create;
    private FirebaseAuth auth;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_create_account );

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );
        Objects.requireNonNull( getSupportActionBar( ) ).setDisplayHomeAsUpEnabled( true);

        name = findViewById(R.id.cre_name);
        address = findViewById(R.id.cre_address);
        mobile = findViewById(R.id.cre_phone);
        create = findViewById(R.id.button);
        aadhar = findViewById(R.id.aadhar);
        create.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                String a = name.getText().toString();
                String b = address.getText().toString();
                String c = mobile.getText().toString();
                String d = aadhar.getText().toString();
                if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty()){
                    Toast.makeText( CreateAccount.this, "Fill All The Fields", Toast.LENGTH_LONG ).show( );
                }else {
                    createuser(a,b,c,d);
                }
            }
        } );
    }



    private void createuser (String a, String b, String c,String d) {
        auth = FirebaseAuth.getInstance();
        HashMap<String,Object> map = new HashMap<>();
         map.put("name",a.toUpperCase());
         map.put("address",b.toUpperCase());
         map.put("mobile",c.toUpperCase());
         map.put("aadharno",d.toUpperCase());

        FirebaseDatabase.getInstance().getReference().child("BankData").setValue(map,"mobile").addOnCompleteListener( new OnCompleteListener<Void>( ) {
            @Override
            public void onComplete (@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText( CreateAccount.this, "Account Created Successfully", Toast.LENGTH_LONG ).show( );
//                    startActivity(new Intent( CreateAccount.this, MainActivity.class));
//                    finish();
                }else {
                    Toast.makeText( CreateAccount.this, ""+task.getException().getMessage(), Toast.LENGTH_SHORT ).show( );
                }
            }
        } );
    }
}