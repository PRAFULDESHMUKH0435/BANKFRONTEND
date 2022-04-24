package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

public class CardServices extends AppCompatActivity {

    Toolbar toolbar;
    CardView Apply,block,link_fastag,card_stolen;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_card_services );

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );
        Objects.requireNonNull( getSupportActionBar( ) ).setDisplayHomeAsUpEnabled( true);

        Apply = findViewById(R.id.card_apply);
        Apply.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                Toast.makeText( CardServices.this, "Please visit Our Branch ", Toast.LENGTH_LONG ).show( );
            }
        } );

        block = findViewById(R.id.block_card);
        block.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                Toast.makeText( CardServices.this, "Call Us On : 9359407730", Toast.LENGTH_LONG ).show( );
            }
        } );

        link_fastag = findViewById(R.id.fastag);
        link_fastag.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                Toast.makeText( CardServices.this, "Fastag Services Are Temporarily Unavailable ", Toast.LENGTH_LONG  ).show( );
            }
        } );

        card_stolen = findViewById(R.id.Card_Stolen);
        card_stolen.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                Toast.makeText( CardServices.this, "Call Us On : 9359407730", Toast.LENGTH_LONG ).show( );
            }
        } );
    }
}