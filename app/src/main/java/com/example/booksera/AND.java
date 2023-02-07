package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class AND extends AppCompatActivity {

    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_n_d);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.card_show);
        RelativeLayout relativeLayout = findViewById(R.id.rl);
        relativeLayout.startAnimation(animation);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "Android Brain Friendly Guide\n",
                        60000,
                        "https://firebasestorage.googleapis.com/v0/b/androidpdf-fc452.appspot.com/o/HeadFirstAndroidDevelopmentABrainFriendlyGuide2ndEdition-1.pdf?alt=media&token=c7e89013-8a83-46e8-a6dc-6f9b679efc57"
                ));

        productList.add(
                new Product(
                        1,
                        "Professional Android Application Development Guide \n",
                        60000,
                        "https://firebasestorage.googleapis.com/v0/b/androidpdf-fc452.appspot.com/o/professional_android_4_application_development.pdf?alt=media&token=52c85ab6-2ece-46ec-a000-85c8e74105c6"
                ));


        //creating recyclerview adapter
        ANDProductAdapter adapter = new ANDProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}