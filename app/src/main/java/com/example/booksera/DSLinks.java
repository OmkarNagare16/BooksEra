package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class DSLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_s_links);
        CardView dsl1=findViewById(R.id.dsl1);
        CardView dsl2=findViewById(R.id.dsl2);
        CardView dsl3=findViewById(R.id.dsl3);
        CardView dsl4=findViewById(R.id.dsl4);
        CardView dsl5=findViewById(R.id.dsl5);
        CardView dsl6=findViewById(R.id.dsl6);
        CardView dsl7=findViewById(R.id.dsl7);
        CardView dsl8=findViewById(R.id.dsl8);
        CardView dsl9=findViewById(R.id.dsl9);
        CardView dsl10=findViewById(R.id.dsl10);

        dsl1.setOnClickListener(v -> gotoUrl("https://beginnersbook.com/2018/10/data-structure-introduction/"));

        dsl2.setOnClickListener(v -> gotoUrl("https://www.guru99.com/array-data-structure.html#:~:text=An%20array%20is%20a%20data,an%20array%20is%20called%20length."));

        dsl3.setOnClickListener(v -> gotoUrl("https://youtu.be/DOtjTiZ3sws"));

        dsl4.setOnClickListener(v -> gotoUrl("https://youtu.be/8TVaEGeaGGc"));

        dsl5.setOnClickListener(v -> gotoUrl("https://youtu.be/eGnlKPCkAFY"));

        dsl6.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/data-structure-stack"));

        dsl7.setOnClickListener(v -> gotoUrl("https://www.studytonight.com/data-structures/queue-data-structure"));

        dsl8.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/recursion/"));

        dsl9.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/data_structures_algorithms/tree_data_structure.htm"));

        dsl10.setOnClickListener(v -> gotoUrl("https://youtu.be/5hPfm_uqXmw"));

    }

    private void gotoUrl(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}