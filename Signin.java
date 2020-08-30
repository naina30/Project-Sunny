package com.example.sunny;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {

    //Initialising the Views
    private EditText pass;
    private Button logIn;
    private EditText emailId;
    private ProgressDialog progressDialog;

    //Firebase declarations
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        pass=(findViewById(R.id.pass));
        emailId=(findViewById(R.id.email));
        logIn=(findViewById(R.id.sign_inBtn));
        progressDialog= new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });


    }

    private void userLogin() { //After typing in
        String userMail, userPass;
        userMail= emailId.getText().toString().trim();
        userPass= pass.getText().toString().trim();

        //Necessary conditions to check
        if(userMail.isEmpty())
        {
            emailId.setError("Email required");
            emailId.requestFocus();
            return;
        }
        if(userPass.isEmpty())
        {
            pass.setError("Password required");
            pass.requestFocus();
            return;
        }
        if(userPass.length()<6)
        {
            pass.setError("Password should not be less than 6 in length");
            pass.requestFocus();
            return;
        }

        //if validations are fine
        progressDialog.setMessage("Signing in");
        progressDialog.show();

        //Do this when the process is complete
        mAuth.signInWithEmailAndPassword(userMail, userPass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    progressDialog.hide();
                    Intent intent=new Intent(Signin.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //So that the user does not come back to the log in activity after pressing the back button
                    startActivity(intent);
                }
                else
                {
                    //Making a toast for the exception
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    progressDialog.hide();
                }

            }
        });
    }
}