package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class JSPLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_s_p_links);
        CardView jspl1=findViewById(R.id.jspl1);
        CardView jspl2=findViewById(R.id.jspl2);
        CardView jspl3=findViewById(R.id.jspl3);
        CardView jspl4=findViewById(R.id.jspl4);
        CardView jspl5=findViewById(R.id.jspl5);
        CardView jspl6=findViewById(R.id.jspl6);
        CardView jspl7=findViewById(R.id.jspl7);
        CardView jspl8=findViewById(R.id.jspl8);
        CardView jspl9=findViewById(R.id.jspl9);
        CardView jspl10=findViewById(R.id.jspl10);
        CardView jspl11=findViewById(R.id.jspl11);
        CardView jspl12=findViewById(R.id.jspl12);
        CardView jspl13=findViewById(R.id.jspl13);
        CardView jspl14=findViewById(R.id.jspl14);
        CardView jspl15=findViewById(R.id.jspl15);

        jspl1.setOnClickListener(v -> gotoUrl("https://careerfoundry.com/en/tutorials/web-development-for-beginners/introduction-to-web-development/"));

        jspl2.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/http-requests"));

        jspl3.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/life-cycle-of-a-servlet"));

        jspl4.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/jsp/jsp_syntax.htm"));

        jspl5.setOnClickListener(v -> gotoUrl("https://data-flair.training/blogs/jsp-syntax-and-semantics/#:~:text=JSP%20Syntax%20and%20Semantics%20This%20JSP%20Tutorial%20deals,additional%20elements%20like%20comments%2C%20implicit%20objects%2C%20custom%20tags"));

        jspl6.setOnClickListener(v -> gotoUrl("https://way2java.com/jsp/what-are-jsp-scriptlet-expression-and-declaration-example/"));

        jspl7.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/requestdispatcher-in-servlet"));

        jspl8.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/servlets/servlets-session-tracking.htm"));

        jspl9.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/jsp/jsp_database_access.htm"));

        jspl10.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/Event-and-Listener-in-Servlet"));

        jspl11.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/servlet-filter"));

        jspl12.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/custom-tags"));

        jspl13.setOnClickListener(v -> gotoUrl("https://www.javatpoint.com/EL-expression-in-jsp"));

        jspl14.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/jsp/jsp_debugging.htm#:~:text=It%20is%20always%20difficult%20testing,likely%20but%20hard%20to%20reproduce."));

        jspl15.setOnClickListener(v -> gotoUrl("https://docs.oracle.com/cd/E13222_01/wls/docs70/webapp/deployment.html"));

    }

    private void gotoUrl(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}