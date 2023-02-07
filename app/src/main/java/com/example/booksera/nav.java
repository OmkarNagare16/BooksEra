package com.example.booksera;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static android.view.View.*;

public class nav extends AppCompatActivity implements View.OnClickListener{
    private CardView card1,card2,card3,card4;
    GoogleSignInClient mGoogleSignInClient;
    private AppBarConfiguration mAppBarConfiguration;
    public static String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        card1=(CardView) findViewById ( R.id.c1 );
        card2=(CardView) findViewById ( R.id.c2 );
        card3=(CardView) findViewById ( R.id.c3 );
        card4=(CardView) findViewById ( R.id.c4 );

        card1.setOnClickListener(nav.this);
        card2.setOnClickListener(nav.this);
        card3.setOnClickListener(nav.this);
        card4.setOnClickListener(nav.this);

        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout (drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int i=item.getItemId();
                if(i==R.id.nav_task)
                {
                    task.username=username;
                    Intent intent=new Intent(nav.this,task.class);
                    startActivity(intent);

                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(i==R.id.btn_signout)
                {
                    logout();
                }
                else if(i==R.id.nav_book){
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(i==R.id.nav_subscription){
                    Intent intent=new Intent(nav.this,Links.class);
                    startActivity(intent);
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(i==R.id.nav_premium){
                    Intent intent=new Intent(nav.this,Subscription.class);
                    startActivity(intent);
                    drawer.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void logout()
    {
        mGoogleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(nav.this, "Signed out Successfully", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId ()){
            case R.id.c1:
                 intent=new Intent(nav.this,rdbms.class);
                startActivity(intent);
            break;

            case R.id.c2:
                intent=new Intent(nav.this,os.class);
                startActivity(intent);
            break;

            case R.id.c3:
                intent=new Intent(nav.this,AND.class);
                startActivity(intent);
                break;

            case R.id.c4:
                intent=new Intent(nav.this,maths.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id1 = item.getItemId();
        if(id1 == R.id.action_settings){

            Intent intent=new Intent(getApplicationContext(),aboutus.class);
            startActivity(intent);
            return true;
        }
        else if(id1 == R.id.User_Manul){

            Intent intent=new Intent(getApplicationContext(),UserManual.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}