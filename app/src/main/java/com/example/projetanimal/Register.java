package com.example.projetanimal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    private EditText firstname;
    private EditText lastname;
    private EditText phone;
    private EditText email;
    private EditText password;
    private Button postbtn;

    DatabaseReference AnimalDbRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firstname=findViewById(R.id.userfirstname);
        lastname=findViewById(R.id.userlastname);
        email=findViewById(R.id.useremail);
        phone=findViewById(R.id.userphone);
        password=findViewById(R.id.userpassword);
        postbtn=findViewById(R.id.postbtn);

        AnimalDbRef = FirebaseDatabase.getInstance().getReference().child("Users");
        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Register.this, login.class);
                startActivity(intent);
                insertAnimalData();
            }
        });



    }
    private void insertAnimalData(){
        String regfirstname=firstname.getText().toString();
        String reglastname=lastname.getText().toString();
        String regemail=email.getText().toString();

        String regpassword=password.getText().toString();
        String regphoneString = phone.getText().toString();
        int regphone = Integer.parseInt(regphoneString);


        User users= new User(regfirstname,reglastname,regemail,regpassword,regphone);
        AnimalDbRef.push().setValue(users);
        Toast.makeText(Register.this,"Data Inserted",Toast.LENGTH_SHORT).show();


    }
}
