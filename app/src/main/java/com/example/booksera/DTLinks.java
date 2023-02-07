package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class DTLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_t_links);
        CardView dtl1=findViewById(R.id.dtl1);
        CardView dtl2=findViewById(R.id.dtl2);
        CardView dtl3=findViewById(R.id.dtl3);
        CardView dtl4=findViewById(R.id.dtl4);
        CardView dtl5=findViewById(R.id.dtl5);
        CardView dtl6=findViewById(R.id.dtl6);
        CardView dtl7=findViewById(R.id.dtl7);


        dtl1.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/number-system-in-digital-electronics"));

                dtl2.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/computer_logical_organization/boolean_algebra.htm"));

                dtl3.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/computer_logical_organization/combinational_circuits.htm"));

                dtl4.setOnClickListener(v -> gotoUrl("https://www.electronicshub.org/multiplexer-and-demultiplexer/"));

                dtl5.setOnClickListener(v -> gotoUrl("https://kader05cuet.files.wordpress.com/2016/11/msi.pdf"));

                dtl6.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/digital_circuits/digital_circuits_flip_flops.htm"));

                dtl7.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/digital_circuits/digital_circuits_sequential_circuits.htm#:~:text=The%20outputs%20of%20sequential,rage%20elements."));

                }

private void gotoUrl(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }
        }