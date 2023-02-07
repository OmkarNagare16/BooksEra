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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Register extends AppCompatActivity {
EditText mFullName,mEmail,mPassword,mCPassword,mPhone;
Button mRegisterBtn;
TextView mLoginBtn;
FirebaseAuth fAuth;
ProgressBar progressBar;
public static String username;


private GoogleSignInClient mGoogleSignInClient;
private final String TAG="Register";

    private final int RC_SIGN_IN=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        SignInButton signInButton = findViewById(R.id.sign_in);
        fAuth=FirebaseAuth.getInstance();



        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);

        signInButton.setOnClickListener(v -> signIn());

        mFullName=findViewById(R.id.fullName);
        mEmail=findViewById(R.id.Email);
        mPassword=findViewById(R.id.Password);
        mCPassword=findViewById(R.id.Password2);
        mPhone=findViewById(R.id.Phone);
        mRegisterBtn=findViewById(R.id.register_Btn);
        mLoginBtn=findViewById(R.id.createText);

        fAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);
        if(fAuth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(),nav.class));
            finish();
        }

        mRegisterBtn.setOnClickListener(v -> {
            String fname = mFullName.getText().toString().trim();
            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            String confirmPassword = mCPassword.getText().toString().trim();
            String fmobileno =mPhone.getText().toString().trim();


            if (TextUtils.isEmpty(email)) {
                mEmail.setError("Email is Required..");
                return;
            }
            if (TextUtils.isEmpty(password)) {
                mPassword.setError("Password is required..");
                return;
            }

            if (TextUtils.isEmpty(fname)) {
                mFullName.setError("Username is required..");
                return;
            }

            if (TextUtils.isEmpty(fmobileno)) {
                mPhone.setError("Phone Number is required..");
                return;
            }

            if (password.length() < 6) {
                mPassword.setError("Password Must be >=6 Characters..");
                return;
            }

            if (fmobileno.length() != 10) {
                mPhone.setError("Phone Number  Must be 10 digits");
                return;
            }

            if (TextUtils.isEmpty(confirmPassword)) {
                mCPassword.setError("Confirm password..");
            }

            progressBar.setVisibility(View.VISIBLE);
            if (!password.equals(confirmPassword)) {
                mCPassword.setError("Your password do not match with your confirm password..");
            }
            else {
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        username = email;
                        nav.username=username;
                        Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), nav.class));
                    } else {
                        Toast.makeText(Register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }

        });



        mLoginBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),LoginActivity.class)));
    }

    private void signIn()
    {
        Intent signInIntent=mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN)
        {
            Task<GoogleSignInAccount> task =GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult( Task<GoogleSignInAccount> completedTask)
    {
        try {
            GoogleSignInAccount acc=completedTask.getResult(ApiException.class);
            Toast.makeText(Register.this,"Signed in successfully",Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc);
        }
        catch (ApiException e)
        {
            Toast.makeText(Register.this,"Sign In Failed",Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }
    }
    private void FirebaseGoogleAuth(GoogleSignInAccount acct){

        AuthCredential authCredential= GoogleAuthProvider.getCredential(acct.getIdToken(),null);
        fAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(Register.this,"successful",Toast.LENGTH_SHORT).show();
                    FirebaseUser user=fAuth.getCurrentUser();
                    updateUI(user);
                }
                else
                {
                    Toast.makeText(Register.this,"failed",Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }
    private void updateUI(FirebaseUser fuser){



        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (account!=null)
        {
            Intent intent=new Intent(Register.this,nav.class);
            startActivity(intent);
            String personName=account.getDisplayName();
            Toast.makeText(Register.this,personName+" "+" "+"Signed in successfully",Toast.LENGTH_SHORT).show();

        }


    }
}