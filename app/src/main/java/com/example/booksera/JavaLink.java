package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class JavaLink extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_link);

        CardView jl1=findViewById(R.id.jl1);
        CardView jl2=findViewById(R.id.jl2);
        CardView jl3=findViewById(R.id.jl3);
        CardView jl4=findViewById(R.id.jl4);
        CardView jl5=findViewById(R.id.jl5);
        CardView jl6=findViewById(R.id.jl6);
        CardView jl7=findViewById(R.id.jl7);
        CardView jl8=findViewById(R.id.jl8);
        CardView jl9=findViewById(R.id.jl9);
        CardView jl10=findViewById(R.id.jl10);

        jl1.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/java-basics"));

        jl2.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/classes-objects-java/"));

        jl3.setOnClickListener(v -> gotoUrl("https://www.programiz.com/java-programming/methods"));

        jl4.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/java-string"));

        jl5.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/interface-in-java"));

        jl6.setOnClickListener(v -> gotoUrl("https://youtu.be/k7TwStbkK70"));

        jl7.setOnClickListener(v -> gotoUrl("https://www.guru99.com/multithreading-java.html#:~:text=MULTITHREADING%20in%20Java%20is%20a,runs%20parallel%20to%20each%20other."));

        jl8.setOnClickListener(v -> gotoUrl("https://youtu.be/8WTVLa1Xtsk"));

        jl9.setOnClickListener(v -> gotoUrl("https://www.studytonight.com/java/java-applet.php"));

        jl10.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/java/java_files_io.htm"));

    }

    private void gotoUrl(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}