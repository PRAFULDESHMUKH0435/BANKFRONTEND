package com.example.bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ImageSlider imageSlider;
    CardView one,two,three,four,five,six;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle( this,drawerLayout,toolbar,R.string.open,R.string.close );
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();


        /////////code of image slider

        imageSlider = findViewById(R.id.image_slider);
        ArrayList<SlideModel> list = new ArrayList<>();
        list.add( new SlideModel( "https://media.istockphoto.com/photos/indian-currency-in-a-white-background-picture-id879008460?b=1&k=20&m=879008460&s=170667a&w=0&h=jWRhuA-BkotVSQdLx3QPjL7TbITcyZd_OQjK_kkaAzA=","Money Inflow and Outflow", ScaleTypes.FIT));
        list.add( new SlideModel( "https://cdn.pixabay.com/photo/2015/09/15/15/53/bank-notes-941246__480.jpg","Banking regulations", ScaleTypes.FIT));
        list.add( new SlideModel( "https://media.istockphoto.com/photos/banking-online-concept-internet-bank-picture-id1285809521?b=1&k=20&m=1285809521&s=170667a&w=0&h=tfuaMLlsjhU4GXmeTgfTFPklCBS8OEaCej_hMKL8evs=","GDP", ScaleTypes.FIT));
        list.add( new SlideModel( "https://cdn.pixabay.com/photo/2016/08/10/15/01/credit-cards-1583534__340.jpg","Money Market", ScaleTypes.FIT));
        list.add( new SlideModel( "https://cdn.pixabay.com/photo/2016/09/29/08/02/rupee-1702288__340.jpg","Monetization", ScaleTypes.FIT));
        imageSlider.setImageList(list,ScaleTypes.CENTER_CROP);

        navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener( ) {
            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.about :
                        Toast.makeText( MainActivity.this, "About Us", Toast.LENGTH_SHORT ).show( );
                        drawerLayout.close();
                        break;

                     case R.id.branches :
                        Toast.makeText( MainActivity.this, "Only Have One branch In Nagpur", Toast.LENGTH_SHORT ).show( );
                        drawerLayout.close();
                        break;

                     case R.id.contact_us :
                        Toast.makeText( MainActivity.this, "mail us On: prafuldeshmukh068@gmail.com", Toast.LENGTH_LONG ).show( );
                        drawerLayout.close();
                        break;

                     case R.id.logout :
                        Toast.makeText( MainActivity.this, "Signing Off , Thank You ", Toast.LENGTH_SHORT ).show( );
                        drawerLayout.close();
                        finish();
                        break;
                }
                return true;
            }
        } );








        ////////////////////////////GRID LAYOUT



        one = findViewById(R.id.createacc);
        one.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this,CreateAccount.class));
            }
        } );



        two = findViewById(R.id.depositmny);
        two.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this,DepositMoney.class));
            }
        } );



        three = findViewById(R.id.withdrawmny);
        three.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this,WithdrawMoney.class));
            }
        } );



        four = findViewById(R.id.checkblnce);
        four.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this,CheckBalance.class));
            }
        } );



        five = findViewById(R.id.cardservices);
        five.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this,CardServices.class));
            }
        } );



        six = findViewById(R.id.netbanking);
        six.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this,NetBanking.class));
            }
        } );





    }

    @Override
    public void onBackPressed ( ) {
//        super.onBackPressed( );
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exit ? ")
                .setMessage("Are You Sure , You Want To Exit ")
                .setIcon(R.drawable.ic_baseline_exit_to_app_24)
                .setCancelable(false)
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener( ) {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        finish();
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