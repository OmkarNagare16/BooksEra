package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class JSLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_s_links);

        CardView jsl1=findViewById(R.id.jsl1);
        CardView jsl2=findViewById(R.id.jsl2);
        CardView jsl3=findViewById(R.id.jsl3);
        CardView jsl4=findViewById(R.id.jsl4);
        CardView jsl5=findViewById(R.id.jsl5);
        CardView jsl6=findViewById(R.id.jsl6);
        CardView jsl7=findViewById(R.id.jsl7);
        CardView jsl8=findViewById(R.id.jsl8);
        CardView jsl9=findViewById(R.id.jsl9);
        CardView jsl10=findViewById(R.id.jsl10);

        jsl1.setOnClickListener(v -> gotoUrl("https://careerfoundry.com/en/tutorials/web-development-for-beginners/an-introduction-to-javascript/"));

        jsl2.setOnClickListener(v -> gotoUrl("https://javascript.info/array-methods"));

        jsl3.setOnClickListener(v -> gotoUrl("https://www.javascripttutorial.net/javascript-dom/javascript-form/#:~:text=JavaScript%20Form%201%20Form%20basics.%20The%20%3Cform%3E%20element,The%20form%20references%20the%20form.css%20and%20form.js%20files."));

        jsl4.setOnClickListener(v -> gotoUrl("https://www.w3schools.com/js/js_events.asp"));

        jsl5.setOnClickListener(v -> gotoUrl("https://www.codexworld.com/store-data-in-cookies-with-javascript/#:~:text=Store%20Data%20in%20Cookies%20with%20JavaScript%201%20Create,...%207%20Delete%20Cookie.%20...%208%20Conclusion.%20"));

        jsl6.setOnClickListener(v -> gotoUrl("https://www.w3schools.com/js/js_window.asp#:~:text=%20JavaScript%20Window%20-%20The%20Browser%20Object%20Model,browser...%204%20Other%20Window%20Methods.%20%20More%20"));

        jsl7.setOnClickListener(v -> gotoUrl("https://www.w3schools.com/js/js_regexp.asp"));

        jsl8.setOnClickListener(v -> gotoUrl("https://www.w3schools.com/jsref/prop_win_frames.asp"));

        jsl9.setOnClickListener(v -> gotoUrl("https://www.quackit.com/javascript/javascript_status_bar_messages.cfm"));

        jsl10.setOnClickListener(v -> gotoUrl("https://javascript-tutor.net/index.php/lesson-29-creating-slideshow-in-javascript/"));

    }
    private void gotoUrl(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
