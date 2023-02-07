package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class ANDROIDLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_n_d_r_o_i_d_links);
        CardView andl1=findViewById(R.id.andl1);
        CardView andl2=findViewById(R.id.andl2);
        CardView andl3=findViewById(R.id.andl3);
        CardView andl4=findViewById(R.id.andl4);
        CardView andl5=findViewById(R.id.andl5);
        CardView andl6=findViewById(R.id.andl6);
        CardView andl7=findViewById(R.id.andl7);
        CardView andl8=findViewById(R.id.andl8);
        CardView andl9=findViewById(R.id.andl9);


        andl1.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/android/android_overview.htm"));

        andl2.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/android-architecture/"));

        andl3.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/android/android_environment_setup.htm"));

        andl4.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/components-android-application/"));

        andl5.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/android/android_user_interface_layouts.htm"));

        andl6.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/android/android_user_interface_controls.htm"));

        andl7.setOnClickListener(v -> gotoUrl("https://developer.android.com/reference/android/database/package-summary"));

        andl8.setOnClickListener(v -> gotoUrl("https://developer.android.com/topic/security/best-practices"));

        andl9.setOnClickListener(v -> gotoUrl("https://www.embarcadero.com/starthere/xe5/mobdevsetup/android/en/preparing_an_android_application_for_deployment.html#:~:text=Your%20Android%20app%20is%20deployed,Deploying%20Your%20Signed%20Android%20Application."));


    }

    private void gotoUrl(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}