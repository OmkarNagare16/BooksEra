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

public class os extends AppCompatActivity {

    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_os );

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
                        "Modern Operating System\n",
                        60000,
                        "https://firebasestorage.googleapis.com/v0/b/todotask-38ff7.appspot.com/o/SY%20Modern%20Operating%20Systems%204th%20Edition%20OS.pdf?alt=media&token=0e5469a2-d1af-4f32-8444-c01881bead28"
                ));

        productList.add(
                new Product(
                        1,
                        "System Programming & Operating System \n",
                        60000,
                        "https://firebasestorage.googleapis.com/v0/b/todotask-38ff7.appspot.com/o/SY%20spos-by-dhamdhere%20OS.pdf?alt=media&token=853de2da-e8cc-4404-9bc1-96086ff39926"
                ));


        //creating recyclerview adapter
        OsProductAdapter adapter = new OsProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}