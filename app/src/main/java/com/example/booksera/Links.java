package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Links extends AppCompatActivity {

    CardView cardjava,cardcs,cardds,cardjs,cardrdbms,carddt,cardcpp,cardand,cardjsp,cardc,cardadjava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        cardjava=findViewById(R.id.JavaLink);

        cardcs=findViewById(R.id.CSLink);
        cardds=findViewById(R.id.DSLink);
        cardjs=findViewById(R.id.JSLink);
        cardrdbms=findViewById(R.id.RDBMSLink);
        carddt=findViewById(R.id.DTLink);
        cardcpp=findViewById(R.id.CPPLink);
        cardand=findViewById(R.id.ANDLink);
        cardjsp=findViewById(R.id.JSPLink);
        cardc=findViewById(R.id.CLink);
        cardadjava=findViewById(R.id.ADJavaLink);


        cardjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Links.this,JavaLink.class);
                startActivity(intent);
            }
        });

        cardcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Links.this,CSLinks.class);
                startActivity(intent);
            }
        });

        cardds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Links.this,DSLinks.class);
                startActivity(intent);
            }
        });


        cardjs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Links.this,JSLinks.class);
                startActivity(intent);
            }
        });

        cardrdbms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Links.this,RDBMSLinks.class);
                startActivity(intent);
            }
        });

        carddt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Links.this,DTLinks.class);
                startActivity(intent);
            }
        });

        cardcpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Links.this,CPPLinks.class);
                startActivity(intent);
            }
        });

        cardand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Links.this,ANDROIDLinks.class);
                startActivity(intent);
            }
        });

        cardjsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Links.this,JSPLinks.class);
                startActivity(intent);
            }
        });

        cardc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Links.this,CLinks.class);
                startActivity(intent);
            }
        });

        cardadjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Links.this,ADJLinks.class);
                startActivity(intent);
            }
        });





    }
}