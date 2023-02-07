package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class CLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_links);
        CardView cl1=findViewById(R.id.cl1);
        CardView cl2=findViewById(R.id.cl2);
        CardView cl3=findViewById(R.id.cl3);
        CardView cl4=findViewById(R.id.cl4);
        CardView cl5=findViewById(R.id.cl5);
        CardView cl6=findViewById(R.id.cl6);
        CardView cl7=findViewById(R.id.cl7);
        CardView cl8=findViewById(R.id.cl8);
        CardView cl9=findViewById(R.id.cl9);
        CardView cl10=findViewById(R.id.cl10);

        cl1.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cprogramming/c_overview.htm"));

        cl2.setOnClickListener(v -> gotoUrl("https://www.w3schools.in/c-tutorial/data-types/"));

        cl3.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cprogramming/c_operators.htm"));

        cl4.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cprogramming/c_decision_making.htm"));

        cl5.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cprogramming/c_arrays.htm"));

        cl6.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cprogramming/c_strings.htm"));

        cl7.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/functions-in-c"));

        cl8.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cprogramming/c_structures.htm#:~:text=C%20-%20Structures%201%20Defining%20a%20Structure.%20To,Pointers%20to%20Structures.%20...%205%20Bit%20Fields.%20"));

        cl9.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cprogramming/c_unions.htm"));

        cl10.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/c-pointers"));

    }

    private void gotoUrl(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}