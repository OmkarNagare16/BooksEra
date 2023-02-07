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

public class RdbmsPdf extends AppCompatActivity {

    String link="", productList="", product="";
    PDFView pdfView;


    // for audiobook
    String phyaudio="https://www.google.com/url?sa=j&url=https%3A%2F%2Ffirebasestorage.googleapis.com%2Fv0%2Fb%2Fupload1-d76d8.appspot.com%2Fo%2Fspos-by-dhamdhere.mp3%3Falt%3Dmedia%26token%3D39452616-55de-44c5-ae2a-c69a3e8a3784&uct=1564653268&usg=01AwEeAhg_iHBn_xkSVJU28p8QQ.&source=meet";
    String mathsaudio="";
    String cmsaudio="";
    String ceaudio="https://firebasestorage.googleapis.com/v0/b/online-music-player-5376d.appspot.com/o/teach_yourself_c%2B%2B_1_.mp3?alt=media&token=9e798c97-5064-48";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdbms_pdf);

        //audiobook

        JcPlayerView jcPlayerView = findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();

        jcAudios.add(JcAudio.createFromURL("The C++ Programming Language", phyaudio));
        jcAudios.add(JcAudio.createFromURL("Object Oriented Programming in c++ ", mathsaudio));

        jcPlayerView.initPlaylist(jcAudios, null);
        jcPlayerView.createNotification(); // default icon

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

            AlertDialog.Builder builder = new AlertDialog.Builder(RdbmsPdf.this);
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
                            Toast.makeText(RdbmsPdf.this,"Go Back TO HomePage!",Toast.LENGTH_SHORT).show();
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
        new RdbmsPdf.RetrievePDFStream().execute(link);
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
            progressDialog = new ProgressDialog(RdbmsPdf.this);
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