package com.example.booksera;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Subscription extends AppCompatActivity {

    Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);

        sub = findViewById(R.id.button);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog=new AlertDialog.Builder(Subscription.this);
                dialog.setMessage("BooksEra will be soon coming up with premium option which will provide you some benefits you would like, STAY TUNED..!!!!! ");
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                });

                AlertDialog alertDialog=dialog.create();
                alertDialog.show();

            }
        });

    }
}