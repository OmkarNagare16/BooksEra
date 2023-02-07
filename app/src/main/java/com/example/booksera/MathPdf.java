package com.example.booksera;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class MathPdf extends AppCompatActivity {

    String link="", productList="", product="";
    PDFView pdfView;


    // for audiobook
    String phyaudio="https://firebasestorage.googleapis.com/v0/b/mathsaudio-f97ee.appspot.com/o/Engineering-Mathematics-I.mp3?alt=media&token=5eabf8f1-a69b-4bae-aa95-a7be4b5c9ddc";
    String mathsaudio="https://firebasestorage.googleapis.com/v0/b/mathsaudio-f97ee.appspot.com/o/textbook_og_engineering_matematics%20M2%20(1)%20(1).mp3?alt=media&token=ee883d45-e02f-4485-8e09-f5ad661f70c0";
    String cmsaudio="https://firebasestorage.googleapis.com/v0/b/online-music-player-5376d.appspot.com/o/cms.mp3?alt=media&token=a0627acc-1d20-458a-8b19-45af51631fcf";
    String ceaudio="https://firebasestorage.googleapis.com/v0/b/online-music-player-5376d.appspot.com/o/ce.mp3?alt=media&token=3e4a0ed2-e2ad-42a9-8e12-9c4e6efa0722";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_pdf);

        //audiobook

        JcPlayerView jp4= findViewById(R.id.jcplayer4);

        ArrayList<JcAudio> ja4 = new ArrayList<>();

        ja4.add(JcAudio.createFromURL("ENGINEERING MATHEMATICS I", phyaudio));
        ja4.add(JcAudio.createFromURL("ENGINEERING MATHEMATICS", mathsaudio));

        jp4.initPlaylist(ja4, null);
        jp4.createNotification(); // default icon

        //for pdf

        product = getIntent().getStringExtra("title");
        productList=getIntent().getStringExtra("productList");
        link=getIntent().getStringExtra("link");
        Objects.requireNonNull ( getSupportActionBar () ).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(productList);
        pdfView=findViewById(R.id.showPdf);

        if (isConnected()) {
            Toast.makeText(getApplicationContext(), "Internet Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(MathPdf.this);
            builder.setTitle("NoInternet Connection Alert")
                    .setMessage("GO to Setting ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MathPdf.this,"Go Back TO HomePage!",Toast.LENGTH_SHORT).show();
                        }
                    });
            //Creating dialog box
            AlertDialog dialog  = builder.create();
            dialog.show();

        }

        Bundle bundle = getIntent().getExtras();
        if (null != bundle) {
            link = getIntent().getStringExtra("link");
        }
        new MathPdf.RetrievePDFStream().execute(link);
    }

    public boolean isConnected() {
        boolean connected = false;

        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return false;
    }


    @SuppressLint("StaticFieldLeak")
    class RetrievePDFStream extends AsyncTask<String, Void, InputStream> {

        ProgressDialog progressDialog;
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(MathPdf.this);
            progressDialog.setTitle("getting the book content...");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

        }
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;

            try {

                URL urlx = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) urlx.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());

                }
            } catch (IOException e) {
                return null;
            }
            return inputStream;

        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
            progressDialog.dismiss();
        }
    }

    @Override public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            onBackPressed();
            return true;
        }
        return false;
    }
}