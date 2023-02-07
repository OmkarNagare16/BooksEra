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

public class OsPdf extends AppCompatActivity {

    String link="", productList="", product="";
    PDFView pdfView;


    // for audiobook
    String phyaudio="https://firebasestorage.googleapis.com/v0/b/todotask-38ff7.appspot.com/o/SY%20Modern%20Operating%20Systems%204th%20Edition%20OS.mp3?alt=media&token=eab0c12b-1032-4b78-90aa-2ceb80c5bdc8";
    String mathsaudio="https://firebasestorage.googleapis.com/v0/b/upload1-d76d8.appspot.com/o/spos-by-dhamdhere.mp3?alt=media&token=39452616-55de-44c5-ae2a-c69a3e8a3784";
    String cmsaudio="https://firebasestorage.googleapis.com/v0/b/upload1-d76d8.appspot.com/o/spos-by-dhamdhere.mp3?alt=media&token=39452616-55de-44c5-ae2a-c69a3e8a3784";
    String ceaudio="https://firebasestorage.googleapis.com/v0/b/upload1-d76d8.appspot.com/o/spos-by-dhamdhere.mp3?alt=media&token=39452616-55de-44c5-ae2a-c69a3e8a3784";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_pdf);

        //audiobook

        JcPlayerView jp2 = findViewById(R.id.jcplayer2);

        ArrayList<JcAudio> ja2 = new ArrayList<>();

        ja2.add(JcAudio.createFromURL("Modern Operating System", phyaudio));
        ja2.add(JcAudio.createFromURL("System Programming & Operating System", mathsaudio));

        jp2.initPlaylist(ja2, null);
        jp2.createNotification(); // default icon

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

            AlertDialog.Builder builder = new AlertDialog.Builder(OsPdf.this);
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
                            Toast.makeText(OsPdf.this,"Go Back TO HomePage!",Toast.LENGTH_SHORT).show();
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
        new OsPdf.RetrievePDFStream().execute(link);
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
            progressDialog = new ProgressDialog(OsPdf.this);
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