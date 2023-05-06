package com.example.projetanimal;

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
    private EditText name;
    private EditText type;
    private EditText address;
    private EditText phone;
    private EditText age;
    private Button postbtn;

    DatabaseReference AnimalDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        type=findViewById(R.id.type);
        age=findViewById(R.id.age);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);
        postbtn=findViewById(R.id.postbtn);

        AnimalDbRef = FirebaseDatabase.getInstance().getReference().child("Animals");
        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertAnimalData();
            }
        });



    }
    private void insertAnimalData(){
        String rname=name.getText().toString();
        String rtype=type.getText().toString();
        String rage=age.getText().toString();

        String raddress=address.getText().toString();
        String rphoneString = phone.getText().toString();
        int rphone = Integer.parseInt(rphoneString);


        Animal animals=new Animal(rname,rtype,rage,raddress,rphone);
        AnimalDbRef.push().setValue(animals);
        Toast.makeText(Register.this,"Data Inserted",Toast.LENGTH_SHORT).show();


    }
}
