package com.example.projetanimal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private TextView nUser;
    private View home;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    private EditText email, password;
    private Button log;
    private  Button Signup;
    private String mailA,pws;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.idEmail1);
        password = findViewById(R.id.idPassword1);
        log = findViewById(R.id.idLogin2);
        fAuth = FirebaseAuth.getInstance();

        nUser = findViewById(R.id.Creat);
        Signup=findViewById(R.id.signup);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,Register.class);
                startActivity(intent);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailA =email.getText().toString();
                pws =password.getText().toString();


                if (!mailA.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(mailA).matches()){
                    if (!pws.isEmpty()){
                        fAuth.signInWithEmailAndPassword(mailA, pws)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(login.this, "Login successful. ", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(login.this, MainActivity.class));
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(login.this, "Login Failed. ", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    } else{
                        password.setError("password cannot be empty");
                    }
                } else if(mailA.isEmpty()){
                    email.setError("mail cannot be empty");
                }else{
                    email.setError("please enter valid email");
                }
            }
        });
    }
}