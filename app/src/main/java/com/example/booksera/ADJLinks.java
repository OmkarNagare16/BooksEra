package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class ADJLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_j_links);
        CardView adjl1=findViewById(R.id.adjl1);
        CardView adjl2=findViewById(R.id.adjl2);
        CardView adjl3=findViewById(R.id.adjl3);
        CardView adjl4=findViewById(R.id.adjl4);
        CardView adjl5=findViewById(R.id.adjl5);
        CardView adjl6=findViewById(R.id.adjl6);
        CardView adjl7=findViewById(R.id.adjl7);
        CardView adjl8=findViewById(R.id.adjl8);


        adjl1.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/event-handling-in-java"));

        adjl2.setOnClickListener(v -> gotoUrl("https://www.infoworld.com/article/2077188/introduction-to-the-awt.html"));

        adjl3.setOnClickListener(v -> gotoUrl("https://www.studytonight.com/java/java-swing-components.php"));

        adjl4.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/jdbc/jdbc-introduction.htm"));

        adjl5.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/jdbc-driver"));

        adjl6.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/jsp/jsp_java_beans.htm"));

        adjl7.setOnClickListener(v -> gotoUrl("https://www.iitk.ac.in/esc101/05Aug/tutorial/javabeans/whatis/bdkDescription.html"));

        adjl8.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/java_rmi/java_rmi_introduction.htm#:~:text=RMI%20stands%20for%20Remote%20Method,remote%20communication%20between%20Java%20programs."));


    }

    private void gotoUrl(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}