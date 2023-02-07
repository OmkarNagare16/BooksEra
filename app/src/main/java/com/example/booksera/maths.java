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

public class maths extends AppCompatActivity {

    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);

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
                        "Engineering Mathematics I\n",
                        60000,
                        "https://firebasestorage.googleapis.com/v0/b/mathspdf-862f0.appspot.com/o/Engineering-Mathematics-I.pdf?alt=media&token=422c9d07-5bb3-4a86-add6-648357633c95"
                ));

        productList.add(
                new Product(
                        1,
                        "Engineering Mathematics \n",
                        60000,
                        "https://firebasestorage.googleapis.com/v0/b/mathspdf-862f0.appspot.com/o/textbook_og_engineering_matematics%20M2.pdf?alt=media&token=7847444e-6e7e-413a-bfad-387ecf1ca94b"
                ));


        //creating recyclerview adapter
        MathProductAdapter adapter = new MathProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}