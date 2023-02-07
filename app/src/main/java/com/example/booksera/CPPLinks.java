package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class CPPLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_p_p_links);
        CardView cppl1=findViewById(R.id.cppl1);
        CardView cppl2=findViewById(R.id.cppl2);
        CardView cppl3=findViewById(R.id.cppl3);
        CardView cppl4=findViewById(R.id.cppl4);
        CardView cppl5=findViewById(R.id.cppl5);
        CardView cppl6=findViewById(R.id.cppl6);
        CardView cppl7=findViewById(R.id.cppl7);
        CardView cppl8=findViewById(R.id.cppl8);
        CardView cppl9=findViewById(R.id.cppl9);


        cppl1.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/object-oriented-programming-in-cpp/"));

        cppl2.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/benefits-advantages-of-oop/"));

        cppl3.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cplusplus/cpp_operators.htm"));

        cppl4.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cplusplus/cpp_functions.htm"));

        cppl5.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cplusplus/cpp_classes_objects.htm"));

        cppl6.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cplusplus/cpp_constructor_destructor.htm"));

        cppl7.setOnClickListener(v -> gotoUrl("https://www.guru99.com/cpp-operator-overloading.html"));

        cppl8.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/inheritance-in-c/"));

        cppl9.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/cplusplus/cpp_exceptions_handling.htm#:~:text=C%2B%2B%20exception%20handling%20is%20built,want%20to%20handle%20the%20problem."));

    }

    private void gotoUrl(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}