package com.example.booksera;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {


    EditText mEmail, mPassword;
    Button mLoginBtn;
    TextView mCreateBtn;
    ProgressBar mProgressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mEmail=findViewById(R.id.Email);
        mPassword=findViewById(R.id.Password);
        mProgressBar=findViewById(R.id.progressBar3);
        fAuth=FirebaseAuth.getInstance();
        mLoginBtn=findViewById(R.id.loginBtn);
        mCreateBtn=findViewById(R.id.createText);

        mLoginBtn.setOnClickListener(v -> {

            String email = mEmail.getText().toString().trim();
            String password= mPassword.getText().toString().trim();
            if(TextUtils.isEmpty(email))
            {
                mEmail.setError("Email is Required..");
                return;
            }

            if(TextUtils.isEmpty(password))
            {
                mPassword.setError("Password is required..");
                return;
            }

            if(password.length()<6)
            {
                mPassword.setError("Password Must be >=6 Characters..");
                return;
            }

            mProgressBar.setVisibility(View.VISIBLE);

            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        nav.username=email;
                        Toast.makeText(LoginActivity.this,"Logged in Successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),nav.class));

                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Error.!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        mProgressBar.setVisibility(View.GONE);
                    }
                }
            });
        });


        mCreateBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Register.class)));
    }
}